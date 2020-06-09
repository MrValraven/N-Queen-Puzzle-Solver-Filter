public class Rainha extends Peca {
    private Tabuleiro tabuleiro;

    public Rainha(final Tabuleiro tab, final int linha, final int coluna, char id, String name) {
        super(tab, linha, coluna, id, name);
        id = 'D';
        name = "Rainha";

    }

    @Override
    public boolean vazia(){
        return false;
    }

    @Override
    public boolean podeIrPara(final int linha, final int coluna){
        if(tabuleiro.ameacada(linha, coluna) == true){
            return false;
        }
        else{
            return true;
        }
        
    }
    
}