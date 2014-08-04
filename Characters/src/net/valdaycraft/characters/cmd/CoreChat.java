package net.valdaycraft.characters.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.valdaycraft.characters.ChatHelpCmd;
import net.valdaycraft.characters.Core;

public class CoreChat implements CommandExecutor {
	
	Core plugin;
	
	public CoreChat(Core iPlugin) {
		this.plugin = iPlugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean list = args[0].equalsIgnoreCase("list");
		if (cmd.getName().equalsIgnoreCase("ch")) {
			Player player = (Player) sender;
			if (args.length == 0) {
				ChatHelpCmd.displayFor(player);
			}
			if (args.length == 1) {
				if (list) {
					
				}
			}
		}
		return true;
	}
}
