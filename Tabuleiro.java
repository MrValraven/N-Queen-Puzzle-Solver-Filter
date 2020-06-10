/**
 * Class Tabuleiro
 * Representa um tabuleiro
 * */ 
public class Tabuleiro {
    private String repr;
    private int size;
    private char[][] board;
    private Peca[][] boardPecas;

    /**
     * Construtor que recebe uma string como argumento e procede à criação de um tabuleiro do tipo 'char' e outro do tipo 'peca'
     * @param repr - uma string que representa uma configuração
     */
    public Tabuleiro(String repr) {
        this.repr = repr;
        size = (int) (Math.sqrt(repr.length()));
        board = new char[size][size];
        boardPecas = new Peca[size][size]; 
        int aux = 0;

        //converter a String em uma Matriz
        for (int i = 0; i < size; i++){ 
            for (int j = 0; j < size; j++){ 
                if(aux < repr.length())
                    board[i][j] = repr.charAt(aux);
                    //guardar os objetos 'rainha' e 'nada' na matriz
                    if (repr.charAt(aux) == 'D') {
                        boardPecas[i][j] = new Rainha(this, i, j, 'D', "Rainha");
                    }
                    else {
                        boardPecas[i][j] = new Nada(this, i, j, '-', "Nada");
                    } 
                aux++; 
            } 
        }
    }
    
    /**
     * Função que cria,no tabuleiro,uma nova peça nas coordenadas indicadas
     * @param linha - inteiro que representa a coordenada da linha em que pretendemos colocar a peça
     * @param coluna - inteiro que representa a coordenada da coluna em que pretendemos colocar a peça
     */
    public void colocarPeca(int linha, int coluna){
        boardPecas[linha][coluna] = new Rainha(this,linha,coluna,'D', "Rainha");
    }
    
    /**
     * Função que indica qual é a peca presente nas coordenadas indicadas
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return a peça nas coordenadas indicadas
     */
    public Peca peca(int linha, int coluna){
        return boardPecas[linha][coluna];
    }
    
    /**
     * Função que indica se a posição nas coordenadas indicadas está ameaçada por outras pessoas
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna -  inteiro que representa a coordenada da coluna
     * @return true se a posição estiver ameaçada por outras peças, caso contrário false
     */
    public boolean ameacada(int linha, int coluna){
        
        if(linha(linha).pecas() >= 2 || coluna(coluna).pecas() >= 2 || diagonalAscendente(linha, coluna).pecas() >= 2 || diagonalDescendente(linha, coluna).pecas() >= 2){
            return true;
        }
        else{
           return false; 
        }
    }

    /**
     * Função que obtem a linha na coordenada indicada
     * @param linha - inteiro que representa a coordenada da linha
     * @return a linha que está na coordenada indicada
     */
    private Linha linha(int linha){
        Linha linhaAtual = new Linha(this, linha);
        return linhaAtual;
    }

    /**
     * Função que obtem a coluna na coordenada indicada
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return a coluna que está na coordenada indicada
     */
    private Coluna coluna(int coluna){
        Coluna colunaAtual = new Coluna(this, coluna);
        return colunaAtual;
    }

    /**
     * Função que obtem a diagonal ascendente que passa nas coordenadas indicadas
     * @param linha - inteiro que representa a coordenada da linha
     * @param coluna - inteiro que representa a coordenada da coluna
     * @return a diagonal ascendente que passa nas coordenadas indicadas
     */
    private DiagonalAscendente diagonalAscendente(int linha, int coluna) {
        int number = linha + coluna;
        
        DiagonalAscendente diagonalAscendente = new DiagonalAscendente(this, number);
        return diagonalAscendente;
    }

    /**
     * Função que obtem a diagonal descendente que passa nas coordenadas indicadas
     * @param linha - coordenada da linha
     * @param coluna - coordenada da coluna
     * @return a diagonal descendente que passa nas coordenadas indicadas
     */
    private DiagonalDescendente diagonalDescendente(int linha, int coluna){
        int number = getSize() - 1 - (coluna - linha);
        
        DiagonalDescendente diagonalDescendente = new DiagonalDescendente(this, number);
        return diagonalDescendente;
    }

    /**
     * Função que verifica a validade da configuração de um tabuleiro
     * @return false se o tabuleiro tiver uma configuração errada , caso contrário , true
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
     * Função que obtem o valor do tamanho de cada lado do tabuleiro
     * @return um inteiro que representa o tamanho de cada lado do tabuleiro
     */
    private int getSize() {
        return (int) Math.sqrt(getLength());
    }

    /**
     * Função que obtem o valor do tamanho do tabuleiro
     * @return um inteiro que representa o tamanho do tabuleiro
     */
	public int getLength() {
		return repr.length();
    }

    /**
     * Função que obtem a configuração obtida em forma de um tabuleiro
     * @return um array bidimensional de char que representa o tabuleiro
     */
    public char[][] getBoard(){
        return board;
    }
}