import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

ROASTER.recipeBuilder()
        .inputs(ore('dustTerbiumCarbonate') * 14)
        .outputs(metaitem('dustTerbiumOxide') * 5)
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .duration(80)
        .EUt(480)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustTerbiumOxide') * 5)
        .fluidInputs(fluid('hydrofluoric_acid') * 6000)
        .outputs(metaitem('dustTerbiumFluoride') * 8)
        .fluidOutputs(fluid('dense_steam') * 9000)
        .duration(80)
        .EUt(60)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustTerbiumFluoride') * 8)
        .inputs(ore('dustCalcium') * 3)
        .outputs(metaitem('dustTerbium') * 2)
        .outputs(metaitem('dustFluorite') * 9)
        .duration(200)
        .EUt(960)
        .buildAndRegister()