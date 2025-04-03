(: a :)
(: //fons[compteassociat="20-A"]/dades/quantitatdipositada/number() :)

(: b :)
(: distinct-values(//fons/dades/moneda/text()) :)
 
(: c :)
(: //saldoactual[@moneda="euros"]/..//titular/@dni :)

(: d :)
//fons[dades/moneda="Euros" and dades/quantitatdipositada<21000]