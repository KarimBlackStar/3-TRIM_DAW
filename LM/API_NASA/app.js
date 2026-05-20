const API_KEY = '3iIph3aytC58ONOThZNrq8glxnPHb6bD0MIDwtgT'; 

const apodTitulo = document.getElementById('apod-titulo');
const apodMedia = document.getElementById('apod-media');
const apodDescripcion = document.getElementById('apod-descripcion');
const inputFecha = document.getElementById('fecha-buscar');
const btnBuscar = document.getElementById('btn-buscar');

function cargarAPOD(fecha = '') {
    let url = `https://api.nasa.gov/planetary/apod?api_key=${API_KEY}`;
    if (fecha) {
        url += `&date=${fecha}`;
    }

    apodTitulo.textContent = "Buscando en el espacio...";
    apodMedia.innerHTML = "";
    apodDescripcion.textContent = "";

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la API');
            }
            return response.json();
        })
        .then(data => {
            apodTitulo.textContent = data.title;
            apodDescripcion.textContent = data.explanation;

            if (data.media_type === 'image') {
                apodMedia.innerHTML = `<img src="${data.url}" alt="${data.title}">`;
            } else if (data.media_type === 'video') {
                apodMedia.innerHTML = `<iframe src="${data.url}" allowfullscreen></iframe>`;
            }
        })
        .catch(error => {
            console.error(error);
            apodTitulo.textContent = "Error al cargar los datos.";
            apodDescripcion.textContent = "Verifica tu API Key o que la fecha no sea futura.";
        });
}

btnBuscar.addEventListener('click', () => {
    const fechaSeleccionada = inputFecha.value;
    if (fechaSeleccionada) {
        cargarAPOD(fechaSeleccionada);
    } else {
        alert("Selecciona una fecha primero.");
    }
});

cargarAPOD();