orario: main.o orario.o
	gcc -g -o orario main.o orario.o

main.o: main.c orario.h
	gcc -c -g main.c

orario.o: orario.c orario.h
	gcc -c -g orario.c