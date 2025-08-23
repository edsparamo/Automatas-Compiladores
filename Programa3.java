/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1.pkg5.programa.pkg3;

/**
 *
 * @author edsparamo
 */
public class Programa3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.io.File archivo = new java.io.File("entrada.txt");
        java.util.Scanner lector = null;

        int caracteresConEspacios = 0;
        int caracteresSinEspacios = 0;
        int totalLexemas = 0;
        int totalNumeros = 0;
        int totalPalabras = 0;
        int totalCompuestas = 0;

        try {
            lector = new java.util.Scanner(archivo);

            System.out.println("=== Clasificador de Lexemas ===");

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();

                // Contar caracteres
                caracteresConEspacios += linea.length();
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) != ' ') {
                        caracteresSinEspacios++;
                    }
                }

                // Separar lexemas
                String[] lexemas = linea.split(" ");

                for (int i = 0; i < lexemas.length; i++) {
                    String lexema = lexemas[i];
                    if (lexema.length() == 0) {
                        continue;
                    }

                    totalLexemas++;

                    if (esNumero(lexema)) {
                        totalNumeros++;
                        System.out.println("[" + lexema + "] -> número");
                    } else if (esPalabra(lexema)) {
                        totalPalabras++;
                        System.out.println("[" + lexema + "] -> palabra");
                    } else {
                        totalCompuestas++;
                        System.out.println("[" + lexema + "] -> compuesta");
                    }
                }
            }

            // Mostrar estadísticas
            System.out.println("\n=== Estadisticas ===");
            System.out.println("Caracteres con espacios: " + caracteresConEspacios);
            System.out.println("Caracteres sin espacios: " + caracteresSinEspacios);
            System.out.println("Total de lexemas: " + totalLexemas);
            System.out.println("Palabras: " + totalPalabras);
            System.out.println("Numeros: " + totalNumeros);
            System.out.println("Compuestas: " + totalCompuestas);

        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error: No se encontro el archivo.");
        }
    }

    public static boolean esNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return cadena.length() > 0;
    }

    public static boolean esPalabra(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == 'ñ' || c == 'Ñ')) {
                return false;
            }
        }
        return cadena.length() > 0;
    }
}
