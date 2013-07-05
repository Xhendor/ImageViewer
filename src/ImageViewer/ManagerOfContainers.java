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
import ImageViewer.util.InfoImage;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.*;

class ManagerOfContainers extends JPanel {

    private int x;
    private int y;
    private GridOfContainers app;
    private ArrayList vecimge = new ArrayList();
    private ImageContainer canvas;
    private Scrollbar scroll;
    private HashMap<Integer, String> slct = new HashMap<Integer, String>();
    private int contador = 0;

    /**
     * Constructs a new ManagerOfContainers.
     *@param x
     *@param y
     */
    public ManagerOfContainers(MouseListener ml, final int x, final int y) {
        this.x = x;
        this.y = y;
        this.addMouseListener(ml);

        app = new GridOfContainers(ml, this.x, this.y);

        scroll = new Scrollbar();
        scroll.setMinimum(0);
        scroll.setMaximum(vecimge.size());
        scroll.addAdjustmentListener(new AdjustmentListener() {

            public void adjustmentValueChanged(AdjustmentEvent size) {
                int tama = size.getValue();
                if (tama > -1) {
                    clearAll();
                    relacion((tama + 1) * (y));
                    scroll();
                } else {
                    clearAll();
                    relacion(0);
                    scroll();
                }
            }
        });
        this.setLayout(new BorderLayout());
        this.add(app, BorderLayout.CENTER);
        this.add(scroll, BorderLayout.EAST);
//        this.add(borrar, BorderLayout.SOUTH);

    }

    private void eventMouseClick(MouseEvent e) {
        Component c = e.getComponent();
        if (c instanceof ImageContainer) {

            ImageContainer can = (ImageContainer) c;
            int a = e.getX();
            int b = e.getY();

            if (a >= (c.getSize().width - 20) && b >= c.getHeight() - 20) {
                if (can.getImg() != null) {

                    if (can.getCont() == 1) {
                        slct.remove(vecimge.indexOf(can.toString()));

                        can.setCont(0);
                        can.repaint();
                    } else {
                         slct.put(vecimge.indexOf(can.toString()), can.toString());

                        can.setCont(1);
                        can.repaint();
                    }
                }
            }

        }

    }

    public InfoImage infoDoubleClick(MouseEvent e) {
        int click=e.getClickCount();
        InfoImage info = null;
        if (e.getComponent() != null && e.getComponent() instanceof ImageContainer) {
            
            if ( click== 2) {
                info = new InfoImage(vecimge.indexOf(e.getComponent().toString()), e.getComponent().toString());

            }else{
                  eventMouseClick(e);
            }
        }
        return info;

    }

    //Regresa 1,0 si estan seleccionados o no.
    private int isSelected(String imagen) {
        if ((slct.get(vecimge.indexOf(imagen)) != null)) {
            return 1;
        }
        return 0;
    }

//Relaciona los CanvasM con el ArrayList de imagenes
    private void relacion(int num) {
        try {
            if (num != -1) {
                for (int z = 0; z < (x * y); z++) {
                    String s;
                    canvas = (ImageContainer) app.getComponents()[z];
                    if((vecimge.size()-1)>=num)
                    if ((s = (String) vecimge.get(num)) != null) {
                        canvas.LoadImg(s);
                        canvas.repaint();
                        canvas.setCont(isSelected(s));
                    } else {
                        canvas.setImg(null);
                    }
                    num++;

                }
            }
            scroll();
        } catch (ArrayIndexOutOfBoundsException e) {
            canvas.setImg(null);

        }
    }

    //Set all CanvasM en Cont=0 imgage=null
    public void clearAll() {

        for (int z = 0; z < (x * y); z++) {
            canvas = (ImageContainer) app.getComponents()[z];
            canvas.setImg(null);
            canvas.setPath(null);
            canvas.setCont(0);
           
            canvas.repaint();
        }

         
    }
public void renew(){
clearAll();
 vecimge.clear();
 slct.clear();
         
}
    private void scroll() {

        if (vecimge.size() <= (x * y)) {

            scroll.setMaximum(0);
        } else {


            scroll.setMaximum(contador);
            System.out.println(scroll.getMaximum());
        }
    }

    public boolean addImg(String ruta) {


        if (ruta != null) {
            resetCounter();
            System.out.println("RUTA_ADDED: "+ruta);
            vecimge.add(ruta);
            relacion(0);

            counter();
            scroll.setMaximum(0);
            scroll();
            return true;
        }
        return false;
    }

    public HashMap crateAlbum() {

        if (!vecimge.isEmpty()) {
            if (!slct.isEmpty()) {

                return slct;

            }
        }
        return null;
    }

    public void filterImg() {
        
        if (!vecimge.isEmpty()) {
            if (!slct.isEmpty()) {
                int size = vecimge.size();
                vecimge.clear();//LimpiarArrayList

                for (int z = 0; z < size; z++) {
                    if (slct.get(z) != null) {
                        vecimge.add(slct.get(z));

                    }
                    canvas.repaint();
                }
                clearAll();
                slct.clear();
                relacion(0);
                scroll();


            }
        }
    }

    public boolean delImg() {


        if (!vecimge.isEmpty()) {
            int size = vecimge.size();
            for (int z = 0; z < size; z++) {

                if (slct.get(z) != null) {
                    resetCounter();
                    vecimge.remove(slct.get(z));
                    counter();


                }
            }

            clearAll();
            slct.clear();
            relacion(0);
            scroll.setMaximum(0);
            scroll();
            return true;

        }

        return false;

    }

    private void counter() {

        if (vecimge.size() > (x * y)) {


            int count = ((vecimge.size() - 1) - (x * y)) / y;
            if (contador == 0) {
                contador = 1;
            }

            for (int z = 0; z < count; z++) {
                contador++;
            }






        }
    }

    private void resetCounter() {
        contador = 0;
    }

    public Component getComponent() {

        return this;
    }
}
