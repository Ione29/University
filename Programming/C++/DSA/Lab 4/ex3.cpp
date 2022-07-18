#include <iostream>
#include "StackedQueue.h"
using namespace std;
int main()
{
    StackedQueue <int> stackedQueue;

    stackedQueue.enqueue(5);
    stackedQueue.enqueue(2);
    stackedQueue.enqueue(3);
    cout << stackedQueue.dequeue();
    cout << stackedQueue.dequeue();
}