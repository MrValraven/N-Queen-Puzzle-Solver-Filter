import java.util.Scanner;

public class Validador {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        if(args.length == 0){
        System.out.println("Digite a sua String: ");
        String userString = scanner.nextLine();
        String userStringWithoutSpaces = userString.replaceAll("\\s+","");
        validadorIndividual(userStringWithoutSpaces);
        scanner.close();
        }
        else if(args[0].equals("filtro")){
            for(int i = 1; i < args.length; i++){
                filtro(args[i]);
            }
        }
    }

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

    public static void validadorIndividual(String configuracao){
        Tabuleiro tabuleiro = new Tabuleiro(configuracao);

        if(tabuleiro.isValid() == false){
            //System.out.println("INVALIDA");
        }
        else{
            System.out.println("VALIDA");
            System.out.println(configuracao);
        }
    }

}