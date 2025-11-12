# Algebra di Boole

$$A=\{A,+,\cdot,',0,1\}$$

- $A$ supporto all'algebra
- $+$: OR
- $\cdot$: AND
- $'$: NOT
- $0$ elemento neutro rispetto a $+$, $1$ elemento neutro rispetto a $\cdot$

## Proprietà

| Proprietà          | Formula                                                               |
| ------------------ | --------------------------------------------------------------------- |
| Associativa        | $x+(y+z)=(x+y)+z\text{ e }x\cdot (y\cdot z)=(x\cdot y)\cdot z$        |
| Idempotenza        | $x+x=x\text{ e } x\cdot x=x$                                          |
| Elemento nullo     | $x+1=1\text{ e } x\cdot 0 = 0$                                        |
| Assorbimento       | $x+x\cdot y = x \Rightarrow x\cdot (x+y) = x$                         |
| Semplificazione    | $x+x'\cdot y = x+y \Rightarrow x\cdot (x'+y) = x\cdot y$              |
| Involuzione        | $(x')' = x$                                                           |
| Leggi di De Morgan | $(x+y)'=x'\cdot y' \text{ e } (x\cdot y)'=x'+y'$                      |
| Consenso           | $x \cdot y + x' \cdot z + \boxed{y \cdot z} = x \cdot y + x' \cdot z$ |

# Algebra di commutazione

$$f:\{0,1\}^n\rightarrow\{0,1\}$$

Le funzioni di commutazione possono essere descritte attraverso tabelle di verità. SI ha una riga per ciascuna configurazione delle variabili e il corrispondente risultato di $f$.

## Letterali

Coppia (variabile, valore)

Una variabile booleana $x$ può assumere solo due valori:

- $0$ (falso)
- $1$ (vero)

Allora ci sono due letterali possibili per x:

- $(x, 1)$ -> significa che $x$ è vero -> si indica semplicemente come $x$
- $(x, 0)$ -> significa che $x$ è falso -> si indica come $x′$

> Quindi, $x$ è il letterale "vero", mentre $x′$ è il letterale "negato".