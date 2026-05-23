# Snippets Java MVC

---

## DAO

### Agregar

```java
public void agregar(${Entidad} ${objeto}) throws SQLException {

    String sql = "INSERT INTO ${tabla} (${columna1}, ${columna2}) VALUES (?, ?)";

    try (
        Connection conn = DatabaseSetup.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            sql,
            Statement.RETURN_GENERATED_KEYS
        )
    ) {

        pstmt.setString(1, ${objeto}.get${Propiedad1}());
        pstmt.setInt(2, ${objeto}.get${Propiedad2}());

        pstmt.executeUpdate();

        try (ResultSet rs = pstmt.getGeneratedKeys()) {

            if (rs.next()) {

                long id = rs.getLong(1);

                ${objeto}.setId((int) id);

                System.out.println("${Entidad} guardada con ID: " + id);
            }
        }

        ${cache}.add(${objeto});
    }
}
```

---

### Borrar

```java
public boolean borrar(int id) {

    String sql = "DELETE FROM componentes WHERE id = ?";

    try (
        Connection conn = DatabaseSetup.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)
    ) {

        pstmt.setInt(1, id);

        return pstmt.executeUpdate() > 0;

    } catch (SQLException e) {

        System.err.println(
            "Error de BD al intentar borrar: " + e.getMessage()
        );

        return false;
    }
}
```

---

### Modificar

```java
public boolean modificar(${Entidad} ${objeto}) throws SQLException {

    boolean modificar = true;

    String sqlModificar =
        "UPDATE ${tabla} " +
        "SET ${columna1} = ?, ${columna2} = ? " +
        "WHERE id = ?";

    try (Connection conn = DatabaseSetup.getConnection()) {

        conn.setAutoCommit(false);

        try (PreparedStatement ps = conn.prepareStatement(sqlModificar)) {

            ps.setString(1, ${objeto}.get${Propiedad1}());
            ps.setInt(2, ${objeto}.get${Propiedad2}());
            ps.setInt(3, ${objeto}.getId());

            ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {

            conn.rollback();

            throw e;

        } finally {

            conn.setAutoCommit(true);
        }

    } catch (SQLException e) {

        System.err.println(
            "Error al modificar en la BD: " + e.getMessage()
        );

        modificar = false;
    }

    return modificar;
}
```

---

### Buscar por ID

```java
public ${Entidad} buscadorID(int id) {

    ${Entidad} ${objeto}Encontrado = null;

    for (${Entidad} ${obj} : cache${Entidad}es) {

        if (${obj}.getId() == id) {

            ${objeto}Encontrado = ${obj};

            break;
        }
    }

    return ${objeto}Encontrado;
}
```

---

### Filtrar por valor numérico

```java
public List<${Entidad}> filtrarPor${PropiedadInt}(int ${propiedadInt}) {

    List<${Entidad}> filtrados = new ArrayList<>();

    for (${Entidad} c : cache${Entidad}es) {

        if (c.get${PropiedadInt}() == ${propiedadInt}) {

            filtrados.add(c);
        }
    }

    return filtrados;
}
```

---

### Filtrar por texto

```java
public List<${Entidad}> filtrarPor${PropiedadString}(String ${propiedadString}) {

    List<${Entidad}> filtrados = new ArrayList<>();

    String filtro = ${propiedadString}.toLowerCase();

    for (${Entidad} c : cache${Entidad}es) {

        if (
            c.get${PropiedadString}()
             .toLowerCase()
             .contains(filtro)
        ) {

            filtrados.add(c);
        }
    }

    return filtrados;
}
```

---

### Filtrar tipo exacto

```java
public List<${Entidad}> filtrarPor${Propiedad}(String ${propiedad}) {

    List<${Entidad}> filtrados = new ArrayList<>();

    for (${Entidad} c : cache${Entidad}es) {

        if (
            c.get${Propiedad}()
             .equalsIgnoreCase(${propiedad})
        ) {

            filtrados.add(c);
        }
    }

    return filtrados;
}
```

---

### Filtrar coincidencia parcial

```java
public List<${Entidad}> filtrarPor${PropiedadParcial}(String ${propiedadParcial}) {

    List<${Entidad}> filtrados = new ArrayList<>();

    for (${Entidad} c : cache${Entidad}es) {

        if (
            c.get${PropiedadParcial}() != null &&
            c.get${PropiedadParcial}()
             .toLowerCase()
             .contains(${propiedadParcial}.toLowerCase())
        ) {

            filtrados.add(c);
        }
    }

    return filtrados;
}
```

---

## Controlador

### Agregar

```java
public void agregar${Entidad}() throws SQLException {

    vista.mostrarMensaje(
        "-".repeat(5) + " Agregar ${Entidad} " + "-".repeat(5)
    );

    ${Entidad} ${objeto} = vista.pedirDatos${Entidad}();

    modelo.agregar(${objeto});

    vista.mostrar${Entidad}(${objeto});
}
```

---

### Borrar

```java
public void borrar${Entidad}() {

    int id = vista.pedirDatoInteger(
        "Introduce el ID de la ${entidad_min} a borrar"
    );

    boolean exito = modelo.borrar(id);

    if (exito) {

        vista.mostrarMensaje(
            "${Entidad} borrado con exito de la BD y de la cache."
        );

    } else {

        vista.mostrarMensajeError(
            "Error: No se encontro ninguna ${entidad_min} con ese ID."
        );
    }
}
```

---

### Modificar

```java
public void modificar${Entidad}() throws SQLException {

    int id = vista.pedirDatoInteger(
        "Dame el id de la ${entidad_min} que quieras"
    );

    ${Entidad} ${objeto} = modelo.buscadorID(id);

    if (${objeto} != null) {

        vista.pedirDatosModificacion${Entidad}(${objeto});

        modelo.modificar(${objeto});

        modelo.modificarCache(${objeto});

    } else {

        vista.mostrarMensajeError(
            "Error: No se encontro ninguna ${entidad_min} con ese ID."
        );
    }
}
```

---

### Filtrar tipo

```java
public void filtrarPor${Propiedad}() {

    String ${criterio} = vista.pedir${Propiedad}();

    List<${Entidad}> listaFiltrada =
        modelo.filtrarPor${Propiedad}(${criterio});

    vista.mostrarLista${Entidad}es(listaFiltrada);
}
```

---

### Filtrar con validación

```java
public void filtrarPor${PropiedadConValidacion}() {

    String criterio = vista.pedirString(
        "Introduce la ${propiedad_min} a buscar"
    );

    if (criterio == null || criterio.trim().isEmpty()) {

        vista.mostrarMensajeError(
            "El criterio de busqueda no puede estar vacio."
        );

        return;
    }

    try {

        List<${Entidad}> listaFiltrada =
            modelo.filtrarPor${PropiedadConValidacion}(criterio);

        vista.mostrarLista${Entidad}es(listaFiltrada);

    } catch (Exception e) {

        vista.mostrarMensajeError(
            "Error al filtrar por ${propiedad_min}: " + e.getMessage()
        );
    }
}
```
