package com.gus.donationMod;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class DonationModData {
	
	static String setDonationChestChestName;
	static HashMap<Player, Boolean> didPlayerCallCommand = new HashMap<Player,Boolean>();
	static HashMap<String, DonationChest> chests = new HashMap<String, DonationChest>();

}
