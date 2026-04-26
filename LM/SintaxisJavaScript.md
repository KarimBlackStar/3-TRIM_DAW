# 📘 Resumen JavaScript (Completo)

---

## 🧾 Índice
- Interacción y salida
- Variables y tipos
- Strings
- Arrays
- Condicionales
- Funciones
- Bucles
- Objetos
- DOM
- Eventos
- BOM
- Creación dinámica

---

## 1. Interacción y Salida de Datos

**console.log()** → Muestra información en la consola (debug)
```javascript
console.log("Hola mundo");
```

**alert()** → Muestra una ventana emergente
```javascript
alert("Esto es una alerta");
```

**console.dir()** → Muestra un objeto con todas sus propiedades
```javascript
console.dir({nombre: "Juan"});
```

**prompt()** → Pide datos al usuario
```javascript
let nombre = prompt("Tu nombre:");
```

**confirm()** → Devuelve true/false según la respuesta
```javascript
let ok = confirm("¿Seguro?");
```

---

## 2. Variables y Tipos

**let** → Variable modificable
```javascript
let edad = 20;
```

**const** → No se puede reasignar
```javascript
const nombre = "Ana";
```

**typeof** → Devuelve el tipo de dato
```javascript
console.log(typeof 42);
```

**Number()** → Convierte texto a número
```javascript
let n = Number("123");
```

---

## 3. Strings

**length** → Longitud del texto
```javascript
"Hola".length;
```

**toUpperCase()** → Convierte a mayúsculas
```javascript
"hola".toUpperCase();
```

**indexOf()** → Posición de un carácter
```javascript
"hola".indexOf("o");
```

**trim()** → Elimina espacios
```javascript
" hola ".trim();
```

---

## 4. Arrays

**push()** → Añade al final
```javascript
arr.push(3);
```

**pop()** → Elimina el último
```javascript
arr.pop();
```

**shift()** → Elimina el primero
```javascript
arr.shift();
```

**unshift()** → Añade al inicio
```javascript
arr.unshift(1);
```

**sort()** → Ordena el array
```javascript
arr.sort();
```

**includes()** → Comprueba si existe un valor
```javascript
arr.includes(2);
```

**concat()** → Une arrays
```javascript
arr.concat([4,5]);
```

**splice()** → Añade o elimina elementos en una posición
```javascript
arr.splice(1,1);
```

**indexOf() / lastIndexOf()** → Busca posiciones
```javascript
arr.indexOf(2);
arr.lastIndexOf(2);
```

---

## 5. Condicionales

**if / else** → Ejecuta código según condición
```javascript
if (edad >= 18) {
  console.log("Mayor");
} else {
  console.log("Menor");
}
```

**Operador ternario** → Versión corta de if/else
```javascript
let msg = edad >= 18 ? "Mayor" : "Menor";
```

**switch** → Evalúa múltiples casos
```javascript
switch(dia) {
  case 1:
    console.log("Lunes");
    break;
  default:
    console.log("Otro");
}
```

---

## 6. Funciones

**function** → Define una función
```javascript
function saludar() {
  console.log("Hola");
}
```

**return** → Devuelve un valor
```javascript
function suma(a, b) {
  return a + b;
}
```

**Arrow function** → Forma corta
```javascript
const suma = (a,b) => a + b;
```

---

## 7. Bucles

**for** → Repite un número de veces
```javascript
for (let i = 0; i < 5; i++) {
  console.log(i);
}
```

**for...of** → Recorre valores
```javascript
for (let x of [1,2,3]) {
  console.log(x);
}
```

**forEach()** → Ejecuta función por elemento
```javascript
[1,2].forEach(n => console.log(n));
```

**while** → Repite mientras se cumpla condición
```javascript
while (i < 5) {
  i++;
}
```

---

## 8. Objetos

→ Estructura clave-valor
```javascript
const persona = {
  nombre: "Ana",
  edad: 30
};

persona.nombre;
persona["edad"];
```

---

## 9. DOM (Selección)

👉 Permite acceder a elementos HTML

**getElementById()** → Selecciona por ID (rápido)
```javascript
document.getElementById("id");
```

**getElementsByClassName()** → Devuelve varios elementos
```javascript
document.getElementsByClassName("clase");
```

**getElementsByTagName()** → Por etiqueta
```javascript
document.getElementsByTagName("p");
```

**querySelector()** → Primer elemento que coincida con CSS
```javascript
document.querySelector(".clase");
```

**querySelectorAll()** → Todos los que coincidan
```javascript
document.querySelectorAll("p");
```

💡 Diferencia clave:
- `getElementById` → más rápido, pero limitado a ID
- `querySelector` → más flexible (usa CSS), pero más general

---

## 10. DOM (Contenido y atributos)

**innerText / textContent** → Cambiar texto
```javascript
element.innerText = "Texto";
```

**innerHTML** → Insertar HTML
```javascript
element.innerHTML = "<b>HTML</b>";
```

**getAttribute / setAttribute** → Leer/modificar atributos
```javascript
element.setAttribute("src", "img.png");
```

**Propiedades directas**
```javascript
element.value;
element.src;
element.href;
```

---

## 11. DOM (Estilos y clases)

**style** → Modificar CSS
```javascript
element.style.color = "red";
```

**classList** → Gestionar clases
```javascript
element.classList.add("activo");
element.classList.toggle("activo");
```

---

## 12. DOM (Estructura)

**parentElement / children**
```javascript
element.parentElement;
element.children;
```

**createElement / appendChild / remove**
```javascript
let div = document.createElement("div");
document.body.appendChild(div);
div.remove();
```

---

## 13. Eventos

→ Detectan acciones del usuario

```javascript
element.addEventListener("click", () => {
  console.log("Click");
});
```

---

## 14. BOM

→ Interacción con el navegador

```javascript
console.log(window);
console.log(window.location);
```

**Redirección**
```javascript
window.location.href = "https://example.com";
```

---

## 15. Creación dinámica

→ Crear HTML desde JavaScript

**Enlace**
```javascript
let a = document.createElement("a");
a.setAttribute("href", "https://example.com");
a.innerText = "Ir";
document.body.appendChild(a);
```

**Imagen**
```javascript
let img = document.createElement("img");
img.setAttribute("src", "img.jpg");
img.setAttribute("alt", "Imagen");
document.body.appendChild(img);
```

**Estructura**
```javascript
let div = document.createElement("div");
let p = document.createElement("p");
p.textContent = "Texto";
div.appendChild(p);
document.body.appendChild(div);
```

---

## 💡 Tips

- Usa siempre `===`
- `const` no hace inmutables los objetos
- `querySelector` = flexible
- `getElementById` = rápido
- DOM + eventos = lo más importante

---
