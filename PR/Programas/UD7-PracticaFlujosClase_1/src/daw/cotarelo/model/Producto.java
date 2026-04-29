package daw.cotarelo.model;

/**
 * Representa un producto específico dentro del inventario de hardware. Esta
 * clase extiende de {@link EntidadBase} para heredar los atributos comunes e
 * implementa los métodos de la interfaz {@link IAlmacenable} para permitir su
 * exportación a ficheros CSV
 *
 * @author Módulo Programación 1º DAW
 * @version 1.0
 */
public class Producto extends EntidadBase {

    private String categoria;
    private double precio;
    private int stock;

    /**
     * Constructor completo para la clase Producto.
     *
     * @param id Identificador único del producto
     * @param nombre Nombre descriptivo del producto
     * @param categoria Categoría a la que pertenece (ej. Periféricos, Audio)
     * @param precio Valor unitario del producto
     * @param stock Cantidad de unidades disponibles en almacén
     */
    public Producto(int id, String nombre, String categoria, double precio, int stock) {
        // Llamada obligatoria al constructor de la clase padre (EntidadBase)
        // para inicializar los atributos protegidos id y nombre
        super(id, nombre);
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return String con el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return String con la categoría
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Obtiene el precio actual del producto.
     *
     * @return double con el precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el número de unidades en stock.
     *
     * @return int con la cantidad disponible
     */
    public int getStock() {
        return stock;
    }

    /**
     * Convierte el objeto en una línea de texto con formato CSV. Utiliza la
     * coma (,) como separador según los requisitos del proyecto
     *
     * @return Una cadena de texto con los campos: id, nombre, categoria,
     * precio, stock
     */
    @Override
    public String toCsvLine() {
        // Concatenamos los atributos propios y los heredados de EntidadBase
        return id + "," + nombre + "," + categoria + "," + precio + "," + stock;
    }

    /**
     * Genera una representación visual del producto formateada para consola.
     * Utiliza String.format para alinear las columnas y facilitar la lectura.
     *
     * @return Cadena formateada con el ID, nombre (30 carac.), categoría,
     * precio y stock.
     */
    @Override
    public String toString() {
        // %-30s: Reserva 30 espacios para el nombre, alineado a la izquierda.
        // %8.2f: Reserva 8 espacios para el precio con 2 decimales.
        return String.format("[%d] %-30s | %-15s | %8.2f€ | stock: %d",
                id, nombre, categoria, precio, stock);
    }
}
