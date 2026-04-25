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

**console.log()** → Muestra información en la consola (para depurar)
```javascript
console.log("Hola mundo");
```

**alert()** → Muestra una ventana emergente al usuario
```javascript
alert("Esto es una alerta");
```

**console.dir()** → Muestra un objeto con todas sus propiedades
```javascript
const obj = { nombre: "Juan", edad: 25 };
console.dir(obj);
```

---

## 2. Variables y Tipos

**let** → Variable que puede cambiar
```javascript
let edad = 20;
edad = 25;
```

**const** → Variable que no se puede reasignar
```javascript
const nombre = "Carlos";
```

**typeof** → Devuelve el tipo de dato
```javascript
console.log(typeof 42);
```

---

## 3. Strings

**length** → Devuelve la longitud del texto
```javascript
let texto = "Hola";
console.log(texto.length);
```

**toUpperCase()** → Convierte a mayúsculas
```javascript
console.log("hola".toUpperCase());
```

**indexOf()** → Devuelve la posición de un carácter
```javascript
console.log("hola".indexOf("o"));
```

**trim()** → Elimina espacios al inicio y final
```javascript
console.log(" hola ".trim());
```

---

## 4. Arrays

**push()** → Añade elemento al final
```javascript
let arr = [1, 2];
arr.push(3);
```

**pop()** → Elimina el último elemento
```javascript
arr.pop();
```

**shift()** → Elimina el primero
```javascript
arr.shift();
```

**unshift()** → Añade al inicio
```javascript
arr.unshift(0);
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
let nuevo = arr.concat([4, 5]);
```

**splice()** → Añade o elimina elementos en una posición
```javascript
arr.splice(1, 1);
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
let mensaje = edad >= 18 ? "Mayor" : "Menor";
```

**switch** → Evalúa múltiples casos
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

**Arrow function** → Forma corta de función
```javascript
const suma = (a, b) => a + b;
```

---

## 7. Bucles

**for** → Repite un bloque un número de veces
```javascript
for (let i = 0; i < 5; i++) {
  console.log(i);
}
```

**for...of** → Recorre valores de un array
```javascript
for (let valor of [1,2,3]) {
  console.log(valor);
}
```

**forEach()** → Ejecuta una función por cada elemento
```javascript
[1,2,3].forEach(num => console.log(num));
```

**while** → Repite mientras se cumpla una condición
```javascript
let i = 0;
while (i < 5) {
  console.log(i);
  i++;
}
```

---

## 8. Objetos

→ Estructura para guardar datos en clave-valor
```javascript
const persona = {
  nombre: "Ana",
  edad: 30
};

console.log(persona.nombre);
```

---

## 9. DOM

**Selección** → Buscar elementos en HTML
```javascript
document.getElementById("id");
document.querySelector(".clase");
```

**Modificar** → Cambiar contenido
```javascript
element.innerText = "Texto";
element.innerHTML = "<b>HTML</b>";
```

**Estilos** → Cambiar CSS
```javascript
element.style.color = "red";
```

---

## 10. Eventos

→ Detecta acciones del usuario (click, teclado, etc.)
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
