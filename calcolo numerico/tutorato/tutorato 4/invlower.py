import numpy as np

def invlower(L):
    """
    Sovrascrive una matrice triangolare inferiore con la propria inversa.
    """
    _, n = L.shape # mi ritorna la tupla con il numero di righe e di colonne
    if not np.diagonal(L).all():  # `diagonal` mi ritorna un vettore con i valori nella diagonale della matrice
                                    # `all` controlla che nessun elemento sia zero
        raise ValueError("La matrice non è invertibile")
    
    if L.dtype != np.float64:
        L = np.float64(L)
    
    L[0, 0] = 1/L[0, 0]
    for i in range(1, n):
        L[i, i] = 1 / L[i, i]
        for j in range(0, i):
            # - (sum_{k=j+1}^i) r_{kj} * p_{ik}) / r_{ii}
            L[i, j] = -np.dot(L[i, j:i], L[j:i, j]) * L[i, i] # itero da j perche gli array partono da 0
    return L