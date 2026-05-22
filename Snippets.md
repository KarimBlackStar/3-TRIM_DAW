# SNIPPETS REALES EXAMEN MVC MYSQL NETBEANS

## INSERT DAO

```java
public boolean agregar(${CLASS} ${obj}) {

    boolean agregado = false;

    String sql =
            "INSERT INTO ${TABLE} "
            + "(${FIELD1}, ${FIELD2}, ${FIELD3}, ${FIELD4}) "
            + "VALUES (?, ?, ?, ?)";

    try {PreparedStatement pstmt =conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1,${obj}.get${GET1}());
        pstmt.setInt(2,${obj}.get${GET2}());
        pstmt.setString(3,${obj}.get${GET3}());
        pstmt.setDouble(4,${obj}.get${GET4}());

        int filas = pstmt.executeUpdate();

        if (filas > 0) {ResultSet rs =pstmt.getGeneratedKeys();

            if (rs.next()) {
                ${obj}.setId(rs.getInt(1));
            } cache${LIST}.add(${obj});
            agregado = true;
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return agregado;
}
```

---

## DELETE DAO

```java
public boolean borrar(int id) {

    boolean borrado = false;

    String sql = "DELETE FROM ${TABLE} " + "WHERE id = ?";

    try {PreparedStatement pstmt = conexion.prepareStatement(sql);

        pstmt.setInt(1, id);

        int filas = pstmt.executeUpdate();

        if (filas > 0) {
            int i = 0;

            while ( i < cache${LIST}.size() && !borrado) {
                if ( cache${LIST}.get(i).getId()== id) {

                    cache${LIST}.remove(i);
                    borrado = true;
                } else {
                    i++;
                }
            }
        }

    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return borrado;
}
```

---

## UPDATE DAO

```java
public boolean modificar(${CLASS} ${obj}) {

    boolean modificado = false;

    String sql =
            "UPDATE ${TABLE} "
            + "SET ${FIELD1} = ?, "
            + "${FIELD2} = ?, "
            + "${FIELD3} = ?, "
            + "${FIELD4} = ? "
            + "WHERE id = ?";

    try {PreparedStatement pstmt =conexion.prepareStatement(sql);

        pstmt.setString(1,${obj}.get${GET1}());
        pstmt.setInt(2,${obj}.get${GET2}());
        pstmt.setString(3,${obj}.get${GET3}());
        pstmt.setDouble(4,${obj}.get${GET4}());
        pstmt.setInt(5,${obj}.getId());

        int filas =pstmt.executeUpdate();

        if (filas > 0) {
            int i = 0;
            while (
                    i < cache${LIST}.size() && !modificado) {

                if (cache${LIST}.get(i).getId()== ${obj}.getId()) {
                    cache${LIST}.set(i,${obj});

                    modificado = true;
                } else {
                    i++;
                }
            }
        }

    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return modificado;
}
```

---

## BUSCAR POR ID

```java
public ${CLASS} buscarPorId(int id) {

    ${CLASS} encontrado = null;

    int i = 0;

    boolean existe = false;

    while (i < cache${LIST}.size() && !existe) {
        if (cache${LIST}.get(i).getId()== id) {
            encontrado =cache${LIST}.get(i);

            existe = true;
        } else {
            i++;
        }
    }
    return encontrado;
}
```

---

## FILTRO STRING

```java
public List<${CLASS}>${METHOD}(String ${param}) {

    List<${CLASS}> filtrados =new ArrayList<>();

    for ( ${CLASS} ${obj} : cache${LIST}) {
        if (${obj}.get${GET}() != null && ${obj}.get${GET}().toLowerCase().contains(${param}.toLowerCase())) {
            filtrados.add(${obj});
        }
    }
    return filtrados;
}
```

---

## FILTRO EXACTO

```java
public List<${CLASS}>${METHOD}(int ${param}) {

    List<${CLASS}> filtrados =new ArrayList<>();

    for (${CLASS} ${obj}: cache${LIST}) {

        if (${obj}.get${GET}()== ${param}) {
            filtrados.add(${obj});
        }
    }
    return filtrados;
}
```

---

## pedirDatoInteger

```java
public int pedirDatoInteger(String mensaje) {

    int numero = 0;
    boolean valido = false;

    while (!valido) {
        try {System.out.println(mensaje);

            numero = Integer.parseInt(sc.nextLine());

            valido = true;
        } catch (NumberFormatException e) {
            System.err.println("${ERROR}");
        }
    }
    return numero;
}
```

---

## pedirString

```java
public String pedirString(String mensaje) {

    String texto = "";
    System.out.println(mensaje);

    texto = sc.nextLine();
    return texto;
}
```

---

## pedirTipo

```java
public String pedirTipo() {

    String tipo = "";
    boolean valido = false;

    while (!valido) {System.out.println("${MSG}");

        tipo =sc.nextLine().toUpperCase();

        if (tipo.equals("${VAL1}") ||tipo.equals("${VAL2}")) {
            valido = true;
        } else {
            System.err.println("${ERROR}");
        }
    }
    return tipo;
}
```

---

## pedirDatos GENERICO

```java
public ${CLASS}
        pedirDatos${CLASS}() {

    ${CLASS} obj = null;
    ${TYPE1} ${var1};
    ${TYPE2} ${var2};
    ${TYPE3} ${var3};
    ${TYPE4} ${var4};

    ${var1} =pedirString("${MSG1}");
    ${var2} =pedirDatoInteger("${MSG2}");
    ${var3} =pedirString("${MSG3}");
    ${var4} =pedirDatoInteger("${MSG4}");

    obj = new ${CLASS}(0,${var1},${var2},${var3},${var4});
    return obj;
}
```

---

## pedirDatosModificacion GENERICO

```java
public ${CLASS}
    pedirDatosModificacion${CLASS}(${CLASS} actual) {
        ${CLASS} nuevo = null;
        String entrada;
        ${TYPE1} ${var1};
        ${TYPE2} ${var2};
        ${TYPE3} ${var3};
        ${TYPE4} ${var4};

    System.out.println("${MSG1} ["+ actual.get${GET1}()+ "]");

    entrada = sc.nextLine();

    if (entrada.isEmpty()) { ${var1} =actual.get${GET1}();
    } else {
        ${var1} = entrada;
    } ${var2} =actual.get${GET2}();

    System.out.println("${MSG2} ["+ actual.get${GET2}()+ "]");

    entrada = sc.nextLine();

    if (!entrada.isEmpty()) {
        ${var2} =Integer.parseInt(entrada);
    } ${var3} =actual.get${GET3}();

    System.out.println("${MSG3} ["+ actual.get${GET3}()+ "]");

    entrada = sc.nextLine();

    if (!entrada.isEmpty()) {
        ${var3} = entrada;
    } ${var4} =actual.get${GET4}();

    System.out.println("${MSG4} ["+ actual.get${GET4}()+ "]");

    entrada = sc.nextLine();
    if (!entrada.isEmpty()) {
        ${var4} =Integer.parseInt(entrada);
    } nuevo = new ${CLASS}(actual.getId(),${var1},${var2},${var3},${var4});
    return nuevo;
}
```

---

## mostrarMensaje

```java
public void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
}
```

---

## mostrarMensajeError

```java
public void mostrarMensajeError(String mensaje) {
    System.err.println(mensaje);
}
```

---

## mostrarObjeto

```java
public void mostrar${CLASS}(${CLASS} obj) {
    System.out.println(obj);
}
```

---

## mostrarLista

```java
public void mostrarLista${CLASS}(List<${CLASS}> lista) {
    if (lista.isEmpty()) {
        System.out.println("${EMPTY}");
    } else {
        for (${CLASS} obj: lista) {
            mostrar${CLASS}(obj);
        }
    }
}
```

---

## CONTROLADOR AGREGAR

```java
public void agregar${CLASS}() {

    ${CLASS} obj =view.pedirDatos${CLASS}();
    boolean resultado =dao.agregar(obj);

    if (resultado) {
        view.mostrarMensaje("${OK}");
        view.mostrar${CLASS}(obj);
    } else {
        view.mostrarMensajeError("${ERROR}");
    }
}
```

---

## CONTROLADOR BORRAR

```java
public void borrar${CLASS}() {

    int id =view.pedirDatoInteger("${MSG}");
    boolean resultado =dao.borrar(id);

    if (resultado) {
        view.mostrarMensaje("${OK}");
    } else {
        view.mostrarMensajeError("${ERROR}");
    }
}
```

---

## CONTROLADOR MODIFICAR

```java
public void modificar${CLASS}() {

    int id =view.pedirDatoInteger("${MSG}");
    ${CLASS} actual =dao.buscarPorId(id);

    if (actual != null) {
        ${CLASS} nuevo =view.pedirDatosModificacion${CLASS}(actual);

        boolean resultado =dao.modificar(nuevo);
        if (resultado) {
            view.mostrarMensaje("${OK}");
        } else {
            view.mostrarMensajeError("${ERROR}");
        }
    } else {
            view.mostrarMensajeError("${ERRORID}"
        );
    }
}
```

---

## MENU MVC

```java
switch (${OPTION}) {

    case 1:
        controller.${METHOD1}();
        break;

    case 2:
        controller.${METHOD2}();
        break;

    case 3:
        controller.${METHOD3}();
        break;

    case 4:
        controller.${METHOD4}();
        break;

    case 5:
        controller.${METHOD5}();
        break;

    case 0:
        ${EXIT} = true;
        break;
}
```

---

## MAIN

```java
public static void main(String[] args) {
    ${CLASS}Controller controller = new ${CLASS}Controller();

    controller.iniciar();
}
```
