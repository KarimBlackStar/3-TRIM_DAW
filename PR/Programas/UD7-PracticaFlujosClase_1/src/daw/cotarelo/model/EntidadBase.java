package daw.cotarelo.model;

/**
 *
 * @author Módulo Programación 1º DAW
 */
public abstract class EntidadBase implements IAlmacenable {

    protected int id;
    protected String nombre;

    public EntidadBase(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public abstract String toString();
}
