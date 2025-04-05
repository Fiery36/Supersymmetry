import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

ROASTER.recipeBuilder()
        .inputs(ore('dustLanthanumCarbonate') * 14)
        .outputs(metaitem('dustLanthanumOxide') * 5)
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustLanthanumOxide') * 5)
        .fluidInputs(fluid('hydrofluoric_acid') * 6)
        .outputs(metaitem('dustLanthanumFluoride') * 8)
        .fluidOutputs(fluid('dense_steam') * 9000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustLanthanumChloride') * 4)
        .fluidInputs(fluid('hydrofluoric_acid') * 3000)
        .outputs(metaitem('dustLanthanumFluoride') * 4)
        .fluidOutputs(fluid('hydrochloric_acid') * 3000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustLanthanumFluoride') * 8)
        .inputs(ore('dustCalcium') * 3)
        .outputs(metaitem('dustLanthanum') * 2)
        .outputs(metaitem('dustFluorite') * 9)
        .duration(20)
        .EUt(1)
        .buildAndRegister()