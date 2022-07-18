#include <stdio.h>
#include <iostream>
#define NMAX 20

using namespace std;

template<typename T> class QueueCirc {
    private:
        T queueArray[NMAX];
        int head, tail, size;
    public:
        void enqueue(T x) {
            if (size == NMAX) {
                cout<<"Error 101 - The queue is full!\n";
                return;
            }
            queueArray[tail] = x;
            tail = (tail + 1) % NMAX;
            size++;
        }

        int getSize () {
        	return size; }
        	
        T dequeue() {
            if (isEmpty()) {
                cout<<"Error 102 - The queue is empty!\n";
                T x;
                return x;
            }
            T x = queueArray[head];
            head = (head + 1) % NMAX;
            size--;
            return x;
}
        T peek() {
            if (isEmpty()) {
                cout<<stderr, "Error 103 - The queue is empty!\n";
                T x;
                return x;
            }
            return queueArray[head];
        }

        int isEmpty() {
            return (size == 0);
        }

    QueueCirc() {
        head = tail = size = 0;
    }
};

