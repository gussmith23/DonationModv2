package com.gus.donationMod;

import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.World;

public class DonationChest {
	
	public Location location;
	public World world;
	public String name;
	
	public DonationChest(String name, World world, Location location){
		
		this.location = location;
		this.world = world;
		this.name = name;
		
		DonationModData.chests.put(name, this);
		
		DonationMod.config.set("chests." + name + ".x", location.getBlockX());
		DonationMod.config.set("chests." + name + ".y", location.getBlockY());
		DonationMod.config.set("chests." + name + ".z", location.getBlockZ());
		DonationMod.config.set("chests." + name + ".world", location.getWorld().getName());
		DonationMod.config.set("chests." + name + ".name", name);
		try {
			DonationMod.config.save(DonationMod.configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
