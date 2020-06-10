/**
 * Class abstrata Peca.
 * Representa o que e uma peca no tabuleiro
 */
public abstract class Peca {
    private Tabuleiro tab;
    private int linha;
    private int coluna;

    /**
     * Construtor que obtem uma nova peca
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
     * Funcao que verifica se uma posicao está livre ou ameaçada
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return true se a posicao esta livre de perigo, false se estiver ameaçada
     */
    public abstract boolean podeIrPara(int linha, int coluna);

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