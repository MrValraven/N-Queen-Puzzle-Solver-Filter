import java.util.ArrayList;

/**
 * <p> Class DiagonalDescendente que implementa a interface Fila. <p>
 * Representa uma diagonal descendente do tabuleiro
 */
public class DiagonalDescendente implements Fila {
    private ArrayList<String> diagonalDescendente = new ArrayList<String>();
    private Tabuleiro tabuleiro;
    private int diagonalDescendenteNumber;

    /**
     * Construtor que obtem todas as diagonais descendentes do tabuleiro
     * @param tabuleiro - Representa um tabuleiro criado apartir de um configuracao
     * @param diagonalDescendenteNumber - inteiro que representa a coordenada da diagonal descendente que pretendemos obter
     */
    public DiagonalDescendente(Tabuleiro tabuleiro, int diagonalDescendenteNumber){
        this.tabuleiro = tabuleiro;
        this.diagonalDescendenteNumber = diagonalDescendenteNumber;
        String currentDiagonalDescendente = "";
        char[][] board = tabuleiro.getBoard();
        char diagonalChar;
        int size = (int) Math.sqrt(tabuleiro.getLength());
        int linha = 0;
        int coluna;

        //Primeira metade [0][7]
        
        while(linha < size){
            coluna = size - 1;
            int linhaAux = linha;
            while(linhaAux >= 0){
                diagonalChar = board[linhaAux][coluna];
                currentDiagonalDescendente += diagonalChar;
                linhaAux--;
                coluna--;
            }
            diagonalDescendente.add(currentDiagonalDescendente);
            currentDiagonalDescendente = "";
            linha++;
        }

        //Segunda metade [7][6]

        coluna = size - 2;

        while(coluna >= 0){
            int colunaAux = coluna;
            linha = size - 1;
            while(colunaAux >= 0){
                diagonalChar = board[linha][colunaAux];
                currentDiagonalDescendente += diagonalChar;
                linha--;
                colunaAux--;
            }
            diagonalDescendente.add(currentDiagonalDescendente);
            currentDiagonalDescendente = "";
            coluna--;
        }
    }

    @Override
    public int comprimento() {
        return diagonalDescendente.get(diagonalDescendenteNumber).length();
    }

    @Override
    public int pecas() {
        int count = 0;
        String currentdiagonalDescendente = diagonalDescendente.get(diagonalDescendenteNumber);
        
        for(int j = 0; j < currentdiagonalDescendente.length(); j++){
            if(currentdiagonalDescendente.charAt(j) == 'D'){
                count++;
                } 
            }
        return count;
    }

    @Override
    public Peca peca(int pos) throws IndexOutOfBoundsException {
        Peca diagonalDescendentePeca;
        String diagonalDescendentePos = diagonalDescendente.get(getdiagonalDescendenteNumber());

            if(pos >= diagonalDescendentePos.length()){
                throw new IndexOutOfBoundsException("Posicão inválida");
            }
            else{
                if(diagonalDescendentePos.charAt(pos) == 'D'){
                    diagonalDescendentePeca = new Rainha(tabuleiro, pos, pos);
                    return diagonalDescendentePeca;
                }
                else if(diagonalDescendentePos.charAt(pos) == '-'){
                    diagonalDescendentePeca = new Nada(tabuleiro, pos, pos);
                    return diagonalDescendentePeca;
                }
            }
        return null;
    }

    public int getdiagonalDescendenteNumber(){
        return diagonalDescendenteNumber;
    }
}