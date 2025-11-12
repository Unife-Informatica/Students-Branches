vaccinazioni: listaCani.o main.o
	gcc -o vaccinazioni listaCani.o main.o

main.o: main.c listaCani.h
	gcc -c main.c

listaCani.o: listaCani.c listaCani.h
	gcc -c listaCani.c