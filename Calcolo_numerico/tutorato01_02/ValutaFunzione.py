import numpy as np

from math import floor, sin, cos
from time import time

def valutaFunzione(n, alpha):
  """
  Valuta la funzione
    f(x) = sum_{k=0,...,n, k pari} sin(k*x)
         + f(x) sum_{k=0,...,n, k dispari} cos(k*x)
  nel punto x = alpha.
  """

  if n < 1 or floor(n) != n:
    raise Exception("n deve essere un intero positivo")
  
  z = [0,0,0]
  t = [0,0,0]

  t0 = time()
  for k in range(0, n+1):
    if k % 2 == 0:
      #k pari
      z[0] += sin(k*alpha)
    else:
      #k dispari
      z[0] += cos(k*alpha)
  t[0] = time() - t0

  #Alternativa: li prendo a coppie(attenzione all'ultimo elemento!)
  t0 = time()
  for k in range(0, n, 2):
    z[1] = z[1] + sin(k*alpha) + cos((k+1)*alpha)
  if n %2 == 0: #Manca un seno!
    z[1] = z[1] + sin(n*alpha)
  t[1] = time() - t0

  #Usando numpy: sintassi vettoriale
  t0 = time()
  if k % 2 == 0:
    z[2] = np.sum(np.sin(np.linspace(0,n//2+1)*alpha))
    z[2] += np.sum(np.cos(np.linspace(1,n-1//2+1)*alpha))
  else:
    z[2] = np.sum(np.sin(np.linspace(0,n-1//2+1)*alpha))
    z[2] += np.sum(np.cos(np.linspace(0,n//2+1)*alpha))
  t[2] = time() - t0

  return z, t