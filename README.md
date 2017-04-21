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
