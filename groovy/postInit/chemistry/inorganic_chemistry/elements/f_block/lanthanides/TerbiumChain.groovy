import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ROASTER = recipemap('roaster')

ROASTER.recipeBuilder()
        .inputs(ore('dustTerbiumCarbonate') * 14)
        .outputs(metaitem('dustTerbiumOxide') * 5)
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustTerbiumOxide') * 5)
        .fluidInputs(fluid('hydrofluoric_acid') * 6)
        .outputs(metaitem('dustTerbiumFluoride') * 8)
        .fluidOutputs(fluid('dense_steam') * 9000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustTerbiumFluoride') * 8)
        .inputs(ore('dustCalcium') * 3)
        .outputs(metaitem('dustTerbium') * 2)
        .outputs(metaitem('dustFluorite') * 9)
        .duration(20)
        .EUt(1)
        .buildAndRegister()