package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 6/30/2016.
 */
public class Square extends Shape{
    private int side;

    public Square (int side){
        this.side=side;
    }

    public double area(){
        return (double) side*side;
    }
}
