package org.valere.novillagers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityTransformEvent;
import org.bukkit.event.world.ChunkLoadEvent;

import java.util.logging.Logger;

import static org.bukkit.entity.EntityType.ZOMBIE_VILLAGER;

public class SpawnHandler implements Listener {

    Logger logger = Bukkit.getLogger();

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent chunkEvent){
        removeVillagers(chunkEvent);
    }

    @EventHandler
    public void onEntityBreed(EntityBreedEvent event){
        disableBreed(event);
    }

    @EventHandler
    public void entityTransform(EntityTransformEvent event){
        disableCures(event);
    }

    @EventHandler
    public void createSpawn(CreatureSpawnEvent event){
        disableCures(event);
    }


    /**
     * Disable the zombie villager curing for the creature
     * spawn event
     *
     * @param event
     */
    private void disableCures(CreatureSpawnEvent event){
        if(event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CURED && event.getEntityType() == ZOMBIE_VILLAGER){
            event.setCancelled(true);
        }
    }

    /**
     * Disable the zombie villager curing for the transform event
     *
     * @param event
     */
    private void disableCures(EntityTransformEvent event){
        if(event.getEntityType() == ZOMBIE_VILLAGER && event.getTransformReason() == EntityTransformEvent.TransformReason.CURED){
            event.setCancelled(true);
        }
    }

    /**
     * Remove villager when the map load a chunk for
     * the first time
     *
     * @param chunkEvent
     */
    private void removeVillagers(ChunkLoadEvent chunkEvent){
        // When a chunk is loaded
        Entity[] entities = chunkEvent.getChunk().getEntities();
        for (Entity entity:entities) {
            //if the chunk contains Villagers
            if(Villager.class.isAssignableFrom(entity.getClass())){
                entity.remove();
            }
        }
    }

    /**
     * Remove villager when the map load a chunk for
     * the first time
     *
     * @param chunkEvent
     */
    private void removeVillagersNewChunks(ChunkLoadEvent chunkEvent){
        // When a chunk is loaded
        Entity[] entities = chunkEvent.getChunk().getEntities();
        for (Entity entity:entities) {
            //if the chunk contains Villagers
            if(Villager.class.isAssignableFrom(entity.getClass())){
                if(chunkEvent.isNewChunk())entity.remove();
            }
        }
    }

    private void disableBreed(EntityBreedEvent event){
        if(Villager.class.isAssignableFrom(event.getEntity().getClass())){
            event.setCancelled(true);
        }
    }
}
