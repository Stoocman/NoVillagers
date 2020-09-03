package org.valere.novillagers.version;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import java.util.Arrays;
import java.util.List;

public class Version {

    private static final String version = getBukkitVersion();
    private static final List<String> supported = Arrays.asList(
            "1_16_R1",
            "1_15_R1");

    public static boolean checkBukkitVersion(Plugin plugin){
        if(!supported.contains(version)){
            plugin.getLogger().warning("This plugin doesn't support your bukkit org.stoocman.mesos.version:"+version);
            Bukkit.getPluginManager().disablePlugin(plugin);
            return false;
        }
        return true;
    }

    public static String getBukkitVersion(){
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].substring(1);
    }

    public static String getVersion(){
        return version;
    }
}