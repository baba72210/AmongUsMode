package fr.charly.amongusmode;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	/*
	 * Messages au lancement et fin du plugin
	 */
	@Override
	public void onEnable() {
		System.out.println("Plug ON");
	}
	@Override
	public void onDisable() {
		System.out.println("Plug OFF");
	}
	
	
}
