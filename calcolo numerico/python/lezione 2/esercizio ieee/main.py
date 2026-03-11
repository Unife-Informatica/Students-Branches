n = input("Inserire un numero").split(".")

tmp = "0." + n[1]

print(float(tmp))

def int2bin(n):
    resti = []
    while n >= 1:
        resto = n % 2
        resti.append(resto)
        n = n // 2
    new_resti = []
    for i in range(len(resti)):
        new_resti.append(resti[len(resti) - i - 1])
    return new_resti
