/**
 * Class abstrata Peca
 * Representa o que é uma peça no tabuleiro
 */
public abstract class Peca {
    private Tabuleiro tab;
    private int linha;
    private int coluna;
    private char id;
    private String name;

    /**
     * Construtor que obtem uma nova peça
     * @param tab - tabuleiro
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @param id - char que representa a maneira em como podemos identificar uma peça
     * @param name - string que representa o nome de uma peça
     */
    Peca(Tabuleiro tab, int linha, int coluna, char id, String name){
        this.tab = tab;
        this.linha = linha;
        this.coluna = coluna;
        this.id = id;
        this.name = name;
    }

    /**
     * Função que verifica se uma posição está livre ou ameaçada
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return true se a posição esta livre de perigo, false se estiver ameaçada
     */
    public abstract boolean podeIrPara(int linha, int coluna);

    /**
     * Função que verifica se uma posição está ocupada
     * @return true se estiver vazia, false se estiver ocupada
     */
    public abstract boolean vazia();

    /**
     * Função que verifica se é possivel atacar uma peça
     * @param vitima - uma peca que representa peça a ser atacada
     * @return true se for possivel atacar a vitima, caso contrário false
     */
    final boolean ataca(Peca vitima){
        return podeIrPara(vitima.getLinha(), vitima.getColuna()); 
    }

    /**
     * Função que obtem o tabuleiro em que a peça se encontra
     * @return o tabuleiro
     */
    public Tabuleiro getTab(){
        return this.tab;
    }

    /**
     * Função que obtem a linha em que a peça se encontra
     * @return um inteiro que representa a coordenada da linha
     */
    public int getLinha(){
        return this.linha;
    }

    /**
     * Função que obtem a coluna em que a peça se encontra
     * @return um inteiro que representa a coordenada da coluna
     */
    public int getColuna() {
        return this.coluna;
    }

    /**
     * Função que obtem a identificação de uma peça
     * @return um char que representa a identificação da peça
     */
     public char getId() {
        return this.id;
    }

    /**
     * Função que obtem o nome de uma peça
     * @return uma string que representa o nome da peça
     */
     public String getName() {
        return this.name;
    }
}