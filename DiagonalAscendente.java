import java.util.ArrayList;

/**
 * <p> Class DiagonalAscendente que implementa a interface Fila. <p>
 * Representa uma diagonal ascendente do tabuleiro
 */
public class DiagonalAscendente implements Fila {
    private ArrayList<String> diagonalAscendente = new ArrayList<String>();
    private Tabuleiro tabuleiro;
    private int diagonalAscendenteNumber;

    /**
     * Construtor que obtem todas as diagonais ascendentes do tabuleiro
     * @param tabuleiro - Representa um tabuleiro criado apartir de um configuracao
     * @param diagonalAscendenteNumber - inteiro que representa a coordenada da diagonal ascendente que pretendemos obter
     */
    public DiagonalAscendente(Tabuleiro tabuleiro, int diagonalAscendenteNumber){
        this.tabuleiro = tabuleiro;
        this.diagonalAscendenteNumber = diagonalAscendenteNumber;
        String currentDiagonalAscendente = "";
        char[][] board = tabuleiro.getBoard();
        char diagonalChar;
        int size = (int) Math.sqrt(tabuleiro.getLength());
        int linha = 0;
        int coluna;

        //Primeira metade [0][0]

        while(linha < size){
            coluna = 0;
            int linhaAux = linha;
            while(linhaAux >= 0){
                diagonalChar = board[linhaAux][coluna];
                currentDiagonalAscendente += diagonalChar;
                linhaAux--;
                coluna++;
            }
            diagonalAscendente.add(currentDiagonalAscendente);
            currentDiagonalAscendente = "";
            linha++;
        }

        //Segunda metade [7][1]

        coluna = 1;

        while(coluna < size){
            int colunaAux = coluna;
            linha = size - 1;
            while(colunaAux <= size - 1){
                diagonalChar = board[linha][colunaAux];
                currentDiagonalAscendente += diagonalChar;
                linha--;
                colunaAux++;
            }
            diagonalAscendente.add(currentDiagonalAscendente);
            currentDiagonalAscendente = "";
            coluna++;
        }
    }

    @Override
    public int comprimento() {
        return diagonalAscendente.get(diagonalAscendenteNumber).length();
    }

    @Override
    public int pecas() {
        int count = 0;
        String currentdiagonalAscendente = diagonalAscendente.get(diagonalAscendenteNumber);
        
        for(int j = 0; j < currentdiagonalAscendente.length(); j++){
            if(currentdiagonalAscendente.charAt(j) == 'D'){
                count++;
                } 
            }
        return count;
    }

    @Override
    public Peca peca(int pos) throws IndexOutOfBoundsException {
        Peca diagonalAscendentePeca;
        String diagonalAscendentePos = diagonalAscendente.get(getdiagonalAscendenteNumber());

            if(pos >= diagonalAscendentePos.length()){
                throw new IndexOutOfBoundsException("Posicão inválida");
            }
            else{
                if(diagonalAscendentePos.charAt(pos) == 'D'){
                    diagonalAscendentePeca = new Rainha(tabuleiro, pos, pos);
                    return diagonalAscendentePeca;
                }
                else if(diagonalAscendentePos.charAt(pos) == '-'){
                    diagonalAscendentePeca = new Nada(tabuleiro, pos, pos);
                    return diagonalAscendentePeca;
                }
            }
        return null;
    }

    public int getdiagonalAscendenteNumber(){
        return diagonalAscendenteNumber;
    }
}