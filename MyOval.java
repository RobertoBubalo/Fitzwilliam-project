package com.robertobubalo;
//By Roberto Bubalo 15.7.2017

import java.awt.*;

/**
 * Created by rober on 15/07/2017.
 */
public class MyOval {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    private Boolean flag;

    // constructor with no arguments
    public MyOval(){
        //setting the values using the set methodes
        setX1(0);
        setX2(2);
        setY1(0);
        setY2(0);
        setColor(Color.black);
        setFlag(false);
    }
    // constructor with all the arguments
    public MyOval(int x1, int x2, int y1, int y2, Color color, Boolean flag) {
        //setting the values using the set methodes instead assiging it locally
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setColor(color);
        setFlag(flag);
    }

    // checking which X coordinate is smaller and returning it
    // used for determining which value to use for drawing the shapes
    public int getUpperLeftX() {
        if (x1 > x2){
            return x2;
        }else{
            return x1;
        }
    }
    // checking which Y coordinate is smaller and returning it
    // used for determining which value to use for drawing the shapes
    public int getUpperLeftY(){
        if(y1 > y2){
            return y2;
        }else{
            return y1;
        }
    }
    // getting absolute X value
    public int getWidth(){
        if( x1> x2){
            return Math.abs(x2-x1);
        }else{
            return Math.abs(x1-x2);
        }

    }
    // getting absolute Y value
    public int getHeight(){
        if (y1>y2){
            return Math.abs(y2-y1);
        }else{
            return Math.abs(y1-y2);
        }

    }

    // all the basic getters below
    public Color getColor() {
        return color;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Boolean getFlag() {
        return flag;
    }

    // getters finished


    // all the basic setters below
    public void setX1(int x1) {
        if (x1 >= 0)    // checking if value is smaller than 0, if it is setting it to 0 with else
            this.x1 = x1;
        else
            this.x1 = 0;
    }

    public void setY1(int y1) {
        if (y1 >= 0)    // checking if value is smaller than 0, if it is setting it to 0 with else
            this.y1 = y1;
        else
            this.y1 = 0;
    }

    public void setX2(int x2) {
        if (x2 >= 0)    // checking if value is smaller than 0, if it is setting it to 0 with else
            this.x2 = x2;
        else
            this.x2 = 0;
    }

    public void setY2(int y2) {
        if (y2 >= 0)    // checking if value is smaller than 0, if it is setting it to 0 with else
            this.y2 = y2;
        else
            this.y2 = 0;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void draw( Graphics g )
    {
        g.setColor( getColor() );

        if( getFlag() == true){ // checking the flag boolean for filled property
            g.fillOval( getX1(), getY1(), getX2(), getY2() );
        }else
            g.drawOval( getX1(), getY1(), getX2(), getY2() );

    }
}
