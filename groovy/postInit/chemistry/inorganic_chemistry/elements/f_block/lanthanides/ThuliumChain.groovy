import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

ION_EXCHANGE = recipemap('ion_exchange_column')
DISTILLERY = recipemap('distillery')
REACTION_FURNACE = recipemap('reaction_furnace')

ION_EXCHANGE.recipeBuilder()
        .inputs(metaitem('beads.loaded_thulium_cation_exchange'))
        .fluidInputs(fluid('copper_chloride_solution') * 3000)
        .outputs(metaitem('beads.rare_earth_cation_exchange'))
        .fluidOutputs(fluid('thulium_chloride_solution') * 2000)
        .duration(20)
        .EUt(1)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('thulium_chloride_solution') * 1000)
        .outputs(metaitem('dustThuliumChloride') * 4)
        .fluidOutputs(fluid('water') * 1000)
        .duration(80)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustThuliumChloride') * 4)
        .inputs(ore('dustLanthanum'))
        .outputs(metaitem('dustThulium'))
        .outputs(metaitem('dustLanthanumChloride') * 4)
        .duration(160)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()