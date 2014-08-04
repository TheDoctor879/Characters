package net.valdaycraft.characters.chats;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.valdaycraft.core.UUIDFetcher;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class LocalChannel {
	
	public static List<UUID> localChatList = new ArrayList<UUID>();
	
	public static void startup() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Set up the " + ChatColor.WHITE + "Local" + ChatColor.GREEN + " chat channel.");
	}
	public void addPlayer(Player player) {
		UUID playerId = null;
		try {
			playerId = UUIDFetcher.getUUIDOf(player.getName());
		} catch (Exception e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Warning: " + ChatColor.RED + "Could not pass " + player.getName() + " to the 'Local' Chat Channel.");
			e.printStackTrace();
		}
		localChatList.add(playerId);
		player.sendMessage(ChatColor.YELLOW + "You have joined the " + ChatColor.GREEN + "Local" + ChatColor.YELLOW + " Chat Channel.");
	}
	public void removePlayer(Player player) {
		UUID playerId = null;
		try {
			playerId = UUIDFetcher.getUUIDOf(player.getName());
		} catch (Exception e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Warning: " + ChatColor.RED + "Could not pass " + player.getName() + " to the 'Local' Chat Channel.");
			e.printStackTrace();
		}
		localChatList.remove(playerId);
		player.sendMessage(ChatColor.YELLOW + "You have left the " + ChatColor.GREEN + "Local" + ChatColor.YELLOW + " Chat Channel");
	}
}
