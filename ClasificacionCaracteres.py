import string

texto = input('Introduzca texto: ')
abc = string.ascii_letters
num = string.digits
car = string.punctuation
palabras = texto.split()

for x in palabras:
    a = False
    b = False
    c = False
    for y in x:
        if y in abc:
            a = True
        if y in num:
            b = True
        if y in car:
            c = True
    if a and b and c == False:
        print(x,', Es una palabra compuesta')
    if a and b == False and c == False:
        print(x,', Es un palabra')
    if b and a == False and c == False:
        print(x,', Es un numero')
    if a and b and c:
        print(x,', Es una palabra compuesta con caracteres especiales')
    if b and c and a == False :
        print(x,', Es un numero con caracteres especiales')
    if b == False and c and a == False :
        print(x,', Es un caracter especial')
    if b == False and c and a:
        print(x,', Es una palabra con caracter especial')