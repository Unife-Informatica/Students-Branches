import numpy as np

"""
implementazione della funzione `ruffini_horner`
input: [a_n, ..., n_0], a
output: risultato, [q_{n-1}, ..., q_0]
"""


def naive_ruffini_horner(p, a):
    """
    Valuta il polinomio `p` nel punto `a` utilizzando il metodo
    Ruffini-Horner. Il polinomio è rappresentato come un vettore
    contente i suoi coefficienti in ordine decrescente (i.e., da
    quello di grado più alto).
    2x^4 + 1x^2 + 3 -> [2, 0, 1, 0, 3]
    """
    n = len(p)  # grado del polinomio + 1
    q = [p[0]]
    for i in range(1, n):
        q.append(q[i - 1] * a * p[i])
    r = q.pop()
    return r, q


def ruffini_horner(p, a):
    """
    Valuta il polinomio `p` nel punto `a` utilizzando il metodo
    Ruffini-Horner. Il polinomio è rappresentato come un vettore
    contente i suoi coefficienti in ordine decrescente (i.e., da
    quello di grado più alto).
    2x^4 + 1x^2 + 3 -> [2, 0, 1, 0, 3]
    """
    n = len(p)  # grado del polinomio + 1
    q = p.copy()  # devo usare `copy()` perché se no passo per riferimento
    for i in range(1, n):
        q[i] = q[i - 1] * a + p[i]
    r = q[-1]
    q = q[:-1]
    return r, q


def numpy_ruffini_horner(p, a):
    """
    Valuta il polinomio `p` nel punto `a` utilizzando il metodo
    Ruffini-Horner. Il polinomio è rappresentato come un vettore
    contente i suoi coefficienti in ordine decrescente (i.e., da
    quello di grado più alto).
    2x^4 + 1x^2 + 3 -> [2, 0, 1, 0, 3]
    """
    n = len(p)  # grado del polinomio + 1
    q = np.zeros(n, dtype=np.float64)
    q[0] = p[0]
    for i in range(1, n):
        q[i] = q[i - 1] * a + p[i]
    r = q[-1]
    q = q[:-1]
    return r, q
