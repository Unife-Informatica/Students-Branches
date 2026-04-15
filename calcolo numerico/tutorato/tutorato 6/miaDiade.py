import numpy as np


# Una diade è una matrice ottenuta come prodotto tra due vettori colonna:
# A = r * s^T
# dove s^T è il trasposto di s.
# Una matrice di questo tipo ha sempre rango <= 1 (se r e s non sono nulli → rango = 1).
def miaDiade(r, s):
    """
    Calcola la diade A = r s^T e ne ricava:
    - rango
    - determinante
    - norma infinito

    PARAMETRI:
    r, s : vettori colonna (array numpy di dimensione n x 1)

    OUTPUT:
    rango : rango della matrice A
    determinante : prodotto degli elementi diagonali della R (da QR)
    normaInf : norma infinito della matrice A
    """

    # Controllo che i vettori non siano vuoti
    if r.size == 0 or s.size == 0:
        raise ValueError("[Errore]: i due vettori in input devono essere non vuoti")

    # Controllo che siano vettori colonna (forma n x 1)
    if not (r.shape[1] == 1 and s.shape[1] == 1):
        raise ValueError("[Errore]: i due vettori devono essere vettori colonna")

    # Costruzione della diade:
    # r @ s^T produce una matrice n x n
    # @ è l'operatore di moltiplicazione matriciale in NumPy
    A = r @ np.transpose(s)

    # Dimensioni della matrice A
    m, n = A.shape

    # Decomposizione QR:
    # A = Q R
    # Q è ortogonale, R è triangolare superiore
    # Questa decomposizione è utile per stimare il rango
    Q, R = np.linalg.qr(A)

    # Estrazione della diagonale di R
    # Gli elementi diagonali di R contengono informazioni sul rango
    diagonaleR = np.diag(R)

    # Norma infinito:
    # è il massimo della somma dei valori assoluti per riga
    normaInf = np.linalg.norm(A, np.inf)

    # Calcolo del rango:
    # Si contano quanti elementi diagonali di R sono "significativamente diversi da zero"
    # eps = precisione macchina (circa 1e-16 per float64)
    # normaInf serve a scalare la soglia numerica
    rango = len(np.argwhere(abs(diagonaleR) > np.finfo(float).eps * normaInf))

    # Determinante:
    # Per una matrice triangolare (R), il determinante è il prodotto degli elementi diagonali
    # ATTENZIONE: per una diade (rango 1), il determinante sarà sempre 0 se n > 1
    determinante = np.prod(diagonaleR)

    return rango, determinante, normaInf


if __name__ == "__main__":
    # Esempio di utilizzo

    # Definizione di due vettori colonna
    r = np.array([[1], [2], [3]])
    s = np.array([[4], [5], [6]])

    rango, determinante, normaInf = miaDiade(r, s)

    print("Rango:", rango)
    print("Determinante:", determinante)
    print("Norma infinito:", normaInf)
