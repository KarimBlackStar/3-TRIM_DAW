# PLANTILLA COMPLETA JAVAFX (MAIN + FXML + CONTROLLER)

---

# 1. ESTRUCTURA DEL PROYECTO

```txt
src/
 ├── Main.java
 ├── hello.fxml
 └── HelloController.java
```

---

# 2. MAIN.JAVA

```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Cargar FXML
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("hello.fxml")
        );

        // Contenedor raíz
        Parent root = loader.load();

        // Crear escena
        Scene scene = new Scene(root);

        // Configurar Stage
        stage.setTitle("Mi aplicación JavaFX");
        stage.setScene(scene);

        // Mostrar ventana
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
```

---

# 3. HELLO.FXML (VISTA)

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.VBox?>

<VBox
    alignment="CENTER"
    spacing="10"
    xmlns:fx="http://javafx.com/fxml"
    fx:controller="HelloController">

    <!-- Label -->
    <Label
        fx:id="lbl_Mensaje"
        text="Introduce tu nombre" />

    <!-- TextField -->
    <TextField
        fx:id="txt_Nombre"
        promptText="Escribe aquí..." />

    <!-- Button -->
    <Button
        fx:id="btn_Saludar"
        text="Saludar"
        onAction="#handle_btn_Saludar" />

</VBox>
```

---

# 4. HELLOCONTROLLER.JAVA

```java
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController implements Initializable {

    // COMPONENTES DEL FXML

    @FXML
    private Label lbl_Mensaje;

    @FXML
    private TextField txt_Nombre;

    @FXML
    private Button btn_Saludar;

    // MÉTODO INITIALIZE

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Se ejecuta al cargar el FXML
    }

    // HANDLER DEL BOTÓN

    @FXML
    private void handle_btn_Saludar() {

        // Obtener texto
        String nombre = txt_Nombre.getText().trim();

        // Comprobar vacío
        if(!nombre.isEmpty()) {

            // Cambiar Label
            lbl_Mensaje.setText("Hola " + nombre);

            // Limpiar TextField
            txt_Nombre.clear();

            // Desactivar botón
            btn_Saludar.setDisable(true);

        } else {

            lbl_Mensaje.setText("Introduce un nombre");
        }
    }
}
```

---

# 5. VM OPTIONS

```txt
--module-path "C:\Program Files\Java\javafx-sdk-25.0.3\lib" --add-modules javafx.controls,javafx.fxml
```

---

# 6. QUÉ VA EN CADA PARTE

## MAIN
- Inicia JavaFX
- Carga el FXML
- Crea Scene
- Configura Stage

---

## FXML
- Interfaz gráfica
- Botones
- Labels
- TextFields
- VBox / HBox / BorderPane

---

## CONTROLLER
- Lógica
- Eventos
- Handlers
- Modificar componentes

---

# 7. ORDEN TÍPICO EN EXAMEN

## 1. Crear FXML
- VBox
- Label
- TextField
- Button

---

## 2. Poner fx:id

```xml
fx:id="txt_Nombre"
```

---

## 3. Poner handler

```xml
onAction="#handle_btn_Saludar"
```

---

## 4. Añadir controlador

```xml
fx:controller="HelloController"
```

---

## 5. Crear variables @FXML

```java
@FXML
private TextField txt_Nombre;
```

---

## 6. Crear handler

```java
@FXML
private void handle_btn_Saludar() {

}
```

---

# 8. PLANTILLA RÁPIDA DE HANDLER

```java
@FXML
private void handle_btn() {

    String texto = txt_Campo.getText().trim();

    if(!texto.isEmpty()) {

        lbl_Texto.setText(texto);

        txt_Campo.clear();

    } else {

        lbl_Texto.setText("Campo vacío");
    }
}
```

---

# 9. PLANTILLA PARA CAMBIAR DE VENTANA

```java
@FXML
private void handle_btn_Abrir() throws Exception {

    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("ventana2.fxml")
    );

    Parent root = loader.load();

    Stage stage2 = new Stage();

    stage2.setScene(new Scene(root));
    stage2.show();

    Stage stage1 = (Stage) btn_Abrir.getScene().getWindow();

    stage1.close();
}
```

---

# 10. ERRORES MÁS TÍPICOS

## ❌ No funciona el botón
Falta:
```xml
onAction="#handle_btn"
```

---

## ❌ No encuentra componentes
Falta:
```java
@FXML
```

---

## ❌ No carga el FXML
Ruta incorrecta:
```java
getClass().getResource("hello.fxml")
```

---

## ❌ No conecta controlador
Falta:
```xml
fx:controller="HelloController"
```
