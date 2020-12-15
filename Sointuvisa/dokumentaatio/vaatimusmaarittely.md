# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla harjoitellaan tunnistamaan erilaisia sointutyyppejä. Sovellus on peli, jossa pelaaja valitsee oikean sointutyypin annetuista vaihtoehdoista kuulemansa soinnun perusteella. Suorituksesta saa pisteitä ja parhaiten suoriutuneiden pisteet on näkyvillä High score -listauksessa. Tiedot pelaajista, pisteistä ja kysymyksistä tallennetaan tiedostoon.

## Käyttäjät

Sovelluksella on ainostaan peruskäyttäjiä, jotka voivat antaa käyttäjänimen ja tehdä harjoituksia.

## Käyttöliittymäluonnos

<img src="https://raw.githubusercontent.com/AnttiHal/ot-harjoitustyo/master/Sointuvisa/dokumentaatio/images/kayttoliittymaluonnos.png">


          

## Perusversion toiminnallisuus
### Ennen käyttäjänimen antamista
- käyttäjä voi valita käyttäjänimensä
  - nimi voi olla 3-10 merkkiä pitkä.
- Linkki _huipputulokset_ -näkymään

### Pelin aloitusnäkymä
- Avautuu pelin avausnäkymä jossa annettu pelaajalle tekstimuodossa ohjeet pelaamiseen sekä nappi _Aloita_, josta peli käynnistyy.

### Pelinäkymä
- Pelissä on kymmenen kysymystä
- Peli toistaa käyttäjälle yhden audiotiedoston kerrallaan painettaessa nappia _kuuntele_, ja pelaajan on tunnistettava kyseessä olevan kolmisoinnun tyyppi
  - Sointutyypit: Duuri, molli, vähennetty, ylinouseva
- Vaihtoehto valitaan _radiobuttoneilla_
- Napista _Seuraava_ vastaus tallentuu ja käyttäjä pääsee seuraavaan näkymään.
  
### Pelatun kierroksen jälkeen 

- pelaaja saa eteensä tulosnäkymän, jossa näkyy kokonaistulos, sekä erittelyn, josta näkee mitkä soinnut menivät oikein ja mitkä väärin 
- Mahdollisuus joko
  - lopettaa pelaaminen _lopeta_-painikkeesta 
  - pelata kierros uudestaan
  - tarkastella _huipputulokset: -listaa 
 

## Jatkokehityksessä suunniteltu toiminnallisuus

Seuraavia toimintoja voi mahdollisesti lisätä sovellukseen, jos prosessi etenee nopeasti.
- Käyttäjän rekisteröityminen ja kirjautuminen
- Mahdolliset käyttäjäroolit, esim. normikäyttäjän lisäksi pääkäyttäjä, joka voisi tarkastella kaikkien käyttäjien tuloksia sekä poistaa käyttäjiä
- Level 2, jossa mukana myös nelisoinnut (7, maj7, 6, m7)
- Testaa audiota - nappi pelin aloitusnäkymään


