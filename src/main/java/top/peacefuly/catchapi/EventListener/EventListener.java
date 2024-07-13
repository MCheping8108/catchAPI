package top.peacefuly.catchapi.EventListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements org.bukkit.event.Listener {
    @EventHandler
    void onPlayerJoined(PlayerJoinEvent e){
        e.setJoinMessage("Welcome joined this server!");
//        System.out.println("A player has joined the Server!");
    }

    @EventHandler
    void onEnterBed(PlayerBedEnterEvent e){
        Player player = e.getPlayer();
        player.sendMessage("§b "+ player.getName() + " entered the bed!");
    }

    @EventHandler
    void onLeaveBed(PlayerBedLeaveEvent e){
        Player player = e.getPlayer();
        player.sendMessage("§b "+ player.getName() + " left the bed!");
    }
}
