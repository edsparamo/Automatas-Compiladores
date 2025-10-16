%option noyywrap

%{
	#include <stdio.h>
%}
TOKEN_CORREO [A-Za-z0-9._+\-]+@uaeh\.edu\.mx
%%
{TOKEN_CORREO} {printf("TOKEN_CORREO=%s\n", yytext); }
%%

int main() 

{
	yylex();
	return 0;
}