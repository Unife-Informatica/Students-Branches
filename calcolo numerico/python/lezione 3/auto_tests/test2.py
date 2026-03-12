import numpy as np

print("--- Esecuzione Script 2: Matrici e Broadcasting ---")
domain = np.ones((5, 5), dtype=np.float64)
damping = 0.5
column_bias = np.array([0.1, 0.2, 0.3, 0.4, 0.5])  # Vettore di dimensione (5,)

# Creazione di una vista sui nodi interni (sottomatrice 3x3 centrale)
interior_nodes = domain[1:-1, 1:-1]

# BUG 1: Si valuta (interior_nodes * damping) allocando una nuova variabile locale,
# disconnettendola dall'indirizzo di memoria della matrice 'domain' originale.
interior_nodes = interior_nodes * damping

# BUG 2: Si desidera sottrarre column_bias da ciascuna COLONNA della matrice domain.
# In NumPy, domain - column_bias effettua il broadcasting per RIGHE.
# Lo studente deve alterare le dimensioni di column_bias (es. con np.newaxis)
# per forzare l'allineamento column-wise.
domain_corrected = domain - column_bias

# --- BLOCCO DI VALIDAZIONE (NON MODIFICARE) ---
try:
    assert np.allclose(domain[1:-1, 1:-1], 0.5), (
        "Errore: La sottomatrice interna di 'domain' non è stata alterata."
    )
    assert domain[0, 0] == 1.0, (
        "Errore: Le condizioni al contorno (Dirichlet) sono state corrotte."
    )

    # Validazione del corretto broadcasting column-wise
    expected_col_0 = np.array([0.9, 0.4, 0.4, 0.4, 0.9])
    assert np.allclose(domain_corrected[:, 0], expected_col_0), (
        "Errore: Il vettore di bias è stato sottratto per righe invece che per colonne."
    )
    print(
        "Script 2: Validazione superata. Viste e Broadcasting implementati con successo.\n"
    )
except AssertionError as e:
    print(f"Fallimento Validazione 2: {e}\n")
