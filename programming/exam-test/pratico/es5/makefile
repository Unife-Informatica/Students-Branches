esami: listaEsami.o main.o
	gcc -o esami listaEsami.o main.o

main.o: main.c listaEsami.h
	gcc -c main.c

listaEsami.o: listaEsami.c listaEsami.h
	gcc -c listaEsami.c