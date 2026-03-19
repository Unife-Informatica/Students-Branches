from math import factorial
from time import time

import numpy as np

import ruffini_horner

p = np.array([1, -5, 3, -2, 1])
x0 = float(input("Inserire il punto (numero reale) nel quale valutare il polinomio: "))

t0 = time()

r1, q1 = ruffini_horner.numpy_ruffini_horner(p, x0)
r2, q2 = ruffini_horner.numpy_ruffini_horner(q1, x0)
r3, q3 = ruffini_horner.numpy_ruffini_horner(q2, x0)
r4, q4 = ruffini_horner.numpy_ruffini_horner(q3, x0)

print(f"Valore del polinomio in: p(x0) = {r1}")
print(f"Valore della derivata prima in x0: p'(x0) = {r2}")
print(f"Valore della derivata seconda in x0: p''(x0) = {2 * r3}")
print(f"Valore della derivata terza in x0: p'''(x0) = {factorial(3) * r4}")

print(f"[Test 1]: tempo di esecuzione {time() - t0}")

# -----------------------------------------------------------------

t0 = time()

r1, q1 = ruffini_horner.naive_ruffini_horner(p, x0)
r2, q2 = ruffini_horner.naive_ruffini_horner(q1, x0)
r3, q3 = ruffini_horner.naive_ruffini_horner(q2, x0)
r4, q4 = ruffini_horner.naive_ruffini_horner(q3, x0)

print(f"Valore del polinomio in: p(x0) = {r1}")
print(f"Valore della derivata prima in x0: p'(x0) = {r2}")
print(f"Valore della derivata seconda in x0: p''(x0) = {2 * r3}")
print(f"Valore della derivata terza in x0: p'''(x0) = {factorial(3) * r4}")

print(f"[Test 2]: tempo di esecuzione {time() - t0}")
