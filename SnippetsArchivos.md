# java-io-nio-snippets-netbeans

> Snippets genéricos para NetBeans — POO + Programación estructurada + 1 return + break solo en switch.

---

## Nombre sugerido para los snippets en NetBeans

| Prefix | Descripción |
|---|---|
| `mainmvc` | Main con controlador |
| `menuctrl` | Menú MVC |
| `constio` | Clase constantes |
| `mkfile` | Crear archivo |
| `mkdirio` | Crear directorio |
| `mkdirsio` | Crear subdirectorios |
| `pathnio` | Uso de Path y Files |
| `copyfile` | Copiar archivos |
| `listfile` | Listar archivos |
| `deletefile` | Eliminar archivo |
| `readbyte` | Lectura byte a byte |
| `writeutf` | Escritura UTF-8 |
| `readbuffer` | Lectura con buffer |
| `bufferio` | BufferedReader/Writer |
| `syserr` | System.err |
| `trysql` | Try-with-resources |
| `servicestr` | Clase service |
| `switchclean` | Switch limpio |

---

## MAIN GENÉRICO

```java
public class ${ClassName} {

    public static void main(String[] args) {

        ${ControllerClass} controller;

        controller = new ${ControllerClass}();

        controller.iniciar();

    }
}
```

---

## CONTROLADOR CON MENÚ

```java
import java.util.Scanner;

public class ${ControllerClass} {

    private final Scanner scanner;
    private final ${ServiceClass} service;

    public ${ControllerClass}() {

        scanner = new Scanner(System.in);
        service = new ${ServiceClass}();

    }

    public void iniciar() {

        int opcion;

        do {

            mostrarMenu();

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    service.${metodo1}();
                    break;

                case 2:
                    service.${metodo2}();
                    break;

                case 3:
                    service.${metodo3}();
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (opcion != 0);

    }

    private void mostrarMenu() {

        System.out.println("1. ${opcion1}");
        System.out.println("2. ${opcion2}");
        System.out.println("3. ${opcion3}");
        System.out.println("0. Salir");
        System.out.print("Opción: ");

    }
}
```

---

## CLASE DE CONSTANTES

```java
import java.io.File;

public class ${ClassName} {

    public static final String DIR_RAIZ = "${directorio}";

    public static final String DIR_ANIDADO =
            "${carpeta1}"
            + File.separator
            + "${carpeta2}"
            + File.separator
            + "${carpeta3}";

    public static final String ARCHIVO = "${archivo}.txt";

    private ${ClassName}() {
    }
}
```

---

## CREAR DIRECTORIO

```java
import java.io.File;

public void ${metodo}() {

    File directorio;
    boolean creado;

    directorio = new File(${ClassConstantes}.DIR_RAIZ);

    creado = directorio.mkdir();

    if (creado) {
        System.out.println("Directorio creado");
    }

}
```

---

## CREAR SUBDIRECTORIOS

```java
import java.io.File;

public void ${metodo}() {

    File directorio;
    boolean creado;

    directorio = new File(
            ${ClassConstantes}.DIR_RAIZ,
            ${ClassConstantes}.DIR_ANIDADO
    );

    creado = directorio.mkdirs();

    if (creado) {
        System.out.println("Subdirectorios creados");
    }

}
```

---

## CREAR ARCHIVO

```java
import java.io.File;
import java.io.IOException;

public void ${metodo}() {

    File archivo;
    boolean creado;

    archivo = new File(
            ${ClassConstantes}.DIR_RAIZ,
            ${ClassConstantes}.ARCHIVO
    );

    try {

        creado = archivo.createNewFile();

        if (creado) {
            System.out.println("Archivo creado");
        }

    } catch (IOException e) {
        System.out.println("Error al crear archivo");
    }

}
```

---

## PATH + FILES

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public void ${metodo}() {

    Path ruta;
    Path absoluta;

    ruta = Paths.get(
            ${ClassConstantes}.DIR_RAIZ,
            ${ClassConstantes}.ARCHIVO
    );

    absoluta = ruta.toAbsolutePath();

    System.out.println("Ruta: " + absoluta);

    System.out.println(
            "Padre: "
            + absoluta.getParent()
    );

    System.out.println(
            "Elementos: "
            + absoluta.getNameCount()
    );

    System.out.println(
            "Lectura: "
            + Files.isReadable(ruta)
    );

    System.out.println(
            "Escritura: "
            + Files.isWritable(ruta)
    );

    System.out.println(
            "Es archivo: "
            + Files.isRegularFile(ruta)
    );

}
```

---

## COPIAR ARCHIVO

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public void ${metodo}() {

    Path origen;
    Path destino;

    origen = Paths.get("${origen}.txt");

    destino = Paths.get("${destino}.txt");

    try {

        Files.copy(
                origen,
                destino,
                StandardCopyOption.REPLACE_EXISTING
        );

        System.out.println("Archivo copiado");

    } catch (IOException e) {
        System.out.println("Error al copiar");
    }

}
```

---

## LISTAR ARCHIVOS

```java
import java.io.File;

public void ${metodo}() {

    File directorio;
    File[] contenido;

    directorio = new File(${ClassConstantes}.DIR_RAIZ);

    contenido = directorio.listFiles();

    if (contenido != null) {

        for (File elemento : contenido) {
            System.out.println(elemento.getName());
        }

    }

}
```

---

## ELIMINAR ARCHIVO

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public void ${metodo}() {

    Path ruta;
    boolean eliminado;

    ruta = Paths.get("${archivo}.txt");

    try {

        eliminado = Files.deleteIfExists(ruta);

        if (eliminado) {
            System.out.println("Archivo eliminado");
        }

    } catch (IOException e) {
        System.out.println("Error al eliminar");
    }

}
```

---

## LECTURA BYTE A BYTE

```java
import java.io.IOException;

public void ${metodo}() {

    int dato;
    int contador;
    char caracter;

    contador = 0;

    System.out.println("Introduce texto:");

    try {

        dato = System.in.read();

        while (dato != '\\n') {

            caracter = (char) dato;

            System.out.println(caracter);

            contador++;

            dato = System.in.read();

        }

        System.out.println(
                "Bytes leídos: "
                + contador
        );

    } catch (IOException e) {
        System.out.println("Error de lectura");
    }

}
```

---

## ESCRIBIR UTF-8

```java
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public void ${metodo}(String texto, boolean append) {

    File archivo;

    archivo = new File("${archivo}.txt");

    try (

            OutputStreamWriter writer =
                    new OutputStreamWriter(
                            new FileOutputStream(
                                    archivo,
                                    append
                            ),
                            Charset.forName("UTF-8")
                    )

    ) {

        writer.write(texto);

        writer.write(System.lineSeparator());

        System.out.println("Texto guardado");

    } catch (IOException e) {
        System.out.println("Error al escribir");
    }

}
```

---

## LEER BUFFER + STRINGBUILDER

```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public void ${metodo}() {

    char[] buffer;
    int caracteresLeidos;
    StringBuilder builder;

    buffer = new char[1024];

    builder = new StringBuilder();

    try (

            InputStreamReader reader =
                    new InputStreamReader(
                            new FileInputStream(
                                    "${archivo}.txt"
                            ),
                            Charset.forName("UTF-8")
                    )

    ) {

        caracteresLeidos = reader.read(buffer);

        while (caracteresLeidos != -1) {

            builder.append(
                    buffer,
                    0,
                    caracteresLeidos
            );

            caracteresLeidos = reader.read(buffer);

        }

        System.out.println(builder);

    } catch (IOException e) {
        System.out.println("Error al leer");
    }

}
```

---

## BUFFEREDREADER + BUFFEREDWRITER

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public void ${metodo}(String origen, String destino) {

    String linea;

    try (

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(origen),
                                    Charset.forName("UTF-8")
                            )
                    );

            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(destino),
                                    Charset.forName("UTF-8")
                            )
                    )

    ) {

        linea = reader.readLine();

        while (linea != null) {

            writer.write(linea);

            writer.newLine();

            linea = reader.readLine();

        }

        System.out.println("Copia realizada");

    } catch (FileNotFoundException e) {

        System.out.println("Archivo no encontrado");

    } catch (IOException e) {

        System.out.println("Error de entrada/salida");

    }

}
```

---

## SYSTEM.ERR

```java
import java.io.FileInputStream;
import java.io.IOException;

public void ${metodo}() {

    try {

        FileInputStream file =
                new FileInputStream(
                        "${archivo}.txt"
                );

        file.close();

    } catch (IOException e) {

        System.err.println(
                "ERROR: No se pudo abrir el archivo"
        );

    }

}
```

---

## TRY-WITH-RESOURCES

```java
try (

        ${Recurso} recurso =
                new ${Recurso}(${parametros})

) {

    ${cursor}

} catch (${Exception} e) {

    System.out.println("${mensaje}");

}
```

---

## SERVICE GENÉRICO

```java
public class ${ServiceClass} {

    public void ${metodo1}() {

    }

    public void ${metodo2}() {

    }

    public void ${metodo3}() {

    }

}
```

---

## SWITCH LIMPIO

```java
switch (${variable}) {

    case ${valor1}:
        ${accion1};
        break;

    case ${valor2}:
        ${accion2};
        break;

    case ${valor3}:
        ${accion3};
        break;

    default:
        System.out.println("Opción inválida");
        break;
}
```
