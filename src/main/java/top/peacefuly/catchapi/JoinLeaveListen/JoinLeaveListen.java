package top.peacefuly.catchapi.JoinLeaveListen;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import top.peacefuly.catchapi.CatchAPI;

public class JoinLeaveListen implements Listener {
    private final CatchAPI plugin;

    public JoinLeaveListen(CatchAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String joinMessage = this.plugin.getConfig().getString("join-message");
        String hasBefore = this.plugin.getConfig().getString("hasBefore");
        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', hasBefore).replace("%player%", player.getDisplayName()));
        } else {
            if (joinMessage != null) {
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMessage).replace("%player%", player.getDisplayName()));
            }
        }

//        e.setJoinMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.GREEN + " has joined the server!");
//        // 这里可以添加你想要的代码
//        if (player.hasPlayedBefore()) {
//            e.setJoinMessage(ChatColor.GREEN + "欢迎 " + player.getDisplayName() + " 回来！");
//        } else {
//            e.setJoinMessage(ChatColor.BLUE + "欢迎 " + player.getDisplayName() + " 来到服务器！");;
//        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
//        e.setQuitMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.RED + " has leaved the server!");
    }
}
