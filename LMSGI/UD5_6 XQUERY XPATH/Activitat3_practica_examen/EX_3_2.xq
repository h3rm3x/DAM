(: a :)
for $producto in //producto
where $producto/detalle/precio/@moneda = "USD"
return concat("Nombre producto: ", $producto/nombre , ", Precio: ", $producto/detalle/precio)

(: b :)
(: <resultado>{sum(for $producto in //producto
where $producto/nombre/starts-with(text(),"Smart")
return count($producto))}</resultado> :)


(: c :)
(: <product>{
  for $producto in //producto
return <brand>{upper-case(distinct-values($producto//marca))}</brand>
}</product> :)


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
(: for $producto in //producto
let $precio-original := $producto/detalle/precio 
let $descuento := 0.85
let $precio-descuento := $descuento * $precio-original
return concat("<producto", " id= , $producto/@codigo, """""> ","
  , "<PrecioOriginal>", $precio-original," </PrecioOriginal>", "
  ", "<precioDescuento>", $precio-descuento,"</precioDescuento>") :)
  
(: f :)
(: <resultado>{
  
let $preciomedio:= avg(//producto/detalle/precio[@moneda = "EURO"])
return <precioMedio>{$preciomedio}</precioMedio>, <productos>{
    for $producto in //producto[detalle/precio[@moneda = "EURO"]]
    return <producto>{
      $producto/nombre,
      <precio>{
        $producto/detalle/precio/number()
        }</precio>
      }</producto>
    }</productos>
}</resultado> :)


(: g) :)
(: <productos>{
let $productosinRAM:= //producto[not(dtealle/especificaciones/ram)]
let $preciomin := min($productosinRAM/detalle/precio)
return <producto>{$productosinRAM[detalle/precio = $preciomin]/nombre,<precio>{$preciomin}</precio>}</producto> }</productos> :)

(: h) :)
(: let $productos:= //producto
let $preciomedio:= avg($productos/detalle/precio)
for $producto in $productos
where xs:double($producto/detalle/precio) < $preciomedio and $producto/detalle/especificaciones/conexion = "Wi-Fi"
return $producto :)



