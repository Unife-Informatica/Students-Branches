# Risposte
*Fonte*: [20190206_t1.pdf](./20190206_t1.pdf)

1. 
    **Valore dell'espressione** i = i++: il valore originale di i (prima dell'incremento).
    **Effetto dell'espressione** i = i++: non c'è effettivo cambiamento nel valore di i, che rimane invariato a causa del post-incremento.

2. N matricola: 205330 --> output: EIUY

3. 
    Durante l'esecuzione del programma, il numero massimo di record di attivazione che si trovano contemporaneamente sullo stack è 3:
    - uno per il `main`
    - uno per `f(3)`.
    - uno per `f(2)`.
    
    Quando `f(2)` ritorna, il record di attivazione per `f(2)` viene rimosso, e quindi rimane solo il record di attivazione per `f(3)` prima che il programma termini.