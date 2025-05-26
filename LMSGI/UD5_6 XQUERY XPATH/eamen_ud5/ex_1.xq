(: a) :)
(: biblioteca/libro[@id=3]/descripcion/text() :)

(: b) :)
(: //libro[(xs:decimal(detalle/precio >= 49.99)) and detalle/precio[@moneda="USD"]]/titulo/string() :)

(: c) :)
//libro[contains(lower-case(titulo), "datos")]


(: d) :)
(: //libro[titulo = "Introducción al Big Data"]/detalle/especificaciones/* :)