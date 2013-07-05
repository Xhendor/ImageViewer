package test;

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



import ImageViewer.ImageViewer;
import ImageViewer.util.InfoImage;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Rosendo Rafael Sosa Canales EDUMAT-TI
 */
public class M_Example extends JFrame implements MouseListener{
    ImageViewer hand;
    InfoImage info;
    int x=0;
    private String RUTA="/Library/Application Support/Apple/iChat Icons/Flags/";;
    private Llenador llenador;
    private Thread miHilo;
    public M_Example(){
        
        hand=new ImageViewer(this,4,4);
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(hand.getComponent(),BorderLayout.CENTER);
        Button boton=new Button("Agregar");
       llenador = new Llenador(hand, RUTA);
       miHilo=new Thread(llenador);
       miHilo.start();
        
        boton.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
               
              
                  hand.ClickEvent(e);
//                  if(e.getClickCount()==2){
//                  hand.clearAll();
//                  }
                
            }

            public void mousePressed(MouseEvent e) {
  //              throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseReleased(MouseEvent e) {
    //            throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseEntered(MouseEvent e) {
      //          throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseExited(MouseEvent e) {
        //        throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        panel.add(boton,BorderLayout.SOUTH);
        panel.setSize(200, 200);
        this.setSize(300, 300);
        this.add(panel,BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void  main (String args[]){
        new M_Example().setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
     info=hand.ClickEvent(e);
        System.out.println(info);
    }

    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
