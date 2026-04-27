const contador = document.getElementById("contador");
const numero = document.getElementById("numero");

contador.addEventListener("click",
    function() {
        numero.textContent++;
    }
);