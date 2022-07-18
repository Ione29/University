#include <iostream>
#include "myStack.h"
#include "queue2.h"

template <typename T>
class StackedQueue
{
    private:
        Stack <T> s1, s2;

    public:
        void enqueue(T x)
        {
            s1.push(x);
        }

        T dequeue()
        {
            while(s1.getTopLevel() > 0)
                s2.push(s1.pop());
            
            T x = s1.pop();

            while(s1.getTopLevel() >= 0)
                s1.push(s2.pop());
            
            return x;
        }

    StackedQueue(){}
    ~StackedQueue(){}
};