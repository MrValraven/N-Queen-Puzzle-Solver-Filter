import java.util.ArrayList;

/**
 * Class Coluna que implementa a interface Fila 
 * Representa uma coluna do tabuleiro
 */
public class Coluna implements Fila {
    private ArrayList<String> coluna = new ArrayList<String>();
    private Tabuleiro tabuleiro;
    private int colunaNumber;
    
    /**
     * Construtor que obtem todas as colunas do tabuleiro
     * @param tabuleiro - Representa um tabuleiro criado apartir de um configuração
     * @param colunaNumber - inteiro que representa a coordenada da coluna que pretendemos obter
     */
    public Coluna(Tabuleiro tabuleiro, int colunaNumber){
        this.tabuleiro = tabuleiro;
        this.colunaNumber = colunaNumber;
        char colunaChar;
        String colunaString = "";
        int size = (int) Math.sqrt(tabuleiro.getLength());
        char[][] board = tabuleiro.getBoard();
    
        for(int j = 0; j < size; j++){
            for(int i = 0; i < size; i++){
                colunaChar = board[i][j];
                colunaString += colunaChar;
                if(colunaString.length() == size){
                    coluna.add(colunaString);
                    colunaString = "";
                }
            }
        }
    }

    @Override
    public int comprimento() {
        return coluna.get(colunaNumber).length();
    }

    @Override
    public int pecas() {
        int count = 0;
        String currentColuna = coluna.get(colunaNumber);
        
        for(int j = 0; j < currentColuna.length(); j++){
            if(currentColuna.charAt(j) == 'D'){
                count++;
                } 
            }
        return count;
    }

    @Override
    public Peca peca(int pos) throws IndexOutOfBoundsException {
        Peca colunaPeca;
        String colunaPos = coluna.get(getColunaNumber());

            if(pos >= colunaPos.length()){
                throw new IndexOutOfBoundsException("Posicão inválida");
            }
            else{
                if(colunaPos.charAt(pos) == 'D'){
                    colunaPeca = new Rainha(tabuleiro, pos, pos,'D',"Rainha");
                    return colunaPeca;
                }
                else if(colunaPos.charAt(pos) == '-'){
                    colunaPeca = new Nada(tabuleiro, pos, pos, '-', "Nada");
                    return colunaPeca;
                }
            }
        return null;
    }

    public int getColunaNumber(){
        return colunaNumber;
    }
}