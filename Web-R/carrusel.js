let index = 0;
function mostrarSlide() {
const slides = document.querySelectorAll('.slide');
index++;

if (index >= slides.length) {
index = 0;
}
const carrusel = document.querySelector('.carrusel');
carrusel.style.transform = `translateX(-${index * 100}%)`;
}
setInterval(mostrarSlide, 3000); // Cambia cada 3 segundos