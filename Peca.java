public abstract class Peca {
    private Tabuleiro tab;
    private int linha;
    private int coluna;
    private char id;
    private String name;

    public abstract boolean podeIrPara(int linha, int coluna​);
    public abstract boolean vazia();

    final boolean ataca(Peca vitima){
        return podeIrPara(vitima.getLinha(), vitima.getColuna()); 
    }
    
    Peca(Tabuleiro tab, int linha, int coluna, char id, String name){
        this.tab = tab;
        this.linha = linha;
        this.coluna = coluna;
        this.id = id;
        this.name = name;
    }

    public Tabuleiro getTab(){
        return this.tab;
    }

    public int getLinha(){
        return this.linha;
    }

    public int getColuna() {
        return this.coluna;
    }

     public char getId() {
        return this.id;
    }

     public String getName() {
        return this.name;
    }
}