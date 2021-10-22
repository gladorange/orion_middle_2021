package com.orion.lection.lesson3.defaultparameters;

public class MoveablePoint {
    final int x;
    final int y;

    public MoveablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public MoveablePoint getNewPoint(int deltaX,int deltaY) {
        return new MoveablePoint(x + deltaX, y + deltaY);
    }

    public MoveablePoint getNewPoint(int deltaX) {
        return getNewPoint(deltaX, 0);
    }


    public static void main(String[] args) {
        MoveablePoint initialPoint = new MoveablePoint(0, 10);

        initialPoint.getNewPoint(10, 0);
        initialPoint.getNewPoint(10);
    }
}
