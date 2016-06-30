package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 6/30/2016.
 */
public class Point {
    int xPos;
    int yPos;

    public Point(int xPos, int yPos){
        this.xPos=xPos;
        this.yPos=yPos;
    }

    public boolean equals(Object otherObject){
        if(otherObject==null) return false;
        else if(otherObject instanceof Point){
            Point other=(Point) otherObject;
            if(xPos==other.xPos && yPos==other.yPos){return true;}
        }
        return false;
    }
}
