const caja = document.getElementById("caja");

caja.addEventListener('mouseover',
    function() {
        caja.style.backgroundColor = "purple";
    }
);

caja.addEventListener('mouseout',
    function() {
        caja.style.backgroundColor = "greenyellow";
    }
);