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

Sovelluksessa on kaksi loogista luokkaa, _User_ ja _Question_. _User_-luokkaan tallentuu käyttäjän nimi, sekä hänen ansaitsemat pisteet, jotka ovat aina alussa nolla. _Question_-luokkaan tallentuvat id, audio-tiedoston url, sekä soinnun tyyppi. Kysymykset generoituvat automaattisesti Random-olion avulla satunnaiseen järjestykseen kun peli alkaa.

Sovelluksen toiminnallisuuksia käytetään _SointuvisaService_-luokan avulla. Yksi instanssi luokasta luodaan sovelluksen käynnistyessä, ja sen metodeja hyödyntämällä käyttöliittymästä käsin toteutetaan eri toiminnallisuuksia, kuten
- getQuestionById
- getUserByUsername
- updateUserPoints
- getTopThree

_SointuvisaService_ pääsee käsiksi _User_- ja _Question_-luokkiin rajapintojen _Userdao_ ja _Questiondao_ kautta. Alla olevassa kuvassa näkyy _SointuvisaService_-luokan suhde muihin luokkiin.


<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/arkkitehtuuri.png">
