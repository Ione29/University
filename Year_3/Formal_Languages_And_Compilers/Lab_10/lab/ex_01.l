%{
#include<stdio.h>
%}

%%

(https:\/\/www\.|http:\/\/www\.|https:\/\/|http:\/\/)?[a-zA-Z0-9]{2,}(\.[a-zA-Z0-9]{2,})(\.[a-zA-Z0-9]{2,})? { 
    printf("\n is a valid URL\n");
} 
. {
    printf("\n is an invalid invalid URL\n");
}

%%

int main() {
    printf("\n URL: ");
    yylex();
    return 0;
}