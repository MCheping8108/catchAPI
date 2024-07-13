package top.peacefuly.catchapi.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.peacefuly.catchapi.CatchAPI;

public class SpawnCommand implements CommandExecutor {

    private final CatchAPI plugin;

    public SpawnCommand(CatchAPI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){
                player.teleport(location);
                player.sendMessage("已传送到出生点");
            }else{
                player.sendMessage("你似乎没有设置出生点，请使用/setspawn");
            }
        }

        return true;
    }
}
