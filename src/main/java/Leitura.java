/*
 * Luiz Felipe Fernanddes Ramos - RA: 2767112
 * Classe de leitura
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



// Classe para leitura de dados
public class Leitura{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Método de entrada de dados string
    public static String entrada(String mensagem) {
        System.out.print(mensagem);
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Erro na leitura: " + e.getMessage());
            return "";
        }
    }
   
    // Método de entrada de dados int com tratamento de exceção
    public static int entradaInt(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(entrada(mensagem));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                
            }
        }
    }
    

}
