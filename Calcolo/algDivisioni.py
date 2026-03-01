ALPHA = 133 #NUMERO IN BASE 10
BETA = 2 #BASE IN CUI CONVERTIRE

s="01" #SEGNI DISPONIBILI IN BASE 2 [0,1]

q = ALPHA
d = ''

while(q!=0):
    r=q%BETA
    q=q//BETA
    d=s[r]+d
print(d)

