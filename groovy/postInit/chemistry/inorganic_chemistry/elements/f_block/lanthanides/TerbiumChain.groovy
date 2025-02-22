import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')

ROASTER.recipeBuilder()
    .inputs(ore('dustTebiumCarbonate') * 14)
    .outputs(metaitem('dustTerbiumOxide') * 5)
    .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()