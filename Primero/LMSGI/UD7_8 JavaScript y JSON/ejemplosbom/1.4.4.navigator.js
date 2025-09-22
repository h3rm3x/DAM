/* CARACTERÍSTIQUES:
- Guarda informació sobre el navegador.
- No hi ha un estàndard públic però la majoria dels navegadors suporten aquest objecte. */

//PROPIETATS DEL OBJECTE NAVIGATOR:
let text = "";
//appCodeName: codeName del navegador
text += "<br/>CodeName: "+navigator.appCodeName;
//appName: nom del navegador
text += "<br/>Name: "+navigator.appName;
//appVersion: versió del navegador
text += "<br/>Versió: "+navigator.appVersion;

//product: motor del navegador
text += "<br/>Motor: "+navigator.product;
//platform: plataforma del navegador
text += "<br/>Plataforma: "+navigator.platform;
//onLine: navegador online/offline
text += "<br/>OnLine: "+navigator.onLine;

//language: idioma del navegador
text += "<br/>Idioma: "+navigator.language;
//cookieEnabled: cookies activades
text += "<br/>Cookies: "+navigator.cookieEnabled;
//userAgent: capçalera user-agent retornada pel navegador al servidor
text += "<br/>UserAgent: "+navigator.userAgent;
document.getElementById("navegador").innerHTML = text;

//geolocation: retorna un objecte Geolocation que pot servir per localitzar la posició de l'usuari. 

//MÈTODE DEL OBJECTE NAVIGATOR:
//javaEnabled(): devuelve true o false si está activado Java.
alert("Java activat: "+navigator.javaEnabled());
