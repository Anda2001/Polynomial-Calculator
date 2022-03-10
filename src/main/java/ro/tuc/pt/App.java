package ro.tuc.pt;

import ro.tuc.pt.gui.View;

import javax.swing.*;
import java.awt.*;

public class App
{
    public static void main( String[] args )
    {

        JFrame frame = new View("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
