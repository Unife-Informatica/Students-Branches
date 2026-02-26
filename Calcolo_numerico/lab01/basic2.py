import numpy as np

a = 0.0
print(f"{a} {type(a)=}")

a = np.arange(5)*1.0 # crea un'array di dim = 5 crescente

a = a * 3
a[2] = 10
print(f"{a} {type(a)=}")

b = np.zeros(2) # crea un'array di dim = 2 di zeri
print(f"{b} {type(b)=}")

c = np.ones(2) # crea un'array di dim = 3 di uni
print(f"{c} {type(c)=}")

d = np.ones((2,3)) #crea una matrice di uni
print(f"{d} {type(d)=}")