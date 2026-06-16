
# 📝 PLANTILLA OFICIAL PARA EXAMEN: CAJA BLANCA Y CAJA NEGRA

---

## 1. PRUEBAS DE CAJA BLANCA (Estructurales)

> **Nota para el examen:** Recuerda calcular primero la Complejidad Ciclomática $V(G) = Aristas - Nodos + 2$ para saber exactamente cuántos caminos independientes mínimos (`C1`, `C2`...) tienes que dibujar y testear.

| Camino e Identificador | Recorrido Detallado (Flujo de Nodos) y Descripción del Camino | Datos de Entrada (Valores Explícitos) | Resultado Esperado (Salida/Efecto) | Resultado Obtenido | ¿Pasa o Falla? |
| :---: | :--- | :--- | :--- | :--- | :---: |
| **C1** | **Nodos:** 1 → 2 → 3 → 5 → 6<br>**Descripción:** Entra en el `if` principal con condiciones correctas y finaliza con éxito. | `variable1 = valor`<br>`variable2 = valor` | Retorna `true` o realiza la acción esperada. | | |
| **C2** | **Nodos:** 1 → 2 → 4 → 6<br>**Descripción:** La condición del `if` es falsa, salta al `else` (o fuera) y termina. | `variable1 = valor_incorrecto` | Lanza excepción / Retorna `false`. | | |
| **C3** | **Nodos:** 1 → 2 → 3 → 2 → 5 → 6<br>**Descripción:** Camino que fuerza al menos una iteración del bucle (`while` / `for`). | `lista = [elem1]` | Procesa el elemento y sale. | | |
| **C4** | **Nodos:** ... | | | | |

---

## 2. PRUEBAS DE CAJA NEGRA (Funcionales)

### A. Identificación de Clases de Equivalencia y Valores Límite
*Analiza cada variable o condición lógica que aparezca en los `if`, `while` o restricciones del problema.*

| CONDICIÓN / VARIABLE | CLASE DE EQUIVALENCIA VÁLIDA (Datos Correctos) | VALOR LÍMITE VÁLIDO (Ejemplo Exacto) | CÓDIGO CV | CLASE DE EQUIVALENCIA NO VÁLIDA (Datos Incorrectos) | VALOR LÍMITE INVÁLIDO (Ejemplo Exacto) | CÓDIGO CNV |
| :--- | :--- | :---: | :---: | :--- | :---: | :---: |
| **Ejemplo:** `edad >= 18` | Personas mayores de edad o igual a 18. | `18` | **CV1** | Personas menores de 18 años. | `17` | **CNV1** |
| **Condición 2:** ... | | | **CV2** | | | **CNV2** |
| **Condición 3:** ... | | | **CV3** | | | **CNV3** |

### B. Diseño de Casos de Prueba (Matriz de Cobertura)
*Regla de oro para el examen: Intenta cubrir el máximo de Clases Válidas juntas en los primeros casos, pero crea **un Caso de Prueba individual por cada Clase No Válida (CNV)** para evitar que un error tape a otro.*

| CASO PRUEBA | CÓDIGOS CUBIERTOS (CV / CNV) | ENTRADA DE VALORES EXPLÍCITOS (Qué introduces) | RESULTADO ESPERADO (Qué debería pasar) | RESULTADO REAL | ESTADO |
| :---: | :--- | :--- | :--- | :--- | :---: |
| **CP1** | CV1, CV2, CV3 | `edad = 20`<br>`param2 = "ok"` | Flujo normal, registro completado con éxito. | | |
| **CP2** | **CNV1**, CV2, CV3 | `edad = 17`<br>`param2 = "ok"` | **Error esperado:** Mensaje "Debes ser mayor de edad". | | |
| **CP3** | CV1, **CNV2**, CV3 | `edad = 20`<br>`param2 = "erróneo"` | **Error esperado:** Mensaje "Parámetro inválido". | | |
| **CP4** | ... | | | | |
