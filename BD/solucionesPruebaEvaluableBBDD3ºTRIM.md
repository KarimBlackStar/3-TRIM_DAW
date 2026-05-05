# 🚗 Base de Datos — Taller de Coches (Soluciones)

---

## 🧠 Ejercicios SQL

---

### 🔹 1. Cliente con más vehículos
```sql
SELECT CONCAT(c.Apellido, ", ", c.Nombre) AS cliente, COUNT(*) AS total_vehiculos
FROM Clientes c
JOIN Vehiculos v ON c.IdCliente = v.Cliente
GROUP BY c.IdCliente
ORDER BY total_vehiculos DESC
LIMIT 1;
```

---

### 🔹 2. Empleados y reparaciones terminadas
```sql
SELECT e.*, COUNT(*) AS total_reparaciones
FROM Empleados e
JOIN Asignaciones a ON e.IdEmpleado = a.Empleado
JOIN Reparaciones r ON a.Reparacion = r.IdReparacion
WHERE r.Fec_salida IS NOT NULL
GROUP BY e.IdEmpleado;
```

---

### 🔹 3. Vehículos con más de una reparación
```sql
SELECT v.*, COUNT(*) AS total
FROM Vehiculos v
JOIN Reparaciones r ON v.IdVehiculo = r.Vehiculo
GROUP BY v.IdVehiculo
HAVING COUNT(*) > 1;
```

---

### 🔹 4. Empleado con más reparaciones
```sql
SELECT e.*, COUNT(*) AS total_reparaciones
FROM Empleados e
JOIN Asignaciones a ON e.IdEmpleado = a.Empleado
JOIN Reparaciones r ON a.Reparacion = r.IdReparacion
GROUP BY e.IdEmpleado
ORDER BY total_reparaciones DESC
LIMIT 1;
```

---

### 🔹 5. Año con más reparaciones
```sql
SELECT YEAR(Fec_ingreso) AS año, COUNT(*) AS total
FROM Reparaciones
GROUP BY año
ORDER BY total DESC
LIMIT 1;
```

---

### 🔹 6. Cliente con más reparaciones completadas
```sql
SELECT c.IdCliente, SUM(r.Importe) AS total_importe
FROM Clientes c
JOIN Vehiculos v ON c.IdCliente = v.Cliente
JOIN Reparaciones r ON v.IdVehiculo = r.Vehiculo
WHERE r.Fec_salida IS NOT NULL
GROUP BY c.IdCliente
ORDER BY COUNT(*) DESC
LIMIT 1;
```

---

### 🔹 7. Reparación más costosa
```sql
SELECT c.*, v.*, r.Importe
FROM Clientes c
JOIN Vehiculos v ON c.IdCliente = v.Cliente
JOIN Reparaciones r ON v.IdVehiculo = r.Vehiculo
ORDER BY r.Importe DESC
LIMIT 1;
```

---

### 🔹 8. Clientes sin reparaciones
```sql
SELECT c.*
FROM Clientes c
LEFT JOIN Vehiculos v ON c.IdCliente = v.Cliente
LEFT JOIN Reparaciones r ON v.IdVehiculo = r.Vehiculo
WHERE r.IdReparacion IS NULL;
```

---

### 🔹 9. Empleados con más de 2 reparaciones (sin JOIN)
```sql
SELECT *
FROM Empleados e
WHERE (
  SELECT COUNT(*)
  FROM Asignaciones a
  WHERE a.Empleado = e.IdEmpleado
) > 2;
```

---

### 🔹 10. Reparaciones por especialidad
```sql
SELECT e.Especialidad, COUNT(r.IdReparacion) AS total, AVG(r.Importe) AS media
FROM Empleados e
JOIN Asignaciones a ON e.IdEmpleado = a.Empleado
JOIN Reparaciones r ON a.Reparacion = r.IdReparacion
WHERE r.Fec_salida IS NOT NULL
GROUP BY e.Especialidad;
```

---

### 🔹 11. Vehículos reparados este año (sin JOIN)
```sql
SELECT Marca, Modelo, Año
FROM Vehiculos
WHERE IdVehiculo IN (
  SELECT Vehiculo
  FROM Reparaciones
  WHERE YEAR(Fec_salida) = YEAR(CURDATE())
)
ORDER BY Marca, Modelo;
```

---

### 🔹 12. Vehículos con más de 7 días en reparación (sin JOIN)
```sql
SELECT *
FROM Vehiculos v
WHERE 7 < (
  SELECT MAX(DATEDIFF(Fec_salida, Fec_ingreso))
  FROM Reparaciones r
  WHERE r.Vehiculo = v.IdVehiculo
);
```

---
