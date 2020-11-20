package ant.model;

import lombok.Data;

@Data
public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinate(int[] mass) {
        this.x = mass[0];
        this.y = mass[1];
    }

    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString() {
        return "[" + x +
                ", " + y +
                ']';
    }

    public Coordinate findNextToByDirection(Direction d){
        return new Coordinate(this.x + d.getX(), this.y + d.getY());
    }

    //крест вокруг клетки
    /**
     * * *
     x c *
     * * *
     */
    public Coordinate getLeft(){
        return new Coordinate(x-1, y);
    }
    /**
     * * *
     * c x
     * * *
     */
    public Coordinate getRight(){
        return new Coordinate(x+1, y);
    }
    /**
     * x *
     * c *
     * * *
     */
    public Coordinate getUp(){
        return new Coordinate(x, y-1);
    }
    /**
     * * *
     * c *
     * x *
     */
    public Coordinate getDown(){
        return new Coordinate(x, y+1);
    }

    // углы вокруг клетки

    /**
     x * *
     * c *
     * * *
     */
    public Coordinate getLeftUp(){
        return new Coordinate(x-1,y-1);
    }
    /**
     * * *
     * c *
     x * *
     */
    public Coordinate getLeftDown(){
        return new Coordinate(x-1,y+1);
    }
    /**
     * * x
     * c *
     * * *
     */
    public Coordinate getRightUp(){
        return new Coordinate(x+1,y-1);
    }
    /**
     * * *
     * c *
     * * x
     */
    public Coordinate getRightDown(){
        return new Coordinate(x+1,y+1);
    }

}
