package fr.charly.amongusmode.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BossBar;
import org.bukkit.boss.KeyedBossBar;
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

public class CommandTestcharly implements CommandExecutor {

	public static List<Player> onlinePlayers = new ArrayList<Player>();
	public static List<Player> impostors = new ArrayList<Player>();
	public static List<Player> crewMates = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {


		if(sender instanceof Player) {
			Player player = (Player)sender;

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
				//if(onlinePlayers.contains(player))player.sendMessage();
				return true;
			}

			if(cmd.getName().equalsIgnoreCase("vote")) {
				double rad=-11* Math.PI/12;
				TimerTask TimeVote
				while 
				for(Player p : onlinePlayers) {//pas opti car on regarde dans tout les joueurs co
					if (p.getScoreboardTags().contains("amongUs")) {
						p.teleport(new Location(p.getWorld(), 4*Math.sin(rad), 4*Math.cos(rad), 10));
						rad+=2*Math.PI/12;
					}
				}
				
				BossBar b = null;
				b.setTitle("");
			}
		}
		return false;

	}
}
