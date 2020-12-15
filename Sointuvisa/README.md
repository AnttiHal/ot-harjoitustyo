# Sointuvisa

Tässä sovelluksessa pääset harjoittelemaan eri sointutyyppien tunnistamista. 
Sovelluksessa annetaan ensin käyttäjänimi ja sen pääsee tekemään soinnuntunnistustehtäviä. 
Nappia painamalla käyttäjä kuulee tunnistettavan soinnun ja sen jälkeen hän voi valita neljästä vaihtoehdosta oikean. 
Ulkoasu on toteutettu javafx:llä.<br>
Projektin koodin pystyy suorittamaan NetBeansin vihreällä napilla _tai/ja_ komennolla 
<code>mvn compile exec:java -Dexec.mainClass=Main</code><br>
Sovellusta pystyy testaamaan komennolla <code>mvn test</code><br>
Sovelluksella saa generoitua testikattavuusraportin komennolla <code>mvn test jacoco:report</code><br>
[linkki suorituskelpoiseen jar-tiedostoon](https://github.com/AnttiHal/ot-harjoitustyo/releases/tag/final)


### Testaus

Testien suoritus tapahtuu komennolla

```
mvn test
```

Testikattavuusraportti saadaan luotua komennolla

```
mvn jacoco:report
```

Kattavuusraportin tarkastelu onnistuu kansiossa _target/site/jacoco/_ komennolla


```
open index.html
```

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Sointuvisa-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tarkastukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

