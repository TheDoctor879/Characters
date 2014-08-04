package net.valdaycraft.characters.cmd;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatList {
	
	public static void showList(Player player) {
		player.sendMessage(ChatColor.GREEN + "-------" + ChatColor.LIGHT_PURPLE + "{ " + ChatColor.YELLOW + "Chat Channels" + ChatColor.LIGHT_PURPLE + " }" + ChatColor.GREEN + "--------");
		player.sendMessage(ChatColor.LIGHT_PURPLE + "Local" + ChatColor.YELLOW + ": The Official Roleplay Channel");
		player.sendMessage(ChatColor.DARK_GRAY + "Global" + ChatColor.YELLOW + ": Continental Chat Channel");
		player.sendMessage(ChatColor.RED + "Server" + ChatColor.YELLOW + ": Cross-Server Chat Channel");
		player.sendMessage(ChatColor.RED.toString() + ChatColor.YELLOW + ": Coming Soon!");;
	}

}
