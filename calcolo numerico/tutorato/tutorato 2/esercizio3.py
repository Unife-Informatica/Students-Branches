import math
from time import time

import numpy as np


def valuta_funzione(n, alpha):
    """
    Valuta la funzione:
        f(x) = sum_ {k=0, ... , n, k pari} sin(k*x)
             + sum_ {k=0, ... , n, k dispari} cos(k*x)
    nel punto x = k
    """

    if n < 1 or math.floor(n) != n:
        raise Exception("n deve essere un intero positivo")

    z = [0, 0, 0]
    t = [0, 0, 0]

    t0 = time()
    for k in range(0, n + 1):
        if k % 2 == 0:
            # k pari
            z[0] += math.sin(k * alpha)
        else:
            # k dispari
            z[0] += math.cos(k * alpha)

    t[0] = time() - t0

    # range(start, stop, step)
    t0 = time()
    for k in range(0, n, 2):
        z[1] += math.sin(k * alpha) + math.cos((k + 1) * alpha)
    if n % 2 == 0:  # manca un seno (caso dispari)
        z[1] += math.sin(n * alpha)
    t[1] = time() - t0

    # numpy con sintassi vettoriale
    t0 = time()
    if k % 2 == 0:
        z = [0, 0]
        z[2] = np.sum(np.sin(np.linspace(0, n, n // 2 + 1) * alpha))
        z[2] += np.sum(np.cos(np.linspace(0, n - 1, n // 2 + 1) * alpha))
    else:
        z[2] = np.sum(np.sin(np.linspace(0, n, n // 2 + 1) * alpha))
        z[2] += np.sum(np.cos(np.linspace(0, n - 1, n // 2 + 1) * alpha))
    t[2] = time() - t0

    # TIPS per fare un controllo tra due float posso usare il
    # seguente codice che dice:
    # "le due cifre sono uguali fino a 8 numeri dopo la virgola"
    # abs(z[0] - z[1]) < 1e-8

    return z, t
