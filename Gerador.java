import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
 * Class Gerador
 * Representa um Gerador de configurações com diversos argumentos
 */ 
public class Gerador {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int modeValue = 0;

    public static void main(String[] args) {
        int numberOfConfigs = 0;
        int numberOfQueens = 0;
        int numberOfSize = 0;
        int dimensions = 0;
        
        if(args.length == 0){
            System.out.println("Please choose a mode: 'random' , 'all' , 'allValid'.");
            String mode = scanner.nextLine();
            while(mode != "random" || mode != "allValid" || mode != "all" || mode != "validador"){
                if(mode.contains("random")){
                    System.out.println("Digite o numero de configuracoes: ");
                    numberOfConfigs = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a dimensao do tabuleiro: ");
                    numberOfSize = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o numero de rainhas: ");
                    numberOfQueens = scanner.nextInt();
                    scanner.nextLine();
                    random(numberOfSize,numberOfQueens,numberOfConfigs);
                    break;
                }
                else if(mode.contains("allValid")){
                    int value = 0;
                    System.out.println("Value: ");
                    value = scanner.nextInt();
                    allValid(value);
                    break;
                }
                else if(mode.contains("all")){
                    modeValue = 1;
                    int value = 0;
                    System.out.println("Value: ");
                    value = scanner.nextInt();
                    all(value);
                    break;
                }
                else{
                    System.out.println("Invalid mode, please try again");
                    mode = scanner.nextLine();
                }
            }
        }
        // Configuração final para aceitar argumentos do terminal
        else if(args[0].equals("random")){
            numberOfConfigs = Integer.parseInt(args[3]);
            numberOfQueens = Integer.parseInt(args[2]);
            numberOfSize = Integer.parseInt(args[1]);
            dimensions = numberOfSize * numberOfSize;

            random(numberOfConfigs, dimensions, numberOfQueens);
        }
        else if(args[0].equals("all")){
            modeValue = 1;
            numberOfQueens = Integer.parseInt(args[1]);
            all(numberOfQueens); 
        }
        else if(args[0].equals("allValid")){
            numberOfQueens = Integer.parseInt(args[1]);
            allValid(numberOfQueens); 
        }
        scanner.close();
    }

    /**
     * Gera um inteiro que representa o número entre 0 e range
     * @param range - um inteiro que representa o alcance máximo
     * @return um inteiro entre 0 e o valor de range
     */
    private static int randomIndex(int range){
        int randomNumber =  (int) Math.floor(Math.random() * range);
        return randomNumber;
    }

    /**
     * Cria uma string composta apenas por '-';
     * @param length - inteiro que representa o tamanho da string
     * @return uma string de '-' de tamanho 'length' 
     */
    private static String dashLine(int length){
         String dash = "-".repeat(length);
         return dash;
    }

    /**
     * Adiciona 'D' a um index aleatório da string até a quantidade igualar o valor de numberOfQueens
     * @param size - inteiro que representa tamanho da string
     * @param numberOfQueens - inteiro que representa a quantidade de 'D' a adicionar à string
     * @return uma string de tamanho 'size' composta por 'D' e '-'
     */
    private static String addQueensToString(int size, int numberOfQueens) {
        StringBuilder string = new StringBuilder(dashLine(size));
        int queenCounter = 0;
        int index = 0;

            for(int j = 0; j < string.length(); j++){
                while(queenCounter < numberOfQueens){
                    index = randomIndex(size);
                    if(string.charAt(index) == 'D'){
                        index = randomIndex(size);
                    }
                    else if(string.charAt(index) == '-'){
                        string.setCharAt(index, 'D');
                        queenCounter++;
                    }
                }
            }
            return string.toString();
    }
    /**
     * Gerador de N strings de tamanho M * M , com Q rainhas
     * @param m - inteiro que representa o número de casas de cada lado da matriz
     * @param q - inteiro que representa o número de rainhas 
     * @param n - inteiro que representa o número de configurações
     * @return uma ArrayList que contem N strings com os parametros indicados
     */
    public static List<String> random(int m, int q, int n){ 
        List<String> randomList = new ArrayList<String>();
        String randomString;
        int dimensions = m * m;

        if(q <= m){
            for(int i = 0; i < n; i++){
                randomString = addQueensToString(dimensions, q);
                randomList.add(randomString);
                System.out.println(randomString);
            }
        }
        else{
            System.out.println("Argumentos inválidos, o numero de rainhas (Q) é maior que a dimensão (M) permitida");
        }
        return randomList;
    }

    /**
     * Gerador de todas as combinações de strings M * M , com M rainhas
     * @param m - inteiro que representa o número de rainhas e de casas de cada lado da matriz
     * @return uma ArrayList que contem todas as strings com os parametros indicados
     */
    public static List<String> all(int m){
        List<String> allStrings = new ArrayList<String>();
        String binary;
        String finalString;
        long lowestValue = 0;
        long highestValue = 0;
        int count = 0;

        if(m < 2){
            highestValue = (long)Math.pow(2, m);
        }
        else if(m == 2){
            highestValue = (long)Math.pow(2, m+2);
        }
        else{
            lowestValue = (long)Math.pow(2, m) - 1;
            highestValue = (long)Math.pow(2, m * m);
        }

        for(long i = lowestValue; i < highestValue; i++){
            binary = Long.toBinaryString(i);
            char[] binaryChar = binary.toCharArray();
            count = 0;
            for(int j = 0; j < binaryChar.length; j++) {
                if(binaryChar[j] == '1'){
                    count++;
                    }
                }
            
            if(count == m){
                if(binary.length() < m * m){
                    binary = "-".repeat(m * m - binary.length()) + binary;
                }
                finalString = binary.replace('1', 'D');
                finalString = finalString.replace('0', '-');
                if(modeValue == 1){
                    System.out.println(finalString);
                }
                allStrings.add(finalString);
            }
        }
        return allStrings;
    }

    /**
     * Gerador de todas as strings válidas de tamanho M * M com M rainhas
     * @param m - inteiro que representa o número de rainhas e de casas de cada lado da matriz
     * @return uma ArrayList com todas as strings válidas com os parametros indicados
     */
    public static List<String> allValid(int m){
        List<String> allValid = new ArrayList<String>();
        String newConfig;
        List<String> allConfigs = all(m);
        
        for(int i = 0; i < allConfigs.size(); i++){
            newConfig = allConfigs.get(i);
            if(Validador.filtro(newConfig) == "VALIDA"){
                System.out.println(newConfig);
                allValid.add(newConfig);
            }
        }
        return allValid;
    }
}