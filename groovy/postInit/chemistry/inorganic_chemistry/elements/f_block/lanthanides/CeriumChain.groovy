import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')

ROASTER.recipeBuilder()
    .inputs(ore('dustCeriumIvNitrate') * 17)
    .outputs(metaitem('dustCeriumIvOxide') * 3)
    .fluidOutputs(fluid('nitrogen_dioxide') * 4000)
    .fluidOutputs(fluid('oxygen') * 2000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()