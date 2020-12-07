# Käyttöohje

[linkki suorituskelpoiseen jar-tiedostoon](https://github.com/AnttiHal/ot-harjoitustyo/releases/tag/viikko5)

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto _config.properties_, jossa määritellään käyttäjät ja testeissä käytettävät kysymykset. Tiedoston sisältö on seuraava:

```
userFile=users.txt
questionFile=questions.txt
```

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar Sointuvisa-app.jar
```

## Etusivu

Sovellus käynnistyy nimenantonäkymään:


Nimi annetaan syöttämällä nimi syötekenttään ja painamalla painiketta "OK".
Samasta näkymästä voi halutessaan tarkastella huipputuloksia painamalla painikkeesta "Huipputulokset".

## Pelin aloitus

Nimen antamisen jälkeen avautuu aloitusnäkymä, jossa näkyy sovelluksen otsikko, tervetulotoivotus ja Aloita-painike, josta saa aloitettua pelin.

## Pelaaminen

Pelissä on 10 kysymystä, joiden näkymät ovat identtisiä lukuun ottamatta kysymysnumeroa. Otsikon ja kysymysnumeron alla on Kuuntele-painike, josta kyseessä olevan soinnun voi kuunnella niin monta kertaa kuin haluaa. Painikkeen alla on vastausvaihtoehdot, joista voi valita mieleisensä. Käyttäjä näkee valintansa painikkeen lisäksi myös vastausvaihtoehtojen alla olevalla rivillä. Alimpana näkymässä on Seuraava-painike, josta siirrytään seuraavaan kysymykseen. 

