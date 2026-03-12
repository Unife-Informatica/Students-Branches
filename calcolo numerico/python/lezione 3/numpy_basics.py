"""
Fondamenti di NumPy: Sintassi, Flusso di Controllo Vettorializzato,
Gestione della Memoria e Operazioni di Algebra Lineare
"""

import time

import numpy as np

# ---------------------------------------------------------
# 1. Definizione di Array e Preallocazione di Memoria
# ---------------------------------------------------------
print("--- 1. Inizializzazione Array e Preallocazione ---")

max_iterations = np.array([500], dtype=np.int32)
tolerance = np.array([1e-6], dtype=np.float64)
step_size = np.array([0.05], dtype=np.float64)
algorithm_name = np.array(["Discesa del Gradiente"])

grid_dimensions = np.zeros((100, 100, 50), dtype=np.float64)
vector_ones = np.ones(4, dtype=np.float64)

print(
    f"Tipo di algorithm_name: {type(algorithm_name)} | dtype: {algorithm_name.dtype}\n"
)

# ---------------------------------------------------------
# 2. Opzioni di Stampa NumPy e f-strings
# ---------------------------------------------------------
np.set_printoptions(precision=4, suppress=True, linewidth=70)

print(f"Iterazioni massime: {max_iterations[0]} | dtype: {max_iterations.dtype}")
print(f"Tolleranza: {tolerance[0]}")
print(f"Step size formattato: {step_size[0]:.3f} | dtype: {step_size.dtype}\n")

# ---------------------------------------------------------
# 3. Operazioni di Base e Assegnazione In-Place
# ---------------------------------------------------------
print("--- 3. Operazioni di Base e Assegnazione In-Place ---")
a = np.array([10.0, 10.0, 10.0], dtype=np.float64)
b = np.array([3.0, 3.0, 3.0], dtype=np.float64)

print(f"ID di a: {id(a)} | ID di b: {id(b)}")

a *= 2.0
print(f"a dopo raddoppio in-place (a *= 2.0): {a}")
print(f"ID di a post-modifica: {id(a)}\n")

print(f"Addition: {a + b}")
print(f"Division: {a / b}")
print(f"Floor Division: {a // b}\n")

# ---------------------------------------------------------
# 4. Promozione del Tipo nelle Operazioni Miste
# ---------------------------------------------------------
print("--- 4. Promozione del Tipo ---")
int_val = np.array([5], dtype=np.int32)
float_val = np.array([2.5], dtype=np.float64)

int_val = int_val + 1
print(f"int_val + 1   -> ID: {id(int_val)} | dtype: {int_val.dtype}")

int_val = int_val + 1.0
print(f"int_val + 1.0 -> ID: {id(int_val)} | dtype: {int_val.dtype}\n")

# ---------------------------------------------------------
# 5. Viste (Views) e Riferimenti di Memoria
# ---------------------------------------------------------
print("--- 5. Viste e Riferimenti di Memoria ---")
vector_a = np.array([1.0, 2.0, 3.0])
vector_b = vector_a

vector_b[0] = 99.0
print(f"vector_a dopo modifica tramite vector_b:\n{vector_a}")
print(f"Condivisione memoria confermata? {np.may_share_memory(vector_a, vector_b)}\n")

# ---------------------------------------------------------
# 6. Indicizzazione con Interi e Floats
# ---------------------------------------------------------
print("--- 6. Metodi di Indicizzazione ---")
data_array = np.arange(10, 20, dtype=np.float64)

py_indices = [2, 5]
print(f"Indicizzazione con lista di int nativi {py_indices}: {data_array[py_indices]}")

np_indices = [np.int32(2), np.int64(5)]
print(f"Indicizzazione con tipi NumPy {np_indices}: {data_array[np_indices]}")

float_indices = [2.0, 5.0]
print(f"Tentativo di indicizzazione con floats {float_indices}:")
try:
    _ = data_array[float_indices]
except IndexError as e:
    print(f"  -> Eccezione catturata: {type(e).__name__} - {e}\n")

# ---------------------------------------------------------
# 7. Flusso di Controllo Vettorializzato
# ---------------------------------------------------------
print("--- 7. Flusso di Controllo Vettorializzato ---")
current_error = np.array([1e-2, 1e-4, 1e-7, 1e-3])

status = np.where(
    current_error < tolerance[0], "Convergenza raggiunta", "Non convergente"
)
print(f"Errori: {current_error}")
print(f"Stato:  {status}\n")

# ---------------------------------------------------------
# 8. Efficienza: Ciclo For vs Vettorializzazione NumPy
# ---------------------------------------------------------
print("--- 8. Benchmarking: Ciclo For vs Metodi Nativi ---")
vec_size = 5_000_000
v1 = np.random.rand(vec_size)
v2 = np.random.rand(vec_size)

start_loop = time.perf_counter()
dot_loop = 0.0
for i in range(vec_size):
    dot_loop += v1[i] * v2[i]
time_loop = time.perf_counter() - start_loop

start_np = time.perf_counter()
dot_np = np.dot(v1, v2)
time_np = time.perf_counter() - start_np

print(f"Prodotto interno (Ciclo For): {dot_loop:.4f} | Tempo: {time_loop:.4f} sec")
print(f"Prodotto interno (np.dot):    {dot_np:.4f} | Tempo: {time_np:.4f} sec")
print(f"Speedup: ~{time_loop / time_np:.1f}x a favore di NumPy\n")

# ---------------------------------------------------------
# 9. Efficienza: Preallocazione in Cicli Iterativi
# ---------------------------------------------------------
print("--- 9. Benchmarking: Preallocazione di Memoria ---")
ncycle = 10

start = time.perf_counter()
for _ in range(ncycle):
    z = v1 + v2
cpu_alloc = time.perf_counter() - start
print(f"Con allocazione implicita: {cpu_alloc:.4f} sec")

z_prealloc = np.empty(vec_size)
start = time.perf_counter()
for _ in range(ncycle):
    np.add(v1, v2, out=z_prealloc)
cpu_no_alloc = time.perf_counter() - start
print(f"Senza riallocazione (in-place): {cpu_no_alloc:.4f} sec\n")

# ---------------------------------------------------------
# 10. Prodotti Vettoriali e Operazioni Matrice-Vettore
# ---------------------------------------------------------
print("--- 10. Prodotti Vettoriali e Operazioni Matrice-Vettore ---")

v_a = np.array([1.0, 2.0, 3.0], dtype=np.float64)
v_b = np.array([4.0, 5.0, 6.0], dtype=np.float64)

# 10.1 Prodotto Interno vs Prodotto Puntuale (Hadamard)
dot_product = np.dot(v_a, v_b)  # Prodotto interno scalare
pointwise_product = v_a * v_b  # Prodotto di Hadamard (element-wise)

print("Vettori operandi:")
print(f"v_a = {v_a}")
print(f"v_b = {v_b}")
print(f"Prodotto interno (np.dot): {dot_product} | Tipo: {type(dot_product)}")
print(
    f"Prodotto puntuale (v_a * v_b): {pointwise_product} | Shape: {pointwise_product.shape}\n"
)

# 10.2 Operatore @ vs Operatore * (Matrice e Vettore)
M = np.array([[1.0, 2.0, 3.0], [4.0, 5.0, 6.0], [7.0, 8.0, 9.0]], dtype=np.float64)
v = np.array([1.0, 0.0, -1.0], dtype=np.float64)

# L'operatore @ esegue la rigorosa moltiplicazione matrice-vettore.
# Calcola il prodotto interno tra ogni riga di M e il vettore v.
matrix_vector_mult = M @ v

# L'operatore * esegue la moltiplicazione element-wise sfruttando il broadcasting.
# Il vettore v viene replicato (broadcasted) virtualmente per allinearsi alle righe di M.
matrix_vector_pointwise = M * v

print("Matrice M:\n", M)
print(f"Vettore v: {v}\n")

print("Risultato di M @ v (Moltiplicazione Matrice-Vettore):")
print(matrix_vector_mult)
print(f"Shape: {matrix_vector_mult.shape}\n")

print("Risultato di M * v (Moltiplicazione Element-wise tramite Broadcasting):")
print(matrix_vector_pointwise)
print(f"Shape: {matrix_vector_pointwise.shape}\n")

# ---------------------------------------------------------
# 11. Analisi di Stabilità Numerica e Cancellazione Catastrofica
# ---------------------------------------------------------
print("--- 11. Limiti del Floating Point ---")
print(f"Epsilon macchina (float64): {np.finfo(float).eps}\n")
import sys

sys.path.append("./src/")
from error_difference import sqrt_difference

sqrt_difference()
