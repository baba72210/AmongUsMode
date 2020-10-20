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

public class CommandTest implements CommandExecutor {

	public static List<Player> onlinePlayers = new ArrayList<Player>();
	public static List<Player> impostors = new ArrayList<Player>();
	public static List<Player> crewMates = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {


		if(sender instanceof Player) {
			Player player = (Player)sender;
			//épée impostor ONE SHOT
			if(cmd.getName().equalsIgnoreCase("impostor") ) {
				String name = player.getName();
				player.sendMessage("§4Impostor " + name + ", get your weapon !"); //Changer pour la couleur
				//Création du kill
				ItemStack impSword = new ItemStack(Material.IRON_SWORD);
				//Création du sabotage des communications
				ItemStack impComm = new ItemStack(Material.REDSTONE_BLOCK);
				//Création du sabotage du réacteur
				ItemStack impReact = new ItemStack(Material.TNT);
				//Création du sabotage des lights
				ItemStack impLight = new ItemStack(Material.LEGACY_REDSTONE_LAMP_ON);
				//Création du sabotage des portes
				ItemStack impDoor1 = new ItemStack(Material.IRON_DOOR);
				ItemStack impDoor2 = new ItemStack(Material.OAK_DOOR);
				ItemStack impDoor3 = new ItemStack(Material.SPRUCE_DOOR);
				ItemStack impDoor4 = new ItemStack(Material.JUNGLE_DOOR);

				//Création des attributs
				ItemMeta impSwordM = impSword.getItemMeta();
				ItemMeta impCommM = impComm.getItemMeta();
				ItemMeta impReactM = impReact.getItemMeta();
				ItemMeta impLightM = impLight.getItemMeta();
				ItemMeta impDoor1M = impDoor1.getItemMeta();
				ItemMeta impDoor2M = impDoor2.getItemMeta();
				ItemMeta impDoor3M = impDoor3.getItemMeta();
				ItemMeta impDoor4M = impDoor4.getItemMeta();

				//Définition des attributs
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


			if(cmd.getName().equalsIgnoreCase("teamSet")) {
				//ajout dans les crewmates de tout les joueurs en ligne ayant le tag "amongUs"
				for(Player p : onlinePlayers) {
					if (p.getScoreboardTags().contains("amongUs")) {
						crewMates.add(p);
					}
				}
				//deplacement de deux players de la team crewmate a la team imposteur
				int numImpostor = (int)(Math.random() * (crewMates.size()+1));
				impostors.add(crewMates.get(numImpostor));
				crewMates.remove(numImpostor);
				numImpostor = (int)(Math.random() * (crewMates.size() + 1));
				impostors.add(crewMates.get(numImpostor));
				crewMates.remove(numImpostor);
			}


			//commande de test team
			if(cmd.getName().equalsIgnoreCase("teamcheck")) {
				player.sendMessage("OnlinePlayers:");
				for(Player p : onlinePlayers) {
					player.sendMessage("-"+p.getName());
				}
				player.sendMessage("impostors:");
				for(Player p : impostors) {
					player.sendMessage("-"+p.getName());
				}
				player.sendMessage("crewmates:");
				for(Player p : crewMates) {
					player.sendMessage("-"+p.getName());
				}
				return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("vote")) {
				double rad=-11* Math.PI/12;
				for(Player p : onlinePlayers) {
					if (p.getScoreboardTags().contains("amongUs")) {
						p.teleport(new Location(p.getWorld(), 4*Math.sin(rad), 4*Math.cos(rad), 10));
						rad+=2*Math.PI/12;
					}
				}
				
			}


			if(cmd.getName().equalsIgnoreCase("test")) {
				player.sendMessage("Bravo tu as réussi le test");
				return true;
			}
		}
		return false;
	}
}
