%{
#include <stdio.h>
%}

%%

^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$ {
    printf("%s is a valid email address.\n", yytext);
}

.* {
    printf("%s is not a valid email address.\n", yytext);
}

%%

int main()
{
    while(true){
        yylex();
    }
    return 0;
}