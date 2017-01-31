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
  - Konfiguracja środowiska 
  - Adventure Maker Language
  - Przykładowa gra
7. Wkład własny
8. Bibliografia

### Bibliografia
Ian F. Darwin, 2013. Android Receptury. Wydawnictwo: Helion.


[Xtext](https://eclipse.org/Xtext/documentation/index.html)
[Xtent](http://www.eclipse.org/xtend)

### Do wykorzystania

Niniejsza praca zawiera opis stworzonego języka oraz silnika gry. Osobny rozdział został poświęcony przygotowaniu środowiska pracy dla osoby, która chciałaby wykorzystać mój silnik do napisania własnej gry. Jest też część ilustrująca jak korzystać z narzędzia, w której krok po kroku pokazuje jak stworzyć przykładową grę na postawię przygotowanego scenariusza. 

W pracy opisany jest cały proces powstawania narzędzia. Osobne rozdziały zawierają opis powstawania projektu, jego implementacji oraz testów.


## Wymagania
### Funkcjonalne
- Język DSL zawieający elemnty takie jak
  - Klasy Postaci
  - Przedmioty
  - Zdarzenia
  - Przeciwnicy
- Integracja ze środowiskiem IntelliJ Idea
- Kompilacja aplikacji na podstawie pliku DSL 
  
### Niefunkcjonalne
- Tworzenie gier RPG bez znajomości języków programowania ogólnego przeznaczenia oraz znajomości technologii

## Technologie
### Xtext

Xtext to framework służący do implementacji języków DSL. Xtext tworzy infrastrukturę języka zawierającą elementy takie jak: parser,linker, typechecker, compiler na podstawie gramatyki języka. Dodatkowo postwala na integracje zaprojektowane języka z popularnymi IDE, eclipse oraz IntelliJ Idea.

### Xtend

Xtend jest językiem programowania wywodzącym się z JAVY i składniowo zbliżonym do JAVY. Został zaprojektowany, aby wyeliminować kilka wad języka Java. Zawiera elementy niedostępne w Javie oraz upraszcza niektóre strutury pozwalając na pozbycie się niepotrzebnego kody. Kodem wynikowym dla języka Xtext jest Java. Mamy tu więc do czynienia z tranpilacją, czyli przetłumaczeniem jednego kodu źródłowego w inny.
W moim projekcie Xtend został użyty ze względu na technologie Xtext. Wykorzystanie Xtend jest zalecanym sposobem implementacji generatorów dla języków DSL tworzonych przy użyciu Xtend. Główną zaletą języka Xtext, w kontekście pisania generatorów kodu są szablony, które nie są dostępne w języku JAVA.

### Android SKD

Android SDK to zestaw standardowych narzędzi programisty umożliwiający tworzenie aplikacji na platformę Android. Zestaw podzielony jest na dwie części, zależną i niezależną od wersji systemu. Całość pakietu SDK podzielona jest na moduły, które można instalować i deinstalować w prosty sposób za pomocą aplikacji SDK manager. Aplikacje napisane w oparciu o Android SDK piszę się w języku JAVA.

### JUnit

JUnit jest to framework służący do testowania programów napisanych w języku Java.

### Mockito

Mockito to biblioteka ściśle związana z frameworkiem JUnit. Umożliwia tzw. mockowanie obiektów na czas testów. Mockowanie polega na przechwyceniu metod klas będących zależnościami testowanej klasy, tak aby można było sprawdzić poprawność działania klasy w oderwaniu od poprawności działania całego systemu.

### Dagger 2

Dagger 2 to biblioteka umożliwiająca wstrzykiwanie zależności w Androdzie. Istnieje wiele bibliotek umożliwiających DI, jednak Dagger 2 jest wśród programistów Androida. Jego główną zaletą jest rozstrzyganie zależności w czasie kompilacji oraz generacja kodu. Dzięki temu możemy wykryć wady projektu, takie jak zależności cykliczne jeszcze przed uruchomieniem aplikacji. Dodatkowo wygenerowany kod jest o wiele szybszy niż typowe rozwiazanie czasu wykonania - czyli refleksja.

## DSL

Istnotnym elementem implementacji Andventure Makera są języki domenowe, czyli jezyki programowania zaoprojektowane z myślą o ściśle określonym zastosowaniu. W odróżnieniu od języków programowania ogólnego przeznaczenia, języki domenowe umożliwiają rozwiązanie tylko określonych problemów. Dzięki ograniczeniu się jedynie do wąstkiej grupy zastosowań, możliwe jest tworzenie języków, które są zrozumiałe dla osób będących ekspertami w danej dziedzinie. Języki domenowe należą zazwydzaj do języków deklaratywnych, gdyż skupiąnę są wokół tego co, a nie w jaki sposób chce osiągnąć programista.

Języki domenowe ze względu na sposób ich implementacji można podzielić na dwie grupy:
  - Języki wewnętrzne (Internal DSL)
  - Języki zewnętrzne (External DSL)
 
W moim projektcie wykorzystałem zawróno wewnętrzny, jak i zerwnętrzny język domenowy. Zastosowanie zewnętrznego DSL pozwala twórcy gry na opisanie świata gry w sposób przyjazny dla osoby znającej tematykę gier RPG. Wewnętrzy DSL natomiast, sprawił, że generowany przez przez framework kod jest bardziej czytelny i przyjazny dla programisty, co w dużym stopniu przyczyniło się do skrócenia czasu potrzebnego mi do zaimplementowania generatorów.
  
### Internal DSL
Jest to język stworzonych w ramach innego istniejącego już języka ogólnego przeznaczenia. Technicznie rzecz biorą jest to zbiór klas udostępniających wygodny dla programisty, dający wrażenie pisania w innym języku zbiór metod. Klasy te umieszcza się zazwyczaj w bibliotece, którą możemy użyć w do rozwiązania ściśle określonego problemu. Główną cechą takich bibliotek jest wyraźne nastawienie na udostępniany interfejs, a nie samą implementacje. O jakości takiego rozwiąznie świadczy nie tyle wydajność jego działania, lecz łatwość używania. Biblioteki takie dają programiście wrażenie pisania w zupełnie nowym, wyrażającym w możliwie najlepszy sposób jego intencje języku.

W framewodku Adventure Maker również został wykorzystany zewnętrzny język domenowy. W jego skład wchodzą klasy umieszczone w pakiecie "".
Poniżej znajduje się przykład kodu napisanego z wykorzystaniem tego języka.
--KOD--
Przytoczony kod opisuje mogące wystąpić czasie gry zdarzenie. Chodź na to nie wygląda, kod ten został napisany oczywiście w Javie.

### External DSL
Jest to jezyk domenowy z prawdziwego zdarzenia. Język taki posiada ściśle określoną gramatykę i od początku został zaprojektowany w ściśle określonym celu. Przykładami takich języków są:
  - SQL - język służący do obsługi relacyjnych baz danych
  - CSS - język służący do definiowania stylu stron intenetowych 
  - HTML - język służący do definiowania struktury strony internetowej

Na potrzeby frameworka stworzyłem zupełnie nowy zewnętrzy język domenowy o nazwie Adventure Maker Language.
Opis tego języka znajduje się w rozdziale korzystaniu z frameworka.

## Architektura rozwiązania
W celu stworzenia frameworka Adventure Maker utworzyłem dwa projekty. Pierwszy to projekt odwpowiedzialny za DSL Andventure Maker Language. Projekt bazuje na technologii Xtext, a produktem wyjściowym jest wtyczka do IDE IntelliJ Idea obsługująca zaprojektowany DSL.
Drugi projekt, to szkielet aplikacji na system Android. Kod aplikacji jest częściowo napisany w AML i do jego kompilacji potrzebna jest jeog obsługa.

### Xtext DSL
Projekt powstał w celu implementacji języka Andventure Maker Language. Wykorzystanie technologii Xtext [] wymaga implementacji dwóch elementów gramatyki i generatorów kodu.
#### Definicja Gramatyki
Gramatyka języka została umieszczona w pojedyńczym pliku -nazwa pliki-. Głównym celem stworzenia gramatyki jest opis modelu syntaktycznego i semantycznego tworzonego języka. Innymi słowy musimy zdefiniować jaki tekst będzie należał do języka oraz jak zmapować dany tekst na jego reprezentacje w pamięci komputera [dokumentacja]. Xtext na podstawie tego pliku wygeneruje między innymi parser, który sprawdzi, czy dany tekst poprawnym programem oraz zwróci jego reprezentacje w postaci drzewa obiektów.
#### Generator
Generator języka odpowiedzialny jest za wygenerowanie kodu (w tym przypadku kodu Java) na podstawie modelu semantycznego zwróconego przez parser w postacie drzewa obiektów. Generator został napisany w języku Xtend i zkłada się z głównej klasy implementującej metodę -nazwa metody- oraz klas pomocniczych utworzonym w celu dekompozycji problemu na mniejsze części zgodnie z zasadą pojedynczej odpowiedzialności [źródło].

### Aplikacja Android
- Plik aml
- Podział na moduły itp...

## Testy
W celu sprawdzenia powprawności dzialania stworzonego oprogramowania postanowiłem je oczywiście przetestować. Na pierwszym miejscu postawiłem testy automatyczne, ponieważ są najbardziej praktyczne i wiarygodne. Testy automatyczne zaimplementowałem w postaci mokowanych testów jednostkowych za pomocą technologii JUnit i Mockito.
Niestety nie każdy dało się pokryć testemi automatycznymi wszystkich funcjonalności. Z tego powodzu część kodu została przetestowana w sposób manualny. Elementami przetestowanymi w ten sposób są działanie modułu NFC, GPS oraz generacja kodu. Do każdego z tych elemetów przygotowałem scenariusz testowy, który następnie wykonałem. Sposób przeprowadzenia oraz wyniki tych testów zostały przedstawione poniżej.
### Scenariusze testowania
#### Testy automatyczne 
Podczas  automatycznych testów jednostkowych testowałem z osobna działanie poszczególnych funkcji w oderwaniu od reszty systemu, z tego powodu scenariusz każdego testu jest bardzo podobny. Każdy test został podzielone na 3 sekcje, w których umieszczony został kod odpowiedniego typu:
  - GIVEN
  - WHEN
  - THEN
  
#### NFC
#### GPS
#### Generowanie kodu
### Wyniki

## Korzystanie z frameworka
### Konfiguracja środowika
Pierwszym krokiem w celu konfiguracji środowika jest przygotowanie IDE oraz odpowiednich narzędzie. Należy pobrać i zainstalować w standarodowy sposób IntelliJ Idea, JRE, JDK i Android SDK. Drugim krokiem jest przygotowanie wtyczki do IntelliJ Idea. Wtyczka ta odpowiedzialna będzie za obsługę języka AML w tym za generacje kodu Java na podstawie pliku ".aml". Można pominąć ten etap pobierając gotową wtyczkę. Wtyczkę należy zaistalować w środowisku w IDE IntelliJ Idea. Kiedy mamy już potrzebne oprogramowanie należy jeszcze pobrać pusty projekt i można przystąć do stworzenia własnej gry. Napisanie własnej gry sprowadza się do edycji jednego pliku mianowicie "game.aml". Należy w nim umieścić kod w języku AML.

### Adventure Maker Language
Adventure Maker Language to język domenowy stworzony specjalnie na potrzeby frameworka Adventure Maker. Poniżej znajduje się dokumentacja tego języka.

### Przykładowa gra
Aby ułatwić korzystanie z frameworka postanowiłem przygotować przykładową grę. Poniżej znajduje się kod AML potrzebny do skompilowania gry oraz opis każdego z jego elementów.

    KOD AML
  OPIS
