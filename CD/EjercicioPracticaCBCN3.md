# Ejercicio: Pruebas de Software - Sistema de Seguridad de Aeropuerto

## 1. Descripción
En este escenario, trabajarás con la clase `ValidadorSeguridad`. Esta clase se encarga de procesar las puntuaciones de riesgo de los pasajeros y de validar los códigos de las tarjetas de embarque.

---

## 2. Código Base
Copia este código para realizar el análisis de Caja Blanca y Caja Negra:

```java
/**
 * Clase para la gestión de seguridad y validación de embarque.
 */
public class ValidadorSeguridad {

    public ValidadorSeguridad() {}

    /**
     * MÉTODO PARA CAJA BLANCA: Evalúa el nivel de riesgo medio de un grupo.
     * @param riesgos Array con niveles de riesgo (0-100).
     * @return true si el grupo es seguro, false si el riesgo medio supera 50 
     * o si hay algún individuo con riesgo > 80.
     */
    public boolean evaluarRiesgoGrupo(int[] riesgos) {
        if (riesgos == null || riesgos.length == 0) {
            return true;
        }

        double suma = 0;
        boolean alertaIndividual = false;

        for (int i = 0; i < riesgos.length; i++) {
            if (riesgos[i] > 80) {
                alertaIndividual = true;
            }
            suma += riesgos[i];
        }

        double promedio = suma / riesgos.length;

        if (promedio > 50 || alertaIndividual) {
            return false;
        }

        return true;
    }

/**
 * MÉTODO PARA CAJA NEGRA: Validar formato de Tarjeta de Embarque.
 * Requisitos:
 * - Longitud: 10 caracteres.
 * - Inicio: "BORD".
 * - Asiento (posiciones 7-9): dos números y una letra (A-F).
 */
public boolean validarBoardingPass(String code) {
    // 1. Validación de longitud y nulos
    if (code == null || code.length() != 10) {
        return false;
    }
    
    // 2. Validación de prefijo
    if (!code.startsWith("BORD")) {
        return false;
    }

    // Guardamos el atributo asiento para analizarlo
    String asiento = code.substring(7); 

    // 3. Validación de formato de asiento (más sencillo para Caja Negra)
    // Comprobamos que tenga 2 números y una letra de la A a la F
    if (!asiento.matches("[0-9]{2}[A-F]")) {
        return false;
    }

    return true;
}
}

```
## 3. Tareas a realizar

### Tarea 1: Análisis de Caja Blanca (Método `evaluarRiesgoGrupo`)

Este método incluye un bucle y un array, lo que hace el grafo de flujo más interesante.

**Grafo de flujo:**
Dibuja el diagrama. Recuerda que el `for` tiene un nodo de decisión (¿quedan elementos?) y una flecha que vuelve atrás tras el cuerpo del bucle.

**Complejidad Ciclomática:**
Calcúlala mediante las tres fórmulas estándar.

**Caminos independientes:**
Identifica los caminos. Ten en cuenta:
- Array nulo/vacío.
- Entrar en el bucle y no cumplir `riesgos[i] > 80`.
- Entrar en el bucle y cumplir `riesgos[i] > 80`.
- Salir del bucle y que el promedio sea alto.

**Casos de prueba:**
Crea una tabla con entradas de array (ej: `{10, 20}`, `{90, 10}`, `null`) para cubrir los caminos.

---

### Tarea 2: Análisis de Caja Negra (Método `validarBoardingPass`)

Basándote solo en los requisitos:

**Particiones de Equivalencia:**
- Longitud (exactamente 10, menos de 10, más de 10).
- Prefijo (empieza por BORD, no empieza por BORD).
- Asiento (formato correcto, número fuera de rango, letra fuera de A-F).

**Análisis de Valores Límite:**
- Longitud: 9, 10, 11 caracteres.
- Número de asiento: `"00"`, `"01"`, `"99"`, `"100"`.
- Letra de asiento: `"@"`, `"A"`, `"F"`, `"G"`.

**Conjetura de Errores:**
- Cadena `null`.
- Cadena con espacios en blanco.
- Uso de minúsculas (`bord` en lugar de `BORD`).

---

### Tarea 3: Pruebas Unitarias (JUnit)

Crea la clase `ValidadorSeguridadTest`.

**Ejemplo:**
```java
assertTrue(validador.evaluarRiesgoGrupo(new int[]{10, 20}));
