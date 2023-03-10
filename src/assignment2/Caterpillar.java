package assignment2;


public class Caterpillar extends MyDoublyLinkedList<Position>{
    public Caterpillar(){
        Position temp=new Position(7,7);
        this.addFirst(temp);
    }
    public Position getHead(){//head position
        return this.peekFirst();
    }
    public void eat(Position input){
        if(Position.getDistance(input,this.getHead())!=1){
            throw new IllegalArgumentException("Input not orthogonally adjacent to head!");
        }
        this.addFirst(input);
    }
    public void move(Position input){
        if(Position.getDistance(input,this.getHead())!=1){
            throw new IllegalArgumentException("Input not adjacent to head!");
        }
        this.addFirst(input);
        this.removeLast();
    }
    public boolean selfCollision(Position input){

        for(Position temp:this){
            if(temp.equals(input)){
                return true;
            }
        }

        return false;
    }
}
