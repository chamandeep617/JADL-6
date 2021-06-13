package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client2 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to the server");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        String msg;
        while (true) {
            System.out.println("Please Enter your message : ");
            msg = scanner.nextLine();
            out.println(msg);
            String response = in.readLine();
            System.out.println(response);
            if (msg.equals("exit")) {
                break;
            }
        }
    }
}
