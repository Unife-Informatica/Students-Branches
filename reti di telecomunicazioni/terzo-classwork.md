# Appunti terzo classwork

## Token Ring IEEE 802.5

È stato introdotto da IBM nel 1984 e standardizzato come IEEE 802.5. Utilizza un frame di 3 bytes chiamato *token* ch viene passato attraverso un anello logico composto da workstations e server. Il passaggio di token è un metodo di accesso che fornisce un accesso equo per tutte le stazioni ed elimina le collisioni.
La tecnologia token ring è diventata ampiamente utilizzata, in particolare in ambiente aziendale, ma gradualmente rimpiazzata da nuove interazioni di Ethernet.

### Confronto con Ethernet

Sono entrame tecnologie utilizzate per collegare più computer all'interno di una rete LAN. La differenza principale riguarda il modo in cui i computer comunicano e si dividono il canale di trasmissione.
Nel modello token ring a differenza dell'ethernet il computer deve attendere la ricezione di un token prima di trasmettere. Questa pratica permette di ridurre le collisioni a zero.
Nonostante ciò Ethernet ha avuto piu successo principalemente per 3 motivi:
1. costo inferiore
2. maggiore semplicità
3. grzie ai cavi a doppino intrecciato e degli switch, Ethernet è diventata più conveniente e veloce.

### Processo
Il processo di trasmissione dei dati opera come segue:
1. il token passa continuamente da una macchina all'altra nell'anello. Finché libero permette ad un computer di trasmettere.
2. quando un computer vuole inviare un messaggio intercetta il token libero, lo contrassegna come occupato e inserisce al suo interno i dati da trasmettere e l'indirizzo del destinatario.
3. il frame passa da una macchina all'altra. Ogni computer controlla l'indirizzo del destinatario. Se non è il destinatario inoltra il pacchetto al computer successivo.
4. quando il pacchetto raggiunge il pacchetto destinatario, quest'ultimo copia i dati e modifica alcuni bit del frame per segnalare che il messaggio è stato ricevuto e copiato. <!-- aggiornare la parte di pacchetto modificata -->
5. il pacchetto continua a circolare fino a raggiungere nuovamente il computer che lo aveva inviato. Il mittente controlla i bit di stato per verificare se il destinatario ha ricevuto e copiato correttamente il messaggio.
6. il mittente rimuove i dati e lo rende nuovamente disponibile.

### Cablaggio

### Frames

#### Token

Il token IEEE 802.5 è composto da 3 byte (24 bit).

\begin{center}
\begin{tikzpicture}

% Dimensioni
\def\w{3.6}
\def\h{1.5}
\def\gap{0.07}

% Primo byte - SD
\fill[blue!80!cyan, rounded corners=3pt]
    (0,0) rectangle (\w,\h);

\node[white, font=\sffamily\bfseries\Large]
    at (\w/2,1.08) {8 bit};

\node[white, font=\sffamily\small]
    at (\w/2,0.35) {SD};

% Secondo byte - AC
\fill[teal!80!green, rounded corners=3pt]
    (\w+\gap,0) rectangle (2*\w+\gap,\h);

\node[white, font=\sffamily\bfseries\Large]
    at (1.5*\w+\gap,1.08) {8 bit};

\node[white, font=\sffamily\small]
    at (1.5*\w+\gap,0.35) {AC};

% Terzo byte - ED
\fill[violet!85, rounded corners=3pt]
    (2*\w+2*\gap,0) rectangle (3*\w+2*\gap,\h);

\node[white, font=\sffamily\bfseries\Large]
    at (2.5*\w+2*\gap,1.08) {8 bit};

\node[white, font=\sffamily\small]
    at (2.5*\w+2*\gap,0.35) {ED};

\end{tikzpicture}
\end{center}

- SD: indica l'inizio del token
- AC: contiene le informazioni di controllo priorità
- ED: indica la fine del token

##### Access Control (AC)

\begin{center}
\begin{tikzpicture}
\matrix[
    matrix of nodes,
    nodes={
        minimum width=1.2cm,
        minimum height=0.5cm,
        inner sep=0pt,
        text=white,
        font=\sffamily\bfseries\small,
        rounded corners=2pt,
        anchor=center
    },
    column sep=1pt
] {
    |[fill=blue!75!black]| P0 &
    |[fill=blue!75!black]| P1 &
    |[fill=blue!75!black]| P2 &
    |[fill=teal!75!black]| T &
    |[fill=orange!85!black]| M &
    |[fill=gray!65!blue]| R0 &
    |[fill=gray!65!blue]| R1 &
    |[fill=gray!65!blue]| R2 \\
};
\end{tikzpicture}
\end{center}

- `P0`, `P1`, `P2` indicano la priorità del token o del pacchetto
- `T` distingue un token da un pacchetto (T=0 token libero, T=1 pacchetto)
- `M` monitor bit usato per il controllo dell'anello
- `R0`, `R1`, `R2` bit di prenotazione della priorità

#### Frame

Quando una stazione acquisisce il token può trasmettere un frame contenente informazioni. Il frame dati è più grande del token e presenta una struttura composta da diversi campi.

\begin{center}
\begin{tikzpicture}
\matrix[
    matrix of nodes,
    nodes={
        minimum height=0.5cm,
        inner sep=3pt,
        outer sep=0pt,
        text=white,
        font=\sffamily\bfseries\small,
        rounded corners=2pt,
        anchor=center,
        align=center
    },
    column sep=1pt,
    row sep=3pt
] {
    |[fill=blue!75!black, minimum width=1.15cm]| SD &
    |[fill=teal!75!black, minimum width=1.15cm]| AC &
    |[fill=red!65!black, minimum width=1.15cm]| FC &
    |[fill=blue!75!black, minimum width=1.15cm]| DA &
    |[fill=blue!75!black, minimum width=1.15cm]| SA &
    |[fill=gray!65!blue, minimum width=1.15cm]| RI &
    |[fill=teal!75!black, minimum width=1.15cm]| INFO &
    |[fill=orange!85!black, minimum width=1.15cm]| FCS &
    |[fill=blue!75!black, minimum width=1.15cm]| ED &
    |[fill=orange!85!black, minimum width=1.15cm]| FS \\

    |[text=black, font=\sffamily\scriptsize]|  &
    |[text=black, font=\sffamily\scriptsize]| 1 byte &
    |[text=black, font=\sffamily\scriptsize]| 1 byte &
    |[text=black, font=\sffamily\scriptsize]| 6 byte &
    |[text=black, font=\sffamily\scriptsize]| 6 byte &
    |[text=black, font=\sffamily\scriptsize]| 0--30 byte &
    |[text=black, font=\sffamily\scriptsize]| Variabile &
    |[text=black, font=\sffamily\scriptsize]| 4 byte &
    |[text=black, font=\sffamily\scriptsize]| 1 byte &
    |[text=black, font=\sffamily\scriptsize]| 1 byte \\
};
\end{tikzpicture}
\end{center}

- FC: è un byte che identifica la tipologia del frame
- DA: indirizzo MAC del destinatario
- SA: indirizzo MAC del mittente
- RI: è un campo opzionale che può ranggiungere i 30 byte e viene utilizzato quando il mittente specifica il percorso che il frame deve seguire attraverso i bridge della rete
- INFO: contiene i dati veri e propri
- FCS: contiene un valore di controllo calcolato mediante un algoritmo CRC.


---

## Real Time Protocol (RTP)

---

## References
<!-- Token Ring -->
- https://en.wikipedia.org/wiki/Token_Ring
<!-- Real Time Protocol (RTP) -->
- https://homes.di.unimi.it/~alberti/Mm07/doc/rtp.pdf