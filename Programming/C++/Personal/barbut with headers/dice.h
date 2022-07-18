#ifndef DICE_H
#define DICE_H

#include <iostream>
#include <cstring>

class Player
{
    private:
        int dice, score, sum;
        char name[10];
    public:
        Player(char *v_name)
        {
            strcpy(name, v_name);
            score = 0;
        }

        char *getName()
        {
            return name;
        }

        int rollDice()
        {
            dice = rand() % 6 + 1;
            std::cout << dice << " | ";
            sum += dice;
            dice = rand() % 6 + 1;
            std::cout << dice;
            sum += dice;
            
            return sum;
        }

};

#endif /* DICE_H */