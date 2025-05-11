import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')

ROASTER.recipeBuilder()
    .inputs(ore('dustDysprosiumHydroxide') * 7)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustDysprosiumFluoride') * 4)
    .fluidOutputs(fluid('dense_steam') * 6000)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustDysprosiumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('helium') * 50)
    .outputs(metaitem('dustFluorite') * 9)
    .outputs(metaitem('dustDysprosium') * 2)
    .duration(160)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()