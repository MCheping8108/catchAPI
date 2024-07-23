package top.peacefuly.catchapi.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class InventorryListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getWhoClicked() instanceof Player player){
            var clickItem = e.getCurrentItem();
            if (clickItem.getType() == Material.OAK_LOG){
                player.sendMessage("You clicked the sword");

                if (e.isShiftClick()){
                    clickItem.setType(Material.DIAMOND);
                    ItemMeta diamondMeta = clickItem.getItemMeta();
                    diamondMeta.setDisplayName(ChatColor.AQUA + "DIAMOND");
                    clickItem.setItemMeta(diamondMeta);
                }

            }else {
                player.sendMessage("You click something else.");
                player.sendMessage(clickItem.getType().toString());
            }
        }
    }
}
