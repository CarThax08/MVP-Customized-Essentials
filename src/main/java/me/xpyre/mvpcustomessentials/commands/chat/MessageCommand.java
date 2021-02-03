package me.xpyre.mvpcustomessentials.commands.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player)commandSender;
            if(player.hasPermission("m.msg")) {
                if (strings.length <= 1) {
                    player.sendMessage(ChatColor.RED + "You did not provide enough information");
                    return false;
                } else {
                    Player player1 = Bukkit.getPlayer(strings[0]);
                    if(player1 != null) {
                        StringBuilder message = new StringBuilder();
                        for (String string : strings) {
                            message.append(string).append(" ");

                        }
                        player1.sendMessage(player.getName() + "--->" + message);
                        return true;
                    }else{
                        player.sendMessage(ChatColor.RED + "That player does not exist!");
                        return true;
                    }
                }
            }else{
                player.sendMessage(ChatColor.RED + "You don't have the required permissions to run this command!");
                return true;
            }

        }else{
            return true;

        }

    }
}
