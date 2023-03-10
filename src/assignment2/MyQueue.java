package assignment2;

public class MyQueue<E>{
    private MyDoublyLinkedList<E> myList;
    public MyQueue(){
        myList=new MyDoublyLinkedList<E>();
    }
    public void enqueue(E elmt){
        myList.addLast(elmt);
    }
    public E dequeue(){
        return myList.removeFirst();
    }
    public boolean isEmpty(){
        return myList.isEmpty();
    }
    public void clear(){
        myList.clear();
    }

    public boolean equals(Object input){
        if(input instanceof MyQueue)//don't need the generics when using instanceof
        { return this.myList.equals(((MyQueue<?>) input).myList);}
        else{return false;}
    }

}
