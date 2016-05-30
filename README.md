## Framework dla terenowych gier RGP

### Wstęp

Projekt ma na celu stworzenie biblioteki/frameworka umożliwiajcego szybkie tworzenie terenowych gier RPG. Programista korzystający z tego narzędzia pełnił bedzie funkcję Game Mastera znanego z gier fabularnych. Framework pozwalał będzie na stworzenie prostej gry nawet przez mało doświadczonego programistę. Będzie to możwiwe dzieki strzorzeniu specjalnego języka DSL zaprojektowanego właśnie w tym celu. Składnia języka będzie przyjazna dla programisty-projektanta gry i pozwoli mu się skupić na stworzeniu ciekawego wirtualnego świata w czym pomocne mu będzie odciążenie go od szczegółów implementacyjnych.

Stworzenie gry z użyciem narzędzia w najprostrzym przykadku sprowadzać sie bedzie do rozmieszczenie przeciwników na terenie danego obiektu (znacznik NFC) lub danej lokalizacji (Wspólrzedne geograficzne) oraz ustalenia klas postaci dostepnych w danej rozgrywce.

### Streszczenie

Celem niniejszej pracy jest projekt i implentacja narzędzia pozwalający w prosty sposób tworzyć terenowe gry RPG. Aby osiągnąć ten cel stworzony został specjalny język opisu sceneriuszy oraz zadad panujących w grze. Język ten został zaprojektowany z urzyciem technologii Xtext [2]. Dzięki wykorzystaniu tego narzędzia możliwe było względnie szybkie stworzenie nowego języka zawięrającego takie elementy jak linker, kompiler. Dodatkowo język zintegrowany został z IDE Idea InteliJ co pozwala na podświetlanie oraz automatyczne sprawdzanie składni.

Stworzony silnik gier wykorzystuje technologię NFC w celu lokalizacji graczy w pomieszczeniach, jak i na otwartym terenie. Silnik został zaprojektowany tak, aby projektant gry mógł traktować te dwie technologie w sposób podobny. Z jego punktu widzenia zarówno pomiesznienie oznaczone tagiem NFC, jak i współrzędne geograficzne, stanowią po prostu lokację w której gracza mogą spotkać dowolnego typu przygody. 

W pracy postanowiłem opisać czym są jezyki domenowe (DSL), ponieważ stanowią one podstawę realizacji założeń projektowych. Dzięki wykorzystaniu języka DSL możliwe było stworzenie narzędzia tak prostego i przyjaznego w obsłudze. Umieściłem też rozdziały opisujące wykorzystane przeze mnie narzędzia takie jak: Android SDK, Xtext, Adroid Studio.

Niniejsza praca zawiera opis stworzonego języka oraz silnika gry. Osobny rozdział został poświęcony przygotowaniu środowiska pracy dla osoby, która chciałaby wykorzystać mój silnik do napisania własnej gry. Jest też część ilustrująca jak korzystać z narzędzia, w której krok po kroku pokazuje jak stworzyć przykładową grę na postawię przygotowanego scenariusza. 

W pracy opisany jest cały proces powstawania narzędzia. Osobne rozdziały zawierają opis powstawania projektu, jego implementacji oraz testów. 

### Słowa Kluczowe:

Android, DSL, Xtext, Location-Based Game, Framework, Engine

### Bibliografia
Ian F. Darwin, 2013. Android Receptury. Wydawnictwo: Helion.
[Xtext](https://eclipse.org/Xtext/documentation/index.html)
