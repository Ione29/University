#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>

int main(){
    char *myfifo = "/home/ione/Desktop/myfifo.txt";

    int fd = open(myfifo, O_RDWR | O_CREAT, S_IRUSR | S_IWUSR);

    if(fd == 0){
        perror("Cannot open \"myfifo.txt\"");
        unlink(myfifo);
        exit(1);
    }

    int playerNr = 0;
    char data[50] = " ";
    char text[50] = "Sternocleidomastoidian"; //first player starts with this string
    
    for(playerNr = 1; playerNr < 11; playerNr++){
        //distort the string from the second onward
        if(playerNr != 1){
            int mode = rand() % 3 + 1;
            int pos; char letter;
            
            switch (mode){
            case 1: //replace a letter with a random letter
                pos = rand() % strlen(text);
                letter = rand() % 26 + 65;
                text[pos] = letter;
                break;
            case 2: //delete a letter
                pos = rand() % strlen(text);
                for(int i = pos; i < strlen(text); i++)
                    text[i] = text[i+1];
            case 3: //add a letter
                pos = rand() % strlen(text);
                letter = rand() % 26 + 65;
                for(int i = strlen(text); i > pos; i--)
                    text[i] = text[i-1];
                text[pos] = letter;
                break;
            default:
                pos = rand() % strlen(text);
                for(int i = pos; i < strlen(text); i++)
                    text[i] = text[i+1];
                break;
            }
        }
        
        //printf("Control 1: %s | ", text);
    
        //write data to pipe myfifo.txt
        int nb = write(fd, &text, sizeof(text));
        if(nb == 0)
            fprintf(stderr, "Write error\n");

        //display data in terminal
        fprintf(stderr, "\nPlayer %d says: %s", playerNr, text);

    }

    unlink(myfifo);
    return 0; 

}