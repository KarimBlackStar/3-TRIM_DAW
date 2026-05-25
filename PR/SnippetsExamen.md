# ================================
# CONTROLADOR
# ================================

/*
 * Muestra todos los registros almacenados.
 * Si no existen datos muestra un mensaje de error.
 */
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


/*
 * Busca un objeto por ID y muestra sus datos.
 */
public void ${nombreMetodo}() {

    int id = vista.pedirDatoInteger("Introduzca el ID: ");

    ${Objeto} o = modelo.buscarPorId(id);

    if (o != null) {

        vista.mostrarMensaje(o.toString());

    } else {

        vista.mostrarMensajeError("${Objeto} no encontrado!");

    }

}


/*
 * Busca registros usando un criterio indicado por el usuario.
 */
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


/*
 * Solicita datos al usuario y registra un nuevo objeto.
 */
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


/*
 * Modifica los datos de un objeto existente.
 */
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



# ================================
# MODELO
# ================================

/*
 * Devuelve todos los objetos almacenados en el mapa.
 */
public List<${Objeto}> ${nombreMetodo}() {

    return new ArrayList<>(mapa${Objeto}s.values());

}


/*
 * Busca y devuelve un objeto usando su ID.
 */
public ${Objeto} ${nombreMetodo}(int id) {

    return mapa${Objeto}s.get(id);

}


/*
 * Busca objetos usando un filtro determinado.
 */
public List<${Objeto}> ${nombreMetodo}(String filtro) {

    List<${Objeto}> resultado = new ArrayList<>();

    for (${Objeto} o : mapa${Objeto}s.values()) {

        if (o.getServicio().equalsIgnoreCase(filtro)) {

            resultado.add(o);

        }

    }

    return resultado;

}


/*
 * Carga todos los registros desde la Base de Datos al mapa.
 */
public void ${nombreMetodo}() throws SQLException {

    if (!mapa${Objeto}s.isEmpty()) {

        mapa${Objeto}s.clear();

    }

    String sql = "SELECT * FROM tabla";

    try (Connection conn = DatabaseSetup.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {

            int id = rs.getInt("id");

            ${Objeto} o = new ${Objeto}();

            mapa${Objeto}s.put(id, o);

        }

    }

}


/*
 * Inserta un nuevo objeto en la Base de Datos y en el mapa.
 */
public void ${nombreMetodo}(${Objeto} o) throws SQLException {

    String sql = "INSERT INTO tabla VALUES (...)";

    try (Connection conn = DatabaseSetup.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.executeUpdate();

        mapa${Objeto}s.put(o.getId(), o);

    }

}


/*
 * Actualiza los datos de un objeto en BD y en el mapa.
 */
public void ${nombreMetodo}(${Objeto} o) throws SQLException {

    String sql = "UPDATE tabla SET ... WHERE id = ?";

    try (Connection conn = DatabaseSetup.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.executeUpdate();

        mapa${Objeto}s.put(o.getId(), o);

    }

}
```
