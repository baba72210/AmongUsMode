package fr.charly.amongusmode;

import org.bukkit.plugin.java.JavaPlugin;

import fr.charly.amongusmode.commands.CommandTest;

public class Main extends JavaPlugin {
	
	/*
	 * Messages au lancement et fin du plugin
	 */
	@Override
	public void onEnable() {
		System.out.println("Le Serveur vient de s'allumer");
		getCommand("test").setExecutor(new CommandTest());
	}
	@Override
	public void onDisable() {
		System.out.println("Plug OFF");
	}
	
	
}
