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
// server invoking code.
public class Server
{
     public Server() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket server = null;
        int port;
        System.out.print("Enter port number: ");
        port = Integer.parseInt(br.readLine());
        server = new ServerSocket(port);
        System.out.println("Waiting for Client to connect.");
        new ServerThread(server);
        


    }

}
