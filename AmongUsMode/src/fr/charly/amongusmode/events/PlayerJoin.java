package fr.charly.amongusmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.charly.amongusmode.commands.CommandTest;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = (Player) e.getPlayer();
		
		e.setJoinMessage("Bienvenue sur le serveur");
		
		CommandTest.onlinePlayers.add(p);
		
		//Ne peut pas prendre d'item
		p.setCanPickupItems(false);
		//N'as pas de collisions
		p.setCollidable(false);
		//Clear son inventaire
		//p.getInventory().clear();
	}	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = (Player) e.getPlayer();
		
		CommandTest.onlinePlayers.remove(p);
	}
	
		
	}
	
