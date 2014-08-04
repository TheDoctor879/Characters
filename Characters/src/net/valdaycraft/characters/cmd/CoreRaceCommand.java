package net.valdaycraft.characters.cmd;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import net.valdaycraft.characters.Core;
import net.valdaycraft.characters.HelpCmd;
import net.valdaycraft.core.UUIDFetcher;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CoreRaceCommand implements CommandExecutor {
	
	Core plugin;
	
	HashMap<String, Integer> cooldownPlayers = new HashMap<String, Integer>();
	
	long Second = 20L;
	long Minute = Second*60;
	long Hour = Minute*60;
	long Day = Hour*24;
	long Delay = Day*7;
	
	public CoreRaceCommand(Core iPlugin) {
		this.plugin = iPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equals("r")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
			    if (args.length == 0) {
				HelpCmd.executeRaceHelp(sender);
			    }
			    if (args.length == 1) {
			    	boolean help = args[0].equalsIgnoreCase("help");
				    if (help) {
					    HelpCmd.executeRaceHelp(sender);
				    }
				}
			    if (args.length == 2) {
					boolean inherit = args[0].equalsIgnoreCase("inherit");
					boolean i = args[0].equalsIgnoreCase("i");
					boolean become = args[0].equalsIgnoreCase("become");
					boolean elf = args[1].equalsIgnoreCase("elf");
					boolean human = args[1].equalsIgnoreCase("human");
					boolean dwarf = args[1].equalsIgnoreCase("dwarf");
			    	if (i || inherit || become) {
			    		if (cooldownPlayers.containsKey(player.getName())) {
			    			final Player cooledPlayer = (Player) sender;
			    			final int time = cooldownPlayers.get(cooledPlayer.getName());
			    			if (time > 0) {
			    				Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
									@Override
									public void run() {
										cooldownPlayers.put(cooledPlayer.getName(), time - 1);
									}
			    				}, 0L, 19L);
			    				if (time > Day) {
									long display = time/Day;
									float b = (float) Math.round(display);
									cooledPlayer.sendMessage(ChatColor.RED + "You can not send this command for another " + ChatColor.AQUA + b + " Days.");
								}
								if (time > Hour && time < Day) {
									long display = time/Hour;
									float b = (float) Math.round(display);
									cooledPlayer.sendMessage(ChatColor.RED + "You can not send this command for another " + ChatColor.AQUA + b + " Hour(s).");
								}
								if (time > Minute && time < Hour && time < Day) {
									long display = time/Minute;
									float b = (float) Math.round(display);
									cooledPlayer.sendMessage(ChatColor.RED + "You can not send this command for another " + ChatColor.AQUA + b + " Minute(s).");
								}
								if (time > Second && time < Minute && time < Hour && time < Day) {
									long display = time/Second;
									float b = (float) Math.round(display);
									cooledPlayer.sendMessage(ChatColor.RED + "You can not send this command for another " + ChatColor.AQUA + b + " Second(s).");
								}
			    			} else {
			    				cooldownPlayers.remove(cooledPlayer.getName());
			    				player.sendMessage(ChatColor.GREEN + "Your cooldown has finished. Now please try again.");
			    			}
			    		} else {
			    			if (elf) {
			    				UUID id = null;
			    				try {
									id = UUIDFetcher.getUUIDOf(player.getName());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			    				final File file = new File("ValdayCraft" + File.separator + "Users" + File.separator + id.toString() + ".yml");
			    				final FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			    				if (!config.getString("Race").equalsIgnoreCase("Elf")) {
			    					final Player cooledPlayer = (Player) player;
			    					cooldownPlayers.put(player.getName(), (int) Delay);
			    					player.sendMessage(ChatColor.GREEN + "Please wait while we modify your race...");
			    					Bukkit.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable() {

										@Override
										public void run() {
											config.set("Race", "Elf");
											try {
												config.save(file);
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											cooledPlayer.sendMessage(ChatColor.GREEN + "Done! You are now a " + ChatColor.DARK_GREEN + "Elf");
											cooledPlayer.playSound(cooledPlayer.getLocation(), Sound.SHOOT_ARROW, (float) 1, (float) 1);
										}
			    					}, 40L);
			    				}
			    				if (config.getString("Race").equalsIgnoreCase("Elf")) {
			    					player.sendMessage(ChatColor.DARK_RED + "You are already this race. Sorry to disappoint you.");
			    				}
			    			}
			    			if (human) {
			    				UUID id = null;
			    				try {
									id = UUIDFetcher.getUUIDOf(player.getName());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			    				final File file = new File("ValdayCraft" + File.separator + "Users" + File.separator + id.toString() + ".yml");
			    				final FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			    				if (!config.getString("Race").equalsIgnoreCase("Human")) {
			    					final Player cooledPlayer = (Player) player;
			    					cooldownPlayers.put(player.getName(), (int) Delay);
			    					player.sendMessage(ChatColor.GREEN + "Please wait while we modify your race...");
			    					Bukkit.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable() {

										@Override
										public void run() {
											config.set("Race", "Human");
											try {
												config.save(file);
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											cooledPlayer.sendMessage(ChatColor.GREEN + "Done! You are now a " + ChatColor.DARK_GRAY + "Human");
											cooledPlayer.playSound(cooledPlayer.getLocation(), Sound.FIRE_IGNITE, (float) 1, (float) 1);
										}
			    					}, 40L);
			    				}
			    				if (config.getString("Race").equalsIgnoreCase("Human")) {
			    					player.sendMessage(ChatColor.DARK_RED + "You are already this race. Sorry to disappoint you.");
			    				}
			    			}
			    			if (dwarf) {
			    				UUID id = null;
			    				try {
									id = UUIDFetcher.getUUIDOf(player.getName());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			    				final File file = new File("ValdayCraft" + File.separator + "Users" + File.separator + id.toString() + ".yml");
			    				final FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			    				final Player cooledPlayer = (Player) player;
			    				if (!config.getString("Race").equalsIgnoreCase("Dwarf")) {
			    					cooldownPlayers.put(player.getName(), (int) Delay);
			    					player.sendMessage(ChatColor.GREEN + "Please wait while we modify your race...");
			    					Bukkit.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable() {

										@Override
										public void run() {
											try {
												config.save(file);
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											cooledPlayer.sendMessage(ChatColor.GREEN + "Done! You are now a " + ChatColor.DARK_AQUA + "Dwarf");
											cooledPlayer.playSound(cooledPlayer.getLocation(), Sound.DIG_STONE, (float) 1, (float) 1);
										}
			    					}, 40L);
			    				}
			    				if (config.getString("Race").equalsIgnoreCase("Dwarf")) {
			    					player.sendMessage(ChatColor.DARK_RED + "You are already this race. Sorry to disappoint you.");
			    				}
			    			}
			    		}
			    	}
			    }
			}
		}
		return true;
	}

}
