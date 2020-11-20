package ant.model;

import lombok.Data;
import static ant.model.Constans.*;
import java.util.Random;

@Data
public class RandomField extends Field {

    private final Random myRandom = new Random();
    private Coordinate startPoint;
    private Coordinate goalPoint;



    protected void setShip(int length) {
        Coordinate[] ship = new Coordinate[length];

        do {
            int x = myRandom.nextInt(FIELD_LENGTH);
            int y = myRandom.nextInt(FIELD_LENGTH);
            boolean isHorizontal = myRandom.nextBoolean();
            ship[0] = new Coordinate(x, y);
            for (int i = 1; i < length; i++) {
                if(isHorizontal) {
                    ship[i] = ship[i-1].getRight();
                } else {
                    ship[i] = ship[i-1].getDown();
                }
            }
        } while (!isPlaceAvailable(ship));

        fillCoordinates(ship);
    }

    private boolean isCellAvailable(Coordinate c) {
        if (!isInside(c)) return false;
        for(Direction d:Direction.values()) {
            if(findCellValue(c.findNextToByDirection(d))!= EMPTY
                    && isInside(c.findNextToByDirection(d))) return false;
        }
        return true;
    }

    protected boolean isPlaceAvailable(Coordinate[] ship) {
        for (Coordinate eachShip: ship ) {
            if(!isCellAvailable(eachShip) ) return false;
        }
        return true;
    }

    protected void fillCoordinates(Coordinate[] ship) {
        for(Coordinate eachShip: ship) {
            this.setCellValue(eachShip, WALL);
        }
    }

    public void fillMap(int[][] map){
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                int c = map[i][j];
                if (c == 1){
                    this.setCellValue(new Coordinate(i,j), WALL);
                }
            }

        }
    }

    public Coordinate getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Coordinate startPoint) {
        this.startPoint = startPoint;
        this.setCellValue(startPoint, START);
    }

    public Coordinate getGoalPoint() {
        return goalPoint;

    }

    public void setGoalPoint(Coordinate goalPoint) {
        this.goalPoint = goalPoint;
        this.setCellValue(goalPoint, GOAL);
    }

    // 1. random for tests.
    public void initTestMap() {
        // Start point:
        startPoint = new Coordinate(myRandom.nextInt(FIELD_LENGTH)
                ,myRandom.nextInt(FIELD_LENGTH));
        this.setCellValue(startPoint, START);


        // The Goal:
        goalPoint = new Coordinate(myRandom.nextInt(FIELD_LENGTH)
                ,myRandom.nextInt(FIELD_LENGTH));

        this.setCellValue(goalPoint, GOAL);


        // Set walls:
        for (int i=0; i<4;i++){
            this.setShip(5);
        }

        for (int i=0; i<2;i++){
            this.setShip(4);
        }

        for (int i=0; i<2;i++){
            this.setShip(7);
        }
        for (int i=0; i<10;i++){
            this.setShip(2);
        }
        for (int i=0; i<10;i++){
            this.setShip(1);
        }

    }

    public void newGoal(){
        Coordinate somePoint;
        do {
            int x = myRandom.nextInt(FIELD_LENGTH);
            int y = myRandom.nextInt(FIELD_LENGTH);
            somePoint = new Coordinate(x, y);

        } while (!isCellAvailable(somePoint));

        if (this.findCellValue(goalPoint) == GOAL){
            this.setCellValue(goalPoint, EMPTY);
        }
        goalPoint = somePoint;
        this.setCellValue(somePoint, GOAL);
    }

}

