import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')

BR.recipeBuilder()
        .inputs(ore('dustErbiumDodecylSulfate'))
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .outputs(metaitem('dustErbiumHydroxide') * 7)
        .fluidOutputs(fluid('sodium_dodecyl_sulfate_solution') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustErbiumHydroxide') * 14)
        .outputs(metaitem('dustErbiumOxide') * 5)
        .fluidOutputs(fluid('dense_steam') * 3000)
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()