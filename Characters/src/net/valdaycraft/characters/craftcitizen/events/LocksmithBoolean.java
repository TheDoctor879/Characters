package net.valdaycraft.characters.craftcitizen.events;

import net.valdaycraft.characters.craftcitizen.TutorialLocksmith;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LocksmithBoolean implements Listener {
	
	static boolean isSpeaking = TutorialLocksmith.isSpeaking;
	
	public static boolean requestsYes = false;
	
	public static boolean requesting(Player p) {
		return isSpeaking;
	}
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (isSpeaking) {
			e.setCancelled(true);
			if (e.getMessage().contains("Yes") || e.getMessage().contains("yeah")) {
				requestsYes = true;
			} else {
				requestsYes = false;
			}
		}
	}
}
