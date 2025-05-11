import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

REACTION_FURNACE = recipemap('reaction_furnace')
BR = recipemap('batch_reactor')

BR.recipeBuilder()
    .fluidInputs(fluid('holmium_chloride_solution') * 3000)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustHolmiumFluoride') * 4)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustHolmiumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('helium') * 50)
    .outputs(metaitem('dustHolmium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()