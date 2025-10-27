/*// setTimeout
setTimeout( () => console.log("han pasado 3 segundos"), 3000 );
clearTimeout(timeout);

// setInterval
let segundos = 0;
intervalo = setInterval( () => {
    segundos++;
    console.log(`han pasado ${segundos} segundos`);
}, 1000 );

clearInterval(intervalo);
*/
const compteEnrere = document.getElementById('compte-enrere');
const tempsTranscorregut = document.getElementById('temps-transcorregut');
const btnInici = document.getElementById('inici');
const anell = document.getElementById('anell');
const missatge = document.getElementById('missatge');
const areaDeJoc = document.getElementById('area-joc');
let compteEnrereValor = 10;
let tempsTranscorregutValor = 0;
let CompteEnrereInterval;
let TempsTranscorregutInterval;

function iniciarJoc() {
    
    if (btnInici.disabled) return;
    btnInici.disabled = true;
    missatge.textContent = "";
    compteEnrereValor = 10;
    tempsTranscorregutValor = 0;
    mostrarAnell();
    compteEnrere.textContent = `Temps restant: ${compteEnrereValor} s`;
    CompteEnrereInterval = setInterval( () => {
        compteEnrereValor--;
        compteEnrere.textContent = `Temps restant: ${compteEnrereValor} s`;
        if (compteEnrereValor <= 0) {
            finalJoc(false);
        }
    }, 1000 );

    tempsTranscorregut.textContent = `Temps transcorregut: ${tempsTranscorregutValor} s`;
    TempsTranscorregutInterval = setInterval( () => {
        tempsTranscorregutValor++;
        tempsTranscorregut.textContent = `Temps transcorregut: ${tempsTranscorregutValor} s`;
    }, 1000 );

    anell.style.display = 'block';
}

function mostrarAnell() {
    const maxX = areaDeJoc.clientWidth - anell.offsetWidth;
    const maxY = areaDeJoc.clientHeight - anell.offsetHeight;
    const randomX = Math.floor(Math.random() * (maxX + 1));
    const randomY = Math.floor(Math.random() * (maxY + 1));
    anell.style.left = `${randomX}px`;
    anell.style.top = `${randomY}px`;
}

function finalJoc(esGanador) {
    clearInterval(CompteEnrereInterval);
    clearInterval(TempsTranscorregutInterval);
    
    btnInici.disabled = false;
    anell.style.display = 'none';
    removeEventListener('click', rescataAnell);
    if (esGanador) {
        missatge.textContent = `Has rescatat l'anell en ${tempsTranscorregutValor} segons!`;
    } else {
        missatge.textContent = `No has rescatat l'anell a temps. Has durat ${tempsTranscorregutValor} segons.`;
    }
}

function rescataAnell() {
    finalJoc(true);
}   

btnInici.addEventListener('click', iniciarJoc);
