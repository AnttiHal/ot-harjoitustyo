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
<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/nimenantonakyma.png" width="400">

Nimi annetaan syöttämällä nimi syötekenttään ja painamalla painiketta _OK_.
Samasta näkymästä voi halutessaan tarkastella huipputuloksia painamalla painikkeesta _Huipputulokset_.

<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/huipputulos-nakyma.png" width="400">

## Pelin aloitusnäkymä

Nimen antamisen jälkeen avautuu aloitusnäkymä, jossa näkyy sovelluksen otsikko, tervetulotoivotus ja _Aloita_-painike, josta saa aloitettua pelin.

<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/pelin-aloitusnakyma.png" width="400">

## Pelaaminen

Pelissä on 10 kysymystä, joiden näkymät ovat identtisiä lukuun ottamatta kysymysnumeroa. Otsikon ja kysymysnumeron alla on _Kuuntele_-painike, josta kyseessä olevan soinnun voi kuunnella niin monta kertaa kuin haluaa. Painikkeen alla on vastausvaihtoehdot, joista voi valita mieleisensä. Käyttäjä näkee valintansa painikkeen lisäksi myös vastausvaihtoehtojen alla olevalla rivillä. Alimpana näkymässä on _Seuraava_-painike, josta siirrytään seuraavaan kysymykseen. 

<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/pelinakyma.png" width="400">

## Viimeinen kysymys

Viimeisen kysymyksen kohdalla näkymä on muuten identtinen edellisten kanssa, paitsi että _Seuraava_-napin tilalla on _Katso tulokset_ -nappi, josta pääsee tarkastelemaan tulosnäkymää.

## Tulosnäkymä

Tässä näkymässä käyttäjä näkee kuinka monta oikeaa vastausta hän on saanut. Tuloksen alla olevista painikkeista _Pelaa uudestaan_ -painike palauttaa pelaajan pelin aloitusnäkymään. _Lopeta_-painike sulkee sovelluksen.

<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/loppunakyma.png" width="400">

