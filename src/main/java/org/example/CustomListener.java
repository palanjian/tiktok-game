package org.example;

import io.github.jwdeveloper.tiktok.annotations.TikTokEventObserver;
import io.github.jwdeveloper.tiktok.data.events.TikTokCommentEvent;
import io.github.jwdeveloper.tiktok.data.events.TikTokConnectedEvent;
import io.github.jwdeveloper.tiktok.data.events.TikTokDisconnectedEvent;
import io.github.jwdeveloper.tiktok.data.events.TikTokErrorEvent;
import io.github.jwdeveloper.tiktok.listener.TikTokEventListener;
import io.github.jwdeveloper.tiktok.live.LiveClient;

import static org.example.Main.streamer;

public class CustomListener implements TikTokEventListener {
    @TikTokEventObserver
    public void onConnected(LiveClient liveClient, TikTokConnectedEvent event){
        System.out.println("Successfully established connection to @" + streamer);
    }

    @TikTokEventObserver
    public void onDisconnected(LiveClient liveClient, TikTokDisconnectedEvent event){
        System.out.println("Disconnected from server. Reason: " + event.getReason());

        //to prevent getting rate limited
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @TikTokEventObserver
    public void onError(LiveClient liveClient, TikTokErrorEvent event){
        System.out.println("Error:" + event.getException().toString());
    }

    @TikTokEventObserver
    public void onComment(LiveClient liveClient, TikTokCommentEvent event){
        String text = event.getText();
        Main.robotHandler.handleInput(text.strip().toLowerCase());
    }

}
