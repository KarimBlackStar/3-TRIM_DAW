# 📘 JavaScript DOM — Ejercicios y Apuntes

---

## 🔹 1. Selección de elementos

```javascript
let elemento = document.getElementById("miId");
console.log(elemento);
```

```javascript
let elementos = document.getElementsByClassName("miClase");
console.log(elementos);
```

```javascript
let elementos = document.getElementsByTagName("p");
console.log(elementos);
```

```javascript
let elemento = document.querySelector("#miId");
console.log(elemento);
```

```javascript
let elementos = document.querySelectorAll(".miClase");
console.log(elementos);
```

---

## 🔹 2. Modificar contenido

```javascript
elemento.innerHTML = "Nuevo contenido";
```

```javascript
elemento.textContent = "Nuevo texto";
```

---

## 🔹 3. Modificar atributos

```javascript
elemento.setAttribute("href", "https://www.google.com");
```

```javascript
let valor = elemento.getAttribute("href");
```

---

## 🔹 4. Manipulación de estilos

```javascript
elemento.style.color = "red";
```

```javascript
elemento.style.backgroundColor = "yellow";
```

---

## 🔹 5. Clases

```javascript
elemento.classList.add("clase");
```

```javascript
elemento.classList.remove("clase");
```

```javascript
elemento.classList.toggle("clase");
```

---

## 🔹 6. Eventos

```javascript
elemento.addEventListener("click", function() {
    console.log("Click en el elemento");
});
```

---

## 🔹 7. Creación de elementos

```javascript
let nuevo = document.createElement("p");
nuevo.textContent = "Hola mundo";
document.body.appendChild(nuevo);
```

---

## 🔹 8. Eliminación de elementos

```javascript
elemento.remove();
```

---

## 🔹 9. Navegación en el DOM

```javascript
elemento.parentElement;
elemento.children;
elemento.firstElementChild;
elemento.lastElementChild;
```

---

## 🔹 10. Ejercicio 1

👉 Cambiar el texto de un elemento con id "titulo"

```javascript
let titulo = document.getElementById("titulo");
titulo.textContent = "Nuevo título";
```

---

## 🔹 11. Ejercicio 2

👉 Cambiar el color de todos los párrafos

```javascript
let parrafos = document.querySelectorAll("p");

parrafos.forEach(p => {
    p.style.color = "blue";
});
```

---

## 🔹 12. Ejercicio 3

👉 Añadir un nuevo elemento a la página

```javascript
let nuevo = document.createElement("div");
nuevo.textContent = "Elemento añadido";
document.body.appendChild(nuevo);
```

---

## 🔹 13. Ejercicio 4

👉 Eliminar un elemento con id "eliminar"

```javascript
let el = document.getElementById("eliminar");
el.remove();
```

---

## 🔹 14. Ejercicio 5

👉 Crear una lista dinámica

```javascript
let ul = document.createElement("ul");

for (let i = 1; i <= 5; i++) {
    let li = document.createElement("li");
    li.textContent = "Elemento " + i;
    ul.appendChild(li);
}

document.body.appendChild(ul);
```

---

## 🔹 15. Ejercicio 6

👉 Crear una tabla dinámica

```javascript
let table = document.createElement("table");

for (let i = 0; i < 3; i++) {
    let tr = document.createElement("tr");

    for (let j = 0; j < 3; j++) {
        let td = document.createElement("td");
        td.textContent = i + "," + j;
        tr.appendChild(td);
    }

    table.appendChild(tr);
}

document.body.appendChild(table);
```

---

## 💡 Notas importantes

- `querySelector` usa selectores CSS
- `getElementById` es más rápido pero menos flexible
- `innerHTML` permite HTML, `textContent` solo texto
- `classList` es la forma correcta de manejar clases
- DOM + eventos = base del desarrollo web

---