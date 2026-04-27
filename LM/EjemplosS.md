# 🧠 Ejercicios JavaScript DOM (Bloque 10)

---

## 🔹 10.1 Crear un enlace

👉 Crear un enlace dinámicamente

```javascript
let enlace = document.createElement("a");
enlace.setAttribute("href", "https://www.google.com");
enlace.textContent = "Ir a Google";

document.body.appendChild(enlace);
```

---

## 🔹 10.2 Crear una imagen

👉 Crear una imagen con atributos

```javascript
let img = document.createElement("img");
img.setAttribute("src", "imagen.jpg");
img.setAttribute("alt", "Imagen de prueba");

document.body.appendChild(img);
```

---

## 🔹 10.3 Crear una estructura HTML

👉 Crear un div con un párrafo dentro

```javascript
let div = document.createElement("div");
div.className = "contenedor";

let p = document.createElement("p");
p.textContent = "Texto dentro del div";

div.appendChild(p);
document.body.appendChild(div);
```

---

## 🔹 10.4 Crear múltiples párrafos

👉 Usar un bucle para generar varios elementos

```javascript
for (let i = 1; i <= 5; i++) {
    let p = document.createElement("p");
    p.textContent = "Párrafo " + i;
    document.body.appendChild(p);
}
```

---

## 🔹 10.5 Crear una lista

👉 Generar una lista dinámica

```javascript
let ul = document.createElement("ul");

for (let i = 1; i <= 3; i++) {
    let li = document.createElement("li");
    li.textContent = "Elemento " + i;
    ul.appendChild(li);
}

document.body.appendChild(ul);
```

---

## 🔹 10.6 Crear una tabla

👉 Crear una tabla con bucles

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

## 🔹 10.7 Crear elementos con clases

👉 Añadir clases dinámicamente

```javascript
let ul = document.createElement("ul");

for (let i = 1; i <= 3; i++) {
    let li = document.createElement("li");
    li.className = "item" + i;
    li.textContent = "Elemento " + i;
    ul.appendChild(li);
}

document.body.appendChild(ul);
```

---
