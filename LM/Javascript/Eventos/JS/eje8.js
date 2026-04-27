const input = document.getElementById("nombre");
const boton = document.querySelector("button");
const saludo = document.getElementById("saludo");

boton.addEventListener("click",
    function() {
        saludo.textContent = "Hola " + input.value;
    });