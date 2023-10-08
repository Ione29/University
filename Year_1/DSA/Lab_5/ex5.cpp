#include <iostream>
#include <cstring>
using namespace std;

char *commaReplacer(char *p)
{
    for(int i = 0; i < strlen(p); i++)
        if(*(p + i) == ',')
            *(p + i) = ' ';

    return p;
}

int main()
{
    char text[20], dep[5];
    cin.get(text, 20);

    char* p;
    p = text;

    cout << commaReplacer(p);

    return 0;

}