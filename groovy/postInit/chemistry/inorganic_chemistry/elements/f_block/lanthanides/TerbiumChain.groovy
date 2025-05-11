import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

ROASTER.recipeBuilder()
    .inputs(ore('dustTerbiumHydroxide') * 7)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustTerbiumFluoride') * 4)
    .fluidOutputs(fluid('dense_steam') * 6000)
    .duration(80)
    .EUt(480)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustTerbiumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('helium') * 50)
    .outputs(metaitem('dustTerbium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()