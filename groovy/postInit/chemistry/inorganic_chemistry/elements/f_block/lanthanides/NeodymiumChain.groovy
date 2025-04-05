import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR.recipeBuilder()
        .inputs(ore('dustNeodymiumOxide') * 5)
        .fluidInputs(fluid('hydrofluoric_acid') * 6)
        .outputs(metaitem('dustNeodymiumFluoride') * 8)
        .fluidOutputs(fluid('dense_steam') * 9000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustNeodymiumFluoride') * 8)
        .inputs(ore('dustCalcium') * 3)
        .outputs(metaitem('dustNeodymium') * 2)
        .outputs(metaitem('dustFluorite') * 9)
        .duration(20)
        .EUt(1)
        .buildAndRegister()