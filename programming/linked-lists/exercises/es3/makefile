prog: main.o register.o
	gcc -o prog main.o register.o

main.o: main.c register.h
	gcc -c main.c

register.o: register.c register.h
	gcc -c register.c