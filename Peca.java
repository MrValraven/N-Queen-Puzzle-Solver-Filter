/**
 * <p> Class abstrata Peca. <p>
 * Representa o que e uma peca no tabuleiro
 */
public abstract class Peca {
    private Tabuleiro tab;
    private int linha;
    private int coluna;

    /**
     * Construtor que cria uma nova peca
     * @param tab - tabuleiro onde se encontra a peca
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @param id - char que representa a maneira em como podemos identificar uma peca
     * @param nome - string que representa o nome de uma peca
     */
    Peca(Tabuleiro tab, int linha, int coluna){
        this.tab = tab;
        this.linha = linha;
        this.coluna = coluna;
    }

    /**
     * Funcao que verifica se uma posicao está livre 
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return true se a posicao esta livre, false se estiver ocupada
     */
    public boolean podeIrPara(int linha, int coluna){
        char[][] board = tab.getBoard();
        int linhaInicial = tab.linha(getLinha()).getLinhaNumber();
        int linhaDestino = tab.linha(linha).getLinhaNumber();
        int colunaInicial = tab.coluna(getColuna()).getColunaNumber();
        int colunaDestino = tab.coluna(coluna).getColunaNumber();
        int diagonalAscendenteInicial = tab.diagonalAscendente(getLinha(), getColuna()).getdiagonalAscendenteNumber();
        int diagonalAscendenteDestino = tab.diagonalAscendente(linha, coluna).getdiagonalAscendenteNumber();
        int diagonalDescendenteInicial = tab.diagonalDescendente(getLinha(), getColuna()).getdiagonalDescendenteNumber();
        int diagonalDescendenteDestino = tab.diagonalDescendente(linha, coluna).getdiagonalDescendenteNumber();
        
        if(linha >= board.length || coluna >= board.length){
            return false;
        }
        else if((linhaInicial == linhaDestino) || (colunaInicial == colunaDestino) || (diagonalAscendenteInicial == diagonalAscendenteDestino) || (diagonalDescendenteInicial == diagonalDescendenteDestino)){
            return true;
        }
        else{
            return false;
        }
    } 

    /**
     * Funcao que verifica se uma posicao está ocupada
     * @return true se estiver vazia, false se estiver ocupada
     */
    public abstract boolean vazia();

    /**
     * Funcao que verifica se e possivel atacar uma peca
     * @param vitima - uma peca que representa a peca a ser atacada
     * @return true se for possivel atacar a vitima, caso contrário false
     */
    public final boolean ataca(Peca vitima){
        return podeIrPara(vitima.getLinha(), vitima.getColuna()); 
    }

    /**
     * Funcao que obtem o tabuleiro em que a peca se encontra
     * @return o tabuleiro em que a peca se encontra
     */
    public Tabuleiro getTab(){
        return this.tab;
    }

    /**
     * Funcao que obtem a linha em que a peca se encontra
     * @return um inteiro que representa a coordenada da linha
     */
    public int getLinha(){
        return this.linha;
    }

    /**
     * Funcao que obtem a coluna em que a peca se encontra
     * @return um inteiro que representa a coordenada da coluna
     */
    public int getColuna() {
        return this.coluna;
    }
}