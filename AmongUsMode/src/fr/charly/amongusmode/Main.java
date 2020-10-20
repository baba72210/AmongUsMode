package fr.charly.amongusmode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.plugin.java.JavaPlugin;

import fr.charly.amongusmode.commands.CommandTest;
import fr.charly.amongusmode.events.PlayerJoin;

public class Main extends JavaPlugin {

	/*
	 * Messages au lancement et fin du plugin
	 */
	@Override
	public void onEnable() {
		System.out.println("Le Serveur vient de s'allumer");
		Bukkit.setDefaultGameMode(GameMode.SURVIVAL);
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(),this);
		getCommand("test").setExecutor(new CommandTest());
		getCommand("impostor").setExecutor(new CommandTest());
		getCommand("teamCheck").setExecutor(new CommandTest());
		getCommand("teamSet").setExecutor(new CommandTest());
		getCommand("vote").setExecutor(new CommandTest());
	}
	@Override
	public void onDisable() {
		System.out.println("Plug OFF");
	}
	
}
