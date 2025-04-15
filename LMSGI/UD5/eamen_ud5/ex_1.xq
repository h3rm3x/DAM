(: a) :)
(: biblioteca/libro[@id=3]/descripcion/text() :)

(: b) :)
(: //libro[xs:decimal(detalle/precio >= 49.99)]/titulo/string() :)

(: c) :)
(: //libro[titulo/contains(text(), "datos") or contains(string(), concat(upper-case("d"),"atos"))or contains(string(), concat("d",upper-case("a"),"tos")) or contains(string(), concat("da",upper-case("t"),"os")) or contains(string(), concat("dat",upper-case("o"),"s")) or contains(string(),concat("dato",upper-case("s")))]/detalle/precio :)

(: d) :)
//libro[titulo = "Introducción al Big Data"]/detalle/especificaciones/*