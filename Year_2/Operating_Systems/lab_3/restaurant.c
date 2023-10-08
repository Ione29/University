#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>
#include <pthread.h>
#include <dirent.h>
#include <stdbool.h>
#include <stdatomic.h>

pthread_t tid[2];
bool pizzaIsReady, availableSpaces, barrierIsUp;
pthread_mutex_t lock;

void *cook(void *arg){
    while(true){
        pthread_mutex_lock(&lock);
        printf("\n Pizza is cooked");
        pizzaIsReady = true;
        pthread_mutex_unlock(&lock);
        sleep(2);
    }
}

void *waiter(void *arg){
    while(true){
        pthread_mutex_lock(&lock);
        printf("\n Pizza is served");
        pizzaIsReady = false;
        pthread_mutex_unlock(&lock);
        sleep(2);
    }
}

void *driver(void *arg){
    while(true){
        if(availableSpaces){    
            pthread_mutex_lock(&lock);
            printf("The driver is inside. The barrier is lowered.");
            availableSpaces = false;
            pthread_mutex_unlock(&lock);
        }
        else{
            pthread_mutex_lock(&lock);
            printf("The driver left. The barrier is up.");
            availableSpaces = true;
            pthread_mutex_unlock(&lock);    
        }
        sleep(4);

    }
}

void *parkingBarrier(void *arg){
    while(true){
        if(availableSpaces)
            barrierIsUp = true;
        else
            barrierIsUp = false;
    }
}

int main(){

    if(pthread_mutex_init(&lock, NULL) != 0){
        printf("\nMutex initiation has failed.\n");
        return 1;
    }

    pizzaIsReady = true;
    availableSpaces = true;
    barrierIsUp = true;

    int cook_thread = pthread_create(&(tid[0]), NULL, &cook, NULL);
    int waiter_thread = pthread_create(&(tid[1]), NULL, &waiter, NULL);

    if(cook_thread != 0){
        printf("\nCook thread could not be created: [%s]", strerror(cook_thread));
        return 0;
    }

    if(waiter_thread != 0){
        printf("\nWaiter thread could not be created: [%s]", strerror(waiter_thread));
        return 1;
    }

    

    pthread_join(tid[0], NULL);
    pthread_join(tid[1], NULL);
    pthread_mutex_destroy(&lock);

    return 0;
}