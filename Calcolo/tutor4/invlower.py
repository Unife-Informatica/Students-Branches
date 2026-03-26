import numpy as np

# L matrice diagonale inferiore
def invlower(L):
    """
    Sovrascire una matrice triangolare inferiore con la propria inversa.
    """
    (n, m) = L.shape
    if (not np.diagonal(L).all()):
        raise ValueError("La matrice L non e' invertibile")
        
    L[0, 0] = 1/L[0, 0]
    for i in range(1, n):
        L[i, i] = 1/L[i, i]
        for j in range(0, i):
            # - sum (k=j+1)^i r_kj * p_ik)/r_ii
            L[i, j] = - np.dot(L[i, j:i], L[j:i, j]) * L[i,i]
            
    return L
