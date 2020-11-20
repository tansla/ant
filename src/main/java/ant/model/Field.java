package ant.model;

import lombok.Data;

import java.util.Map;

import static ant.model.Constans.*;

@Data
public class Field {

    public static final int FIELD_LENGTH = 21;

 //   private final int[][] field = new int[FIELD_LENGTH][FIELD_LENGTH];
    private final Cell[][] field = new Cell[FIELD_LENGTH][FIELD_LENGTH];


    public Field() {
        for (int i = 0; i < FIELD_LENGTH; i++) {
            for (int j = 0; j < FIELD_LENGTH; j++) {
                field[i][j]    = new Cell();
            }
        }
    }


    public void addTree(Coordinate c,MyTree tree){
        field[c.getX()][c.getY()].setTreeLeaf(tree);
    }

    protected boolean isInside(Coordinate c) {
        return ((c.getX() >= 0 && c.getX() < FIELD_LENGTH) && (c.getY() >= 0 && c.getY() < FIELD_LENGTH));
    }

    public void setCellValue(Coordinate c , int value){
        if(!isInside(c)) {
            throw new IllegalArgumentException("Coordinates outside the Field" + c.getX()+"-"+c.getY());
        }
        field[c.getX()][c.getY()].setValue(value);

    }



    public int getField(Coordinate c) {
        return findCellValue(c);
    }
    public MyTree getTree(Coordinate c) {return field[c.getX()][c.getY()].getTreeLeaf();}

    protected int findCellValue(Coordinate c){
        if(!isInside(c)) {
            return WALL;
        }
        return  this.field[c.getX()][c.getY()].getValue();
    }

    public void print(String title) {
        System.out.println("---------- "+title+" start ---------");
        System.out.print("\t");
        for (int i = 0; i < FIELD_LENGTH; i++) {
            System.out.print("\t"+ String.format("%02d", i) );
        }
        System.out.println();
        for (int i = 0; i < FIELD_LENGTH; i++) {
            System.out.print(String.format("%02d", i) +" :");
            for (int j = 0; j < FIELD_LENGTH; j++) {
                String printValue;

                switch (field[j][i].getValue()) {
                    case EMPTY:
                        printValue = "   ";  // Пусто
                        break;
                    case WALL:
                        printValue = " # ";  // Препятствие
                        break;
                    case START:
                        printValue = "{@}";  // Препятствие
                        break;
                    case GOAL:
                        printValue = "{$}";  // Препятствие
                        break;
                    case PATH:
                        printValue = " . ";  // genm
                        break;
                    default:
                        printValue = String.valueOf(field[j][i]);


                }

                System.out.print("\t" + printValue);
            }
            System.out.println(" :\t" + i);
        }
        System.out.print("\t");
        for (int i = 0; i < FIELD_LENGTH; i++) {

            System.out.print("\t"+ String.format("%02d", i) );;
        }
        System.out.println();
        System.out.println("----------- "+title+" end ----------");
    }


}
