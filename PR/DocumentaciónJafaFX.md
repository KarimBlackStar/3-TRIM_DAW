# 🛠️ Manual de Configuración JavaFX: El Protocolo Completo

---

# 1. ⚙️ El Motor (JDK) y el IDE

Para que NetBeans 23 funcione correctamente y no dé errores al arrancar, debe utilizar el **JDK 23**.

## 📍 Ubicación del JDK

```text
C:\Program Files\Java\jdk-23
```

---

## 🔧 Configuración crítica de NetBeans

Debes abrir el archivo:

```text
C:\Program Files\NetBeans-23\netbeans\etc\netbeans.conf
```

> ⚠️ IMPORTANTE:  
> Abre el editor como **Administrador** para poder guardar los cambios.

Busca esta línea:

```text
netbeans_jdkhome="C:\Program Files\Java\jdk-23"
```

> 💡 Si esta ruta es incorrecta, NetBeans puede no abrir proyectos correctamente.

---

# 2. 📦 El Almacén de Piezas (SDK JavaFX)

Desde Java 11, JavaFX ya no viene incluido dentro del JDK y debe instalarse aparte.

## 📥 SDK utilizado

```text
JavaFX SDK 25.0.3
```

## 📍 Ubicación

```text
C:\Program Files\Java\javafx-sdk-25.0.3
```

---

## 📁 Carpeta importante

Dentro del SDK existe la carpeta:

```text
lib
```

Ahí se encuentran:

- Archivos `.jar` → bibliotecas de JavaFX
- Archivos `.dll` → motores internos necesarios

---

# 3. 🧰 Registro Global en NetBeans (Caja de Herramientas)

Para no tener que añadir manualmente los `.jar` en cada proyecto:

## 📌 Pasos

1. Ir a:

```text
Tools > Libraries
```

2. Pulsar:

```text
New Library
```

3. Crear una librería llamada:

```text
JavaFX25
```

4. En la pestaña:

```text
Classpath
```

Pulsar:

```text
Add JAR/Folder
```

5. Añadir todos los `.jar` de:

```text
C:\Program Files\Java\javafx-sdk-25.0.3\lib
```

---

# 4. 🎨 El Diseñador Visual (Scene Builder)

Scene Builder permite crear interfaces JavaFX visualmente mediante FXML.

---

## 📍 Instalación

```text
C:\Users\GAVKo\AppData\Local\SceneBuilder\
```

---

## 🔗 Vinculación con NetBeans

Ir a:

```text
Tools > Options > Java > JavaFX
```

En:

```text
Scene Builder Home
```

Pegar la ruta anterior.

---

## 🔌 Activación del plugin JavaFX

Ir a:

```text
Tools > Plugins
```

Y comprobar que:

```text
JavaFX 2
```

esté:
- en la pestaña **Installed**
- con el check verde de **Active**

---

# 5. ✅ Check-list de Cada Proyecto

Cada vez que crees un proyecto nuevo JavaFX, debes seguir estos pasos.

---

## 🅰️ PASO A: Eliminar el bloqueo de módulos

Si existe el archivo:

```text
module-info.java
```

👉 **Bórralo**

> ⚠️ Es la causa más común del error:
>
> ```text
> Package not visible
> ```

---

## 🅱️ PASO B: Añadir las librerías

Ir a:

```text
Properties > Libraries
```

⚠️ MUY IMPORTANTE:

Añadir la librería `JavaFX25` en:

```text
Classpath
```

❌ NO en `Modulepath`

---

## 🅲 PASO C: Desactivar Compile on Save

Ir a:

```text
Properties > Build > Compiling
```

Desmarcar:

```text
Compile on Save
```

> 💡 Evita errores relacionados con módulos bloqueados.

---

## 🅳 PASO D: Configurar VM Options

Ir a:

```text
Properties > Run
```

En:

```text
VM Options
```

Pegar esta línea:

```text
--module-path "C:\Program Files\Java\javafx-sdk-25.0.3\lib" --add-modules javafx.controls,javafx.fxml
```

---

# 6. 💻 Estructura de Código que Debe Funcionar

La clase principal debe tener una estructura similar a esta:

```java
package pruebajavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PruebaJavaFX extends Application {

    @Override
    public void start(Stage stage) {

        // 1. Crear contenido
        Label etiqueta = new Label("¡Entorno configurado correctamente!");

        // 2. Crear contenedor raíz
        StackPane raiz = new StackPane();
        raiz.getChildren().add(etiqueta);

        // 3. Crear escena
        Scene escena = new Scene(raiz, 400, 250);

        // 4. Configurar ventana
        stage.setTitle("Test JavaFX 25");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Arranca JavaFX
    }
}
```

---

# 🚀 Resultado Esperado

Si todo está correctamente configurado:

✅ NetBeans reconocerá JavaFX  
✅ Scene Builder funcionará  
✅ Los proyectos compilarán sin errores  
✅ La ventana JavaFX se abrirá correctamente

---
