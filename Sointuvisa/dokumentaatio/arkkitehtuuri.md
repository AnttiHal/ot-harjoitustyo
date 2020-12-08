# Arkkitehtuurikuvaus

## Pakkausrakenne
Sovelluksen rakenne on jaettu kolmeen pakkaukseen allaolevan kuvan mukaisesti.

<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/pakkausrakenne.png">

_Sointuvisa.ui_ sisältää sovelluksen javafx-pohjaisen käyttöliittymän, _sointuvisa.domain_ sovelluslogiikan ja _sointuvisa.dao_ tallennukseen liittyvät toimet.


## Käyttöliittymä

Käyttöliittymä sisältää viisi näkymää
- Nimenantonäkymä
- Aloitusnäkymä
- Pelinäkymä
- Highscore-näkymä
- Lopputulosnäkymä

Näkymät on toteutettu omina Scene-olioina. Näkymät ovat käytössä yksi kerrallaan samassa Stage-oliossa. Kaikki käyttöliittymän koodi on yhdessä luokassa _sointuvisaUi.java_.

Valtaosa sovelluksen logiikasta on pyritty eristämäään käyttöliittymästä. Käyttöliittymästä käsin kutsutaan sovelluslogiikan toteuttavan luokan _SointuvisaService_ metodeja.
Kun käyttäjä kerää pisteitä oikeista soinnuista, tallentuvat pisteet sovelluslogiikkaan ja pelin loppuessa tiedostoon.

## Sovelluslogiikka


<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/arkkitehtuuri.png">
