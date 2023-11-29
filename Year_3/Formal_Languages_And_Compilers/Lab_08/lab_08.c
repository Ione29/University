#include <stdio.h>
#include <stdbool.h>

void ex1(){
    printf("Ex. 1:");
    int year;
    printf("\nGive the year you wish to check: ");
    scanf("%i", &year);

    if(year % 4 == 0 && year % 4 != 0)
        printf("The year %i is a leap year.", year);
    else if(year % 400 == 0)
        printf("The year %i is a leap year.", year);
    else
        printf("The year %i is not a leap year.", year);
}

void ex2(){
    printf("\n\nEx. 2:");
    int number;
    printf("\nGive an integer number you wish to check: ");
    scanf("\n%i", &number);

    int flag = 0;

    if(number > 0)
        flag = 1;
    else if(number < 0)
        flag = -1;

    switch(flag){
        case 1:
            printf("%i is a positive number.", number);
            break;
        case -1:
            printf("%i is a negative number.", number);
            break;
        default:
            printf("The given number is 0");
    }
}

void ex3(){
    printf("\n\nEx. 3:");
    int number;
    printf("\nGive an integer number: ");
    scanf("%i", &number);

    int s = 0;
    for(int i = 0; i <= number; i++){
        if(i % 2 != 0 )
            s = s + i;
    }

    printf("The sum of odd numbers between 0 and %i is: %i", number, s);
   
}

void ex4(){
    printf("\n\nEx. 4:");
    printf("\nGive an integer number: ");
    int number, copyNumber;
    scanf("%i", &number);
    copyNumber = number;
    int digitNr = 0;

    while(copyNumber != 0){
        digitNr++;
        copyNumber = copyNumber / 10;
    }

    printf("Number %i has %i digits.", number, digitNr);
}

void ex5(){
    printf("\n\nEx. 5:");
    int numbers[] = {1, 2, 3, 4, 5};
    int sum = 0;

    for(int i = 0; i < 5; i++)
        sum = sum + numbers[i];

    printf("\nThe sum of all of the numbers in the array is %i", sum);
}

void ex6(){
    printf("\n\nEx. 6:");
    int a, b, c;
    printf("\nGive the first integer number: ");
    scanf("%i", &a);
    printf("Give the second integer number: ");
    scanf("%i", &b);
    printf("Give the third integer number: ");
    scanf("%i", &c);

    int maximum = a;
    
    if(maximum < b)
        maximum = b;
    if(maximum < c)
        maximum = c;

    printf("The maximum between all the numbers is %i", maximum);
}

int main(){

    ex1();
    ex2();
    ex3();
    ex4();
    ex5();
    ex6();

    return 0;

}