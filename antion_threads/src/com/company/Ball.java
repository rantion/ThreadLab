package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/23/13
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */

public class Ball {

    int xLoc = 0;
    int yLoc = 0;
    int xdir = 10;
    int ydir = 10;
    int size = 50;
    int delay = 50;
    JComponent parent;

    public Ball(JComponent parent){
        this.parent = parent;
    }

    public void paint(Graphics g){
        g.fillOval(xLoc, yLoc, size, size);

    }

    void move(){
        if (xLoc+xdir > parent.getWidth()-(size*.75) || xLoc+xdir <= -(size*.25)) xdir *= -1;
        xLoc += xdir;
        if (xLoc > parent.getWidth()) xLoc -= size*2;
        if (yLoc+ydir > parent.getHeight()-(size*.75) || yLoc+ydir <= -(size*.25)) ydir *= -1;
        yLoc += ydir;
        if (yLoc > parent.getHeight()) yLoc -= size*2;
    }
}
