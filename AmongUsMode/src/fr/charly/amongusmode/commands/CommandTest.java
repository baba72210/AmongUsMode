package fr.charly.amongusmode.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandTest implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {


		if(sender instanceof Player) {
			Player player = (Player)sender;
			//�p�e impostor ONE SHOT
			if(cmd.getName().equalsIgnoreCase("impostor") ) {
				String name = player.getName();
				player.sendMessage("�4Impostor " + name + ", get your weapon !"); //Changer pour la couleur
				//Cr�ation du kill
				ItemStack impSword = new ItemStack(Material.IRON_SWORD);
				//Cr�ation du sabotage des communications
				ItemStack impComm = new ItemStack(Material.REDSTONE_BLOCK);
				//Cr�ation du sabotage du r�acteur
				ItemStack impReact = new ItemStack(Material.TNT);
				//Cr�ation du sabotage des lights
				ItemStack impLight = new ItemStack(Material.LEGACY_REDSTONE_LAMP_ON);
				//Cr�ation du sabotage des portes
				ItemStack impDoor1 = new ItemStack(Material.IRON_DOOR);
				ItemStack impDoor2 = new ItemStack(Material.OAK_DOOR);
				ItemStack impDoor3 = new ItemStack(Material.SPRUCE_DOOR);
				ItemStack impDoor4 = new ItemStack(Material.JUNGLE_DOOR);

				//Cr�ation des attributs
				ItemMeta impSwordM = impSword.getItemMeta();
				ItemMeta impCommM = impComm.getItemMeta();
				ItemMeta impReactM = impReact.getItemMeta();
				ItemMeta impLightM = impLight.getItemMeta();
				ItemMeta impDoor1M = impDoor1.getItemMeta();
				ItemMeta impDoor2M = impDoor2.getItemMeta();
				ItemMeta impDoor3M = impDoor3.getItemMeta();
				ItemMeta impDoor4M = impDoor4.getItemMeta();

				//D�finition des attributs
				impSwordM.setUnbreakable(true);
				impSwordM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impSwordM.setDisplayName("Kill");
				
				impSwordM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
				impSwordM.addItemFlags(ItemFlag.HIDE_ENCHANTS);

				impCommM.setUnbreakable(true);
				impCommM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impCommM.setDisplayName("Communication");

				impReactM.setUnbreakable(true);
				impReactM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impReactM.setDisplayName("Reactor");

				impLightM.setUnbreakable(true);
				impLightM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impLightM.setDisplayName("Light");

				impDoor1M.setUnbreakable(true);
				impDoor1M.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impDoor1M.setDisplayName("Lock Cafeteria");

				impDoor2M.setUnbreakable(true);
				impDoor2M.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impDoor2M.setDisplayName("Lock Electrical");

				impDoor3M.setUnbreakable(true);
				impDoor3M.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impDoor3M.setDisplayName("Lock Engine");

				impDoor4M.setUnbreakable(true);
				impDoor4M.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impDoor4M.setDisplayName("Lock Storage");

				//Ajout des attributs
				impSword.setItemMeta(impSwordM);
				impComm.setItemMeta(impCommM);
				impReact.setItemMeta(impReactM);
				impLight.setItemMeta(impLightM);
				impDoor1.setItemMeta(impDoor1M);
				impDoor2.setItemMeta(impDoor2M);
				impDoor3.setItemMeta(impDoor3M);
				impDoor4.setItemMeta(impDoor4M);
				
				//Clear et ajout des objets en main
				player.getInventory().clear();
				player.getInventory().addItem(impSword);
				player.getInventory().addItem(impComm);
				player.getInventory().addItem(impReact);
				player.getInventory().addItem(impLight);
				player.getInventory().addItem(impDoor1);
				player.getInventory().addItem(impDoor2);
				player.getInventory().addItem(impDoor3);
				player.getInventory().addItem(impDoor4);
				player.updateInventory();
				return true;
			}




			if(cmd.getName().equalsIgnoreCase("test")) {
				player.sendMessage("Bravo tu as r�ussi le test");
				return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("GoInVent")){
				player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999,255),true);
			}
		}
		return false;
	}
}
