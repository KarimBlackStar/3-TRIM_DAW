# 🚗 Base de Datos — Taller de Coches

---

## 🗄️ Tablas

### 👤 Clientes
```sql
Clientes (IdCliente, Nombre, Apellido, Direccion, Telefono, Correo_e)
```

### 🚙 Vehículos
```sql
Vehiculos (IdVehiculo, Cliente, Marca, Modelo, Año, Num_chasis, Color)
```

### 🔧 Reparaciones
```sql
Reparaciones (IdReparacion, Vehiculo, Descripcion, Fec_ingreso, Fec_salida, Importe)
```
> 💡 `Fec_salida` es `NULL` mientras la reparación está activa

### 👨‍🔧 Empleados
```sql
Empleados (IdEmpleado, Nombre, Apellido, Direccion, Telefono, Correo_e, Especialidad)
```

### 🔗 Asignaciones
```sql
Asignaciones (Reparacion, Empleado)
```

---

## ⚙️ Creación de la BD

```sql
source /ruta_al_archivo/BDTallerCoches.sql;
```

---

## 🧠 Ejercicios SQL

---

### 🔹 1. Cliente con más vehículos
👉 Mostrar el nombre y apellidos del cliente con más vehículos registrados y el número de éstos.

---

### 🔹 2. Empleados y reparaciones terminadas
👉 Obtener los datos de los empleados y la cantidad de reparaciones terminadas que ha realizado cada uno.

---

### 🔹 3. Vehículos con más de una reparación
👉 Listar los datos de los vehículos que tienen o han tenido más de una reparación.

---

### 🔹 4. Empleado con más reparaciones
👉 Obtener los datos del empleado que ha trabajado en más reparaciones y el número de éstas.

---

### 🔹 5. Año con más reparaciones
👉 Obtener el año con más reparaciones realizadas y el número de éstas.

---

### 🔹 6. Cliente con más reparaciones completadas
👉 Obtener la clave del cliente con más reparaciones completadas y el importe total de éstas.

---

### 🔹 7. Reparación más costosa
👉 Obtener los datos del cliente y del vehículo con la reparación más costosa.

---

### 🔹 8. Clientes sin reparaciones
👉 Listar los clientes que no han realizado ninguna reparación.

---

### 🔹 9. Empleados con más de 2 reparaciones (sin JOIN)
👉 Obtener los datos de los empleados que han trabajado en más de 2 reparaciones sin usar JOIN.

---

### 🔹 10. Reparaciones por especialidad
👉 Mostrar el número total de reparaciones completadas y el importe medio por especialidad de empleados.

---

### 🔹 11. Vehículos reparados este año (sin JOIN)
👉 Listar la marca, modelo y año de los vehículos que han finalizado la reparación este año, ordenados por marca y modelo.

---

### 🔹 12. Vehículos con más de 7 días en reparación (sin JOIN)
👉 Mostrar los vehículos que han pasado más de 7 días en reparación sin usar JOIN.

---
