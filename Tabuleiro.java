public class Tabuleiro {
    private String repr;
    private int size;
    private char[][] board;
    private Peca[][] boardPecas;

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
                    //guardar os objetos rainha e nada na matriz
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
    
    public void colocarPeca(int linha, int coluna){
        boardPecas[linha][coluna] = new Rainha(this,linha,coluna,'D', "Rainha");
    }
       
    public Peca peca(int linha, int coluna){
        return boardPecas[linha][coluna];
    }
        
    public boolean ameacada(int linha, int coluna){
        
        if(linha(linha).pecas() >= 2 || coluna(coluna).pecas() >= 2 || diagonalAscendente(linha, coluna).pecas() >= 2 || diagonalDescendente(linha, coluna).pecas() >= 2){
            return true;
        }
        else{
           return false; 
        }
    }

    private Linha linha(int linha){
        Linha linhaAtual = new Linha(this, linha);
        return linhaAtual;
    }

    public Coluna coluna(int coluna){
        Coluna colunaAtual = new Coluna(this, coluna);
        return colunaAtual;
    }

    public DiagonalAscendente diagonalAscendente(int linha, int coluna) {
        int number = linha + coluna;
        
        DiagonalAscendente diagonalAscendente = new DiagonalAscendente(this, number);
        return diagonalAscendente;
    }

    public DiagonalDescendente diagonalDescendente(int linha, int coluna){
        int number = getSize() - 1 - (coluna - linha);
        
        DiagonalDescendente diagonalDescendente = new DiagonalDescendente(this, number);
        return diagonalDescendente;
    }

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

    private int getSize() {
        return (int) Math.sqrt(getLength());
    }

	public int getLength() {
		return repr.length();
    }
    
    public char[][] getBoard(){
        return board;
    }
}