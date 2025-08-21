/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1.pkg4.programa.pkg2;

/**
 *
 * @author edspa
 */
public class Programa2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("=== Clasificador de Cadenas ===");
        System.out.println("Introduce una linea con palabras, numeros y cadenas compuestas:");
        System.out.print("Entrada: ");

        String entrada = scanner.nextLine();

        // Separar la entrada por espacios
        String[] elementos = entrada.split(" ");
        int total = elementos.length;
        int enteros = 0;
        int palabras = 0;
        int compuestas = 0;

        System.out.println("\nClasificacion individual:");
        for (int i = 0; i < elementos.length; i++) {
            String elemento = elementos[i];

            if (esEntero(elemento)) {
                enteros++;
                System.out.println("[" + elemento + "] → entero");
            } else if (esPalabra(elemento)) {
                palabras++;
                System.out.println("[" + elemento + "] → palabra");
            } else {
                compuestas++;
                System.out.println("[" + elemento + "] → compuesta");
            }
            
        }
        
        System.out.println("\n=== Resumen ===");
        System.out.println("Total elementos: " + total);
        System.out.println("Enteros: " + enteros);
        System.out.println("Palabras: " + palabras);
        System.out.println("Compuestas: " + compuestas);

        System.out.println("\nFin del programa. ¡Gracias por usarlo!");
    }
    
    public static boolean esEntero(String cadena) {
        if (cadena.length() == 0) return false;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean esPalabra(String cadena) {
        if (cadena.length() == 0) return false;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == 'ñ' || c == 'Ñ')) {
                return false;
            }
        }
        return true;
    }

    
}
