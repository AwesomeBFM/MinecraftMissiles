package dev.awesomebfm.minecraftmissiles.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        if (!(e.getView().getTitle().equals("Missile Launcher"))) return;

        if (e.getSlot() <= 9 || e.getSlot() >= 17) {
            e.setCancelled(true);
            return;
        }
        if (e.getSlot() == 11 || e.getSlot() == 13) {
            e.setCancelled(true);
            return;
        }

        if (e.getSlot() == 14 || e.getSlot() == 15 || e.getSlot() == 16) {
            int slot = e.getSlot();
            e.setCancelled(true);

            ItemStack item = e.getClickedInventory().getItem(slot);
            if (item == null) return;
            ItemMeta meta = item.getItemMeta();
            if (meta.getLore().contains(ChatColor.YELLOW + "Selected.")) {
                meta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
            } else {
                meta.setLore(List.of(ChatColor.YELLOW + "Selected."));
            }
            item.setItemMeta(meta);
            e.getInventory().setItem(slot, item);

            Player p = (Player) e.getWhoClicked();
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 1);
            return;
        }

    }
}
