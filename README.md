## NazwaFrameworka - Framework dla terenowych gier RGP

### Wstęp

Gry terenowe, czyli to aplikacje instesywnie wykorzystujące fizyczną pozycje gracza, są nowym trendem w dziedzinie rozrywki elektronicznej. Sukces niedawno wydanej gry "Pocemon GO" pokazał, że na gry tego typu znajduje się całkiem spora rzesza odbiorców.

Niestety tworzenie tego typu gier jest dość skomplikowane, a przez to kosztowne. Wykorzystanie technologii typu GPS, czy NFC wymaga od programisty wykorzystnia specjalistycznego API oraz sprawia, że testowanie aplikacji jest utrudnione.

W idealnym świecie napisanie tego typu gry powinno sprowadzać się jedynie do zdefiniowania zasad obowiązujących w wirtualnym świecie, odciążając tym samym programiste od szczegółów implementacyjnych. Dlatego właśnie postanowiłem storzyć Adventure Maker - framework umożliwiający szybkie tworzenie terenowych gier RPG. 

Framework pozwala na implementacje prostej gry nawet przez mało doświadczonego programistę nieznającego Javy ani AndroidSDK. Jest to możliwe dzieki specjalnemu językowi DSL zaprojektowanego właśnie w tym celu. Składnia języka jest przyjazna dla programisty-projektanta gry i nie wymaga znajomości, ani żadnego języka programowania ogólnego przeznaczenia, ani żadnych dodatkowych technologii.

Stworzenie gry z użyciem narzędzia w najprostrzym przykadku sprowadza sie do rozmieszczenie przeciwników na terenie danego obiektu (znacznik NFC) lub danej lokalizacji (Wspólrzedne geograficzne) oraz ustalenia klas postaci dostepnych w danej rozgrywce.

### Streszczenie

Celem niniejszej pracy jest projekt i implementacja narzędzia pozwalającego w prosty sposób tworzyć terenowe gry RPG. Aby osiągnąć ten cel zaprojektowany został specjalny język opisu sceneriuszy oraz zadad panujących w grze. Język ten został stworzony z użyciem technologii Xtext [2]. Dzięki wykorzystaniu tego narzędzia możliwa jest względnie szybka implementacja nowego języka, zawięrającego takie elementy jak linker, czy kompiler. Dodatkowo powstały język zintegrowany jest z IDE Idea InteliJ co pozwala na podświetlanie, autouzupełnianie oraz automatyczne sprawdzanie składni.

Stworzony silnik gier wykorzystuje technologię NFC oraz GPS w celu lokalizacji graczy w pomieszczeniach, jak i na otwartym terenie. Silnik został zaprojektowany tak, aby twórca gry mógł traktować te dwie technologie w sposób bardzo zbliżony, nie zważając na ich  całkowicie odmienną techniczną implementację. Z jego punktu widzenia zarówno pomiesznienie oznaczone tagiem NFC, jak i współrzędne geograficzne, stanowią po prostu lokację w której gracza mogą spotkać dowolnego typu przygody. 

### Słowa Kluczowe:

Android, DSL, Xtext, Location-Based Game, Framework, Engine

### Spis treści

1. Opis problemu
  - Porównanie dostępnych rozwiązań
    - Istniejące gry terenowe
    - Obszary zastosowań DSL
  - Zastosowania DSL w grach terenowych
2. Projekt i analiza 
  - Wymagania 
    - Funkcjonalne 
    - Niefunkcjonalne
  - Diagram klas
  - Projekt interfejsu użytkownika
3. Implementacja
  - DSL
    - Internal DSL
    - External DSL
  - Użyte technologie
    - Java
    - AndroidSDK
    - JUnit, Mockito
    - Xtext
    - Xtend
    - Dagger 2
  - Architektura rozwiązania
    - Xtext DSL
    - Aplikacja
4. Testy
  - Scenariusz testowania
    - Automatyczne
    - Manualne
  - Raport z testów
    - Automatyczne
    - Manualne
5. Korzystanie z frameworka
6. Przykładowa gra
7. Wkład własny
8. Bibliografia

### Bibliografia
Ian F. Darwin, 2013. Android Receptury. Wydawnictwo: Helion.

[Xtext](https://eclipse.org/Xtext/documentation/index.html)

### Do wykorzystania

W pracy postanowiłem opisać czym właściwie są jezyki domenowe (DSL), ponieważ stanowią one punkt wyjściowy w realizacji założeń  projektowych. Dzięki wykorzystaniu języka DSL możliwe było stworzenie narzędzia bardzo prostego i przyjaznego w obsłudze w relatywnie krótkim czasie. Umieściłem też rozdziały opisujące wykorzystane przeze mnie narzędzia takie jak: Android SDK, Xtext, Adroid Studio.

Niniejsza praca zawiera opis stworzonego języka oraz silnika gry. Osobny rozdział został poświęcony przygotowaniu środowiska pracy dla osoby, która chciałaby wykorzystać mój silnik do napisania własnej gry. Jest też część ilustrująca jak korzystać z narzędzia, w której krok po kroku pokazuje jak stworzyć przykładową grę na postawię przygotowanego scenariusza. 

W pracy opisany jest cały proces powstawania narzędzia. Osobne rozdziały zawierają opis powstawania projektu, jego implementacji oraz testów.
