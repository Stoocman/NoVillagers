package org.valere.novillagers.abstraction;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;

public class NoVillager_1_16_R1 implements NoVillagerInternals {

    @Override
    public void get() {
        CraftEntity en;
        Bukkit.getLogger().info("1.16.1");
    }
}