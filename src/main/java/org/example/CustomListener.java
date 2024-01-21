package org.example;

import io.github.jwdeveloper.tiktok.annotations.TikTokEventObserver;
import io.github.jwdeveloper.tiktok.data.events.TikTokCommentEvent;
import io.github.jwdeveloper.tiktok.data.events.TikTokConnectedEvent;
import io.github.jwdeveloper.tiktok.data.events.TikTokDisconnectedEvent;
import io.github.jwdeveloper.tiktok.data.events.TikTokErrorEvent;
import io.github.jwdeveloper.tiktok.listener.TikTokEventListener;
import io.github.jwdeveloper.tiktok.live.LiveClient;

public class CustomListener implements TikTokEventListener {
    @TikTokEventObserver
    public void onConnected(LiveClient liveClient, TikTokConnectedEvent event){
        System.out.println(event.toString());
    }

    @TikTokEventObserver
    public void onDisconnected(LiveClient liveClient, TikTokDisconnectedEvent event){
        System.out.println(event.toString());
    }


    @TikTokEventObserver
    public void onError(LiveClient liveClient, TikTokErrorEvent event){
        System.out.println(event.toString());
    }

    @TikTokEventObserver
    public void onComment(LiveClient liveClient, TikTokCommentEvent event){
        System.out.println(event.getUser() + " says: " + event.getText());
    }
}
