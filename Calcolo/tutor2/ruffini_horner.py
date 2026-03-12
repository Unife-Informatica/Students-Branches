def naive_ruffini_horner(p, a):
    """
    Valuta il polinomio p nel punto a utilizzando il metodo di Ruffini-Horner.
    Il polinomio è rappresentato come un vettore contenente i suoi coefficienti
    in ordine decrescente (i.e., da quello di grado più alto).
    """
    n = len(p)  # Grado del polinomio + 1
    q = [p[0]]
    for i in range(1,n):
        q.append(q[i-1]*a+p[i])
    r = q.pop()
    return r, q