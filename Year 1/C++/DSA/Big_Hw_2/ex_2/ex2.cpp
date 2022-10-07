#include "bst.h"
#include "wizards.h"

void task1(BST<Wizard > node)
{
    if(node.left_son != NULL)
        task1(*node.left_son);
        
    cout << node.pinfo->getFirstName() << node.pinfo->getLastName() << node.pinfo->getScore();

    if(node.right_son != NULL)
        task1(*(node.right_son));
}

void task2(BST<Wizard> node, int house, int &sum)
{
    int *x;

    if(node.left_son != NULL)
        task1(*node.left_son);
        
    switch(house)
    {
        case 1: //Hufflepuff, <5000
            x = node.pinfo->getScore();   
            if(*node.pinfo->getScore() < 5000) 
            sum += *x;
            break;
        case 2: //Gryffindor, 5000-20000
            x = node.pinfo->getScore();   
            if(5000 < *node.pinfo->getScore() and *node.pinfo->getScore() < 20000)
            sum += *x;
            break;
        case 3: //Ravenclaw, 20000-50000
            x = node.pinfo->getScore();   
            if(20000 <= *node.pinfo->getScore() and *node.pinfo->getScore() < 50000)
            sum += *x;
            break;
        case 4: //Slytherin, >50000
            x = node.pinfo->getScore();   
            if(*node.pinfo->getScore() > 50000)
            sum += *x;
            break;
    }

    if(node.right_son != NULL)
        task1(*(node.right_son));      
}
/*
void task3(BST<Wizard> node)
{

}

void task4(BST<Wizard> node)
{

}

void task5(BST<Wizard> node)
{

}
*/
int main()
{
    BST<Wizard> hogwards;
    Wizard wizard("Cedric", "Diggory", 2000);
    hogwards.insert(wizard);
    Wizard wizard("Harry", "Potter", 10000);
    hogwards.insert(wizard);
    Wizard wizard("Hermonie", "Grander", 17000);
    hogwards.insert(wizard);
    Wizard wizard("Luna", "Lovegood", 31000);
    hogwards.insert(wizard);
    Wizard wizard("Draco", "Malfoy", 60000);
    hogwards.insert(wizard);
    Wizard wizard("Severus", "Snape", 150000);
    hogwards.insert(wizard);
    
    while(true)
    {
        int x, y;
        bool ok;

        cout << "Select which task you wish to perform (type in the number):";
        cout << endl << "1. Display all wizards (sorted);";
        cout << endl << "2. Display House Score;";
        cout << endl << "3. Display all wizards (by house);";
        cout << endl << "4. Check if you can play Quidditch;";
        cout << endl << "5. Check a score sequence;";
        
        do
        {
            cin >> x;
            ok = true;
            if(!(1 <= x and x <= 5))
            {
                cout << "Invalid input!";
                ok = false;
            }
        }while(!ok);

        switch(x)
        {
        case 1:
            //task1(hogwards);
            break;
        case 2:
            int sum = 0;
            system("CLS");
            cout << "Select the house (type in the number):";
            cout << endl << "1. Hufflepuff;";
            cout << endl << "2. Gryffindor;";
            cout << endl << "3. Ravenclaw;";
            cout << endl << "4. Slytherin;";
            
            do
            {
                cin >> y;
                ok = true;
                if(!(1 <= y and y <= 4))
                {
                    cout << "Invalid input!";
                    ok = false;
                }
            }while(!ok);
            /*
            task2(hogwards, y, sum);
            switch(y)
            {
                case 1:
                    cout << endl << " Hufflepuff ";
                    break;
                case 2:
                    cout << endl << " Gryffindor ";
                    break;
                case 3:
                    cout << endl << " Ravenclaw ";
                    break;
                case 4:
                    cout << endl << " Slytherin ";
                    break;
            }

            cout << "has " << sum << " points in total.";
            */
            break;
        /*case 3:
            task3(hogwards);
            break;
        case 4:
            task4(hogwards);
            break;
        case 5:
            task5(hogwards);
            break;*/
        }

    }

}