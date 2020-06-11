/**
 * <p> Class Rainha que herda a Class Peca <p>
 * Representa que tipo de peça e uma Rainha
 */
public class Rainha extends Peca {
    private String nome = "Rainha";

    public Rainha(final Tabuleiro tab, final int linha, final int coluna) {
        super(tab, linha, coluna);
    }

    @Override
    public String toString(){
        return nome;
    }

    @Override
    public boolean vazia(){
        return false;
    }
}