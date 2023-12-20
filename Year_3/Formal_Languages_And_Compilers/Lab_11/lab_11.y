%{
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

extern int yylex();
extern int yyparse();
extern FILE* yyin;

void yyerror(const char* s);
%}

%union {
    int ival;
    float fval;
}

%token<ival> T_INT
%token T_PLUS T_MINUS T_MULTIPLY T_DIVIDE T_POWER
%token T_NEWLINE
%token L_PAREN R_PAREN

%type<ival> expression

%%

%start calculation;

calculation:
    | calculation line
;

line: T_NEWLINE
    | expression T_NEWLINE {printf("\tResults: %i\n",$1);}
;

expression: T_INT { $$ = $1; }
    /* Add rules for other operations here */

%%

int main()
{
    yyparse();
    return 0;
}

void yyerror(const char* s) {
    fprintf(stderr, "Error: %s\n", s);
}