# ================================
# APPUNTI SU NUMPY: VETTORI E MATRICI
# ================================

import numpy as np  # Libreria fondamentale per il calcolo numerico in Python

# --------------------------------
# CREAZIONE DI ARRAY (VETTORI E MATRICI)
# --------------------------------

# np.ones() crea un array pieno di 1
a = np.ones((2, 2), dtype=np.float32)  
# (2,2) = matrice 2 righe x 2 colonne
# dtype=np.float32 = tipo di dato (numeri reali a 32 bit)
print("Matrice di 1:")
print(a)

# np.arange() crea un vettore con valori in sequenza
a = np.arange(5)
# Crea un vettore: [0 1 2 3 4]
print("Vettore con arange:")
print(a)

# --------------------------------
# COPIA E MODIFICA DI ARRAY
# --------------------------------

# np.array(a) crea una COPIA dei dati di a
b = np.array(a)

# Modifico i primi 3 elementi del vettore
b[:3] = 99
# b diventa: [99 99 99 3 4]
print("Vettore modificato:")
print(b)

# IMPORTANTE:
# Se avessi scritto b = a
# NON sarebbe una copia, ma un riferimento!
# Modificando b, cambierebbe anche a.

# --------------------------------
# VETTORI (ARRAY 1D)
# --------------------------------

v = np.array([1, 2, 3, 4])

# Proprietà principali
print("Dimensioni:", v.shape)   # (4,)
print("Numero dimensioni:", v.ndim)  # 1
print("Numero elementi:", v.size)  # 4

# Operazioni matematiche (element-wise)
print("v * 2 =", v * 2)       # Moltiplicazione elemento per elemento
print("v + 10 =", v + 10)     # Somma elemento per elemento

# --------------------------------
# MATRICI (ARRAY 2D)
# --------------------------------

M = np.array([[1, 2],
              [3, 4]])

print("Matrice M:")
print(M)

print("Shape:", M.shape)   # (2,2)
print("Dimensioni:", M.ndim)  # 2

# Accesso agli elementi
print("Elemento riga 0 colonna 1:", M[0, 1])

# Riga intera
print("Prima riga:", M[0, :])

# Colonna intera
print("Prima colonna:", M[:, 0])

# --------------------------------
# OPERAZIONI TRA MATRICI
# --------------------------------

A = np.array([[1, 2],
              [3, 4]])

B = np.array([[5, 6],
              [7, 8]])

# Somma elemento per elemento
print("A + B =")
print(A + B)

# Moltiplicazione elemento per elemento
print("A * B =")
print(A * B)

# Prodotto matriciale (moltiplicazione tra matrici)
print("Prodotto matriciale A @ B =")
print(A @ B)
# Oppure: np.dot(A, B)

# --------------------------------
# FUNZIONI UTILI
# --------------------------------

# Matrice identità
I = np.eye(3)
print("Matrice identità 3x3:")
print(I)

# Matrice di zeri
Z = np.zeros((2,3))
print("Matrice di zeri 2x3:")
print(Z)

# Trasposta
print("Trasposta di A:")
print(A.T)

# --------------------------------
# STATISTICHE BASE
# --------------------------------

x = np.array([1, 2, 3, 4, 5])

print("Somma:", np.sum(x))
print("Media:", np.mean(x))
print("Massimo:", np.max(x))
print("Minimo:", np.min(x))

# --------------------------------
# CONCETTI IMPORTANTI
# --------------------------------

# 1) Gli array NumPy sono più veloci delle liste Python
# 2) Le operazioni sono vettorializzate (niente for espliciti)
# 3) Tutti gli elementi hanno lo stesso tipo (dtype)
# 4) Le operazioni sono fatte elemento per elemento (salvo prodotto matriciale)

# --------------------------------
# DIFFERENZA TRA VIEW E COPY
# --------------------------------

a = np.arange(5)
b = a[0:3]   # VIEW (vista, non copia)
b[0] = 100

print("Array originale dopo modifica view:")
print(a)
# Modificando b cambia anche a!

# Per fare una copia vera:
c = a[0:3].copy()
c[0] = -1

print("Array originale dopo modifica copy:")
print(a)
# Qui a NON cambia
