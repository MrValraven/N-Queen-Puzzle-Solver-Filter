import java.util.Scanner;

/**
 * Class Validador
 * Representa um Validador que testa a validade das configuracoes
 */
public class Validador {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        if(args.length == 0){
        
       /*System.out.println("Digite a sua String: ");
        String userString = scanner.nextLine();
        validadorIndividual(userString); */
        
        Tabuleiro tab1 = new Tabuleiro("D-D-D----");
        Peca peca = tab1.peca(0,1); 
        System.out.println(peca.vazia());
        Tabuleiro tab = new Tabuleiro("D-D-D----");
        Peca peca_0 = tab.peca(0,0); 
        Peca peca_1 = tab.peca(1,4);
        System.out.println(peca_0.ataca(peca_1));
        
        
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

        if(tabuleiro.isValid() == false){
            System.out.println("INVALIDA");
        }
        else{
            System.out.println("VALIDA");
        }
    }
}