## AdventureMaker - Język dla terenowych gier RGP

AdventureMaker powstał, aby ułatwić tworzenie terenowych gier RPG na system Android. Główny cel języka to pozwolić na tworzenie gier osobom obytym z tematem gier RPG, które nie miały wcześniej do czynienia z programowaniem.

Poniżej znajduje się przykładowa definicja przedmiotu. Powinna być ona zrozumiała, dla każdego, kto chodź raz grał w typowego RPG.

```
item Sword (weapon) {
   + 2 str
   + 1 agi
}
```

### Struktura projektu

Projekt składa się z trzech część. Języka (*AdventureMakerLanguage*), szkieletu aplikacji (*ExampleAdventure*) i pracy magisterskiej (*tex/magisterka.pdf*).

### Wtyczka AML

W ramach projektu powstała specjalna wtyczka do IDE *IntelliJ Idea*. Wtyczka w postaci pliku *aml.zip* znajduje się w folderze *docs/files*.

### Przykładowa gra

W ramach projektu powstała przykładowa gra, której akcje odbywa się na uniwersytecie. Pliku *.apk* znajduje się w folderze *docs/files*.
