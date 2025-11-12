# Sintesi di reti combinatorie

Sono composte da una serie di componenti logici che eseguono operazioni su variabili in ingresso, producendo un'uscita che dipende esclusivamente da questi ingressi. Queste reti non hanno memoria, cioè non dipendono dallo stato precedente delle variabili.Vengono utilizzate per risolvere problemi in cui l'uscita dipende solo dall'entrata corrente e non da precedenti stati (**reti senza memoria**) o da sequenze temporali.

## Forma canonica

Serve per trovare l'espressione logica corrispondente ad una tabella di verità.

- **prima forma canonica**:

  - considero solo le righe con l'uscita = 1
  - ogni riga corrisponde a un prodotto logico AND (_minitermine_) di tutte le variabili
  - l'uscita è data dalla somma logica OR di tutti i minitermini individuati

  ![prima forma canonica](../attachments/prima%20forma%20canonica.png)
  $$U = \overline{A}B\overline{C}+A\overline{B}\overline{C}+AB\overline{C}$$

- **seconda forma canonica**:

  - considero solo le righe con l'uscita = 0
  - ogni riga corrisponde a un prodotto logico OR (_maxiermine_) di tutte le variabili
  - l'uscita è data dalla somma logica AND di tutti i maxitermini individuati

  ![seconda forma canonica](../attachments/seconda%20forma%20canonica.png)
  $$U = (A+B+C)\cdot(A+B+\overline{C})\cdot(A+\overline{B}+\overline{C})\cdot(\overline{A}+B+\overline{C})\cdot(\overline{A}+\overline{B}+\overline{C})$$

## Ottimizzazione

Si usa per trovare la versione più semplice, cioè con meno porte logiche e meno collegamenti.

## Forme normali

Forme canoniche che non devono necessariamente avere tutte le variabili in ogni termine.

## Tecniche di semplificazione

- **espansione**
  $$\overline{x}P+xP=P$$
- **idempotenza**
  $$P+P=P$$
- **distanza di hamming**
  se il segnale è ridondante da tre segnali ed è 111 e il ritorno 110 allora so che ce un errore.

## Implicanti e Implicati

- Implicante: in SP, un termine che, se vero, garantisce che la funzione sia vera
- Implicato: in PS, un termine che, se falso, garantisce che la funzione sia falsa