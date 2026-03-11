import numpy as np

def NaiveRuffiniHorner(p, alpha):  
  """
  Valuta il polinomio p nel punto a utilizzando il metodo di 
  Ruffini-Horner. Il polinomio è rappresentato come un vettore contente
  i suoi coefficienti in ordine decrescente (i.e., da quello di grado più alto)
  2x^4 + 1x^2 + 3
  [2, 0, 1, 0, 3]
  """

  n = len(p) #Grado del polinomio + 1
  q = [p[0]]

  for i in range(1, n):
    q.append(q[i-1]*alpha+p[i])
  r = q.pop()
  return r, q


def ruffiniHorner(p, alpha):
  """
  Valuta il polinomio p nel punto a utilizzando il metodo di 
  Ruffini-Horner. Il polinomio è rappresentato come un vettore contente
  i suoi coefficienti in ordine decrescente (i.e., da quello di grado più alto)
  2x^4 + 1x^2 + 3
  [2, 0, 1, 0, 3]
  """

  n = len(p) #Grado del polinomio + 1
  q = p.copy()
  for i in range(1, n):
    q[i] = q[i-1]*alpha+p[i]
  r = q[-1]
  q = q[:-1]
  return r, q


def NumpyRuffiniHorner(p, alpha):
  """
  Valuta il polinomio p nel punto a utilizzando il metodo di 
  Ruffini-Horner. Il polinomio è rappresentato come un vettore contente
  i suoi coefficienti in ordine decrescente (i.e., da quello di grado più alto)
  2x^4 + 1x^2 + 3
  [2, 0, 1, 0, 3]
  """

  n = len(p) #Grado del polinomio + 1
  q = np.zeros(n, dtype=np.float64)
  q[0] = p[0]
  for i in range(1, n):
    q[i] = q[i-1]*alpha+p[i]
  r = q[-1]
  q = q[:-1]
  return r, q