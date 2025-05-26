/* CARACTERÍSTIQUES:
- Conté la informació de la finestra del visitant.
- No hi ha un estàndard públic però la majoria dels navegadors suporten Screen */

//PROPIETATS DEL OBJECTE SCREEN
let text = "";

//Mida pantalla
text += "<br/>Ample: "+screen.width; 
text += "<br/>Alt: "+screen.height;

//Mida pantalla sense barra de tasques
text += "<br/>Ample sense barra: "+screen.availWidth; 
text += "<br/>Alt sense barra: "+screen.availHeight;

//Profunditat de color de la pantalla
text += "<br/>Profunditat: "+screen.colorDepth; 

//Resolució de color en bits per píxel
text += "<br/>Resolució: "+screen.pixelDepth;

document.getElementById("pantalla").innerHTML = text;
