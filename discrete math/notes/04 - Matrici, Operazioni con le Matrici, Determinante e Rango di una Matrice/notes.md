# 04 - Matrici, Operazioni con le Matrici, Determinante e Rango di una Matrice


## Matrici
> Siano $m$ e $n$ due naturali positivi. Una matrice $m \times n$ a elementi in $\mathbb{R}$ è una tabella $M$ di $m \times n$ numeri reali.
$$
M = 
\begin{pmatrix}
a_{11} & a_{12} & \cdots & a_{1n} \\
a_{21} & a_{22} & \cdots & a_{2n} \\
\vdots & \vdots & \ddots & \vdots \\
a_{m1} & a_{m2} & \cdots & a_{mn}
\end{pmatrix}
= (a_{ij})_{\substack{1, \dots,  m \\ 1, \dots, n}}
$$

Si può denotare più semplicemente con $(a_{ij})$, ove il primo indice $i$ è una informazione sulle righe, il secondo $j$ è una informazione sulle colonne.



## Trasposizione
> Sia $A = (a_{ij})_{\substack{1, \dots,  m \\ 1, \dots, n}}$ di dimensione $m\times n$. Si dice trasposta di $A$ la matrice $B = (b_{ij})_{\substack{1, \dots,  m \\ 1, \dots, n}}$ di dimensione $n\times m$ tale che:
$$b_{ij} = a_{ji}$$
In pratica la trasposta di $A$ si ottieni scambiando le righe con le colonne e si indica con $A^\top$



### Operazioni
Considero $\alpha = 3$ e le matrici $A$, $B$ di dimensioni $2\times4$:
$$
A = \begin{pmatrix}
2 & 1 & 5 & 3 \\
4 & 2 & 8 & 1
\end{pmatrix}, \quad
B = \begin{pmatrix}
2 & 0 & 4 & -1 \\
1 & 0 & 2 & 8
\end{pmatrix}
$$
Calcoliamo la **somma** $A+B$ tra matrici:
$$
A+B=
\begin{pmatrix}
4 & 1 & 9 & 2 \\
5 & 2 & 10 & 9
\end{pmatrix}
$$
ed il **prodotto** di $A$ per lo scalare:
$$
\alpha A =
\begin{pmatrix}
6 & 3 & 15 & 9 \\
12 & 6 & 24 & 3
\end{pmatrix}
$$



## Prodotto di matrici
> Date due matrici $A\in M_{m\times n}$ e $B\in M_{n\times p}$ il prodotto $AB$ è una nuova matrice $C\in M_{n\times p}$ i cui elementi $c_{ij}$ si ottengono così:
$$
c_{ij} = a_{i1}\cdot b_{1j} + a_{i2}\cdot b_{2j} + \dots + a_{in}\cdot b_{nj} = \sum_{k=1, \dots, n} a_{ik}b_{kj}
$$
![matrix multiplication](../attachments/matrix%20multiplication.png)
In sostanza l'elemento $c_{ij}$ si ottiene facendo il prodotto scalare tra l'i-esima riga della matrice $A$ e la j-esima colonna della matrice $B$ (pesante come vettori n-dimensionali).

**Attenzione!** Posso moltiplicare tra loro due matrici solo se il numero di colonne della prima coincide con il numero di colonne della seconda.

*Osservazione 1*: Le matrici quadrate sono le uniche che possono essere moltiplicate per se stesse, e se $A$ è una matrice quadrata al posto di scrivere $AA$ posso scrivere $A^2$

*Osservazione 2*: Se $A$ e $B$ sono entrambi matrici quadrate dello stesso ordine è definito sia $AB$ che $BA$ e, in generale, $AB\not=BA$. Quindi il **prodotto non è commutativo** e quindi devo specificare l'ordine in cui compaiono le matrici.



## Inversa di una matrice
> Una matrice $A\in M_n$ si dice invertibile se esiste una matrice $B\in M_n$ tale che:
$$AB=BA=I_n$$
dove $I_n$ denota la matrice identità $n\times n$.
In questo caso la matrice $B$ è chiamata inversa di A e viene indicata con $A^{-1}$
Perché $A$ sia invertibile deve essere singolare, ovvero $detA\not=0$.



## Sottomatrice
Sia $A\in M_{m,n}(\mathbb{R})$. Consideriamo $m_1$ righe e $n_1$ colonne di $A$ con $m_1 \le m$ e $n1 \le n$. La matrice formata dagli elementi di incrocio tra le $m_1$ righe e le $n_1$ colonne considerate si dice sottomatrice di $A$ di dimensioni $m_1 \times n_1$.



## Determinante di una matrice
Per calcolare il determinante di una matrice:
$$
A =
\begin{pmatrix}
a & b \\
c & d
\end{pmatrix}
$$
si fa così:
$$det = a\cdot d - b\cdot c$$
Se il determinante è diverso $0$ la matrice ha un inversa, se invece è uguale a $0$ allora non è invertibile.

### Determinante con La Place
$$detA=\sum^n_{j=1}[a_{ij}\cdot(-1)^{i+j}\cdot det(A_{ij})]$$



## Rango di una matrice
Si dice rango per righe $r$ di una matrice $A\in M_{mn}(\mathbb{R})$ il massimo numero di righe di $A$ linearmente indipendenti; vale $r \le min(m,n)$.
Si dice rango per colonne c di una matrice $A\in M_{mn}(\mathbb{R})$ il massimo numero di colonne di $A$ linearmente indipendenti; vale $c \le min(m,n)$.

Per una matrice quadrata di ordine $n$ non singolare (tale cioè che $|A|\not= 0$), si ha $r = c = n$.



# Formulario
- calcolo matrice inversa
  - 