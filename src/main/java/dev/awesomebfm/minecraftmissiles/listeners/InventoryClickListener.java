package dev.awesomebfm.minecraftmissiles.listeners;

import dev.awesomebfm.minecraftmissiles.MinecraftMissiles;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.UUID;

public class InventoryClickListener implements Listener {
    private final MinecraftMissiles instance = MinecraftMissiles.getInstance();

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

        if (e.getSlot() == 14) {
            e.setCancelled(true);

            ItemStack launch = e.getClickedInventory().getItem(10);
            ItemMeta launchMeta = launch.getItemMeta();
            PersistentDataContainer launchData = launch.getItemMeta().getPersistentDataContainer();

            ItemStack item = e.getClickedInventory().getItem(14);
            if (item == null) return;
            ItemMeta meta = item.getItemMeta();
            if (meta.getLore().contains(ChatColor.YELLOW + "Selected.")) {
                meta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                launchData.remove(new NamespacedKey(instance, "target"));
            } else {
                meta.setLore(List.of(ChatColor.YELLOW + "Selected."));

                ItemStack two = e.getClickedInventory().getItem(15);
                ItemMeta bMeta = two.getItemMeta();
                bMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                two.setItemMeta(bMeta);
                ItemStack three = e.getClickedInventory().getItem(16);
                ItemMeta cMeta = three.getItemMeta();
                cMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                three.setItemMeta(cMeta);

                String uuid = meta.getPersistentDataContainer().get(new NamespacedKey(instance, "uuid"), PersistentDataType.STRING);
                launchData.set(new NamespacedKey(instance, "target"), PersistentDataType.STRING, uuid);
            }
            launch.setItemMeta(launchMeta);
            item.setItemMeta(meta);
            e.getInventory().setItem(14, item);

            Player p = (Player) e.getWhoClicked();
            p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 10, 1);
            return;
        }

        if (e.getSlot() == 15) {
            e.setCancelled(true);

            ItemStack launch = e.getClickedInventory().getItem(10);
            ItemMeta launchMeta = launch.getItemMeta();
            PersistentDataContainer launchData = launch.getItemMeta().getPersistentDataContainer();

            ItemStack item = e.getClickedInventory().getItem(15);
            if (item == null) return;
            ItemMeta meta = item.getItemMeta();
            if (meta.getLore().contains(ChatColor.YELLOW + "Selected.")) {
                meta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                launchData.remove(new NamespacedKey(instance, "target"));
            } else {
                meta.setLore(List.of(ChatColor.YELLOW + "Selected."));

                ItemStack two = e.getClickedInventory().getItem(14);
                ItemMeta bMeta = two.getItemMeta();
                bMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                two.setItemMeta(bMeta);
                ItemStack three = e.getClickedInventory().getItem(16);
                ItemMeta cMeta = three.getItemMeta();
                cMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                three.setItemMeta(cMeta);

                String uuid = meta.getPersistentDataContainer().get(new NamespacedKey(instance, "uuid"), PersistentDataType.STRING);
                launchData.set(new NamespacedKey(instance, "target"), PersistentDataType.STRING, uuid);
            }
            launch.setItemMeta(launchMeta);
            item.setItemMeta(meta);
            e.getInventory().setItem(15, item);

            Player p = (Player) e.getWhoClicked();
            p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 10, 1);
            return;
        }

        if (e.getSlot() == 16) {
            e.setCancelled(true);

            ItemStack launch = e.getClickedInventory().getItem(10);
            ItemMeta launchMeta = launch.getItemMeta();
            PersistentDataContainer launchData = launch.getItemMeta().getPersistentDataContainer();

            ItemStack item = e.getClickedInventory().getItem(16);
            if (item == null) return;
            ItemMeta meta = item.getItemMeta();
            if (meta.getLore().contains(ChatColor.YELLOW + "Selected.")) {
                meta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                launchData.remove(new NamespacedKey(instance, "target"));
            } else {
                meta.setLore(List.of(ChatColor.YELLOW + "Selected."));

                ItemStack two = e.getClickedInventory().getItem(14);
                ItemMeta bMeta = two.getItemMeta();
                bMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                two.setItemMeta(bMeta);
                ItemStack three = e.getClickedInventory().getItem(15);
                ItemMeta cMeta = three.getItemMeta();
                cMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
                three.setItemMeta(cMeta);

                String uuid = meta.getPersistentDataContainer().get(new NamespacedKey(instance, "uuid"), PersistentDataType.STRING);
                launchData.set(new NamespacedKey(instance, "target"), PersistentDataType.STRING, uuid);
            }
            launch.setItemMeta(launchMeta);
            item.setItemMeta(meta);
            e.getInventory().setItem(16, item);

            Player p = (Player) e.getWhoClicked();
            p.playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 10, 1);
            return;
        }

        if (e.getSlot() == 10) {
            e.setCancelled(true);

            ItemStack launch = e.getClickedInventory().getItem(10);
            ItemMeta launchMeta = launch.getItemMeta();
            PersistentDataContainer launchData = launch.getItemMeta().getPersistentDataContainer();
            String uuid = launchData.get(new NamespacedKey(instance, "target"), PersistentDataType.STRING);
            if (uuid == null) {
                Player p = (Player) e.getWhoClicked();
                p.sendMessage(ChatColor.RED + "ERROR: No target selected.");
                p.closeInventory();
                return;
            }
            if (Bukkit.getPlayer(UUID.fromString(uuid)) == null) {
                Player p = (Player) e.getWhoClicked();
                p.sendMessage(ChatColor.RED + "ERROR: Target is offline.");
                p.closeInventory();
                return;
            }
            Player target = Bukkit.getPlayer(UUID.fromString(uuid));
            Location targetLoc = target.getLocation();
            targetLoc.getWorld().spawn(targetLoc, TNTPrimed.class);
        }

    }
}