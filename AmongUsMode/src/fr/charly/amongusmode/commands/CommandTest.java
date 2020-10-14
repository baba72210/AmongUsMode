package fr.charly.amongusmode.commands;

import java.util.ArrayList;
import java.util.List;

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

	public static List<Player> onlinePlayers = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {


		if(sender instanceof Player) {
			//épée impostor ONE SHOT
			if(cmd.getName().equalsIgnoreCase("impostor") ) {
				//On rend le sender en player pour mieux l'utiliser
				Player player = (Player)sender;
				String name = player.getName();
				player.sendMessage("§4Impostor " + name + ", get your weapon !"); //Changer pour la couleur
				//Création du kill
				ItemStack impSword = new ItemStack(Material.IRON_SWORD);
				//Création du sabotage des communications
				ItemStack impComm = new ItemStack(Material.REDSTONE_BLOCK);
				//Création du sabotage du réacteur
				ItemStack impReact = new ItemStack(Material.TNT);
				//Création du sabotage des lights
				ItemStack impLight = new ItemStack(Material.LEGACY_REDSTONE_TORCH_ON);
				//Création du sabotage des portes
				ItemStack impDoor1 = new ItemStack(Material.IRON_DOOR);
				ItemStack impDoor2 = new ItemStack(Material.OAK_DOOR);
				ItemStack impDoor3 = new ItemStack(Material.SPRUCE_DOOR);
				ItemStack impDoor4 = new ItemStack(Material.JUNGLE_DOOR);
				//Création du réport
				ItemStack report = new ItemStack(Material.LEGACY_REDSTONE_LAMP_OFF);

				//Création des attributs
				ItemMeta impSwordM = impSword.getItemMeta();
				ItemMeta impCommM = impComm.getItemMeta();
				ItemMeta impReactM = impReact.getItemMeta();
				ItemMeta impLightM = impLight.getItemMeta();
				ItemMeta impDoor1M = impDoor1.getItemMeta();
				ItemMeta impDoor2M = impDoor2.getItemMeta();
				ItemMeta impDoor3M = impDoor3.getItemMeta();
				ItemMeta impDoor4M = impDoor4.getItemMeta();
				ItemMeta reportM = report.getItemMeta();

				//Définition des attributs
				impSwordM.setUnbreakable(true);
				impSwordM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				impSwordM.setDisplayName("§4KILL");
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

				reportM.setUnbreakable(true);
				reportM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				reportM.setDisplayName("Report");
				//Ajout des attributs
				impSword.setItemMeta(impSwordM);
				impComm.setItemMeta(impCommM);
				impReact.setItemMeta(impReactM);
				impLight.setItemMeta(impLightM);
				impDoor1.setItemMeta(impDoor1M);
				impDoor2.setItemMeta(impDoor2M);
				impDoor3.setItemMeta(impDoor3M);
				impDoor4.setItemMeta(impDoor4M);
				report.setItemMeta(reportM);
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
				player.getInventory().addItem(report);
				player.updateInventory();
				return true;
			}


			if(cmd.getName().equalsIgnoreCase("teamSet")) {
				List<Player> impostors = new ArrayList<Player>();
				List<Player> crewMates = new ArrayList<Player>();
				for(Player p : onlinePlayers) {
					if (p.getScoreboardTags().contains("amongUs")) {
						crewMates.add(p);
					}
				}
				int numImpostor = (int)(Math.random() * (crewMates.size() + 1));
				impostors.add(crewMates.get(numImpostor));
				crewMates.remove(numImpostor);
				numImpostor = (int)(Math.random() * (crewMates.size() + 1));
				impostors.add(crewMates.get(numImpostor));
				crewMates.remove(numImpostor);
			}
		}

		//commande de test team
		if(cmd.getName().equalsIgnoreCase("teamcheck")) {
			for(Player p : onlinePlayers) {

			}
			return true;
		}


		else if(cmd.getName().equalsIgnoreCase("test")) {
			sender.sendMessage("Bravo tu as réussi le test");
			return true;
		}

		return false;
	}
}
