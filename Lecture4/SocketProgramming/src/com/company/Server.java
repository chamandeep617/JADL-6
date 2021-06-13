package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws  IOException {
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("waiting for the client to connect");
        Socket clientSocket = socket.accept();
        System.out.println("client Connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

        while(true){
            String msg = in.readLine();
            System.out.println("Client Sent : " +msg);
            out.println("Server acknowledged this message : "+msg);
            out.flush();
            if(msg.equals("exit")){
                break;
            }
        }



    }

}
