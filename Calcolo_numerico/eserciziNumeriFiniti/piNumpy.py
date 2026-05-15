import numpy as np

def calcolaPiArctan(tollerance=1e-3):
    piReal = np.pi
    stimatedPi = 0
    n = 0
    while True:
        # Termine della serie: (-1)^n / (2n + 1)
        term = ((-1)**n) / (2*n+1)
        stimatedPi += 4*term
        n += 1
        # Verifichiamo l'errore relativo
        relativeError = abs(stimatedPi - piReal) / piReal
        if relativeError < tollerance:
            break
        return n, stimatedPi

def calcolaPiArcsin(tollerance=1e-3):
    piReal = np.pi
    # Iniziamo col primo termine: 6 * 0.5 = 3
    stimatedPi = 3.0
    term = 0.5
    n = 1
    while True:
        relativeError = abs(stimatedPi -piReal) / piReal
        if relativeError < tollerance:
            break

        # Calcolo del termine successivo basato sulla formula dell'immagine
        # Usiamo n come indice per i coefficienti
        num = (2*n - 1)
        den = (2*n)
        term *= (num/den) * (0.5**2)

        # Aggiorniamo pi_stimato aggiungendo il nuovo pezzo
        # Nota: il denominatore extra (2n+1) nella formula
        stimatedPi += 6 * (term / (2*n + 1))
        n += 1
    return n, stimatedPi

n1, valore1 = calcolaPiArctan()
n2, valore2 = calcolaPiArcsin()

print(f"Metodo arctan(1): servono {n1} termini. Valore: {valore1:.6f}")
print(f"Metodo arcsin(1/2): servono {n2} termini. Valore: {valore2:.6f}")