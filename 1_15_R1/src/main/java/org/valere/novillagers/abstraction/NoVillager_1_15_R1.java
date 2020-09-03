package org.valere.novillagers.abstraction;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftEntity;

public class NoVillager_1_15_R1 implements NoVillagerInternals {

    @Override
    public void get() {
        CraftEntity en;
        Bukkit.getLogger().info("1.15.1");
    }
}