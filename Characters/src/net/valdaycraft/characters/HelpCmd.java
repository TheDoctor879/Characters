package net.valdaycraft.characters;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCmd {
	
	public static void executeRaceHelp(CommandSender player) {	
		player.sendMessage(ChatColor.GREEN + "[]=========={ " + ChatColor.AQUA + "Characters" + ChatColor.GREEN + " }==========[]");
		player.sendMessage(ChatColor.AQUA + "/r, i {inherit, become} <race>" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "Sets your current race to the one specified.");
		player.sendMessage(ChatColor.AQUA + "/r, c {check, find} <PlayerName>" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "Finds the race of the specified player.");
		player.sendMessage(ChatColor.AQUA + "/r, in {info, features, f} <Race>" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "Checks all features and abilities of the specified race.");
		player.sendMessage(ChatColor.AQUA + "/r, p {population} <Race>" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "Checks how many players inherit the following race.");
	}
}
