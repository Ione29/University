#include <iostream>
#include <cstring>
using namespace std;

char *getDep(char *p)
{
    int i = 0;

    while(*(p + i) != ',')
        i++;

    return p + i + 1;
}

int main()
{
    char text[20], dep[5];
    cin.get(text, 20);

    char* p;
    p = text;

    cout <<"The department is:" << getDep(p) << endl;

    return 0;

}