```java
public void ${nombreMetodo}() {

    List<${Objeto}> ${objeto}s = modelo.obtenerTodos();

    if (${objeto}s.isEmpty()) {

        vista.mostrarMensajeError("No hay registros!");

    } else {

        for (${Objeto} o : ${objeto}s) {

            vista.mostrarMensaje(o.toString());

        }

        vista.mostrarMensaje("Total: " + ${objeto}s.size());

    }

}
```
public void ${nombreMetodo}() {

    int id = vista.pedirDatoInteger("Introduzca el ID: ");

    ${Objeto} o = modelo.buscarPorId(id);

    if (o != null) {

        vista.mostrarMensaje(o.toString());

    } else {

        vista.mostrarMensajeError("${Objeto} no encontrado!");

    }

}

public void ${nombreMetodo}() {

    String filtro = vista.pedirString("Introduzca el criterio de búsqueda: ");

    List<${Objeto}> resultados = modelo.buscarPorServicio(filtro);

    if (resultados.isEmpty()) {

        vista.mostrarMensajeError("No se encontraron resultados!");

    } else {

        vista.mostrarMensaje("Resultados encontrados:");

        for (${Objeto} o : resultados) {

            vista.mostrarMensaje(o.toString());

        }

    }

}

public void ${nombreMetodo}() {

    double precio = 0.0;

    String nombre = vista.pedirString("Introduzca el nombre: ");

    try {

        precio = Double.parseDouble(vista.pedirString("Introduzca el precio: "));

    } catch (NumberFormatException e) {

        vista.mostrarMensajeError("Precio no válido!");

    }

    int cantidad = vista.pedirDatoInteger("Introduzca la cantidad: ");

    try {

        modelo.insertar(new ${Objeto}(nombre, precio, cantidad));

        vista.mostrarMensaje("${Objeto} insertado correctamente!");

    } catch (SQLException e) {

        vista.mostrarMensajeError("Error en BD: " + e.getMessage());

    }

}

public void ${nombreMetodo}() {

    int id = vista.pedirDatoInteger("Introduce el ID: ");

    ${Objeto} o = modelo.buscarPorId(id);

    if (o != null) {

        vista.mostrarMensaje("Datos actuales: " + o.toString());

        o.setNombre(vista.pedirString("Nuevo nombre: "));

        try {

            o.setPrecio(Double.parseDouble(vista.pedirString("Nuevo precio: ")));

        } catch (NumberFormatException e) {

            vista.mostrarMensajeError("Precio no válido!");

        }

        try {

            modelo.actualizarDatos(o);

            vista.mostrarMensaje("${Objeto} actualizado correctamente.");

        } catch (SQLException e) {

            vista.mostrarMensajeError("Error al actualizar: " + e.getMessage());

        }

    } else {

        vista.mostrarMensaje("${Objeto} no encontrado.");

    }

}

public List<${Objeto}> ${nombreMetodo}() {

    return new ArrayList<>(mapa${Objeto}s.values());

}

public ${Objeto} ${nombreMetodo}(int id) {

    return mapa${Objeto}s.get(id);

}

public void ${nombreMetodo}(${Objeto} o) throws SQLException {

    String sql = "INSERT INTO tabla VALUES (...)";

    try (Connection conn = DatabaseSetup.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.executeUpdate();

        mapa${Objeto}s.put(o.getId(), o);

    }

}

public void ${nombreMetodo}(${Objeto} o) throws SQLException {

    String sql = "UPDATE tabla SET ... WHERE id = ?";

    try (Connection conn = DatabaseSetup.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.executeUpdate();

        mapa${Objeto}s.put(o.getId(), o);

    }

}
```
