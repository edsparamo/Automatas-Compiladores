%option noyywrap

%{
	#include <stdio.h>
%}
TOKEN_NUMERO [0-9]+ 
%%
{TOKEN_NUMERO} {printf("TOKEN_NUMERO=%s\n", yytext); }
%%

int main() 

{
	yylex();
	return 0;
}