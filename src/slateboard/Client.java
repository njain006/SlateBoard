package slateboard;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Test2;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dev
 */
// Client code;
public class Client
{
    Socket clientsocket;
    public Client() throws Exception
    {
        PrintWriter out;
        BufferedReader in;
        String ip,sserver,sclient;
        int cport,ch;
        boolean choice=true;
        Date date = new Date();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter IP Address to connect: ");
        ip = br.readLine();        
        System.out.print("Enter port number to connect: ");
        cport = Integer.parseInt(br.readLine());
        
        while(choice)
        {
         clientsocket = new Socket(ip,cport);
        System.out.println("Connected with Server on " + clientsocket);
        //cLog.WriteLog("Connected with Server: " + clientsocket +"\tTime:"+ date);
        out = new PrintWriter(clientsocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));    
        
        System.out.println("Choose Operation:\n1 - Send File.\n2 - Download File.\n3 - Exit.");
        System.out.print("Enter number: ");

        ch=Integer.parseInt(br.readLine());
        if(ch==1) // Condition for sending file.
        {
            System.out.println("You choose to send file.");
            out.println(ch);
            System.out.print("Enter file name to be sent: ");
            sclient = br.readLine();
            out.println(sclient);
            
            Send sendtoServer = new Send(sclient,clientsocket);
            System.out.println("File Sent successfully!!!");
            //cLog.WriteLog("Send file \t" + sclient + " from \t" + clientsocket +" \tTime:"+ date);


        }
      
        else if(ch==2) // Condition for copying file.
        {
            System.out.println("You have choosen to Copy File.");
            out.println(ch);
            System.out.println("Enter filename with extension: ");
            sclient = br.readLine();
            out.println(sclient);
            System.out.println("File Copying...");
            FileCopy copyfile=new FileCopy(sclient,clientsocket);
            System.out.println("File copied successfully!!!");
            //cLog.WriteLog("Download file \t" + sclient + " from \t" + clientsocket +" \tTime:"+ date);
        }

         else if(ch==3) // Condition for exit.
        {
            out.println(ch);
            choice = false;
            
        }
 else
        {  
              
        System.out.println("Client Reset!!!");        
        in.close();
        out.close();
        //cLog.WriteLog("Disconnected with Server: " + clientsocket +"\tTime:"+ date);
        clientsocket.close();
        }
      }
      //cLog.WriteLog("Disconnected with Server: " + clientsocket +"\tTime:"+ date);
        System.out.println("Client Exited!!!");
        MainMenu menu = new MainMenu();
    }

}
