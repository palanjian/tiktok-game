package org.example;

import io.github.jwdeveloper.tiktok.TikTokLive;

import java.util.Scanner;

public class Main {

    public static String streamer = "";
    public static void main(String[] args) {
        initializeConnection();
    }

    public static void initializeConnection(){
        System.out.println("Enter username of streamer");
        Scanner scan = new Scanner(System.in);
        streamer = scan.next().strip();

        try{
            CustomListener customListener = new CustomListener();
            TikTokLive.newClient(streamer).addListener(customListener).buildAndConnect();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("User not found or is offline. Try again");
            initializeConnection();
        }
    }
}