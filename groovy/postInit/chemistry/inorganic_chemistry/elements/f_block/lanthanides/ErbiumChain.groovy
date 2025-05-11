import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

BR.recipeBuilder()
        .fluidInputs(fluid('erbium_sulfate_solution') * 1500)
        .fluidInputs(fluid('hydrofluoric_acid') * 3000)
        .outputs(metaitem('dustErbiumFluoride') * 4)
        .fluidOutputs(fluid('acidic_wastewater') * 4500)
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .notConsumable(metaitem('crucible.tantalum'))
        .inputs(ore('dustErbiumFluoride') * 8)
        .inputs(ore('dustHighPurityCalcium') * 3)
        .fluidInputs(fluid('helium') * 50)
        .outputs(metaitem('dustErbium') * 2)
        .outputs(metaitem('dustFluorite') * 9)
        .duration(200)
        .EUt(960)
        .buildAndRegister()