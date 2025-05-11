import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
CENTRIFUGE = recipemap('centrifuge')
ION_EXCHANGE = recipemap('ion_exchange_column')

// Tier 1
BR.recipeBuilder()
    .inputs(metaitem('beads.loaded_gadolinium_anion_exchange'))
    .fluidInputs(fluid('pentetic_acid_solution') * 100)
    .outputs(metaitem('beads.strong_basic_anion_exchange'))
    .fluidOutputs(fluid('gadolinium_concentrate') * 100)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 9)
    .fluidInputs(fluid('gadolinium_concentrate') * 1000)
    .outputs(metaitem('dustGadoliniumHydroxide') * 7)
    .fluidOutputs(fluid('wastewater') * 1000)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustGadoliniumHydroxide') * 14)
    .outputs(metaitem('dustGadoliniumOxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustGadoliniumOxide') * 5)
    .fluidInputs(fluid('hydrofluoric_acid') * 6000)
    .outputs(metaitem('dustGadoliniumFluoride') * 8)
    .fluidOutputs(fluid('dense_steam') * 9000)
    .duration(80)
    .EUt(60)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustGadoliniumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustGadolinium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()

// Tier 2
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 725)
    .fluidInputs(fluid('gadolinium_extract') * 5000) // 0.2 mol Gd
    .fluidOutputs(fluid('gadolinium_chloride_solution') * 725)
    .fluidOutputs(fluid('spent_P507_extraction_mixture') * 5000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 9)
    .fluidInputs(fluid('gadolinium_chloride_solution') * 3625)
    .outputs(metaitem('dustGadoliniumHydroxide') * 7)
    .fluidOutputs(fluid('wastewater') * 3625)
    .duration(80)
    .EUt(120)
    .buildAndRegister()