/**
 * Class Nada que herda a Class Peca
 * Representa que tipo de peça e o vazio
 */
public class Nada extends Peca{
    private String nome = "Nada";
    public Nada(final Tabuleiro tab, final int linha, final int coluna) {
        super(tab, linha, coluna);
    }

    @Override
    public String toString(){
        return nome;
    }
    
    @Override
    public boolean vazia(){
        return true;
    }
}