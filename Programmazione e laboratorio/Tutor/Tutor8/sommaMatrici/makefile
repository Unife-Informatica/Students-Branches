sommaMatrici: main.o matrici.o
	gcc -g -o sommaMatrici main.o matrici.o

main.o: main.c matrici.h
	gcc -c -g main.c

matrici.o: matrici.c matrici.h
	gcc -c -g matrici.c