package net.valdaycraft.characters.craftcitizen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.valdaycraft.characters.Core;
import net.valdaycraft.characters.craftcitizen.events.LocksmithBoolean;
import net.valdaycraft.core.UUIDFetcher;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TutorialLocksmith implements Listener {
	
	LocksmithBoolean lmb;
	
	static File f = new File("ValdayCraft" + File.separator + "Tutorials" + File.separator + "Locksmith.yml");
	static FileConfiguration config = YamlConfiguration.loadConfiguration(f);
	
	Core plugin;
	
	public static List<String> educatedLock = new ArrayList<String>(config.getStringList("Blacksmiths"));
	
	public static boolean isSpeaking = false;
	
	boolean yes = LocksmithBoolean.requestsYes;
	
	@EventHandler
	public void isTutorialNPC(NPCRightClickEvent e) {
		if (e.getNPC().getName().contains("Locksmith Jeff")) {
			UUID id = null;
			try {
				id = UUIDFetcher.getUUIDOf(e.getClicker().getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (!educatedLock.contains(id.toString())) {
				final UUID uid = id;
				Player p = e.getClicker();
				isSpeaking = true;
				p.sendMessage(ChatColor.GREEN + "Jeff" + ChatColor.WHITE + ": Why, hello there. I do not believe we've met before. Allow me to introduce myself, my name is Jeff, I am the local locksmith."
						+ "\n" + ChatColor.GREEN + "Jeff" + ChatColor.WHITE + ": Because of recent break ins in Quaderian homes, I am requested by authorities to teach you how to lock your things. Do you wish to know how? ");
				final Player pl = p; 
				Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {

					@Override
					public void run() {
						if (yes) {
							pl.sendMessage(ChatColor.GREEN + "Jeff" + ChatColor.WHITE + ": Good choice! *Jeff reaches into his drawer, then takes out a book.* Read this, this book will describe to you how to lock and secure your chests. Good luck out there!");
							pl.sendMessage(ChatColor.GOLD + "Achievment Tracker: " + ChatColor.YELLOW + "You have received the chestlocker achivment.");
							educatedLock.add(uid.toString());
						}
						else {
							pl.sendMessage(ChatColor.GREEN + "Jeff" + ChatColor.WHITE + ": Oh well, a brave one I see. Good luck, I hope you come back and change your mind.");
						}
					}
				}, 17L);
			} else {
				Player player = e.getClicker();
				Random r = new Random();
				if (r.nextInt(2) == 0) {
				    player.sendMessage(ChatColor.GREEN + "Jeff" + ChatColor.WHITE + ": Hello sir, I hope ");
				}
				if (r.nextInt(2) == 1) {
					player.sendMessage(ChatColor.GREEN + "Jeff" + ChatColor.WHITE + ": Tell your friends all about my shop and tutorials. You know they'll like it.");
				}
				if (r.nextInt(2) == 1) {
					player.sendMessage(ChatColor.GREEN + "Jeff" + ChatColor.WHITE + ": I hope I'm not to complicating, that ruins business you know?");
				}
			}
		}
	}
}
