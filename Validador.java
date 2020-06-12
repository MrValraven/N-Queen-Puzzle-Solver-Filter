import java.util.Scanner;

/**
 * <p>
 * Class Validador
 * <p>
 * Representa um Validador que testa a validade das configuracoes
 */
public class Validador {
    public static void main(String[] args){
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
        } 
        else if (args[0].equals("filtro")) {
            Scanner scanner = new Scanner(System.in);

            input = null;

            while (scanner.hasNext()) {
                input = scanner.nextLine();
            
                if(filtro(input) == "VALIDA"){
                    System.out.println(input);
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

        if(tabuleiro.isValid() == true){
            resultado = "VALIDA";
        }
        else{
            resultado = "INVALIDA";
        }
        return resultado;
    }

}