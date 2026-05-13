# EJERCICIOS U.D. 6 MySQL

*(B.D. Ejercicios)*

---

# PROCEDIMIENTOS

## 1
Crear un procedimiento para añadir un usuario calculando la clave correspondiente y comprobando que el tipo de usuario es válido.

### Parámetros
- DNI
- Nombre
- Apellidos
- Fecha de Nacimiento
- Tipo

### Condiciones
- Fecha de Alta → actual
- Cuota → 0

### Debe devolver
- Nº de usuario
- `-1` si no se insertó

```sql
delimiter $$

drop procedure if exists ejercicio1 $$
create procedure ejercicio1 (midni varchar(9), minombre varchar(20), miapellidos varchar(20), mifechanacimiento datetime,
mitipousuario varchar(2), out salida int)
begin
declare tipo varchar(2);
declare miclave int;

-- comprobar si el tipo de usuario existe

select tipousuario
into tipo
from tiposusuarios
where tipousuario = mitipousuario;

	if tipo is null then
		set salida = -1; -- no existe --> fin
	else -- si existe --> buscar el utlimo usuario e insertar
		select ifnull(max(numsocio),0)
		into miclave
		from usuarios;
		set miclave = miclave+1;

		insert into usuarios values(miclave,midni,minombre,miapellidos,mifechanacimiento,
		mitipousuario,curdate(),0,default);
		set salida = miclave;
	end if;
end
```

---

## 2
Crear un procedimiento que devuelva:
- Nº de ejemplares disponibles
- Nº de ejemplares en préstamo

### Búsqueda
- Por código
- O por título

```sql
delimiter $$

drop procedure if exists ejercicio2 $$
create procedure ejercicio2(
		micodigo varchar(75),
        out disponibles int,
        out prestables int
)
begin
	
		select count(prestable)
        into disponible
        from ejemplares
        where prestable = 0 and CodLocalizacion = micodigo;
        
        select count(prestable)
        into prestado
        from ejemplares
        where prestable = -1 and CodLocalizacion = micodigo;

end
/*
select count(prestable)
        into disponible
        from ejemplares e join libros l
        on e.codlocalizacion = l.codlocalizacion
        where prestable = 0 and titulo like concat("%",mititulo,"%");

select count(prestable)
        into disponible
        from ejemplares e join libros l
        on e.codlocalizacion = l.codlocalizacion
        where prestable = -1 and titulo like concat("%",mititulo,"%");
*/
/*
delimiter $$

drop procedure if exists ejercicio2 $$

create procedure ejercicio2( mitituloOcodigo varchar(75), out disponible int, out prestamo int)
begin
-- Declaramos una variable para guardar el código real del libro
DECLARE v_codigo VARCHAR(6);

-- PASO 1: Comprobamos lo que nos mete el usuario (título o código)
-- y guardamos su código en nuestra variable
SELECT codlocalizacion INTO v_codigo
FROM libros
WHERE titulo like concat("%",mitituloOcodigo,"%") OR codlocalizacion = mitituloOcodigo
LIMIT 1; -- Limit 1 asegura que no dé error si hay más de un resultado

-- PASO 2: Contamos cuántos están disponibles usando ese código
-- (Asumo que tienes una columna 'estado' o similar en la tabla ejemplares)
SELECT COUNT(*)
INTO disponible
FROM ejemplares
WHERE codlocalizacion = v_codigo AND prestable = 0;


-- PASO 3: Contamos cuántos están prestados usando ese código
SELECT COUNT(*)
INTO prestamo
FROM ejemplares
WHERE codlocalizacion = v_codigo AND prestable = -1;

end
*/
```
---

## 3
Procedimiento que cree una tabla nueva `ProfeDepto` con:
- Profesores
  - Código
  - Nombre
  - Apellidos
- Departamentos
  - Número
  - Nombre

### Condición
Asignar un campo clave a la tabla.

```sql
/*delimiter $$
drop procedure if exists ejercicio3 $$
create procedure ejercicio3()
begin
    -- Eliminamos la tabla si ya existe para evitar errores al re-ejecutar
    drop table if exists ProfeDepto;

    -- Creamos la tabla con los datos
    create table ProfeDepto as
    select 
        p.NumSocio as Codigo, 
        u.NombreUsuario as Nombre, 
        u.ApellidosUsuario as Apellidos, 
        d.NumDpto as NumeroDpto, 
        d.NombreDpto
    from profesores p 
    join usuarios u on p.NumSocio = u.NumSocio
    join areas a on p.CodArea = a.CodArea 
    join departamentos d on a.NumDpto = d.NumDpto;

    -- Asignamos la clave primaria al código del profesor
    alter table ProfeDepto add primary key (Codigo);
end $$*/
delimiter $$
drop procedure if exists ejercicio3 $$
create procedure ejercicio3()
begin
	drop table if exists profedepto;
    create table ProfeDepto (primary key(numsocio)) as
    select u.numsocio, u.nombreusuario, u.apellidosusuario,
		d.numdpto, d.nombredpto
    from usuarios u join profesores o join areas a join departamentos d
    on u.NumSocio=p.NumSocio and p.CodArea=a.CodArea and a.numdpto=d.numdpto
    where u.TipoUsuario = 'P'
    ;
end
```

---

## 4
Crear un procedimiento que devuelva:
- Edad
- Antigüedad como socio
- Cuota mensual total

### De
Un usuario concreto.

```sql
delimiter $$
drop procedure if exists ejercicio4 $$
create procedure ejercicio4(
minumsocio int,
out edad int, 
out antig int,
out cuotaTotal decimal(20,4))

begin
	select  year(curdate())-year(fechanacimiento),
			year(curdate())-year(fechaalta),
            cuotamensual + ifnull(cuotaextra,0)
    into edad, antig, cuotatotal
    from usuario
    where numsocio=minumsocio
    ;
end
```

---

## 5
Crear un procedimiento para realizar consultas con múltiples criterios sobre la tabla `Usuarios`.

### Criterios
- DNI `(=)`
- Apellidos `(LIKE)`
- CuotaTotal `(>=)`

---

## 6
Crear un procedimiento `ver_tablas` que muestre:
- Los nombres de las tablas
- De una base de datos pasada como parámetro

### Debe informar si:
- La BD no existe
- Existe pero no tiene tablas

---

# CURSORES

## 1
Utilizando un cursor:
- Actualizar las cuotas extras de los profesores
- Incrementándolas en un porcentaje dado

---

## 2
Realizar un listado de usuarios:
- Organizado por tipos de usuario

---

# FUNCIONES

## 1
Crear una función que devuelva:
- Nombre y apellidos
- Formato:
  ```txt
  apellidos, nombre
  ```

### Parámetro
- Clave del usuario

---

## 2
Crear una función que devuelva:
- Nº de años completos
- Entre una fecha dada y la actual

---

## 3
Crear una función que indique:
- A qué departamento pertenece un profesor

### Debe devolver
- Nombre del departamento
- O:
  ```txt
  No es profesor
  ```

---

# TRIGGERS

## 1
Crear triggers para:
- Poner en mayúsculas:
  - Nombre
  - Apellidos

### Al:
- Insertar
- Modificar usuarios

---

## 2
Crear triggers para:
- Mantener actualizada
- Una copia de la tabla `usuarios`

---

## 3
Crear triggers para:
- Controlar
- Documentar

### Todos los cambios en:
- Tabla `departamentos`

---

## 4
Crear un trigger que impida insertar:
- Libros con menos de 20 páginas
- Libros con más de 1000 páginas