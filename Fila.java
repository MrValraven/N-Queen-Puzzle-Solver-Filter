/**
 * Interface Fila que representa o que é uma fila do tabuleiro e os seus atributos comuns
 * 
 */
public interface Fila {
    
    /**
     * Função que obtem o tamanho de uma fila
     * @return um inteiro que represente o tamanho de uma fila
     */
    public abstract int comprimento();

    /**
     * Função que obtem o número de peças existentes numa fila
     * @return um inteiro que representa a quantidade de peças existentes numa fila
     */
    public abstract int pecas();

    /**
     * Função que obtem a peça que se encontra numa determinada posição de uma fila
     * @param pos - inteiro que representa a posição da fila 
     * @return a peça que se encontra na posição dada
     * @throws IndexOutOfBoundsException - se o valor de 'pos' não existir na fila é dada esta exceção
     */
    public abstract Peca peca(int pos) throws IndexOutOfBoundsException;
}