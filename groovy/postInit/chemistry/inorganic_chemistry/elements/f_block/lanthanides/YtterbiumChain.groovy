import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
DISTILLERY = recipemap('distillery')

BR.recipeBuilder()
        .fluidInputs(fluid('ytterbium_amalgam') * 1000)
        .fluidInputs(fluid('hydrochloric_acid') * 5000)
        .outputs(metaitem('dustMercuryIiChloride') * 3)
        .fluidOutputs(fluid('hydrogen') * 5000)
        .fluidOutputs(fluid('ytterbium_chloride_solution') * 5000)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('ytteribum_chloride_solution') * 5000)
        .outputs(metaitem('dustYtterbiumChloride') * 4)
        .fluidOutputs(fluid('water') * 5000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustYtterbiumChloride') * 4)
        .inputs(ore('dustLanthanum'))
        .outputs(metaitem('dustYtterbium'))
        .outputs(metaitem('dustLanthanumChloride') * 4)
        .duration(200)
        .EUt(480)
        .buildAndRegister()