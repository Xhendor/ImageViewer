/*
 *  Copyright (C) 2009 Rosendo R. Sosa Canales - EDUMAT-TI
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 */

package ImageViewer;

/**
 *
 * @author Rosendo R. Sosa Canales EDUMAT-TI
 */

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JPanel;


 final class GridOfContainers extends JPanel {

    private int x;
    private int y;

/**
 *
 *@param x Rows.
 *@param y Columns.
 */
    public GridOfContainers(MouseListener mouse, int x, int y) {
        this.x = x;
        this.y = y;
        
        GridLayout grid = new GridLayout(x, y);
        grid.setHgap(10);
        grid.setVgap(10);
        this.addMouseListener(mouse);
        this.setLayout(grid);
        for (int z = 0; z < (x*y); z++) {
            add();
        
        }
    }
/**
 *Add a new CanvasM  to the JPanel.
 */
    public void add() {
        ImageContainer can = new ImageContainer(this.getMouseListeners()[0]);
        add(can);

    }

}
