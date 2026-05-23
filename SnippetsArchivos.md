# java-db-list-file-snippets

> Snippets optimizados para el examen.  
> SOLO lo útil para:
> - Base de datos ya creada
> - Leer datos
> - Pasar datos a `ArrayList`
> - Filtrar datos
> - Operaciones con listas
> - Guardar resultado en archivo
> - POO + programación estructurada
> - 1 return
> - break solo en switch

---

## Prefix recomendados NetBeans

| Prefix | Uso |
|---|---|
| `mainmvc` | Main |
| `menucrud` | Menú |
| `modelclass` | Modelo |
| `dbconn` | Conexión BD |
| `selectlist` | SELECT → ArrayList |
| `filterlist` | Filtrar lista |
| `savefile` | Guardar archivo |
| `switchclean` | Switch limpio |

---

## MAIN

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

## MENÚ MVC

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
                    service.cargarDatos();
                    break;

                case 2:
                    service.filtrarDatos();
                    break;

                case 3:
                    service.guardarArchivo();
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

        System.out.println("1. Cargar datos");
        System.out.println("2. Filtrar datos");
        System.out.println("3. Guardar archivo");
        System.out.println("0. Salir");
        System.out.print("Opción: ");

    }

}
```

---

## MODELO / ENTITY

```java
public class ${ModelClass} {

    private int id;
    private String nombre;
    private int cantidad;

    public ${ModelClass}() {
    }

    public ${ModelClass}(int id, String nombre, int cantidad) {

        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
```

---

## CONEXIÓN BASE DE DATOS

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/${database}";

    private static final String USER = "${user}";
    private static final String PASSWORD = "${password}";

    public Connection conectar() {

        Connection conexion;

        conexion = null;

        try {

            conexion = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (SQLException e) {

            System.out.println("Error conexión BD");

        }

        return conexion;

    }

}
```

---

## SELECT → ARRAYLIST

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ${ServiceClass} {

    private final ArrayList<${ModelClass}> lista;

    public ${ServiceClass}() {

        lista = new ArrayList<>();

    }

    public void cargarDatos() {

        ConexionBD conexionBD;
        Connection conexion;
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        ${ModelClass} objeto;

        conexionBD = new ConexionBD();

        conexion = conexionBD.conectar();

        sql = "SELECT * FROM ${tabla}";

        try {

            ps = conexion.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                objeto = new ${ModelClass}(

                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad")

                );

                lista.add(objeto);

            }

            System.out.println("Datos cargados");

            rs.close();
            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error SELECT");

        }

    }

}
```

---

## FILTRAR LISTA

```java
import java.util.ArrayList;

public void filtrarDatos() {

    ArrayList<${ModelClass}> filtrados;
    int limite;

    filtrados = new ArrayList<>();

    limite = ${numero};

    for (${ModelClass} objeto : lista) {

        if (objeto.getCantidad() >= limite) {

            filtrados.add(objeto);

        }

    }

    for (${ModelClass} objeto : filtrados) {

        System.out.println(
                objeto.getNombre()
                + " - "
                + objeto.getCantidad()
        );

    }

}
```

---

## GUARDAR RESULTADO EN ARCHIVO

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public void guardarArchivo() {

    BufferedWriter writer;

    try {

        writer = new BufferedWriter(
                new FileWriter("${archivo}.txt")
        );

        for (${ModelClass} objeto : lista) {

            writer.write(

                    objeto.getId()
                    + " - "
                    + objeto.getNombre()
                    + " - "
                    + objeto.getCantidad()

            );

            writer.newLine();

        }

        writer.close();

        System.out.println("Archivo guardado");

    } catch (IOException e) {

        System.out.println("Error escritura");

    }

}
```

---

## SWITCH LIMPIO

```java
switch (${variable}) {

    case 1:
        ${accion1};
        break;

    case 2:
        ${accion2};
        break;

    case 3:
        ${accion3};
        break;

    case 0:
        System.out.println("Fin");
        break;

    default:
        System.out.println("Opción inválida");
        break;

}
```

---

## ESTRUCTURA RÁPIDA EXAMEN

```text
src/
│
├── Main.java
│
├── controller/
│   └── MenuController.java
│
├── model/
│   └── ${ModelClass}.java
│
├── service/
│   └── ${ServiceClass}.java
│
└── database/
    └── ConexionBD.java
```

---

## LO MÁS IMPORTANTE PARA EL EXAMEN

### ✔ HACER
- ArrayList
- ResultSet
- PreparedStatement
- foreach
- filtros con if
- BufferedWriter
- MVC simple
- cerrar conexión

### ❌ EVITAR
- lógica en main
- return múltiples
- catch Exception
- SQL quemado por todos lados
- System.exit()
