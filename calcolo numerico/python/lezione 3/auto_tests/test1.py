import numpy as np

print("--- Esecuzione Script 1: Evoluzione Campo Scalare ---")
grid_nodes = np.array([10, 20, 30, 40], dtype=np.int32)
scaling_factor = 0.75
lower_bound = 15.0

# BUG 1: Assegnazione in-place di float su un array int32.
# Lo studente deve inizializzare correttamente grid_nodes o utilizzare una riassegnazione.
grid_nodes *= scaling_factor

# BUG 2: La funzione np.where valuta la condizione e genera un nuovo array,
# ma il risultato non viene assegnato, lasciando grid_nodes inalterato in memoria.
np.where(grid_nodes < lower_bound, lower_bound, grid_nodes)

# --- BLOCCO DI VALIDAZIONE (NON MODIFICARE) ---
try:
    assert grid_nodes.dtype == np.float64, (
        "Errore: L'array risultante deve essere di tipo float64."
    )
    assert np.allclose(grid_nodes, [15.0, 15.0, 22.5, 30.0]), (
        "Errore: I valori nodali o l'applicazione del lower_bound sono errati."
    )
    print(
        "Script 1: Validazione superata. Gestione dei tipi e mascheramento corretti.\n"
    )
except AssertionError as e:
    print(f"Fallimento Validazione 1: {e}\n")
