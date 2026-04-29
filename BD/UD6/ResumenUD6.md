# Guía Técnica: Programación de Bases de Datos en MySQL

## Resumen Ejecutivo
La implementación de programas almacenados en MySQL (procedimientos, funciones, disparadores y eventos) permite centralizar la lógica de negocio en el servidor. Esto optimiza el rendimiento al reducir el tráfico de red y robustece la seguridad al impedir el acceso directo de los usuarios a las tablas. La programación se basa en bloques de instrucciones, variables y estructuras de control de flujo, siendo esencial el manejo de cursores y la gestión de excepciones para construir aplicaciones robustas.

---

## 1. Fundamentos y Ventajas
Un programa almacenado es un conjunto de instrucciones SQL con nombre que se ejecutan en el servidor.

| Ventaja | Descripción |
| :--- | :--- |
| **Seguridad y Robustez** | Limita el acceso directo a las tablas y evita manipulaciones accidentales. |
| **Mantenimiento Centralizado** | Interfaz común para todas las aplicaciones cliente; facilita actualizaciones. |
| **Portabilidad** | La lógica reside en la base de datos, independientemente de la interfaz cliente. |
| **Eficiencia de Red** | Reduce el tráfico al enviar solo los datos necesarios entre cliente y servidor. |
| **Integración Nativa** | Ejecuta sentencias SQL sin necesidad de conectores externos (ODBC/JDBC). |

---

## 2. Tipos de Programas Almacenados
1.  **Procedimientos Almacenados:** Resuelven problemas específicos. Admiten parámetros de entrada (IN), salida (OUT) y mixtos (INOUT). Se ejecutan con `CALL`.
2.  **Funciones Almacenadas:** Devuelven un único valor. Pueden ser invocadas directamente dentro de sentencias SQL (ej. en un `SELECT`).
3.  **Triggers (Disparadores):** Se ejecutan automáticamente ante un suceso (INSERT, UPDATE o DELETE).
4.  **Eventos:** Tareas programadas para ejecutarse en momentos específicos.

---

## 3. Elementos del Lenguaje y Control de Flujo
### Variables y Sintaxis
* **Delimitadores:** Es necesario cambiar el delimitador (ej. `DELIMITER $$`) para que el servidor identifique el fin del bloque.
* **Variables Locales:** Se declaran con `DECLARE` al inicio de los bloques.
* **Variables de Usuario:** Se identifican con el prefijo `@` (ej. `@mi_variable`). Tienen alcance de sesión.
* **Parámetros:** `IN` (paso por valor), `OUT` (paso por variable, sale como NULL) e `INOUT` (paso por variable con valor inicial).

### Control de Flujo
* **Condicionales:** `IF ... THEN ... ELSE` y `CASE`.
* **Bucles:**
    * `LOOP`: Ejecución continua hasta un `LEAVE`.
    * `REPEAT ... UNTIL`: Se ejecuta al menos una vez; condición al final.
    * `WHILE`: Se ejecuta mientras la condición sea cierta; evaluación previa.
    * `ITERATE`: Reinicia el bucle desde el principio.

---

## 4. Gestión de Datos Avanzada
* **Cursores:** Permiten recorrer resultados de varias filas una a una. Ciclo: `DECLARE` -> `OPEN` -> `FETCH` -> `CLOSE`. Requieren gestionar el error `NOT FOUND`.
* **SQL Dinámico:** Permite construir instrucciones en tiempo de ejecución mediante `PREPARE`, `EXECUTE` (con `USING`) y `DEALLOCATE PREPARE`. *Atención: Riesgo de inyección SQL.*

---

## 5. Manejo de Errores y Excepciones
Se definen mediante **Handlers** (manejadores):
* **CONTINUE:** Ejecuta una acción y sigue con la siguiente línea.
* **EXIT:** Ejecuta una acción y finaliza el bloque actual.

**Identificación del error:** Por código MySQL, código SQLSTATE o condiciones con nombre (`CONDITION FOR`).

---

## 6. Administración y Diccionario de Datos
Requiere privilegios como `CREATE ROUTINE`, `ALTER ROUTINE` y `EXECUTE`.

| Comando / Tabla | Propósito |
| :--- | :--- |
| `SHOW PROCEDURE STATUS` | Lista procedimientos y características generales. |
| `SHOW CREATE PROCEDURE [nombre]` | Muestra el código fuente del objeto. |
| `INFORMATION_SCHEMA.ROUTINES` | Vista del diccionario con información exhaustiva. |

**Modificación:** `ALTER` solo cambia metadatos. Para cambiar la lógica, es necesario usar `DROP` (borrar) y `CREATE` (volver a crear).