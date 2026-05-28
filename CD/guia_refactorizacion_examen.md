# Guía De Refactorización

Java + IntelliJ IDEA

Guía completa para el examen



## 1. Cómo Analizar un Proyecto

Antes de tocar una sola línea de código, realiza este análisis sistemático:



## 1.1 Preguntas obligatorias por clase

Para cada clase del proyecto hazte estas tres preguntas:

¿Qué hace esta clase? Descríbelo en una sola frase. Si necesitas 'y' para describirla, tiene demasiadas responsabilidades.

¿De qué depende? Qué otras clases necesita para funcionar. Más dependencias = más riesgo al refactorizar.

¿Qué se rompería si la cambio? Qué partes del sistema usan esta clase.



## 1.2 Checklist de análisis

Recorre cada clase y apunta lo que encuentres:

Leer Main primero: Entiende el flujo general de la aplicación.

Listar todas las clases: Dibuja un mapa mental con sus relaciones.

Por cada clase anotar: atributos y tipos, métodos y lo que hacen, dependencias.

Buscar código muerto: Métodos con 'no usages' en IntelliJ (aparecen en gris).

Buscar comentarios: Especialmente TODO y comentarios que explican lo obvio.

Medir longitud de métodos: Si un método no cabe en pantalla, es demasiado largo.

Contar niveles de anidamiento: Más de 2 niveles de if/for es una señal de alerta.







## 2. Detectar y Clasificar Code Smells



## 2.1 Tabla completa de smells



## 2.2 Orden de detección recomendado

Sigue este orden para no perderte nada:

Imports grises: Lo primero y más rápido. Elimínalos.

Atributos public: Escanea todos los atributos de las clases de modelo.

Comentarios: Busca comentarios TODO y comentarios que explican lo obvio.

Nombres: Variables de una letra, métodos con nombres vagos.

Magic Numbers: Números literales en condiciones y cálculos.

Métodos largos: Mide visualmente. Si no cabe en pantalla, es largo.

Anidamiento: Cuenta niveles de llaves. Más de 2 es arrow code.

Código duplicado: Busca bloques similares, especialmente en switch/if.

God Class: Cuenta las responsabilidades. Hotel gestionando clientes + habitaciones + reservas = God Class.

Código muerto: Métodos que no se llaman desde ningún sitio.





## 3. Cómo Refactorizar Cada Smell





## 3.1 Eliminar Import muerto

Con IntelliJ:

Coloca el cursor sobre el import en gris.

Pulsa Alt + Enter.

Selecciona 'Remove unused import'.

Manual:

Borra la línea del import directamente.



## 3.2 Eliminar Comentarios redundantes

Con o sin IntelliJ (manual):

Identifica comentarios que explican lo obvio (// incrementamos i, // creamos el objeto).

Borra la línea entera del comentario.

Conserva solo comentarios que explican el PORQUÉ, no el QUÉ.



## 3.3 Eliminar Código muerto

Con IntelliJ:

IntelliJ muestra 'no usages' en gris junto al método.

Haz clic derecho sobre el método → 'Safe Delete'.

IntelliJ verificará que nadie lo usa y lo eliminará.

Manual:

Verifica manualmente con Ctrl+F que nadie llama al método.

Elimina el bloque completo del método.



## 3.4 Renombrar (Nombres poco descriptivos)

Con IntelliJ:

Coloca el cursor sobre la variable o método a renombrar.

En el menú superior ve a Refactor → Rename.

Escribe el nuevo nombre descriptivo.

Pulsa Refactor. IntelliJ actualiza TODAS las referencias automáticamente.

Manual:

Busca con Ctrl+F el nombre actual.

Usa Ctrl+R para reemplazar uno a uno, verificando cada cambio.



## 3.5 Extraer Constante (Magic Numbers)

Con IntelliJ:

Selecciona el número literal (ej: 0.9).

Ve a Refactor → Extract → Constant.

Escribe el nombre de la constante (ej: DESCUENTO_VIP).

Pulsa Refactor. IntelliJ sustituye todas las ocurrencias.

Manual:

Añade al principio de la clase: private static final double DESCUENTO_VIP = 0.9;

Busca con Ctrl+F el número 0.9 en el archivo.

Reemplaza cada ocurrencia por DESCUENTO_VIP.



Resultado esperado:

private static final double DESCUENTO_VIP = 0.9;

private static final double DESCUENTO_ESTANCIA = 0.95;

private static final int DIAS_MINIMOS = 7;



## 3.6 Extraer Método (Long Method)

Con IntelliJ:

Selecciona el bloque de código que quieres extraer.

Ve a Refactor → Extract → Method.

Escribe el nombre del nuevo método.

Pulsa Refactor. IntelliJ crea el método y reemplaza el bloque seleccionado por la llamada.

Manual:

Identifica el bloque con responsabilidad propia.

Crea un método nuevo privado con nombre descriptivo.

Mueve el bloque al nuevo método.

Identifica qué variables necesita el método (serán parámetros) y qué devuelve.

Reemplaza el bloque original por la llamada al nuevo método.





## 3.7 Inline Variable (Variable innecesaria)

Con IntelliJ:

Coloca el cursor sobre la variable que se declara y se devuelve inmediatamente.

Ve a Refactor → Inline Variable.

Selecciona 'Inline all usages, remove the variable'.

Pulsa Refactor.

Manual:

Sustituye la variable por su valor directamente en el return.

Antes:

int resultado = a + b;

return resultado;

Después:

return a + b;



## 3.8 Early Return (Arrow Code / Deep Nesting)

Con IntelliJ:

Coloca el cursor sobre el if más externo.

Pulsa Alt + Enter.

Selecciona 'Invert if condition'.

Elimina el else resultante manualmente si queda.

Repite para cada nivel de anidamiento.

Manual:

Identifica el if más externo del método.

Invierte la condición (cambia isEmpty() por !isEmpty(), etc.).

Mueve el contenido del else antes del if, con return/throw.

Elimina el else.

Repite para el siguiente nivel.



Antes (Arrow Code):

if (!lista.isEmpty()) {

if (cliente != null) {

if (fechaValida) {

// lógica principal

}

}

}



Después (Early Return):

if (lista.isEmpty()) return -4;

if (cliente == null) return -3;

if (!fechaValida) return -2;

// lógica principal



## 3.9 Eliminar Código duplicado

Con IntelliJ:

Selecciona el bloque duplicado.

Ve a Refactor → Extract → Method.

IntelliJ detectará automáticamente otros bloques similares y preguntará si reemplazarlos también.

Acepta y confirma.

Manual:

Identifica los bloques duplicados.

Crea un método con los parámetros que varían entre las copias.

Reemplaza cada bloque duplicado por la llamada al método.



## 3.10 Encapsular atributos públicos

Con IntelliJ:

Haz clic derecho en el nombre de la clase.

Selecciona Refactor → Encapsulate Fields.

Marca los campos que quieres encapsular.

Selecciona visibilidad Private para los campos.

Selecciona visibilidad Public para los accessors.

Desmarca 'Set access' si no necesitas setters.

Pulsa Refactor.

Manual:

Cambia public a private en cada atributo.

Crea un getter para cada atributo:

public String getNombre() { return nombre; }

Corrige los errores de compilación en las clases que accedían directamente.



## 3.11 Cambiar tipo de retorno incorrecto

Manual (no hay herramienta automática):

Cambia la firma del método de boolean a void.

Elimina los return true; del método.

Corrige los if (validar()) que llaman al método eliminando el if.

Antes:

public boolean validarNombre(String nombre) {

if (nombre == null) throw new IllegalArgumentException(...);

return true;

}

Después:

public void validarNombre(String nombre) {

if (nombre == null) throw new IllegalArgumentException(...);

}



## 3.12 Extraer clase (God Class / Single Responsibility)

Con IntelliJ (Extract Delegate):

Haz clic derecho en la clase God Class.

Selecciona Refactor → Extract Delegate.

Escribe el nombre de la nueva clase.

Marca los métodos y atributos que pertenecen a la nueva clase.

Selecciona visibilidad Public.

Pulsa Refactor.

Con IntelliJ (Move Members):

Selecciona los métodos estáticos que quieres mover.

Ve a Refactor → Move.

Escribe el nombre de la clase destino.

Pulsa Refactor.

Manual:

Crea una clase nueva con el nombre apropiado.

Mueve los métodos y atributos correspondientes.

En la clase original, crea un atributo del tipo de la nueva clase.

Actualiza los métodos de la clase original para delegar en la nueva.



## 3.13 Extraer interfaz

Con IntelliJ:

Haz clic derecho en la clase.

Selecciona Refactor → Extract Interface.

Escribe el nombre de la interfaz.

Marca los métodos que quieres en la interfaz.

Pulsa Refactor.

Manual:

Crea el archivo de la interfaz.

Declara los métodos que quieres (sin cuerpo).

En la clase, escribe 'implements NombreInterfaz'.

Asegúrate de que los métodos tienen exactamente la misma firma.





## 4. Crear Jerarquías de Clases



## 4.1 Clase Abstracta

Usa clase abstracta cuando: varias clases comparten comportamiento común Y tienen comportamiento que varía entre ellas.



Paso a paso — Manual

Crear la clase abstracta:



public abstract class Animal {

private String nombre;

// Constructor

public Animal(String nombre) {

this.nombre = nombre;

}

// Método común (implementado aquí)

public String getNombre() { return nombre; }

// Método abstracto (cada subclase lo implementa diferente)

public abstract String hacerSonido();

}



Crear las clases hijas:

public class Perro extends Animal {

public Perro(String nombre) {

super(nombre); // Llama al constructor del padre

}

@Override

public String hacerSonido() {

return "Guau";

}

}



Reglas importantes:

La clase abstracta NO puede instanciarse directamente.

Las subclases DEBEN implementar todos los métodos abstractos.

El constructor de la subclase DEBE llamar a super() como primera línea.

Los métodos no abstractos se heredan tal cual.



Paso a paso — Con IntelliJ (Extract Superclass)

Haz clic derecho en la clase que va a ser subclase.

Selecciona Refactor → Extract Superclass.

Escribe el nombre de la clase abstracta.

Marca los métodos que quieres subir a la clase padre.

Marca 'Make abstract' para los que deben ser abstractos.

Pulsa Refactor.





## 4.2 Interfaz

Usa interfaz cuando: quieres definir un contrato que pueden implementar clases sin relación de herencia.



Paso a paso — Manual

Crear la interfaz:

public interface Validable {

void validar(); // Sin cuerpo, sin modificador de acceso

boolean esValido(); // Todos los métodos son públicos por defecto

}



Implementar en la clase:

public class Cliente implements Validable {

@Override

public void validar() {

if (nombre == null) throw new IllegalArgumentException(...);

}

@Override

public boolean esValido() { return nombre != null; }

}



Reglas importantes:

Una clase puede implementar MÚLTIPLES interfaces (implements A, B, C).

Una clase solo puede heredar de UNA clase abstracta.

Todos los métodos de la interfaz son public abstract por defecto.

Desde Java 8 se pueden tener métodos default con cuerpo en interfaces.



Paso a paso — Con IntelliJ (Extract Interface)

Haz clic derecho en la clase que va a implementar la interfaz.

Selecciona Refactor → Extract Interface.

Escribe el nombre de la interfaz.

Marca los métodos que formarán parte de la interfaz.

Pulsa Refactor.



## 4.3 Detalles importantes para el examen

Diferencias clave:



Patrón Fachada (Facade):

Cuando divides una God Class en gestores, la clase original actúa como Fachada: delega en los gestores sin exponer su implementación interna.

public class Hotel {

private GestorClientes gestorClientes = new GestorClientes();

private GestorReservas gestorReservas = new GestorReservas();

// Hotel solo delega, no expone los gestores

public void registrarCliente(...) { gestorClientes.registrar(...); }

}





## 5. Herramientas de IntelliJ IDEA paso a paso

Todas estas herramientas se encuentran en el menú Refactor de la barra superior, o con clic derecho → Refactor.



## 5.1 Rename (Renombrar)

Para renombrar variables, métodos, clases o parámetros actualizando todas las referencias.

Coloca el cursor sobre el elemento a renombrar.

Ve al menú Refactor → Rename.

En el popup que aparece, escribe el nuevo nombre.

Pulsa Enter para confirmar.

IntelliJ actualiza automáticamente todas las referencias en todo el proyecto.



## 5.2 Extract Method (Extraer Método)

Para extraer un bloque de código a un método independiente.

Selecciona el bloque de código que quieres extraer (clic y arrastra).

Ve al menú Refactor → Extract → Method.

En el diálogo, escribe el nombre del nuevo método.

Revisa los parámetros detectados automáticamente por IntelliJ.

Pulsa Refactor.



## 5.3 Extract Constant (Extraer Constante)

Para convertir un valor literal en una constante con nombre.

Selecciona el valor literal (número o texto).

Ve al menú Refactor → Extract → Constant.

Escribe el nombre de la constante (convención: MAYUSCULAS_CON_GUION).

Elige si la constante es local o de clase.

Pulsa Refactor.



## 5.4 Inline Variable (Eliminar variable innecesaria)

Para eliminar una variable que solo se declara y se devuelve inmediatamente.

Coloca el cursor sobre el nombre de la variable.

Ve al menú Refactor → Inline Variable.

Selecciona 'Inline all usages, remove the variable'.

Pulsa Refactor.



## 5.5 Encapsulate Fields

Para convertir atributos públicos en privados y generar getters/setters.

Haz clic derecho en cualquier parte de la clase.

Selecciona Refactor → Encapsulate Fields.

En el diálogo, marca todos los campos que quieres encapsular.

En 'Encapsulated Fields Visibility' selecciona Private.

En 'Accessors Visibility' selecciona Public.

Desmarca 'Set access' si no necesitas setters.

Pulsa Refactor.



## 5.6 Move Members (Mover métodos estáticos)

Para mover métodos estáticos de una clase a otra (por ejemplo, al extraer un validador).

Coloca el cursor sobre el método estático a mover.

Ve al menú Refactor → Move.

En el campo 'To (fully qualified name)' escribe el nombre completo de la clase destino.

Marca los métodos que quieres mover.

Selecciona la visibilidad Public.

Pulsa Refactor.



## 5.7 Extract Delegate (Extraer Delegado)

Para extraer un conjunto de métodos y atributos a una nueva clase independiente (ideal para God Class).

Haz clic derecho en la clase que quieres dividir.

Selecciona Refactor → Extract Delegate.

Escribe el nombre de la nueva clase.

Marca los métodos y atributos que pertenecen a la nueva clase.

Selecciona visibilidad Public.

Pulsa Refactor.



## 5.8 Extract Superclass (Extraer Clase Padre)

Para crear una clase abstracta a partir de una clase existente.

Haz clic derecho en la clase que va a ser subclase.

Selecciona Refactor → Extract Superclass.

Escribe el nombre de la nueva clase padre.

Marca los métodos que quieres mover al padre.

Marca 'Make abstract' para los métodos que deben ser abstractos.

Pulsa Refactor.



## 5.9 Extract Interface

Para extraer una interfaz a partir de los métodos de una clase.

Haz clic derecho en la clase.

Selecciona Refactor → Extract Interface.

Escribe el nombre de la interfaz.

Marca los métodos que quieres incluir en la interfaz.

Pulsa Refactor.



## 5.10 Invert If (para Early Return)

Para invertir la condición de un if y facilitar el patrón Early Return.

Coloca el cursor sobre la palabra if que quieres invertir.

Pulsa Alt + Enter para abrir el menú de sugerencias.

Selecciona 'Invert if condition'.

Elimina manualmente el else resultante si procede.



## 5.11 Safe Delete (Borrar con seguridad)

Para eliminar métodos o clases verificando que nadie los usa.

Haz clic derecho sobre el método o clase.

Selecciona Refactor → Safe Delete.

IntelliJ comprueba que no hay referencias. Si las hay, te avisa.

Confirma la eliminación.





## 6. Cómo Hacer la Documentación



## 6.1 Estructura del informe

El informe debe tener esta estructura mínima:

Portada: Nombre, actividad, proyecto.

Índice: Con enlaces a cada sección.

Análisis previo: Un apartado por clase con los smells identificados.

Tests (si los hay): Capturas de los tests pasando antes de refactorizar.

Refactorizaciones: Un apartado por cada smell corregido, con captura.

Estructura final: Tabla de clases y sus responsabilidades.

Resumen de técnicas: Tabla con las herramientas usadas.



## 6.2 Cómo hacer las capturas

Para cada refactorización, haz la captura EN EL MOMENTO CLAVE:

Rename: Captura cuando IntelliJ muestra las ocurrencias resaltadas antes de cambiar.

Extract Method: Captura del diálogo antes de pulsar Refactor.

Extract Constant: Captura del popup con el nombre propuesto.

Encapsulate Fields: Captura del diálogo con los campos marcados.

Tests en verde: Captura después de cada grupo de cambios.



## 6.3 Sintaxis Markdown útil

# Título H1

## Subtítulo H2

### Apartado H3

**negrita**

*cursiva*

`código inline`

```java

// bloque de código

```

![texto alternativo](ruta/imagen.png)

| Col1 | Col2 | ← tabla

|------|------|

| dato | dato |





## 7. Consejos Adicionales para el Examen



## 7.1 Orden de trabajo recomendado

Lee todo primero: Antes de tocar nada, lee todas las clases. 5 minutos de lectura ahorran 20 de depuración.

Anota los smells: En papel o en un comentario temporal. No intentes arreglar mientras lees.

Lo seguro primero: Imports muertos, comentarios, renombrar. Son cambios sin riesgo.

Luego los bugs lógicos: Lógica invertida, tipos de retorno incorrectos.

Por último lo estructural: Extract Method, Extract Class, jerarquías.

Tests después de cada grupo: Si tienes tests, córrelos frecuentemente.



## 7.2 Señales de alarma en el código

Método muy largo: Si hay que hacer scroll para verlo entero, es demasiado largo.

Clase con más de 200 líneas: Probable God Class.

Mismo número en varios sitios: Magic Number.

Variable con nombre de una letra: Nombre poco descriptivo.

if dentro de if dentro de if: Arrow Code, aplicar Early Return.

Bloque de código repetido: Código duplicado, extraer método.

Atributos public en clase de modelo: Encapsulación rota.



## 7.3 Cómo deshacer en IntelliJ

Si algo sale mal después de una refactorización automática:

Ctrl + Z: deshace el último cambio.

Ctrl + Shift + Z: rehace un cambio deshecho.

IntelliJ mantiene el historial completo de la sesión.



## 7.4 Verificación final

Antes de entregar, verifica:

No hay imports en gris.

No hay métodos con 'no usages'.

No hay variables de una letra (excepto i, j en bucles).

No hay números literales en cálculos y condiciones.

Todos los atributos de clases de modelo son private.

Los métodos hacen una sola cosa.

El código se puede leer sin necesitar comentarios que expliquen el qué.





## 7.5 Atajos de teclado (referencia rápida)

