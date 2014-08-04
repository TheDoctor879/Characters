package net.valdaycraft.characters;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatHelpCmd {
	
	public static void displayFor(Player player) {
		player.sendMessage(ChatColor.AQUA + "--------" + ChatColor.RED + "{ " + ChatColor.GOLD + "Characters Help" + ChatColor.RED + " }" + ChatColor.AQUA + "--------");
		player.sendMessage(ChatColor.GOLD + "/ch s, speak <Channel>" + ChatColor.YELLOW + ": Speak in a specific chat channel.");
		player.sendMessage(ChatColor.GOLD + "/ch j, join <Channel>" + ChatColor.YELLOW + ": Listen to the according channel.");
		player.sendMessage(ChatColor.GOLD + "/ch l, leave <Channel>" + ChatColor.YELLOW + ": Stop listening to the according channel.");
		player.sendMessage(ChatColor.GOLD + "/ch l, list" + ChatColor.YELLOW + ": List all available chat channels.");
		player.sendMessage(ChatColor.GOLD + "/nick, /n, /nickname" + ChatColor.YELLOW + ": Sets your new roleplay name to be displayed in local channels.");
	}

}
