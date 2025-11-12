# Componenti per l'elaborazione binaria dell'informazione

## CMOS

Il CMOS è un circuito che funge da interruttore. Quando $x$ è a 1 l'interruttore superiore si chiude e quello inferiore si apre in modo da far passare la tensione. Al contrario quando $x$ va a 0 l'interruttore superiore si apre mentre quello inferiore si chiude in modo da collegare l'uscita direttamente a massa.

## Aspetti tecnologici

- **costo**
- **ritardo di propagazione**: dato dal numero di transistori in serie che pilotano il nuovo valore. Questo ritardo contribuisce a determinare le prestazioni di un sistema.

## Reti logiche combinatorie

Insieme di porte logiche interconnesse secondo opportune regole in modo da una relizzare una funzione $f:\{0,1\}^n\rightarrow\{0,1\}^m$

### Algoritmo di analisi

- Rete logica $\Rightarrow$ Espressione $\Rightarrow$ Funzione
  1. si assegna un nome a ciascun ingresso (a, b, c, ...)
  2. si esprime l'uscita di ciascun gate (porte AND, OR, ...)
  3. quando si hanno le espressioni di uscita si ottiene la tabella di verità
- Funzione $\Rightarrow$ Espressione $\Rightarrow$ Rete logica
