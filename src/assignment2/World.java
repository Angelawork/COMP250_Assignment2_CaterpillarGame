package assignment2;

public class World {
    private Caterpillar player;
    private Position food;
    private Region map;
    private ActionQueue actions;
    private TargetQueue targets;
    private GameState myGame;
    public World(TargetQueue t,ActionQueue a){
        this.targets=t;
        this.actions=a;
        this.map=new Region(0,0,15,15);
        this.player=new Caterpillar();
        this.food=this.targets.dequeue();
        this.myGame=GameState.MOVE;
    }
    public void step(){
        //1
        if(this.actions.isEmpty()){this.myGame=GameState.NO_MORE_ACTION;}
        else {
            Direction direction = this.actions.dequeue();

            //2
            if (this.myGame != GameState.MOVE && this.myGame != GameState.EAT) {
                return;
            }

            //3
            Position curr = this.player.getHead();
            Position towards = new Position(curr);
            switch (direction) {
                case EAST:
                    towards.moveEast();
                    break;
                case WEST:
                    towards.moveWest();
                    break;
                case NORTH:
                    towards.moveNorth();
                    break;
                case SOUTH:
                    towards.moveSouth();
                    break;
            }

            if (!map.contains(towards)) {
                this.myGame = GameState.WALL_COLLISION;
            } else if (this.player.selfCollision(towards)) {
                this.myGame = GameState.SELF_COLLISION;
            } else if (towards.equals(food)) {
                this.player.eat(towards);
                if (this.targets.isEmpty()) {this.myGame = GameState.DONE;} //this step is included in this else-if?
                else {
                    this.food = this.targets.dequeue();
                    this.myGame = GameState.EAT;
                }
            } else {
                this.player.move(towards);
                this.myGame = GameState.MOVE;
            }
        }
    }
    public GameState getState(){
        return this.myGame;
    }
    public Caterpillar getCaterpillar(){
        return this.player;
    }
    public Position getFood(){
        return this.food;
    }
    public boolean isRunning(){
        return (this.myGame==GameState.EAT || this.myGame==GameState.MOVE);
    }
}
