# 📘 Resumen JavaScript

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

---

## 1. Interacción y Salida de Datos

**console.log()**
```javascript
console.log("Hola mundo");
```

**alert()**
```javascript
alert("Esto es una alerta");
```

**console.dir()**
```javascript
const obj = { nombre: "Juan", edad: 25 };
console.dir(obj);
```

---

## 2. Variables y Tipos

**let**
```javascript
let edad = 20;
edad = 25;
```

**const**
```javascript
const nombre = "Carlos";
```

**typeof**
```javascript
console.log(typeof 42);
```

---

## 3. Strings

**length**
```javascript
let texto = "Hola";
console.log(texto.length);
```

**toUpperCase()**
```javascript
console.log("hola".toUpperCase());
```

**indexOf()**
```javascript
console.log("hola".indexOf("o"));
```

**trim()**
```javascript
console.log(" hola ".trim());
```

---

## 4. Arrays

**push()**
```javascript
let arr = [1, 2];
arr.push(3);
```

**pop()**
```javascript
arr.pop();
```

**shift()**
```javascript
arr.shift();
```

**unshift()**
```javascript
arr.unshift(0);
```

**sort()**
```javascript
arr.sort();
```

**includes()**
```javascript
arr.includes(2);
```

**concat()**
```javascript
let nuevo = arr.concat([4, 5]);
```

**splice()**
```javascript
arr.splice(1, 1);
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
let mensaje = edad >= 18 ? "Mayor" : "Menor";
```

```javascript
switch(dia) {
  case 1:
    console.log("Lunes");
    break;
  default:
    console.log("Otro día");
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
const suma = (a, b) => a + b;
```

---

## 7. Bucles

```javascript
for (let i = 0; i < 5; i++) {
  console.log(i);
}
```

```javascript
for (let valor of [1,2,3]) {
  console.log(valor);
}
```

```javascript
[1,2,3].forEach(num => console.log(num));
```

```javascript
let i = 0;
while (i < 5) {
  console.log(i);
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

console.log(persona.nombre);
```

---

## 9. DOM

**Selección**
```javascript
document.getElementById("id");
document.querySelector(".clase");
```

**Modificar**
```javascript
element.innerText = "Texto";
element.innerHTML = "<b>HTML</b>";
```

**Estilos**
```javascript
element.style.color = "red";
```

---

## 10. Eventos

```javascript
document.addEventListener("click", () => {
  console.log("Click");
});
```

---

## 💡 Tips (importante para DAW)

- `const` no significa inmutable (en objetos/arrays)
- `==` vs `===` → usa siempre `===`
- `forEach` no rompe (no usar con `break`)
- `innerHTML` puede ser peligroso (XSS)

---