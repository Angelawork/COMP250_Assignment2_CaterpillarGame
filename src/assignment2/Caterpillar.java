package assignment2;

import java.util.Iterator;

public class Caterpillar extends MyDoublyLinkedList<Position>{
    public Caterpillar(){//initial size=1?
        Position temp=new Position(7,7);
        this.addFirst(temp);
    }
    public Position getHead(){//head position
        return this.peekFirst();
    }
    public void eat(Position input){//orthogonally adjacent to the current?
        if(Position.getDistance(input,this.getHead())!=1){
            throw new IllegalArgumentException("Input not orthogonally adjacent to head!");
        }
        this.addFirst(input);
    }
    public void move(Position input){//adjacent to the current head?
        if(Position.getDistance(input,this.getHead())!=1 && Position.getDistance(input,this.getHead())!=2){
            throw new IllegalArgumentException("Input not adjacent to head!");
        }
        this.addFirst(input);
        this.removeLast();
    }
    public boolean selfCollision(Position input){ //check overlap position?
        Iterator<Position> iter=this.iterator();
        Position temp;

        while(iter.hasNext()){
            temp=iter.next();
            if(temp.equals(input)){
                return true;
            }
        }
        return false;
    }
}
