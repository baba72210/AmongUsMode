package fr.charly.amongusmode.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {


		//�p�e impostor ONE SHOT
		if(cmd.getName().equalsIgnoreCase("impostor") && sender instanceof Player) {
			//On rend le sender en player pour mieux l'utiliser
			Player player = (Player)sender;
			String name = player.getName();
			player.sendMessage("�4Impostor " + name + ", get your weapon !"); //Changer pour la couleur
			//Cr�ation de l'�p�e
			ItemStack impostorSword = new ItemStack(Material.IRON_SWORD);
			//Cr�ation des attributs de l'�p�e
			ItemMeta impostorSwordM = impostorSword.getItemMeta();
			impostorSwordM.setUnbreakable(true);
			impostorSwordM.setDisplayName("�4KILL");
			impostorSwordM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
			impostorSwordM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			impostorSwordM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			//Ajout des attributs � l'�p�e
			impostorSword.setItemMeta(impostorSwordM);
			//Clear et ajoute l'�p�e
			player.getInventory().clear();
			player.getInventory().addItem(impostorSword);
			player.updateInventory();
			return true;
		}

		else if(cmd.getName().equalsIgnoreCase("test")) {
			sender.sendMessage("Bravo tu as r�ussi le test");
			return true;
		}
		return false;
	}

}
