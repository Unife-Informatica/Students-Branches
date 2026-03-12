import numpy as np


def sqrt_difference():
    x_values = np.array([1e14, 1e15, 1e16, 1e17], dtype=np.float64)

    print(
        f"{'Input (x)':<12} | {'Denominatore':<20} | {'Expected (stabile)'} | {'Computed f(x) (instabile)':<22}"
    )
    print("-" * 85)

    for x in x_values:
        denom = np.sqrt(x + 1.0) - np.sqrt(x)

        with np.errstate(divide="ignore", invalid="ignore"):
            result = 1.0 / denom

        expected = np.sqrt(x + 1.0) + np.sqrt(x)
        print(f"{x:<12.0e} | {denom:<20.15e} | {expected:<18.15e} | {result:<18.15e}")
