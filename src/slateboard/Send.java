package slateboard;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Test2;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */

// file sending code.
public class Send {
    public Send(String fileName, Socket sock)
    {
        try
        {
        File sendFile = new File (fileName);
        if(!sendFile.exists()){
            System.out.println("File does not exists.");
            MainMenu mein = new MainMenu();
        }
        byte [] bytearray  = new byte [(int)sendFile.length()];
        FileInputStream fi = new FileInputStream(sendFile);
        BufferedInputStream bi = new BufferedInputStream(fi);
        bi.read(bytearray,0,bytearray.length);
        OutputStream os = sock.getOutputStream();
        System.out.println("File sending...");
        os.write(bytearray,0,bytearray.length);
        os.flush();
        }
        catch(Exception e){System.out.println(e);}
        finally{try {
                sock.close();
            } catch (IOException ex) {
                Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }

}
