import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
REACTION_FURNACE = recipemap('reaction_furnace')

BR.recipeBuilder()
        .inputs(metaitem('beads.loaded_lutetium_cation_exchange'))
        .fluidInputs(fluid('copper_chloride_solution') * 15)
        .outputs(metaitem('beads.rare_earth_cation_exchange'))
        .fluidOutputs(fluid('lutetium_chloride_solution') * 10)
        .duration(20)
        .EUt(16)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('lutetium_chloride_solution') * 1000)
        .outputs(metaitem('dustLutetiumChloride') * 4)
        .fluidOutputs(fluid('water') * 1000)
        .duration(80)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustLutetiumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('helium') * 50)
    .outputs(metaitem('dustLutetium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
        .duration(160)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()