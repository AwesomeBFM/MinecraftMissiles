package dev.awesomebfm.minecraftmissiles.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DebugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack item = new ItemStack(Material.SMOKER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Missile Silo");
        item.setItemMeta(meta);
        ((Player) sender).getInventory().addItem(item);

        ItemStack ipad = new ItemStack(Material.IRON_INGOT);
        ItemMeta ipadMeta = ipad.getItemMeta();
        ipadMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Missile Tablet");
        ipad.setItemMeta(ipadMeta);
        ((Player) sender).getInventory().addItem(ipad);
        return true;
    }
}
