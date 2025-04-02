(: a :)
(: //pes :)

(: b :)
(: //pes/number() :)

(: c :)
(: //producte[last()]/pes :)

(: d :)
(: distinct-values(//pes/@unitat) :)

(: e :)
(: //producte[last()-1]/@codi :)

(: f :)
(: //producte[@codi="AAA-111"]/pes :)

(: g :)
(: //producte/pes[@unitat="g"] :)

(: h :)
(: //producte/nom[contains(text(),'l')] :)

(: i :)
(: //producte[nom="Monitor"]/@codi :)

(: j :)
//producte[pes>0.25 and pes/@unitat="kg" or pes>250 and pes/@unitat="g"]/@codi
