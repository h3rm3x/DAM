(: a :)
(: //producto/nombre/text() :)

(: b :)
(: tienda/producto[@codigo= "3" ]/descripcion/text() :)

(: c :)
(: //producto[detalle/precio>500 and detalle/precio/@moneda="USD"] :)

(: d :)
(: //producto[@codigo="1"]/concat("codigo= """,@codigo, """
", nombre,"
", detalle/marca ) :)

(: solucion optima: :)
(: //producto[@codigo="1"]/@codigo , //producto[1]/nombre/text() , //producto[1]/detalle/marca/text() :)
(: e :)
(: //producto[detalle/marca="Sony" and nombre/contains(text(), "Auriculares") ]/detalle/precio :)

(: f :)
(: //producto[nombre="Smartwatch Samsung Galaxy Watch 4"]/detalle/especificaciones/* :)

(: g :)
//producto[detalle/especificaciones/bateria]/nombre/text()