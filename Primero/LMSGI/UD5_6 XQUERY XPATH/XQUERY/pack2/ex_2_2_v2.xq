(: a) :)
(: for $llibre in //llibre
return <llibre>{$llibre/titol }<autor>{concat($llibre/autor/nom, " ", $llibre/autor/llinatges)}</autor></llibre> :)

(: b) :)
(: for $llibre in //llibre
where count($llibre/autor)>1
return $llibre/titol :)

(: c :)
(: for $llibre in //llibre
where $llibre/any>2004
return $llibre/titol :)

(: d) :)
(: for $llibre in //llibre
return concat("Titol ",$llibre/titol, " Nº autores ", count($llibre/autor) ) :)

(: e) :)
(: for $llibre in //llibre
return concat(" ID: ", $llibre/@id, " Nº autores ", count($llibre/autor) ) :)

(: f) :)
(: for $llibre in //llibre
return concat("Titol ",$llibre/titol, " ID: ", $llibre/@id, " Nº autores ", count($llibre/autor) ) :)

(: g) :)
(: for $llibre in //llibre
return if (count($llibre/autor)>1) then
  concat("Titol ", $llibre/titol, " Autors ", $llibre/autor[position()=1]/nom, " ", $llibre/autor[position()=1]/llinatges, "et Al.") 
else 
  concat("Titol ", $llibre/titol, " Autors ", $llibre/autor/nom, " ", $llibre/autor/llinatges) :) 
  
(: h) :)
(: for $llibre in //llibre
where $llibre/autor/nom = "P." and $llibre/autor/llinatges= "Alarcon"
return $llibre/titol :)

(: i) :)
(: for $llibre in //llibre
where $llibre/autor/nom = "C.J." and $llibre/autor/llinatges= "DATE"
return $llibre/titol :)

(: j) :)
(: for $llibre in //llibre
where $llibre/titol= "Bases de Datos"
return <libro>{$llibre/@*, $llibre/*}</libro> :)

(: k) :) 
(: for $llibre in //llibre[not(editorial)]
return $llibre :)

(: l) :)
(: for $llibre in //llibre[editorial]
return $llibre :)

(: m) :)
(: for $llibre in //llibre
where $llibre/editorial ="Addison-Wesley" and $llibre/any> "2005"
return $llibre :)

(: n) :)
(: for $llibre in //llibre
where xs:decimal ($llibre/preu>50)
return $llibre :)

(: o) :)
<html>
  <head><title>Dades Llibres HTML</title></head>
  <body>
    <ul>{
      for $llibre in //llibre
      return <li>{$llibre/titol/text()}</li>
    }</ul>
  </body>
</html>
