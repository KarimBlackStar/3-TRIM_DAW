# Guía Rápida de Consulta: Java, Coleccións e Persistencia

---

## 1. Coleccións en Java (`java.util`)

### Interface `Collection<E>` (Herdada de `Iterable<E>`)
Métodos comúns dispoñibles en todas as coleccións:
* `size()`: Devolve o número de elementos.
* `isEmpty()`: Devolve `true` se está baleira.
* `contains(Object element)`: Devolve `true` se o elemento existe na colección.
* `add(E element)`: Engade un elemento.
* `remove(E element)`: Elimina un elemento.
* `clear()`: Baleira a colección por completo.
* `toArray()`: Converte a colección nun array de tipo `Object[]`.
* `iterator()`: Devolve un obxecto `Iterator<E>` para percorrelo.

### I. Conxuntos: `Set<E>` (Non permite duplicados)
> ⚠️ **Requisito crítico**: Os obxectos almacenados nun `HashSet` ou `LinkedHashSet` **deben** ter implementados **`equals()`** e **`hashCode()`** para detectar duplicados.

* **`HashSet<E>`**: Implementación en táboa hash. A máis eficiente, pero non garante ningunha orde. Permite indicar a capacidade inicial no construtor para evitar redimensionamentos automáticos ao acadar o 75%.
* **`LinkedHashSet<E>`**: Mantén os elementos estritamente segundo a súa **orde de inserción**.
* **`TreeSet<E>`**: Almacena os elementos ordenados segundo o seu valor. Os elementos **deben implementar `Comparable`**. É a máis lenta.

### II. Listas: `List<E>` (Elementos identificados por posición/índice)
Métodos específicos de `List` adicionais a `Collection`:
* `add(int index, E element)`: Insire un elemento nunha posición determinada.
* `get(int index)`: Devolve o elemento da posición indicada.
* `indexOf(Object o)` / `lastIndexOf(Object o)`: Primeira/última posición do elemento.
* `remove(int index)`: Elimina e devolve o elemento nesa posición.
* `set(int index, E element)`: Substitúe o elemento na posición indicada.
* `subList(int fromIndex, int toIndex)`: Vista ou "ventá" (non copia) apuntando á lista orixinal.

**Implementacións principais de List:**
* **`ArrayList<E>`**: Baseado nun array dinámico. Acceso rápido por posición. Inserir na posición 0 require mover todos os elementos y é lento.
* **`LinkedList<E>`**: Lista dobremente enlazada. Moi rápida para insercións/eliminacións en extremos. Métodos específicos:
    * `getFirst()` / `getLast()`
    * `addFirst(E e)` / `addLast(E e)`
    * `removeFirst()` / `removeLast()`

### III. Pilas: `Stack<E>` (Estrutura LIFO - Last In, First Out)
Clase que implementa a interface `List`:
* `push(E item)`: Introduce un elemento na pila.
* `pop()`: Obtén e elimina o elemento da cima.
* `peek()`: Obtén o elemento da cima sen eliminalo.
* `empty()`: Comproba se a pila está baleira.
* `search(Object o)`: Devolve a posición baseada en 1 desde a cima (-1 se non existe).

### IV. Mapas: `Map<K, V>` (Pares Clave-Valor)
> ⚠️ **Requisito de clave**: As claves non poden repetirse e requiren que a súa clase teña definidos **`hashCode()`** e **`equals()`**.

* `put(K key, V value)`: Insire un par ou sobrescribe o valor se a clave xa existe.
* `get(K key)`: Obtén o valor asociado ou `null` se a clave non existe.
* `remove(K key)`: Borra o par asociado á clave.
* `containsKey(K key)` / `containsValue(V value)`: Comproban se existe a clave ou o valor.
* `keySet()`: Devolve un `Set<K>` con todas as claves.
* `values()`: Devolve unha `Collection<V>` con todos os valores.
* `entrySet()`: Devolve un `Set<Map.Entry<K,V>>` cos pares clave/valor dispoñibles.

**Implementacións de Map:**
* **`HashMap<K, V>`**: Táboa hash sen ningunha orde. Permite clave `null`. A máis eficiente.
* **`LinkedHashMap<K, V>`**: Mantén estritamente a **orde de inserción** dos pares.
* **`TreeMap<K, V>`**: Estrutura en árbore ordenada ascendentemente pola clave. A clave **debe implementar `Comparable`** e **non permite claves `null`**.

### V. Iteradores: `Iterator<E>` (Percorrido seguro)
Mellor que un *for-each* tradicional se pretendes eliminar elementos durante a iteración para evitar `ConcurrentModificationException`.
* `hasNext()`: Comproba se hai un seguinte elemento.
* `next()`: Obtén o seguinte elemento.
* `remove()`: Elimina o último elemento devolto de forma segura.

---

## 2. Ordenación e Comparación de Obxectos

### Interface `Comparable<T>` (Ordenación Natural)
* **Método:** `int compareTo(T o)`.
* **Funcionamento:** Debe devolver:
    * **Negativo** se `this < o`.
    * **Cero** se `this == o`.
    * **Positivo** se `this > o`.
* *Strings*: Úsase `cadea1.compareTo(cadea2)` (orde lexicográfica).
* *Primitivos numéricos*: Recoméndase o uso do método profesional `Integer.compare(num1, num2)` para evitar erros con números moi grandes.

---

## 3. Xestión de Arquivos e Rutas

### Clase `java.io.File` (Rutas e Metadatos)
* **Construtores:** `File(String ruta)`, `File(String ruta, String nome)`, `File(File dir, String nome)`.
* **Métodos fundamentais:**
    * `createNewFile()`: Crea un arquivo baleiro no disco se non existía (obriga a capturar `IOException`).
    * `mkdir()` / `mkdirs()`: Crea a carpeta final / Crea a ruta completa incluíndo carpetas pai non existentes.
    * `exists()`: Comproba se o arquivo ou directorio existe fisicamente.
    * `delete()`: Borra o arquivo (os directorios deben estar baleiros).
    * `getName()` / `getAbsolutePath()`: Obtén o nome / a ruta absoluta completa.
    * `isDirectory()` / `isFile()`: Comproba se a ruta apunta a un directorio ou a un arquivo común.
    * `listFiles()`: Devolve un array de obxectos `File[]` co contido do directorio.
    * `length()`: Tamaño en bytes.
    * `renameTo(File dest)`: Cambia o nome ou move o ficheiro.

> 💡 **Nota Multiplataforma**: Utiliza **`File.separator`** para concatenar carpetas de xeito dinámico e evitar fallos entre Windows (`\`) e Linux (`/`).

### O moderno de Java 8+: `java.nio.file` (NIO.2)

#### Interface `Path` (A Ruta en Memoria)
Representación lóxica da ruta sen acceder directamente ao disco duro.
* **Instanciación:** `Path.of("ruta")` (ou `Paths.get` en versións anteriores).
* `resolve(String fillo)`: Concatena rutas de forma intelixente.
* `getFileName()`: Nome do arquivo.
* `getParent()` / `getRoot()`: Devolve o camiño pai / a raíz da unidade.
* `toAbsolutePath()`: Transforma unha ruta relativa en absoluta.
* `normalize()`: Limpa redundancias eliminando os elementos `.` e `..` da ruta.
* `getNameCount()`: Número de niveis ou carpetas que compoñen a ruta.

#### Clase `Files` (Operacións directas en Disco co obxecto Path)
* `Files.createFile(Path)`: Crea un arquivo baleiro. Lanza excepción se xa existe.
* `Files.createDirectory(Path)` / `createDirectories(Path)`: Equivalentes modernos de NIO a `mkdir()` e `mkdirs()`.
* `Files.exists(Path)` / `Files.delete(Path)` / `Files.deleteIfExists(Path)`.
* `Files.isReadable(Path)` / `Files.isWritable(Path)`: Comprobación de permisos.
* `Files.isDirectory(Path)` / `Files.isRegularFile(Path)`: Verificación do tipo de arquivo.

---

## 4. Fluxos de Datos (Streams, Lectura e Escritura)

### I. Fluxos de Bytes (Arquivos Binarios, Imaxes, Obxectos Serializados)
Descenden de `InputStream` e `OutputStream`. Traballan a nivel de 8 bits.
* **`FileInputStream`** / **`FileOutputStream`**: Lectura/Escritura básica de bytes en ficheiros.
* **Fluxos estándar predefinidos en `System`:**
    * `System.in`: Fluxo de entrada (normalmente teclado). Tipo `InputStream`. Métodos: `read()` (le un byte), `skip(n)`, `available()`. Comportamento bloqueante e amortecido por buffer de liña do S.O..
    * `System.out`: Fluxo de saída estándar (pantalla). Tipo `PrintStream`. Métodos: `print()`, `println()`, `flush()` (forza o baleirado do búfer de memoria).
    * `System.err`: Fluxo de saída para erros. Tipo `PrintStream`. Normalmente sen buffer intermedio para garantir visibilidade instantánea.

### II. Fluxos de Caracteres (Arquivos de Texto plano .txt, .xml, .html)
Descenden de `Reader` e `Writer`. Procesan unidades de 16 bits para interpretar Unicode (UTF-16) sen erros.
* **`FileReader`** / **`FileWriter`**: Lectura e escritura de texto en ficheiros.
    * *Construtor importante*: `new FileWriter(file, boolean append)`. Se `append = true`, engade texto ao final do arquivo en vez de sobrescribilo.
* **Métodos de Reader:** `read()` (devolve o valor Unicode ou `-1` se chega ao final do arquivo/EOF), `read(char[] cbuf)` (le en bloques dentro dun array), `close()`.
* **Métodos de Writer:** `write(String s)`, `write(char[] buf)`, `flush()`, `close()` (fai un flush automático antes de pechar).

### III. Amortecedores intermedios: Clases `Buffered`
Evitan accesos físicos directos ao disco duro acumulando os datos nun buffer en memoria RAM. Aumentan masivamente a velocidade.
* **`BufferedReader`**: Envolve a un `FileReader`. Engade o método **`readLine()`** que le liñas completas de texto e devolve `null` ao chegar ao final.
* **`BufferedWriter`**: Envolve a un `FileWriter`. Engade o método **`newLine()`** que xera un salto de liña automático.

### IV. Serialización de Obxectos
Garda o estado completo dun obxecto vivo transformándoo nunha secuencia de bytes.
> ⚠️ **Requisito legal**: A clase do obxecto a gardar **debe implementar a interface `Serializable`**.
* **`ObjectOutputStream`**: Método **`writeObject(Object obj)`** para gardar.
* **`ObjectInputStream`**: Método **`readObject()`** para recuperar. *(Precisa casting explícito ao tipo orixinal)*.

---

## 5. Sentenza `try-with-resources` (Control de Recursos Automático)

Introducida en Java 7 para pechar recursos de forma automática.
* **Requisito**: O recurso debe implementar a interface **`AutoCloseable`**.

```java
try (BufferedReader br = new BufferedReader(new FileReader("poesia.txt"))) {
    String linea = br.readLine();
    System.out.println(linea);
} catch (IOException e) {
    System.err.println("Erro de E/S: " + e.getMessage());
} // O recurso PÉCHASE AQUÍ AUTOMATICAMENTE

## 6. Acceso a Bases de Datos con JDBC (`java.sql`)

### I. Compoñentes Estruturais Clave

- **Driver**: Peza de software (`.jar`) que traduce chamadas JDBC ao protocolo nativo da BD.
- **DriverManager**: Establece a canle de conexión co SGBD.
- **Connection**: Representa a sesión activa coa base de datos.
- **Statement**: Obxecto contenedor para enviar comandos SQL estáticos.
- **PreparedStatement**: Sentenza precompilada con marcadores de posición (`?`). Evita *Inyección SQL*.
- **ResultSet**: Contén os datos devueltos por unha consulta `SELECT`.

---

### II. Métodos de Execución de Sentencias SQL (`Statement` / `PreparedStatement`)

- `executeQuery(String sql)`: Exclusivo para consultas `SELECT`. Devolve un obxecto `ResultSet`.
- `executeUpdate(String sql)`: Para sentenzas que modifican datos (`INSERT`, `UPDATE`, `DELETE`). Devolve o `int` co número de filas afectadas.
- `execute(String sql)`: Xenérico. Devolve `true` se o resultado é un `ResultSet` o `false` se devolve un reconto de filas.
- `close()`: Vital para liberar os recursos do servidor.

---

### III. Navegación e Obtención de Datos no `ResultSet`

- `next()`: Avanza o cursor á seguinte fila dispoñible. Devolve `false` se non quedan máis filas. É obrigatorio executalo antes de ler datos.

#### Métodos Getter (`getXXX`)

Recupérase a información especificando o nome da columna (`String`) ou o seu índice numérico (`int`) *(os índices comenzan en 1)*.

```java
getString("nome");
getInt("id");
getDouble("nota");
```

- `getGeneratedKeys()`: Devolve un `ResultSet` que contén a clave primaria `AUTOINCREMENTAL` xerada tras un `INSERT`. *(Precisa o flag `Statement.RETURN_GENERATED_KEYS`)*.

---

### IV. Transaccións e Batch Masivo

- `con.setAutoCommit(false)`: Desactiva o modo por defecto e inicia unha transacción manual.
- `con.commit()`: Confirma definitivamente e asenta no disco todos os cambios realizados dende o inicio da transacción.
- `con.rollback()`: Cancela e revirte absolutamente todas as operacións da transacción actual se algo fallou.
- `pstmt.addBatch()`: Encola a sentencia configurada cun lote de parámetros sen executala aínda.
- `pstmt.executeBatch()`: Envía a cola de sentenzas acumuladas á base de datos nun único viaxe. Devolve un array de enteiros `int[]`.

---

## 7. Text Blocks (Java 15+)

Permite escribir cadeas complexas multilínea de forma limpa sen concatenacións nin escapes interminables.

- Usa tres comillas dobres (`"""`) como delimitador.
- As comillas de apertura deben ir solas na súa liña.
- As comillas de peche deben ir en liña propia e a súa indentación marca o marxe esquerdo.

### Exemplo

```java
String sqlCorrecto = """
        SELECT id, nombre, email 
        FROM usuarios 
        WHERE activo = true
        """;
```
