import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
DISTILLERY = recipemap('distillery')

// Tier 1
DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('cerium_iii_nitrate_solution') * 500)
    .outputs(metaitem('dustCeriumIiiNitrate') * 10)
    .fluidOutputs(fluid('water') * 500)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustCeriumIiiNitrate') * 10)
    .outputs(metaitem('dustCeriumIvOxide') * 3)
    .fluidOutputs(fluid('nitrogen_dioxide') * 4000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(80)
    .EUt(480)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCeriumIvOxide') * 3)
    .fluidInputs(fluid('hydrofluoric_acid') * 4000)
    .outputs(metaitem('dustCeriumIvFluoride') * 5)
    .fluidOutputs(fluid('dense_steam') * 6000)
    .duration(80)
    .EUt(60)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.graphite'))
    .inputs(ore('dustCeriumIvFluoride') * 5)
    .inputs(ore('dustHighPurityCalcium') * 2)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustCerium'))
    .outputs(metaitem('dustFluorite') * 6)
    .duration(200)
    .EUt(960)
    .buildAndRegister()

// Cerium reductive stripping (Tier 2)
// 2Ce(NO3)4 + H2O2 -> 2Ce(NO3)3 + O2 + 2HNO3
BR.recipeBuilder()
    .fluidInputs(fluid('cerium_extract') * 2000)
    .fluidInputs(fluid('hydrogen_peroxide_solution') * 500)
    .fluidOutputs(fluid('cerium_iii_nitrate_solution') * 500)
    .fluidOutputs(fluid('tributyl_phosphate') * 2000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()