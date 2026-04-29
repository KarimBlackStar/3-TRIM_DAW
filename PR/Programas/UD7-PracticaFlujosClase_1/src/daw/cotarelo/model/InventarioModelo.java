package daw.cotarelo.model;

import java.util.HashMap;
import java.util.Map;


/**
 * Clase que gestiona la lógica de colección de los trabajadores de la organización.
 * <p>Esta clase permite realizar operaciones CRUD básicas (Crear, Leer, Eliminar)
 * sobre la lista</p>
 * 
 * @author Programación/DAW
 * @version 1.0
 */
public class InventarioModelo {

    private Map<Integer, Producto> inventario = new HashMap<>();
    
    public Map<Integer, Producto> getInventario () {    
        return inventario;
    }

    public void agregarProducto(Producto p) {
        // En un HashMap, el método put asocia la clave (ID) con el objeto (Producto)
        inventario.put(p.getId(), p);
    }
   
}
