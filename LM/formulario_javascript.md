# Diseño de un Formulario en JavaScript

## 1. Estructura básica (HTML)

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Formulario de Registro</title>
</head>
<body>

<form id="miFormulario">
  <label>Nombre:</label>
  <input type="text" id="nombre" required />

  <label>Email:</label>
  <input type="email" id="email" required />

  <label>Contraseña:</label>
  <input type="password" id="password" required />

  <button type="submit">Enviar</button>
</form>

<p id="mensaje"></p>

<script src="app.js"></script>
</body>
</html>
```

---

## 2. Lógica en JavaScript

```javascript
const formulario = document.getElementById("miFormulario");
const mensaje = document.getElementById("mensaje");

formulario.addEventListener("submit", function(e) {
  e.preventDefault();

  const nombre = document.getElementById("nombre").value.trim();
  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value.trim();

  if (!nombre || !email || !password) {
    mensaje.textContent = "Todos los campos son obligatorios";
    mensaje.style.color = "red";
    return;
  }

  if (password.length < 6) {
    mensaje.textContent = "La contraseña debe tener al menos 6 caracteres";
    mensaje.style.color = "red";
    return;
  }

  mensaje.textContent = "Formulario enviado correctamente";
  mensaje.style.color = "green";
});
```

---

## 3. Mejoras que implementaría

### 🔹 Validación avanzada
- Validar formato de email con regex
- Validar fortaleza de contraseña (mayúsculas, números, símbolos)

### 🔹 UX (Experiencia de usuario)
- Mostrar errores debajo de cada campo
- Validación en tiempo real (oninput)
- Indicador visual de campos válidos/inválidos

### 🔹 Seguridad
- No confiar solo en validación del frontend
- Sanitizar inputs
- Enviar datos mediante HTTPS

### 🔹 Accesibilidad
- Añadir atributos `aria-*`
- Asociar correctamente `label` con `input`

### 🔹 Diseño (CSS)
- Inputs con estados: focus, error, success
- Botón deshabilitado hasta que el formulario sea válido

---

## 4. Ejemplo de mejora: Validación en tiempo real

```javascript
const emailInput = document.getElementById("email");

emailInput.addEventListener("input", () => {
  const email = emailInput.value;
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

  if (!regex.test(email)) {
    emailInput.style.border = "2px solid red";
  } else {
    emailInput.style.border = "2px solid green";
  }
});
```

---

## 5. Posibles extensiones

- Conectar con backend (Node.js / API REST)
- Guardar datos en base de datos
- Añadir autenticación
- Integrar librerías como Formik o React Hook Form (si usas React)

---

## Conclusión

Un formulario básico en JavaScript funciona, pero las mejoras en validación, seguridad y experiencia de usuario son clave para hacerlo profesional y usable.
