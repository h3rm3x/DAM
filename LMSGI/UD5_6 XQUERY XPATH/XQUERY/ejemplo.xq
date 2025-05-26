(: for $obra in //obra
while $obra/@any>"1800"
order by $obra/@pais
return $obra/@pais/string() :)

(: for $obra in //obra 
let $visible:= $obra/museu/@visible
where $visible = "true"
return data($obra/@pais) :)


(: distinct-values(for $obra in //obra 
let $visible:= $obra/museu/@visible
where $visible = "true"
return substring(data($obra/@pais),2)) :)


(: <ul>
{
for $pais in distinct-values(
  for $obra in //obra 
  let $visible:= $obra/museu/@visible
  where $visible = "true"
  return data($obra/@pais)
)
order by $pais 
return <li>{$pais}</li>
}
</ul> :)

(: <table>
{
  for $obra in //obra
  order by $obra/autor
  return if($obra/@pais= "França") 
  then 
  <tr>
  <td>{$obra/titol/text()}</td>
  <td>{$obra/autor/text()}</td>
  </tr>
}
</table> :)

(: for $obra in //obra
let $titol:=  $obra/titol/text()
 order by $obra/autor
 return concat($titol,"- Autor: ", $obra/autor/text()) :)
 
 
<ul>
{
  
  for $obra in //obra
  let $visible:= $obra/museu/@visible
  return
   <li>
     {
     concat($obra/titol,
     " (", $obra/@any, " ) - ", 
     if ($visible= "true") then concat("Exposat al museu ", 
     $obra/museu) else("No exposat al museu")  )
   }
   </li>
}
</ul>