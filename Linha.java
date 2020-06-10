import java.util.ArrayList;

/**
 * Class Linha que implementa a interface Fila
 * Representa uma linha do tabuleiro
 */
public class Linha implements Fila {
    private ArrayList<String> linha = new ArrayList<String>();
    private Tabuleiro tabuleiro;
    private int linhaNumber;

    /**
     * Construtor que obtem todas as linhas do tabuleiro
     * @param tabuleiro - Representa um tabuleiro criado apartir de um configuração
     * @param linhaNumber - inteiro que representa a coordenada da linha que pretendemos obter
     */
    public Linha(Tabuleiro tabuleiro, int linhaNumber){
        this.tabuleiro = tabuleiro;
        this.linhaNumber = linhaNumber;
        char linhaChar;
        String linhaString = "";
        int size = (int) Math.sqrt(tabuleiro.getLength());
        char[][] board = tabuleiro.getBoard();
    
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                linhaChar = board[i][j];
                linhaString += linhaChar;
                if(linhaString.length() == size){
                    linha.add(linhaString);
                    linhaString = "";
                }
            }
        }
    }


    @Override
    public int comprimento() {
        return linha.get(linhaNumber).length();
    }

    @Override
    public int pecas() {
        int count = 0;
        String currentlinha = linha.get(linhaNumber);
        
        for(int j = 0; j < currentlinha.length(); j++){
            if(currentlinha.charAt(j) == 'D'){
                count++;
                } 
            }
        return count;
    }

    @Override
    public Peca peca(int pos) throws IndexOutOfBoundsException {
        Peca linhaPeca;
        String linhaPos = linha.get(getLinhaNumber());

            if(pos >= linhaPos.length()){
                throw new IndexOutOfBoundsException("Posicão inválida");
            }
            else{
                if(linhaPos.charAt(pos) == 'D'){
                    linhaPeca = new Rainha(tabuleiro, pos, pos,'D',"Rainha");
                    return linhaPeca;
                }
                else if(linhaPos.charAt(pos) == '-'){
                    linhaPeca = new Nada(tabuleiro, pos, pos, '-', "Nada");
                    return linhaPeca;
                }
            }
        return null;
    }

    public int getLinhaNumber(){
        return linhaNumber;
    }
}