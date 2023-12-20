%{
#include <stdio.h>
%}

%%

[aeiouAEIOU] {
    printf("%s is a vowel.\n", yytext);
}

.|\n {
    printf("%s is not a vowel.\n", yytext);
}

%%

int main()
{
    yylex();
    return 0;
}