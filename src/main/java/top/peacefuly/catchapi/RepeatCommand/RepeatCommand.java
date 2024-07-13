package top.peacefuly.catchapi.RepeatCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(strings.length == 0){
                player.sendMessage("§b "+ player.getName() + " 请输入指令!");
            }else if (strings.length == 1){
                String word = strings[0];
                player.sendMessage("§b Message:"+ word);
            }else{
                StringBuilder builder = new StringBuilder();
                for(int i = 0; i< strings.length; i++){
                    builder.append(strings[i]);
                    builder.append(" ");
                }
                String finalMessage = builder.toString();
            }
        }

        return true;
    }
}
