#include <iostream>
using namespace std;
#define NMAX 50

template<typename T>
class Stack {
    private:
        T stackArray[NMAX]; 
        int topLevel; 
    public:
        void push(T x) {
            if (topLevel >= NMAX-1) 
			{
                cout<<"The stack is full: we have already NMAX elements!\n";
                return;
            }
            stackArray[++topLevel] = x;
        }

        int isEmpty()
        {
            return (topLevel < 0);
        }

        T pop()
        {
            if (isEmpty())
            {
                cout<<"The stack is empty! \n";
                T x;
                return x;
            }
            return stackArray[topLevel--]; 
        }

        T peek()
        {
            if (isEmpty())
            {
                cout<<"The stack is empty! \n";
                T x;
                return x;
        	}
            return stackArray[topLevel];
        }

        int getTopLevel()
        {
            return topLevel;
        }
        Stack()
        {
            topLevel = -1;
        }

        ~Stack()
        {
        }
};