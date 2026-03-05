"""
Fondamenti di Python: Sintassi, Flusso di Controllo e Gestione
della Memoria
"""

# # ---------------------------------------------------------
# # 1. Definizione di Variabili Float, Integer e String
# # ---------------------------------------------------------
# print("--- Inizializzazione Variabili---")
max_iterations = 500              # Intero
tolerance = 1e-6                  # Float (notazione scientifica)
# step_size = 0.05                  # Float
# algorithm_name = "Discesa del Gradiente" # Stringa

# # ---------------------------------------------------------
# # 2. Opzioni di Stampa con le f-strings
# # ---------------------------------------------------------
# print(f"Algoritmo inizializzato: {algorithm_name} {type(algorithm_name)=}\n")
# # Utilizzo di \n per limitare la lunghezza dell'output su console
# print(f"Iterazioni massime: {max_iterations=} {type(max_iterations)=}\n"
#       f"Tolleranza: {tolerance}")
# print(f"Step size formattato: {step_size:.3f} {type(step_size)=} \n")

# # ---------------------------------------------------------
# # 3. Operazioni di Base, Assegnazione Aumentata e Promozione
# # ---------------------------------------------------------
# a = 18.0  # Float
# b = 3.0   # Float

# print(f"ID of a: {id(a)} | ID of b: {id(b)}\n")

# print(f"Raddoppiamo a con l'instruzione a =*2.0 \n")
# a += 2.0  # Modifica in loco di a, ma a è un nuovo oggetto
# print(f"a dopo raddoppio: {a=}\n")
# print(f"ID of a after modification: {id(a)}\n")

# print(f"Operazioni di base tra {a=:.2f} e {b=:.2e}:\n")
# addition = a + b
# print(f"Addition: {addition:.2f}")
# subtraction = a - b
# print(f"Subtraction: {subtraction:.2f}")
# multiplication = a * b
# print(f"Multiplication: {multiplication:.2f}")
# division = a / b           # Produce sempre un float
# print(f"Division: {division:.2f}")
# floor_division = a // b    # Tronca la parte decimale
# print(f"Floor Division: {floor_division:.2f} {type(floor_division)=}")
# modulo = a % b             # Resto

# check = floor_division * b + modulo
# print(f"Verifica: {floor_division:.2f} * {b:.2f} + {modulo:.2f} = {check:.2f}\n")

# print(f"Modulo: {modulo:.2f} {type(modulo)=}")
# power = a ** b             # Esponenziazione (a elevato alla b)
# print(f"Power: {power:.2f}\n")

# print(f"---- integer ----")
# # ---------------------------------------------------------
# # 4. Operazioni di Base, Assegnazione Aumentata e Promozione
# # ---------------------------------------------------------
# a = 20  # integer
# b = 3   # integer
# print(f"{a=}, {b=}")
# print(f"ID of a: {id(a)} | ID of b: {id(b)} {type(a)=}\n")
# a *= 2  # Modifica in loco di a, ma a è un nuovo oggetto
# print(f"ID of a after modification: {id(a)} {type(a)=}\n")
# print(f"Aggiungiamo 1 a a con l'instruzione a += 1.0 \n")
# a += 1.0
# print(f"Identificatore di int_val: {id(a)} {a=} {type(a)=}\n")


# a = 20
# b = 3
# print(f"Operazioni di base tra {a=:d} e {b=:05d}:\n")
# addition = a + b
# print(f"Addition: {addition:d} {type(addition)=}")
# subtraction = a - b
# print(f"Subtraction: {subtraction:.2f} {type(subtraction)=}")
# multiplication = a * b
# print(f"Multiplication: {multiplication:.2f} {type(multiplication)=}")
# division = a / b           # Produce sempre un float
# print(f"Division: {division:.2f} {type(division)=}")
# integer_division = a // b    # Divisione intera, tronca la parte decimale
# print(f"Integer Division: {integer_division:.2f} {type(integer_division)=}")
# modulo = a % b             # Resto
# print(f"Modulo: {modulo:.2f} {type(modulo)=}")
# power = a ** b             # Esponenziazione (a elevato alla b)
# print(f"Power: {power:.2f} {type(power)=}\n")


# print("--- Promozione del Tipo nelle Operazioni Miste ---")
# # Nelle operazioni tra intero e float, Python converte (upcasting)
# # l'intero in float per prevenire la perdita di precisione.
# int_val = 5
# float_val = 2
# print(f"{int_val=} è di tipo {type(int_val)}, {float_val=} è di tipo {type(float_val)}\n")

# mixed_result = int_val * float_val
# print(f"Risultato di int_val * float_val: {mixed_result} | Tipo: {type(mixed_result)}\n")

# # ---------------------------------------------------------
# # 4. Liste e Tuple
# # ---------------------------------------------------------
# # Le liste sono mutabili e possono contenere tipi eterogenei.
# mixed_list = [10, 3.14159, "convergenza", True]



# Efficienza: le liste standard contengono tipi misti e agiscono
# come array di puntatori a oggetti sparsi. La mancanza di 
# località della cache le rende inefficienti per il calcolo 
# scientifico e l'algebra lineare numerica.

vector_x = [0.0, 1.5, 3.0, 4.5]
vector_x.append(6.0)       # Aggiunge alla fine
print(f"Lista modificata: {vector_x}\n")    
vector_x[0] = -1.0         # Modifica il primo elemento
print(f"Lista modificata: {vector_x}\n")    


# Le tuple sono immutabili, utili per dimensioni fisse.
grid_dimensions = (100, 100, 50)
print(f"{grid_dimensions[0]=}\n")


# ---------------------------------------------------------
# 5. Assegnazione di Variabili come Riferimenti (Puntatori)
# ---------------------------------------------------------
# Assegnare una lista esistente a una nuova variabile crea 
# un puntatore al medesimo indirizzo di memoria.

vector_a = [1.0, 2.0, 3.0]
vector_b = vector_a        # Punta alla stessa lista di vector_a
vector_b[0]= 99 
print(f" vector_a: {vector_a} | ID: {id(vector_a)}")
print(f" vector_b: {vector_b} | ID: {id(vector_b)}\n")

vector_c = vector_b.copy()
vector_c[1] = 99.
print(f"--- Riferimenti di Memoria ---")
print(f"vector_a: {vector_a} | ID: {id(vector_a)}")
print(f"vector_b: {vector_b} | ID: {id(vector_b)}\n")
print(f"vector_a e vector_b sono l'esatto stesso oggetto\n")
print(f"{vector_b=}{id(vector_b)=}\n")
print(f"{vector_c=}{id(vector_c)=}")


# Modificare tramite vector_b altera intrinsecamente vector_a
vector_b[0] = 99.0

print("--- Riferimenti di Memoria ---")
print(f"vector_a originale dopo modifica di vector_b:\n{vector_a}")
print(f"vector_a e vector_b sono l'esatto stesso oggetto\n"
      f"in memoria? {vector_a is vector_b}\n")

# Per una copia indipendente: vector_c = vector_a.copy()

# ---------------------------------------------------------
# 6. If, Elif, Else
# ---------------------------------------------------------
current_error = 1e-4

print("--- Flusso di Controllo ---")
if (current_error != tolerance):
    print("Convergenza raggiunta.")
elif current_error == tolerance:
    print("L'errore è esattamente sulla soglia\n"
          "di tolleranza.")
else:
    print("L'algoritmo non è ancora convergente.")
    print("curent_error è maggiore di tolerance\n")

# ---------------------------------------------------------
# 7. Ciclo For
# ---------------------------------------------------------
sum_elements = 0.0
vector_x[-1] = 99
for index, val in enumerate(vector_x):
    print(f"Valore corrente: {index} {val}")
    sum_elements += val
print(f"Somma elementi di vector_x: {sum_elements}")


for i in range(3): 
    print(f"Elaborazione dell'indice: {i}")


# ---------------------------------------------------------
# 8. Ciclo While
# ---------------------------------------------------------
current_value = 1.0
iteration = 0

while current_value > 0.1 and iteration < max_iterations:
    current_value /= 2.0
    iteration += 1

print(f"Ciclo while terminato all'iterazione {iteration}\n"
      f"con valore {current_value}\n")


# ---------------------------------------------------------
# 9. Definizione di Funzioni
# ---------------------------------------------------------
def compute_norm(v, p=2, verbose=False):
    """
    Calcola la p-norma semplificata di un vettore.
    """
    norm_val = 0.0
    for element in v:
        norm_val += abs(element) ** p
    norm_val = norm_val ** (1.0 / p)
    
    if verbose:
        print(f"Calcolata norma-{p}: {norm_val:.4f}")
        
    return norm_val

print("--- Funzioni ---")
l2_norm = compute_norm(vector_x)
l1_norm = compute_norm(vector_x, 1)
l1_norm = compute_norm(vector_x, verbose=True, p=1)
l1_norm = compute_norm(vector_x, p=4, verbose=True)
_ = compute_norm(vector_x, p=float('inf'), verbose=False)


# ---------------------------------------------------------
# 10. Funzioni con Output Multipli
# ---------------------------------------------------------
def compute_range_and_mean(v):
    """
    Calcola minimo, massimo e media di una lista.
    """
    if not v:
        return None, None, None
        
    min_val = min(v)
    max_val = max(v)
    mean_val = sum(v) / len(v)
    
    return min_val, max_val, mean_val
output = compute_range_and_mean([1.5, 2.5, 3.5, 4.5])

print(f"Output della funzione compute_range_and_mean: {type(output)=}")
print(f"{type(output[0])=} \n")
v_min, v_max, v_mean = output

print(f"\nMinimo: {v_min}\nMassimo: {v_max}\nMedia: {v_mean}")

# ---------------------------------------------------------
# 11. Gestione degli Errori (Try / Except)
# ---------------------------------------------------------
print("\n--- Gestione degli Errori ---")
# Le tuple sono immutabili, la riassegnazione solleva un TypeError.

try:
    print(f"Tentativo di modifica del primo elemento\n"
          f"della tupla grid_dimensions: {grid_dimensions}")
    grid_dimensions[0] = 200
except TypeError as e:
    print(f"Intercettata un'eccezione: {e}\n"
          "Spiegazione: Le tuple non possono essere\n"
          "mutate dopo l'inizializzazione.")