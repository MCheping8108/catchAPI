package top.peacefuly.catchapi.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.peacefuly.catchapi.CatchAPI;

public class SetSpawnCommand implements CommandExecutor {

    private final CatchAPI plugin;

    public SetSpawnCommand(CatchAPI plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            Location location = player.getLocation();
//            String worldName = "potato";
//            World foundWorld = Bukkit.getWorld(worldName);
//            Location location1 = new Location(foundWorld, x, y, z);

//            plugin.getConfig().set("spaen.x", location.getX());
//            plugin.getConfig().set("spaen.y", location.getY());
//            plugin.getConfig().set("spaen.z", location.getZ());
//            plugin.getConfig().set("spawn.worldName", location.getWorld().getName());

            plugin.getConfig().set("spawn", location);
            plugin.saveConfig();
            player.sendMessage("Spawn location set!");


        }else {
            System.out.println("not");
        }


        return true;
    }
}
