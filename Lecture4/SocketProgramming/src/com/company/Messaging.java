package com.company;

import java.io.*;
import java.net.Socket;

public class Messaging extends Thread{

    Socket clientSocket;

    public Messaging(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);

            while(true){
                String msg = in.readLine();
                System.out.println("Client Sent : " +msg);
                out.println("Server acknowledged this message : "+msg);
                out.flush();
                if(msg.equals("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
