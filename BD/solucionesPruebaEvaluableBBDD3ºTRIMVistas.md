# 🧾 Examen SQL — Solución Corregida

**APELLIDOS Y NOMBRE:** Nogueira Castaño Ángel

---

## 🗄️ Creación de las BBDD

```sql
source /ruta_al_archivo/biblioteca.sql;
source /ruta_al_archivo/ventas_tiendas.sql;
```

---

# 📚 Base de Datos: Biblioteca

### Tablas:
- LIBROS (nlibro, seccion, titulo, autor, editorial, comentarios)
- SOCIOS (nsocio, nombre, apellidos, direccion, c_postal, poblacion, provincia, telefono)
- PRESTAMOS (nprestamo, nlibro, nsocio, fechapres)

---

## 🔹 1. Vista de socios con nº de préstamos

```sql
CREATE VIEW v_socio_presta AS
SELECT s.nsocio, s.nombre, s.apellidos, COUNT(p.nsocio) AS n_de_prestamos
FROM socios s
JOIN prestamos p ON s.nsocio = p.nsocio
GROUP BY s.nsocio, s.nombre, s.apellidos
ORDER BY n_de_prestamos DESC;
```

### ❓ ¿Es actualizable?
❌ **No es actualizable**, porque:
- Usa `COUNT()` (función de agregación)
- Usa `GROUP BY`

---

## 🔹 2. Vista para nuevos socios

```sql
CREATE VIEW v_nuevo_socio AS
SELECT nsocio, nombre, apellidos, direccion, c_postal, poblacion, provincia, telefono
FROM socios
WHERE provincia BETWEEN '01' AND '52'
AND c_postal LIKE CONCAT(provincia, '%')
WITH CHECK OPTION;
```

---

# 🏪 Base de Datos: ventas_tiendas

### Tablas:
- PROVEEDORES (prv_num, prv_nom)
- ARTICULOS (art_num, art_nom, art_peso, art_col, art_pc, art_pv, art_prv, art_stock)
- CLIENTES (clt_num, clt_apel, clt_nom, clt_pais, clt_pob, clt_ventas)
- TIENDAS (tda_num, tda_pob, tda_ger)
- VENTAS (ven_clt, ven_tda, ven_art, ven_cant, ven_importe, ven_fecha)

---

## 🔹 3. Función: total de artículos vendidos por tienda

```sql
DELIMITER $$

CREATE FUNCTION fn_ventas_tienda(id_tienda INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;

    SELECT IFNULL(SUM(ven_cant), 0)
    INTO total
    FROM ventas
    WHERE ven_tda = id_tienda;

    RETURN total;
END $$

DELIMITER ;
```

### ❓ ¿Es determinística?
❌ **No es realmente determinística**, porque depende de datos de tabla (pueden cambiar).

---

## 🔹 4. Procedimiento: actualizar ventas de clientes

```sql
DELIMITER $$

CREATE PROCEDURE act_ventas()
BEGIN
    UPDATE clientes c
    SET clt_ventas = (
        SELECT COUNT(*)
        FROM ventas v
        WHERE v.ven_clt = c.clt_num
    );
END $$

DELIMITER ;
```

---

## 🔹 5. Procedimiento: ventas entre fechas

```sql
DELIMITER $$

CREATE PROCEDURE ventas_fecha(fecha1 DATE, fecha2 DATE)
BEGIN
    SELECT v.ven_tda, v.ven_fecha, c.clt_nom, v.ven_importe
    FROM ventas v
    JOIN clientes c ON v.ven_clt = c.clt_num
    WHERE v.ven_fecha BETWEEN fecha1 AND fecha2;
END $$

DELIMITER ;
```

---

## 🔹 6. Triggers: actualizar stock y ventas

### ➕ INSERT
```sql
CREATE TRIGGER trg_insert_venta
AFTER INSERT ON ventas
FOR EACH ROW
BEGIN
    UPDATE articulos
    SET art_stock = art_stock - NEW.ven_cant
    WHERE art_num = NEW.ven_art;

    UPDATE clientes
    SET clt_ventas = clt_ventas + 1
    WHERE clt_num = NEW.ven_clt;
END;
```

### ➖ DELETE
```sql
CREATE TRIGGER trg_delete_venta
AFTER DELETE ON ventas
FOR EACH ROW
BEGIN
    UPDATE articulos
    SET art_stock = art_stock + OLD.ven_cant
    WHERE art_num = OLD.ven_art;

    UPDATE clientes
    SET clt_ventas = clt_ventas - 1
    WHERE clt_num = OLD.ven_clt;
END;
```

### 🔄 UPDATE
```sql
CREATE TRIGGER trg_update_venta
AFTER UPDATE ON ventas
FOR EACH ROW
BEGIN
    UPDATE articulos
    SET art_stock = art_stock + OLD.ven_cant - NEW.ven_cant
    WHERE art_num = NEW.ven_art;
END;
```

---

## 🔹 7. Trigger: evitar stock negativo

```sql
DELIMITER $$

CREATE TRIGGER trg_check_stock
BEFORE INSERT ON ventas
FOR EACH ROW
BEGIN
    DECLARE stock_actual INT;

    SELECT art_stock INTO stock_actual
    FROM articulos
    WHERE art_num = NEW.ven_art;

    IF stock_actual < NEW.ven_cant THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El stock no puede ser negativo';
    END IF;
END $$

DELIMITER ;
```

---

## 🔹 8. Evento: eliminar ventas antiguas

```sql
CREATE EVENT elimin_ventas
ON SCHEDULE EVERY 1 YEAR
STARTS CURRENT_TIMESTAMP
ENDS CURRENT_TIMESTAMP + INTERVAL 4 YEAR
DO
DELETE FROM ventas
WHERE ven_fecha < DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
```

---