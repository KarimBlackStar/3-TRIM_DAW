package daw.cotarelo.view;

import java.util.Scanner;

/**
 * Vista responsable de toda la interacción con el usuario.
 * <p>
 * Se limita a actuar como interfaz entre el sistema y el operador sin contener
 * lógica.</p>
 *
 * @author Programación/DAW
 * @version 1.0
 */
public class Vista {

    // 1. CONSTANTES
    // 2. ATRIBUTOS DE INSTANCIA
    private final Scanner sc = new Scanner(System.in);

    // 3. MÉTODOS DE ENTRADA DE DATOS
    /**
     * Solicita una cadena de texto al usuario.
     *
     * @param mensaje Etiqueta descriptiva.
     * @return Texto introducido.
     */
    public String pedirDato(String mensaje) {
        System.out.print(mensaje + ": ");
        return sc.nextLine();
    }

    /**
     * Solicita y valida la entrada de un dato decimal.
     *
     * @param mensaje Etiqueta informativa.
     * @return Valor decimal validado.
     */
    public double pedirDatoDouble(String mensaje) {
        boolean correcto = false;
        double dato = 0.0;
        do {
            try {
                System.out.print(mensaje + ": ");
                dato = Double.parseDouble(sc.nextLine());
                correcto = true;
            } catch (NumberFormatException e) {
                mostrarMensajeError("Tipo de dato decimal no correcto.");
            }
        } while (!correcto);
        return dato;
    }
    // 4. MÉTODOS DE SALIDA DE INFORMACIÓN (CABECERAS)

    // 5. MÉTODOS DE LÓGICA DE INTERFAZ
    /**
     * Imprime un mensaje est?ndar.
     *
     * @param msg Texto a mostrar.
     */
    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    /**
     * Imprime un mensaje por el flujo de error.
     *
     * @param msg Texto del error.
     */
    public void mostrarMensajeError(String msg) {
        System.err.println(msg);
    }

    // 6. MÉTODOS PRIVADOS AUXILIARES
}
