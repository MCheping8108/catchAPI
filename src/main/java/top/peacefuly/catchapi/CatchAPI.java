package top.peacefuly.catchapi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import top.peacefuly.catchapi.DeathListener.DeathListener;
import top.peacefuly.catchapi.EventListener.EventListener;
import top.peacefuly.catchapi.FartCommand.FartCommand;
import top.peacefuly.catchapi.JoinLeaveListen.JoinLeaveListen;
import top.peacefuly.catchapi.Listener.Listener;
import top.peacefuly.catchapi.RepeatCommand.RepeatCommand;
import top.peacefuly.catchapi.command.FoodCommand;
import top.peacefuly.catchapi.command.SetSpawnCommand;
import top.peacefuly.catchapi.command.SpawnCommand;
import top.peacefuly.catchapi.command.command;

public final class CatchAPI extends JavaPlugin {




    @Override
    public void onEnable() {
//        System.out.println("Hello World!");
        // config.yml
        saveDefaultConfig();
        this.getLogger().info("enabled!");
        Bukkit.getConsoleSender().sendMessage("§aStart plugins!");
        Bukkit.getPluginManager().registerEvents(new Listener(), this);
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListen(this), this);
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getCommand("god").setExecutor(new command());
        getCommand("food").setExecutor(new FoodCommand());
        getCommand("repeat").setExecutor(new RepeatCommand());
        getCommand("fart").setExecutor(new FartCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("reload")){
            this.reloadConfig();
            sender.sendMessage("热加载成功");
        }

        if (cmd.getName().equalsIgnoreCase("de")){
            if (sender instanceof Player){
                Player p = (Player) sender;
                p.setHealth(0.0);
                p.sendMessage(ChatColor.RED + "你被catchapi以“德”服你了！");
            }else if (sender instanceof ConsoleCommandSender){
                System.out.println("The command was run by the console.");
            }else if (sender instanceof BlockCommandSender){
                System.out.println("The command was run by a BlockCommandSender.");
            }else if (cmd.getName().equalsIgnoreCase("poop")){

            }
        }

        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("§cshutdown");
    }
}
