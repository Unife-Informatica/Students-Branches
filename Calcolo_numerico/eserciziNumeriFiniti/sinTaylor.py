import math

def taylorSin(x, tolerance=1e-3):
    # 1. Riduzione dell'intervallo usando la periodicita (2*pi)
    # Riportiamo x in [-pi, pi]
    x = x % (2*math.pi)
    if x > math.pi:
        x -= 2*math.pi

    # 2. Inizializzazione variabili
    result = 0
    term = x # Primo termine della serie (n=0)
    n = 0

    # 3. Calcolo della serie
    while abs(term) > tolerance:
        result += term
        n += 1
        # Calcolo del termine successivo: 
        # moltiplico per -x^2 e divido per (2n)(2n+1)
        term *= -x**2 / ((2*n) * (2*n + 1))
        
    return result


testValues = [0, math.pi/4, math.pi/2, math.pi, 5*math.pi, -math.pi/3]

print(f"{'x (rad)':>10} | {'Taylor Sin':>12} | {'Math Sin':>12} | {'Errore':>10}")
print("-" * 55)

for val in testValues:
    tSin = taylorSin(val)
    mSin = math.sin(val)
    error = abs(tSin - mSin)
    print(f"{val:10.4f} | {tSin:12.6f} | {mSin:12.6f} | {error:10.2e}")