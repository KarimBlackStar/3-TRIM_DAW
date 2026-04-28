# Soluciones en JavaScript

## 1. Invertir un string
```javascript
function invertirString(str) {
  return str.split("").reverse().join("");
}

console.log(invertirString("hola")); // "aloh"
```

## 2. Contar cuántas veces aparece una letra
```javascript
function contarLetra(str, letra) {
  return str.split("").filter(c => c === letra).length;
}

console.log(contarLetra("banana", "a")); // 3
```

## 3. Encontrar el número mayor de un array
```javascript
function numeroMayor(arr) {
  return Math.max(...arr);
}

console.log(numeroMayor([3, 7, 2, 9, 5])); // 9
```

## 4. Sumar solo los positivos de un array
```javascript
function sumarPositivos(arr) {
  return arr.filter(n => n > 0).reduce((acc, n) => acc + n, 0);
}

console.log(sumarPositivos([-1, 5, -3, 10, 2])); // 17
```

## 5. Método filter

### a) Filtrar números pares
```javascript
const numeros = [1, 4, 7, 10, 15, 18, 3, 6, 12, 9];

const pares = numeros.filter(n => n % 2 === 0);

console.log(pares); // [4, 10, 18, 6, 12]
```

### b) Filtrar productos con precio mayor a 50
```javascript
const productos = [
  { nombre: "Camisa", precio: 30 },
  { nombre: "Pantalón", precio: 60 },
  { nombre: "Zapatos", precio: 80 },
  { nombre: "Gorra", precio: 20 }
];

const productosCaros = productos.filter(p => p.precio > 50);

console.log(productosCaros);
// [
//   { nombre: "Pantalón", precio: 60 },
//   { nombre: "Zapatos", precio: 80 }
// ]
```
