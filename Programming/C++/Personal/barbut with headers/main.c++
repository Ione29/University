#include <iostream>
#include <string>
#include <stdio.h>
#include <conio.h>
#include "dice.h"
using namespace std;

bool keyCheck()
{
    int val = (int)getch();

    while(true)
    {  
        if(val == 32)
            return true;
        else if(val == 27)
            return false;
    }
}

int main()
{
    char name[10];


    cout << "Barbut" << endl
    ;

    cout << "Type in the name of the first player: ";
    cin >> name;
    Player juc1(name);

    cout << "Type in the name of the second player: ";
    cin >> name;
    Player juc2(name);    
    
    do
    {
        bool ok = false;
        cout << "Press SPACE to play or ESC to leave the program."


    }while(ok);
    return 0;
}