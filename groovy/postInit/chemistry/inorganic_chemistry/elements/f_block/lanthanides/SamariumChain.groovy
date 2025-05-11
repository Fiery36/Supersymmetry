import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')
DISTILLERY = recipemap('distillery')

// Tier 1
BR.recipeBuilder()
    .fluidInputs(fluid('samarium_amalgam') * 1000)
    .fluidInputs(fluid('hydrochloric_acid') * 5000)
    .outputs(metaitem('dustMercuryIiChloride') * 3)
    .fluidOutputs(fluid('hydrogen') * 5000)
    .fluidOutputs(fluid('samarium_chloride_solution') * 5000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('samarium_chloride_solution') * 5000)
    .outputs(metaitem('dustSamariumChloride') * 4)
    .fluidOutputs(fluid('water') * 5000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustSamariumChloride') * 4)
    .inputs(ore('dustLanthanum'))
    .outputs(metaitem('dustSamarium'))
    .outputs(metaitem('dustLanthanumChloride') * 4)
    .duration(200)
    .EUt(480)
    .buildAndRegister()

// Tier 2
ROASTER.recipeBuilder()
    .inputs(ore('dustSamariumHydroxide') * 14)
    .outputs(metaitem('dustSamariumOxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSamariumOxide') * 5)
    .fluidInputs(fluid('hydrochloric_acid') * 6000)
    .fluidInputs(fluid('distilled_water') * 4000)
    .fluidOutputs(fluid('samarium_chloride_solution') * 10000)
    .duration(80)
    .EUt(60)
    .buildAndRegister()