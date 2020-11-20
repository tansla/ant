package ant.model;

import lombok.Data;

@Data
public class Cell {

    private int value;
    private MyTree treeLeaf;

    public Cell() {
        this.value = 0;
        this.treeLeaf = null;
    }

    public void setTreeLeaf(MyTree treeLeaf) {
        this.treeLeaf = treeLeaf;
    }

    public MyTree getTreeLeaf() {
        return treeLeaf;
    }
}
