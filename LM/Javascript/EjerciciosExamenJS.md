# 🧠 Ejercicios JavaScript DOM

---

## 🔹 Ejercicio 1

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ejercicio 1</title>
  <script src="../JS/eje1.js" defer></script>
</head>
<body>

<button id="btn">Pulsa aquí</button>

</body>
</html>
```

```javascript
const btn = document.querySelector('#btn');

btn.addEventListener('click', function() {
    alert("Hola!");
});
```

---

## 🔹 Ejercicio 2

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ejercicio 2</title>
  <script src="../JS/eje2.js" defer></script>
</head>
<body>

<p id="texto">Texto original</p>
<button id="cambiar">Cambiar texto</button>

</body>
</html>
```

```javascript
const cambiar = document.getElementById("cambiar");
const texto = document.getElementById("texto");

cambiar.addEventListener("click", function() {
    texto.textContent = "Texto cambiado";
});
```

---

## 🔹 Ejercicio 5

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ejercicio 5</title>
  <script src="../JS/eje5.js" defer></script>
</head>
<body>

<div id="caja" style="width:100px;height:100px;background:red;"></div>

</body>
</html>
```

```javascript
const caja = document.getElementById("caja");

caja.addEventListener('mouseover', function() {
    caja.style.backgroundColor = "purple";
});

caja.addEventListener('mouseout', function() {
    caja.style.backgroundColor = "greenyellow";
});
```

---

## 🔹 Ejercicio 6

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ejercicio 6</title>
  <script src="../JS/eje6.js" defer></script>
</head>
<body>

<button id="contador">Click</button>
<p id="numero">0</p>

</body>
</html>
```

```javascript
const contador = document.getElementById("contador");
const numero = document.getElementById("numero");

contador.addEventListener("click", function() {
    numero.textContent++;
});
```

---

## 🔹 Ejercicio 7

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ejercicio 7</title>
  <script src="../JS/eje7.js" defer></script>
</head>
<body>

<input type="text" id="texto">
<p id="resultado"></p>

</body>
</html>
```

```javascript
const texto = document.getElementById("texto");
const resultado = document.getElementById("resultado");

texto.addEventListener("input", function() {
    resultado.textContent = texto.value;
});
```

---

## 🔹 Ejercicio 8

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Actividad 8b</title>
  <script src="../JS/eje8.js" defer></script>
</head>
<body>

<input type="text" id="nombre" placeholder="Escribe tu nombre">
<button>Mostrar</button>
<p id="saludo"></p>

</body>
</html>
```

```javascript
const input = document.getElementById("nombre");
const boton = document.querySelector("button");
const saludo = document.getElementById("saludo");

boton.addEventListener("click", function() {
    saludo.textContent = "Hola " + input.value;
});
```

---