%option noyywrap

%{
	#include <stdio.h>
%}
TOKEN_CURP [A-Z]{4}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1|2][0-9]|3[0|1])(H|M|X)[A-Z]{2}[A-Z0-9]{4,5}
%%
{TOKEN_CURP} {printf("TOKEN_CURP=%s\n", yytext); }
%%

int main() 

{
	yylex();
	return 0;
}