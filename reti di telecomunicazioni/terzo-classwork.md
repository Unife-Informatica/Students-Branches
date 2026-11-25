---
title: "Appunti Terzo Classwork"
author: "Pietro Peerani"
---

# Token Ring IEEE 802.5

![token ring](images/terzo-classwork_20261118095540374.png)

È stato introdotto da IBM nel 1984 e standardizzato come IEEE 802.5. Utilizza un frame di 3 bytes chiamato *token* ch viene passato attraverso un anello logico composto da workstations e server. Il passaggio di token è un metodo di accesso che fornisce un accesso equo per tutte le stazioni ed elimina le collisioni.
Dalla figura si può notare un grosso problema: se il cavo si interrompe in un qualsiasi punto il ring stesso si interrompe e la comunicazione diviene impossibile. Per superare tale ostacolo è stata proposta una nuova topologia che fa uso del **wire center**. Le stazioni sono collegate al wire center con almeno due cavi coassiali, per avere flusso di dati in entrambe le direzioni. All'interno del wire center vi sono dei relè che vengono automaticamente attivati quando la stazione a cui fanno riferimento si guasta, e come effetto producono il bypass della stazione stessa.
La tecnologia token ring è diventata ampiamente utilizzata, in particolare in ambiente aziendale, ma gradualmente rimpiazzata da nuove generazioni di Ethernet.

## Confronto con Ethernet

Sono entrambe tecnologie utilizzate per collegare più computer all'interno di una rete LAN. La differenza principale riguarda il modo in cui i computer comunicano e si dividono il canale di trasmissione.
Nel modello token ring a differenza dell'ethernet il computer deve attendere la ricezione di un token prima di trasmettere. Questa pratica permette di ridurre le collisioni a zero.
Nonostante ciò Ethernet ha avuto piu successo principalemente per 3 motivi:

1. costo inferiore
2. maggiore semplicità
3. grazie ai cavi a doppino intrecciato e degli switch, Ethernet è diventata più conveniente e veloce.

## Processo

Il processo di trasmissione dei dati opera come segue:

1. il token passa continuamente da una macchina all'altra nell'anello. Finché è libero permette ad un computer di trasmettere.
2. quando un computer vuole inviare un messaggio intercetta il token libero, lo contrassegna come occupato e inserisce al suo interno i dati da trasmettere e l'indirizzo del destinatario.
3. il frame passa da una macchina all'altra. Ogni computer controlla l'indirizzo del destinatario. Se non è il destinatario inoltra il pacchetto al computer successivo.
4. quando il pacchetto raggiunge il computer destinatario, quest'ultimo copia i dati e modifica il frame per segnalare che il messaggio è stato ricevuto e copiato.
5. il pacchetto continua a circolare fino a raggiungere nuovamente il computer che lo aveva inviato. Il mittente controlla i bit di stato per verificare se il destinatario ha ricevuto e copiato correttamente il messaggio.
6. il mittente rimuove i dati e lo rende nuovamente disponibile.

Tutto questo meccanismo è supervisionato da una stazione detta **Active Monitor** che ha il compito di risolvere eventuali situazioni anomale.

L'interfaccia sul ring delle stazioni può operare in due modalità:

- ascolto: la stazione copia il bit che riceve in ingresso sull'uscita
- trasmissione: in cui la stazione interrompe il ring e inserisce nell'anello il frame che deve inviare

## Frames

### Token

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

#### Access Control (AC)

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

- `P0`, `P1`, `P2` indicano la priorità del token o del pacchetto.
- `T` distingue un token da un pacchetto (T=0 token libero, T=1 pacchetto).
- `M` è usato da una particolare stazione denominata Monitor Station per evitare che il frame continui a circolare indefinitivamente sul ring.
- `R0`, `R1`, `R2` bit che permettono la prenotazione del token con una priorità.

### Frame

Una stazione che rileva il token ed ha qualcosa da trasmettere, verifica che il frame da spedire abbia priorità maggiore o uguale a quella del token, dunque, in caso affermativo modifica il bit `T`, modificando il token in un frame dati, e successivamente accoda il frame rispettando il formato:

\begin{center}
\begin{tikzpicture}
\matrix[
    matrix of nodes,
    nodes={
        minimum height=0.6cm,
        inner sep=2pt,
        outer sep=0pt,
        text=white,
        font=\sffamily\bfseries\small,
        rounded corners=2pt,
        anchor=center,
        align=center
    },
    row 2/.style={
        nodes={
            text=black,
            font=\sffamily\scriptsize,
            minimum height=0.35cm,
            text height=1.5ex,
            text depth=0.25ex,
            inner sep=1pt
        }
    },
    column sep=1.5pt,
    row sep=3pt
] {
    |[fill=blue!75!black, minimum width=0.95cm]| SD &
    |[fill=teal!75!black, minimum width=0.95cm]| AC &
    |[fill=red!65!black, minimum width=0.95cm]| FC &
    |[fill=blue!75!black, minimum width=1.55cm]| DA &
    |[fill=blue!75!black, minimum width=1.55cm]| SA &
    |[fill=gray!65!blue, minimum width=1.85cm]| RI &
    |[fill=teal!75!black, minimum width=2.45cm]| INFO &
    |[fill=orange!85!black, minimum width=1.25cm]| FCS &
    |[fill=blue!75!black, minimum width=0.95cm]| ED &
    |[fill=orange!85!black, minimum width=0.95cm]| FS \\

    1 byte &
    1 byte &
    1 byte &
    6 byte &
    6 byte &
    0--30 byte &
    Variabile &
    4 byte &
    1 byte &
    1 byte \\
};
\end{tikzpicture}
\end{center}

- FC: è un byte che identifica la tipologia del frame
- DA: indirizzo MAC del destinatario
- SA: indirizzo MAC del mittente
- RI: è un campo opzionale che può ranggiungere i 30 byte e viene utilizzato quando il mittente specifica il percorso che il frame deve seguire attraverso i bridge della rete
- INFO: contiene i dati veri e propri
- FCS: contiene un valore di controllo calcolato mediante un algoritmo CRC.

La frame inviata, percorrerà tutto l’anello fino a tornare alla stazione trasmittente che avrà il compito di estrarla dal ring, e reinserire il token nel caso in cui non ha più nulla da trasmettere oppure è scaduto il **THT** (Token Holding time), e dunque deve necessariamente passare il token.

## Monitor Station

Per ogni anello vi è una stazione che monitora il funzionamento del ring. Se tale stazione si guasta è previsto un meccanismo che permette ad un'altra workstation di diventare monitor station. Questa stazione si occupa di risolvere tutte le condizioni di malfunzionamento del ring:

- controllare che il token non venga perso (es. a causa di disturbi)
- ricerca di eventuali interruzioni del ring
- eliminazione di frame che circolano indefinitivamente sul ring

## Valutazione delle prestazioni

Vengono valutate le prestazioni del protocollo, con particolare determinazione del massimo throughput ottenibile. A tal fine viene introdotto il cosidetto fattore $a$, definito come:

$$a=\frac{\text{tempo di propagazione}}{\text{tempo di trasmissione}}$$

Il fattore $a$ indica la lunghezza del mezzo di trasmissione espressa in messaggi. 

Si possono avere due casi:

- Se $a<1$, normalizzo il tempo rispetto al tempo di trasmissione. Assumento che il tempo di trasmissione di un pacchetto è pari a $1$, la sequenza di eventi è:
	1. La stazione 1 inizia a trasmettere nell’istante $t_0$.
	2. La stazione 2 inizia a ricevere all’istante $t_0+a$.
	3. La trasmissione è completata nell’istante $t_0+1$.
	4. La ricezione è completata nell’istante $t_0+a+1$.
- Viceversa se $a>1$ la sequenza di eventi è:
	1. La stazione 1 inizia a trasmettere nell’istante $t_0$.
	2. La trasmissione è completata nell’istante $t_0+1$.
	3. La stazione 2 inizia a ricevere all’istante $t_0+a$.
	4. La ricezione è completata nell’istante $t_0+a+1$.
	5. Le altre stazioni possono iniziare la trasmissione di un altro messaggio.

In ogni caso, il tempo totale per un ciclo è $1+a$, mentre il tempo di trasmissione è $1$; l’utilizzazione sarà dunque pari a:

$$U=\frac{1}{1+a}$$

![comunicazione token ring](images/terzo-classwork_20261119143430405.png)

Nel caso più generale si può immaginare che dopo che la stazione sender ha rilasciato il token, ci potrà essere una delle altre stazioni che potrà utilizzarlo. Diventa fondamentale la distinzione fra i due casi, perché nel valutare il tempo di ciclo bisogna aggiungere al tempo di propagazione del token fra la stazione e quella successiva, un tempo che nel primo caso è $a$ mentre nel secondo è $1$.

Si valuta il massimo throughput ottenibile nelle LAN supponendo che vi siano $N$ stazioni connesse.

### Token Passing

Nel protocollo Token Ring, con il passare del tempo, sull’anello transitano sia frame di dati sia token. Si definisce ciclo la successione di un singolo frame e di un token. Si definiscono:

- $C$ = tempo medio per un ciclo
- $t_{frame}$ = tempo medio di trasmissione di un frame di dati
- $t_{token}$ = tempo medio di passaggio del token

Il rate medio di ciclo è dato dall'inverso di $C$ e si ha:

$$\frac{1}{C} = \frac{1}{t_{token} + t_{frame}}$$

Indicando con $S$ il throughput della rete locale normalizzo rispetto alle capacità del sistema:

$$S=\frac{t_{frame}}{t_{frame}+t_{token}} = \frac{t_{frame}}{C}$$

$S$ rappresenta dunque la funzione di tempo che è spesa dal sistema per trasmettere i dati.

Ricordando che il tempo è normalizzato, cioè il tempo di trasmissione del pacchetto è unitario, mentre il tempo di propagazione è indicato con $a$:

Sia $a>1$, la stazione trasmette il pacchetto nell'istante $t_0$, inizia a ricevere all'istante $t_0+a$, e completa la trasmissione all'instante $t_0+1$. La stazione quindi ementte un nuovo token, che richiede un tempo pari ad $\frac{a}{N}$ per raggiungere la stazione successiva. Un ciclo richiede un tempo pari a:

$$C = 1 + \frac{a}{N} \quad \Longrightarrow \quad S = \frac{1}{1+\frac{a}{N}}$$

Sia $a<1$, la stazione trasmette nell’istante $t_0$, completa la trasmissione all’istante $t_0+1$, e riceve il pacchetto spedito all’istante $t_0+a$. A questo punto, emette il token che raggiungerà la stazione successiva dopo un tempo pari ad $\frac{a}{N}$. Il tempo di ciclo è dunque:

$$C=a+\frac{a}{N} \quad \Longrightarrow \quad S=\frac{1}{a\big(1+\frac{1}{N}\big)}$$

Considerando i risultati:

$$S =
\begin{cases}
\dfrac{1}{1+\dfrac{a}{N}} & a < 1 \\[10pt]
\dfrac{1}{a\left(1+\dfrac{1}{N}\right)} & a > 1
\end{cases}$$

---

# Real Time Protocol (RTP)

RTP  è un protocollo e rappresenta un valido supporto per il trasferimento di dati in tempo reale, come ad esempio flussi audio e video. I servizi forniti da RTP sono essenzialmente i seguenti:

1. identificazione del payload type
2. sequence numbering
3. timestamping
4. monitoring

Le applicazioni tipicamente pongono RTP sopra UDP. Il trasferimento di dati verso molteplici destinazioni avviene con una distribuzione multicast.
E' da notare che questo protocollo non prevede **nessun meccanismo che assicuri una corretta trasmissione** o che garantisca la qualità del servizio, in quanto questo e' compito degli strati più bassi. Inoltre **non si interessa direttamente di un errato ordine di consegna** dei pacchetti. I numeri di sequenza inclusi da RTP permettono al ricevente di ricostruire la sequenza.

Lo standard è diviso in due parti strettamente legate:

1. Realtime Transport Protocol (RTP): per trasportare i dati con proprietà temporali;
2. RTP Control Protocol (RTCP): per monitorare la qualità del servizio e fornire informazioni sui partecipanti di una sessione.

\begin{figure}[ht]
    \centering
    \begin{tikzpicture}[font=\normalsize]

        % Dimensioni del protocol stack
        \def\W{8}
        \def\H{4}
        \def\h{1.4}

        % Contorno esterno
        \draw[line width=0.9pt] (0,0) rectangle (\W,\H);

        % Divisioni orizzontali
        \draw[line width=0.7pt] (0,2.6) -- (\W,2.6);
        \draw[line width=0.7pt] (0,1.3) -- (\W,1.3);

        % Divisione verticale tra RTP e RTCP
        \draw[line width=0.7pt] (4,2.6) -- (4,4);

        % Etichette
        \node at (2,3.3) {RTP};
        \node at (6,3.3) {RTCP};
        \node at (4,1.95) {UDP};
        \node at (4,0.65) {IP};

    \end{tikzpicture}
\end{figure}

## Esempi d'impiego

In una conferenza audio/video entrami i media sono trasmessi come sessioni RTP separate e i pacchetti RTCP relativi usano due differenti coppie di porte UDP. Le sessioni RTP audio e video non sono perciò accoppiate tra loro per permettere ai partecipanti di ricevere soltanto uno dei due media a loro scelta. Nonostante questo è possibile sincronizzare il playback usando le informazioni di temporizzazione trasportate nei pacchetti RTCP.

\begin{figure}[H]
\centering
\begin{tikzpicture}[
    app/.style={
        circle,
        draw=blue!55!black,
        fill=blue!5,
        line width=1.2pt,
        minimum size=2.5cm,
        align=center,
        font=\small
    },
    multicast/.style={
        rectangle,
        rounded corners=7pt,
        draw=black!75,
        fill=gray!10,
        line width=1.4pt,
        minimum width=3.6cm,
        minimum height=1.7cm,
        align=center,
        font=\small
    },
    audio/.style={
        <->,
        >=Stealth,
        draw=blue!75!black,
        line width=1.1pt
    },
    video/.style={
        <->,
        >=Stealth,
        draw=red!75!black,
        line width=1.1pt
    },
    lab/.style={
        font=\scriptsize,
        fill=white,
        inner sep=2pt
    }
]

% ==========================================
% APPLICAZIONI
% ==========================================

\node[app] (A) at (-5.5,0) {
    \textbf{Applicazione}\\
    \textbf{A}
};

\node[app] (C) at (5.5,0) {
    \textbf{Applicazione}\\
    \textbf{C}
};

\node[app] (B) at (0,-5.5) {
    \textbf{Applicazione}\\
    \textbf{B}
};

% ==========================================
% GRUPPO MULTICAST
% ==========================================

\node[multicast] (M) at (0,0) {
    \textbf{\large MULTICAST}\\[5pt]
    \texttt{224.0.1.140}
};

% ==========================================
% APPLICAZIONE A - MULTICAST
% ==========================================

\draw[audio] (-4.25,0.45) -- (-1.85,0.45);
\draw[audio] (-4.25,0.15) -- (-1.85,0.15);

\draw[video] (-4.25,-0.15) -- (-1.85,-0.15);
\draw[video] (-4.25,-0.45) -- (-1.85,-0.45);

% ==========================================
% APPLICAZIONE C - MULTICAST
% ==========================================

\draw[audio] (1.85,0.45) -- (4.25,0.45);
\draw[audio] (1.85,0.15) -- (4.25,0.15);

\draw[video] (1.85,-0.15) -- (4.25,-0.15);
\draw[video] (1.85,-0.45) -- (4.25,-0.45);

% ==========================================
% APPLICAZIONE B - MULTICAST
% ==========================================

\draw[audio] (-0.55,-1.0) -- (-0.55,-4.25);
\draw[audio] (-0.20,-1.0) -- (-0.20,-4.25);

\draw[video] (0.20,-1.0) -- (0.20,-4.25);
\draw[video] (0.55,-1.0) -- (0.55,-4.25);

% ==========================================
% LEGENDA
% ==========================================

\node[font=\scriptsize] at (0,-7.0) {
    \textcolor{blue!75!black}{\rule{0.5cm}{1.2pt}}
    \quad RTP/RTCP Audio
    \qquad
    \textcolor{red!75!black}{\rule{0.5cm}{1.2pt}}
    \quad RTP/RTCP Video
};

\end{tikzpicture}
\end{figure}

Ogni partecipante invia i dati audio in pacchetti da $20ms$ di durata con un header RTP in cui è indicata la codifica usata per l'audio. Il payload type può cambiare durante la conferenza per reagire ad esempio ad un calo di banda.

## Protocollo di trasporto (RTP)

Per ogni partecipante di una conferenza, la sessione RTP è definita da una particolare coppia di indirizzi di destinazione:

1. indirizzo di rete
2. una coppia di porte (RTP e RTCP)

In una conferenza multimediale ogni media (audio o video) ha una sua separata sessione con i propri pacchetti RTCP.

Il pacchetto dati consiste in un header fisso RTP, una eventuale lista chiamata contributing source (CSRC) e il payload data (la sorgente dati).

I primi **12 byte** costituiscono l'header fisso, presente in ogni pacchetto RTP, seguito eventualmente dalla lista degli identificatori CSRC (da 0 a 15 elementi da 32 bit ciascuno):

\begin{figure}[H]
\centering
\begin{tikzpicture}[scale=0.38, every node/.style={font=\scriptsize}]
  % Griglia principale 32 bit x 4 righe (12 byte + CSRC)
  \draw[thick] (0,0) rectangle (32,10);
  
  % Linee orizzontali
  \draw[thick] (0,8) -- (32,8);
  \draw[thick] (0,6) -- (32,6);
  \draw[thick] (0,4) -- (32,4);
  \draw[thick, dashed] (0,2) -- (32,2);

  % Riga 1 (Bit 0-31)
  \draw (2,8) -- (2,10);
  \draw (3,8) -- (3,10);
  \draw (4,8) -- (4,10);
  \draw (8,8) -- (8,10);
  \draw (9,8) -- (9,10);
  \draw (16,8) -- (16,10);

  \node at (1,9) {V};
  \node at (2.5,9) {P};
  \node at (3.5,9) {X};
  \node at (6,9) {CC};
  \node at (8.5,9) {M};
  \node at (12.5,9) {PT};
  \node at (24,9) {Sequence Number};

  % Riga 2: Timestamp
  \node at (16,7) {Timestamp};

  % Riga 3: SSRC
  \node at (16,5) {SSRC (Synchronization Source Identifier)};

  % Riga 4: CSRC (opzionale)
  \node at (16,3) {CSRC (Contributing Source Identifiers - opzionale, 0..15)};
  
  % Riga 5: Payload
  \node at (16,1) {\textit{Payload Data (Audio / Video)}};

  % Indicatori bit in alto
  \node[above] at (0.3,10) {\tiny 0};
  \node[above] at (8,10) {\tiny 8};
  \node[above] at (16,10) {\tiny 16};
  \node[above] at (31.7,10) {\tiny 31};
\end{tikzpicture}
\caption{Struttura del pacchetto e dell'header RTP}
\end{figure}

- **V (Version - 2 bit):** indica la versione del protocollo (attualmente la versione 2).
- **P (Padding - 1 bit):** se impostato a 1, indica che il pacchetto contiene byte di riempimento aggiuntivi alla fine.
- **X (Extension - 1 bit):** se impostato a 1, indica la presenza di un'estensione dell'header subito dopo i campi CSRC.
- **CC (CSRC Count - 4 bit):** specifica il numero di identificatori CSRC (da 0 a 15) che seguono l'header fisso.
- **M (Marker - 1 bit):** segnala eventi significativi nel flusso (ad esempio l'inizio di un nuovo fotogramma video o di una frase dopo una pausa audio).
- **PT (Payload Type - 7 bit):** identifica il formato di codifica del contenuto trasportato (es. H.264).
- **Sequence Number (16 bit):** numero progressivo incrementato di 1 per ogni pacchetto inviato; consente al ricevitore di riordinare i pacchetti e rilevare eventuali perdite.
- **Timestamp (32 bit):** indica l'istante di campionamento del primo byte del pacchetto; permette di sincronizzare i flussi.
- **SSRC (32 bit):** identifica in modo univoco la sorgente del flusso all'interno della sessione RTP.
- **CSRC (32 bit ciascuno):** elenca le sorgenti originali che hanno contribuito al pacchetto nel caso in cui il flusso sia stato combinato da un *mixer* RTP.

## Protocollo di controllo (RTCP)

L'RTP Control Protocol è basato sulla trasmissione periodica dei pacchetti di controllo a tutti i partecipanti ad una sessione. Il protocollo sottostante deve quindi provvedere alla separazione dei pacchetti usando porte con numeri diversi.

L'RTCP ha 4 funzioni:

1. controllo qualità della trasmissione dati
2. assegna CNAME (codice univo assegnato ad ogni mittente in modo da riconoscerlo anche nel caso di un cambio di codice sessione)
3. regolazione del traffico
4. gestione conferenze aperte (opzionale)

RTCP si basa sulla trasmissione di 5 tipi di pacchetto:

- SR (sender report): per portare statistiche di ricezione e trasmissione
- RR (receiver report): statistiche di ricezione
- SDES (source descriptor): per gli elementi di descrizione, incluso CNAME
- BYE: fine di una partecipazione
- APP: pacchetti per funzioni specifiche di un'applicazione

Ogni pacchetto è costituito da una prima parte fissa e da una seconda variabile. Più pacchetti RTCP possono essere inviati in uno stesso pacchetto UDP, ogni pacchetto deve però essere processato indipendentemente.

## Banda impiegata

RTP è un protocollo progettato per sessioni che vanno da pochi a migliaia di partecipanti, quindi non solo per servizi di videoconferenza ma anche per servizi di video on demand, o trasmissioni “TV” su Internet. Non stupisce quindi l’attenzione che viene data al controllo della banda impiegata.

Prima di tutto va notato che la banda impiegata dalle trasmissioni audio sono auto limitate perché in generale parla un solo interlocutore alla volta. Per quanto riguarda il traffico video, esso cresce con il numero dei partecipanti, ma si suppone che in una conferenza il numero dei partecipanti sia limitato mentre in una trasmissione TV, la sorgente video è una sola. Si conclude quindi che anche il traffico video è auto limitato.

\begin{figure}[htbp]
\centering
\begin{tikzpicture}[
    x=1cm,
    y=1cm,
    line width=0.8pt,
    >=stealth,
    font=\small
]

% Dimensioni barra
\def\L{12}
\def\H{1.55}
\def\C{0.75}

% Barra principale
\draw (0,0) rectangle (\L,\H);
\draw (\C,0) -- (\C,\H);

% Testi nella barra
\node[rotate=90,font=\bfseries\small] (node1)
    at (0.37,0.775) {T. RTCP};

\node[font=\bfseries] at (6.4,0.775)
    {Traffico RTP};

% Casella intervallo di trasmissione
\draw (-0.1,3.85) rectangle (4.85,4.65);
\node[font=\bfseries] at (2.375,4.25)
    {Intervallo di trasmissione.};

% Freccia verso RTCP
\draw (0.37,3.85) -- (0.37,1.55);

% Casella tipo codifica
\draw (3.5,2.45) rectangle (8.9,3.25);
\node[font=\bfseries] at (6.2,2.85)
    {Tipo codifica audio/video.};

% Freccia verso RTP
\draw (6.2,2.45) -- (6.2,1.55);

% Percentuali
\node[anchor=west] at (-0.22,-0.38) {0\%};
\node[anchor=west] at (0.46,-0.38) {5\%};
\node[anchor=west] at (11.51,-0.37) {100\%};

% Freccia larghezza di banda
\draw[<->] (0,-1.15) -- (\L,-1.15);

% Etichetta larghezza di banda
\node[fill=white,inner sep=4pt] at (6,-1.15)
    {Larghezza di banda usata.};

\end{tikzpicture}
\end{figure}

Per ogni sessione si suppone quindi che il traffico sia sottoposto ad un limite di banda, da dividere fra i partecipanti. Tale limite di banda può essere scelto secondo qualche criterio (ad esempio il costo della banda, o una percentuale della banda disponibile).





---

# References
<!-- Token Ring -->
- <https://en.wikipedia.org/wiki/Token_Ring>
- <https://www3.diism.unisi.it/~giambene/reti_di_telecomunicazioni_materiale/materiale_didattico/Nuovo_Ordinamento/Accesso_multiplo_MAC.PDF>
<!-- Real Time Protocol (RTP) -->
- <https://homes.di.unimi.it/~alberti/Mm07/doc/rtp.pdf>