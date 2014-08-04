package net.valdaycraft.characters;

import net.valdaycraft.characters.cmd.CoreRaceCommand;
import net.valdaycraft.characters.types.Human;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Characters" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "Checking for ValdayCore's stability check...");
		if (!checkValdayCore()) {
			getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Characters" + ChatColor.GRAY + ": " + ChatColor.DARK_RED + "Startup Error: " + ChatColor.RED + "Could not locate 'ValdayCore' in dir/plugins, please try again.");
			getServer().getPluginManager().disablePlugin(this);
		} else {
			Human.start();
			getCommand("r").setExecutor(new CoreRaceCommand(this));
		}
	}
	private boolean checkValdayCore() {
		boolean b = false;
		if (getServer().getPluginManager().getPlugin("ValdayCore").isEnabled()) {
			b = true;
		}
		else if (!getServer().getPluginManager().getPlugin("ValdayCore").isEnabled()) {
			b = false;
		}
		return b;
	}
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Characters" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "Unloaded Characters. All data has been logged.");
	}
}
