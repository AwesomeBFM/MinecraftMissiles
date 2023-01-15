package dev.awesomebfm.minecraftmissiles.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DistanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p1 = Bukkit.getPlayer(args[0]);
        double distance = ((Player) sender).getLocation().distance(p1.getLocation());
        sender.sendMessage("Distance: " + distance);
        return true;
    }
}
