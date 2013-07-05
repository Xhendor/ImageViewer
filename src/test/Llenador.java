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
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * @author Rosendo R. Sosa Canales - EDUMAT-TI
 *
 */
public class Llenador implements Runnable {

    private ImageViewer handler;
    private final long TIMMER = 3000;
    private String filename;
    private String dirURL;
    public static ArrayList files = new ArrayList();
    public static int cont = 0;

    public Llenador(ImageViewer handler,
            String dirURL) {
        this.handler = handler;
        this.dirURL = dirURL;
    }

    public void run() {
        File dir = new File(dirURL);
        
        String[] children = null;
        while (true) {
            children = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {

               if (dir.isHidden()) {
                    return false;
                }else if(name.endsWith(".png")||name.endsWith(".jpg")||name.endsWith(".jpeg")){
                return true;
                }
                return false;

            }
        });
            if (children == null) {
                // Either dir does not exist or is not a directory
            } else {
                for (int i = 0; i < children.length; i++) {
                    // Get filename of file or directory

                    filename = children[i];
                    System.out.println("NOMBRE: " + filename);
                    if (!files.contains(filename)) {
                        files.add(filename);
                        handler.add(dirURL + filename);
                        cont++;
                    }
                }
            }


            try {

                Thread.sleep(TIMMER);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
