#include <stdio.h>
#include <iostream>
#define NMAX 100

using namespace std;
template<typename T> class Queue {
    private:
        T queueArray[NMAX];
        int head, tail;
    public:

        void enqueue(T x) {
            if (tail == NMAX) { //we check if the queue is full
                cout<<"Error 101 - The queue is full!\n";
                return;
            }
            queueArray[tail] = x; //we add the element at the end of the queue
            tail++; //we shift the tail to the right
        }

        T dequeue() {
            if (isEmpty()) { //we check if the queue is empty
                cout<<"Error 102 - The queue is empty!\n";
                T x;
                return x;
            }
            T x = queueArray[head]; //we return the element situated at the head
            head++;                          //we shift the head to the right
            return x;   }

        T peek() {
            if (isEmpty()) {//we check if the queue is empty
                cout<<"Error 103 - The queue is empty!\n";
                T x;
                return x;
            }
            return queueArray[head]; //we return the element situated at the head
        }

        int isEmpty() {
            return (head == tail); //if head and tail are equal, the queue is empty
        }

    Queue() {
        head = tail = 0; // the queue is empty at the beginning
    }
};
