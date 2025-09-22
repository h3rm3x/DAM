(: a) :)
(: <libros>{
  for $libro in //libro
  return <libro>{
    $libro/titulo, <precio>{$libro/detalle/precio/data()}</precio>, <moneda>{$libro/detalle/precio/@moneda/data()}</moneda>
  }</libro>
}
</libros> :)

(: b) :)
(: <editoriales>{
   distinct-values(
    for $libro in //libro
    let $editorial:= $libro/detalle/editorial/text()
    order by $editorial
    return <editorial>{ <nombre>{upper-case($editorial)}</nombre>, <ejemplares>{count($libro[detalle/editorial = $editorial]/detalle/editorial)}</ejemplares>} </editorial>
  )
}</editoriales> :)

(: c) :)

  (: for $libro in //libro
  let $descuento:= 0.90
  where $libro[detalle/especificaciones/paginas > 300]
  return <libro>{ <id>{$libro/@id/data()}</id>, <precio_original>{$libro/detalle/precio/number()}</precio_original>, <precio_descuento>{concat($libro/detalle/precio/@moneda/data(), " ", ($libro/detalle/precio/number())*$descuento)}</precio_descuento>
  
}</libro> :)

(: d) :)
<resultado>{
  let $preciomedio:= avg(//libro/detalle/precio[@moneda = "USD"])
  return <precioMedio>{$preciomedio}</precioMedio>,
   <libros>{
   for $libro in //libro[detalle/precio[@moneda = "USD"]]
      return 
      $libro/titulo
   }</libros>

}</resultado>


