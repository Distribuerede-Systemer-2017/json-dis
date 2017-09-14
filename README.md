## 4. øvelsesgang

I dag skal vi kigge på at få vores DIS til at returnere vores data i et bestemt udvekslingsformat. Google har udviklet et super
værktøj, GSON, der nemt kan parse Java's objekt orienterede struktur til JSON.

#### Opgave 1.
Klon og kør dette repository på din computer. Læg mærke til at projektet her indholder en `pom.xml` fil. I filen er en dependency til GSON, som er hostet hos Google. 

1. Åbn din terminal og naviger hen til mappen hvor du ønsker dette projekt skal ligge (HINT: `cd` bruges til at skifte mappe)
2. `git clone https://github.com/Distribuerede-Systemer-2017/json-dis.git`
3. Åbn IntelliJ, lav et nyt projekt og placer projektet oven i dette repository
4. Åbn `json-dis` mappen i IntellJ og find filen `pom.xml`
5. Højreklik på `pom.xml` og tryk "Add as Maven Project". Bruger du ikke IntelliJ, så følg guiden til installation af GSON på  Learn.
6. Hvis `pom.xml` nu er et blåt "M", så er du færdig

#### Opgave 2.
Nu da vi har GSON biblioteket installeret i vores projekt, kan vi bruge de metoder som er tilrådighed. Som vidst i mine slides, vil vi gerne parse vores Java objekter til et JSON repræsenteret tekst. For at lave et eksempel på hvordan dette kunne foregå uden at vi forbinder til en database, kan vi lave et `User` object som vi selv indsætter data i.

1. Opret en ny package i mappen `src` og kald den `Models`
2. Lav klassen `User` i din nyoprettede package 
3. Giv klassen `username` og `password` som instansvariable (som `Strings`)
4. Giv klassen `skills` som instansvariabel (Som `ArrayList<String>`)
5. Lav selv nødvendige `get/set/add` metoder til variablerne

#### Opgave 3.
Lad os lave nogle opdigtede Users og bruge GSON's `.toJson()` metode til at sende vores brugere som JSON tilbage til vores klient.

1. Lav en ny `ArrayList<Users>` på linje 44 i `ResponseHandler` klassen
2. 
