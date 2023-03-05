package assignment2;

public interface MyList<E> extends Iterable<E>{
    public int getSize();
    public boolean isEmpty();
    public void add(E elmt);
    public void clear();
    public E remove();
}
