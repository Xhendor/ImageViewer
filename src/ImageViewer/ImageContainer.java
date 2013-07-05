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

import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;

class ImageContainer extends Canvas {

    private String flecha;
    private Image img = null;
    private String path = null;
    private int cont = 0;
    private File url;

    /**
     *Constructs a new ImageContainer given a MouseListener.
     */
    public ImageContainer(MouseListener ml) {

        this.addMouseListener(ml);
        this.setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    /**Load from path  the image, only load .jpg,.gif*/
    public void LoadImg(String imagen) {
        this.setPath(imagen);


        if (imagen != null) {
            img = getToolkit().getImage(imagen);
        }
    }

    /**
     *Paint the Image in CanvasM.
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, (int) this.getSize().getWidth(), (int) this.getSize().getHeight(), this);
        g.setColor(Color.WHITE);//CheckBoxdibujado

        g.fill3DRect((int) (this.getSize().getWidth() - 20), this.getHeight() - 20, 20, 20, true);
        if (isSelect(cont)) {

            ImageIcon i = new ImageIcon(getClass().getResource("/res/1.jpg"));

            g.drawImage(i.getImage(), this.getSize().width - 20, this.getSize().height - 20, 18, 18, this);

        } else {
            g.setColor(Color.WHITE);//CheckBoxdibujado
            g.fill3DRect(this.getSize().width - 20, this.getHeight() - 20, 20, 20, true);
        }
    }

    /**
     *Return Image used in this CanvasM.
     */
    public Image getImg() {
        return img;
    }

    /**
     *Sets the Image in this CanvasM.
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     *Return the value  of count.
     * @return int
     */
    public int getCont() {
        return cont;
    }

    /**
     *Sets the value of coun
     * t.
     */
    public void setCont(int cont) {
        this.cont = cont;
    }

    /**
     *Check if the CanvasM is selected.
     * @return  boolean
     */
    public boolean isSelect(int x) {
        if (x == 0) {
            return false;
        }

        return true;
    }

    /**
     *Return the String of path.
     */
    @Override
    public String toString() {
        return getPath();

    }

    /**
     *Return the String of path.
     */
    public String getPath() {
        return path;
    }

    /**
     *Sets the String of path.
     */
    public void setPath(String nombre) {
        this.path = nombre;
    }

    /**
     * @return the flecha
     */
    public String getFlecha() {
        return flecha;
    }

    /**
     * @param flecha the flecha to set
     */
    public void setFlecha(String flecha) {
        this.flecha = flecha;
    }
}
