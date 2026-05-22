# Snippets Java

+ Agregar en DAO

```java
public void agregar(${Entidad} ${objeto}) throws SQLException {
    String sql = "INSERT INTO ${tabla} (${columna1}, ${columna2}) VALUES (?, ?)";

    try (Connection conn = DatabaseSetup.getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

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

+ Añadir Componente en el Controlador

```java
public void agregar${Entidad}() throws SQLException {
    vista.mostrarMensaje("-".repeat(5) + " Agregar ${Entidad} " + "-".repeat(5));
    
    // Se piden los datos del objeto a la vista
    ${Entidad} ${objeto} = vista.pedirDatos${Entidad}();
    
    // Insertamos el objeto en la BD a través del modelo/DAO
    modelo.agregar(${objeto});
    
    // Muestra el objeto finalizado
    vista.mostrar${Entidad}(${objeto});
}
```

+ Borrar Componente en DAO

```java
public boolean borrar(int id) {
        String sql = "DELETE FROM componentes WHERE id = ?";
        
        try (Connection conn = DatabaseSetup.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error de BD al intentar borrar: " + e.getMessage());
            return false;
        }
    }
```
