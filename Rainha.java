/**
 * Class Rainha que herda a Class Peca
 * Representa que tipo de peça e uma Rainha
 */
public class Rainha extends Peca {
    private Tabuleiro tabuleiro;
    private String name = "Rainha";

    public Rainha(final Tabuleiro tab, final int linha, final int coluna) {
        super(tab, linha, coluna);
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean vazia(){
        return false;
    }

    @Override
    public boolean podeIrPara(int linha, int coluna){
        //Erro
        char[][] board = tabuleiro.getBoard();
        board[linha][coluna] = 'D';
        if(board[linha][coluna] == 'D'){
            return true;
        }
        else{
            return false;
        } 
    }
    
}