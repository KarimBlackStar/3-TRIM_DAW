package daw.cotarelo.model;

/**
 *
 * @author Módulo Programación 1º DAW
 */
public interface IAlmacenable {
    String toCsvLine(); // Convierte el objeto a línea CSV 
    int getId(); // Devuelve el identificador único
}
