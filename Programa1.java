
package pkg1.pkg2.programa.pkg1;

import java.util.Scanner;

/**
 *
 * @author edspa
 */
public class Programa1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce una cadena de caracteres: ");
        String entrada = scanner.nextLine();
        
        String[] elementos = entrada.split("\\s+");
        
        System.out.println("\nClasificacion de elementos: ");
        for (String elemento : elementos){
            String tipo = clasificarElemento(elemento);
            System.out.println(elemento + " -> " + tipo);
        }
        
        scanner.close();
}
    
    public static String clasificarElemento(String cadena) {
        if (esNumeroEntero(cadena)){
            return "Numero entero";
        } else if (esPalabra(cadena)){
            return "Palabra";
        } else {
            return "Compuesta";
        }
        
    }
    
    public static boolean esNumeroEntero (String cadena){
        return cadena.matches("\\dd+");
    }
    
    public static boolean esPalabra (String cadena) {
        return cadena.matches("[a-zA-Z]+");
    }
    
}
