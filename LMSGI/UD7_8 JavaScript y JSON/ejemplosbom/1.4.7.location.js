/* CARACTERÍSTIQUES:
  - Guarda informació de la URL actual.
  - No hi ha un estàndard públic però la majoria dels navegadors suporten aquest objecte. */

  //PROPIETATS DEL OBJECTE LOCATION
  let text = "";
  //href: HREF (URL) de la pàgina
  text += "<br/>Href: "+location.href;
  //hostname: nom del host de la pàgina
  text += "<br/>Hostname: "+location.hostname;
  //pathname: pathname de la pàgina
  text += "<br/>Pathname: "+location.pathname;
  //protocol: protocol de la pàgina
  text += "<br/>Protocol: "+location.protocol;
  //hash: hash o àncora de la pàgina (Ex. www.web.com/index.html#indice)
  text += "<br/>Hash: "+location.hasg;

  //host: nom del hostname y el port
  text += "<br/>Host: "+location.host;
  //origin: nom del protocol, hostname y el port
  text += "<br/>Origin: "+location.origin;
  //search: querystring de la pàgina (Ex. www.web.com/index.html?user=ada)
  text += "<br/>Search: "+location.search;
  document.getElementById("location").innerHTML = text;

  //MÈTODOS DEL OBJECTE LOCATION
  //assign(<url>): assigna un nou document a la pàgina
  function nouDocument(){
    location.assign("http://www.google.com")
  }

  //reload(): recarrega la pàgina
  function recarrega(){
    location.reload()
  }

  //replace(<url>): substitueix la pàgina per una altra. DESAPAREIX EL SEU HISTORIAL.
  function substitueix(){
    location.replace("http://www.google.com");
  }