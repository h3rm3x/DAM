/* CARACTERÍSTIQUES:
- Guarda informació de les URL visitades per l'usuari dins d'una finestra de l'explorador.
- No hi ha un estàndard públic però la majoria dels navegadors suporten aquest objecte. */

//PROPIETATS DEL OBJECTE HISTORY
//length: nombre d'URL en l'historial de la pàgina.
alert("URLs de l'historial: "+history.length);

//MÈTODES DE L'OBJECTE HISTORY
//back: carrega la URL anterior en l'historial
function enrere(){
  history.back();
}

//forward: carregar la URL següent en l'historial
function endavant(){
  history.forward();
}

/* go(<nombre|url>): va a una pàgina concreta de l'historial.
- Si indiquem un nombre positiu va cap al davant un nombre de pàgines
- Si indiquem un nombre negatiu va cap enrere un nombre de pàgines
- Si indiquem una URL o part d'ella va a la url en concret. */
function anar(){
  var nombre = prompt("Indica un nombre per moure't en l'historial");
  history.go(nombre);
}