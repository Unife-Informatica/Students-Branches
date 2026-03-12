import numpy as np

print("--- Esecuzione Script 3: Algebra Lineare e Stabilità Numerica ---")
nrows, ncols = 500, 100
A = np.ones((nrows, ncols), dtype=np.float64)
v = np.ones(nrows, dtype=np.float64)

# BUG 1: Dimensione errata in preallocazione per il calcolo A^T * v.
# L'operazione A^T @ v restituisce un vettore di dimensione 'ncols'.
# Questo genererà un ValueError durante l'esecuzione di np.matmul.
w_result = np.empty(nrows, dtype=np.float64)
np.matmul(A.T, v, out=w_result)

# BUG 2: Creazione di una matrice ausiliaria per perturbare A.T.
# L'attributo .T restituisce una vista. Modificare A_transposed altera anche A.
# Lo studente deve forzare l'allocazione di un nuovo oggetto indipendente.
A_transposed = A.T
A_transposed[0, 0] = -999.0

# BUG 3: Ottimizzazione e mitigazione dell'errore di arrotondamento.
# Valutare f(x) = exp(x+1) - exp(x) in modo ingenuo richiede due computazioni
# esponenziali e sottrae valori grandi per x elevati.
# Lo studente deve implementare la forma fattorizzata analiticamente equivalente.
x_val = 50.0
f_x_naive = np.exp(x_val + 1.0) - np.exp(x_val)
f_x_stable = f_x_naive  # SOSTITUIRE con la formulazione ottimizzata (es. raccoglimento)

# --- BLOCCO DI VALIDAZIONE (NON MODIFICARE) ---
try:
    assert w_result.shape == (ncols,), (
        f"Errore: La dimensione preallocata è {w_result.shape}, ma era attesa ({ncols},)."
    )

    assert A[0, 0] == 1.0, (
        "Errore: La matrice originale A è stata modificata. Utilizzare un metodo esplicito per disaccoppiare la memoria."
    )

    expected_stable = np.exp(x_val) * (np.e - 1.0)
    assert np.isclose(f_x_stable, expected_stable, rtol=1e-14), (
        "Errore: La valutazione non è ottimizzata. Implementare la forma fattorizzata."
    )
    print(
        "Script 3: Validazione superata. Preallocazione, disaccoppiamento memoria e formulazione algebrica corretti.\n"
    )
except AssertionError as e:
    print(f"Fallimento Validazione 3: {e}\n")
except ValueError as ve:
    print(f"Fallimento Esecuzione 3 (ValueError): {ve}\n")
