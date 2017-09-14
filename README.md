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
6. Hvis `pom.xml` nu er et blåt "M"-ikon, så er du færdig

#### Opgave 1.5 - Frivillig git-træning
Hvis du er interesseret i at få lidt træning i at bruge git, så følg med her.
Inden du starter med at kode, så lav først din egen branch. Det gør du ved følgende:

1. `git branch <dit-branch-navn>` (HINT: undgå mellemrum, store bogstaver og specialkarakterer)
2. `git checkout <dit-branch-navn>`
3. Du er klar

#### Opgave 2.
Nu da vi har GSON biblioteket installeret i vores projekt, kan vi bruge de metoder som er tilrådighed. Som vist i mine slides, vil vi gerne parse vores Java objekter til et JSON repræsenteret tekst. For at lave et eksempel på hvordan dette kunne foregå uden at vi forbinder til en database, kan vi lave et `User` object som vi selv indsætter data i.

1. Opret en ny package i mappen `src` og kald den `Models`
2. Lav klassen `User` i din nyoprettede package 
3. Giv klassen `username` og `password` som instansvariable (som `Strings`)
4. Giv klassen `skills` som instansvariabel (Som `ArrayList<String>`)
5. Lav selv nødvendige `get/set/add` metoder til variablerne

Hvis du lavede opgave 1.5, så kan du nu lave et "checkpoint" på din branch, et såkaldt `commit`. Hvis ikke, så kan du springe de 4 steps nedenfor over.
1. Skriv `git status` for at se hvad der har ændret sig siden dit sidste commit
2. Skriv `git add .` for at "stage" alle ændringerne til commit
3. Skriv `git commit -m "<din beskrivelse af hvad du har lavet>"`
4. Dine ændringer er nu commitet, men ligger stadig kun lokalt på din maskine

#### Opgave 3.
Lad os lave nogle opdigtede Users og bruge GSON's `.toJson()` metode til at sende vores brugere som JSON tilbage til vores klient.

1. Lav en ny `ArrayList<Users>` under linje 38 i `ResponseHandler` klassen, og kald den `users`
2. Opdigt et par test brugere og tilføj dem til `users`
3. Konverter din liste til JSON med følgende kode: `String usersAsJson = new Gson().toJson(users);`
4. Skift "hello world!" i `outToClient.println()` ud med `usersAsJson`
5. Kør din webserver (husk måske at ændre port-nr)
6. Lav et request til severen i din browser og se resultatet!

#### Opgave 3.5 - Frivillig git-træning
Når du har et system som fungerer, så kan du dele dine ændringer ved at `pushe` dine tilføjelser til repositoriet. Har du lavet flere ændringer siden sidste commit, så skal disse først commites for at kunne fortsætte. Check evt. med `git status`. Når du har commitet dine ændringer, så skriv: `git push origin <dit-branch-navn>` (OBS: oplever du en permission fejl her, så er du ikke med i vores organisation - hiv fat i mig).

##### Lav et Pull Request (PR)
Da det ikke anbefales at man kan pushe ændringer direkte ind i `master` branch kan i på Github lave et såkald "Pull Request". Kort fortalt så beder I om at "pull" jeres branch ind `master` branch. Inden det sker, kan man tjekke hvilke ting der er ændret, om der er nogle conflicts osv. Først til sidst når et pull requests godkendes bliver ændringerne merged ind i `master` branch.

1. Klik på fanen "Pull requests" på Github på dette repository
2. Klik "New Pull Request"
3. Vælg `master` som base og `<dit-branch-navn>` som compare
4. Tryk "Create Pull Request"
5. Beskriv kort hvad dette PR gør
6. I oversigten kan du se om du har nogle merge conflicts

Jeg gennemgår alle PR's og merger den bedste :)
