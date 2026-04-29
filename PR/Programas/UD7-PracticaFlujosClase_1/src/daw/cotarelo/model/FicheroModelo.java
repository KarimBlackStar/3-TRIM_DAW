package daw.cotarelo.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Módulo Programación 1º DAW
 */


public class FicheroModelo {
    
    private static final String DIR_SALIDA = "salida";
    
    public void inicializarDirectorio() {
        File dir = new File(DIR_SALIDA);
        if (!dir.exists()) {
            // mkdirs() crea el directorio y cualquier padre necesario
            dir.mkdirs();
        }
    }
    
    
    public List<Producto> cargarDesdeArchivo(String ruta) throws IOException {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(ruta, StandardCharsets.ISO_8859_1))) {
            br.readLine(); // Saltar cabecera
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    int id = Integer.parseInt(partes[0].trim());
                    String nombre = partes[1].trim();
                    String categoria = partes[2].trim();
                    double precio = Double.parseDouble(partes[3].trim());
                    int stock = Integer.parseInt(partes[4].trim());
                    productos.add(new Producto(id, nombre, categoria, precio, stock));
                }
            }
        } 
        return productos; // Devuelve la lista, no toca nada más
    }
    
}
