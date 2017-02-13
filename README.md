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
  - Gry terenowe
  - Gry RPG
  - DSL
  - Frameworki
  - Zastosowanie DSL w grach terenowych
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

## Opis problemu
Celem niniejszej pracy jest implementacja frameworku służącego do szybkiego tworzenia terenowych gier RPG. Najważniejszym moim zdaniem elementem tej implentacji jest stworzony język domenowy. Niniejsza praca zachacza więc o cztery z pozoru niezwiązane ze sobą tematyki jakimi są gry terenowe, gry RPG, frameworki oraz języki domenowe. Aby wprowadzić czytelnika w tematykę pracy, postanowiłem opisać z osobna, każdy z  tych elementów oraz sposób w jaki postanowiłem je ze sobą połączyć.  
### Gry terenowe
Rozwój technologii mobilny sprawił, że od paru lat na rynku rozrywki elektronicznej pojawił się nowy nowy pomysł. Pomysłem tym są gry terenowe, czyli takie, w których istotną częścią rozgrywki jest poruszanie się gracza po świecie rzeczywistym. W grach tych zrezygnowano ze znanego z tradycyjnych gier wirtualnego świata na rzecz tzw. rzeczywistości rozszerzonej [źródło]. W grach terenowych gracz nie steruje już postacią za pomocą myszki, czy klawiatury, lecz jest zmuszony do fizycznego przemieszczania się po rzeczywistym świecie. Lokalizacja gracza zostaje przeniesiona do świata gry za pomocą technologii takiej jak np. GPS. Mapa po której porusza się gracz jest więc mapą znaną z lekcji geografii. Elementami które sprawiają, że świat gry jest rzeczywistością rozszerzoną są pojawiające się w grze, a nie istniejące w rzeczywistości, obiekty lub postaci które wpływają w jakiś sposób na przebieg rozgrywki.

Doskonały przykładem gry terenowej jest Pokemon GO. Gra...

Inny pomysł na wykorzystanie lokalizacji gracza mieli twórcy ...
### Gry RPG
Gry RGP inaczej gry fabularne [źródło wiki], są to gry w których gracze wcielają się w rolę fikcyjnych postaci poruszających się po fikcyjnym świecie.  Celem graczy jest zazwyczaj ukończenie jakiegoś scenariusza, badź też po prostu usiągnięcie określonego celu np. zbobycie jakiegoś przedmiotu, danej ilości złota lub rozwój postaci do konkretnego poziomu. Istnieją też gry otwarte, w których gracz nie ma żadnego narzuconego celu, a jedynie przemierza fikcyjny świat ze znanej tylko sobie motywacji. Tradycyjnie grę tego typu rozgrywa się w wyobraźni graczy. Jeden z graczy wciela się wtedy w tzw. mastera gry. Zadaniem mastera jest o prowadzenia graczy przez świat gry poprzez opowiadanie pewnej historii oraz zadawanie pytań. Master przedstawia graczą jak wygląda sytuacja, w której znajduję się ich postacie oraz karze im podjąć decyzje jak w tej sytuacji ich postacie się zachowają. Gracze podejmują decyzję, po czym master gry określa z jakimi skutkami się ona wiąże i przechodzi do dalszej opowieści. Aby zachować pewną spójność gry, master podejmuje decyzję w oparciu o ustalony zbiór zasad (tzw. mechanikę gry), zazwyczaj efekt podjętej decyzji zależy też od rzutu kością.

Oprócz tradycyjnej odmiany gier fabularnych powstały tej ich planszowe oraz komputerowe odmiany. W grach tych nie już mastera. Gry takie mają z góry narzucony scenariusz oraz zasady. 

Jednym z najpopularniejszych przykładów planszowych gier RPG jest Magia i Miecza. Gracze wybierają w niej jedną z kilkudziesieciu postaci. A ich celem jest dostanie się do tzw. Korony Władzy. 

W świecie gier komputerowych, RPG osiągneły niekwestionowany sukces. Wydanych tytułów są całe dziesiątki, a elementy tych gier takie jak rozwój i statystyki postaci przedostały się już do prawie każdego gatunku gier komputerowcych.

### DSL 
[źródło]
DSL, czyli języki domenowe, to jezyki programowania zaoprojektowane z myślą o ściśle określonym z reguły bardzo wąskim zastosowaniu. W odróżnieniu od języków programowania ogólnego przeznaczenia, języki domenowe nie nadają się do rozwiązania większości problemów informatycznych. Dzięki ograniczeniu się jedynie do wąstkiej grupy zastosowań, możliwe jest tworzenie języków, które są zrozumiałe dla osób będących ekspertami w danej dziedzinie. Języki domenowe należą zazwyczaj do języków deklaratywnych, gdyż skupiąnę są wokół tego co, a nie w jaki sposób chce osiągnąć programista.

Języki domenowe ze względu na sposób ich implementacji można podzielić na dwie grupy:
  - Języki wewnętrzne (Internal DSL)
  - Języki zewnętrzne (External DSL)

#### Internal DSL
Jest to język stworzonych w ramach innego istniejącego już języka ogólnego przeznaczenia. Technicznie rzecz biorą jest to zbiór klas udostępniających wygodny dla programisty, dający wrażenie pisania w innym języku zbiór metod. Klasy te umieszcza się zazwyczaj w bibliotece, którą możemy użyć w do rozwiązania ściśle określonego problemu. Główną cechą takich bibliotek jest wyraźne nastawienie na udostępniany interfejs, a nie samą implementacje. O jakości takiego rozwiąznie świadczy nie tyle wydajność jego działania, lecz łatwość używania. Biblioteki takie dają programiście wrażenie pisania w zupełnie nowym, wyrażającym w możliwie najlepszy sposób jego intencje języku.
Przykładami taki języków są np. język asercji z bilioteki AsserJ lub język mocków z bilioteki Mockito. 

#### External DSL
Jest to jezyk domenowy z prawdziwego zdarzenia. Język taki posiada ściśle określoną gramatykę i od początku został zaprojektowany w ściśle określonym celu. Nie jest on częścią innego języka, chodź często z nim ściśle współpracuje. Przykładem takiej współpracy może być np komunikacja z bazą danych, gdzie kod programu (napisany np w języku JAVA), wywołuje pewne zapytanie w języku SQL. Przykładami takich języków są:
  - SQL - język służący do obsługi relacyjnych baz danych
  - CSS - język służący do definiowania stylu stron intenetowych 
  - HTML - język służący do definiowania struktury strony internetowej

### Frameworki
Frameworki są doskonałym przykładem korzyści jakie niesie ze sobą popularna zasada Clean Code - DRY (Don't Repeat Yourself) czyli nie powtarzaj się. 
Twórcy frameworków  wychodzą z założenia, że projekty informatyczne można z powodzeniem podzielić na pewne grupy np aplikacje webowe. Projekty informatyczne należące do takiej grupy bywają do siebie tak podobne, że zazwyczaj łatwiej jest wzkazać cechy wspólne niż różnice. Aplikacje webowe np. udostępniają pewien interfejs w postaci stron html, przechowują dane w bazach (zazwyczaj relacyjnych) i komunikują się z użytkownikiem za pomocą protokołu HTTP. Elementem różniącym te aplikacje jest ich wygląd i funkcjonalność. Ideą frameworku jest implementacja tych elementów wspólnych w jednym miejscu i udostępnienie programistom-użytkownikom frameworku przyjaznego interfejsu do implementacji różnic. Programista pisze jest ograniczony pewnymi ramami, w których musi mieścić się jego aplikacja, stąd nazwa takiego narzędzia - framework.

Z uwagi na fakt, że gry RPG są bardzo popularne, a jednocześnie do siebie bardzo podobne, naturalnym wydaje się stworzenie oprogramowania pozwalające na łatwe tworzenie takiego typu gier. Narzędzie RPG Maker [http://www.rpgmakerweb.com/] pozwala na proste tworzenie dwuwymiarowych gier RPG. Według twórców, tworzenie gier przy pomocy RPG Maker, jest możliwe bez jakiejkolwiek wiedzy na temat programowania, a jednocześnie dając bardzo duże możliwości doświadczonym użytkownikom. Oprogramowanie udostępnia przyjazne GUI, dzięki któremu można tworzyć w pełni funkjonalnego gry i to na wiele różnych platforma. Jedynym, ale bardzo istotnym ograniczeniem jest ściśle narzucony gatunek gier. Jednak to ograniczenie właśnie pozwoliło na stworzenie narzędzia jednocześnie tak prostego i funkjonalnego. 

W tym rozdziale warto też wspomnieć o istnieniu narzędzi pozwalajace na łatwe tworzenie nawet zaawansowanych gier mobilnych dowolnego typu. Takim oprogramowanie jest np. Unity [https://unity3d.com/]. Unity udostępnia przyjazne GUI, które pozwala na tworzenie świata gry. Elementy fizyki takie jak grafitacja, są już zaimplementowane w silniku gry. Programista musi natomiast jedynie pamiętać o nadaniu obiektom odpowiednich cech takich jak masa. Logikę gry można zaimplementować w jednym z dwóch języków UnityScript, C#. UnityScript jest językiem o sładni bardzo zbliżonej do JavaScript, a C# jest populanym obiektowym językiem programowania. Użycie powszechnie znanych języków oraz wieleplatformowość z pewnością przyczyniło się do popularności Unity.

### Zastosowania DSL w grach terenowych

W mojej pracy postawiłem sobie na celu stworzenie frameworku pozwalającego na łatwe tworzenie terenowych gier RPG. Narzędzie łączy ze sobą cechy isniejących rozwiązań zaprzęgając je jednocześnie do rozwiązania nowych problemów. Cele postawione przed tym frameworkiem są typowe. Udostępnić narzędzie do przyjaznego rozwiązywania problemów określonej klasy. Nowy jest natomiast obszar w jakim działać będzie framework oraz użyte rozwiazania.

Przy pomocy Andventure Makera możliwe będzie tworzenie terenowych gier o narzuconych z góry, dość wąstkich i specyficznych ramach, typowych dla tradycyjnych gier RPG. Stworzona gra polegać będzie głównie na rozwoju postaci, poprzez odwiedzanie lokacji, podejmowanie decyzji, a przede wszystkim pokonywanie przeciwników. Postać sterowana przez gracza zdobywać będzie punkty doświadczenia, dzięki którym gracz będzie mógł rozwijać postać w wybranym przez siebie kierunku. 

Większość dostępnych frameworków opiera się na dwóch rozwiazaniach. Albo udostępniają użystkowikowi interfesy graficzny, albo pewien popularny język programowania, poszerzony ewentualnie o pewne fukcjonalności. Pierwsze podejście stosowane jest najczęściej w przypadku gier komputerowych lub gry odbiorną jest osoba nie umiąca programować. Jest ono ukierunkowane na prostotę ograniczając przy tym jednak możliwości narzędzia. Drugie podejcie sprawdza się głównie w aplikacja biznesowych. Integracja frameworku z popularnym językiem programowania pozwala pozyskać szerokie rzesze odbiorców. Dodatkowo sprawia, że narzędzie jest zarówno elastyczne, jak uniwersalne, tzn. dające się zastosować wielu przypadkach. Frameworki takie często są pisane   
W przypadku Adventure Makera pozstanowiem zastosować nieco inne podejście. Uznałem, że głównymi elementem gry RPG są świat w którym się rozgrywa, jej zasady oraz scenariusz. Stwiedziłem więc, że naturnym pomysłem na implementacje tych elementów, będzie specjalny język DSL. 

## Wymagania
Jednym z pierwszym kroków jakie należy podjąć przez przystąpieniem do projektowania oprogramowania jest analiza wymagań. Uznałem, że aby, mój framework realizował postawione przed sobą zadania musi spełniać wymienione ponieżej wymagania funkcjonalne i niefunkcjonalne.
### Funkcjonalne
- Język DSL zawieający elemnty takie jak
  - Klasy Postaci
  - Przedmioty
  - Lokacje
  - Zdarzenia
  - Przeciwnicy
- Integracja ze środowiskiem IntelliJ Idea
- Kompilacja aplikacji na podstawie pliku DSL 
  
Elementy wchodziące w skłąd zaprojektowanego języka DSL zostały przeze mnie wybrane arbitralnie, w taki sposób, żeby zawierał minimum niezbędne do zaprojektowania gry.  Chciałem, aby zaprojektowany język był jednocześnie prosty, ale i pozwalający na implementacje nawet dość zawiłej logiki. Oczywiście RPG z prawdziwego zdarzenia powinien zawierać nieco więcej. Uznałem jednak, że dodanie elementów takich jak np. misje lub NPC zbędnie rozbudowały by język i jego implementacje. Elementy te prawdopodobnie pojawią się, w przypadku wydania kolejenej wersji frameworku. Nie mniej jednak implementacja stworzona w ramach tej pracy obejmować będzie jedynie wyszczególnione punktu.

U celu ułatwienia edycji kodu warto udostępnić użytkownikowi przyjazne IDE. Na szczęście narzędzia takie już isnieją i nie musiałem projektować ich od zera. Popularne narzędzia programistyczne pozwalają na rozszarzanie ich funcjonalności poprzez tzw. wtyczki, czyli oprogramowanie, które doistalowuje się do już istniejącego IDE. Postanowiłem więc, że udostępnie obsługującą język AML wtyczkę do IDE IntelliJ Idea. Postanowiłem wybrać to środowisko z kilku powodów:
  - jest darmowy w wersji Community
  - udostępnia integracje z Android SDK
  - jest wspierany przez Xtext i Xtend

Możliwość łatwej edycji to zamało, aby język był fukcjonalny. Użytkownikowi należy udostępnić możliwość kompilacji kodu. W tym przydku będzie to transkompilacja, ponieważ kodem wyściowym nie będzie kod binarny, a pliki JAVA. Na podstawie wygenerowanego oraz dostarczonego wraz z frameworkiem kody możliwa musi być kompilacja gotowej aplikacji, bez konieczności dopisywania dodatkowego kodu. 
### Niefunkcjonalne
- Tworzenie gier RPG bez znajomości języków programowania ogólnego przeznaczenia oraz znajomości technologii

Podstawowym założeniem Adventure Makera jest udostępnienie możliwości tworzenia gier osobom będącym laikami jeśli chodzi o programowanie i technologie IT. Cen ten został też niejako wyrażony poprzez wymagania funcjonalne w postaci implementacji i integracji z IDE języka AML.
## Technologie
Przed przystąpieniem do projektu informatycznego warto zastanowić się z jakich narzędzi, technologii będziemy korzystać. Napeży wybrać technologie dostosowane do wymagań konkretnego projektu. Jest bardzo ważne, aby nie wymyślać nowo koła. Oznacza to, że należy korzystać z gotowych rozwiązań, jeżeli takie już istnieją. Warto sięgać po sprawdzone rozwiązania, które przeszły już swóch chrzest bojowy. W tym rodziale opisałem najważniejsze z użytych w opisawanym projekcie technologii.

### Xtext

Xtext [http://www.eclipse.org/Xtext/] to framework służący do implementacji języków DSL. Xtext tworzy infrastrukturę języka zawierającą elementy takie jak: parser,linker, typechecker, compiler na podstawie gramatyki języka. Dodatkowo pozwala na integracje zaprojektowane języka z popularnymi IDE: eclipse oraz IntelliJ Idea. Narzędzie umożliwia też ciągła integracje poprzez wsparcie dla maven i gradle.

### Xtend

Xtend [http://www.eclipse.org/xtend/] jest językiem programowania wywodzącym się z JAVY i składniowo zbliżonym do JAVY. Został zaprojektowany, aby wyeliminować kilka wad języka Java. Zawiera elementy niedostępne w Javie oraz upraszcza niektóre strutury pozwalając na pozbycie się niepotrzebnego kody. Kodem wynikowym dla języka Xtext jest Java. Mamy tu więc do czynienia z tranpilacją, czyli przetłumaczeniem jednego kodu źródłowego w inny.
W moim projekcie Xtend został użyty ze względu na technologie Xtext. Wykorzystanie Xtend jest zalecanym sposobem implementacji generatorów dla języków DSL tworzonych przy użyciu Xtend. Główną zaletą języka Xtext, w kontekście pisania generatorów kodu są szablony, które nie są dostępne w języku JAVA.

### Android SKD

Android SDK to zestaw standardowych narzędzi programisty umożliwiający tworzenie aplikacji na platformę Android. Zestaw podzielony jest na dwie części, zależną i niezależną od wersji systemu. Całość pakietu SDK podzielona jest na moduły, które można instalować i deinstalować w prosty sposób za pomocą aplikacji SDK manager. Aplikacje napisane w oparciu o Android SDK piszę się w języku JAVA.

### JUnit

JUnit [http://junit.org/junit4/] jest to framework służący do testowania programów napisanych w języku Java. Początkowo zaprojektowany przez Erich Gamma i Kent Beck, dziś rozwijany w formie open source.

### Mockito

Mockito [http://site.mockito.org/] to biblioteka ściśle związana z frameworkiem JUnit. Umożliwia tzw. mockowanie obiektów na czas testów jednostkowych. Mockowanie polega na przechwyceniu wywołań metod z klas będących zależnościami testowanej klasy, tak aby można było sprawdzić poprawność działania klasy w oderwaniu od poprawności działania całego systemu. Możliwe jest zarówno zmiana zachowania wywołanej metody, jak i sprawdzenie, czy, ile razy i z jakimi parametrami została wywołana. Główną zaletą mockito jest bardzo wygodne API, tworzące swego rodzaju wewnętrzny DSL.

### Dagger 2

Dagger 2 to biblioteka umożliwiająca wstrzykiwanie zależności w Androdzie. Istnieje wiele bibliotek umożliwiających DI, jednak Dagger 2 jest wśród programistów Androida. Jego główną zaletą jest rozstrzyganie zależności w czasie kompilacji oraz generacja kodu. Dzięki temu możemy wykryć wady projektu, takie jak zależności cykliczne jeszcze przed uruchomieniem aplikacji. Dodatkowo wygenerowany kod jest o wiele szybszy niż typowe rozwiazanie czasu wykonania - czyli refleksja.

## Architektura rozwiązania
W celu stworzenia frameworka Adventure Maker utworzyłem dwa projekty. Pierwszy to projekt odwpowiedzialny za DSL Andventure Maker Language. Projekt bazuje na technologii Xtext, a produktem wyjściowym jest wtyczka do IDE IntelliJ Idea obsługująca zaprojektowany DSL.
Drugi projekt, to szkielet aplikacji na system Android. Kod aplikacji jest częściowo napisany w AML i do jego kompilacji potrzebna jest jego obsługa.
 
Istotnym elementem implementacji frameworku są języki domenowe. W moim projektcie wykorzystałem zawróno wewnętrzny, jak i zerwnętrzny język domenowy. Zastosowanie zewnętrznego DSL pozwala twórcy gry na opisanie świata gry w sposób przyjazny dla osoby znającej tematykę gier RPG. Wewnętrzy DSL natomiast, sprawił, że generowany przez przez framework kod jest bardziej czytelny i przyjazny dla programisty, co w dużym stopniu przyczyniło się do skrócenia czasu potrzebnego mi do zaimplementowania generatorów.
  
### Xtext DSL
Projekt powstał w celu implementacji języka Andventure Maker Language. Opis tego języka znajduje się w rozdziale korzystaniu z frameworka.
Wykorzystanie technologii Xtext [] wymaga implementacji dwóch elementów gramatyki i generatorów kodu. 

#### Definicja Gramatyki
Gramatyka języka została umieszczona w pojedyńczym pliku -nazwa pliki-. Głównym celem stworzenia gramatyki jest opis modelu syntaktycznego i semantycznego tworzonego języka. Innymi słowy musimy zdefiniować jaki tekst będzie należał do języka oraz jak zmapować dany tekst na jego reprezentacje w pamięci komputera [dokumentacja]. Xtext na podstawie tego pliku wygeneruje między innymi parser, który sprawdzi, czy dany tekst poprawnym programem oraz zwróci jego reprezentacje w postaci drzewa obiektów.
#### Generator
Generator języka odpowiedzialny jest za wygenerowanie kodu (w tym przypadku kodu Java) na podstawie modelu semantycznego zwróconego przez parser w postacie drzewa obiektów. Generator został napisany w języku Xtend i zkłada się z głównej klasy implementującej metodę -nazwa metody- oraz klas pomocniczych utworzonym w celu dekompozycji problemu na mniejsze części zgodnie z zasadą pojedynczej odpowiedzialności [źródło].

### Aplikacja Android
- Plik aml

- Podział na moduły itp...

W framewodku Adventure Maker również został wykorzystany wewnętrzny język domenowy. W jego skład wchodzą klasy umieszczone w pakiecie "".
Poniżej znajduje się przykład kodu napisanego z wykorzystaniem tego języka.
--KOD--
Przytoczony kod opisuje mogące wystąpić w czasie gry zdarzenie. Chodź na to nie wygląda, kod ten został napisany w Javie.


## Testy
W celu sprawdzenia powprawności dzialania stworzonego oprogramowania postanowiłem je przetestować. Na pierwszym miejscu postawiłem testy automatyczne, ponieważ są najbardziej praktyczne i wiarygodne. Testy automatyczne zaimplementowałem w postaci mokowanych testów jednostkowych za pomocą bibliotek JUnit i Mockito.
Niestety nie dało się pokryć testemi automatycznymi wszystkich funcjonalności. Z tego powodzu część kodu została przetestowana w sposób manualny. Elementami przetestowanymi w ten sposób są działanie modułu NFC, GPS oraz generacja kodu. Do każdego z tych elemetów przygotowałem scenariusz testowy, który następnie wykonałem. Sposób przeprowadzenia oraz wyniki tych testów zostały przedstawione poniżej.
### Scenariusze testowania
#### Testy automatyczne 
Podczas  automatycznych testów jednostkowych testowałem z osobna działanie poszczególnych funkcji w oderwaniu od reszty systemu. Każdy test został podzielone na 3 sekcje, w których umieszczony został kod odpowiedniego typu:
  - GIVEN
  - WHEN
  - THEN

W sekcji Given został umieszczony kod implementujący warunki początkowe. Są to przedewszystkim linie kodu mockującego metody klas zależności klasy testowanej. Mogą to być też wywołania metod dostarczających jakieś dane. 

W sekcji When składa się z pojedynczej linii. Jest to wywołanie testowanej metody na instancji testowanej klasy.

Sekcja Then odpowiedzialna jest za sprawdzenie, czy metoda zachowała się w oczekiwany sposób. Zazwyczaj jest to kod skłądający się z kilku linii zawierających asercje. Asercje służą sprawdzeniu czy, ile razy i z jakimi parametrami zostały wywołane metody klas-zależności. Jeżeli funcja zwraca jakiś wynik, za pomocą assercje testują pokrywa się on z oczekiwanym.

#### NFC
#### GPS
#### Generowanie kodu
### Wyniki

## Korzystanie z frameworka
### Konfiguracja środowika
Pierwszym krokiem w celu konfiguracji środowika jest przygotowanie IDE oraz odpowiednich narzędzie. Należy pobrać i zainstalować w standarodowy sposób IntelliJ Idea, JRE, JDK i Android SDK. Drugim krokiem jest przygotowanie wtyczki do IntelliJ Idea. Wtyczka ta odpowiedzialna będzie za obsługę języka AML w tym za generacje kodu Java na podstawie pliku ".aml". Można pominąć ten etap pobierając gotową wtyczkę. Wtyczkę należy zaistalować w środowisku w IDE IntelliJ Idea. Kiedy mamy już potrzebne oprogramowanie należy jeszcze pobrać pusty projekt i można przystąć do implementacji własnej gry. 

#### Instalacja
  - IntelliJ Idea
  - JRE
  - JDK
  - Android SDK
  
#### Kompilacja wtyczki
Aby skompilować wtyczkę samodzielnie należy pobrać ją z repozytorium [link] i uruchodzić polecenie [grandle ...]. 

#### Instacja wtyczki
Wtyczkę obsługującą język AML można pobrać w postaci pliku .zip [skąd?] lub przygotować samodzielnie. Jeżeli mamy już przygotowany plik .zip musimy go zainstalować środowisku IDE IntelliJ Idea. W tym celu należy...

#### Konfiguracja projektu

#### Implementacja gry
Implementacja własnej gry sprowadza się do edycji jednego pliku mianowicie "game.aml". Należy w nim umieścić kod w języku AML. W kodzie tym należy umieścić wszystkie niezbędne elementy gry. Pisząc ten kod można posłużyć się dokumentacją języka AML zamieszczoną w niniejszej pracy. Warto też wzorować się na kodzie przykładowej gry, który równiej wchodzi w skład pracy.

#### Kompilacja projektu
Projekt należy skompilować przy pomocy narzędzia grandle []. Projekt jest standartowym projektem Androidowym, tak więc możemy go też uruchomić przyciskiem play dostępnym w IDE IntelliJ Idea. Ważne jest, żeby korzystać z IDE, ponieważ kod, generowany na podstawie pliku AML, tworzony jest przez samo środowisko. Budowanie projektu za pomocą może się więc nie powieść. Osoby zainteresowany głębszym zrozumieniem narzędzia grandle [] , Android SDK [] oraz samego IDE odsyłam do źródeł. 

## Adventure Maker Language
Adventure Maker Language to język domenowy stworzony specjalnie na potrzeby frameworka Adventure Maker. Poniżej znajduje się dokumentacja tego języka.

## Przykładowa gra
Aby ułatwić korzystanie z frameworka postanowiłem przygotować przykładową grę. Poniżej znajduje się kod AML potrzebny do skompilowania gry oraz opis każdego z jego elementów.

    KOD AML
  OPIS
