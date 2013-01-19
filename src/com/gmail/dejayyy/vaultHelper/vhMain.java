package com.gmail.dejayyy.vaultHelper;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class vhMain extends JavaPlugin {

	
	public void onEnable(){
		
		if(this.getServer().getPluginManager().getPlugin("Vault") == null){
			
			this.getServer().getPluginManager().disablePlugin(this);
			
			this.getLogger().info("Plugin disabled due to Vault not being found!");
		}
		
	}
	
	public void onDisable(){
		
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdL, String[] args)  {
		
		if(!(sender instanceof Player)){
			
			return false;
			
		}
		
		Player player = (Player) sender;
		
		//Economy Usage
		
		if(cmdL.equalsIgnoreCase("TestEconomy")){
			
			Economy econ = VaultAdapter.getEconomy();
			
			EconomyResponse er = econ.depositPlayer(player.getName(), 100);
			
			if(er.transactionSuccess()){
				
				player.sendMessage("You've been given $100! You now have " + er.balance);
				player.sendMessage("You are using " + econ.getName() + " as your economy manager!");
								
			}else{
				
				player.sendMessage("Oops, there was a problem. The error returned: " + er.errorMessage);
			}
			
			return true;
		}
		
		//End Economy Usage
		
		//Permisison Usage
		
		//Please note that bukkit has a built in feature for permissions.... player.hasPermission("Node")
		
		Permission perm = VaultAdapter.getPermissions();
				
		if(cmdL.equalsIgnoreCase("TestPermission")){
			
			if(perm.has(player, "test.permission.node")){
				
				player.sendMessage("You are using " + perm.getName() + " as a permission manager!");
								
			}else{
				
				player.sendMessage("You dont have permission!");
				
			}
			
			return true;
			
		}
		
		//End Permission Usage
		
		return true;
		
	}
}
