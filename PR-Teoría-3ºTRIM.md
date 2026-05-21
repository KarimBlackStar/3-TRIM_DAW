# Guía Rápida de Consulta: Java, Colecciones y Persistencia

---

## 1. Colecciones en Java (`java.util`)

### Interface `Collection<E>` (Heredada de `Iterable<E>`)
Métodos comunes disponibles en todas las colecciones:

* `size()`: Devuelve el número de elementos.
* `isEmpty()`: Devuelve `true` si está vacía.
* `contains(Object element)`: Devuelve `true` si el elemento existe en la colección.
* `add(E element)`: Añade un elemento.
* `remove(E element)`: Elimina un elemento.
* `clear()`: Vacía la colección por completo.
* `toArray()`: Convierte la colección en un array de tipo `Object[]`.
* `iterator()`: Devuelve un objeto `Iterator<E>` para recorrerla.

### I. Conjuntos: `Set<E>` (No permite duplicados)

> ⚠️ **Requisito crítico**: Los objetos almacenados en un `HashSet` o `LinkedHashSet` **deben** tener implementados **`equals()`** y **`hashCode()`** para detectar duplicados.

* **`HashSet<E>`**: Implementación en tabla hash. La más eficiente, pero no garantiza ningún orden. Permite indicar la capacidad inicial en el constructor para evitar redimensionamientos automáticos al alcanzar el 75%.
* **`LinkedHashSet<E>`**: Mantiene los elementos estrictamente según su **orden de inserción**.
* **`TreeSet<E>`**: Almacena los elementos ordenados según su valor. Los elementos **deben implementar `Comparable`**. Es la más lenta.

### II. Listas: `List<E>` (Elementos identificados por posición/índice)

Métodos específicos de `List` adicionales a `Collection`:

* `add(int index, E element)`: Inserta un elemento en una posición determinada.
* `get(int index)`: Devuelve el elemento de la posición indicada.
* `indexOf(Object o)` / `lastIndexOf(Object o)`: Primera/última posición del elemento.
* `remove(int index)`: Elimina y devuelve el elemento en esa posición.
* `set(int index, E element)`: Sustituye el elemento en la posición indicada.
* `subList(int fromIndex, int toIndex)`: Vista o "ventana" (no copia) apuntando a la lista original.

**Implementaciones principales de List:**

* **`ArrayList<E>`**: Basado en un array dinámico. Acceso rápido por posición. Insertar en la posición 0 requiere mover todos los elementos y es lento.
* **`LinkedList<E>`**: Lista doblemente enlazada. Muy rápida para inserciones/eliminaciones en extremos. Métodos específicos:
    * `getFirst()` / `getLast()`
    * `addFirst(E e)` / `addLast(E e)`
    * `removeFirst()` / `removeLast()`

### III. Pilas: `Stack<E>` (Estructura LIFO - Last In, First Out)

Clase que implementa la interface `List`:

* `push(E item)`: Introduce un elemento en la pila.
* `pop()`: Obtiene y elimina el elemento de la cima.
* `peek()`: Obtiene el elemento de la cima sin eliminarlo.
* `empty()`: Comprueba si la pila está vacía.
* `search(Object o)`: Devuelve la posición basada en 1 desde la cima (-1 si no existe).

### IV. Mapas: `Map<K, V>` (Pares Clave-Valor)

> ⚠️ **Requisito de clave**: Las claves no pueden repetirse y requieren que su clase tenga definidos **`hashCode()`** y **`equals()`**.

* `put(K key, V value)`: Inserta un par o sobrescribe el valor si la clave ya existe.
* `get(K key)`: Obtiene el valor asociado o `null` si la clave no existe.
* `remove(K key)`: Borra el par asociado a la clave.
* `containsKey(K key)` / `containsValue(V value)`: Comprueban si existe la clave o el valor.
* `keySet()`: Devuelve un `Set<K>` con todas las claves.
* `values()`: Devuelve una `Collection<V>` con todos los valores.
* `entrySet()`: Devuelve un `Set<Map.Entry<K,V>>` con los pares clave/valor disponibles.

**Implementaciones de Map:**

* **`HashMap<K, V>`**: Tabla hash sin ningún orden. Permite clave `null`. La más eficiente.
* **`LinkedHashMap<K, V>`**: Mantiene estrictamente el **orden de inserción** de los pares.
* **`TreeMap<K, V>`**: Estructura en árbol ordenada ascendentemente por la clave. La clave **debe implementar `Comparable`** y **no permite claves `null`**.

### V. Iteradores: `Iterator<E>` (Recorrido seguro)

Mejor que un *for-each* tradicional si pretendes eliminar elementos durante la iteración para evitar `ConcurrentModificationException`.

* `hasNext()`: Comprueba si hay un siguiente elemento.
* `next()`: Obtiene el siguiente elemento.
* `remove()`: Elimina el último elemento devuelto de forma segura.

---

## 2. Ordenación y Comparación de Objetos

### Interface `Comparable<T>` (Ordenación Natural)

* **Método:** `int compareTo(T o)`.
* **Funcionamiento:** Debe devolver:
    * **Negativo** si `this < o`.
    * **Cero** si `this == o`.
    * **Positivo** si `this > o`.

* *Strings*: Se usa `cadena1.compareTo(cadena2)` (orden lexicográfico).
* *Primitivos numéricos*: Se recomienda el uso del método profesional `Integer.compare(num1, num2)` para evitar errores con números muy grandes.

---

## 3. Gestión de Archivos y Rutas

### Clase `java.io.File` (Rutas y Metadatos)

* **Constructores:** `File(String ruta)`, `File(String ruta, String nombre)`, `File(File dir, String nombre)`.

* **Métodos fundamentales:**
    * `createNewFile()`: Crea un archivo vacío en disco si no existía (obliga a capturar `IOException`).
    * `mkdir()` / `mkdirs()`: Crea la carpeta final / Crea la ruta completa incluyendo carpetas padre no existentes.
    * `exists()`: Comprueba si el archivo o directorio existe físicamente.
    * `delete()`: Borra el archivo (los directorios deben estar vacíos).
    * `getName()` / `getAbsolutePath()`: Obtiene el nombre / la ruta absoluta completa.
    * `isDirectory()` / `isFile()`: Comprueba si la ruta apunta a un directorio o a un archivo común.
    * `listFiles()`: Devuelve un array de objetos `File[]` con el contenido del directorio.
    * `length()`: Tamaño en bytes.
    * `renameTo(File dest)`: Cambia el nombre o mueve el fichero.

> 💡 **Nota Multiplataforma**: Utiliza **`File.separator`** para concatenar carpetas de forma dinámica y evitar fallos entre Windows (`\`) y Linux (`/`).

### Lo moderno de Java 8+: `java.nio.file` (NIO.2)

#### Interface `Path` (La Ruta en Memoria)

Representación lógica de la ruta sin acceder directamente al disco duro.

* **Instanciación:** `Path.of("ruta")` (o `Paths.get` en versiones anteriores).
* `resolve(String hijo)`: Concatena rutas de forma inteligente.
* `getFileName()`: Nombre del archivo.
* `getParent()` / `getRoot()`: Devuelve la ruta padre / la raíz de la unidad.
* `toAbsolutePath()`: Transforma una ruta relativa en absoluta.
* `normalize()`: Limpia redundancias eliminando los elementos `.` y `..` de la ruta.
* `getNameCount()`: Número de niveles o carpetas que componen la ruta.

#### Clase `Files` (Operaciones directas en Disco con el objeto Path)

* `Files.createFile(Path)`: Crea un archivo vacío. Lanza excepción si ya existe.
* `Files.createDirectory(Path)` / `createDirectories(Path)`: Equivalentes modernos de NIO a `mkdir()` y `mkdirs()`.
* `Files.exists(Path)` / `Files.delete(Path)` / `Files.deleteIfExists(Path)`.
* `Files.isReadable(Path)` / `Files.isWritable(Path)`: Comprobación de permisos.
* `Files.isDirectory(Path)` / `Files.isRegularFile(Path)`: Verificación del tipo de archivo.

---

## 4. Flujos de Datos (Streams, Lectura y Escritura)

### I. Flujos de Bytes (Archivos Binarios, Imágenes, Objetos Serializados)

Descienden de `InputStream` y `OutputStream`. Trabajan a nivel de 8 bits.

* **`FileInputStream`** / **`FileOutputStream`**: Lectura/Escritura básica de bytes en ficheros.

* **Flujos estándar predefinidos en `System`:**
    * `System.in`: Flujo de entrada (normalmente teclado). Tipo `InputStream`. Métodos: `read()` (lee un byte), `skip(n)`, `available()`. Comportamiento bloqueante y amortiguado por buffer de línea del S.O.
    * `System.out`: Flujo de salida estándar (pantalla). Tipo `PrintStream`. Métodos: `print()`, `println()`, `flush()` (fuerza el vaciado del búfer de memoria).
    * `System.err`: Flujo de salida para errores. Tipo `PrintStream`. Normalmente sin buffer intermedio para garantizar visibilidad instantánea.

### II. Flujos de Caracteres (Archivos de Texto plano .txt, .xml, .html)

Descienden de `Reader` y `Writer`. Procesan unidades de 16 bits para interpretar Unicode (UTF-16) sin errores.

* **`FileReader`** / **`FileWriter`**: Lectura y escritura de texto en ficheros.
    * *Constructor importante*: `new FileWriter(file, boolean append)`. Si `append = true`, añade texto al final del archivo en vez de sobrescribirlo.

* **Métodos de Reader:** `read()` (devuelve el valor Unicode o `-1` si llega al final del archivo/EOF), `read(char[] cbuf)` (lee en bloques dentro de un array), `close()`.

* **Métodos de Writer:** `write(String s)`, `write(char[] buf)`, `flush()`, `close()` (realiza un flush automático antes de cerrar).

### III. Amortiguadores intermedios: Clases `Buffered`

Evitan accesos físicos directos al disco duro acumulando los datos en un buffer en memoria RAM. Aumentan masivamente la velocidad.

* **`BufferedReader`**: Envuelve a un `FileReader`. Añade el método **`readLine()`** que lee líneas completas de texto y devuelve `null` al llegar al final.
* **`BufferedWriter`**: Envuelve a un `FileWriter`. Añade el método **`newLine()`** que genera un salto de línea automático.

### IV. Serialización de Objetos

Guarda el estado completo de un objeto vivo transformándolo en una secuencia de bytes.

> ⚠️ **Requisito legal**: La clase del objeto a guardar **debe implementar la interface `Serializable`**.

* **`ObjectOutputStream`**: Método **`writeObject(Object obj)`** para guardar.
* **`ObjectInputStream`**: Método **`readObject()`** para recuperar. *(Requiere casting explícito al tipo original)*.

---

## 5. Sentencia `try-with-resources` (Control de Recursos Automático)

Introducida en Java 7 para cerrar recursos de forma automática.

* **Requisito**: El recurso debe implementar la interface **`AutoCloseable`**.

```java
try (BufferedReader br = new BufferedReader(new FileReader("poesia.txt"))) {
    String linea = br.readLine();
    System.out.println(linea);
} catch (IOException e) {
    System.err.println("Error de E/S: " + e.getMessage());
} // EL RECURSO SE CIERRA AQUÍ AUTOMÁTICAMENTE
```

## 6. Acceso a Bases de Datos con JDBC (`java.sql`)

### I. Componentes Estructurales Clave

- **Driver**: Pieza de software (`.jar`) que traduce llamadas JDBC al protocolo nativo de la BD.
- **DriverManager**: Establece el canal de conexión con el SGBD.
- **Connection**: Representa la sesión activa con la base de datos.
- **Statement**: Objeto contenedor para enviar comandos SQL estáticos.
- **PreparedStatement**: Sentencia precompilada con marcadores de posición (`?`). Evita *Inyección SQL*.
- **ResultSet**: Contiene los datos devueltos por una consulta `SELECT`.

---

### II. Métodos de Ejecución de Sentencias SQL (`Statement` / `PreparedStatement`)

- `executeQuery(String sql)`: Exclusivo para consultas `SELECT`. Devuelve un objeto `ResultSet`.
- `executeUpdate(String sql)`: Para sentencias que modifican datos (`INSERT`, `UPDATE`, `DELETE`). Devuelve el `int` con el número de filas afectadas.
- `execute(String sql)`: Genérico. Devuelve `true` si el resultado es un `ResultSet` o `false` si devuelve un recuento de filas.
- `close()`: Vital para liberar los recursos del servidor.

---

### III. Navegación y Obtención de Datos en el `ResultSet`

- `next()`: Avanza el cursor a la siguiente fila disponible. Devuelve `false` si no quedan más filas. Es obligatorio ejecutarlo antes de leer datos.

#### Métodos Getter (`getXXX`)

Se recupera la información especificando el nombre de la columna (`String`) o su índice numérico (`int`) *(los índices comienzan en 1)*.

```java
getString("nombre");
getInt("id");
getDouble("nota");
```

- `getGeneratedKeys()`: Devuelve un `ResultSet` que contiene la clave primaria `AUTOINCREMENTAL` generada tras un `INSERT`. *(Requiere el flag `Statement.RETURN_GENERATED_KEYS`)*.

---

### IV. Transacciones y Batch Masivo

- `con.setAutoCommit(false)`: Desactiva el modo por defecto e inicia una transacción manual.
- `con.commit()`: Confirma definitivamente y guarda en disco todos los cambios realizados desde el inicio de la transacción.
- `con.rollback()`: Cancela y revierte absolutamente todas las operaciones de la transacción actual si algo falló.
- `pstmt.addBatch()`: Encola la sentencia configurada con un lote de parámetros sin ejecutarla todavía.
- `pstmt.executeBatch()`: Envía la cola de sentencias acumuladas a la base de datos en un único viaje. Devuelve un array de enteros `int[]`.

---

## 7. Text Blocks (Java 15+)

Permite escribir cadenas complejas multilínea de forma limpia sin concatenaciones ni escapes interminables.

- Usa tres comillas dobles (`"""`) como delimitador.
- Las comillas de apertura deben ir solas en su línea.
- Las comillas de cierre deben ir en línea propia y su indentación marca el margen izquierdo.

### Ejemplo

```java
String sqlCorrecto = """
        SELECT id, nombre, email 
        FROM usuarios 
        WHERE activo = true
        """;
```
