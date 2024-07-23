package top.peacefuly.catchapi.Cooldowns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Cooldowns implements CommandExecutor {

    private final HashMap<UUID, Long> cooldown;

    public Cooldowns(){
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender Sender, Command command, String s, String[] strings) {

        if (Sender instanceof Player){
            Player player = (Player) Sender;
            if (this.cooldown.containsKey(player.getUniqueId())){
                this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                player.sendMessage("You are lunched cooldowns");
            } else {
                long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
                if (timeElapsed >= 10000){
                    this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    player.sendMessage("You are lunched cooldowns");
                }else{
                    player.sendMessage("Count down:" + (10000 - timeElapsed) + "milliseconds");
                }
            }
        }

        return true;
    }
}
