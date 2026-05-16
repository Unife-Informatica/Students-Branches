import numpy as np

def risolviEquazioneStabile(a, b, c):
    # Calcolo del delta
    delta = b**2 - 4*a*c

    if delta < 0:
        return "Radici complesse (non trattate in questo script)"
    
    sqrtDelta = np.sqrt(delta)

    # Calcoliamo la radice stabile (quella che evita b - b)
    # Se b è positivo, la radice stabile è quella col segno meno: -b - sqrt(delta)
    # Se b è negativo, la radice stabile è quella col segno più: -b + sqrt(delta)
    if b > 0:
        x1 = (-b - sqrtDelta) / (2*a)
    else:
        x1 = (-b + sqrtDelta) / (2*a)

    # Ricaviamo la seconda radice usando la relazione x1 * x2 = c/a
    # x2 = c / (a * x1)
    x2 = c / (a*x1)

    return x1, x2

aVal = 1
bVal = 1000000.0
cVal = 1

# Risultato con formula classica
xClassico1 = (-bVal + np.sqrt(bVal**2 - 4*aVal*cVal)) / (2*aVal)

# Risultato con formula stabile
x1Stabile, x2Stabile = risolviEquazioneStabile(aVal, bVal, cVal)

print(f"Formula Classica (x1): {xClassico1}")
print(f"Formula Stabile  (x1): {x2Stabile}  <-- Questa è quella precisa!")