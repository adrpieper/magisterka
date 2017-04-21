## Adventure Maker - Framework dla terenowych gier RGP

### Streszczenie

W ramach niniejszej pracy zostało zaprojektowane i zaimplementowane frameworka pozwalającego w prosty sposób tworzyć terenowe gry RPG. Kluczowym elementem frameworku jest specjalny język opisu scenariuszy oraz zasad panujących w grze - Adventure Maker Language. Język ten został stworzony z użyciem technologii Xtext. Dzięki wykorzystaniu tego narzędzia możliwa była względnie szybka implementacja nowego języka, zawierającego takie elementy jak linker, czy kompiler. Dodatkowo powstały język zintegrowany jest z IDE Idea InteliJ co pozwala na podświetlanie, autouzupełnianie oraz automatyczne sprawdzanie składni.
  
Stworzone gry wykorzystują technologię NFC oraz GPS w celu lokalizacji graczy w pomieszczeniach, jak i na otwartym terenie. Framework został zaprojektowany tak, aby twórca gry mógł traktować te dwie technologie w sposób bardzo zbliżony, nie zważając na ich  całkowicie odmienną techniczną implementację. Z jego punktu widzenia zarówno pomieszczenie oznaczone tagiem NFC, jak i współrzędne geograficzne, stanowią po prostu lokację, w której gracza mogą spotkać dowolnego typu przygody. 
  
Przy implementacji frameworka wykorzystane zostały popularne narzędzia i biblioteki. Dodatkowo kod był pisany zgodnie z zasadami czystego kodu. Uprościło to znacznie i przyśpieszyło proces implementacji, testowania i budowania stworzonego frameworka.

### Wstęp

Gry terenowe, czyli aplikacje rozrywkowe basujące głównie na fizycznej pozycji gracza, są nowym trendem w dziedzinie rozrywki elektronicznej. Sukces niedawno wydanej gry "Pocemon GO" pokazał, że pomysł by gracz musiał poruszać się po fizycznym świecie jest strzałem w dziesiątkę. Okazuje się, że na gry tego typu znajduje się całkiem spora rzesza odbiorców, czego nie dało się nie zauważyć, gdyż grupy poszukiwaczy pokemonów, spotkać można było niemal na każdym kroku.

Pomimo sukcesu "Pocemon GO", gry terenowe nadal stanowią marginalną część rynku rozrywki elektronicznej. Moim zdaniem niewielka ilość aplikacji tego typu, wynika z braku odpowiednich narządzi do ich tworzenia. Napisanie tego typu gier z wykorzystaniem standardowych narzędzi developerskich jest dość skomplikowane, a przez to kosztowne. Wykorzystanie technologii typu GPS, czy NFC wymaga od programisty wiedzy, wykorzystania specjalistycznego API oraz sprawia, że testowanie aplikacji jest utrudnione.

Spora część elementów gier terenowych jest wspólna, szczególnie jeśli ograniczymy się do gier RPG. Skoro gry tego typu opierają się na podobnych zasadach, powinny one zostać zdefiniowane tylko raz, w myśl zasady - "nie powtarzaj się". W ten sposób można odciążyć projektanta gry od szczegółów implementacyjnych, pozwalając mu skupić się w całości na tym co ważne. W idealnym świecie napisanie tego typu gry powinno sprowadzać się jedynie do zdefiniowania miejsc, postaci oraz zasad obowiązujących w wirtualnym świecie. Postanowiłem więc sprawdzić, czy osiągnięcie takiego ideału jest możliwe. Okazuje się, że tak, o ile tylko zastosuje się do tego odpowiednie podejście i narzędzia.

Sam pomysł umieszczenia warstwy wspólnej dla wielu aplikacji nie jest nowy. Istnieje wiele rozwiązanie, które już to robią. Warstwę tą nazywa się frameworkiem lub silnikiem. Większość powstających obecnie gier osadzonych jest właśnie na tego typu rdzeniu. Nie istnieje natomiast jeszcze framework, wyspecjalizowany do tworzenia konkretnego typu gier, jakimi są terenowe gry RPG. Dlatego właśnie uznałem, że terenowe gry RPG. 

Moim celem nie było stworzenie niesamowicie grywalnej, ani popularnej gry. Chciałem pokazać, na modnym przykładzie gier terenowych, jak można rozwiązać problem "wynajdywania koła na nowo" wykorzystując własny język domenowy. Powstały język pozwala na implementacje prostej gry przez osobę niebędącą programistą. Składnia języka jest przyjazna dla projektanta gry i nie wymaga znajomości, ani żadnego języka programowania ogólnego przeznaczenia, ani żadnych dodatkowych technologii.

### Słowa Kluczowe:

Android, DSL, Xtext, Location-Based Game, RPG, Framework

### Spis treści

Spis treści
Spis treści
Wprowadzenie . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 7
1. Opis problemu . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 9
1.1. Gry terenowe . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 9
1.2. Gry RPG . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 10
1.3. DSL . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 11
1.3.1. Internal DSL . . . . . . . . . . . . . . . . . . . . . . . . . 11
1.3.2. External DSL . . . . . . . . . . . . . . . . . . . . . . . . . 12
1.4. Frameworki . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 12
1.5. Zastosowania DSL w grach terenowych . . . . . . . . . . . . . . . 13
2. Wymagania . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 15
2.1. Funkcjonalne . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 15
2.2. Niefunkcjonalne . . . . . . . . . . . . . . . . . . . . . . . . . . . 16
3. Technologie . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 17
3.1. Xtext . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 17
3.2. Xtend . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 17
3.3. Android SKD . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 18
3.4. JUnit . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 18
3.5. Mockito . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 18
3.6. Dagger 2 . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 19
3.7. Gradle . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 19
4. Projekt GUI . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 20
4.1. Menu początkowe . . . . . . . . . . . . . . . . . . . . . . . . . . 20
4.2. Tryb zwiedzania . . . . . . . . . . . . . . . . . . . . . . . . . . . 20
4.3. Tryb przygody . . . . . . . . . . . . . . . . . . . . . . . . . . . . 21
4
Spis treści 5
5. Architektura rozwiązania . . . . . . . . . . . . . . . . . . . . . . . . . 23
5.1. AML . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 23
5.1.1. Definicja Gramatyki . . . . . . . . . . . . . . . . . . . . . 23
5.1.2. Generator . . . . . . . . . . . . . . . . . . . . . . . . . . 24
5.2. Aplikacja Android . . . . . . . . . . . . . . . . . . . . . . . . . . 24
5.2.1. Standardowy kod aplikacji . . . . . . . . . . . . . . . . . 25
5.2.2. Zasoby . . . . . . . . . . . . . . . . . . . . . . . . . . . . 27
5.2.3. Plik manifestu . . . . . . . . . . . . . . . . . . . . . . . . 28
5.2.4. Gradle . . . . . . . . . . . . . . . . . . . . . . . . . . . . 28
5.2.5. Testy . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 28
5.2.6. Wewnętrzy język AML . . . . . . . . . . . . . . . . . . . 28
5.2.7. Plik game.aml . . . . . . . . . . . . . . . . . . . . . . . . 29
5.2.8. Wygenerowany Kod implementujący zasady gry . . . . . . 29
5.2.9. Przykładowy Kod implementujący zasady gry . . . . . . . 29
6. Testy . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 30
6.1. Testy automatyczne . . . . . . . . . . . . . . . . . . . . . . . . . . 30
6.1.1. Struktura testów . . . . . . . . . . . . . . . . . . . . . . . 30
6.1.2. Wyniki . . . . . . . . . . . . . . . . . . . . . . . . . . . . 31
6.2. NFC i GPS . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 31
6.3. Pliku AML . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 32
6.3.1. Sprawdzenie poprawności zachowania . . . . . . . . . . . 32
7. Korzystanie z frameworka . . . . . . . . . . . . . . . . . . . . . . . . 33
7.1. Konfiguracja środowika . . . . . . . . . . . . . . . . . . . . . . . 33
7.1.1. JRE . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 33
7.1.2. JDK . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 33
7.1.3. IDE - IntelliJ Idea . . . . . . . . . . . . . . . . . . . . . . 33
7.1.4. Android SDK . . . . . . . . . . . . . . . . . . . . . . . . 34
7.1.5. Wtyczka AML . . . . . . . . . . . . . . . . . . . . . . . . 34
7.2. Przygotowanie projektu . . . . . . . . . . . . . . . . . . . . . . . 34
7.3. Implementacja gry . . . . . . . . . . . . . . . . . . . . . . . . . . 34
7.4. Kompilacja projektu . . . . . . . . . . . . . . . . . . . . . . . . . 35
6 Spis treści
8. Adventure Maker Language . . . . . . . . . . . . . . . . . . . . . . . . 36
8.1. Struktura pliku AML . . . . . . . . . . . . . . . . . . . . . . . . . 36
8.2. Przygody Początkowe . . . . . . . . . . . . . . . . . . . . . . . . 36
8.3. Klasy Postaci . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 37
8.4. Typy Przedmiotów . . . . . . . . . . . . . . . . . . . . . . . . . . 38
8.5. Lokacje . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 39
8.6. Przeciwnicy . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 40
8.7. Przygody . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 41
8.7.1. Komunikat . . . . . . . . . . . . . . . . . . . . . . . . . . 41
8.7.2. Walka . . . . . . . . . . . . . . . . . . . . . . . . . . . . 42
8.7.3. Zdarzenie Warunkowe . . . . . . . . . . . . . . . . . . . 42
8.7.4. Pytanie . . . . . . . . . . . . . . . . . . . . . . . . . . . . 43
8.7.5. Modyfikacja Przygód . . . . . . . . . . . . . . . . . . . . 44
8.7.6. Przykład . . . . . . . . . . . . . . . . . . . . . . . . . . . 45
9. Przykładowa gra . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 47
9.1. Opis scenariusza . . . . . . . . . . . . . . . . . . . . . . . . . . . 47
9.2. Uruchamianie gry . . . . . . . . . . . . . . . . . . . . . . . . . . 48
A. Kod przykładowej gry . . . . . . . . . . . . . . . . . . . . . . . . . . . 49
Bibliografia . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 55
Spis tabel . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 56
Spis rysunków . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 57
Oświadczenie . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 58
