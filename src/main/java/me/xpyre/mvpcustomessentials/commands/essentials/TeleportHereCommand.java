package me.xpyre.mvpcustomessentials.commands.essentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportHereCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("m.tphere")) {
                if (args.length > 0) {
                    Player p = Bukkit.getPlayer(args[0]);
                    if (p != null) {
                        p.teleport(player.getLocation());
                    } else {
                        sender.sendMessage(ChatColor.RED + "Their is either no such player or player is offline");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Must use /tphere <player>");
                }
            } else {
                sender.sendMessage((ChatColor.RED + "You Do not have permission to use this command"));

            }
        } else {
            sender.sendMessage(ChatColor.RED + "Error: The console can not use this command!");

        }

        return true;

    }
}