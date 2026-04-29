package daw.cotarelo.controller;

import daw.cotarelo.model.*;
import daw.cotarelo.view.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Orquesta la comunicación entre el modeloFichero y la vista.
 *
 * @author Programación/DAW
 * @version 1.0
 */
public class InventarioControlador {

    private InventarioModelo modeloInventario;
    private FicheroModelo modeloFichero;
    private Vista vista;

    public InventarioControlador(
            InventarioModelo modeloLista,
            FicheroModelo modeloFichero,
            Vista vista) {
        this.modeloInventario = modeloLista;
        this.modeloFichero = modeloFichero;
        this.vista = vista;
    }

    // ==============================================
    // INICIALIZACIÓN DE LA CARPETA DONDE ESTARÁN LOS FICHEROS DE SALIDA
    // ==============================================
    public void inicializarDirectorioSalida() {
        modeloFichero.inicializarDirectorio(); // El controlador habla con el modelo
    }

    // ==============================================
    // CARGA DE DATOS
    // ==============================================
    /**
     * Carga los productos desde un fichero CSV al inventario.
     * <p>
     * Delega la lectura y el parseo del fichero en {@link FicheroModelo}, y
     * añade cada {@link Producto} obtenido al {@link InventarioModelo}. Si se
     * produce un error de E/S, se notifica al usuario a través de la vista sin
     * propagar la excepción.
     * </p>
     *
     * @param ruta ruta absoluta o relativa al fichero CSV que se desea cargar
     * @throws java.io.IOException
     */
    public void cargarDesdeArchivo(String ruta) throws IOException {
        //Carga el conteido del archivo csv en una lista
        List<Producto> productos = modeloFichero.cargarDesdeArchivo(ruta);
        for (Producto p : productos) {
            modeloInventario.agregarProducto(p);
        }
    }

    // ==============================================
    // CONSULTAS — MOSTRAR POR PANTALLA
    // ==============================================
    /**
     * Muestra por pantalla todos los productos del inventario.
     *
     * <p>
     * Recorre el {@code HashMap} e imprime cada entrada con el formato
     * {@code clave -- toString()}. Si el inventario está vacío, informa al
     * usuario con un mensaje claro.</p>
     */
    public void mostrarTodos() {
        if (!modeloInventario.getInventario().isEmpty()) {
            for (Map.Entry<Integer, Producto> entrada : modeloInventario.getInventario().entrySet()) {
                vista.mostrarMensaje(entrada.getKey() + "--" + entrada.getValue());
            }
        } else {
            vista.mostrarMensaje("El inventario está vacío.");
        }
    }

    public List<Producto> filtrar(String categoria) {
        List<Producto> resultado = new ArrayList<>;
    }

}
