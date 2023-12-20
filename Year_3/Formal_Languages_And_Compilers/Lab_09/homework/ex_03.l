%{
#include <stdio.h>
%}
%option noyywrap

%%

"I"|"you"|"he"|"she"|"it"|"we"|"they"|"me"|"him"|"her"|"us"|"them" {
    printf("%s is a pronoun.\n", yytext);
}

"run"|"jump"|"walk"|"eat"|"sleep"|"talk"|"read"|"write"|"see"|"hear" {
    printf("%s is a verb.\n", yytext);
}

"happy"|"sad"|"big"|"small"|"fast"|"slow"|"hot"|"cold"|"bright"|"dark" {
    printf("%s is an adjective.\n", yytext);
}

"dog"|"cat"|"car"|"tree"|"book"|"city"|"computer"|"game"|"song"|"movie" {
    printf("%s is a noun.\n", yytext);
}

"in"|"on"|"at"|"from"|"with"|"under"|"above"|"between"|"through"|"against" {
    printf("%s is a preposition.\n", yytext);
}

[0-9]+ {
    printf("%s is a digit.\n", yytext);
}

.|\n {
    printf("%s is not recognized.\n", yytext);
}

%%

int main()
{
    yylex();
    return 0;
}