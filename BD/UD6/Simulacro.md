# EXAMEN PRÁCTICO — BASES DE DATOS
## 3.ª Evaluación

### PARTE 1 — Base de datos BIBLIOTECA

#### Ejercicio 1 — Vista `v_socio_presta` (0,5 puntos)
Vista de todos los socios con código, nombre, apellidos y número de préstamos realizados, ordenada de mayor a menor por número de préstamos.

¿Es una vista actualizable?

```sql
  create view v_socio_presta as
    select s.cod, s.nombre, s.apell, count(p.numPrestamo) as X
    from socios s left join prestamos p
    on ...
    order by X desc;
```
    
---

#### Ejercicio 2 — Vista `v_nuevo_socio` (0,5 puntos)
Vista que permita dar de alta nuevos socios comprobando que la provincia sea válida (códigos del '01' al '52') y que el inicio del código postal coincida con la provincia.


```sql
    create view v_nuevo_socio as
    select id, nombre, apellidos,  provincia, poblacion, tel, codPostal
    from socios
    where provincia between '01' and '52'
    left(codPostal,2) = provincia
    with check option
```
---

### PARTE 2 — Base de datos VENTAS_TIENDAS

#### Ejercicio 3 — Función `fn_ventas` (0,5 puntos)
Función que devuelva la cantidad total de artículos vendidos en una tienda dada (que podría no existir).

¿Es determinística?

```sql
    create function fn_ventas(X int)
    deterministic
    return int
    begin
      declare total
        select ifnull(sum(cantidadArt,0))
        from ventas
        where vent_tda = X
      return total
    end
```
---

#### Ejercicio 4 — Procedimiento `act_ventas` (1 punto)
Procedimiento que actualice para todos los clientes la columna `clt_ventas`, contando el número de ventas que hay en la tabla `VENTAS` asociadas al cliente.
```sql
    create procedure act_ventas()
      begin
        update clientes c
        set clt_ventas = 
        (select count(*)
        from ventas v 
        where v.venCli = c.idCli)
      end
```
---

#### Ejercicio 5 — Procedimiento `ventas_fecha` (0,5 puntos)
Procedimiento para listar las ventas entre dos fechas dadas, visualizando número de tienda, fecha, nombre del cliente e importe de la venta.

```sql
  create porcedure ventas_fecha(fechaIni date, fechaFin date)

begin
  select v.numTienda, v.fecha, c.nombreCli, v.importe
  from ventas v join clientes c
  on ...
  where fecha between fechaIni and fechaFin 
end
```
---

#### Ejercicio 6 — Disparadores INSERT / DELETE / UPDATE (1,5 puntos)
Disparadores necesarios para que cada vez que se añada, borre o modifique una venta, se actualice el stock del artículo vendido y la columna `clt_ventas` del cliente correspondiente.

---

#### Ejercicio 7 — Disparador stock negativo (1 punto)
Disparador que impida que el stock quede negativo al añadir una venta. Si el stock sería negativo, enviar el mensaje 'Error: El stock no puede ser negativo'.

---

#### Ejercicio 8 — Evento limpieza ventas antiguas (0,5 puntos)
Evento que elimine a principio de cada año las ventas antiguas (de más de 1 año). Debe ejecutarse durante 4 años y no eliminarse pasado ese periodo.
