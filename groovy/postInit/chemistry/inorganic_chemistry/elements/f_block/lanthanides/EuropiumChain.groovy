import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')

ROASTER.recipeBuilder()
    .inputs(ore('dustEuropiumIiSulfate') * 6)
    .outputs(metaitem('dustEuropiumOxide') * 2)
    .fluidOutputs(fluid('sulfur_trioxide') * 1000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()