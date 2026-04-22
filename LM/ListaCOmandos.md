# 📄 Guía rápida de JavaScript DOM

## 🔗 Creación de atributos
document.createAttribute("href")

## 🏷️ Asignar atributos
element.setAttribute("src", "url")
element.setAttribute("alt", "texto")

## 🧱 Crear elementos HTML
document.createElement("div")
document.createElement("p")
document.createElement("img")
document.createElement("ul")
document.createElement("li")
document.createElement("table")
document.createElement("tr")
document.createElement("td")

## 📝 Añadir texto
element.textContent = "Texto"

## 📦 Insertar elementos en el DOM
document.body.appendChild(element)
parent.appendChild(child)

## 🧩 Clases CSS
element.classList.add("clase")

## 🆔 IDs
element.id = "app"

## 🔁 Bucles para generar contenido
for (let i = 0; i < 5; i++) {
  // crear elementos dinámicamente
}

## 📋 Listas dinámicas
const ul = document.createElement("ul")
const li = document.createElement("li")

## 🎨 Estilos en línea
element.style.border = "1px solid black"
element.style.padding = "5px"

## 🔄 Clases dinámicas
element.classList.add("item" + i)