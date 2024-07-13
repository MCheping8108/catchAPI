package top.peacefuly.catchapi.FartCommand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            if (strings.length == 0){
                p.sendMessage("你放了一个屁");
                p.setHealth(0.0);
            }else{
                String PlayName = strings[0];
                Player target = Bukkit.getServer().getPlayerExact(PlayName);
                if (target == null){
                    p.sendMessage("玩家不在线");
                }else {
                    p.sendMessage(target.getDisplayName() + "成功放了一个屁");
                    target.sendMessage("你放了个一个屁");
                    target.setHealth(0.0);
                }
            }
        }

        return true;
    }
}
