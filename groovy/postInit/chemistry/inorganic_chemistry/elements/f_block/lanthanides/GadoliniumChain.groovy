import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')

MIXER.recipeBuilder()
        .inputs(ore('beads.loaded_gadolinium_anion_exchange'))
        .fluidInputs(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustGadoliniumHydroxide'))
        .fluidOutputs(fluid('water') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustGadoliniumHydroxide') * 14)
        .outputs(metaitem('dustGadoliniumOxide') * 5)
        .fluidOutputs(fluid('dense_steam') * 3000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()