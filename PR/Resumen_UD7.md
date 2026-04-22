# Resumen: Interfaces gráficas de usuario y uso de ficheros en Java

El uso de ficheros permite que la información de los programas perdure y no desaparezca al cerrarlos, superando así la volatilidad de la memoria RAM. Los archivos pueden analizarse desde tres enfoques: lógicamente (registros y campos), operativamente (flujos de datos o *streams*) y físicamente (bits almacenados en un disco).

---

## 1. Rutas y Separadores

**Ruta absoluta:** Especifica el camino completo desde la raíz del sistema hasta el archivo (ej. `C:\Usuarios\...`).

**Ruta relativa:** Indica el camino desde el directorio actual del proyecto, usando:

- `.` para el directorio actual  
- `..` para subir al directorio padre  

**Separador de carpetas:** Para evitar errores entre sistemas operativos (Windows usa `\`, Linux/macOS usan `/`), se debe utilizar `File.separator`, haciendo la ruta independiente del sistema.

---

## 2. Paquete `java.io` y la clase File

Este paquete pertenece a las primeras versiones de Java y utiliza la clase `File` para gestionar entradas y salidas.

### Creación

Para instanciar un objeto se pueden usar constructores pasando la ruta o el directorio padre y el nombre del archivo.

Para crearlos físicamente en disco:

- `createNewFile()`: Crea un archivo nuevo vacío. Lanza excepción si la ruta no existe.
- `mkdir()`: Crea una carpeta, siempre que las carpetas padre ya existan.
- `mkdirs()`: Crea un directorio incluyendo todos los directorios padre que no existan en la ruta.

### Métodos principales

**Comprobación:**

- `exists()`
- `canRead()`
- `canWrite()`
- `isDirectory()`
- `isFile()`

**Información de ruta:**

- `getName()`
- `getAbsolutePath()`
- `getPath()`
- `getParent()`

**Operaciones:**

- `delete()`: Borra el archivo o carpeta vacía
- `renameTo()`: Cambia el nombre
- `listFiles()`: Devuelve un array con el contenido de un directorio

---

## 3. Paquete `java.nio` (NIO.2)

Introducido a partir de Java 8, ofrece herramientas más eficaces para trabajar con rutas y archivos. A diferencia de `java.io`, sus métodos suelen lanzar `IOException` por defecto y son más precisos.

### Interfaz Path

Representa la ruta lógica y sustituye el uso de `new File()`.

Las rutas se obtienen con:

- `Path.of()` (o el antiguo `Paths.get()`)

Permite unir rutas fácilmente con:

- `resolve()`

### Métodos de información

- `getFileName()`: nombre del archivo  
- `toAbsolutePath()`: ruta completa  
- `getRoot()`: raíz del sistema  
- `getNameCount()`: número de niveles  

### Normalización

- `normalize()`: elimina redundancias en la ruta como `.` o `..`

### Clase Files

Contiene métodos estáticos para operar sobre objetos `Path`.

**Creación:**

- `Files.createFile()`: fichero nuevo  
- `Files.createDirectory()`: carpeta simple  
- `Files.createDirectories()`: crea carpeta y padres sin error si ya existen  

**Comprobación y eliminación:**

- `Files.exists()`
- `Files.isReadable()`
- `Files.isRegularFile()`
- `Files.delete()`: lanza excepción si no existe  
- `Files.deleteIfExists()`

---

# Resumen: Lectura y Escritura de Ficheros (Flujos de Datos)

Para lograr que los datos generados por un programa sean persistentes y no desaparezcan al cerrarlo, Java utiliza operaciones de entrada y salida (E/S) apoyadas en el paquete `java.io`.

A continuación se resumen los conceptos y herramientas principales sobre los flujos de datos.

---

## 1. Streams (Flujos de Datos)

Un *stream* o flujo de datos es un objeto que representa una secuencia ordenada de datos entre nuestra aplicación y una fuente o destino externo.

Se clasifican en:

- **InputStream (flujo de entrada):** para leer información hacia el programa.
- **OutputStream (flujo de salida):** para escribir información desde el programa.

---

## 2. Tipos de Flujos

### Flujos de bytes (8 bits)

Se utilizan para leer o escribir ficheros binarios (imágenes, audio, archivos comprimidos, objetos serializados).

- Clases base: `InputStream` y `OutputStream`
- Ejemplos: `FileInputStream`, `FileOutputStream`

---

### Flujos de caracteres (16 bits)

Se utilizan exclusivamente para ficheros de texto (`.txt`, `.html`, `.xml`).

- Trabajan con codificación Unicode (UTF-16), lo que garantiza el correcto manejo de acentos y caracteres especiales.
- Clases base: `Reader` y `Writer`

---

## 3. Flujos Estándar y Scanner

### Flujos estándar

Java incluye flujos básicos por defecto vinculados al sistema:

- `System.in`: entrada del teclado (tipo `InputStream`)
- `System.out`: salida estándar en pantalla (tipo `PrintStream`)
- `System.err`: salida para mensajes de error

---

### Diferencia con `Scanner`

- `System.in` entrega datos byte a byte sin interpretación.
- `Scanner` interpreta ese flujo y lo agrupa mediante delimitadores, convirtiendo los datos en tipos útiles como `int`, `double` o `String`.

---

## 4. Gestión eficiente: try-with-resources

Antes de Java 7, los flujos debían cerrarse manualmente en un bloque `finally`.

Actualmente se utiliza **try-with-resources**, que:

- Cierra automáticamente cualquier recurso que implemente `AutoCloseable`
- Evita fugas de recursos
- Hace el código más limpio y seguro
- Garantiza cierre incluso si ocurre una excepción

---

## 5. Clases para Ficheros de Texto

### FileReader (Reader)

Permite leer caracteres desde un fichero.

Métodos principales:

- `read()`: lectura carácter a carácter
- `read(char[] cbuf)`: lectura en bloque hacia un array

---

### FileWriter (Writer)

Permite escribir texto en un fichero.

Métodos principales:

- `write(String)`: escribe texto
- `flush()`: fuerza la escritura en disco

Constructor importante:

- `append = true`: añade datos al final del archivo sin sobrescribirlo

---

## 6. Optimización mediante Buffers

El acceso directo al disco es lento, por lo que se utilizan buffers (memoria intermedia).

### Clases envoltorio

- `BufferedReader`
- `BufferedWriter`

### Funcionamiento

- Los datos se almacenan en memoria RAM (buffer)
- El acceso al disco se realiza solo cuando hay suficiente información o se fuerza con `flush()`
- Mejora significativamente el rendimiento

Métodos útiles:

- `readLine()`: leer líneas completas
- `newLine()`: escribir salto de línea

---

## 7. Serialización de Objetos

La serialización consiste en convertir un objeto en una secuencia de bytes para almacenarlo en un fichero y poder recuperarlo después.

### Requisitos

- La clase debe implementar `Serializable`
- Clases como `String` o `ArrayList` ya lo implementan

---

### Clases utilizadas

- `ObjectOutputStream`: guarda objetos con `writeObject()`
- `ObjectInputStream`: recupera objetos con `readObject()`

⚠️ Al leer un objeto, es necesario hacer *casting* al tipo correspondiente.
