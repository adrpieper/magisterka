## NazwaFrameworka - Framework dla terenowych gier RGP

### Wstęp

NazwaFrameworka - to framework umożliwiajcego szybkie tworzenie terenowych gier RPG. Programista korzystający z tego narzędzia pełnił bedzie funkcję Game Mastera znanego z gier fabularnych, czyli wirtualnego świata wraz z zadasami w nim panującymi. Framework pozwalał będzie na implementacje prostej gry nawet przez mało doświadczonego programistę. Będzie to możliwe dzieki stworzeniu specjalnego języka DSL zaprojektowanego właśnie w tym celu. Składnia języka będzie przyjazna dla programisty-projektanta gry i pozwoli mu się skupić na stworzeniu ciekawego wirtualnego świata w czym pomocne mu będzie odciążenie go od szczegółów implementacyjnych.

Stworzenie gry z użyciem narzędzia w najprostrzym przykadku sprowadzać sie bedzie do rozmieszczenie przeciwników na terenie danego obiektu (znacznik NFC) lub danej lokalizacji (Wspólrzedne geograficzne) oraz ustalenia klas postaci dostepnych w danej rozgrywce.

### Streszczenie

Celem niniejszej pracy jest projekt i implementacja narzędzia pozwalającego w prosty sposób tworzyć terenowe gry RPG. Aby osiągnąć ten cel zaprojektowany został specjalny język opisu sceneriuszy oraz zadad panujących w grze. Język ten został stworzony z użyciem technologii Xtext [2]. Dzięki wykorzystaniu tego narzędzia możliwa jest względnie szybka implementacja nowego języka, zawięrającego takie elementy jak linker, czy kompiler. Dodatkowo powstały język zintegrowany jest z IDE Idea InteliJ co pozwala na podświetlanie, autouzupełnianie oraz automatyczne sprawdzanie składni.

Stworzony silnik gier wykorzystuje technologię NFC oraz GPS w celu lokalizacji graczy w pomieszczeniach, jak i na otwartym terenie. Silnik został zaprojektowany tak, aby twórca gry mógł traktować te dwie technologie w sposób bardzo zbliżony, nie zważając na ich  całkowicie odmienną techniczną implementację. Z jego punktu widzenia zarówno pomiesznienie oznaczone tagiem NFC, jak i współrzędne geograficzne, stanowią po prostu lokację w której gracza mogą spotkać dowolnego typu przygody. 

W pracy postanowiłem opisać czym właściwie są jezyki domenowe (DSL), ponieważ stanowią one punkt wyjściowy w realizacji założeń  projektowych. Dzięki wykorzystaniu języka DSL możliwe było stworzenie narzędzia bardzo prostego i przyjaznego w obsłudze w relatywnie krótkim czasie. Umieściłem też rozdziały opisujące wykorzystane przeze mnie narzędzia takie jak: Android SDK, Xtext, Adroid Studio.

Niniejsza praca zawiera opis stworzonego języka oraz silnika gry. Osobny rozdział został poświęcony przygotowaniu środowiska pracy dla osoby, która chciałaby wykorzystać mój silnik do napisania własnej gry. Jest też część ilustrująca jak korzystać z narzędzia, w której krok po kroku pokazuje jak stworzyć przykładową grę na postawię przygotowanego scenariusza. 

W pracy opisany jest cały proces powstawania narzędzia. Osobne rozdziały zawierają opis powstawania projektu, jego implementacji oraz testów. 

### Słowa Kluczowe:

Android, DSL, Xtext, Location-Based Game, Framework, Engine

### Bibliografia
Ian F. Darwin, 2013. Android Receptury. Wydawnictwo: Helion.
[Xtext](https://eclipse.org/Xtext/documentation/index.html)
