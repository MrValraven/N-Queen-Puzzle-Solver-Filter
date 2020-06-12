import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 * Class Validador
 * <p>
 * Representa um Validador que testa a validade das configuracoes
 */
public class Validador {

    public static void main(String[] args) throws IOException {
        ArrayList<String> stringValidas = new ArrayList<String>();
        String input;
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            Tabuleiro tabuleiro = new Tabuleiro(input);

            if (!(input.matches("[D-]+"))) {
                System.out.println("INVALIDA");
            } else if (tabuleiro.isValid() == true) {
                System.out.println("VALIDA");
            } else {
                System.out.println("INVALIDA");
            }
            scanner.close();
        } else if (args[0].equals("filtro")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = null;
            while (true) {
                input = bufferedReader.readLine();
            
                if(filtro(input) == "VALIDA"){
                    stringValidas.add(input);
                }
                if(input.equals("null")){
                    for(int i = 0; i < stringValidas.size(); i++){
                        System.out.println(stringValidas.get(i));
                    }
                    break;
                }
            }
        }
    }

    /**
     * Funcao que classifica a configuracao dada como valida ou invalida
     * @param configuracao string que representa uma configuração do tabuleiro
     * @return uma string que representa a validade da configuracao
     */
    public static String filtro(String configuracao) {
        Tabuleiro tabuleiro = new Tabuleiro(configuracao);
        String resultado;

        if(tabuleiro.isValid() == false){
            resultado = "INVALIDA";
        }
        else{
            resultado = "VALIDA";
        }
        return resultado;
    }

}