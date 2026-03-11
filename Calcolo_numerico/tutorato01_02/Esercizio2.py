import numpy as np

from math import factorial
from time import time

import Esercizio1RuffiniHorner as rf

p = np.array([1, -5, 3, -2, 1])

x0 = input("Inserire il punto (numero reale) nel quale valutare il polinomio: ")
x0 = float(x0)

[r1, q1] = rf.NumpyRuffiniHorner(p, x0)
[r2, q2] = rf.NumpyRuffiniHorner(q1, x0)
[r3, q3] = rf.NumpyRuffiniHorner(q2, x0)
[r4, q4] = rf.NumpyRuffiniHorner(q3, x0)

print(f"\nValore del polinomio in x0: p(x0) = {r1}")
print(f"\nValore della derivata prima in x0: p'(x0) = {r2}")
print(f"\nValore della derivata seconda in x0: p''(x0) = {2*r3}")
print(f"\nValore della derivata terza in x0: p'''(x0) = {factorial(3)*r4}")

t0 = time()
[r1, q1] = rf.NaiveRuffiniHorner(p, x0)
tNaive = time() - t0

t0 = time()
[r1, q1] = rf.ruffiniHorner(p, x0)
tBetter = time() - t0

print([tNaive, tBetter])