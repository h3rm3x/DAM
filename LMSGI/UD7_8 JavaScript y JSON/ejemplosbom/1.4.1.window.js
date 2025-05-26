//PROPIETATS BÀSIQUES DE WINDOW
window.name = "La meva finestra";
let text = "";
//Nom de la finestra
text += "<br/>Nom: "+window.name;
//Mida de la finestra amb toolbar i scrollbar
text += "<br/>Ample extern: "+window.outerWidth;
text += "<br/>Alt extern: "+window.outerHeight;
//Mida de la finestra sense toolbar ni scrollbar
text += "<br/>Ample intern: "+window.innerWidth;
text += "<br/>Alt intern: "+window.innerHeight;	
//Scroll horitzontal i vertical
text += "<br/>Scroll horitzontal: "+window.pageXOffset;
text += "<br/>Scroll vertical: "+window.pageYOffset;	
//Distància de la cantonada superior esquerra
text += "<br/>Distància des de l'esquerra: "+window.screenX;
text += "<br/>Distància des de dalt: "+window.screenY;	

document.getElementById("finestra").innerHTML = text;

/* PROPIETATS AMB IFRAMES:
- frames: retorna tots els elements iframe de la finestra.
- frameElement: retorna el frame en el qual la finestra està inserida.
- length: retorna el nombre de frames que té la finestra. */

/*PROPIETATS AMB ALTRES FINESTRES:
- closed: retorna un booleà si la finestra està tancada.
- opener: retorna una referència amb la finestra que va crear la finestra actual. 
- parent: torna la finestra pare de la finestra actual.
- self: torna la finestra actual. */

/* ALTRES OBJECTES DEL NAVEGADOR:
window.document
window.navigator
window.screen
window.history
windon.location*/

//MÈTODES DE WINDOW MÉS IMPORTANTS
let laMevaFinestra; //Crear fora de les funcions per poder accedir-hi

//open(<URL>,<nom>,<especificacions>)
function crearFinestra(){
  //laMevaFinestra=window.open("http://www.google.com");
  laMevaFinestra = window.open("","","width=500,height=200");
  laMevaFinestra.document.write("<h1>La meva finestra</h1>");
}

//close(): tanca una finestra en concret
function tancarFinestra(){
  laMevaFinestra.close();
}

//resizeBy(<nºpix>,<nºpix>): redimensiona una finestra un nombre de píxels que fa a la seva grandària actual
function redimensionarFinestra(){
  laMevaFinestra.resizeBy(10,10);
}
//resizeTo(<nºpix>,<nºpix>): redimensiona una finestra a el nombre de píxels indicat

//moveBy(<nºpix>,<nºpix>): mou una finestra un nombre de píxels respecte a la seva posició actual
function moureFinestra(){
  laMevaFinestra.moveBy(10,10);
}
//moveTo(<nºpix>,<nºpix>): mou una finestra a una posició en concret

//scrollBy(<nºpix>,<nºpix>): mou les barres de scroll un nombre de píxels des de la posició actual.
//scrollTo(<nºpix>,<nºpix>): mou les barres de scroll un a una posició determinada.

//focus(): posa el focus a la finestra indicada.
function enfocar(){
  laMevaFinestra.focus();
}

//print(): imprimeix la finestra indicada
function imprimir(){
  //print();
  laMevaFinestra.print();
}

//stop(): aturar la càrrega de la pàgina
