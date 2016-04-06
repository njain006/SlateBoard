package slateboard;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Test2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Dev
 */
// Server thread code;
public class ServerThread extends Thread
{
    
    Date date = new Date();
    private ServerSocket srvr = null;
    private Socket socket = null;
    public ServerThread(ServerSocket srvrs)
    {
        super("ServerThread");
        this.srvr = srvrs;
        start();// calling void run
        
    }

public void run()
    {
    try
    {
        PrintWriter out;
        BufferedReader in;
        int ch;
        String filename,hold;
        boolean status=true;
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//while(true){
        //System.out.println("Waiting for client to connect...");
        while(true){
        socket = srvr.accept();
        System.out.println("Connected with Client on " + socket);
       // sLog.WriteLog("Connected with Client: " + socket +"\tTime:"+ date);
     out = new PrintWriter(socket.getOutputStream(), true);
     in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

  if((ch = Integer.parseInt(in.readLine()))!=6)
  {          
        if(ch==1) // condition and code for downloading file from client.
        {
            filename = in.readLine();

            FileCopy copyfromClient = new FileCopy(filename,socket);
            System.out.println("Dowloading " + filename + " from client.");
            System.out.println("File Copied Successfully!!!");
            //sLog.WriteLog("Received file \t" + filename + " from \t" + socket +" \tTime:"+ date);
        }
        if(ch == 2) // condition and code for search.
        {
            filename = in.readLine();
            System.out.println("Search files for " + filename);
            System.out.println("Searching...");
            //Search srch = new Search(filename, socket);
            System.out.println("Search Complete.");
            //sLog.WriteLog("Searched file \t" + filename + " from \t" + socket +" \tTime:"+ date);
        }
        if(ch == 3)// condition and code for sending file to client.
        {
            filename = in.readLine();
            System.out.println("Sending File " + filename + "...");
            out.println("Sending File " + filename + "...");
            //Sending desired file
            Send copysend = new Send(filename,socket);

            System.out.println("File Sent Successfully!!!");
            //sLog.WriteLog("Send file \t" + filename + " to \t" + socket +" \tTime:"+ date);
        }
      else if(ch==4)// exit condition
      {
      try
      {
          System.out.println("Client disconnected!!! " + socket);
          socket.close();
          //sLog.WriteLog("Disconnected with Client: " + socket +"\tTime:"+ date);
      }catch(Exception e){
      System.out.println("Connection failure with Client.");
          }
      //out.close();
      //in.close();
      //socket.close();
     }

    }
 
  }
} catch (Exception e) {
	    System.out.println();
	}
    finally // closing socket if program interrupted.
    {
        try
        {
        //sLog.WriteLog("Disconnected with Client: " + socket +"\tTime:"+ date);
        System.out.println("Closed connection with client on " + socket);
        socket.close();
        System.out.println("Waiting for other Client Operation.");
        new ServerThread(srvr);
        }
        catch(Exception e){System.out.println();}
    }

    }
   

}
