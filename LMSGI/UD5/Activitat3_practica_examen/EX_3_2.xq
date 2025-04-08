(: a :)
(: for $producto in //producto
where $producto/detalle/precio/@moneda = "USD"
return concat("Nombre producto: ", $producto/nombre , ", Precio: ", $producto/detalle/precio) :)

(: b :)
(: sum(for $producto in //producto
where $producto/nombre/starts-with(text(),"Smart")
return count($producto)) :)

(: c :)
(: for $producto in //producto
return $producto//marca :)

(: d :)
(: for $producto in //producto
where $producto/nombre = "Laptop HP Pavilion"
return concat("<producto>",
$producto/nombre/text(),
"</producto>", " 
", "<especificacion>",
(for $producto in //producto
where $producto/nombre="Laptop HP Pavilion" 
return $producto//especificaciones/concat(*,",") )," 
", "</especificacion>"
) :)

(: e :)
for $producto in //producto
let $precio-original := $producto/detalle/precio 
let $descuento := 0.15
let $precio-descuento := $descuento * $precio-original
return concat("<producto", " id= ", $producto/@codigo, """> ","
", "<PrecioOriginal>", $precio-original," </PrecioOriginal>", "
", "<precioDescuento>", $precio-descuento,"</precioDescuento>")



