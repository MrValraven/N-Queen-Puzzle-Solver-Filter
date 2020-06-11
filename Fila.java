/**
 * <p> Interface Fila <p> 
 * Representa o que e uma fila do tabuleiro e os seus atributos comuns
 * 
 */
public interface Fila {
    
    /**
     * Funcao que obtem o tamanho de uma fila
     * @return um inteiro que represente o tamanho de uma fila
     */
    public abstract int comprimento();

    /**
     * Funcao que obtem o número de peças existentes numa fila
     * @return um inteiro que representa a quantidade de peças existentes numa fila
     */
    public abstract int pecas();

    /**
     * Funcao que obtem a peça que se encontra numa determinada posicao de uma fila
     * @param pos - inteiro que representa a posicao da fila 
     * @return a peça que se encontra na posicao dada
     * @throws IndexOutOfBoundsException - se o valor de 'pos' não existir na fila e dada esta excecao
     */
    public abstract Peca peca(int pos) throws IndexOutOfBoundsException;
}