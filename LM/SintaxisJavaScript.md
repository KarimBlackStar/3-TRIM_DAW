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
- DOM (básico y avanzado)
- Eventos
- BOM
- Creación dinámica (IMPORTANTE)

---

## 1. Interacción y Salida de Datos

**console.log()** → Muestra información en la consola  
```javascript
console.log("Hola mundo");
```

**alert()** → Ventana emergente  
```javascript
alert("Esto es una alerta");
```

**console.dir()** → Ver estructura de objetos  
```javascript
console.dir({nombre: "Juan"});
```

**prompt()** → Pide datos al usuario  
```javascript
let nombre = prompt("Tu nombre:");
```

**confirm()** → Pregunta (true/false)  
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

**typeof** → Tipo de dato  
```javascript
console.log(typeof "Hola");
```

**Number()** → Convierte a número  
```javascript
let n = Number("123");
```

---

## 3. Strings

**length** → Longitud  
```javascript
"Hola".length;
```

**toUpperCase()** → Mayúsculas  
```javascript
"hola".toUpperCase();
```

**indexOf()** → Posición  
```javascript
"hola".indexOf("o");
```

**trim()** → Quita espacios  
```javascript
" hola ".trim();
```

---

## 4. Arrays

**push()** → Añade al final  
```javascript
arr.push(3);
```

**pop()** → Quita último  
```javascript
arr.pop();
```

**shift()** → Quita primero  
```javascript
arr.shift();
```

**unshift()** → Añade al inicio  
```javascript
arr.unshift(1);
```

**sort()** → Ordena  
```javascript
arr.sort();
```

**includes()** → Comprueba valor  
```javascript
arr.includes(2);
```

**concat()** → Une arrays  
```javascript
arr.concat([4,5]);
```

**splice()** → Modifica posiciones  
```javascript
arr.splice(1,1);
```

**indexOf() / lastIndexOf()** → Buscar posición  
```javascript
arr.indexOf(2);
arr.lastIndexOf(2);
```

---

## 5. Condicionales

```javascript
if (edad >= 18) {
  console.log("Mayor");
} else {
  console.log("Menor");
}
```

```javascript
let msg = edad >= 18 ? "Mayor" : "Menor";
```

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

```javascript
function saludar() {
  console.log("Hola");
}
```

```javascript
function suma(a, b) {
  return a + b;
}
```

```javascript
const suma = (a,b) => a + b;
```

---

## 7. Bucles

```javascript
for (let i = 0; i < 5; i++) {
  console.log(i);
}
```

```javascript
for (let x of [1,2,3]) {
  console.log(x);
}
```

```javascript
[1,2].forEach(n => console.log(n));
```

```javascript
while (i < 5) {
  i++;
}
```

---

## 8. Objetos

```javascript
const persona = {
  nombre: "Ana",
  edad: 30
};

persona.nombre;
persona["edad"];
```

---

## 9. DOM (Básico)

**Selección**
```javascript
document.getElementById("id");
document.getElementsByClassName("clase");
document.getElementsByTagName("p");
document.querySelector(".clase");
document.querySelectorAll("p");
```

**Contenido**
```javascript
element.innerText = "Texto";
element.textContent = "Texto";
element.innerHTML = "<b>HTML</b>";
```

---

## 10. DOM (Atributos y estilos)

**Atributos**
```javascript
element.getAttribute("src");
element.setAttribute("src", "img.png");
```

**Propiedades**
```javascript
element.value;
element.src;
element.href;
```

**Estilos**
```javascript
element.style.color = "red";
```

**Clases**
```javascript
element.classList.add("activo");
element.classList.toggle("activo");
```

---

## 11. DOM (Estructura y nodos)

```javascript
element.parentElement;
element.children;
```

```javascript
const div = document.createElement("div");
document.body.appendChild(div);
div.remove();
```

---

## 12. Eventos

```javascript
element.addEventListener("click", () => {
  console.log("Click");
});
```

---

## 13. BOM

```javascript
console.log(window);
console.log(window.location);
```

---

## 14. Creación dinámica (MUY IMPORTANTE)

👉 Esto es lo que más entra en ejercicios del PDF

**Crear enlace**
```javascript
let a = document.createElement("a");
a.setAttribute("href", "https://example.com");
a.innerText = "Ir a página";
document.body.appendChild(a);
```

---

**Crear imagen**
```javascript
let img = document.createElement("img");
img.setAttribute("src", "imagen.jpg");
img.setAttribute("alt", "Imagen de prueba");
document.body.appendChild(img);
```

---

**Crear estructura HTML**
```javascript
let div = document.createElement("div");
div.className = "caja";

let p = document.createElement("p");
p.textContent = "Contenido interno";

div.appendChild(p);
document.body.appendChild(div);
```

---

**Crear elementos con bucle**
```javascript
for (let i = 1; i <= 5; i++) {
  let p = document.createElement("p");
  p.textContent = `Párrafo ${i}`;
  document.body.appendChild(p);
}
```

---

**Lista dinámica**
```javascript
let ul = document.createElement("ul");

for (let i = 1; i <= 3; i++) {
  let li = document.createElement("li");
  li.className = `item${i}`;
  li.textContent = `Elemento ${i}`;
  ul.appendChild(li);
}

document.body.appendChild(ul);
```

---

**Tabla dinámica**
```javascript
let table = document.createElement("table");

for (let i = 0; i < 3; i++) {
  let tr = document.createElement("tr");

  for (let j = 0; j < 3; j++) {
    let td = document.createElement("td");
    td.textContent = `${i},${j}`;
    tr.appendChild(td);
  }

  table.appendChild(tr);
}

document.body.appendChild(table);
```

---

## 💡 Tips (DAW)

- Usa siempre `===`
- `const` en arrays/objetos sí permite modificar contenido
- `innerHTML` puede ser peligroso (XSS)
- DOM + eventos = lo más importante del curso

---
