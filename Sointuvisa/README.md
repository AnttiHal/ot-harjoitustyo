# Sointuvisa

Tässä sovelluksessa pääset harjoittelemaan eri sointutyyppien tunnistamista. 
Sovelluksessa annetaan ensin käyttäjänimi ja sen pääsee tekemään soinnuntunnistustehtäviä. 
Nappia painamalla käyttäjä kuulee tunnistettavan soinnun ja sen jälkeen hän voi valita neljästä vaihtoehdosta oikean. 
Ulkoasu on toteutettu javafx:llä.<br>
Projektin koodin pystyy suorittamaan NetBeansin vihreällä napilla _tai/ja_ komennolla 
<code>mvn compile exec:java -Dexec.mainClass=Main</code><br>
Sovellusta pystyy testaamaan komennolla <code>mvn test</code><br>
Sovelluksella saa generoitua testikattavuusraportin komennolla <code>mvn test jacoco:report</code>

## Näkymät
Aloitusnäyttö, jossa käyttäjänimen anto.
Aloitusnäyttö, jossa käyttäjänimi ja aloita-painike
pelinäkymä, jossa kuuntele-nappi, radiobuttonit valintaa varten, sekä seuraava-nappi



##  Tämänhetkinen tilanne

Sovellukselle on luotu runko. 
Käyttäjänimen tallennus tiedostoon onnistuu.
Kysymysten tallennus tiedostoon onnistuu. (tapahtuu automaattisesti sovelluksen avautuessa)
Aloitusnäkymä on luotu ja se avautuu kun sovellus käynnistetään.
Pelinäkymä on luotu ja se avautuu painamalla OK-painiketta käyttjänimen antamisen jälkeen. 


