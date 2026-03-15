import numpy as np

coeffs = [3, -2, 0, 3, -6]
alpha = 2

# Step 1: Initialize
quotient = [coeffs[0]]  # Start with leading coefficient

# Step 2: Synthetic division
for c in coeffs[1:]:
    next_val = quotient[-1] * alpha + c
    quotient.append(next_val)

# Step 3: Separate remainder from quotient
remainder = quotient.pop()  # Last number is remainder
print("Quotient coefficients:", quotient)
print("Remainder:", remainder)

# Verification using numpy.polyval
print("Check with numpy.polyval:", np.polyval(coeffs, alpha))