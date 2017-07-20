package com.robertobubalo;
//By Roberto Bubalo 15.7.2017


import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel();
        JFrame application = new JFrame();

        // creating the status bar
        JLabel statusBar = new JLabel();

        // using get method to get the needed string from DrawPanel class
        statusBar.setText(panel.getStatusText());

        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.add( panel );
        application.setSize( 600, 600 );
        application.setVisible( true );

        // adding the label to the frame
        application.add(statusBar, BorderLayout.SOUTH);
    }
}