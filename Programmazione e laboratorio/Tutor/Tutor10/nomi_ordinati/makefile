registro: main.o file.o registro.o
	gcc -g -o registro main.o file.o registro.o
main.o: main.c file.h
	gcc -c -g main.c
file.o: file.c file.h
	gcc -c -g file.c
registro.o: registro.c registro.h studente.h
	gcc -c -g registro.c