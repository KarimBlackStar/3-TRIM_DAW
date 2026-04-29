# Formulario dinámico con JavaScript

Este ejemplo muestra cómo crear un formulario dinámicamente usando
`createElement` y `appendChild`.

``` html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario dinámico</title>
</head>
<body>

<h2>Formulario generado con JavaScript</h2>
<div id="contenedor"></div>

<script>
// Crear elementos
const contenedor = document.getElementById("contenedor");

const form = document.createElement("form");

const labelNombre = document.createElement("label");
labelNombre.textContent = "Nombre: ";

const inputNombre = document.createElement("input");
inputNombre.type = "text";
inputNombre.name = "nombre";

const salto1 = document.createElement("br");

const labelEmail = document.createElement("label");
labelEmail.textContent = "Email: ";

const inputEmail = document.createElement("input");
inputEmail.type = "email";
inputEmail.name = "email";

const salto2 = document.createElement("br");

const boton = document.createElement("button");
boton.type = "submit";
boton.textContent = "Enviar";

// AppendChild
form.appendChild(labelNombre);
form.appendChild(inputNombre);
form.appendChild(salto1);

form.appendChild(labelEmail);
form.appendChild(inputEmail);
form.appendChild(salto2);

form.appendChild(boton);

contenedor.appendChild(form);

// Evento submit
form.addEventListener("submit", function(e) {
    e.preventDefault();
    alert("Formulario enviado");
});
</script>

</body>
</html>
```
