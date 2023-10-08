#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>
#include <pthread.h>
#include <dirent.h>
#include <stdatomic.h>

int totalCounter = 0;

//_Atomic Counter wordCounter;

void *wordCounterThread(void *vargp, char *filename){

    //we are searching for the word "yes"
    
    int fd = open(filename, O_RDONLY);
    char data = ' ';

    if (fd == 0){
        printf("File cannot be opened!" );
        return 0;
    }
    else{   //we start numbering the appearances of yes
        while (read(fd, &data, 1)){
            if (data == 'y'){
                if (read(fd, &data, 1)){
                    if (data == 'e'){
                        if (read(fd, &data, 1)){
                            if (data == 's'){
                                totalCounter++;
                            }
                        }
                    }
                }
            }
        }
    }
}

int main(void){
    struct dirent *files;
    DIR *dir = opendir("/home/ione/Desktop/test/");
    
    if (dir == NULL){
      printf("Directory cannot be opened!" );
      return 0;
    }

    //as long as we find files in the directory, we create a thread for each one

    while ((files = readdir(dir)) != NULL)
        if (files->d_type){ //we create a thread and we pass the filename as argument
            pthread_t id;
            pthread_create(&id, NULL, wordCounterThread, files->d_name);
        }        

    printf("Total number of appearances: %d", totalCounter);

    closedir(dir);
    return 0;
}