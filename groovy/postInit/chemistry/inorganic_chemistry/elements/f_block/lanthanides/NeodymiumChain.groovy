import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

BR.recipeBuilder()
    .fluidInputs(fluid('neodymium_chloride_solution') * 3000)
    .inputs(ore('dustSodiumHydroxide') * 9)
    .outputs(metaitem('dustNeodymiumHydroxide') * 7)
    .fluidOutputs(fluid('salt_water') * 3000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustNeodymiumHydroxide') * 14)
    .outputs(metaitem('dustNeodymiumOxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .duration(160)
    .EUt(480)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustNeodymiumOxide') * 5)
    .fluidInputs(fluid('hydrofluoric_acid') * 6000)
    .outputs(metaitem('dustNeodymiumFluoride') * 8)
    .fluidOutputs(fluid('dense_steam') * 9000)
    .duration(80)
    .EUt(60)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.graphite'))
    .inputs(ore('dustNeodymiumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustNeodymium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()