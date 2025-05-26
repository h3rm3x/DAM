
(: Seleccionar el nombre del producto y el precio en dólares de todos los productos que usen esa moneda usando where. La salida debe tener este formato: Nombre producto: <valor_nombre>, Precio: <valor_precio> :)
(: for $producto in /tienda/producto
where $producto[detalle/precio/@moneda='USD']
return concat("Nombre producto: ", $producto/nombre, ", Precio: ", $producto/detalle/precio[@moneda='USD']) :)

(: for $producto in //producto
let $nombre:= $producto/nombre
let $precio:= $producto/detalle/precio
where $precio/@moneda='USD'
return concat('Nom producte: ', $nombre, ', Preu: ', $precio) :)

(: for $producto in //producto
where $producto/detalle/precio/@moneda = "USD"
return concat("Nombre producto: ", $producto/nombre , ", Precio: ", $producto/detalle/precio) :) 

(: Cuenta el número de productos cuyos nombres comienzan por "Smart". El resultado debe estar en una etiqueta :)
(: let $numProductosSmart := count(//producto[starts-with(nombre, "Smart")])
return <numProductosSmart>{$numProductosSmart}</numProductosSmart> :)

(: let $productos := //producto[starts-with(nombre, "Smart")]
return <resultat>{count($productos)}</resultat> :)

(: <resultat>
{
  sum(for $producto in //producto
  where $producto/nombre/starts-with(text(),"Smart")
  return count($producto))
}
</resultat> :)

(: <smart>
{
  count(
    for $producto in //producto
    where $producto/nombre[starts-with(text(), "Smart")]
    return $producto
  )
}
</smart> :)

(: for $tienda in /tienda/producto
where $tienda/nombre[starts-with(text(),'Smart')]
return <li>{data((count($tienda)))}</li> :)

(: Listar todas las marcas de productos en la tienda sin repetición con este formato (la marca debe estar en mayúsculas):
<products>
  <brand>MARCA</brand>
  <brand>MARCA</brand>
</products>
 :)
(: <products>
  {
    for $marca in distinct-values(//producto/detalle/marca)
    return <brand>{upper-case($marca)}</brand>
  }
</products> :)


(: Lista todas las especificaciones del Laptop HP Pavilion con este formato. Debes suponer que no sabes cuántas especificaciones hay. :)
(: let $producto := //producto[nombre = "Laptop HP Pavilion"]
return
  <producto>{ $producto/nombre/text() }</producto>,
  <especificaciones>{
    let $especificaciones := //producto[nombre = "Laptop HP Pavilion"]/detalle/especificaciones/*
return string-join($especificaciones, ", ")
  }</especificaciones> :)

(: let $producto := //producto[nombre = "Laptop HP Pavilion"]
return
  <producto>{ $producto/nombre/text() }</producto>,
  <especificaciones>{
    for $spec in //producto[nombre = "Laptop HP Pavilion"]/detalle/especificaciones/*
    return concat($spec, ', ')
  }</especificaciones> :)

(: Casi :)
(: for $producto in //producto
where $producto/nombre = "Laptop HP Pavilion"
return (<producto>{$producto/nombre/text()}</producto>, <especificaciones>{$producto/detalle/especificaciones/string()}</especificaciones>) :)

(: Casi :)
(: for $producto in //producto
where $producto/nombre/contains(text(),'Laptop HP Pavilion')
let $espe := $producto//especificaciones
return concat("<producto>",$producto/nombre,"</producto>",$producto/concat("<especificaciones>",$espe,"<especificaciones>")) :) 
 

(: Calcula el precio final con un descuento del 15% para todos los productos y devuelve un nuevo documento XML que contenga el ID del producto, el precio original y el precio con descuento para cada uno. Para ello es obligatorio crear por lo menos estas variables: una con el descuento a aplicar, otra con el precio original y otra con el precio con descuento. Este debe ser el formato final :)
(: let $descuentoPorcentaje as xs:decimal := 0.15
for $producto in //producto
let $precioBase := xs:decimal($producto//precio/text())
let $precioFinal := $precioBase * (1 - $descuentoPorcentaje)
return 
<producto id="{$producto/@codigo}">
  <precioOriginal>{ $precioBase }</precioOriginal>
  <precioConDescuento>{ $precioFinal }</precioConDescuento>
</producto> :)

(: mmmm no és aquesta la idea... però bon intent :)
(: for $producto in //producto
let $precio-original := $producto/detalle/precio 
let $descuento := 0.15
let $precio-descuento := $descuento * $precio-original
return concat("<producto", " id= ", $producto/@codigo, """> ","
", "<PrecioOriginal>", $precio-original," </PrecioOriginal>", "
", "<precioDescuento>", $precio-descuento,"</precioDescuento>") :)


(: Calcular el precio promedio de todos los productos en la tienda en euros y mostrar una lista con los nombres de esos productos :)
(: let $productos := //producto[detalle/precio/@moneda = "EURO"]
let $precioPromedio := avg($productos/detalle/precio)
return
  <resultados>
    <precioPromedio>{$precioPromedio}</precioPromedio>
    <productos>{
      for $producto in $productos
      return <producto>
                { $producto/nombre }
                <precio> { $producto//precio/text() }</precio>
            </producto>
    }</productos>
  </resultados> :)
  
  
(: Encontrar el precio mínimo de todos los productos en la tienda que no tengan ram y mostrar como resultado el precio mínimo y el nombre del producto que tenga ese precio. :)

(: let $productosSinRAM := //producto[not(detalle/especificaciones/ram)]
let $precioMin := min($productosSinRAM/detalle/precio)
let $productoMin := $productosSinRAM[detalle/precio = $precioMin]
return 
  <productoPrecioMinSinRAM>
    {$productoMin/nombre}
    <precio>{$precioMin}</precio>
  </productoPrecioMinSinRAM> :)
  
(: let $preus := //producto/detalle/precio
let $minimo := min($preus)
for $producto in //producto
where $producto/detalle/especificaciones[not(ram)]
and $producto/detalle[precio = $minimo]
return concat("Nombre producto: ", $producto/nombre, ",", " Precio Minimo: ", $producto/detalle/precio) :) 
  
(:h Encuentra los productos que tienen un precio inferior al promedio de todos los productos de la tienda y que tienen una conexión Wifi:)

let $productos :=//producto
let $precioPromedio := avg($productos/detalle/precio)
for $producto in $productos
where $producto/detalle/especificaciones/conexion = "Wi-Fi" and xs:double($producto/detalle/precio) < $precioPromedio
return $producto 






 






