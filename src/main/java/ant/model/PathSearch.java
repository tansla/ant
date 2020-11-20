/*
package ant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ant.model.Constans.EMPTY;

public class PathSearch {

    private RandomField myField;

    private MyTree path;
    private List<Coordinate> reachable = new ArrayList<>();
    private List<Coordinate> explored = new ArrayList<>();

   // private Map<Coordinate,MyTree> treeStorage = new HashMap<>();

    public PathSearch(RandomField myField) {
        this.myField = myField;
        this.path =  new MyTree(myField.getStartPoint());
        this.reachable.add(myField.getStartPoint());
      //  this.treeStorage.put(myField.getStartPoint(),path);
    }


    private void addChildren(MyTree leaf){
        for (Direction d: Direction.values()) {
            Coordinate point = leaf.getMe();
            Coordinate nextByPoint = point.findNextToByDirection(d);
            if(myField.getField(nextByPoint) ==  EMPTY
                    && !explored.contains(nextByPoint)){
                new MyTree(leaf,nextByPoint);
                reachable.add(nextByPoint);
            }
        }
    }

    public MyTree chooseNextLeaf(MyTree currentLeaf) {
        MyTree parent = currentLeaf.getParent();
        List<MyTree> siblings = currentLeaf.getSiblings();
        for (MyTree tree:siblings) {
            if (!explored.contains(tree.getMe())) {
                return tree;
            }
        }

        List<MyTree> children = currentLeaf.getChildren();
        return null;

    }


    public void drawTree() {

        MyTree currentLeaf = path;

        while (!reachable.isEmpty()) {
            if (currentLeaf.getMe() == myField.getGoalPoint()) {
              //  return true;
            } else {
                Coordinate point = currentLeaf.getMe();
                reachable.remove(point);
                addChildren(currentLeaf);
                explored.add(point);
                //currentLeaf = currentLeaf.chooseNextLeaf(currentLeaf);
                }
            }

        }


}
*/
