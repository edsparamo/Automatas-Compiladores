%option noyywrap
%{
	#include<stdio.h>
%}
TOKEN_ID [a-zA-Z][a-zA-Z0-9]*
TOKEN_NUMERO [0-9]+
%%
{TOKEN_ID} { printf("TOKEN_ID=%s\n", yytext); }
{TOKEN_NUMERO} { printf("TOKEN_NUMERO=%s\n", yytext); }

%%
int main()
{
	yylex();
	return 0;
}