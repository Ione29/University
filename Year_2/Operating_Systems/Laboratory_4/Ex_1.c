#include <stdlib.h>
#include <stdio.h>
#include "utils.h"

#define N 9

int main(void){
    int i, v[] = {10, -20, 30, 9, 7, 8, 11, 5, -2, 100};

    printf("Values: ");
    for(int i = 0; i <= N; ++i) printf("%d ", v[i]);

    printf("\n");

    printf("Values greater than %d: %d\n", MIN_VAL, vectGt(v, N, MIN_VAL));
    printf("Values less than %d: %d\n", MAX_VAL, vectLt(v, N, MAX_VAL));

    return 0;
}