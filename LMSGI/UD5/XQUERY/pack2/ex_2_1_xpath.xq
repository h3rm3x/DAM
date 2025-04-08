(: a) Autors el cognom dels quals sigui DATE. :)
(: //autor[llinatges = "DATE" ] :)

(: b) llibres amb mes d'un autor :)
(: //llibre[count(autor)>1] :)

(: c) tots els autors :)
(: //autor :)

(: d) llibres editats entre 1998 i 2005 :) 
(: //llibre[llibre/any= "1998" and llibre/any = "2005"] :)

(: e) tots els valors de l'atribut id :)
(: //@id :)

(: f) el llibre que ocupa la tercera posicio :)
(: //llibre[3] :)

(: g) penultim autor del tercer llibre :)
(: //llibre[3]/autor[last()-1] :)

(: h) dos primers autors del trecer llibre :)
(: //llibre[3]/autor[position()<=2] :)

(: i) llibres que tene un atribut id major que 2 :)
(: //llibre[@id>2] :)

(: j) llibres editats entre 1998 i 2005 :)
//llibre[any>= "1998" and any <= "2005"]