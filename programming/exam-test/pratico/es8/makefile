medagliere: listaNazioni.o main.o
	gcc -o medagliere listaNazioni.o main.o

main.o: main.c listaNazioni.h
	gcc -c main.c

listaNazioni.o: listaNazioni.c listaNazioni.h
	gcc -c listaNazioni.c