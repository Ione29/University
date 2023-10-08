#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>

int main(void)
{
    char data = ' ';
    char* myfile = "/home/ione/Desktop/myfifo.txt";
    char vowels[] = "aeiou";
    int fd = open(myfile, O_RDWR);

    if(fd == 0){
        perror("Cannot open file");
        unlink(myfile);
        exit(1);
    }

    while (data != '#'){
        while (read(fd, &data, 1) && (data != "#")){
            if(strchr(vowels, data)){
           
            fprintf(stderr, "%c", 'p');
            fprintf(stderr, "%c", data);
            fprintf(stderr, "%c", 'p');
           
           }
           else
            fprintf(stderr, "%c", data);
        }
    }

    close(fd);
    unlink(myfile);
    return 0;   
}