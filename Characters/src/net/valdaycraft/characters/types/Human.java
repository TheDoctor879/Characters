package net.valdaycraft.characters.types;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Human {
	
	public static void start() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "Characters: " + ChatColor.YELLOW + "Humans loaded.");
	}
	
	public static void addPlayer(Player player) {
		
	}

}
