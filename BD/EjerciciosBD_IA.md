# 📘 Ejercicios SQL

---

## 📚 Base de Datos Biblioteca

### 🔹 4.7B
👉 Obtener los códigos y títulos de todos los libros y el número de usuarios distintos que los han solicitado en préstamo.  
➡️ Ordenar por título de la A a la Z.

---

## 📚 Base de Datos Biblioteca

### 🔹 4.8B
👉 Obtener el **ID, nombre y apellidos** de todos los autores y el número total de libros que han escrito.  
➡️ Ordenar de **más a menos obras**.

---

### 🔹 4.9B
👉 Mostrar el **nombre de todas las áreas** y la cantidad de ejemplares que tienen.  
➡️ Deben aparecer incluso las áreas sin ejemplares.  
➡️ Ordenar por **nombre**.

---

### 🔹 4.10B
👉 Obtener el **nombre de todos los departamentos**, su **presupuesto** y el **nombre de su director**.  
➡️ Ordenar por presupuesto de forma **descendente**.

---

### 🔹 4.11B
👉 Visualizar el **código y título de todos los libros**, junto a:  
- su precio original  
- una columna nueva con el **precio rebajado un 15%**

➡️ Ordenar **alfabéticamente**.

---

### 🔹 4.12B
👉 Obtener la lista de todos los usuarios indicando cuántos **préstamos distintos** han realizado.  
➡️ Ordenar por **número de socio**.

---

# 📘 Consultas SQL (Subconsultas y Vistas)

---

## 🔄 Consultas dentro de otras instrucciones

### 🔹 5.12
👉 Dar de alta un nuevo autor llamado **"Lucía García"** sin correo electrónico.  
➡️ Ejecutar la consulta **dos veces**.

---

### 🔹 5.13
👉 Crear una copia de la tabla `libros` llamada **LibrosCaros**  
➡️ Solo con los libros cuyo precio sea **mayor a 40**.

---

### 🔹 5.14
👉 Borrar de la tabla **LibrosCaros** todos los libros de la editorial **"Anaya"**.

---

### 🔹 5.15
👉 Insertar en **LibrosCaros** todos los libros de la tabla original  
➡️ que hayan sido editados en el **año actual**.

---

### 🔹 5.16
👉 Actualizar el presupuesto del departamento con `NumDpto = 10`  
➡️ Igualarlo al **presupuesto medio** de todos los departamentos.

---

### 🔹 5.17
👉 Aumentar en **1 año** la `FechaEdicion` en **LibrosCaros**  
➡️ Solo para libros cuyo precio sea superior al **precio medio de su formato**.

---

## 👁️ Vistas

### 🔹 5.18
👉 Crear la vista **LibrosInformatica**  
➡️ Con libros cuyo `CodLocalizacion` empiece por `'INF'`  
➡️ Usar `WITH CHECK OPTION`

---

### 🔹 5.19
👉 Crear la vista **ResumenPrestamos** que muestre:  
- nombre del usuario  
- título del libro  
- fecha del préstamo  

➡️ Insertar un registro y comprobar el efecto en las tablas originales

---

### 🔹 5.20
👉 Eliminar mediante SQL:  
- la tabla **LibrosCaros**  
- la vista **LibrosInformatica**

---
