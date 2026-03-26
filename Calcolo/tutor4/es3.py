import numpy as np

from invlower import invlower

np.set_printoptions(precision = 4, suppress = True)

B = np.matrix ([[10, 0, 0], [0, 7, 0], [0, 0, 15]])
C = np.matrix ([[20, 1, 7], [0, 2, 17], [0, 0, 3]])
D = np.transpose(C)

print(invlower(B.copy()))
print(np.transpose(invlower(D.copy())))
print(invlower(D.copy()))

print(np.matmul(B,invlower(B.copy())))
