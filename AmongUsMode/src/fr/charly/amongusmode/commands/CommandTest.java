package fr.charly.amongusmode.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {
		// TODO Auto-generated method stub
		
		sender.sendMessage("Bravo tu as réussi le test");
		return false;
	}

}
