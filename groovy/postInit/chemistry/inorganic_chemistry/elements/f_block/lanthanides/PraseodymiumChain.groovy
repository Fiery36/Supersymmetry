import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
CENTRIFUGE = recipemap('centrifuge')
DISTILLERY = recipemap('distillery')
ROASTER = recipemap('roaster')

// Tier 1
ROASTER.recipeBuilder()
    .inputs(ore('dustPraseodymiumIvOxide') * 6)
    .fluidInputs(fluid('hydrofluoric_acid') * 8000)
    .outputs(metaitem('dustPraseodymiumIiiFluoride') * 8)
    .fluidOutputs(fluid('dense_steam') * 12000)
    .fluidOutputs(fluid('fluorine') * 2000)
    .duration(80)
    .EUt(60)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.graphite'))
    .inputs(ore('dustPraseodymiumFluoride') * 5)
    .inputs(ore('dustCalcium') * 2)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustPraseodymium') * 1)
    .outputs(metaitem('dustFluorite') * 6)
    .duration(200)
    .EUt(960)
    .buildAndRegister()

// Tier 2
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('praseodymium_extract') * 10000)
    .fluidOutputs(fluid('praseodymium_iii_nitrate_solution') * 1000)
    .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 10000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('praseodymium_iii_nitrate_solution') * 1000)
    .outputs(metaitem('dustPraseodymiumIiiNitrate') * 13)
    .fluidOutputs(fluid('water') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustPraseodymiumIiiNitrate') * 26)
    .outputs(metaitem('dustPraseodymiumIiiOxide') * 5)
    .fluidOutputs(fluid('nitrogen_dioxide') * 6000)
    .fluidOutputs(fluid('oxygen') * 3000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustPraseodymiumIiiOxide') * 5)
    .fluidInputs(fluid('hydrofluoric_acid') * 6000)
    .outputs(metaitem('dustPraseodymiumIiiFluoride') * 8)
    .fluidOutputs(fluid('dense_steam') * 9000)
    .duration(80)
    .EUt(60)
    .buildAndRegister()