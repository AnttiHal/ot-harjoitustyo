# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla harjoitellaan tunnistamaan erilaisia sointutyyppejä. Sovellus on peli, jossa pelaaja valitsee oikean sointutyypin annetuista vaihtoehdoista kuulemansa soinnun perusteella. Suorituksesta saa pisteitä ja parhaiten suoriutuneiden pisteet on näkyvillä High score -listauksessa. Tiedot pelaajista, pisteistä ja kysymyksistä tallennetaan tiedostoon.

## Käyttäjät

Sovelluksella on ainostaan peruskäyttäjiä, jotka voivat antaa käyttäjänimen ja tehdä harjoituksia.

## Käyttöliittymäluonnos

<img src="https://raw.githubusercontent.com/AnttiHal/ot-harjoitustyo/master/Sointuvisa/dokumentaatio/images/kayttoliittymaluonnos.png">


          

## Perusversion suunniteltu toiminnallisuus
### Ennen käyttäjänimen antamista
- käyttäjä voi valita käyttäjänimensä
  - nimi voi olla 3-10 merkkiä pitkä ja sisältää merkit A-Z, 0-9 (Tähän lisätty ehto että ei voi olla alle 3 merkkiä, muut ehdot puuttuvat)
  - jos nimi on jo käytössä, sovellus kertoo sen käyttäjälle ja varmistaa, että käyttäjä haluaa jatkaa (Tämä puuttuu)
- Linkki High score -näkymään (Tehty)

### Pelin aloitus
- Avautuu pelin avausnäkymä jossa annettu pelaajalle tekstimuodossa ohjeet pelaamiseen sekä nappi "käynnistä", josta peli käynnistyy (tästä puuttuu ohje, muuten ok)
- Peli toistaa käyttäjälle yhden audiotiedoston kerrallaan (yht 10 kpl) ja pelaajan on tunnistettava kyseessä olevan kolmisoinnun tyyppi (Tehty)
  - Sointutyypit: Duuri, molli, vähennetty, ylinouseva (Lisätty 10 kysymystä, kaikki tallentuvat)
  
### Pelatun kierroksen jälkeen 

- pelaaja saa eteensä tulosnäkymän, jossa näkyy mitkä soinnut menivät oikein ja mitkä väärin (tulosnäkymässä ainoastaan saadut pisteet ja tuloksen generointi ei vielä toimi)
- pelaaja saa tiedon pääsikö high score -listalle.
- pelaaja näkee suorituksen keston
- Mahdollisuus joko
  - lopettaa pelaaminen lopeta-painikkeesta (tehty)
  - pelata kierros uudestaan (tehty)
  - tarkastella high score -listaa (tämä siirtynee etusivulle)
 

## Jatkokehityksessä suunniteltu toiminnallisuus

Seuraavia toimintoja voi mahdollisesti lisätä sovellukseen, jos prosessi etenee nopeasti.
- Käyttäjän rekisteröityminen ja kirjautuminen
- Mahdolliset käyttäjäroolit, esim. normikäyttäjän lisäksi pääkäyttäjä, joka voisi tarkastella kaikkien käyttäjien tuloksia sekä poistaa käyttäjiä
- Level 2, jossa mukana myös nelisoinnut (7, maj7, 6, m7)
- Testaa audiota - nappi pelin aloitusnäkymään


