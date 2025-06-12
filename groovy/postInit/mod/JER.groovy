// This registers loot tables for entities with Just Enough Resources.

import net.minecraft.entity.EntityList
import jeresources.compatibility.minecraft.MinecraftCompat
import jeresources.util.MobTableBuilder
import java.lang.reflect.Constructor
import net.minecraftforge.fml.common.registry.ForgeRegistries
import jeresources.compatibility.JERAPI
import jeresources.registry.MobRegistry
import techguns.entities.npcs.GenericNPC

MobRegistry.getInstance().clear()

def registry = JERAPI.getInstance().getMobRegistry()
def world = MinecraftCompat.getWorld()

for (entityEntry in ForgeRegistries.ENTITIES.getValues()) {
    log.infoMC(entityEntry.getName());

    def entityClass = entityEntry.getEntityClass();
    def entityInstance = EntityList.newEntity(entityClass, world)
    if (!(entityInstance instanceof GenericNPC)) {
        continue
    }

    def lootResource = entityInstance.getLootTable()
    
    if (lootResource == null) {
        continue
    }
    registry.register(entityInstance, lootResource)
}