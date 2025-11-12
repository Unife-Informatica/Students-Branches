# Risposte domande di teoria

## 1) Che cosa sono i nomi e l’ambiente (environment)?
In un linguaggio come Java, i nomi sono gli identificatori che il programmatore usa per designare
variabili, classi, metodi, costanti e così via. L’ambiente è la struttura concettuale che associa questi
nomi alle entità corrispondenti. A tempo di compilazione l’ambiente collega un nome al tipo e allo
scope; a tempo di esecuzione associa i nomi a locazioni di memoria o valori. Questo garantisce che
ogni riferimento a un nome sia correttamente risolto e gestito.

## 2) Che cosa sono le regole di visibilità?
Le regole di visibilità determinano dove un nome dichiarato è accessibile. In Java queste regole si
dividono in due categorie: scope lessicale e modificatori di accesso. Lo scope lessicale deriva dalla
struttura del codice: ad esempio una variabile locale è accessibile solo nel blocco che la contiene. I
modificatori di accesso (`public`, `protected`, `private`, default) stabiliscono la visibilità tra classi e
package. Queste regole sono fondamentali per garantire incapsulamento e modularità.

## 3) Gestione della memoria dinamica tramite stack e record di attivazione
Ogni chiamata a metodo genera uno stack frame nello stack del thread. Questo record contiene
parametri, variabili locali, l’operand stack e l’indirizzo di ritorno. Lo stack segue una logica LIFO:
quando il metodo termina, il frame viene rimosso. Questa gestione è automatica ed efficiente, ma la
profondità è limitata: una ricorsione troppo profonda porta a stack overflow. In Java gli oggetti sono
sempre allocati nell’heap, ma lo stack conserva i riferimenti ad essi.

## 4) Operazioni eseguite durante una chiamata di procedura
Quando viene invocato un metodo in Java, i parametri vengono valutati e copiati nello stack frame
del chiamato. Viene allocato lo spazio per le variabili locali e salvato l’indirizzo di ritorno. Si esegue
il corpo del metodo e, al termine, il risultato viene restituito al chiamante. Infine lo stack frame è
rimosso e il controllo torna al chiamante. Questa sequenza è automatizzata dalla JVM.

## 5) Strategie per la gestione della memoria dinamica tramite heap
Le strategie principali includono: allocazione e deallocazione manuale (come in C), reference
counting, e garbage collection basata sul tracciamento (mark-and-sweep, copying, generazionale).
Java utilizza collettori sofisticati come G1, ZGC o Shenandoah che combinano varie tecniche per
bilanciare throughput, latenza e consumo di memoria.

## 6) Differenza tra linguaggi imperativi e dichiarativi
I linguaggi imperativi descrivono come ottenere un risultato tramite sequenze di istruzioni che
modificano lo stato del programma. Esempi: C, Java. I linguaggi dichiarativi descrivono invece cosa
si vuole ottenere senza specificare i passi operativi: esempi classici sono SQL e Prolog. Java
appartiene al paradigma imperativo/OO, ma incorpora elementi dichiarativi tramite lambda e
stream.

## 7) Si parli del goto
Il comando goto consente salti arbitrari a etichette nel codice. Storicamente molto usato, è stato
criticato perché porta a 'spaghetti code' difficile da leggere e mantenere. Java non consente l’uso di
goto, anche se la parola chiave è riservata. In alternativa fornisce break, continue e break/continue
con etichetta, che coprono i casi pratici senza compromettere la leggibilità.

## 8) Si parli dei comandi condizionali
In Java i comandi condizionali principali sono if/else, l’operatore ternario ?:, e lo switch. Dalla
versione 14 esistono anche le switch expressions, che possono restituire un valore e rendono più
chiara la logica dei casi. Questi strumenti permettono di eseguire blocchi diversi in base a
condizioni booleane, garantendo flessibilità e leggibilità.

## 9) Si parli dei comandi iterativi
Java offre cicli for, while e do-while, oltre al for-each per semplificare l’iterazione su collezioni e
array. Questi comandi consentono di ripetere blocchi di codice finché una condizione è soddisfatta.
Con l’introduzione delle stream API, è possibile scrivere iterazioni in stile dichiarativo, semplificando
il codice e riducendo gli errori.

## 10) Che cos’è la programmazione strutturata?
La programmazione strutturata è un paradigma che promuove l’uso di costrutti di controllo ben
definiti (sequenza, selezione, iterazione) invece dei salti arbitrari. Questo approccio rende il codice
più leggibile, mantenibile e verificabile. È il fondamento su cui si basano paradigmi successivi come
l’object-oriented.

## 11) Che cos’è la tail recursion?
Una funzione è tail-recursive se l’ultima operazione che compie è una chiamata ricorsiva. In questi
casi il compilatore o il runtime possono ottimizzare la ricorsione trasformandola in iterazione,
evitando di consumare stack aggiuntivo. La JVM però non garantisce questa ottimizzazione, quindi
in Java la tail recursion non è sempre sicura e va sostituita da cicli in caso di grandi profondità.

## 12) Differenza tra ricorsione e iterazione
La ricorsione definisce un problema in termini di sé stesso ed è elegante per strutture ricorsive
come alberi o problemi divide-and-conquer. L’iterazione ripete istruzioni tramite cicli ed è
generalmente più efficiente in Java, dato che la JVM non ottimizza le tail call. La ricorsione è più
espressiva, ma rischia stack overflow; l’iterazione è più sicura per grandi input.

## 13) Quando un linguaggio ha funzioni di prima classe?
Un linguaggio ha funzioni di prima classe quando queste possono essere trattate come valori:
assegnate a variabili, passate come argomenti, restituite da funzioni. Java non ha funzioni come tipi
primitivi, ma da Java 8 in poi offre lambda e method references che implementano interfacce
funzionali, simulando di fatto funzioni di prima classe.

## 14) Che cosa fa il garbage collector e perché è utile?
Il garbage collector gestisce automaticamente la memoria liberando gli oggetti che non sono più
raggiungibili dal programma. È utile perché elimina la necessità di deallocazione manuale, riduce
gli errori come i memory leak o i dangling pointer, e migliora la sicurezza e l’affidabilità dei
programmi.

## 15) Le due tecniche principali per la garbage collection
Le due tecniche fondamentali sono il reference counting e il tracing (mark-and-sweep, copying). Il
reference counting elimina subito gli oggetti non più referenziati ma non gestisce i cicli; il tracing
visita gli oggetti raggiungibili a partire dalle root e libera gli altri, con varianti ottimizzate per ridurre
la frammentazione. Java adotta il tracing in versioni avanzate.

## 16) Come sono implementati gli oggetti
Gli oggetti in Java sono allocati sull’heap e hanno un header contenente informazioni per la JVM: il
mark word con dati per GC e sincronizzazione, e il klass pointer che punta alla descrizione della
classe. Seguono i campi della superclasse e della classe. Gli array includono anche la lunghezza.
Questo layout è gestito dalla JVM e ottimizzato per efficienza.

## 17) Dynamic method lookup
Il dynamic dispatch è la scelta del metodo concreto da invocare a runtime in base alla classe reale
dell’oggetto. In Java, il bytecode `invokevirtual` e `invokeinterface` attivano questo meccanismo. Le
JVM usano tabelle dei metodi (vtable) e ottimizzazioni come inline caching e JIT inlining per ridurre
i costi del dispatch dinamico.

## 18) Rappresentazione delle classi
A runtime, una classe è rappresentata da metadati nella method area e da un oggetto
`java.lang.Class` che funge da specchio. I metadati includono campi, metodi, costanti, riferimenti a
superclassi e interfacce. Quando la JVM carica una classe, traduce il class file in queste strutture,
che vengono usate per il linking e l’esecuzione.

## 19) Invocazione dei metodi con ereditarietà singola
In Java, con ereditarietà singola, una sottoclasse può ridefinire i metodi della superclasse. Le
chiamate a metodi non statici vengono risolte tramite dynamic dispatch: se la sottoclasse ha un
override, viene eseguito quello. La JVM implementa il tutto tramite tabelle dei metodi e
ottimizzazioni JIT. Le chiamate a costruttori, metodi privati e super-call usano invece l’istruzione
`invokespecial`.
