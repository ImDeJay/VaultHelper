package com.gmail.dejayyy.vaultHelper;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultAdapter {
    private static final String VAULT = "Vault";

    private static Economy ecoVault = null;
    private static Permission permVault = null;
    private static boolean vaultLoaded = false;
    
    public static Economy getEconomy(){
        if(!vaultLoaded){
            vaultLoaded = true;
            Server theServer = Bukkit.getServer();
            if (theServer.getPluginManager().getPlugin(VAULT) != null){
                RegisteredServiceProvider<Economy> rsp = theServer.getServicesManager().getRegistration(Economy.class);
                if(rsp!=null){
                   ecoVault = rsp.getProvider();
                }
            }
        }
               
        return ecoVault;
    }    
    
    
    
    public static Permission getPermissions(){
        if(!vaultLoaded){
            vaultLoaded = true;
            Server theServer = Bukkit.getServer();
            if (theServer.getPluginManager().getPlugin(VAULT) != null){
                RegisteredServiceProvider<Permission> rsp = theServer.getServicesManager().getRegistration(Permission.class);
                if(rsp!=null){
                    permVault = rsp.getProvider();
                }
            }
        }
               
        return permVault;
    }
    
    
    
}