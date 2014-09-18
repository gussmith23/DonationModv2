package com.gus.donationMod;

import org.bukkit.block.Chest;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

public class DonationModPlayerListener extends PlayerListener{
	
	DonationMod plugin;

	public DonationModPlayerListener(DonationMod donationMod) {
		// TODO Auto-generated constructor stub
		
		plugin = donationMod;
		
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerInteract(event);
		
		
		//if player called setdonationchest
		if(DonationModData.didPlayerCallCommand.get(event.getPlayer()) == true){
				
			//if the block clicked was a chest
			if(event.getClickedBlock().getState() instanceof Chest){
				
				event.getPlayer().sendMessage("Valid chest!");
				DonationMod.log.info(event.getPlayer().getName() + " set a new donation chest.");
				
				new DonationChest(DonationModData.setDonationChestChestName, event.getClickedBlock().getWorld(), event.getClickedBlock().getLocation());
				
			}else event.getPlayer().sendMessage("Please click a valid chest.");
			
			DonationModData.didPlayerCallCommand.put(event.getPlayer(), false);
			
		}
	}
	
	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerJoin(event);
		
		DonationModData.didPlayerCallCommand.put(event.getPlayer(), false);
		
	}
	
	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerQuit(event);
	
		DonationModData.didPlayerCallCommand.put(event.getPlayer(), false);
		
	}
	
}
