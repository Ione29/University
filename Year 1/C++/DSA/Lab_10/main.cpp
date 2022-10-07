#include <iostream>
#include "heap.h"
using namespace std;

int main()
{
    Heap<int> heapArray(10);
    ///25, 17, 36, 2, 3, 100, 1, 19, 17
    heapArray.insertElement(25);
    heapArray.insertElement(17);
    heapArray.insertElement(36);int
    heapArray.insertElement(17);

    heapArray.levelDisplay();

    int array[6] = {5, 2, 3, 1, 4, 7};
    Heap<int> aux(array, 6);

    cout << endl;
    return 0;
}