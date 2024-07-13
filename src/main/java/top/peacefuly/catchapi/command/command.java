package top.peacefuly.catchapi.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.isInvulnerable()) {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.setInvisible(false);
                player.setInvulnerable(false);
                player.sendMessage(ChatColor.RED + "God mode disabled");
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.setInvulnerable(true);
                player.setInvisible(true);
                player.sendMessage(ChatColor.GREEN + "God mode enabled");
            }
        }


        return true;
    }
}
