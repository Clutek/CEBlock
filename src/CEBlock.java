package com.gmail.tclunan;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CEBlock extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable(){
		getLogger().info("CEBlock has been enabled, enchanting while in creative is disabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable(){
		getLogger().info("CEBlock has been disabled, enchanting while in creative is enabled!");
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if (event.getClickedBlock().getType().equals(Material.ENCHANTMENT_TABLE)){
				if (player.getGameMode().equals(GameMode.CREATIVE) && player.isOp() == false){
					player.sendMessage(ChatColor.RED + "You can not enchant while in creative!");
					event.setCancelled(true);
				}
			}
		}
	}
}
