package com.example.ChatApplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class Server {

    private static ArrayList<String> users = new ArrayList<>();
    private static ArrayList<MessagingThread> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8081,10);
        System.out.println("Server started");

        DbOperations.createUserTable("Users");
        DbOperations.createChatTable("Chat_Backup");

        while(true){
            Socket client = server.accept();
            MessagingThread thread = new MessagingThread(client);
            clients.add(thread);
            thread.start();
        }
    }

    public static void sendToAll(String userName, String message){

        for(MessagingThread client: clients){
            if(client.user.equals(userName)){
                client.sendMessageToMe(userName,message);
            }else{
                client.sendMessage(userName,message);
            }
        }
    }

    static class MessagingThread extends Thread{

        BufferedReader input;
        PrintWriter output;
        String user;

        public MessagingThread(Socket client) throws Exception {
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output =new PrintWriter(client.getOutputStream(),true);

            user = input.readLine();
            users.add(user);

            DbOperations.addUserInDb(user);
        }

        public void sendMessage(String userName, String message){
            output.println(userName+" : "+message);
        }

        public void sendMessageToMe(String userName, String message){
            output.println("You : "+message);
        }

        public void saveInDb(String userName, String message) throws SQLException {
            String id = userName+"_"+System.currentTimeMillis();
            DbOperations.saveMessage(id,userName,message);
        }

        @Override
        public void run() {
            String line;
            try{

                while(true){
                    line = input.readLine();
                    if(line.equals("end")){
                        clients.remove(this);
                        users.remove(user);
                        break;
                    }else{
                        sendToAll(user,line);
                        saveInDb(user,line);
                    }
                }

            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }
    }
}
