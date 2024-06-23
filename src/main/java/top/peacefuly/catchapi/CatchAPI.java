package top.peacefuly.catchapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CatchAPI extends JavaPlugin {

    @Override
    public void onLoad() {
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
//        System.out.println("Hello World!");
        this.getLogger().info("enabled!");
        Bukkit.getConsoleSender().sendMessage("§aStart plugins!");
        Bukkit.getPluginManager().registerEvents(new Listener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("§cshutdown");
    }
}
