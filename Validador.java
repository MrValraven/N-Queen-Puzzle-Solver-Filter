import java.util.Scanner;

/**
 * <p> Class Validador <p>
 * Representa um Validador que testa a validade das configuracoes
 */
public class Validador {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        if(args.length == 0){
            System.out.println("Digite a sua String: ");
            String userString = scanner.nextLine();
            Tabuleiro tabuleiro = new Tabuleiro(userString);
            int size = (int)Math.sqrt(userString.length());

            
            if(!(userString.matches("[D-]+"))){
                System.out.println("INVALIDA");
            }
            else if(userString.length() % size != 0){
                System.out.println("INVALIDA");
            }
            else if(tabuleiro.isValid() == true){
                System.out.println("VALIDA");
            }
            else{
                System.out.println("INVALIDA");
            } 
        }
       /*  else if(args[0].equals("filtro")){
            for(int i = 1; i < args.length; i++){
                filtro(args[i]);
            }
        } */
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