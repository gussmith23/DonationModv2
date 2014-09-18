/**
 * 
 */
package com.gus.donationMod;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Gus
 *
 */
public class DonationMod extends JavaPlugin{
	
	static Logger log;
	final public String filePath = "plugins" + File.separator + "DonationMod";
	static File configFile;
	static FileConfiguration config;
	PluginManager pm;
	DonationModPlayerListener playerListener;
	List<String> chests;

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
		playerListener = new DonationModPlayerListener(this);
		
		log = this.getServer().getLogger();
		
		pm = this.getServer().getPluginManager();
		
		new File(filePath).mkdir();
		configFile = new File(filePath +File.separator + "config.yml");
		try {
			configFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		config = this.getConfig();
		
		addChestsOnEnable();
		
		
		
		Player[] connectedPlayers = this.getServer().getOnlinePlayers();
		for(int index = 0;index<connectedPlayers.length;index++){
			DonationModData.didPlayerCallCommand.put(connectedPlayers[index], false);
		}
		
		pm.registerEvent(Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_QUIT, playerListener, Event.Priority.Normal, this);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//setdonationchest command
		if(command.getName().equalsIgnoreCase("setdonationchest")){
			
			//if a player called it
			if(sender instanceof Player){
				
			
				//this is how long it should be
				if(args.length==1){
					
					DonationModData.setDonationChestChestName = args[0];
					
					DonationModData.didPlayerCallCommand.put((Player)sender, true);
					
					sender.sendMessage("Click on a chest to set it up for donations.");
					
					return true;
					
				}
			}
				
		}
		
		
		return super.onCommand(sender, command, label, args);
	}
	
	void addChestsOnEnable(){
		
		chests.set(0, "hi");
		log.info(""+chests.size());
	}
		
	

}
