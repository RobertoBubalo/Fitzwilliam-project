package com.robertobubalo;
//By Roberto Bubalo 1.8.2017
// Program uses class MyShape abstract method Draw which is overriden further for each
// specific shape type to draw

        import java.awt.Color;
        import java.awt.Graphics;
        import java.util.Random;
        import javax.swing.*;


public class DrawPanel extends JPanel
{
    private Random randomNumbers = new Random();

    private MyShape randomShapes[]; // myshape array saving all the shapes
    private int counter[] = new int[]{0,0,0};   // int array used for saving information how many objects of which type were created
    private Boolean textError= false;   // extra functionality in case of wrong input

    // constructor, creates a panel with random shapes
    public DrawPanel()
    {
        // opening inputDialog to check how many shapes should we generate
        String popup= JOptionPane.showInputDialog("Please input a number how many \nshapes you would like to create: " +
                "\n Press cancel to random.");


        setBackground( Color.WHITE );


        // added extra functionality if cancel is pressed
        if(popup==null)
        {
           // getting random length of array, min 3 max 18
        randomShapes = new MyShape[3 + randomNumbers.nextInt(15)];
        }else if(popup.matches("[0-9]*")){
            // setting the inputed number as a array size
            randomShapes = new MyShape[Integer.valueOf(popup)];
        }
        else{
            // not creating any shapes because invalid input
           randomShapes = new MyShape[0];
            textError = true;
        }



        // looping through array
        for (int count = 0; count < randomShapes.length; count++){
            // random generator to determine which shape will be created
            int a = randomNumbers.nextInt(3);
            // generating all the coordinates and color
            int x1 = randomNumbers.nextInt( 300 );
            int y1 = randomNumbers.nextInt( 300 );
            int x2 = randomNumbers.nextInt( 300 );
            int y2 = randomNumbers.nextInt( 300 );
            Color color = new Color( randomNumbers.nextInt( 256 ),
                    randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ) );

            switch (a){
                case 0: // case 0 where we create a line
                    randomShapes[ count ] = new MyLine( x1, y1, x2, y2, color );
                    counter[0] +=1;
                    break;
                case 1: // case 1 where we create rectangle
                    randomShapes[ count ] = new MyRect( x1, y1, x2, y2, color, randomNumbers.nextBoolean() );
                    counter[1] +=1;
                    break;
                case 2: // case 2 where we create oval
                    randomShapes[ count ] = new MyOval( x1, y1, x2, y2, color, randomNumbers.nextBoolean() );
                    counter[2] +=1;
                    break;

            }   // end switch

        }   // end for


    } // end DrawPanel constructor

    // method for south jlabel property
    public String getStatusText(){
        return "Lines: " + counter[0] + ", Ovals: " + counter[1] + ", Rectangles: " + counter[2];
    }

    //
    public Boolean getTextError() {
        return textError;
    }

    // for each shape array, draw the individual shapes
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
            // go through myShape array and draw needed shape using polymorphism
        for (MyShape myShape : randomShapes)
            myShape.draw( g );



    } // end method
} // end class