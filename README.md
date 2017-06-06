## AdventureMaker - Język dla terenowych gier RPG

*AdventureMaker* powstał, aby ułatwić tworzenie terenowych gier RPG na system Android. Główny cel języka to pozwolenie na tworzenie gier osobom obytym z tematem gier RPG, które nie miały wcześniej do czynienia z programowaniem.

Poniżej znajduje się przykładowa definicja przedmiotu. Powinna być ona zrozumiała, dla każdego, kto choć raz grał w typową grę RPG.

```
item Sword (weapon) {
   + 2 str
   + 1 agi
}
```

### Struktura projektu

Projekt składa się z trzech część: języka (*AdventureMakerLanguage*), szkieletu aplikacji (*ExampleAdventure*) i pracy magisterskiej (*tex/magisterka.pdf*).

### Wtyczka AML

W ramach projektu powstała specjalna wtyczka do IDE *IntelliJ IDEA*. Wtyczka w postaci pliku *aml.zip* znajduje się w folderze *docs/files*.

Poniższy screen prezentuje działanie wtyczki takie jak kolorowanie i autouzupełnianie składni.

![*IntelliJ IDEA* Screenshot](https://github.com/adrpieper/magisterka/blob/master/screens/idea_screen.png?raw=true)

### Przykładowa gra

Przykładowa gra, której akcja odbywa się na uniwersytecie, znajduje się w postaci pliku *.apk* w folderze *docs/files*.

Poniżej znajdują się 3 screeny z gry prezentujące wybór postaci, drzewo umiejętności oraz *walkę* z egzaminem.
![*Example Game* Screenshot](https://github.com/adrpieper/magisterka/blob/master/screens/game_screen1.png?raw=true)
![*Example Game* Screenshot](https://github.com/adrpieper/magisterka/blob/master/screens/game_screen2.png?raw=true)
![*Example Game* Screenshot](https://github.com/adrpieper/magisterka/blob/master/screens/game_screen3.png?raw=true)
