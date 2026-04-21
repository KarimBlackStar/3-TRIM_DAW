# Ejercicio: Pruebas de Caja Blanca y Caja Negra (Simplificado)

## 1. Descripción

En esta tarea trabajaremos con una clase Java llamada `GestorEventos`. Esta clase se encarga de gestionar la lógica de precios y el registro de asistentes para un evento cultural. Deberás aplicar técnicas de análisis de software para asegurar que el código funciona correctamente.

## 2. Código Base

Copia este código en tu entorno de desarrollo para analizarlo:

```java
/**
 * Clase que gestiona la venta y registro para un evento.
 */
public class GestorEventos {

    public GestorEventos() {}

    /**
     * MÉTODO PARA CAJA BLANCA: Calcular precio final con descuentos.
     */
    public double aplicarDescuento(double precioBase, int edad, boolean tieneCupon) {
        if (precioBase <= 0) {
            return 0.0;
        }
        
        double descuento = 0.0;
        
        if (edad >= 65) {
            descuento = 0.30; // 30% descuento jubilados
        } else if (edad <= 12) {
            descuento = 0.50; // 50% descuento niños
        }

        if (tieneCupon) {
            descuento += 0.10; // 10% extra por cupón
        }

        return precioBase - (precioBase * descuento);
    }

    /**
     * MÉTODO PARA CAJA NEGRA: Validar registro de asistente.
     */
    public boolean registrarAsistente(String dni, int edad) {
        // Edad permitida: entre 18 y 100 años
        if (edad < 18 || edad > 100) {
            return false;
        }
        // El DNI debe tener 9 caracteres y terminar en letra mayúscula
        if (dni == null || dni.length() != 9) {
            return false;
        }
        if (!dni.substring(8).matches("[A-Z]")) {
            return false;
        }
        return true;
    }
}
```
## 3. Tareas a realizar

### Tarea 1: Análisis de Caja Blanca (Método `aplicarDescuento`)
Realiza un análisis exhaustivo del flujo del código. En tu documento de respuesta debes incluir:
* **Grafo de flujo:** Dibuja el diagrama de nodos y aristas del método.
* **Complejidad Ciclomática:** Calcúlala usando las 3 fórmulas:
    * $V(G) = Aristas - Nodos + 2$
    * $V(G) = Regiones + 1$
    * $V(G) = Nodos\_Predicado + 1$
* **Caminos independientes:** Identifica todos los recorridos posibles.
* **Casos de prueba:** Diseña una tabla con los valores de entrada (`precioBase`, `edad`, `tieneCupon`) necesarios para cubrir cada camino.

### Tarea 2: Análisis de Caja Negra (Método `registrarAsistente`)
Sin mirar la implementación interna, diseña las pruebas basadas en los requisitos:
* **Particiones de Equivalencia:** Identifica clases válidas e inválidas para `edad` y `dni`.
* **Análisis de Valores Límite:** Indica qué valores específicos usarías para probar los límites de la edad (ej. 17, 18, 100, 101).
* **Conjetura de Errores:** Lista al menos 2 casos de prueba adicionales basados en errores comunes (ej. DNI vacío, nulo o con caracteres especiales).

### Tarea 3: Pruebas Unitarias (JUnit)
Crea una clase de prueba `GestorEventosTest` e implementa los casos de prueba de caja blanca diseñados en la Tarea 1. Asegúrate de que todos los tests pasen (Barra verde).

> **Nota de desarrollo:** Para este ejercicio básico con tipos primitivos (`double`, `boolean`), bastará con las aserciones estándar de JUnit como `assertEquals`. Si en futuras ampliaciones de la clase necesitas comparar objetos complejos, recuerda que puedes usar tus plantillas `mhash` y `mequals` en tu IDE para generar rápidamente el *method hash* y el *method equals*.

---

## 4. Guía de Verificación (Cómo comprobar tu trabajo)
Para asegurar que tu análisis es correcto, verifica lo siguiente:
* **En el Grafo:** Recuerda que el `else if` cuenta como una bifurcación adicional.
* **En la Complejidad:** Si calculas $V(G)$ y te da un número concreto (por ejemplo, 4), debes ser capaz de encontrar exactamente esa misma cantidad de caminos independientes. Si no coinciden, revisa el grafo.
* **En JUnit:** Usa `assertEquals(valorEsperado, valorObtenido, 0.001)` para comparar los resultados de tipo `double`, ya que los decimales pueden tener pequeñas variaciones de precisión.
* **En Caja Negra:** Asegúrate de que el DNI falle si tiene 8 o 10 caracteres, y que la letra final sea validada estrictamente como mayúscula.