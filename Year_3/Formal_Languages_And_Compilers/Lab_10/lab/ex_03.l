%{ 
#include<stdio.h> 
#include<string.h> 
  
char r [] = "magical";
char word [] = "lantern"; 
%} 
  
%% 

[a-zA-Z]+ { 
    if(strcmp(yytext, word)==0)
        fprintf(yyout, "%s", r); 
    else
        fprintf(yyout, "%s", yytext); } 
    . {
fprintf(yyout, "%s", yytext); 
}

%% 
  
int main() { 
    extern FILE *yyin, *yyout; 
    
    yyin=fopen("test.txt", "r"); 
    yyout=fopen("output_03.txt", "w"); 
    
    yylex(); 
    return 0;
}