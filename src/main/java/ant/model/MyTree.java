package ant.model;

import java.util.ArrayList;
import java.util.List;

public class MyTree {
    private MyTree parent;
    private Coordinate me;
    private List<MyTree> children = new ArrayList<>();
    private int level;


    public MyTree(Coordinate me) {
        this.me = me;
        this.parent = null;
        this.level = 0;
    }


    public MyTree(MyTree parent, Coordinate me) {
        this.parent = parent;
        this.me = me;
        this.level = parent.level+1;
        parent.addChildren(this);
    }

    public MyTree getParent() {
        return parent;
    }

    protected void addChildren(MyTree children) {
        this.children.add(children);
    }

    public List<MyTree> getChildren() {
        return children;
    }

    public boolean isNode(){
        return parent == null;
    }

    public Coordinate getMe() {
        return me;
    }

    public boolean isLeaf(){
        return children.size() == 0;
    }

    public List<MyTree> getSiblings(MyTree tree){
        MyTree parent = tree.getParent();
        List<MyTree> siblings = parent.getChildren();
        siblings.remove(tree);
        return siblings;
    }

    public int getLevel() {
        return level;
    }
}
