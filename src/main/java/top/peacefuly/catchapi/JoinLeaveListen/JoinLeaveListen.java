package top.peacefuly.catchapi.JoinLeaveListen;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListen implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.GREEN + " has joined the server!");
        // 这里可以添加你想要的代码
        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.GREEN + "欢迎 " + player.getDisplayName() + " 回来！");
        } else {
            e.setJoinMessage(ChatColor.BLUE + "欢迎 " + player.getDisplayName() + " 来到服务器！");;
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.RED + " has leaved the server!");
    }
}
