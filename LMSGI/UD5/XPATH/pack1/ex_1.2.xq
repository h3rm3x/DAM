(: a :)
(: //nom :)

(: b :)
(: count(//alumne) :)

(: c :)
(: //professor[assignatura="XML"]/nom :)

(: d :)
(: distinct-values(//alumne[nom[contains(text(),Pi)]]/credits/assignatura) :)

(: e :)
(: //nom[starts-with(text(),'F')] :)

(: f :)
(: //alumne[any=2010]/nom/text() :)

(: g :)
//alumne/credits[assignatura="XML"]/../nom/text()



