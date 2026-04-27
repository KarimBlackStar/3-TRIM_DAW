const texto = document.getElementById("texto");
const resultado = document.getElementById("resultado");

texto.addEventListener("input",
    function() {
        resultado.textContent = texto.value;
    }
);