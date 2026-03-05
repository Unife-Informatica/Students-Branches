"""
Fondamenti di NumPy: Sintassi, Flusso di Controllo Vettorializzato 
e Gestione della Memoria
"""

import numpy as np

# ---------------------------------------------------------
# 1. Definizione di Array e Preallocazione di Memoria
# ---------------------------------------------------------
print("--- Inizializzazione Array e Preallocazione ---")

# Utilizziamo gli stessi nomi di intro_python, ma definendoli come array NumPy.
max_iterations = np.array([500], dtype=np.int32)
tolerance = np.array([1e-6], dtype=np.float64)
step_size = np.array([0.05], dtype=np.float64)
algorithm_name = np.array(["Discesa del Gradiente"])
print(dir(algorithm_name))  # Verifica che sia un array NumPy
print(f"Tipo di algorithm_name: {type(algorithm_name)} {algorithm_name.dtype=}\n")
exit()

# Inizializzazione esplicita con np.zeros e np.ones.
# Sostituiamo l'immutabilità della tupla grid_dimensions con un array preallocato.
grid_dimensions = np.zeros((100, 100, 50), dtype=np.float64)
vector_ones = np.ones(4, dtype=np.float64)

# ---------------------------------------------------------
# 2. Opzioni di Stampa NumPy e f-strings
# ---------------------------------------------------------
np.set_printoptions(precision=4, suppress=True, linewidth=70)

print(f"Algoritmo inizializzato: {algorithm_name} {type(algorithm_name)=}\n")
print(f"Iterazioni massime: {max_iterations[0]} {max_iterations.dtype=}\n"
      f"Tolleranza: {tolerance[0]}")
print(f"Step size formattato: {step_size[0]:.3f} {step_size.dtype=} \n")
print(f"Shape di grid_dimensions (zeros): {grid_dimensions.shape}")
print(f"{type(algorithm_name)=}, {type(max_iterations)=}, {type(tolerance)=}, {type(step_size)=}\n")

# ---------------------------------------------------------
# 3. Operazioni di Base e Assegnazione Aumentata
# ---------------------------------------------------------
a = np.array([10.0, 10.0, 10.0], dtype=np.float64)
b = np.array([3.0, 3.0, 3.0], dtype=np.float64)

print(f"ID of a: {id(a)} | ID of b: {id(b)}\n")

print("Raddoppiamo a con l'istruzione a *= 2.0 \n")
# L'operatore *= modifica i dati dell'array in-place, senza creare un nuovo oggetto.
a *= 2.0  
print(f"a dopo raddoppio: {a}\n")
print(f"ID of a after modification: {id(a)}\n")

print(f"Operazioni di base tra array:\n")
addition = a + b
print(f"Addition: {addition}")
subtraction = a - b
print(f"Subtraction: {subtraction}")
multiplication = a * b
print(f"Multiplication: {multiplication}")
division = a / b           
print(f"Division: {division}")
floor_division = a // b
print(f"Floor Division: {floor_division}")
modulo = a % b             
print(f"Modulo: {modulo}")
power = a ** b             
print(f"Power: {power}\n")

# ---------------------------------------------------------
# 4. Operazioni di Base, Assegnazione Aumentata e Promozione
# ---------------------------------------------------------
int_val = np.array([5], dtype=np.int32)
float_val = np.array([2.5], dtype=np.float64)

print("Aggiungiamo 1.0 a int_val con l'istruzione int_val += 1.0")
# Essendo int_val di tipo intero, sommare un float richiede il casting
int_val = int_val + 1.0 
print(f"Identificatore di int_val: {id(int_val)} {int_val=} {int_val.dtype=}\n")

print("--- Promozione del Tipo nelle Operazioni Miste ---")
print(f"{int_val.dtype=}, {float_val.dtype=}\n")

mixed_result = int_val * float_val
print(f"Risultato di int_val * float_val: {mixed_result} | Tipo: {mixed_result.dtype}\n")

# ---------------------------------------------------------
# 5. Array NumPy vs Liste
# ---------------------------------------------------------
mixed_list = [10, 3.14159, "convergenza", False]

# Sostituiamo la lista vettoriale con un array NumPy contiguo
vector_x = np.array([0.0, 1.5, 3.0, 4.5], dtype=np.float64)

# Invece di vector_x.append(6.0), in NumPy si prealloca o si concatena 
# (sebbene la concatenazione continua sia inefficiente).
vector_x[0] = -1.0

# ---------------------------------------------------------
# 6. Viste (Views) e Assegnazione di Variabili come Riferimenti
# ---------------------------------------------------------
vector_a = np.array([1.0, 2.0, 3.0])
vector_b = vector_a        # Punta alla stessa area di memoria di vector_a

vector_b[0] = 99.0

print("--- Riferimenti di Memoria ---")
print(f"vector_a originale dopo modifica di vector_b:\n{vector_a}")
print(f"vector_a e vector_b condividono la memoria? {np.may_share_memory(vector_a, vector_b)}\n")

# ---------------------------------------------------------
# 7. Vettorializzazione di If, Elif, Else
# ---------------------------------------------------------
current_error = np.array([1e-2, 1e-4, 1e-7, 1e-3])

print("--- Flusso di Controllo Vettorializzato ---")
status = np.where(current_error < tolerance[0], 
                  "Convergenza raggiunta.", 
                  "L'algoritmo non è ancora convergente.")
print(f"Errori: {current_error}")
print(f"Stato: {status}\n")

# ---------------------------------------------------------
# 8. Vettorializzazione del Ciclo For
# ---------------------------------------------------------
# La somma vettorializzata sostituisce il ciclo for element-wise.
sum_elements = np.sum(vector_x)
print(f"Somma vettorializzata di vector_x: {sum_elements}\n")

# ---------------------------------------------------------
# 9. Ciclo While
# ---------------------------------------------------------
current_value = np.array([1.0, 1.0, 1.0])
iteration = 0

while np.linalg.norm(current_value) > 0.1 and iteration < max_iterations[0]:
    current_value /= 2.0
    iteration += 1

print(f"Ciclo while terminato all'iterazione {iteration}\n"
      f"con norma del vettore {np.linalg.norm(current_value):.4f}\n")

# ---------------------------------------------------------
# 10. Definizione di Funzioni
# ---------------------------------------------------------
def compute_norm_numpy(v, p=2, verbose=True):
    """
    Calcola la p-norma ottimizzata tramite NumPy.
    """
    if p == 2:
        norm_val = np.linalg.norm(v)
    else:
        norm_val = np.sum(np.abs(v) ** p) ** (1.0 / p)
    
    if verbose:
        print(f"Calcolata norma-{p}: {norm_val:.4f}")
        
    return norm_val

print("--- Funzioni ---")
l2_norm = compute_norm_numpy(vector_x)
l1_norm = compute_norm_numpy(vector_x, p=1)

# ---------------------------------------------------------
# 11. Funzioni con Output Multipli
# ---------------------------------------------------------
def compute_range_and_mean_numpy(v):
    """
    Calcola minimo, massimo e media di un array.
    """
    if v.size == 0:
        return None, None, None
        
    min_val = np.min(v)
    max_val = np.max(v)
    mean_val = np.mean(v)
    
    return min_val, max_val, mean_val

v_min, v_max, v_mean = compute_range_and_mean_numpy(np.array([1.5, 2.5, 3.5, 4.5]))

print(f"\nMinimo: {v_min}\nMassimo: {v_max}\nMedia: {v_mean}")

# ---------------------------------------------------------
# 12. Gestione degli Errori (Try / Except)
# ---------------------------------------------------------
print("\n--- Gestione degli Errori ---")

try:
    print(f"Tentativo di sommare array con shape incompatibili (Broadcasting error)")
    invalid_op = vector_x + np.array([1.0, 2.0])
except ValueError as e:
    print(f"Intercettata un'eccezione: {e}\n"
          "Spiegazione: NumPy richiede array con dimensioni\n"
          "compatibili per il broadcasting.")