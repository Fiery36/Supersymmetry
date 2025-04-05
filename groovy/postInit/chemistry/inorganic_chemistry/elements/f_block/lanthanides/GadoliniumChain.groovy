import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

MIXER.recipeBuilder()
        .inputs(metaitem('beads.loaded_gadolinium_anion_exchange'))
        .fluidInputs(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustGadoliniumHydroxide'))
        .fluidOutputs(fluid('water') * 1000)
        .duration(10)
        .EUt(16)
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
        .inputs(ore('dustGadoliniumFluoride') * 8)
        .inputs(ore('dustCalcium') * 3)
        .outputs(metaitem('dustGadolinium') * 2)
        .outputs(metaitem('dustFluorite') * 9)
        .duration(200)
        .EUt(960)
        .buildAndRegister()