def compute_norm(v, p=2, verbose=True):
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


def compute_range_and_mean(v):
    """
    Calcola minimo, massimo e media di una lista.
    """
    if not v:
        return None, None, None

    min_val = min(v)
    max_val = max(v)
    mean_val = sum(v) / len(v)
