# 📄 EJERCICIOS DE SQL (5B)

Realiza los ejercicios en línea de comandos de MySQL, con el prompt personalizado (`mysql> prompt miusuario>;`).  
Haz capturas de pantalla de cada instrucción.

---

# 🗄️ Base de Datos: biblioteca

## Tabla: libros

Información de los libros de la biblioteca.

| Columna      | Tipo | Tamaño | Clave | Nulos | Observaciones |
|--------------|------|--------|-------|-------|---------------|
| nlibro       | Núm  |        | P     | No    | Nº de libro. Autoincremental |
| seccion      | Alf. | 2      |       | Sí    | Códigos de sección o materia |
| titulo       | Alf. | 30     |       | No    | Título del libro |
| autor        | Alf. | 30     |       | Sí    | Autor |
| editorial    | Alf. | 30     |       | Sí    | Editorial del libro |
| comentarios  | Alf. | 60     |       | Sí    | Comentarios sobre el libro |

---

## Tabla: socios

Información de los lectores.

| Columna     | Tipo | Tamaño | Clave | Nulos | Observaciones |
|-------------|------|--------|-------|-------|---------------|
| nsocio      | Núm  |        | P     | No    | Nº de socio. Autoincremental |
| nombre      | Alf. | 15     |       | No    | |
| apellidos   | Alf. | 25     |       | No    | |
| direccion   | Alf. | 25     |       | Sí    | |
| c_postal    | Alf. | 3      |       | Sí    | |
| poblacion   | Alf. | 20     |       | Sí    | |
| provincia   | Alf. | 2      | F     | Sí    | Referencia a provincias |
| telefono    | Alf. | 7      |       | Sí    | |

---

## Tabla: prestamos

Información de los préstamos realizados.

| Columna    | Tipo | Tamaño | Clave | Nulos | Observaciones |
|------------|------|--------|-------|-------|---------------|
| nprestamo  | Núm  |        | P     | No    | Nº de préstamo. Autoincremental |
| nlibro     | Núm  |        | F     | No    | Referencia a libros |
| nsocio     | Núm  |        | F     | No    | Referencia a socios |
| fechapres  | Date |        |       | No    | |

---

## Tabla: provincias

Información de provincias.

| Columna   | Tipo | Tamaño | Clave | Nulos | Observaciones |
|-----------|------|--------|-------|-------|---------------|
| codigop   | Alf. | 2      | P     | No    | Código de provincia |
| nombrep   | Alf. | 20     |       | No    | |
| prefijo   | Alf. | 3      |       | No    | Prefijo telefónico |

---

# Ejercicios

## 1️⃣ Vista v_lugo

Crear una vista con el nombre, apellidos y población de socios de la provincia de Lugo.

![alt text](image.png)
---

## 2️⃣ Vista v_prestamos

Crear una vista con:

- Nombre y apellidos del socio
- Provincia del socio
- Número del libro
- Título y autor

```sql
create view v_prestamos as
select nombre, apellidos, nombrep, l.nlibro, titulo, autor
from socios s join provincias p join prestamos pr join libros l 
on s.provincia=p.codigop
and s.nsocio=pr.nsocio
and pr.nlibro=l.nlibro
;
```

📌 Preguntas:

- ¿Se puede insertar datos desde esta vista?
- ¿Por qué?
- Compruébalo

Solo en 1 , no se pueden insertar en varias tablas a la vez.
No puedo dar de alta un préstamo ni la provincia(la provincia no tiene la clave autoincrement), pero por separado sí puedo dar de alta un socio o un libro.

---

## 3️⃣ Vista v_top3

Crear una vista con:

- Título
- Autor
- Editorial
- Comentarios

```sql
create view v_top3 as
select titulo, autor, editorial, comentarios, count(p.nlibro) as veces
from libros l join prestamos p
on l.nlibro=p.nlibro
group by l.nlibro
order by veces desc
limit 3
;
```

Solo los **3 libros más prestados**, ordenados por número de préstamos.

📌 Preguntas:

- ¿Se puede insertar datos desde esta vista?
- ¿Por qué?
- Compruébalo

Tiene una función de grupo(```count, avg, sum,etc...```), entonces NO puedes actualizable(```insert into```).

---

## 4️⃣ Estructura de vista

- Visualiza la estructura de la vista anterior
- ¿Cómo se puede ver el código SQL de creación?

```sql
describe v_top3;
```

---

## 5️⃣ Vista v_gusta

Mostrar libros prestados más de una vez por el mismo socio:

- Nombre del socio
- Título del libro
- Editorial

```sql
create view v_gusta as
select s.nombre, l.titulo, l.editorial, count(*)
from libros l join prestamos p join socios s
on s.nsocio=p.nsocio and p.nlibro=l.nlibro
/*Agrupo para que tanto el nombre del socio como del libro no se repitan*/
group by   p.nsocio, p.nlibro
having count(*) > 1
;
```

---

## 6️⃣ Vista v_altasocios

Permitir alta de socios con condiciones:

- Provincia gallega: 15, 27, 32, 36
- Código postal no nulo
  
```sql
create view v_altasocios as
select * 
from socios
where provincia in ("15","27","32","36") and c_postal is not null
with check option; 
```

📌 Realiza pruebas de inserción

---

## 7️⃣ Eliminar vista v_lugo

Eliminar la vista sin error si no existe:

```sql
DROP VIEW IF EXISTS v_lugo;
```
