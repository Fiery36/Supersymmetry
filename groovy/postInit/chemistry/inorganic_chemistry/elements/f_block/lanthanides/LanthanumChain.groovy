import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
CENTRIFUGE = recipemap('centrifuge')
DISTILLERY = recipemap('distillery')

// Tier 1
ROASTER.recipeBuilder()
    .inputs(ore('dustLanthanumCarbonate') * 14)
    .outputs(metaitem('dustLanthanumOxide') * 5)
    .fluidOutputs(fluid('carbon_dioxide') * 3000)
    .duration(100)
    .EUt(480)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustLanthanumOxide') * 5)
    .fluidInputs(fluid('hydrofluoric_acid') * 6000)
    .outputs(metaitem('dustLanthanumFluoride') * 8)
    .fluidOutputs(fluid('dense_steam') * 9000)
    .duration(80)
    .EUt(60)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustLanthanumChloride') * 4)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustLanthanumFluoride') * 4)
    .fluidOutputs(fluid('hydrochloric_acid') * 3000)
    .duration(80)
    .EUt(60)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.graphite'))
    .inputs(ore('dustLanthanumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustLanthanum') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()

// Tier 2
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('lanthanum_extract') * 10000)
    .fluidOutputs(fluid('lanthanum_nitrate_solution') * 10000)
    .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('lanthanum_nitrate_solution') * 1000)
    .outputs(metaitem('dustLanthanumNitrate') * 13)
    .fluidOutputs(fluid('water') * 1000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustLanthanumNitrate') * 26)
    .outputs(metaitem('dustLanthanumOxide') * 5)
    .fluidOutputs(fluid('nitrogen_dioxide') * 6000)
    .fluidOutputs(fluid('oxygen') * 3000)
    .duration(100)
    .EUt(120)
    .buildAndRegister()