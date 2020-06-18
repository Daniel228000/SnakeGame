package core;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    private List<Integer> wallListX = new ArrayList<>();
    private List<Integer> wallListY = new ArrayList<>();
    private List<Cell> wallOne = new ArrayList<>();
    private List<Pair<Integer, Integer>> pairList = new ArrayList<>();
    private List<Cell> wallList = new ArrayList<>();
    private List<Cell> cellList = new ArrayList<>();
    private Cell cell;

    public Wall() {

    }
    public void convertCellsToCoordinateX(List<Integer> wallX, List<Cell> wallList){
        for( Cell cell: wallList) {
            wallX.add(cell.x);
        }

    }
    public void convertCellsToCoordinateY(List<Integer> wallY, List<Cell> wallList){
        for( Cell cell: wallList) {
            wallY.add(cell.y);
        }
    }

    public void addConvertedWallToCells( List<Cell> walls, List<Cell> wall) {
        walls.addAll(wall);
    }
    //public void convertToPair(List<Integer> wallX, List<Integer> wallY) {
    //    for (int i = 0; i < wallX.size(); i++) {
    //        point = new Point(wallX.get(i), wallY.get(i));
    //        pointList.add(point);}//= new Point(wallX.get(i), wallY.get(i));
    //}

    public List<Cell> getWallOne(){return wallOne;}
    public List<Integer> getWallListX() {return wallListX;}
    public List<Integer> getWallListY() {return wallListY;}
    public void setWallOne() {
        wallOne.add(new Cell(30, 2));
        //wallOne.add(new Cell(7, 7));
        //wallOne.add(new Cell(7, 8));


    }
public List<Cell> finalWall() {
        setWallOne();
        addConvertedWallToCells(cellList, wallOne);
        //convertCellsToCoordinateX(wallListX, wallOne);
        //convertCellsToCoordinateY(wallListY, wallOne);
        //convertToPair(getWallListX(), getWallListY());
        return cellList;
    }

    public void setWallOne(List<Cell> wallOne) {
        this.wallOne = wallOne;
    }
}

