package top.peacefuly.catchapi.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPlaceEvent;

//import org.bukkit.event.Listener;
public class Listener implements org.bukkit.event.Listener {

    @EventHandler
//    实体检测
    void onEntityplaced(EntityPlaceEvent e) {
        String playerName = e.getPlayer().getName();
        Entity entity = e.getEntity();
//        System.out.println("§e "+ playerName + " placed " + entity);
        Bukkit.getConsoleSender()
                .sendMessage("§b "+ playerName + " placed " + entity);
    }

    @EventHandler
    void onEntityHurt(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        String playerName = entity.getName();
//        System.out.println("§e "+ playerName + " hurt " + entity);
        Bukkit.getConsoleSender()
                .sendMessage("§b "+ playerName + " Damaged " + entity);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    void onBlockPlace(BlockPlaceEvent e) {
        String playerName = e.getPlayer().getName();
        Block block = e.getBlockPlaced();
//        System.out.println("§e "+ playerName + " placed " + block);
        Bukkit.getConsoleSender()
                .sendMessage("§b "+ playerName + " placed " + block);
//        如果玩家放置tnt，插件自动忽略tnt的放置
        if (block.getType() == Material.TNT){
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    void onBlockBreak(BlockBreakEvent e) {
//        获取玩家名是谁破坏了方块
        String playerName = e.getPlayer().getName();
        Block block = e.getBlock();
//        System.out.println("§e "+ playerName + " broken " + block);
        Bukkit.getConsoleSender().sendMessage("§b "+ playerName + " broken " + block);

    }
}
