#include <iostream>
using namespace std;
int main()
{

    int v[6];

    cout << "type in 6 numbers: ";

    for(int i = 0; i < 6; i++)
    {
        int x, *add;
        cin >> x;
        add = &x;
        v[i] = *add;
    }

    for(int i = 0; i < 6; i++)
        cout << "i = " << i << " - " << v[i] << endl;

    return 0;
}