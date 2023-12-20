%{
#include <stdio.h>
%}

%%

"I"|"you"|"he"|"she"|"it"|"we"|"they"|"me"|"him"|"her"|"us"|"them" {
    printf("%s is a pronoun.\n", yytext);
}

.|\n {
    printf("%s is not a pronoun.\n", yytext);
}

%%

int main()
{
    yylex();
    return 0;
}