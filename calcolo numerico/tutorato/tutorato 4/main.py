import numpy as np

from invlower import invlower

np.set_printoptions(precision = 4, suppress = True)

B = np.array([[10, 0, 0], [0, 7, 0], [0, 0, 15]]) # utilizzo `np.array` al posto delle funzione deprecata `np.matrix`
C = np.array([[20, 1, 7], [0, 2, 17], [0, 0, 3]])
CT = np.transpose(C)

print(invlower(B.copy())) # faccio la copia perche la funzione agisce direttamente sulla matrice passata
print(np.transpose(invlower(CT.copy())))
print(invlower(CT.copy()))

print(np.matmul(B, invlower(B.copy()))) # moltiplico (con la funzione `matmul`) B e la sua inversa
print(np.matmul(C,  np.transpose(invlower(CT.copy()))))
print(np.matmul(CT, invlower(CT.copy())))