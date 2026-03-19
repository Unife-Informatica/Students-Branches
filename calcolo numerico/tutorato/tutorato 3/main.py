import numpy as np


def valuta_funzione(k, a, b, N):
    """
    valuta_funzione - Implementa la funzione richiesta dall'esercizio 3 di tutorato
    Valuta la funzione
      f_k(x) = k * (1 - x)^2 * exp(-x^2),  k in [1, 10],
    negli N+1 punti equispaziati dell'intervallo [a,b] e restituisce nel vettore
    y i valori ottenuti.
    SYNOPSIS
      y = valuta_funzione(k, a, b, N)
    INPUT
      k   (float, scalar) - Parametro nell'intervallo [1, 10]
      a,b (float, scalar) - Estremi dell'intervallo [a,b]
      N   (int, scalar)   - Intero positivo: numero di punti equispaziati di
                            campionamento di [a,b]
    OUTPUT
      y   (float, array)  - Vettore dei valori della funzione nel campionamento
                            equispaziato di [a,b]
    """

    # Controlli sui parametri di ingresso
    if (k is None) or (a is None) or (b is None) or (N is None):
        raise ValueError("Nessuno dei parametri di ingresso puo' essere lasciato vuoto")
    elif (k < 1) or (k > 10):
        raise ValueError("Il parametro k deve avere valore in [1, 10]")
    elif a >= b:
        raise ValueError("a deve essere minore stretto di b")
    elif (N < 1) or (int(N) != N):
        raise ValueError("N deve essere un intero positivo")

    xx = np.linspace(a, b, N + 1)
    return k * (1 - xx) ** 2 * np.exp(-xx * xx)
