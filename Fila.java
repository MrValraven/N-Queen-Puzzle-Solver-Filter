public interface Fila {
    public abstract int comprimento();
    public abstract int pecas();
    public abstract Peca peca(int pos) throws IndexOutOfBoundsException;
}