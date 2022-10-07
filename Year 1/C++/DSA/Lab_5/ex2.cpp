#include <iostream>
using namespace std;

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

    int *p[6];

    //we have a pointer array with the addreses of the values from the first array
    for(i = 0, j = 5; i < 6; i++, j--)
        p[i] = &v[j];

    //reverse output
    cout << "reversed order" << endl;
    for(i = 0; i < 6; i++)
        cout << "i = " << i << " - " << *p[i] << endl;

    return 0;
}
