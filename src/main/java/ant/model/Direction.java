package ant.model;


public enum Direction {
    RIGHT(1,0),
    LEFT(-1,0),
    UP(0,-1),
    DOWN(0,1),
    LEFT_UP(-1,-1),
    LEFT_DOWN(-1,1),
    RIGHT_UP(1,-1),
    RIGHT_DOWN(1,1);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
