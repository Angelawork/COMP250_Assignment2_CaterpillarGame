package assignment2;

import java.util.Iterator;

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
        if(input instanceof MyQueue){
            return this.myList.equals(((MyQueue<E>) input).myList);//does this casting cause any error?
        }else{return false;}

    }

}
