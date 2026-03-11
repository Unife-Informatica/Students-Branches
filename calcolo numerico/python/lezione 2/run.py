import sys
sys.path.append('./')
from functions import *
from functions import compute_norm

def local_function(vector_x):
    print("Esecuzione di un test locale...")
    vector_x = [1.0, 2.0, 3.0]
    norm_x = compute_norm(vector_x)
    print(f"Norma L2 di vector_x: {norm_x:.4f}")

if __name__ == "__main__":
    print("Esecuzione del modulo run.py...")
    local_function([1.0, 2.0, 3.0])
