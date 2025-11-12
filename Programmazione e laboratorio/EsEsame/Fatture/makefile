fatture: main.o listaClienti.o
	gcc -g -o fatture main.o listaClienti.o
main.o: main.c listaClienti.h
	gcc -g -c main.c
listaClienti.o: listaClienti.c listaClienti.h
	gcc -g -c listaClienti.c