biblioteca: main.o libro.o biblioteca.o
	gcc -g -o biblioteca main.o libro.o biblioteca.o
main.o: main.c biblioteca.h
	gcc -g -c main.c
libro.o: libro.c libro.h
	gcc -g -c libro.c
biblioteca.o: biblioteca.c biblioteca.h libro.h
	gcc -g -c biblioteca.c