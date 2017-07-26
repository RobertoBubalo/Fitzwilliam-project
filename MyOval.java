package com.robertobubalo;
//By Roberto Bubalo 15.7.2017

import java.awt.*;

/**
 * Created by rober on 15/07/2017.
 */
public class MyOval extends  MyShape{

    private Boolean flag;

    // constructor with no arguments
    public MyOval(){
        super();
        setFlag(false);
    }
    // constructor with all the arguments
    public MyOval(int x1, int x2, int y1, int y2, Color color, Boolean flag) {
        //setting the values using the set methodes instead assigning it locally
        super(x1, y1, x2, y2, color);
        setFlag(flag);
    }

    // checking which X coordinate is smaller and returning it
    // used for determining which value to use for drawing the shapes
    public int getUpperLeftX() {
        if (getX1() > getX2()){
            return getX2();
        }else{
            return getX1();
        }
    }
    // checking which Y coordinate is smaller and returning it
    // used for determining which value to use for drawing the shapes
    public int getUpperLeftY(){
        if(getY1() > getY2()){
            return getY2();
        }else{
            return getY1();
        }
    }
    // getting absolute X value
    public int getWidth(){
        if( getX1()> getX2()){
            return Math.abs(getX2()-getX1());
        }else{
            return Math.abs(getX1()-getX2());
        }

    }
    // getting absolute Y value
    public int getHeight(){
        if (getY1()>getY2()){
            return Math.abs(getY2()-getY1());
        }else{
            return Math.abs(getY1()-getY2());
        }

    }

    public Boolean getFlag() {
        return flag;
    }
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public void draw( Graphics g )
    {
        g.setColor( getColor() );

        if( getFlag() == true){ // checking the flag boolean for filled property
            g.fillOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()  );
        }else
            g.drawOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()  );

    }
}
