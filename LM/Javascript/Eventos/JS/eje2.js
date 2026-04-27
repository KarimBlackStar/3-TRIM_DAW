const cambiar = document.getElementById("cambiar");
const texto = document.getElementById("texto");
cambiar.addEventListener("click",
    function() {
    texto.textContent = "Texto cambiado";
    });