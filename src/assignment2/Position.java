package assignment2;

public class Position {
    private int x;
    private int y;
    public Position(int xCoord, int yCoord){
        this.x=xCoord;
        this.y=yCoord;
    }
    public Position(Position input){
        this.x=input.x;
        this.y=input.y;
    }
    public void reset(int xCoord, int yCoord){
        this.x=xCoord;
        this.y=yCoord;
    }
    public void reset(Position input){
        this.x=input.x;
        this.y=input.y;
    }
    public static int getDistance(Position input1,Position input2){ //calculation?
        int result=Math.abs(input1.x-input2.x)+Math.abs(input1.y-input2.y);
        return result;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void moveWest(){
        this.x--;
    }
    public void moveEast(){
        this.x++;
    }
    public void moveNorth(){
        this.y--;
    }
    public void moveSouth (){
        this.y++;
    }
    public boolean equals(Object input){
        if(input instanceof Position){
            return (this.x==((Position) input).getX() && this.y==((Position) input).getY());
        } else return false;
    }
}
