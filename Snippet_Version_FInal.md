# java-exam-snippets

> Snippets finales optimizados para examen DAW  
> MVC + Base de Datos + ArrayList + Filtros + Archivos  
> Preparados para NetBeans con `${}`

---

## PREFIX RECOMENDADOS

| Prefix | Uso |
|---|---|
| `mainmvc` | Main |
| `menucrud` | Menú |
| `modelclass` | Modelo |
| `dbconn` | Conexión BD |
| `selectlist` | SELECT → ArrayList |
| `insertdao` | INSERT |
| `updatedao` | UPDATE |
| `deletedao` | DELETE |
| `findid` | Buscar ID |
| `filternum` | Filtrar número |
| `filtertext` | Filtrar texto |
| `savefile` | Guardar archivo |
| `switchclean` | Switch |

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
                    service.agregar();
                    break;

                case 3:
                    service.modificar();
                    break;

                case 4:
                    service.borrar();
                    break;

                case 5:
                    service.filtrar();
                    break;

                case 6:
                    service.guardarArchivo();
                    break;

                case 0:
                    System.out.println("Fin");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;

            }

        } while (opcion != 0);

    }

    private void mostrarMenu() {

        System.out.println("1. Cargar datos");
        System.out.println("2. Agregar");
        System.out.println("3. Modificar");
        System.out.println("4. Borrar");
        System.out.println("5. Filtrar");
        System.out.println("6. Guardar archivo");
        System.out.println("0. Salir");

        System.out.print("Opción: ");

    }

}
```

---

## MODELO / ENTITY

```java
public class ${Entidad} {

    private int id;
    private String nombre;
    private int cantidad;

    public ${Entidad}() {
    }

    public ${Entidad}(int id, String nombre, int cantidad) {

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

## ARRAYLIST GLOBAL

```java
private final ArrayList<${Entidad}> lista;

public ${ServiceClass}() {

    lista = new ArrayList<>();

}
```

---

## SELECT → ARRAYLIST

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public void cargarDatos() {

    ConexionBD conexionBD;

    Connection conexion;

    PreparedStatement ps;

    ResultSet rs;

    String sql;

    ${Entidad} objeto;

    conexionBD = new ConexionBD();

    conexion = conexionBD.conectar();

    sql = "SELECT * FROM ${tabla}";

    try {

        ps = conexion.prepareStatement(sql);

        rs = ps.executeQuery();

        while (rs.next()) {

            objeto = new ${Entidad}(

                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("cantidad")

            );

            lista.add(objeto);

        }

        rs.close();

        ps.close();

        conexion.close();

        System.out.println("Datos cargados");

    } catch (SQLException e) {

        System.out.println("Error SELECT");

    }

}
```

---

## INSERT

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public void agregar(${Entidad} objeto) {

    ConexionBD conexionBD;

    Connection conexion;

    PreparedStatement ps;

    String sql;

    conexionBD = new ConexionBD();

    conexion = conexionBD.conectar();

    sql =
        "INSERT INTO ${tabla} (nombre, cantidad) " +
        "VALUES (?, ?)";

    try {

        ps = conexion.prepareStatement(sql);

        ps.setString(1, objeto.getNombre());

        ps.setInt(2, objeto.getCantidad());

        ps.executeUpdate();

        lista.add(objeto);

        ps.close();

        conexion.close();

        System.out.println("Insert realizado");

    } catch (SQLException e) {

        System.out.println("Error INSERT");

    }

}
```

---

## UPDATE

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public void modificar(${Entidad} objeto) {

    ConexionBD conexionBD;

    Connection conexion;

    PreparedStatement ps;

    String sql;

    conexionBD = new ConexionBD();

    conexion = conexionBD.conectar();

    sql =
        "UPDATE ${tabla} " +
        "SET nombre = ?, cantidad = ? " +
        "WHERE id = ?";

    try {

        ps = conexion.prepareStatement(sql);

        ps.setString(1, objeto.getNombre());

        ps.setInt(2, objeto.getCantidad());

        ps.setInt(3, objeto.getId());

        ps.executeUpdate();

        ps.close();

        conexion.close();

        System.out.println("UPDATE realizado");

    } catch (SQLException e) {

        System.out.println("Error UPDATE");

    }

}
```

---

## DELETE

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public void borrar(int id) {

    ConexionBD conexionBD;

    Connection conexion;

    PreparedStatement ps;

    String sql;

    conexionBD = new ConexionBD();

    conexion = conexionBD.conectar();

    sql = "DELETE FROM ${tabla} WHERE id = ?";

    try {

        ps = conexion.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();

        ps.close();

        conexion.close();

        System.out.println("DELETE realizado");

    } catch (SQLException e) {

        System.out.println("Error DELETE");

    }

}
```

---

## BUSCAR POR ID

```java
public ${Entidad} buscarPorId(int id) {

    ${Entidad} encontrado;

    encontrado = null;

    for (${Entidad} objeto : lista) {

        if (objeto.getId() == id) {

            encontrado = objeto;

            break;

        }

    }

    return encontrado;

}
```

---

## FILTRAR NÚMERO

```java
import java.util.ArrayList;

public ArrayList<${Entidad}> filtrarCantidad(int cantidad) {

    ArrayList<${Entidad}> filtrados;

    filtrados = new ArrayList<>();

    for (${Entidad} objeto : lista) {

        if (objeto.getCantidad() >= cantidad) {

            filtrados.add(objeto);

        }

    }

    return filtrados;

}
```

---

## FILTRAR TEXTO

```java
import java.util.ArrayList;

public ArrayList<${Entidad}> filtrarNombre(String nombre) {

    ArrayList<${Entidad}> filtrados;

    filtrados = new ArrayList<>();

    for (${Entidad} objeto : lista) {

        if (

            objeto.getNombre()
                  .toLowerCase()
                  .contains(nombre.toLowerCase())

        ) {

            filtrados.add(objeto);

        }

    }

    return filtrados;

}
```

---

## MOSTRAR LISTA

```java
public void mostrarLista(ArrayList<${Entidad}> lista) {

    for (${Entidad} objeto : lista) {

        System.out.println(

                objeto.getId()
                + " - "
                + objeto.getNombre()
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

        for (${Entidad} objeto : lista) {

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
│   └── ${ControllerClass}.java
│
├── model/
│   └── ${Entidad}.java
│
├── service/
│   └── ${ServiceClass}.java
│
└── database/
    └── ConexionBD.java
```

---

## LO MÁS IMPORTANTE

### ✔ PRIORIDAD ALTA
- SELECT
- ArrayList
- ResultSet
- PreparedStatement
- foreach
- filtros
- guardar archivo
- MVC básico

### ✔ MUY POSIBLE EN EXAMEN
- INSERT
- DELETE
- buscar por ID
- mostrar listas

### ❌ NO PIERDAS TIEMPO
- rollback
- transacciones
- NIO complejo
- Path
- streams raros
- múltiples capas innecesarias
