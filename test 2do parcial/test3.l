%option noyywrap

%{
	#include <stdio.h>
%}
TOKEN_VARIABLE [a-zA-Z][a-zA-Z0-9_]*
%%
{TOKEN_VARIABLE} {printf("TOKEN_VARIABLE=%s\n", yytext); }
%%

int main() 

{
	yylex();
	return 0;
}