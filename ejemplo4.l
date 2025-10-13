%option noyywrap

%{
	#include <stdio.h>
	#include "ejemplo4.h"
%}

%%

ID {return TOKEN_ID}
NUMERO {return TOKEN_NUMERO}

%%

int main() 

{
	int token;
	while(1) {
		token = yylex();
		if( token == TOKEN_ID )
			printf("TOKEN_ID=%s\n", yytext);
		if( token == TOKEN_NUMERO )
			printf("TOKEN_NUMERO=%s\n", yytext);
		if( token == 0)
			break; 
	}
	return 0;
}
