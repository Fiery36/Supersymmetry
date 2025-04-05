import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

BR.recipeBuilder()
        .inputs(ore('dustNeodymiumOxide') * 5)
        .fluidInputs(fluid('hydrofluoric_acid') * 6000)
        .outputs(metaitem('dustNeodymiumFluoride') * 8)
        .fluidOutputs(fluid('dense_steam') * 9000)
        .duration(80)
        .EUt(60)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustNeodymiumFluoride') * 8)
        .inputs(ore('dustCalcium') * 3)
        .outputs(metaitem('dustNeodymium') * 2)
        .outputs(metaitem('dustFluorite') * 9)
        .duration(200)
        .EUt(960)
        .buildAndRegister()