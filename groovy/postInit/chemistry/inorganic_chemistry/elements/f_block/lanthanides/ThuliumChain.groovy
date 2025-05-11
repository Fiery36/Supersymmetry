import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')

ROASTER.recipeBuilder()
    .inputs(ore('dustThuliumHydroxide') * 7)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustThuliumFluoride') * 4)
    .fluidOutputs(fluid('dense_steam') * 6000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustThuliumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('helium') * 50)
    .outputs(metaitem('dustThulium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()