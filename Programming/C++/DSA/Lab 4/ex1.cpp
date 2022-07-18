#include <iostream>
#include "queue2.h"
using namespace std;
int main()
{
    QueueCirc <int>queueCirc;
    int i;
    for(i = 0; i <= 20; i++)
    {   
        cout << "i = " << i;
        queueCirc.enqueue(i);
        cout << "      " << queueCirc.peek();
        cout << endl;
    }
}