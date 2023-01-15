package dev.awesomebfm.minecraftmissiles.listeners;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null) return;
        if (!(e.getClickedBlock().getType() == Material.SMOKER)) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getItem() == null) return;
        if (!(e.getItem().hasItemMeta())) return;
        if (!(e.getItem().getItemMeta().hasDisplayName())) return;
        if (!(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Missile Tablet"))) return;
        e.setCancelled(true);

        Inventory inventory = Bukkit.createInventory(null, 27, "Missile Launcher");
        //region filler item
        ItemStack filler = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(" ");
        fillerMeta.setLore(null);
        filler.setItemMeta(fillerMeta);
        inventory.setItem(0, filler);
        inventory.setItem(1, filler);
        inventory.setItem(2, filler);
        inventory.setItem(3, filler);
        inventory.setItem(4, filler);
        inventory.setItem(5, filler);
        inventory.setItem(6, filler);
        inventory.setItem(7, filler);
        inventory.setItem(8, filler);
        inventory.setItem(9, filler);
        inventory.setItem(11, filler);
        inventory.setItem(13, filler);
        inventory.setItem(17, filler);
        inventory.setItem(18, filler);
        inventory.setItem(19, filler);
        inventory.setItem(20, filler);
        inventory.setItem(21, filler);
        inventory.setItem(22, filler);
        inventory.setItem(23, filler);
        inventory.setItem(24, filler);
        inventory.setItem(25, filler);
        inventory.setItem(26, filler);
        //endregion
        //region launch item
        ItemStack launch = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta launchMeta = launch.getItemMeta();
        launchMeta.setDisplayName(ChatColor.GREEN+ "Launch Missile");
        launchMeta.setLore(List.of(ChatColor.YELLOW + "Click to launch."));
        launch.setItemMeta(launchMeta);
        inventory.setItem(10, launch);
        //endregion
        //region targets
        List<Player> nearestPlayers = getNearestPlayers(e.getPlayer());

        ItemStack firstHead = SkullCreator.itemFromUuid(nearestPlayers.get(0).getUniqueId());
        ItemMeta firstHeadMeta = firstHead.getItemMeta();
        firstHeadMeta.setDisplayName(ChatColor.GREEN + nearestPlayers.get(0).getName());
        firstHeadMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
        firstHead.setItemMeta(firstHeadMeta);
        inventory.setItem(14, firstHead);

        ItemStack secondHead = SkullCreator.itemFromUuid(nearestPlayers.get(1).getUniqueId());
        ItemMeta secondHeadMeta = secondHead.getItemMeta();
        secondHeadMeta.setDisplayName(ChatColor.GREEN + nearestPlayers.get(1).getName());
        secondHeadMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
        secondHead.setItemMeta(secondHeadMeta);
        inventory.setItem(15, secondHead);

        ItemStack thirdHead = SkullCreator.itemFromUuid(nearestPlayers.get(2).getUniqueId());
        ItemMeta thirdHeadMeta = thirdHead.getItemMeta();
        thirdHeadMeta.setDisplayName(ChatColor.GREEN + nearestPlayers.get(2).getName());
        thirdHeadMeta.setLore(List.of(ChatColor.YELLOW + "Click to set as target."));
        thirdHead.setItemMeta(thirdHeadMeta);
        inventory.setItem(16, thirdHead);
        //endregion
        e.getPlayer().openInventory(inventory);

    }

    private List<Player> getNearestPlayers(Player player) {
        List<Player> onlinePlayers = player.getWorld().getPlayers();
        onlinePlayers.remove(player);
        HashMap<Player, Double> playerDistances = new HashMap<>();
        for (Player p : onlinePlayers) {
            playerDistances.put(p, player.getLocation().distance(p.getLocation()));
        }

        List<Player> closestPlayers = new ArrayList<>(); // Contains three players

        // First player
        double temp = 100000;
        Player tempPlayer = null;
        for (Player p : playerDistances.keySet()) {
            if (playerDistances.get(p) < temp) {
                temp = playerDistances.get(p);
                tempPlayer = p;
            }
        }
        playerDistances.remove(tempPlayer);
        closestPlayers.add(tempPlayer);

        // Second Player
        temp = 100000;
        for (Player p : playerDistances.keySet()) {
            if (playerDistances.get(p) < temp) {
                temp = playerDistances.get(p);
                tempPlayer = p;
            }
        }
        playerDistances.remove(tempPlayer);
        closestPlayers.add(tempPlayer);

        // Third Player
        temp = 100000;
        for (Player p : playerDistances.keySet()) {
            if (playerDistances.get(p) < temp) {
                temp = playerDistances.get(p);
                tempPlayer = p;
            }
        }
        playerDistances.remove(tempPlayer);
        closestPlayers.add(tempPlayer);

        return closestPlayers;
    }

}
