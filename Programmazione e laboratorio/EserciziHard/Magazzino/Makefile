magazzino: main.o gestione_file.o gestione_inventario.o utils.o
	gcc -g -o magazzino main.o gestione_file.o gestione_inventario.o utils.o

main.o: main.c gestione_file.h utils.h
	gcc -c -g main.c

gestione_file.o: gestione_file.c gestione_file.h gestione_inventario.h
	gcc -c -g gestione_file.c gestione_inventario.c

gestione_inventario.o: gestione_inventario.c gestione_inventario.h
	gcc -c -g gestione_inventario.c

utils.o: utils.c utils.h
	gcc -c -g utils.c
