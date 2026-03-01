import numpy as np
a=np.arange(5)*1.0
a[0:3]=99
print(f"{a=} {type(a)=}")
list_example = [1,"ciao",3.0]
print(f"{list_example=} {type(list_example)=}")

a=3
b=2
if a<b:
    print("ok")
a=np.ones((2,3))
a[0,0]=99
a[1,1]=99
print(f"{a=} {type(a)=}")