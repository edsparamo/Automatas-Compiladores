%option noyywrap
%{
	#include <stdio.h>
	FILE *yyin;
	int num_comentarios = 0;
%}

%%
// Palabras reservadas
"int"|"float"|"if"|"else"|"while"|"return"|"auto"|"bool"|"break"|"case"|"catch"|"char"|"class"|"const"|"continue"|"default"|"delete"|"do"   
						{ printf("Palabra reservada: %s\n", yytext); }

// Comentarios
"//".*                                          { num_comentarios++; printf("Comentario encontrado\n"); }
"/*"([^*]|\*+[^*/])*\*+"/"                      { num_comentarios++; printf("Comentario bloque encontrado\n"); }

// Identificadores (nombres de variables)
[a-zA-Z_][a-zA-Z0-9_]*                          { printf("Identificador: %s\n", yytext); }

// Constantes numericas
[0-9]+                                          { printf("Numero constante: %s\n", yytext); }

// Operadores aritmeticos
"+"|"-"|"*"|"/"|"%"                             { printf("Operador aritmetico: %s\n", yytext); }

// Operadores logicos
"&&"|"||"|"!"                                   { printf("Operador logico: %s\n", yytext); }

// Simbolos especiales
"{"|"}"|"(" | ")"|"["|"]"|";"|","|"="           { printf("Simbolo especial: %s\n", yytext); }

// Ignorar espacios y saltos
[ \t\n]+                                        { /*  */ }

.                                               { printf("Algo raro: %s\n", yytext); }

%%

int main(int argc, char **argv) {
    if (argc > 1) {
        FILE *archivo = fopen(argv[1], "r");
        if (!archivo) {
            printf("No se pudo abrir el archivo\n");
            return 1;
        }
        yyin = archivo;
    }
    yylex();
    printf("\nTotal de comentarios encontrados: %d\n", num_comentarios);
    fclose(yyin);
    return 0;
}