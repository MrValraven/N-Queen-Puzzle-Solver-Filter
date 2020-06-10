import java.util.Scanner;

/**
 * Class Validador
 * Representa um Validador que testa a validade das configuracoes
 */
public class Validador {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        if(args.length == 0){
        
      /*   System.out.println("Digite a sua String: ");
        String userString = scanner.nextLine();
        validadorIndividual(userString); */
        Tabuleiro tab = new Tabuleiro("DD--"); 
        Peca peca = tab.peca(0,0); 
        System.out.println(peca.podeIrPara(1,1));
        
        scanner.close();
        }
        else if(args[0].equals("filtro")){
            for(int i = 1; i < args.length; i++){
                filtro(args[i]);
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

    /**
     * Funcao que recebe uma configuração do tabuleiro e classifica-a como "VALIDA" ou "INVALIDA"
     * @param configuracao string que representa uma configuracao do tabuleiro
     */
    public void validadorIndividual(String configuracao){
        Tabuleiro tabuleiro = new Tabuleiro(configuracao);

        if(!configuracao.matches("[abc]+")){
            System.out.println("INVALIDA");
        }
        else if(tabuleiro.isValid() == false){
            System.out.println("INVALIDA");
        }
        else{
            System.out.println("VALIDA");
        }
    }
}