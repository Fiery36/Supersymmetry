import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
CENTRIFUGE = recipemap('centrifuge')
DISTILLERY = recipemap('distillery')
ROASTER = recipemap('roaster')

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidInputs(fluid('praeseodymium_extract') * 1000)
        .fluidOutputs(fluid('praseodymium_nitrate_solution') * 1000)
        .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('praseodymium_nitrate_solution') * 1000)
        .outputs(metaitem('dustPraseodymiumNitrate') * 13)
        .fluidOutputs(fluid('water') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustPraseodymiumNitrate') * 26)
        .outputs(metaitem('dustPraseodymiumOxide') * 5)
        .fluidOutputs(fluid('nitrogen_dioxide') * 6000)
        .fluidOutputs(fluid('oxygen') * 3000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustPraseodymiumOxide') * 3)
        .fluidInputs(fluid('hydrofluoric_acid') * 4000)
        .outputs(metaitem('dustPraseodymiumFluoride') * 5)
        .fluidOutputs(fluid('dense_steam') * 6000)
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