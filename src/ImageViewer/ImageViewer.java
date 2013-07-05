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
import ImageViewer.util.InfoImage;
import java.awt.Component;
import java.awt.event.*;
import java.util.HashMap;


/**
 * The <code>ImageViewer</code> class generate a thumbnails of images.
 *@author Rosendo R. Sosa Canales - EDUMAT-TI
 */
public class ImageViewer {

   private ManagerOfContainers mcm;

    /**
     * Construct create a new instance of <code>ImageViewer</code>.
     * @param ml MouseListener.
     * @param x Rows.
     * @param y Columns.
     */
    public ImageViewer(MouseListener ml, int x, int y) {

        
        mcm = new ManagerOfContainers(ml, x, y);

    }

    /**
     * Add image.
     * @param Path the path of image.
     * @return  Return <code>true</code> if add image correctly or <code>false</code> if don't add image.
     */
    public boolean add(String path) {

        return mcm.addImg(path);
    }

    /**
     * Remove only the selected images.
     * @return  Return <code>true</code> if remove image or <code>false</code> if don't remove image.
     
     */
    public boolean removeSelected() {

        return mcm.delImg();

    }

    /**
     * Return a  selected images.
     * @return  Return a <code>Hashtable</code> of selected images.
     */

    public HashMap getSelected() {

        return mcm.crateAlbum();

    }

    /**
     *Remove the unselected images.
     */
    public void onlySelected() {

        mcm.filterImg();
    }

    /**
     *Return the <code>Component</code>.
     */
    public Component getComponent() {

        return mcm.getComponent();
    }

    
    
    /**
     * Handles the <code>MouseEvent</code> on the image.
     * If it is double click will return the location and name of the image.
     * If it is a single click is marked as  selected.
     * @param  e MouseEvent.
     * @return  Return  <code>InfoImage</code> or <code>null</code>.
     * @see InfoImage
     */
    public InfoImage ClickEvent(MouseEvent e) {
       return mcm.infoDoubleClick(e);
    }

    /**
     * Remove all images.
     * 
     */
    public void clearAll(){
           mcm.clearAll();

    }

    public void renew(){
    mcm.renew();
    }

}


