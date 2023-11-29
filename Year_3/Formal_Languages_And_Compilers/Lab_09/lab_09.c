#include <stdio.h>

void ex1(){
    printf("Ex. 1:");
    int nr1, nr2, sum;
    int *a = &nr1, *b = &nr2, *c = &sum;
    printf("\nGive the 2 numbers you wish to add:");
    scanf("%d %d", &nr1, &nr2);
    *c = *a + *b;
    printf("The sum of the 2 numbers is: %d\n", sum);
}

void ex2(){
    printf("Ex. 2:");
    int a, b;
    printf("Give 2 numbers:");
    scanf("%d %d", &a, &b);
    printf("The sum of %d and %d is: %d\n", a, b, a + b);
    printf("The difference of %d and %d is: %d\n", a, b, a - b);
    printf("The product of %d and %d is: %d\n", a, b, a * b);
    printf("The division of %d and %d is: %d\n", a, b, a / b);
    printf("The mean of %d and %d is: %.2f\n", a, b, (a + b) / 2.0);
}

void ex3(){
    printf("Ex. 3:");
    int n;
    printf("Give a number: ");
    scanf("%d", &n);
    if(n % 2 == 0)
        printf("%d is even", n);
    else
        printf("%d is odd", n);
}

double power(int a, int b){
    double power = 1;
    if(b == 0)
        return 1;
    if(b == 1)
        return a;
    else
        for(int i = 0; i < b; i++)
            power *= a;
    return power;
}

void ex4(){
    printf("Ex. 4:");
    int base, pow, result;
    printf("Give the base: ");
    scanf("%d", &base);
    printf("Give the power: ");
    scanf("%d", &pow);
    
    printf("First call: ");
    result = power(base, pow);
    printf("%d", result);
    base = result;
    
    printf("Second call: ");
    result = power(base, pow);
    printf("%d", result);
}

void ex5(){
    printf("Ex. 5:");
    FILE *fout = fopen("text.txt", "w");
    fprintf(fout, "This is a sample text");
    fclose(fout);

    FILE *fin = fopen("text.txt", "r");
    char s[100];
    printf(fgets(s, 100, fin));
    fclose(fin);
}

int main(){
    ex1();
    ex2();
    ex3();
    ex4();
    ex5();
    
    return 0;
}