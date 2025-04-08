(: a :)
(: //producto/nombre/text() :)

(: b :)
(: tienda/producto[@codigo= "3" ]/descripcion/text() :)

(: c :)
(: //producto[detalle/precio>500] :)

(: d :)
(: //producto[@codigo="1"]/concat("codigo= """,@codigo, """
", nombre,"
", detalle/marca ) :)

(: e :)
(: //producto[detalle/marca="Sony" and nombre/contains(text(), "Auriculares") ]/detalle/precio :)

(: f :)
(: //producto[nombre="Smartwatch Samsung Galaxy Watch 4"]/detalle/especificaciones/* :)

(: g :)
//producto/detalle/especificaciones/bateria/..//producto