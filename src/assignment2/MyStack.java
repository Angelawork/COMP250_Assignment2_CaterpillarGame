package assignment2;

public class MyStack<E> {
    private MyDoublyLinkedList<E> myList;
    public MyStack(){
        myList=new MyDoublyLinkedList<E>();
    }
    public void push(E elmt){
        myList.addFirst(elmt);
    }
    public E pop() {
        return myList.removeFirst();
    }
    public E peek() {
        return myList.peekFirst();
    }
    public boolean isEmpty(){
        return myList.isEmpty();
    }
    public void clear(){
        myList.clear();
    }
    public int getSize(){
        return myList.getSize();
    }
}
