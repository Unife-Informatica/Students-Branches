giornate: listaGiornate.o main.o
	gcc -o giornate listaGiornate.o main.o

main.o: main.c listaGiornate.h
	gcc -c main.c

listaGiornate.o: listaGiornate.c listaGiornate.h
	gcc -c listaGiornate.c