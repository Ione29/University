#include <iostream>
#include "queue2.h"
using namespace std;
#define NMAX 20

template <typename T>
class QueuedStack
{
    private:
        QueueCirc <T> q1, q2;

    public:
        void push(T x)
        {
            if(q1.getSize == NMAX){
                cout << "Error - The queue is full!" << endl;
                T x;
                return x;
            }
            q1.enqueue(x);
        }

        T pop()
        {
            if(q1.isEmpty)
            {
                cout << "Error - The stack is empty!" << endl;
                T x;
                return x;
            }   
            
            while(q1.getSize > 1)
                q2.enqueue(q1.dequeue);   

            T x = q1.dequeue;
            
            while(q2.getSize)
                q1.enqueue(q2.dequeue);

            return x;
        }

        int isEmpty()
        {
            return (q1.isEmpty);
        }
    QueuedStack()
    {
        head = tail = size = 0;
    }
};