\# 🛠️ Guía de Configuración: JavaFX en NetBeans (PC Local)



Esta guía resume los pasos necesarios para configurar el entorno de desarrollo de JavaFX 25 utilizando el JDK 23.



\---



\## 1. Instalación del Motor (JDK)

Desde el JDK 11, JavaFX no está incluido por defecto en Java.

\* \*\*Versión instalada\*\*: JDK 23.

\* \*\*Ruta de instalación\*\*: `C:\\Program Files\\Java\\jdk-23`.

\* \*\*Configuración de NetBeans\*\*: Se modificó el archivo `netbeans.conf` para que el IDE use este motor.

&#x20;   \* \*\*Ruta del archivo\*\*: `C:\\Program Files\\NetBeans-23\\netbeans\\etc\\netbeans.conf`.

&#x20;   \* \*\*Línea clave\*\*: `netbeans\_jdkhome="C:\\Program Files\\Java\\jdk-23"`.

&#x20;   \* \*\*IMPORTANTE\*\*: Para guardar cambios en este archivo, debes abrir el Bloc de Notas como \*\*Administrador\*\*.



\---



\## 2. Ubicación del SDK de JavaFX

\* \*\*Versión utilizada\*\*: JavaFX SDK 25.0.3.

\* \*\*Ruta permanente\*\*: `C:\\Program Files\\Java\\javafx-sdk-25.0.3`.

\* \*\*Carpeta clave\*\*: La subcarpeta `lib` contiene los archivos `.jar` necesarios para que la interfaz funcione.



\---



\## 3. Registro de Librería Global en NetBeans

Para que NetBeans reconozca los componentes de JavaFX en cualquier proyecto:

1\. Ve a \*\*Tools > Libraries\*\*.

2\. Haz clic en \*\*New Library\*\* y nómbrala `JavaFX25`.

3\. En la pestaña \*\*Classpath\*\*, añade todos los archivos `.jar` que están dentro de la carpeta `lib` del SDK.



\---



\## 4. Configuración del Scene Builder

Herramienta externa para diseñar ventanas de forma visual (archivos FXML).

\* \*\*Activación\*\*: En `Tools > Plugins > Installed`, activa el plugin \*\*JavaFX 2\*\*.

\* \*\*Vinculación\*\*: En `Tools > Options > Java > JavaFX`, define la ruta donde se instaló el programa en \*\*Scene Builder Home\*\*.



\---



\## 5. Check-list para ejecutar Proyectos

Cada vez que crees un proyecto nuevo, aplica estos ajustes en sus Propiedades (\*\*Properties\*\*):



1\. \*\*Libraries\*\*: En la pestaña `Compile`, añade la librería global `JavaFX25`.

2\. \*\*Compiling\*\*: Desmarca la opción \*\*Compile on Save\*\* (evita errores de bloqueo en la ruta de los módulos).

3\. \*\*Run (VM Options)\*\*: Pega el siguiente comando en el cuadro \*\*VM Options\*\* para enlazar los módulos en tiempo de ejecución:

&#x20;  ```text

&#x20;  --module-path "C:\\Program Files\\Java\\javafx-sdk-25.0.3\\lib" --add-modules javafx.controls,javafx.fxml

