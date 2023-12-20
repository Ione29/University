%{
#include<stdio.h>
int nr = 1;
%}

line .*\n     
  
%% 
{line} { 
    printf("%10d %s", nr++, yytext); 
}  
  
%% 
  
int yywrap() {
}  
  
int main(int argc, char*argv[]) 
{ 
    extern FILE *yyin; 
    
    yyin = fopen("output_ex_02.txt","r");  

    yylex();  
    
    return 0; 
}