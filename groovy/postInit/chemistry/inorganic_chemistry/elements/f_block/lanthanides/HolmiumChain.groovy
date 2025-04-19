import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')

BR.recipeBuilder()
        .inputs(ore('dustHolmiumDodecylSulfate'))
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .outputs(metaitem('dustHolmiumHydroxide') * 7)
        .fluidOutputs(fluid('sodium_dodecyl_sulfate_solution') * 3000)
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustHolmiumHydroxide') * 14)
        .outputs(metaitem('dustHolmiumOxide') * 5)
        .fluidOutputs(fluid('dense_steam') * 3000)
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustHolmiumOxide') * 5)
        .fluidInputs(fluid('hydrofluoric_acid') * 6000)
        .outputs(metaitem('dustHolmiumFluoride') * 8)
        .fluidOutputs(fluid('dense_steam') * 9000)
        .duration(80)
        .EUt(60)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustHolmiumFluoride') * 8)
        .inputs(ore('dustCalcium') * 3)
        .outputs(metaitem('dustHolmium') * 2)
        .outputs(metaitem('dustFluorite') * 9)
        .duration(200)
        .EUt(960)
        .buildAndRegister()