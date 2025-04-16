import gregtech.loaders.recipe.RecyclingRecipes
import gregtech.api.unification.ore.OrePrefix

ARC_FURNACE = recipemap('arc_furnace')
MACERATOR = recipemap('macerator')
EXTRACTOR = recipemap('extractor')

def recyclingRecipeMaps = [
        ARC_FURNACE,
        MACERATOR,
        EXTRACTOR,
]

recyclingRecipeMaps.each { map ->
    map.getGroovyScriptRecipeMap()
            .streamRecipes()
            .removeIf {
                it.getRecipeCategory().getName().endsWith('_recycling')
            }
}

// Reloads every recycling recipes
OrePrefix.runMaterialHandlers()
RecyclingRecipes.init()