# EJERCICIOS U.D. 6 MySQL

(B.D. Ejercicios)

---

## Procedimientos

1. Crear un procedimiento para añadir un usuario calculando la clave correspondiente y comprobando que el tipo de usuario es válido.  
   - Parámetros: DNI, Nombre, Apellidos, Fecha de Nacimiento y Tipo  
   - Fecha de Alta: actual  
   - Cuota: 0  
   - Debe devolver el nº de usuario o -1 si no se insertó  

2. Crear un procedimiento que devuelva el número de ejemplares disponibles y en préstamo de un libro (búsqueda por código o por título).

3. Procedimiento que cree una tabla nueva **ProfeDepto** con:
   - Profesores (Código, Nombre, Apellidos)
   - Departamentos (Número y Nombre)
   - Asignar clave primaria  

4. Crear un procedimiento que devuelva:
   - Edad de un usuario  
   - Antigüedad como socio  
   - Cuota mensual total  

5. Crear un procedimiento para consultas con múltiples criterios sobre la tabla **Usuarios**:
   - DNI (=)  
   - Apellidos (LIKE)  
   - CuotaTotal (>=)  

6. Crear un procedimiento (**ver_tablas**) que muestre los nombres de las tablas de una base de datos pasada como parámetro.  
   - Informar si:
     - No existe la base de datos  
     - Existe pero no tiene tablas  

---

## Cursores

1. Usando un cursor, actualizar las cuotas extras de los profesores incrementándolas en un porcentaje dado.

2. Realizar un listado de usuarios organizado por tipos de usuario:

| Tipo de Usuario | Usuarios |
|-----------------|----------|
|                 |          |
|                 |          |
|                 |          |

---

## Funciones

1. Crear una función que devuelva:
   - Nombre y apellidos (apellidos, nombre)  
   - A partir de la clave de usuario  

2. Crear una función que devuelva:
   - Número de años completos entre una fecha dada y la actual  

3. Crear una función que indique:
   - Departamento de un profesor  
   - Devuelve:
     - Nombre del departamento  
     - O "No es profesor"  

---

## Triggers

1. Crear triggers para:
   - Poner en mayúsculas nombre y apellidos al insertar o modificar  

2. Crear triggers para:
   - Mantener una copia actualizada de la tabla usuarios  

3. Crear triggers para:
   - Controlar y registrar cambios en la tabla departamentos  

4. Crear un trigger que:
   - Impida insertar libros con:
     - Menos de 20 páginas  
     - Más de 1000 páginas  