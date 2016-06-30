package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 6/30/2016.
 */
public class Circle extends Shape{
    private int xPos;
    private int yPos;
    private int radius;

    public Circle(){
        xPos=0;
        yPos=0;
        radius=1;
    }

    public Circle(int radius){
        this.radius=radius;
    }

    public Circle(int xPos, int yPos){
        this.xPos=xPos;
        this.yPos=yPos;
    }

    public Circle(int radius, int xPos, int yPos){
        this.radius=radius;
        this.xPos=xPos;
        this.yPos=yPos;
    }

    public double area(){
        return (double) radius*radius*Math.PI;
    }

    public String toString(){
        return "center=("+xPos+" , "+yPos+") and radius = "+radius;
    }

    public void fillColor(){
        System.out.println("The circle color is now "+super.color);
    }

    public void fillColor(int color){
        super.color=color;
        System.out.println("The circle color is now "+super.color);
    }

    public void fillColor(float saturation){
        super.saturation=saturation;
        System.out.println("The circle saturation is now "+super.saturation);
    }
}
