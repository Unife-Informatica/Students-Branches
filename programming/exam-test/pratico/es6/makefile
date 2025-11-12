greenpass: listaPersone.o main.o
	gcc -o greenpass listaPersone.o main.o

main.o: main.c listaPersone.h
	gcc -c main.c

listaPersone.o: listaPersone.c listaPersone.h
	gcc -c listaPersone.c