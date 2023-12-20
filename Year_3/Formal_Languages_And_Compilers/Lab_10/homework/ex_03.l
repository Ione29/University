{
#include <stdio.h>
%}

%%

"/*"([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*"*"+"/" {
    /* matches C-style comments*/
}

"//"[^\\n]* {
    /* matches C++-style comments*/
}

.|\n {
    /* This rule matches any other character and prints it to the output. */
    printf("%s", yytext);
}

%%

int main()
{
    yylex();
    return 0;
}