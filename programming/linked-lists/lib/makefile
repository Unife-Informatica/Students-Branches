prog: main.o linked-list.o
	gcc -o prog main.o linked-list.o

main.o: main.c linked-list.h
	gcc -c main.c

linked-list.o: linked-list.c linked-list.h
	gcc -c linked-list.c

clean:
	rm prog main.o linked-list.o
