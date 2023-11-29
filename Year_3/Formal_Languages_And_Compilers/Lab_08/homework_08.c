#include <stdio.h>
#include <string.h>

void ex1() {
    int a[5], n, i, x, nr = 0;
    
    printf("x: ");
    scanf("%i", &x);
    printf("n: ");
    scanf("%i", &n);
    
    for (i = 0; i < n; i++)
        scanf("%i", &a[i]);
    
    for (i = 0; i < n; i++)
        if(a[i] == x)
            nr++;
    
    if(nr > 0) {
        printf("%i", x);
        printf("The number is in the array");
        printf("\n");
    }
    else {
        printf("%i", x);
        printf("The number is not in the array");
        printf("\n");
    }
}

void ex2() {
    int a[10][10], b[10][10], s[10][10], n, m, i, j;
    
    printf("n: ");
    scanf("%i", &n);
    printf("m: ");
    scanf("%i", &m);
    
    for (i = 0; i < n; i++)
        for(j = 0; j < m; j++)
            scanf("%i", &a[i][j]);
    
    for (i = 0; i < n; i++)
        for(j = 0; j < m; j++)
            scanf("%i", &b[i][j]);
            
    for (i = 0; i < n; i++)
        for(j = 0; j < m; j++)
            s[i][j] = a[i][j] + b[i][j];
      
    printf("sum: ");  
    printf("\n");
    for (i = 0; i < n; i++) {
        for(j = 0; j < m; j++) {
            printf("%i", s[i][j]);
            printf(" ");
        }
        printf("\n");
    }
}

void ex3() {
    int a[10][10], b[10][10], n, m, i, j, nr = 0;
    
    printf("n: ");
    scanf("%i", &n);
    printf("m: ");
    scanf("%i", &m);
    
    for (i = 0; i < n; i++)
        for(j = 0; j < m; j++)
            scanf("%i", &a[i][j]);
    
    for (i = 0; i < n; i++)
        for(j = 0; j < m; j++)
            scanf("%i", &b[i][j]);
            
    for (i = 0; i < n; i++)
        for(j = 0; j < m; j++)
            if(a[i][j] != b[i][j])
                nr++;
    
    if(nr == 0)
        printf("The arrays are equal");
    else
        printf("The arrays are not equal");

    printf("\n");
}

void ex4() {
    char str[50];
    printf("string: ");
    scanf("%[^\n]s", str);
    
    printf("\n");
    printf("length: ");
    printf("%ld", strlen(str));

    printf("\n");
}

void ex5() {
    int s, p;
    char ex[] = "FILS is part of UPB. I am a student at FILS. Welcome!";
    char f[] = "FILS";
    
    s = strstr(ex, f) - ex;
    p = strstr((ex + 1), f) - ex;
    
    printf("%d", s);
    printf(" ");
    printf("%d", p);

    printf("\n");
}

void ex6() {
    char str[50];
    char str1[50];
    printf("Enter a word ");
    scanf("%[^\n]s", str);
    
    strcpy(str1, str);
    strrev(str1);
    
    if(strcmp(str, str1) == 0)
        printf("The word is a palindrome");
    else
        printf("The word is not a palindrome");

    printf("\n");
}

int main()
{
    ex1();
    ex2();
    ex3();
    ex4();
    ex5();
    ex6();
    return 0;
}