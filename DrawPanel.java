package com.robertobubalo;
//By Roberto Bubalo 15.7.2017
// Program uses class MyLine to draw random lines.

        import sun.plugin2.util.ColorUtil;

        import java.awt.Color;
        import java.awt.Graphics;
        import java.util.Random;
        import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
    private Random randomNumbers = new Random();
    private MyLine lines[]; // array on lines
    private MyRect rects[]; // array on rectangles
    private MyOval ovals[]; // array on ovals

    // constructor, creates a panel with random shapes
    public DrawPanel()
    {
        setBackground( Color.WHITE );

        lines = new MyLine[ 1 + randomNumbers.nextInt( 5 ) ];
        rects = new MyRect[ 1 + randomNumbers.nextInt(5)];
        ovals = new MyOval[ 1 + randomNumbers.nextInt(5)];



        // create lines
        for ( int count = 0; count < lines.length; count++ )
        {
            // generate random coordinates
            int x1 = randomNumbers.nextInt( 300 );
            int y1 = randomNumbers.nextInt( 300 );
            int x2 = randomNumbers.nextInt( 300 );
            int y2 = randomNumbers.nextInt( 300 );

            // generate a random color
            Color color = new Color( randomNumbers.nextInt( 256 ),
                    randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ) );

            // add the line to the list of lines to be displayed
            lines[ count ] = new MyLine( x1, y1, x2, y2, color );
        } // end for

        // create rectangles
        for ( int count = 0; count < rects.length; count++ )
        {
            // generate random coordinates
            int x1 = randomNumbers.nextInt( 300 );
            int y1 = randomNumbers.nextInt( 300 );
            int x2 = randomNumbers.nextInt( 300 );
            int y2 = randomNumbers.nextInt( 300 );

            // generate a random color
            Color color = new Color( randomNumbers.nextInt( 256 ),
                    randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ) );

            // add the line to the list of lines to be displayed
            rects[ count ] = new MyRect( x1, y1, x2, y2, color, randomNumbers.nextBoolean() );
        } // end for

        // create Ovals
        for ( int count = 0; count < ovals.length; count++ )
        {
            // generate random coordinates
            int x1 = randomNumbers.nextInt( 300 );
            int y1 = randomNumbers.nextInt( 300 );
            int x2 = randomNumbers.nextInt( 300 );
            int y2 = randomNumbers.nextInt( 300 );

            // generate a random color
            Color color = new Color( randomNumbers.nextInt( 256 ),
                    randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ) );

            // add the line to the list of lines to be displayed
            // random boolean to see if the shape is empty or filled
            ovals[ count ] = new MyOval( x1, y1, x2, y2, color, randomNumbers.nextBoolean() );
        } // end for

    } // end DrawPanel constructor

    // method for south jlabel property
    public String getStatusText(){
        return "Lines: " + lines.length + ", Ovals: " + ovals.length + ", Rectangles: " + rects.length;
    }

    // for each shape array, draw the individual shapes
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        // draw the lines
        for ( MyLine line : lines )
            line.draw( g );
        // draw the rectangles
        for ( MyRect rect : rects)
            rect.draw( g );
        // draw the ovals
        for ( MyOval oval : ovals)
            oval.draw( g );


    } // end method
} // end class