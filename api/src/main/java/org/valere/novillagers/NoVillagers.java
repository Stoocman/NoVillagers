package org.valere.novillagers;

import org.bukkit.plugin.java.JavaPlugin;


public class NoVillagers extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        getServer().getPluginManager().registerEvents(new SpawnHandler(),this);
        this.getLogger().info("NoVillagers enabled. No more Villagers will spawn on your server !");
    }

    @Override
    public void onDisable() {
    }
}