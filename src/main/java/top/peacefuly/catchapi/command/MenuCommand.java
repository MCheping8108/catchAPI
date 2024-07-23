package top.peacefuly.catchapi.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

//        ItemStack flower = new ItemStack(Material.FLOWERING_AZALEA, 2);
        if (commandSender instanceof Player player){
            ItemStack block = new ItemStack(Material.OAK_LOG);
            player.getInventory().addItem(block);

            ItemStack food = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta foodMeta = food.getItemMeta();
            foodMeta.setDisplayName(ChatColor.RED  + "" + ChatColor.BOLD + "Soul Sword");

            List<String> foodLore = new ArrayList<>();
            foodLore.add("This is the Soul Sword.");
            foodLore.add("Only kill souls");
            foodLore.add("Soul Hunter ™");
            foodMeta.setLore(foodLore);
            foodMeta.addEnchant(Enchantment.POWER, 1000, true);
            foodMeta.addEnchant(Enchantment.FIRE_ASPECT, 1000, true);
            foodMeta.addEnchant(Enchantment.SOUL_SPEED, 1000, true);
            food.setItemMeta(foodMeta);
            player.getInventory().addItem(food);
        }
        return true;
    }
}
