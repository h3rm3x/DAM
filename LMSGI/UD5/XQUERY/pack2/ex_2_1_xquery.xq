(: a) Autors el cognom dels quals sigui DATE. :)
(: for $llibre in //llibre 
let $llinatge:= $llibre/autor/llinatges
where $llinatge = "DATE"
return $llibre/autor :)

(: b) llibres amb mes d'un autor :)
(: for $llibre in //llibre
where count($llibre/autor) > 1
return $llibre/titol/text() :)

(: c) tots els autors :)
(: for $autor in //autor
return $autor :)

(: d) llibres editats entre 1998 i 2005 :) 
(: for $llibre in //llibre
where $llibre/any = 1998 and $llibre/any = 2005
return $llibre/titol/text() :)

(: e) tots els valors de l'atribut id :)
(: for $llibre in //llibre 
return data($llibre/@id) :)

(: f) el llibre que ocupa la tercera posicio :)
(: let $tercer-libro := /llibres/llibre[3]
return $tercer-libro :)

(: g) penultim autor del tercer llibre :)
(: for $tercer-libro in /llibres/llibre[3]
return $tercer-libro/autor[last()-1] :)

(: h) dos primers autors del trecer llibre :)
(: for $tercer-libro in /llibres/llibre[3]
return $tercer-libro/autor[position()<= 2] :)

(: i) llibres que tene un atribut id major que 2 :)
(: for $llibre in //llibre
where $llibre[@id> "2"]
return $llibre :)

(: j) llibres editats entre 1998 i 2005 :)
for $llibre in //llibre
where $llibre/any >= 1998 and $llibre/any <= 2005
return $llibre/titol/text()





