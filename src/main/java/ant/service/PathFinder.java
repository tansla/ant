package ant.service;

import ant.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ant.model.Constans.*;

public class PathFinder {

    private static List<Coordinate> reachable;
    private static List<Coordinate> explored;
    private static List<Coordinate> thePath;
    private final Direction[] straightDirections = {Direction.RIGHT, Direction.DOWN,Direction.LEFT,Direction.UP};
    private static final Direction[] myDirections = {Direction.LEFT_DOWN,
            Direction.LEFT_UP,
            Direction.RIGHT_DOWN,
            Direction.RIGHT_UP,
            Direction.RIGHT,
            Direction.DOWN,
            Direction.LEFT,
            Direction.UP};


    public static void exploreTheMap(RandomField myField){
        reachable = new LinkedList<>();
        explored = new ArrayList<>();
        Coordinate startedPoint = myField.getStartPoint();
        reachable.add(startedPoint);
// create root
        MyTree root = new MyTree(startedPoint);
        myField.addTree(startedPoint,root);
        PathFinder.explore(myField,root);

        while (!reachable.isEmpty()) {
            MyTree nextPoint = PathFinder.chooseNextPoint(myField);
            if(nextPoint.getMe() == myField.getGoalPoint()){
                return;
            }
            PathFinder.explore(myField,nextPoint);

        }

        thePath = PathFinder.findThePath(myField);
    }

    private static MyTree chooseNextPoint(RandomField myField) {
        Coordinate c = reachable.get(0);
        return myField.getTree(c);
    }


    private static void explore(RandomField myField, MyTree leaf){
        Coordinate point = leaf.getMe();
        for (Direction d: myDirections //Direction.values()
        ) {
            Coordinate nextByPoint = point.findNextToByDirection(d);
            if(myField.getField(nextByPoint) !=  WALL
                    && !explored.contains(nextByPoint)
                    && !reachable.contains(nextByPoint)){
                MyTree child = new MyTree(leaf,nextByPoint);
                reachable.add(nextByPoint);
                myField.addTree(nextByPoint,child);
            }
            explored.add(point);
            reachable.remove(point);
        }
    }

    public static void drawMap(RandomField myField){
        List<Coordinate> path = findThePath(myField);
        for (Coordinate c: path) {
            if(myField.getField(c) == EMPTY) {
                myField.setCellValue(c, PATH);
            }
        }
    }

    private static List<Coordinate> findThePath(RandomField myField) {
        List<Coordinate> pathReversed = new LinkedList<>();
        Coordinate goal = myField.getGoalPoint();
        pathReversed.add(goal);

        Coordinate step = goal;
        while (step != myField.getStartPoint()){
            step = myField.getTree(step).getParent().getMe();
            pathReversed.add(step);
        }
        List<Coordinate> path = new LinkedList<>();

        for (int i = pathReversed.size()-1;i>=0;i--){
            path.add(pathReversed.remove(i));
        }

        path.remove(myField.getStartPoint());
        return  path;
    }


    public static void printThePath(){

        //List<Coordinate> path = findThePath(myField);
        System.out.println("Number of steps: " +thePath.size());
        System.out.println(thePath);


    }

    public static List<Coordinate> getThePath() {
        return thePath;
    }

    public static Coordinate getNextPoint() {
        return thePath.remove(0);
    }
}
