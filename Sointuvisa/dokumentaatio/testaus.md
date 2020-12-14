# Testausdokumentti

Ohjelmaa on testattu yksikkö- että integraatiotesteillä monipuolisesti käyttäen JUnitia sekä manuaalisesti testaamalla.

## Yksikkö- ja integraatiotestaus

Laajimmat testit on tehty ohjelman sovelluslogiikasta vastaavalle _SointuvisaService_-luokalle.
Dao-luokkia on testattu luomalla tilapäinen tiedosto käyttäen TemporaryFile-ominaisuutta.

Ohjelman testien rivikattavuus on 92% ja haaraumakattavuus 89%. Käyttöliittymän toteuttava koodi on jätetty testien ulkopuolelle<br>
<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/jacoco-report-final.png">
