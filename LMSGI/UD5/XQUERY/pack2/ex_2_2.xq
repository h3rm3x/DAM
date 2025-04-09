(: a) :)
for $llibre in //llibre
return concat("Titol: ",  $llibre/titol/text(), " Autor ", for $autor in $llibre/autor return concat($autor/nom/text(), " ",  $autor/llinatges/text())
   )
 


(: b) Obtenir els títols de llibre dels quals consti més d'un autor.:)
(: for $llibre in //llibre
where count($llibre/autor)
return $llibre/titol/text() :)

(: c) Obtenir els títols de llibre publicats amb posterioritat a 2004.:)
(: for $llibre in //llibre 
where $llibre/any> "2004"
return $llibre/titol/text() :) 

(: d) Obtenir per cada llibre quants autors l’han publicat. :)
(: for $llibre in //llibre
return concat("Nº autores ", count($llibre/autor) ) :)

(: e) Obtenir per cada llibre, el seu títol i quants autors l'han publicat. :)
(: for $llibre in //llibre
return concat("Titol: ", $llibre/titol, "Nº autores ", count($llibre/autor) ) :)
(: f) Obtenir per cada llibre, el seu id, títol i quants autors l’han publicat.:)
(: for $llibre in //llibre
return concat("Titulo: ", $llibre/titol, ", ID: ", $llibre/@id,", Nº autores", count($llibre/autor)) :)

(: g)Obtenir per cada llibre el seu títol i autors, tenint en compte que si el llibre té
més d'un autor figurarà el primer autor i el text “et. Al”. :)
(: for $llibre in //llibre
return concat("Titulo: ", $llibre/titol, ", Autores: ", $llibre/autor[1]/nom," ", $llibre/autor[1]/llinatges," et. Al") :)

(: h) Obtenir el títol d'aquells llibres en els quals tots els seus autors tinguin el
cognom Alarcon i el nom P. :)
(: for $llibre in //llibre 
where $llibre/autor/llinatges[contains(text(),"Alarcon")] and $llibre/autor/nom[contains(text(),"P")]
return $llibre/titol :)

(: i) Obtenir el títol d'aquells llibres en els quals tots els seus autors tinguin el cognom DATE i el nom C.J. :)
(: for $llibre in //llibre 
where $llibre/autor/llinatges= "DATE"and $llibre/autor/nom = "C.J."
return $llibre/titol/text() :)

(: j) Per a aquells llibres que es titulin “Bases de dades”, obtenir tots els seus atributs i elements, excepte el d'autor. :)
(: for $llibre in //llibre 
where $llibre/titol = "Bases de Datos" 
return (for $element in $llibre/*
    where name($element) != 'autor'
    return $element ) :)

(: k)Obtenir aquells llibres que figurin sense editorial. :)
(: for $llibre in //llibre[not(editorial)]
return $llibre :)

(: l) Obtenir aquells llibres que figurin amb editorial. :)
(: for $llibre in //llibre[editorial]
return $llibre :)

(: m) Obtenir els llibres publicats per l'editorial Addison-Wesley després de 2005. :) 
(: for $llibre in //llibre 
where $llibre/editorial= "Addison-Wesley" and $llibre//any > "2005"
return $llibre :)

(: n) Obtenir el títol del llibre i l’editorial per a aquells llibres que tinguin un preu superior a 50€. :)
(: for $llibre in //llibre 
where $llibre/preu > "50"
return concat("Titol: ", $llibre/titol/text(),", Editorial: " , $llibre/editorial) :)  
     

