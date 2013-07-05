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

package ImageViewer.util;

/**
 *
 *The <code>InfoImage</code> class return a position and name of the image.
 *@author Rosendo R. Sosa Canales EDUMAT-TI
 */
 public class InfoImage {

     private int pos;
     private String path;
     /**
      * Construct create a new instance of <code>InfoImage</code>.
      * @param path   Path of the image.
      * @param pos    Position of the image.
      */
     public InfoImage(int pos,String path){
        this.path=path;
        this.pos=pos;

     }

    /**
     * Return a Position of the image.
      */
    public int getPos() {
        return pos;
    }

    /**
     * Return a Path of the image.
     
     */
    public String getPath() {
        return path;
    }

    @Override
    /**
     * Return a path and position of the image.

     */
    public String toString(){
    return pos+", "+path;
    }
}
