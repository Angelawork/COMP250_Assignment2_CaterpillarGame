package assignment2;

public class Region {
    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;
    public Region(int xMin,int yMin,int xMax,int yMax){
        this.xMin=xMin;
        this.yMin=yMin;
        this.xMax=xMax;
        this.yMax=yMax;
    }
    public boolean contains(Position input){
        int x=input.getX();
        int y=input.getY();
        return((x<=this.xMax)&&(x>=this.xMin)&&(y<=this.yMax)&&(y>=this.yMin));
    }
}
