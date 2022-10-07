#include <iostream>
using namespace std;


class Wizard{
    private:
        char *firstName, *lastName, *house;
        int *score;

    public:
        Wizard(char *p_lastName, char *p_firstName, int p_score)
        {
            firstName = p_firstName;
            lastName = p_lastName;
            score = &p_score;

            if(0 <= *score and *score < 5000)
                house = "Hufflepuff";
            else if(5000 <= *score and *score < 20000)
                house = "Gryffindor";
            else if(20000 <= *score and *score < 50000)
                house = "Ravenclaw";
            else
                house = "Slytherin";
        }

        char* getFirstName()
        {
            return firstName;
        }
        
        char* getLastName()
        {
            return lastName;
        }

        char* getHouse()
        {
            return house;
        }

        int* getScore()
        {
            return score;
        }

};