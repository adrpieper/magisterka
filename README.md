## Adventure Maker - Framework dla terenowych gier RGP

### Streszczenie

Celem niniejszej pracy jest projekt i implementacja narzędzia pozwalającego w prosty sposób tworzyć terenowe gry RPG. Aby osiągnąć ten cel zaprojektowany został specjalny język opisu sceneriuszy oraz zadad panujących w grze. Język ten został stworzony z użyciem technologii Xtext [2]. Dzięki wykorzystaniu tego narzędzia możliwa jest względnie szybka implementacja nowego języka, zawięrającego takie elementy jak linker, czy kompiler. Dodatkowo powstały język zintegrowany jest z IDE Idea InteliJ co pozwala na podświetlanie, autouzupełnianie oraz automatyczne sprawdzanie składni.

Stworzony silnik gier wykorzystuje technologię NFC oraz GPS w celu lokalizacji graczy w pomieszczeniach, jak i na otwartym terenie. Silnik został zaprojektowany tak, aby twórca gry mógł traktować te dwie technologie w sposób bardzo zbliżony, nie zważając na ich  całkowicie odmienną techniczną implementację. Z jego punktu widzenia zarówno pomiesznienie oznaczone tagiem NFC, jak i współrzędne geograficzne, stanowią po prostu lokację w której gracza mogą spotkać dowolnego typu przygody. 

### Wstęp

Gry terenowe, czyli aplikacje rozrywkowe basujące głównie na fizycznej pozycji gracza, są nowym trendem w dziedzinie rozrywki elektronicznej. Do tej pory ukazało się niewiele tytułów tego typu, co mogłoby sugerować, że pomysł by gracz musiał poruszać się po fizycznym świecie jest nietrafiony. Sukces niedawno wydanej gry "Pocemon GO" pokazał jednak, że na gry tego typu znajduje się całkiem spora rzesza odbiorców, czego nie dało się nie zauważyć, gdyż grupy poszukiwaczy pokemonów, spotkać można było niemal na każdym kroku.

Moim zdaniem niewielka ilość aplikacji tego typu, wynika z braku odpowiednich narządzi do ich tworzenia. Napisanie tego typu gier z wykorzystaniem standardowego SDK systemów mobilnych jest dość skomplikowane, a przez to kosztowne. Wykorzystanie technologii typu GPS, czy NFC wymaga od programisty wykorzystnia specjalistycznego API oraz sprawia, że testowanie aplikacji jest utrudnione.

W idealnym świecie napisanie tego typu gry powinno sprowadzać się jedynie do zdefiniowania miejsc, postaci oraz zasad obowiązujących w wirtualnym świecie.
Skoro gry tego typu opierają się na podobnych zasadach, powinny one zostać zdefiniowane raz i reużywane, odciążając tym samym projektanta gry od szczegółów implementacyjnych. 

Sam pomysł umieszczenia warstwy wspólnej dla wielu aplikacji nie jest nowy. Isnieje wiele rozwiązanie, które już to robią. Warstwę tą nazywa się frameworkiem lub silnikiem. Większość powstających obecnie gier osadzonych jest właśnie na tego typu rdzeniu. 
Nie istnieje natomiast jeszcze framework, wyspecjalizowany do tworzenia konkretnego typu gier, jakimi są terenowe gry RPG i zmniejszający wysiłem związany z tworzeniem takiej gry do obsolutnego minimum. Dlatego właśnie postanowiłem storzyć Adventure Maker - framework umożliwiający szybkie tworzenie terenowych gier RPG. 

Framework pozwala na implementacje prostej gry nawet przez mało doświadczonego programistę nieznającego Javy ani AndroidSDK. Jest to możliwe dzieki specjalnemu językowi DSL zaprojektowanego właśnie w tym celu. Składnia języka jest przyjazna dla programisty-projektanta gry i nie wymaga znajomości, ani żadnego języka programowania ogólnego przeznaczenia, ani żadnych dodatkowych technologii.

Stworzenie gry z użyciem narzędzia w najprostrzym przykadku sprowadza sie do rozmieszczenie przeciwników na terenie danego obiektu (znacznik NFC) lub danej lokalizacji (Wspólrzedne geograficzne) oraz ustalenia klas postaci dostepnych w danej rozgrywce.

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
