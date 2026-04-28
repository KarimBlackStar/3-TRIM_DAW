# 📘 Soluciones en JavaScript (con explicación)

---

## 🔹 1. Invertir un string

💡 Convierte el texto en array, lo invierte y lo vuelve a unir

```javascript
function invertirString(str) {
  return str.split("").reverse().join("");
}

console.log(invertirString("hola")); // "aloh"
```

👉 Paso a paso:
- `split("")` → convierte "hola" en `["h","o","l","a"]`
- `reverse()` → invierte el array
- `join("")` → lo vuelve a convertir en string

---

## 🔹 2. Contar cuántas veces aparece una letra

💡 Recorre el string y cuenta las coincidencias

```javascript
function contarLetra(str, letra) {
  return str.split("").filter(c => c === letra).length;
}

console.log(contarLetra("banana", "a")); // 3
```

👉 Paso a paso:
- `split("")` → separa el texto
- `filter()` → se queda solo con las letras iguales
- `length` → cuenta cuántas hay

---

## 🔹 3. Encontrar el número mayor de un array

💡 Usa una función de JavaScript para encontrar el máximo

```javascript
function numeroMayor(arr) {
  return Math.max(...arr);
}

console.log(numeroMayor([3, 7, 2, 9, 5])); // 9
```

👉 Paso a paso:
- `...arr` → convierte el array en valores sueltos
- `Math.max()` → devuelve el número mayor

---

## 🔹 4. Sumar solo los positivos de un array

💡 Filtra los positivos y luego los suma

```javascript
function sumarPositivos(arr) {
  return arr.filter(n => n > 0).reduce((acc, n) => acc + n, 0);
}

console.log(sumarPositivos([-1, 5, -3, 10, 2])); // 17
```

👉 Paso a paso:
- `filter(n > 0)` → elimina negativos
- `reduce()` → suma todos los valores
- `0` → valor inicial del acumulador

---

## 🔹 5. Método filter

---

### a) Filtrar números pares

💡 Selecciona solo los números divisibles entre 2

```javascript
const numeros = [1, 4, 7, 10, 15, 18, 3, 6, 12, 9];

const pares = numeros.filter(n => n % 2 === 0);

console.log(pares); // [4, 10, 18, 6, 12]
```

👉 Paso a paso:
- `n % 2 === 0` → comprueba si es par
- `filter()` → devuelve solo los que cumplen

---

### b) Filtrar productos con precio mayor a 50

💡 Filtra objetos según una condición

```javascript
const productos = [
  { nombre: "Camisa", precio: 30 },
  { nombre: "Pantalón", precio: 60 },
  { nombre: "Zapatos", precio: 80 },
  { nombre: "Gorra", precio: 20 }
];

const productosCaros = productos.filter(p => p.precio > 50);

console.log(productosCaros);
```

👉 Paso a paso:
- `p.precio > 50` → condición
- `filter()` → devuelve solo los objetos que cumplen

---

## 💡 Conceptos clave usados

- `split()` → convierte string en array  
- `reverse()` → invierte arrays  
- `join()` → convierte array en string  
- `filter()` → filtra elementos  
- `reduce()` → acumula valores  
- `Math.max()` → obtiene el mayor  

---
