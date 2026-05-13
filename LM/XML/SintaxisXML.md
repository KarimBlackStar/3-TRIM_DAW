# Resumen Completo: Caracteres Especiales y Estructura DTD

Este documento resume la sintaxis y reglas de validación para definiciones de tipo de documento (DTD), basadas en el análisis de `image_551b5f.png` y ejercicios prácticos de clase.

---

## 1. Cuantificadores (Cardinalidad)
Indican cuántas veces puede aparecer un elemento hijo dentro de un padre.

| Símbolo | Frecuencia | Descripción |
| :---: | :--- | :--- |
| `*` | **0 o más** | El elemento es opcional y se puede repetir indefinidamente. |
| `?` | **0 o 1** | El elemento es opcional, pero si aparece, no puede repetirse. |
| `+` | **1 o más** | El elemento es obligatorio y puede repetirse. |
| *(nada)* | **1 exacto** | El elemento es obligatorio y debe aparecer una sola vez. |

## 2. Operadores y Conectores
Definen la relación lógica y el orden entre los elementos.

*   **Coma (`,`)**: Indica **secuencia**. Los elementos deben aparecer en el orden exacto escrito.
    *   *Ejemplo:* `(codigo, descripcion)` -> Primero el código, luego la descripción.
*   **Barra vertical (`|`)**: Indica **elección (OR)**. Se debe elegir uno de los elementos.
    *   *Ejemplo:* `(teclado|raton)` -> O pones un teclado o un ratón.

## 3. Tipos de Datos y Declaraciones
*   **#PCDATA**: Contenido de texto que será procesado (Parsed Character Data).
*   **SYSTEM**: Indica que la DTD se encuentra en un archivo externo.
    *   *Sintaxis:* `<!DOCTYPE raiz SYSTEM "archivo.dtd">`

---

## Análisis del Ejercicio de Productos

Basado en el código:
```xml
<!ELEMENT productos (teclado|raton)*>
<!ELEMENT teclado (codigo,descripcion,peso?)>
<!ELEMENT raton (codigo, descripcion?)>