package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 6/30/2016.
 */
public class Circles {
    public double getAreaPub(){
        Circle circle=new Circle();
        return circle.area();
    }

    public void getAreaDef(){
        Circle circle=new Circle();
        circle.fillColor();
        circle.fillColor(3);
        circle.fillColor(1.2f);
    }
}
