#include <iostream>
using namespace std;

void reverse(int array[], int array_size)
{
    int *pointer1 = array, *pointer2 = array + array_size - 1;
    
    while (pointer1 < pointer2) {
        int aux = *pointer1;
        *pointer1 = *pointer2;
        *pointer2 = aux;
        pointer1++;
        pointer2--;
    }
}

int main()
{

    int v[6], i, j, x, *add;
    cout << "type in 6 numbers: ";

    //keyboard input
    for(int i = 0; i < 6; i++)
    {
        
        cin >> x;
        add = &x;
        v[i] = *add;
    }
    //output
    for(i = 0; i < 6; i++)
        cout << "i = " << i << " - " << v[i] << endl;
    
    /*

    //did it like this the first time

    int *p[6];

    //we have a pointer array with the addreses of the values from the first array
    for(i = 0, j = 5; i < 6; i++, j--)
        p[i] = &v[j];

    //reverse output by dereferencing the addreses of the pointer array
    cout << "reversed order" << endl;
    for(i = 0; i < 6; i++)
        cout << "i = " << i << " - " << *p[i] << endl;
    */

    int n = 6;

    reverse(v, n);

    cout << "--------" << endl;

    //reverse output
    for(i = 0; i < 6; i++)
        cout << "i = " << i << " - " << v[i] << endl;

    return 0;
}