%{
#include <stdio.h>
%}

%%

^[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}$ {
    printf("%s is a valid date.\n", yytext);
}

.* {
    printf("%s is not a valid date.\n", yytext);
}./

%%

int main()
{
    printf("\n Give a date: ");
    yylex();
    return 0;
}