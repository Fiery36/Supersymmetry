import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

REACTION_FURNACE = recipemap('reaction_furnace')

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustDysprosiumFluoride') * 8)
        .inputs(ore('dustCalcium') * 3)
        .outputs(metaitem('dustFluorite') * 9)
        .outputs(metaitem('dustDysprosium') * 2)
        .duration(160)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()