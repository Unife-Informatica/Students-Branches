import numpy as np
alpha = 1235 #NUMERO IN BASE 10
BETA = 2 #BASE IN CUI CONVERTIRE
T=15
cont=0
s="01" #SEGNI DISPONIBILI IN BASE 2 [0,1]

d = ''
alpha = BETA**(T+1)-alpha
q = alpha

while(q!=0):
    r=q%BETA
    q=q//BETA
    d=s[r]+d
    cont+=1

print(d)


