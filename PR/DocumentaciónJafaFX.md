# 🛠️ Guía de Configuración: JavaFX en NetBeans (PC Local)

Esta guía resume los pasos necesarios para configurar el entorno de desarrollo de JavaFX 25 utilizando el JDK 23.

---

## 1. Instalación del Motor (JDK)

Desde el JDK 11, JavaFX no está incluido por defecto en Java.

- **Versión instalada:** JDK 23
- **Ruta de instalación:**  
  ```text
  C:\Program Files\Java\jdk-23
  ```

### 🔧 Configuración de NetBeans

Se modificó el archivo `netbeans.conf` para que el IDE use este JDK.

- **Ruta del archivo:**  
  ```text
  C:\Program Files\NetBeans-23\netbeans\etc\netbeans.conf
  ```

- **Línea clave:**  
  ```text
  netbeans_jdkhome="C:\Program Files\Java\jdk-23"
  ```

> ⚠️ **IMPORTANTE:**  
> Para guardar cambios en este archivo, debes abrir el Bloc de Notas como **Administrador**.

---

## 2. Ubicación del SDK de JavaFX

- **Versión utilizada:** JavaFX SDK 25.0.3
- **Ruta permanente:**  
  ```text
  C:\Program Files\Java\javafx-sdk-25.0.3
  ```

### 📁 Carpeta importante

La subcarpeta `lib` contiene todos los archivos `.jar` necesarios para ejecutar JavaFX.

---

## 3. Registro de Librería Global en NetBeans

Para que NetBeans reconozca JavaFX en cualquier proyecto:

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

4. En la pestaña **Classpath**, añadir todos los `.jar` de:

   ```text
   C:\Program Files\Java\javafx-sdk-25.0.3\lib
   ```

---

## 4. Configuración del Scene Builder

Scene Builder permite diseñar interfaces JavaFX visualmente mediante archivos FXML.

### 🔌 Activar el plugin JavaFX

Ir a:

```text
Tools > Plugins > Installed
```

Y activar:

```text
JavaFX 2
```

---

### 🎨 Vincular Scene Builder

Ir a:

```text
Tools > Options > Java > JavaFX
```

En el campo **Scene Builder Home**, seleccionar la carpeta donde está instalado Scene Builder.

---

## 5. Check-list para Ejecutar Proyectos JavaFX

Cada vez que crees un proyecto nuevo, revisa estas configuraciones en:

```text
Properties
```

---

### ✅ 1. Libraries

En:

```text
Libraries > Compile
```

Añadir la librería:

```text
JavaFX25
```

---

### ✅ 2. Compiling

Desactivar:

```text
Compile on Save
```

> ⚠️ Esto evita errores relacionados con el bloqueo de módulos.

---

### ✅ 3. Run → VM Options

En:

```text
Run > VM Options
```

Pegar:

```text
--module-path "C:\Program Files\Java\javafx-sdk-25.0.3\lib" --add-modules javafx.controls,javafx.fxml
```

---

# 🚀 Resultado Final

Con esta configuración podrás:

- Crear proyectos JavaFX en NetBeans
- Diseñar interfaces con Scene Builder
- Ejecutar aplicaciones JavaFX correctamente
- Evitar errores típicos de módulos (`javafx.controls not found`)

---
