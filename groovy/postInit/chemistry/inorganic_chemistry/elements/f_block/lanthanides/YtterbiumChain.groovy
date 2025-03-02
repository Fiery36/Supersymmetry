import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')

BR.recipeBuilder()
        .fluidInputs(fluid('ytterbium_amalgam') * 1000)
        .fluidInputs(fluid('hydrochloric_acid') * 8000)
        .outputs(metaitem('dustYtterbiumChloride') * 4)
        .outputs(metaitem('dustMercuryIiChloride') * 4)
        .fluidOutputs(fluid('hydrogen') * 8000)
        .fluidOutputs(fluid('diluted_saltwater') * 6000)
        .fluidOutputs(fluid('water') * 2000)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustYtterbiumChloride') * 4)
        .fluidInputs(fluid('potassium_fluoride_solution') * 3000)
        .outputs(metaitem('dustYtterbiumFluoride') * 4)
        .fluidOutputs(fluid('potassium_chloride_solution') * 3000)
        .duration(80)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
