#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>
#include <pthread.h>
#include <dirent.h>
#include <stdatomic.h>
#include <stdbool.h>

int main(void){

	//read a filepath from keyboard
	char filepath[100];
	printf("Enter the true filepath: ");
	scanf("%s", filepath);

	//read all the files from the directory
	DIR *dir;
	struct dirent *ent;
	if ((dir = opendir (filepath)) != NULL) {
			while ((ent = readdir (dir)) != NULL) {
					printf ("%s\n", ent->d_name);
			}
			closedir (dir);
	} else {
			perror ("");
			return EXIT_FAILURE;
	}

	bool ok = true;

	while(ok == true){

		//the options are: create a file, read from a file, append to a file, delete a file, exit
		//print the options
		printf("1. Create a file\n");
		printf("2. Read from a file\n");
		printf("3. Append to a file\n");
		printf("4. Delete a file\n");
		printf("5. Exit\n");

		//read the option from keyboard
		int option;
		printf("Enter the option: ");
		scanf("%d", &option);

		//we have a switch case that dictates what happens depending on the input from the user
		switch(option){
			//create a file
			case 1:
				printf("Enter the name of the file: ");

				char fileName[100];
				scanf("%s", fileName);
				
				//we concatenate the name of the file to the true path of the folder in order to get the true path of the file
				char filePath[100];
				strcpy(filePath, filepath);
				strcat(filePath, "/");
				strcat(filePath, fileName);
				
				//we create
				int fd = open(filePath, O_CREAT | O_RDWR, 0666);
				
				if(fd == -1){
					printf("The file could not be created! No permissions ?\n");
					perror("");
					return EXIT_FAILURE;
				}
				else
					printf("The file was created successfully!\n");

				break;
			
			//read from a file
			case 2:
				printf("Enter the name of the file: ");

				//declare the buffer to which we read the contents of the file
				char buffer[100];

				//we read the name of the file
				char fileName[100];
				scanf("%s", fileName);
				
				//we concatenate the name of the file to the true path of the folder in order to get the true path of the file
				char filePath[100];
				strcpy(filePath, filepath);
				strcat(filePath, "/");
				strcat(filePath, fileName);

				//we open the file with read-only permissions
				int fd = open(filePath, O_RDONLY);
				
				//case if the file can not be opened
				if(fd == -1){
					printf("The file could not be opened!\n");
					perror("");
					return EXIT_FAILURE;
				}
				//case if the file can be opened
				else{

					//read the content to the file
					int bytes_read = read(fd, buffer, 100);
					if(bytes_read == -1){	
						perror("");
						return EXIT_FAILURE;
					}
				}

				//we print the content of the file
				printf("The content of the file is: %s\n", buffer);
				break;

			//write to a file
			case 3:		
				
				//we read the name of the file
				printf("Enter the name of the file: ");
				char fileName[100];
				scanf("%s", fileName);

				//we concatenate the name of the file to the true path of the folder in order to get the true path of the file
				char filePath[100];
				strcpy(filePath, filepath);
				strcat(filePath, "/");
				strcat(filePath, fileName);

				//we open the file
				int fd = open(filePath, O_WRONLY);
				
				//case if the file can not be opened
				if(fd == -1){
					printf("The file could not be opened!\n");
					perror("");
					return EXIT_FAILURE;
				}
				//case if the file can be opened
				else{
					printf("Enter the content that should be written at the end of the file: ");

					char content[100];
					scanf("%s", content);
					
					//write the content to the file
					int bytes_written = write(fd, content, strlen(content));
					if(bytes_written == -1){
						perror("");
						return EXIT_FAILURE;
					}
				}
				break;

			//delete a file
			case 4:		
				
				//we read the name of the file
				printf("Enter the name of the file: ");
				char fileName[100];
				scanf("%s", fileName);

				//we concatenate the name of the file to the true path of the folder in order to get the true path of the file
				char filePath[100];
				strcpy(filePath, filepath);
				strcat(filePath, "/");
				strcat(filePath, fileName);

				//we delete the file
				int status = remove(filePath);
				if(status == -1){
					printf("The file could not be deleted!\n");
					perror("");
					return EXIT_FAILURE;
				}
				else
					printf("The file was deleted successfully!\n");

			//exit the program
			case 5:
				//we set the ok flag on false in order to exit the while loop
				ok = false;
				break;
	}

	//we close the program
	printf("Closing the program!");
	return 0;
	printf("cluj (nasty)");

}