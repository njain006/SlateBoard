package slateboard;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Test2;
import java.io.*;
import java.net.*;
/**
 *
 * @author Dev
 */
// copy/ downloading file code.
public class FileCopy
{
    public FileCopy(String filename,Socket sockc) 
    {
        try{
    int  fsize=6022386; // filesize temporary hardcoded
    long start = System.currentTimeMillis();
    int bytesRead;
    int current = 0;
    //sockc.setKeepAlive(true);
    filename = "data/Copy"+filename;
    //System.out.println("File Size: " +fsize);
    // receive file
    byte [] bytearray  = new byte [fsize];
    InputStream is = sockc.getInputStream();
    FileOutputStream fos = new FileOutputStream(filename);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    bytesRead = is.read(bytearray,0,bytearray.length);
    current = bytesRead;
    do {
       bytesRead =
          is.read(bytearray, current, (bytearray.length-current));
       if(bytesRead >= 0) current += bytesRead;
    } while(bytesRead > -1);

    bos.write(bytearray, 0 , current);
    bos.flush();
    long end = System.currentTimeMillis();
    System.out.println(end-start+" milliSec");
    bos.close();
    //sockc.close();
        }
        catch(Exception e)
        {
            System.out.println("Copying Error!!!");
        }
       
    }

}
