# 03 - Spazi e Sottospazi Vettoriali, Combinazioni Lineari, Lineare Dipendenza e Indipendenza, Relazione di Grassmann


## Spazio vettoriale
Un campo è un insieme $\mathbb{K}$ in cui sono definite due operazioni interne (somma e prodotto).

Uno spazio vettoriale su un campo $\mathbb{K}$ è un'insieme $V$ in cui sono definite:
- un operazione interna tra elementi di $V$, detta *somma*
- un'operazione di prodotto che associa ad ogni coppia formata da un elemento di $V$ e da un elemento di $K$ un unico elemento di $V$.

L'insieme $\mathbb{R}^n=\{(x_1, x_2, ..., x_n) : x_n \in\mathbb{R}\}$ di tutte le n-uple ordinate di numeri reali con le due operazioni di somma e moltiplicazione per uno scalare cosi definite:
$$
(x_1, x_2, ..., x_n) + (y_1, y_2, ..., y_n) = (x_1+y_1, x_2+y_2, ..., x_n+y_n)\\
\lambda (x_1, x_2, ..., x_n) = (\lambda x_1, \lambda x_2, ..., \lambda x_n)\quad \lambda\in\mathbb{R}
$$
è uno spazio vettoriale su $\mathbb{R}$.



## Sottospazio
È un sottoinsieme di uno spazio vettoriale che funziona come uno spazio vettoriale da solo.

Requisiti:
- Deve contenere il vettore zero (es: $(0,0)$)
- Se sommi due vettori del sottospazio, il risultato deve restare dentro.
- Se moltiplichi un vettore per un numero, il risultato resta dentro.



## Combinazione lineare
Siano due vettori $\vec{v_1}$ e $\vec{v_2}$ e due coefficienti $a_1, a_2 \in \mathbb{R}$ allora la combinazione lineare è:
$$a_1\cdot\vec{v_1} + a_2\cdot\vec{v_2}$$



## Indipendenza e dipendenza lineare
- Un insieme di vettori è indipendente se nessuno si può ottenere sommando gli altri.
- È dipendente se almeno uno si può ottenere come combinazione degli altri.

Esempio:
$$
(1,0),(0,1) \Rightarrow\text{indipendenti}\\
(1,0),(2,0) \Rightarrow\text{dipendenti perché }(2,0) = 2\cdot(1,0)\\
$$

### Esercizio
I vettori $v_1=(1,2)$ e $v_2=(4,1)$ sono linearmente dipendenti o indipendenti?
*Svolgimento*:
Devo risolvere $\lambda_1v_1 + \lambda_2v_2 = 0$
$$\lambda_1(1,2)+\lambda_2(4,1)=(0,0) \Rightarrow (\lambda_1+4\lambda_2, 2\lambda_1+\lambda_2)=(0,0)$$

Lo metto quindi a sistema:
$$
\left\{
\begin{array}{l}
\lambda_1+4\lambda_2 = 0 \\
2\lambda_1+\lambda_2 = 0
\end{array}
\right.
\Rightarrow
\left\{
\begin{array}{l}
\lambda_1 = 0 \\
\lambda_2 = 0
\end{array}
\right.
$$
L'unica combinazione lineare che da il vettore nullo ha tutti i coefficienti nulli. Quindi $v_1$ e $v_2$ sono linearmente indipendenti.


## Dimensione
Numero di vettori in una base.
- $\mathbb{R}^2$: dimensione 2
- $\mathbb{R}^3$: dimensione 3



## Somma di sottospazi



## Relazione di Grassmann
Dati due sottospazi $U$ e $W$, allora la dimensione della loro somma è:
$$dim(U+V)=dim(U)+dim(V)−dim(U\cap V)$$



## Somma diretta
Siano $U$ e $V$ due sottospazi di uno spazio vettoriale $E$. Si dice che la loro somma è diretta e si scrive $E=U\oplus V$ se $U\cap V=\{0\}$



# Formulario
- stabilire i sottospazi:
    - vettore nullo incluso
    - somma interna
    - prodotto interno

- stabilire se $v_1, v_2, \dots, v_n$ sono basi di $V$:
    - sono linearmente indipendenti: siano due vettori $v_1=(1,2)$ e $v_2=(5,1)$ allora $\lambda_1v_1 + \lambda_2v_2 = 0$ quindi $\lambda_1(1,2)+\lambda_2(5,1)=(0,0)$. Infine dovrò definire un sistema.
    - sono un sistema di generatori: siano due vettori $v_1=(1,2)$ e $v_2=(5,1)$ allora $\lambda_1v_1 + \lambda_2v_2 = (a,b)$ quindi $\lambda_1(1,2)+\lambda_2(5,1)=(a,b)$. Infine dovrò definire un sistema.