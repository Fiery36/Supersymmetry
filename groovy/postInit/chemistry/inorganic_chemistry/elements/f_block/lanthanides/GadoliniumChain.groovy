import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')

ROASTER.recipeBuilder()
    .inputs(ore('dustGadoliniumHydroxide') * 14)
    .outputs(metaitem('dustGadoliniumOxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 3000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()