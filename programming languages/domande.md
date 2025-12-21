# Risposte domande di teoria

## 1. Che cosa sono i nomi e l’ambiente (environment)?

In un linguaggio di programmazione, un **nome** è un identificatore che viene utilizzato per riferirsi a un’entità del programma, come una variabile, un metodo, una classe, un’interfaccia o un oggetto. Tuttavia, il nome da solo non è sufficiente a determinare il significato: esso acquista un senso solo all’interno di un **ambiente**, detto anche *environment*. L’ambiente è l’insieme delle associazioni tra nomi ed entità valide in un determinato punto dell’esecuzione del programma.

In Java l’ambiente non è statico, ma cambia durante l’esecuzione: ogni volta che si entra in un metodo o in un blocco di codice viene creato un nuovo ambiente locale che estende quello precedente, introducendo nuovi nomi. Quando si esce dal blocco o dal metodo, quell’ambiente viene distrutto. Questo modello consente di gestire correttamente variabili locali, parametri e campi, evitando conflitti di nomi e garantendo una struttura ordinata del programma.

---

## 2. Che cosa sono le regole di visibilità?

Le **regole di visibilità** determinano **dove un nome può essere utilizzato** all’interno di un programma. In Java la visibilità è regolata da due concetti fondamentali: lo **scope** e i **modificatori di accesso**. Lo scope stabilisce l’area del programma in cui un nome è valido, mentre i modificatori (`private`, `protected`, `public`, default) stabiliscono chi può accedere a quell’entità.

Java adotta uno **scope statico o lessicale**, il che significa che la visibilità di un nome è determinata dalla struttura del codice sorgente e non dal flusso di esecuzione. Questo rende il comportamento del programma più prevedibile. Le regole di visibilità sono fondamentali per l’incapsulamento e per la progettazione modulare, perché permettono di nascondere i dettagli interni di una classe e di esporre solo ciò che è necessario.

---

## 3. Gestione della memoria dinamica tramite stack e record di attivazione

La memoria dinamica in Java è gestita principalmente tramite lo **stack** e l’**heap**. Lo stack è utilizzato per la gestione delle chiamate ai metodi. Ogni volta che un metodo viene invocato, viene creato un **record di attivazione**, noto anche come *stack frame*. Questo record contiene tutte le informazioni necessarie per l’esecuzione del metodo: parametri, variabili locali, indirizzo di ritorno e riferimento all’oggetto corrente (`this`).

I record di attivazione sono organizzati in modo LIFO, cioè a pila. Quando un metodo termina, il suo record viene rimosso dallo stack e la memoria viene immediatamente recuperata. Questo rende lo stack molto efficiente, ma inadatto alla gestione di strutture con durata di vita non determinabile staticamente.

---

## 4. Operazioni eseguite quando viene eseguita una procedura

Quando una procedura o un metodo viene chiamato, il sistema esegue una serie di operazioni ben definite. Innanzitutto viene creato un nuovo record di attivazione sullo stack. Successivamente vengono copiati o associati i parametri attuali ai parametri formali del metodo. Viene poi salvato l’indirizzo dell’istruzione da cui riprendere l’esecuzione al termine della procedura.

A questo punto viene eseguito il corpo del metodo. Se il metodo restituisce un valore, questo viene preparato per il chiamante. Infine, il record di attivazione viene rimosso dallo stack e il controllo ritorna al punto da cui il metodo era stato invocato.

---

## 5. Strategie per la gestione della memoria dinamica tramite heap

L’**heap** è l’area di memoria in cui vengono allocati gli oggetti creati dinamicamente. A differenza dello stack, l’heap non segue una struttura LIFO e richiede strategie più complesse di gestione. Tra le strategie teoriche troviamo il *first-fit*, il *best-fit* e il *worst-fit*, che differiscono per il modo in cui scelgono lo spazio libero da utilizzare.

In Java, però, la gestione dell’heap è completamente automatizzata grazie al garbage collector. Il programmatore non deve preoccuparsi di liberare la memoria, ma solo di creare correttamente gli oggetti. Questo riduce notevolmente la possibilità di errori legati alla gestione manuale della memoria.

---

## 6. Differenza tra linguaggi imperativi e dichiarativi

I **linguaggi imperativi** descrivono il programma come una sequenza di comandi che modificano lo stato della memoria. Il programmatore specifica esattamente come il calcolo deve essere eseguito, utilizzando assegnamenti, cicli e condizioni. Java rientra principalmente in questa categoria.

I **linguaggi dichiarativi**, invece, si concentrano su cosa deve essere calcolato, non su come farlo. Il flusso di controllo è implicito e gestito dal linguaggio stesso. Esempi tipici sono SQL e Prolog. Java, pur essendo imperativo, include oggi elementi dichiarativi come le espressioni lambda e le API Stream.

---

## 7. Si parli del `goto`

Il comando `goto` permette di effettuare salti incondizionati all’interno del codice. Storicamente è stato molto utilizzato, ma ha portato a programmi difficili da comprendere e mantenere, noti come *spaghetti code*. Per questo motivo, con l’avvento della programmazione strutturata, il `goto` è stato fortemente scoraggiato.

In Java il `goto` è una parola riservata, ma non è utilizzabile. Il linguaggio fornisce invece costrutti strutturati come `if`, `while`, `for`, `break` e `continue`, che permettono di controllare il flusso di esecuzione in modo chiaro e sicuro.

---

## 8. Comandi condizionali

I comandi condizionali permettono di eseguire porzioni di codice diverse in base al valore di una condizione booleana. In Java il principale comando condizionale è l’`if`, che può essere accompagnato da uno o più `else if` e da un `else` finale. Un altro costrutto importante è il `switch`, utile quando si devono confrontare molteplici valori discreti.

Questi costrutti migliorano la leggibilità del codice e permettono di esprimere decisioni logiche in modo strutturato.

---

## 9. Comandi iterativi

I comandi iterativi consentono di ripetere l’esecuzione di un blocco di istruzioni finché una condizione è soddisfatta. In Java sono disponibili `while`, `do-while`, `for` e il `for-each`. Ogni costrutto è adatto a situazioni diverse, ma tutti permettono di evitare la duplicazione di codice e di esprimere in modo chiaro la ripetizione.

L’uso corretto dei cicli è fondamentale nella programmazione imperativa.

---

## 10. Che cos’è la programmazione strutturata?

La **programmazione strutturata** è un paradigma che promuove l’uso di strutture di controllo ben definite, eliminando i salti incondizionati come il `goto`. Si basa su tre costrutti fondamentali: sequenza, selezione e iterazione.

Java aderisce pienamente a questo paradigma, favorendo programmi più leggibili, verificabili e manutenibili.

---

## 11. Che cos’è la tail recursion?

La **tail recursion** è una forma particolare di ricorsione in cui la chiamata ricorsiva è l’ultima operazione eseguita dal metodo. In questi casi, teoricamente, il compilatore potrebbe ottimizzare la ricorsione trasformandola in iterazione.

Tuttavia, in Java questa ottimizzazione non è garantita, quindi la tail recursion non offre reali vantaggi in termini di memoria rispetto alla ricorsione normale.

---

## 12. Differenza tra ricorsione e iterazione

La ricorsione e l’iterazione sono due modi diversi di esprimere la ripetizione. La ricorsione si basa su chiamate a sé stessa e utilizza lo stack di chiamata, mentre l’iterazione utilizza strutture di controllo come i cicli e variabili di stato.

In Java l’iterazione è generalmente preferita per motivi di efficienza, anche se la ricorsione può risultare più elegante e naturale in alcuni casi.

---

## 13. Quando un linguaggio ha first-class functions?

Un linguaggio possiede **first-class functions** quando le funzioni possono essere trattate come qualsiasi altro valore: possono essere assegnate a variabili, passate come parametri e restituite come risultato.

Java supporta questo concetto tramite le lambda expressions e le interfacce funzionali introdotte in Java 8, anche se le funzioni non sono oggetti di prima classe in senso puro come in altri linguaggi funzionali.

---

## 14. Che cosa fa il garbage collector e perché è utile?

Il **garbage collector** è il meccanismo che si occupa di liberare automaticamente la memoria occupata da oggetti non più utilizzabili. Un oggetto è considerato “garbage” quando non esiste più alcun riferimento che lo renda raggiungibile.

Questo sistema è utile perché evita errori tipici della gestione manuale della memoria, come memory leak e dangling pointer, e rende il linguaggio più sicuro e affidabile.

---

## 15. Tecniche principali di garbage collection

Le due tecniche principali sono il **mark and sweep**, in cui il garbage collector marca gli oggetti raggiungibili e rimuove quelli non marcati, e la **garbage collection generazionale**, che divide l’heap in generazioni e raccoglie più frequentemente gli oggetti giovani.

La JVM utilizza versioni avanzate di garbage collection generazionale per migliorare le prestazioni.

---

## 16. Come sono implementati gli oggetti?

Un oggetto in Java è rappresentato in memoria come una struttura che contiene i campi dati e un riferimento alla classe a cui appartiene. Inoltre, contiene informazioni aggiuntive utilizzate dalla JVM, come dati per la sincronizzazione e per il garbage collector.

Gli oggetti sono allocati sull’heap e vengono manipolati tramite riferimenti.

---

## 17. Come si svolge il dynamic method lookup?

Il **dynamic method lookup** è il meccanismo con cui Java determina, a runtime, quale implementazione di un metodo deve essere eseguita. La scelta dipende dal tipo reale dell’oggetto e non dal tipo della variabile di riferimento.

Questo meccanismo è alla base del polimorfismo e consente di scrivere codice flessibile ed estendibile.

---

## 18. Come sono rappresentate le classi?

Le classi sono rappresentate tramite strutture interne alla JVM che contengono informazioni sui campi, sui metodi e sulla gerarchia di ereditarietà. Una componente fondamentale è la **method table**, che permette l’invocazione dinamica dei metodi.

Ogni classe viene caricata una sola volta dalla JVM e condivisa da tutte le istanze.

---

## 19. Come si invocano i metodi nel caso di ereditarietà singola?

Nel caso di ereditarietà singola, ogni classe ha una sola superclasse. Quando viene invocato un metodo su un oggetto, la JVM utilizza il dynamic method lookup per cercare il metodo nella classe dell’oggetto reale. Se il metodo è stato sovrascritto, viene chiamata la versione della sottoclasse; altrimenti si risale lungo la catena di ereditarietà.

Questo meccanismo garantisce il corretto funzionamento del polimorfismo in Java.
