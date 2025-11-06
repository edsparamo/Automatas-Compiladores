%option noyywrap
%{
    #include <stdio.h>
    int lineas = 1;
    int palabras = 0;
    int caracteres = 0;
    int Palabra1 = 0;
    int Palabra2 = 0;
    int Palabra3 = 0;
    int Palabra4 = 0;
    int Digito = 0;
    FILE *yyin;
%}

Palabra1 ni[a-zA-Z]*
Palabra2 núm[a-zA-Z]*
Palabra3 b[a-zA-Z]*to
Palabra4 [a-zA-Z]+jo
Digito [0-9]+([.][0-9]*)?
Linea \n
Palabra [a-zA-Z]+
%%
{Palabra1} { Palabra1++; caracteres += yyleng; palabras++; }
{Palabra2} { Palabra2++; caracteres += yyleng; palabras++; }
{Palabra3} { Palabra3++; caracteres += yyleng; palabras++; }
{Palabra4} { Palabra4++; caracteres += yyleng; palabras++; }
{Digito} { Digito++; caracteres += yyleng; palabras++; }
{Linea} { lineas++; }
{Palabra} { palabras++; caracteres += yyleng; }
. { caracteres += yyleng; }
%%
int main(void) {
    yyin = fopen("/Users/gus/flex/ejemplo.txt", "r");
    if (!yyin) {
        perror("No se pudo abrir el archivo ejemplo.txt");
        return 1;
    }
    yylex();
    printf("Total de líneas: %d\n", lineas);
    printf("Total de palabras: %d\n", palabras);
    printf("Total de caracteres: %d\n", caracteres);
    printf("Total de palabras que comienzan con 'ni': %d\n", Palabra1);
    printf("Total de palabras que comienzan con 'núm': %d\n", Palabra2);
    printf("Total de palabras que comienzan con 'b' y terminan con 'to': %d\n", Palabra3);
    printf("Total de palabras que terminan con 'jo': %d\n", Palabra4);
    printf("Total de dígitos: %d\n", Digito);
    fclose(yyin);
    return 0;
}