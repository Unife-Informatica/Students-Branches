print("Hello")

a = 1
a *= 2

type_a = type(a)
print(f"{a=} {type_a=}") # mi stampa a= -> comodo nel debugging e mi da il tipo della variabile

b = 2.0
a = a + b

type_a = type(a)
print(f"{a=} {type_a=}")