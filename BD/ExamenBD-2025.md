# EXAMEN PRÁCTICO — BASES DE DATOS

## 3.ª Evaluación · Soluciones completas

### PARTE 1 — Base de datos BIBLIOTECA

#### Ejercicio 1 — Vista `v_socio_presta` (0,5 puntos)

**Enunciado:**  
Vista de todos los socios con código, nombre, apellidos y número de préstamos realizados, ordenada de mayor a menor por número de préstamos.

**Solución SQL:**

```sql
CREATE OR REPLACE VIEW v_socio_presta AS
SELECT
    s.nsocio,
    s.nombre,
    s.apellidos,
    COUNT(p.nprestamo) AS num_prestamos
FROM SOCIOS s
LEFT JOIN PRESTAMOS p ON s.nsocio = p.nsocio
GROUP BY s.nsocio, s.nombre, s.apellidos
ORDER BY num_prestamos DESC;
```

💡 Se usa `LEFT JOIN` para incluir también los socios sin préstamos (su contador sería 0). Con `INNER JOIN` se perderían esos registros.

**¿Es una vista actualizable?**  
No. Esta vista usa `COUNT()` y `GROUP BY`, lo que la convierte en una vista con agregación. MySQL no permite `INSERT`, `UPDATE` ni `DELETE` sobre vistas que usen funciones de grupo, `DISTINCT`, `UNION` o subconsultas en el `FROM`. Por tanto, esta vista es de solo lectura.

---

#### Ejercicio 2 — Vista `v_nuevo_socio` (0,5 puntos)

**Enunciado:**  
Vista que permita dar de alta nuevos socios comprobando que la provincia sea válida (códigos del `'01'` al `'52'`) y que el inicio del código postal coincida con la provincia.

**Solución SQL:**

```sql
CREATE OR REPLACE VIEW v_nuevo_socio AS
SELECT nsocio, nombre, apellidos, direccion,
       c_postal, poblacion, provincia, telefono
FROM SOCIOS
WHERE provincia BETWEEN '01' AND '52'
  AND LEFT(c_postal, 2) = provincia
WITH CHECK OPTION;
```

💡 `WITH CHECK OPTION` es la clave: obliga a que cualquier `INSERT` o `UPDATE` hecho a través de la vista cumpla las condiciones `WHERE`. Si no se cumple, MySQL rechaza la operación con un error.

💡 `LEFT(c_postal, 2)` extrae los dos primeros dígitos del código postal y los compara con el código de provincia.

---

### PARTE 2 — Base de datos VENTAS_TIENDAS

#### Ejercicio 3 — Función `fn_ventas` (0,5 puntos)

**Enunciado:**  
Función que devuelva la cantidad total de artículos vendidos en una tienda dada (que podría no existir).

**Solución SQL:**

```sql
DELIMITER $$

CREATE FUNCTION fn_ventas(p_tda_num INT)
RETURNS INT
READS SQL DATA
BEGIN
    DECLARE total INT;

    SELECT IFNULL(SUM(ven_cant), 0)
    INTO total
    FROM VENTAS
    WHERE ven_tda = p_tda_num;

    RETURN total;
END$$

DELIMITER ;
```

💡 `IFNULL(SUM(...), 0)`: si la tienda no existe o no tiene ventas, `SUM` devuelve `NULL`. `IFNULL` lo convierte en `0` para devolver un resultado coherente.

**¿Es determinística?**  
No. Una función es determinística si, con los mismos parámetros de entrada, siempre devuelve el mismo resultado. Esta función consulta la tabla `VENTAS`, que puede cambiar con el tiempo, por lo que el mismo número de tienda puede devolver valores distintos en momentos distintos. Por eso se declara `READS SQL DATA` en lugar de `DETERMINISTIC`.

---

#### Ejercicio 4 — Procedimiento `act_ventas` (1 punto)

**Enunciado:**  
Procedimiento que actualice para todos los clientes la columna `clt_ventas`, contando el número de ventas que hay en la tabla `VENTAS` asociadas al cliente.

**Solución SQL:**

```sql
DELIMITER $$

CREATE PROCEDURE act_ventas()
BEGIN
    UPDATE CLIENTES c
    SET clt_ventas = (
        SELECT COUNT(*)
        FROM VENTAS v
        WHERE v.ven_clt = c.clt_num
    );
END$$

DELIMITER ;
```

💡 Subconsulta correlacionada: por cada fila de `CLIENTES`, cuenta cuántas filas de `VENTAS` tienen el mismo número de cliente. El `UPDATE` modifica todos los clientes de una sola vez de forma eficiente.

---

#### Ejercicio 5 — Procedimiento `ventas_fecha` (0,5 puntos)

**Enunciado:**  
Procedimiento para listar las ventas entre dos fechas dadas, visualizando número de tienda, fecha, nombre del cliente e importe de la venta.

**Solución SQL:**

```sql
DELIMITER $$

CREATE PROCEDURE ventas_fecha(
    p_fecha_ini DATE,
    p_fecha_fin DATE
)
BEGIN
    SELECT
        v.ven_tda       AS tienda,
        v.ven_fecha     AS fecha,
        CONCAT(c.clt_nom, ' ', c.clt_apel) AS cliente,
        v.ven_importe   AS importe
    FROM VENTAS v
    JOIN CLIENTES c ON v.ven_clt = c.clt_num
    WHERE v.ven_fecha BETWEEN p_fecha_ini AND p_fecha_fin
    ORDER BY v.ven_fecha;
END$$

DELIMITER ;
```

💡 `BETWEEN` es inclusivo en ambos extremos. `CONCAT` une nombre y apellidos del cliente en una sola columna.

---

#### Ejercicio 6 — Disparadores INSERT / DELETE / UPDATE (1,5 puntos)

**Enunciado:**  
Disparadores necesarios para que cada vez que se añada, borre o modifique una venta, se actualice el stock del artículo vendido y la columna `clt_ventas` del cliente correspondiente.

💡 `NEW` contiene los valores nuevos (tras el cambio). `OLD` contiene los valores anteriores. En `INSERT` solo existe `NEW`; en `DELETE` solo `OLD`; en `UPDATE` existen ambos.

##### AFTER INSERT — al añadir una venta

```sql
DELIMITER $$

CREATE TRIGGER trg_ventas_after_insert
AFTER INSERT ON VENTAS
FOR EACH ROW
BEGIN
    -- Reducir stock del artículo vendido
    UPDATE ARTICULOS
    SET art_stock = art_stock - NEW.ven_cant
    WHERE art_num = NEW.ven_art;

    -- Incrementar el contador de ventas del cliente
    UPDATE CLIENTES
    SET clt_ventas = clt_ventas + 1
    WHERE clt_num = NEW.ven_clt;
END$$

DELIMITER ;
```

##### AFTER DELETE — al borrar una venta

```sql
DELIMITER $$

CREATE TRIGGER trg_ventas_after_delete
AFTER DELETE ON VENTAS
FOR EACH ROW
BEGIN
    -- Devolver el stock del artículo
    UPDATE ARTICULOS
    SET art_stock = art_stock + OLD.ven_cant
    WHERE art_num = OLD.ven_art;

    -- Decrementar el contador de ventas del cliente
    UPDATE CLIENTES
    SET clt_ventas = clt_ventas - 1
    WHERE clt_num = OLD.ven_clt;
END$$

DELIMITER ;
```

##### AFTER UPDATE — al modificar una venta

```sql
DELIMITER $$

CREATE TRIGGER trg_ventas_after_update
AFTER UPDATE ON VENTAS
FOR EACH ROW
BEGIN
    -- Restaurar stock anterior y descontar el nuevo
    UPDATE ARTICULOS
    SET art_stock = art_stock + OLD.ven_cant - NEW.ven_cant
    WHERE art_num = OLD.ven_art;

    -- Si cambió el artículo, ajustar el otro artículo también
    IF OLD.ven_art != NEW.ven_art THEN
        UPDATE ARTICULOS
        SET art_stock = art_stock + OLD.ven_cant
        WHERE art_num = OLD.ven_art;

        UPDATE ARTICULOS
        SET art_stock = art_stock - NEW.ven_cant
        WHERE art_num = NEW.ven_art;
    END IF;

    -- Si cambió el cliente, actualizar ambos contadores
    IF OLD.ven_clt != NEW.ven_clt THEN
        UPDATE CLIENTES SET clt_ventas = clt_ventas - 1
        WHERE clt_num = OLD.ven_clt;

        UPDATE CLIENTES SET clt_ventas = clt_ventas + 1
        WHERE clt_num = NEW.ven_clt;
    END IF;
END$$

DELIMITER ;
```

---

#### Ejercicio 7 — Disparador stock negativo (1 punto)

**Enunciado:**  
Disparador que impida que el stock quede negativo al añadir una venta. Si el stock sería negativo, enviar el mensaje `'Error: El stock no puede ser negativo'`.

**Solución SQL:**

```sql
DELIMITER $$

CREATE TRIGGER trg_check_stock_before_insert
BEFORE INSERT ON VENTAS
FOR EACH ROW
BEGIN
    DECLARE stock_actual INT;

    SELECT art_stock INTO stock_actual
    FROM ARTICULOS
    WHERE art_num = NEW.ven_art;

    IF stock_actual - NEW.ven_cant < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El stock no puede ser negativo';
    END IF;
END$$

DELIMITER ;
```

💡 `BEFORE INSERT`: se ejecuta antes de que el `INSERT` se complete, lo que permite cancelarlo. Con `AFTER INSERT` ya sería demasiado tarde.

💡 `SIGNAL SQLSTATE '45000'`: mecanismo estándar de MySQL para lanzar errores personalizados desde triggers o procedimientos. El mensaje aparecerá en el cliente o aplicación.

---

#### Ejercicio 8 — Evento limpieza ventas antiguas (0,5 puntos)

**Enunciado:**  
Evento que elimine a principio de cada año las ventas antiguas (de más de 1 año). Debe ejecutarse durante 4 años y no eliminarse pasado ese periodo.

**Solución SQL:**

```sql
CREATE EVENT evt_limpiar_ventas
ON SCHEDULE EVERY 1 YEAR
    STARTS '2026-01-01 00:00:00'
    ENDS   '2029-01-01 00:00:00'
ON COMPLETION PRESERVE
DO
    DELETE FROM VENTAS
    WHERE ven_fecha < DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
```

💡 `ON SCHEDULE EVERY 1 YEAR`: se repite cada año (4 ejecuciones: 2026, 2027, 2028, 2029).

💡 `ON COMPLETION PRESERVE`: al terminar el periodo, el evento queda desactivado pero **NO** se elimina. Sin esta cláusula, MySQL lo borraría automáticamente.

💡 `DATE_SUB(CURDATE(), INTERVAL 1 YEAR)`: calcula la fecha de hace exactamente un año y elimina todo lo anterior a esa fecha.

---

Documento generado para estudio · Examen BD 3.ª Evaluación
