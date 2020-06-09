public class Nada extends Peca{

    public Nada(final Tabuleiro tab, final int linha, final int coluna, char id, String name) {
        super(tab, linha, coluna, id, name);
        id = '-';
        name = "Nada";
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