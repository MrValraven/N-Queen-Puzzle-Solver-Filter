/**
 * Class Tabuleiro
 * Representa um tabuleiro
 */ 
public class Tabuleiro {
    private String repr;
    private String finalRepr;
    private int size;
    private char[][] board;
    private Peca[][] boardPecas;

    /**
     * Construtor que recebe uma string como argumento e procede à criacao de um tabuleiro do tipo 'char' e outro do tipo 'peca'
     * @param repr - uma string que representa uma configuracao
     */
    public Tabuleiro(String repr) {
        this.repr = repr;
        if(repr.length() % 2 != 0){
            repr = "";
        }
        finalRepr = repr.replaceAll("\\s+","");
        size = (int) (Math.sqrt(finalRepr.length()));
        board = new char[size][size];
        boardPecas = new Peca[size][size]; 
        int aux = 0;

        //converter a String numa Matriz
        for (int i = 0; i < size; i++){ 
            for (int j = 0; j < size; j++){ 
                if(aux < finalRepr.length())
                    board[i][j] = finalRepr.charAt(aux);
                    
                    //guardar os objetos 'rainha' e 'nada' na matriz
                    if (finalRepr.charAt(aux) == 'D') {
                        boardPecas[i][j] = new Rainha(this, i, j);
                    }
                    else {
                        boardPecas[i][j] = new Nada(this, i, j);
                    } 
                aux++; 
            } 
        }
    }
    
    /**
     * Funcao que cria uma nova peca nas coordenadas indicadas
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     */
    public void colocarPeca(int linha, int coluna){
        boardPecas[linha][coluna] = new Rainha(this,linha,coluna);
    }
    
    /**
     * Funcao que indica qual e a peca presente nas coordenadas indicadas
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return a peca nas coordenadas indicadas
     */
    public Peca peca(int linha, int coluna){
        return boardPecas[linha][coluna];
    }
    
    /**
     * Funcao que indica se a posicao nas coordenadas indicadas esta ameacada por outras pessoas
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna -  inteiro que representa a coordenada da coluna
     * @return true se a posicao estiver ameacada por outras pecas, caso contrario false
     */
    public boolean ameacada(int linha, int coluna){
        
        if(linha(linha).pecas() >= 2 || coluna(coluna).pecas() >= 2 || diagonalAscendente(linha, coluna).pecas() >= 2 || diagonalDescendente(linha, coluna).pecas() >= 2){
            return true;
        }

        return false;
    }

    /**
     * Funcao que obtem a linha na coordenada indicada
     * @param linha - inteiro que representa a coordenada da linha
     * @return a linha que esta na coordenada indicada
     */
    public Linha linha(int linha){
        Linha linhaAtual = new Linha(this, linha);
        return linhaAtual;
    }

    /**
     * Funcao que obtem a coluna na coordenada indicada
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return a coluna que esta na coordenada indicada
     */
    public Coluna coluna(int coluna){
        Coluna colunaAtual = new Coluna(this, coluna);
        return colunaAtual;
    }

    /**
     * Funcao que obtem a diagonal ascendente que passa nas coordenadas indicadas
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return a diagonal ascendente que passa nas coordenadas indicadas
     */
    public DiagonalAscendente diagonalAscendente(int linha, int coluna) {
        int number = linha + coluna;
        
        DiagonalAscendente diagonalAscendente = new DiagonalAscendente(this, number);
        return diagonalAscendente;
    }

    /**
     * Funcao que obtem a diagonal descendente que passa nas coordenadas indicadas
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que represente a coordenada da coluna
     * @return a diagonal descendente que passa nas coordenadas indicadas
     */
    public DiagonalDescendente diagonalDescendente(int linha, int coluna){
        int number = getSize() - 1 - (coluna - linha);
        
        DiagonalDescendente diagonalDescendente = new DiagonalDescendente(this, number);
        return diagonalDescendente;
    }

    /**
     * Funcao que verifica a validade da configuracao de um tabuleiro
     * @return false se o tabuleiro tiver uma configuracao errada, caso contrario, true
     */
    public boolean isValid(){
        for(int i = 0; i < getSize(); i++){
            int linha = i;
            for(int j = 0; j < getSize(); j++){
                int coluna = j;
                if(ameacada(linha, coluna) == true){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Funcao que obtem o valor do tamanho de cada lado do tabuleiro
     * @return um inteiro que representa o tamanho de cada lado do tabuleiro
     */
    private int getSize() {
        return (int) Math.sqrt(getLength());
    }

    /**
     * Funcao que obtem o valor do tamanho do tabuleiro
     * @return um inteiro que representa o tamanho do tabuleiro
     */
	public int getLength() {
		return repr.length();
    }

    /**
     * Funcao que obtem a configuracao obtida em forma de um tabuleiro
     * @return um array bidimensional de char que representa o tabuleiro
     */
    public char[][] getBoard(){
        return board;
    }

    /**
     * Funcao que obtem a configuracao obtida sem espaços
     * @return uma string que representa a configuracao final
     */
    @Override
    public String toString(){
        return finalRepr;
    }

}