# SNIPPETS JAVAFX REALMENTE ÚTILES

---

# 1. MAIN BÁSICO JAVAFX

```java
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Mi app");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

---

# 2. CARGAR FXML

```java
FXMLLoader loader = new FXMLLoader(
    getClass().getResource("hello.fxml")
);

Parent root = loader.load();

Scene scene = new Scene(root);

stage.setScene(scene);
stage.show();
```

---

# 3. CONTROLADOR BÁSICO

```java
public class HelloController implements Initializable {

    @FXML
    private Label lbl_Texto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
```

---

# 4. HANDLER DE BOTÓN

```java
@FXML
private void handle_btn_Saludar() {

    System.out.println("Hola");
}
```

---

# 5. CAMBIAR TEXTO LABEL

```java
lbl_Texto.setText("Nuevo texto");
```

---

# 6. OBTENER TEXTO TEXTFIELD

```java
String texto = txt_Nombre.getText().trim();
```

---

# 7. LIMPIAR TEXTFIELD

```java
txt_Nombre.clear();
```

---

# 8. DESACTIVAR BOTÓN

```java
btn_Saludar.setDisable(true);
```

---

# 9. COMPROBAR SI ESTÁ VACÍO

```java
if(!texto.isEmpty()) {

}
```

---

# 10. CAMBIAR COLOR CON CSS

```java
root.setStyle("-fx-background-color: lightblue;");
```

---

# 11. ABRIR OTRA VENTANA

```java
FXMLLoader loader = new FXMLLoader(
    getClass().getResource("ventana2.fxml")
);

Parent root = loader.load();

Stage stage2 = new Stage();

stage2.setScene(new Scene(root));
stage2.show();
```

---

# 12. CERRAR VENTANA

```java
Stage stage = (Stage) btn_Cerrar.getScene().getWindow();

stage.close();
```

---

# 13. PASAR DATOS ENTRE VENTANAS

## Ventana 1

```java
FXMLLoader loader = new FXMLLoader(
    getClass().getResource("ventana2.fxml")
);

Parent root = loader.load();

Ventana2Controller ctrl = loader.getController();

ctrl.setTexto(texto);
```

## Ventana 2

```java
public void setTexto(String texto) {

    lbl_TextoRecibido.setText(texto);
}
```

---

# 14. CERRAR TODA LA APP

```java
Platform.exit();
```

---

# 15. ALERTA

```java
Alert alert = new Alert(Alert.AlertType.INFORMATION);

alert.setTitle("Título");
alert.setHeaderText(null);
alert.setContentText("Mensaje");

alert.show();
```

---

# 16. OBTENER EL MENU PULSADO

```java
MenuItem src = (MenuItem) event.getSource();

System.out.println(src.getText());
```

---

# 17. VM OPTIONS

```txt
--module-path "C:\Program Files\Java\javafx-sdk-25.0.3\lib" --add-modules javafx.controls,javafx.fxml
```

---

# 18. FXML BOTÓN

```xml
<Button
    fx:id="btn_Saludar"
    text="Saludar"
    onAction="#handle_btn_Saludar"/>
```

---

# 19. FXML VBox

```xml
<VBox spacing="12" alignment="CENTER">

</VBox>
```

---

# 20. IMPORTS MÁS USADOS

```java
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
```
