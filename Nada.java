/**
 * Class Nada que herda a Class Peca
 * Representa que tipo de peça e o vazio
 */
public class Nada extends Peca{

    public Nada(final Tabuleiro tab, final int linha, final int coluna) {
        super(tab, linha, coluna);
    }
    
    @Override
    public boolean vazia(){
        return true;
    }

    @Override
    public boolean podeIrPara(int linha, int coluna){
        return true;
    }
}