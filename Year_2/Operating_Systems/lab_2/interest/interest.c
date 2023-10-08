#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>
#include <pthread.h>
#include <dirent.h>
#include <stdatomic.h>

int initialSum;

void *interestComputer(void *years){
    int months = (int *) years;
    months *= 12;
    int sum = initialSum;

    for(int i = 1; i < months; i++)
        sum = sum + sum*0.007;

    printf("The deposit, with interest, after %d will be: %d", (int *)years, sum);
}

int main(){
    char sum[16];
    printf("Give the amount of money you wihs to compute for: ");
    fgets(sum, sizeof(sum), stdin);
}