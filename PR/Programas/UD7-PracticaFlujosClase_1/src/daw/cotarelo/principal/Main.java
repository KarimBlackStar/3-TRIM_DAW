package daw.cotarelo.principal;

import daw.cotarelo.controller.*;
import daw.cotarelo.model.*;
import daw.cotarelo.view.*;
import gal.cotarelo.menu.controller.*;
import java.io.IOException;


/**
 * Punto de entrada principal de la aplicación.
 *
 * @author Programación/DAW
 * @version 1.0
 */
public class Main {
    /**
     * Ruta relativa al archivo CSV que contiene los datos iniciales.
     */
    private static final String NOMBRE_FICH_CSV = "datos/productos.csv";


    public static void main(String[] args) {
        int opcion = 0; // almacena la opción elegida
        boolean salir = false; // controla si el usuario decidió salir o no del programa

        // 1. Configuramos as opcións do menú
        String[] opcions = {};

        // 2. Inicializamos el controlador del menú (de la  librería) 
        MenuController menuControl = new MenuController("Gestor de inventario de productos", opcions);

        // 3. INSTANCIACIÓN DE COMPONENTES (Arquitectura MVC)
        // Creamos los modelos (datos y lógica de archivos)
        InventarioModelo inventarioModelo = new InventarioModelo();
        FicheroModelo ficheroModelo = new FicheroModelo();

        // Creamos la vista (interfaz de usuario)
        Vista vista = new Vista();

        // Creamos el controlador, inyectando las dependencias necesarias.
        // El controlador "conoce" a los modelos y a la vista para actuar como intermediario.
        InventarioControlador controlador = 
                new InventarioControlador(inventarioModelo, ficheroModelo, vista);
        
        
        
        //Crea el directorio /salida si ni está creado
        controlador.inicializarDirectorioSalida();
        try {
            controlador.cargarDesdeArchivo(NOMBRE_FICH_CSV);
        } catch (IOException e) {
            salir = true;
            System.err.println("Se cierra el programa: No se puedo abrir el fichero de productos "+ e.getMessage());
            
        }
        // 4. Bucle principal del menú
        while (!salir) {
            try {
                // Obtenemos la opción seleccionada por el usuario desde la lógica del menú
                opcion = menuControl.executar();

                // 4. Switch-case: delegación exclusiva al controlador
                switch (opcion) {
                    case 1:// Mostrar todos los productos
                        controlador.mostrarTodos();
                        break;
                    case 2://Opción 2
                        break;
                    case 3://Opción 3
                        break;
                    case 4://Opción de salida
                        salir = true;
                }

            } catch (Exception e) {
                vista.mostrarMensajeError("ERRO INESPERADO: " + e.getMessage());
            }
        } 
    }
}
