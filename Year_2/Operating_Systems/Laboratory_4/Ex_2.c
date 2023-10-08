#include <stdio.h>
#include <string.h>

int areCoprime(int a, int b){
    while(b != a){
        int temp = b;
        b = a % b;
        a = temp;
    }

    return a == 1;
}

int multiplicativeInverse(int e, int phi){
    int d = 0;
    int x1 = 0, x2 = 0, y1 = 1, tempPhi = phi;

    while(e > 0){
        int temp1 = tempPhi / e;
        int temp2 = tempPhi - temp1 * e;
        tempPhi = e;
        e = temp2;

        int x = x2 - temp1 * x1;
        int y = d - temp1 * y1;

        x2 = x1;
        x1 = x;
        d = y1;
        y1 = y;
    }

    if(tempPhi == 1) return d + phi;
}

void generateRSAKeys(int x, int y, int *n, int *e, int *d){
    n = x * y;
    int phi = (x - 1)*(y - 1);

    do{
        *e = rand() % phi + 2;
    }while (!areCoprime(*e, phi));

    *d = multiplicativeInverse(*e, phi);
}

void encryptRSA(char* messageToEncrypt, int* cipher, int l, int e, int n){
    for(int i = 0; i < l; i++){
        cipher[i] = 1;
        for(int j = 0; j < e; j++) cipher[i] = (cipher[i] * messageToEncrypt[i]) % n;
    }
}

void decryptRSA(int* cipher, int l, int d, int n, char* decryptedMessage){
    for(int i = 0; i < l; i++){
        decryptedMessage[i] = 1;
        for(int j = 0; j < d; j++) decryptedMessage[i] = (decryptedMessage[i] * cipher[i]) % n;
    }
}

int main(){
    int x, y, n, e, d;
    printf("Enter x and y: ");
    scanf("%d", x);
    scanf("%d", y);

    generateRSAKeys(x, y, &n, &e, &d);

    char messageToEncrypt[100];
    printf("Enter the message to encrypt: ");
    scanf("%s", messageToEncrypt);

    int lengthOfMessage = strlen(messageToEncrypt);
    int cipher[lengthOfMessage];
    encryptRSA(messageToEncrypt, cipher, lengthOfMessage, e, n);

    char decryptedMessage[100];
    decryptRSA(cipher, lengthOfMessage, d, n, decryptedMessage);

    printf("Decrypted message: %s\n", decryptedMessage);
}