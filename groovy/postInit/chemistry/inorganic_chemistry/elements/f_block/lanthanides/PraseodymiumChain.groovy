import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
ROASTER = recipemap('roaster')

ROASTER.recipeBuilder()
        .inputs(ore('dustPraseodymiumHydroxide') * 18)
        .outputs(metaitem('dustPraseodymiumOxide') * 3)
        .fluidOutputs(fluid('dense_steam') * 4000)
        .duration(160)
        .EUt(480)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustPraseodymiumOxide') * 3)
        .fluidInputs(fluid('hydrofluoric_acid') * 4000)
        .outputs(metaitem('dustPraseodymiumFluoride') * 5)
        .fluidOutputs(fluid('dense_steam') * 2000)
        .duration(80)
        .EUt(60)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustPraseodymiumFluoride') * 5)
        .inputs(ore('dustCalcium') * 2)
        .outputs(metaitem('dustPraseodymium') * 1)
        .outputs(metaitem('dustFluorite') * 6)
        .duration(200)
        .EUt(960)
        .buildAndRegister()