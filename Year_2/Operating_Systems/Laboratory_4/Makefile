all: Ex_1

Ex_1: Ex_1.o utils.o
	gcc -Wall Ex_1.o utils.o -o Ex_1

Ex_1.o: Ex_1.c
	gcc -Wall c Ex_1.c

utils.o: utils.c
	gcc -Wall c utils.c

run: Ex_1
	./Ex_1

clean:
	rm -f *.o*~ Ex_1 