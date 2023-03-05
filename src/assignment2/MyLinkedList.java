package assignment2;

public abstract class MyLinkedList<E> implements MyList<E> {
    protected int size;
    public int getSize(){
        return size;
    }
    @Override
    public boolean isEmpty() { //whether the list is empty?
        return size==0;
    }
    //only need to implement methods getSize and isEmpty?
}
