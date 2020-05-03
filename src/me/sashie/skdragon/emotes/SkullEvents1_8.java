/*
	This file is part of skDragon - A Skript addon
      
	Copyright (C) 2016 - 2020  Sashie

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.sashie.skdragon.emotes;

//import org.bukkit.Bukkit;

//import static ud.skript.sashie.skDragon.emojis.SkullEffectsLib.removeSkull;

import org.bukkit.Material;
//import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class SkullEvents1_8 implements Listener {


    @EventHandler(priority = EventPriority.LOWEST)
    public void cancelMove(InventoryClickEvent event) {
    	Player player = (Player) event.getWhoClicked();
        if ((event.getSlot() < event.getInventory().getSize() || event.getRawSlot() < event.getInventory().getSize() || event.isShiftClick())
        		&& event.getCursor() != null
        		&& event.getCursor().hasItemMeta()
        		&& event.getCursor().getItemMeta().hasDisplayName()
        		&& event.getCursor().getItemMeta().getDisplayName().equals("§b§lEMOTE-" + player.getUniqueId().toString())) {
            event.setCancelled(true);
        }
        
        if(event.getInventory().getType() == InventoryType.PLAYER 
    			&& event.getCurrentItem() != null
                && event.getCurrentItem().hasItemMeta()
                && event.getCurrentItem().getItemMeta().hasDisplayName()
                && event.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lEMOTE-" + player.getUniqueId().toString())) {
            player.getInventory().remove(event.getCurrentItem());
            player.getInventory().removeItem(event.getCurrentItem());
            player.closeInventory();
            return;
    	}
        
        if (SkullEffectsLib.emotelist.containsKey(player.getUniqueId().toString())) {
        	

            if ((event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) && (event.getCursor() == null || event.getCursor().getType() == Material.AIR)) {
                event.setCancelled(true);
                player.updateInventory();
                return;
            }

            if (event.getCurrentItem() != null
                    && event.getCurrentItem().hasItemMeta()
                    && event.getCurrentItem().getItemMeta().hasDisplayName()
                    && event.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lEMOTE-" + player.getUniqueId().toString())) {
                player.getInventory().remove(event.getCurrentItem());
                player.getInventory().removeItem(event.getCurrentItem());
            	//removeSkull(player);
            	event.setCancelled(true);
                player.updateInventory();
                return;
            }
            
            if(event.getAction() == InventoryAction.HOTBAR_MOVE_AND_READD 
            		|| event.getAction() == InventoryAction.HOTBAR_SWAP 
            		|| event.getAction() == InventoryAction.PLACE_ALL 
            		&& event.getCurrentItem() != null
            		&& event.getCurrentItem().hasItemMeta()
                    && event.getCurrentItem().getItemMeta().hasDisplayName()
                    && event.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lEMOTE-" + player.getUniqueId().toString())) {
            	//Bukkit.getServer().broadcastMessage("[skDragon] 4");
                player.getInventory().remove(event.getCurrentItem());
                player.getInventory().removeItem(event.getCurrentItem());
                //removeSkull(player);
            	event.setCancelled(true);
                player.updateInventory();
                return;
        	}
        }
    }

    @EventHandler
    public void cancelDrag(InventoryDragEvent event) {
        for (ItemStack item : event.getNewItems().values()) {
            if (item != null
                    && item.hasItemMeta()
                    && item.getItemMeta().hasDisplayName()
                    && item.getItemMeta().getDisplayName().equals("§b§lEMOTE-" + ((Player) event.getWhoClicked()).getUniqueId().toString())) {
                event.setCancelled(true);
                ((Player) event.getWhoClicked()).updateInventory();
                return;
            }
        }
    }
    
	@EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().hasItemMeta()
                && event.getItemDrop().getItemStack().getItemMeta().hasDisplayName()
                && event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§b§lEMOTE-" + event.getPlayer().getUniqueId().toString())) {
            event.getItemDrop().remove();
            event.getPlayer().updateInventory();
        }
    }
    
    @EventHandler
    public void onPlayerPickUpItem(PlayerPickupItemEvent event) {
        if (event.getItem().getItemStack() != null
                && event.getItem().getItemStack().hasItemMeta()
                && event.getItem().getItemStack().getItemMeta().hasDisplayName()
                && event.getItem().getItemStack().getItemMeta().getDisplayName().equals("§b§lEMOTE-" + event.getPlayer().getUniqueId().toString())) {
            event.setCancelled(true);
            event.getItem().remove();
        }
    }
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
    	//Bukkit.getServer().broadcastMessage("[skDragon] player joined test");
    	Player player = event.getPlayer();
		
    	for (ItemStack item : player.getInventory().getArmorContents()) {
			if (item != null) {
				if (item.hasItemMeta() 
						&& item.getItemMeta().hasDisplayName() 
						&& item.getItemMeta().getDisplayName().equals("§b§lEMOTE-" + player.getUniqueId().toString())) {
					player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
	            	player.getInventory().removeItem(item);
				}
            }
		}
    	
    	
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
    	SkullEffectsLib.stopEffect(event.getPlayer());
    }
    
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
    	SkullEffectsLib.stopEffect(event.getPlayer());
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
    	SkullEffectsLib.stopEffect(event.getEntity());
    }
}
