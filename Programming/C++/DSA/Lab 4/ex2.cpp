#include <iostream>
#include "QueuedStack.h"
using namespace std;
int main()
{
    QueuedStack <int>queuedStack;
    int i;
    for(i = 0; i <= 20; i++)
    {   
        cout << "i = " << i;
        queuedStack.push(i);
        cout << "      " << queuedStack.pop();
        cout << endl;
    }
}