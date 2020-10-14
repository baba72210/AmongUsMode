package fr.charly.amongusmode.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {
		
		
		
		if(cmd.getName().equalsIgnoreCase("impostor") && sender instanceof Player) {
			Player player = (Player)sender;
			String name = player.getName();
			player.sendMessage("&4Impostor " + name + ", get your weapon !");
			player.getInventory().clear();
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			return true;
		}
		sender.sendMessage("Bravo tu as réussi le test");
		return false;
	}

}
