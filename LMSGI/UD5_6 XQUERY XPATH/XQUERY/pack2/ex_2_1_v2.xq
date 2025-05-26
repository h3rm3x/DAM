(: a) :) 
(: //autor[llinatges = "DATE"] :)

(: b) :)
(: //llibre[count(autor)>1] :)

(: c) :)
(: //autor :)

(: d) :)
(: //llibre[any="1998" or any="2005"] :)

(: e) :)
(: //llibre/@id/data() :)

(: f :)
(: //llibre[3] :)

(: g) :)
(: //llibre[3]/autor[last()-1] :)

(: h) :)
(: //llibre[3]/autor[1, 2] :)

(: i) :)
(: //llibre[@id>2] :)

(: j) :)
//llibre[any>="1998" or any<="2005"]