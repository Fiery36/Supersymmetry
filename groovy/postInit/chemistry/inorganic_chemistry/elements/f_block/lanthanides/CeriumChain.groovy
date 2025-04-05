import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

ROASTER.recipeBuilder()
        .inputs(ore('dustCeriumIvNitrate') * 17)
        .outputs(metaitem('dustCeriumIvOxide') * 3)
        .fluidOutputs(fluid('nitrogen_dioxide') * 4000)
        .fluidOutputs(fluid('oxygen') * 2000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustCeriumIvOxide') * 3)
        .fluidInputs(fluid('hydrofluoric_acid') * 4)
        .outputs(metaitem('dustCeriumFluoride') * 5)
        .fluidOutputs(fluid('dense_steam') * 6000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustCeriumFluoride') * 5)
        .inputs(ore('dustCalcium') * 2)
        .outputs(metaitem('dustCerium'))
        .outputs(metaitem('dustFluorite') * 6)
        .duration(20)
        .EUt(1)
        .buildAndRegister()