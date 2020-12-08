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

Käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion _todoServicen_ metodeja.

Kun sovelluksen todolistan tilanne muuttuu, eli uusi käyttäjä kirjautuu, todoja merkitään tehdyksi tai niitä luodaan, kutsutaan sovelluksen metodia [redrawTodolist](https://github.com/mluukkai/OtmTodoApp/blob/master/src/main/java/todoapp/ui/TodoUi.java#L68) joka renderöi todolistanäkymän uudelleen sovelluslogiikalta saamansa näytettävien todojen listan perusteella.
<img src="https://github.com/AnttiHal/ot-harjoitustyo/blob/master/Sointuvisa/dokumentaatio/images/arkkitehtuuri.png">
