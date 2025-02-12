import globals.Globals
import static globals.SinteringGlobals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

GRAVITY_SEPARATOR = recipemap('gravity_separator')
MACERATOR = recipemap('macerator')
MIXER = recipemap('mixer')
FROTH_FLOTATION = recipemap('froth_flotation')
CLARIFIER = recipemap('clarifier')
ROASTER = recipemap('roaster')
ROTARY_KILN = recipemap('rotary_kiln')
BR = recipemap('batch_reactor')
BLENDER = recipemap('blender')


// Bastnasite pre-processing
MACERATOR.recipeBuilder()
    .inputs(ore('bastnasite_alluvial'))
    .outputs(metaitem('dustBastnasite'))
    .duration(20)
    .EUt(1)
    .buildAndRegister()

GRAVITY_SEPARATOR.recipeBuilder()
    .inputs(ore('dustBastnasite'))
    .outputs(metaitem('dustSiftedBastnasite'))
    .duration(20)
    .EUt(1)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSiftedBastnasite'))
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('impure_bastnasite_slurry'))
    .duration(20)
    .EUt(1)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .notConsumable(fluid('methyl_isobutyl_carbinol'))
    .notConsumable(fluid('oleic_acid'))
    .fluidInputs(fluid('impure_bastnasite_slurry'))
    .fluidOutputs(fluid('bastnasite_slurry'))
    .duration(20)
    .EUt(1)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('bastnasite_slurry'))
    .outputs(metaitem('dustFlotatedBastnasite'))
    .fluidOutputs(fluid('wastewater'))
    .duration(20)
    .EUt(1)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustFlotatedBastnasite'))
    .fluidInputs(fluid('sulfuric_acid'))
    .fluidOutputs(fluid('hydrogen_fluoride'))
    .fluidOutputs(fluid('roasted_bastnasite_leach'))
    .duration(20)
    .EUt(1)
    .buildAndRegister()


for (fuel in sintering_fuels) {
    if (!fuel.isPlasma) {
        ROTARY_KILN.recipeBuilder()
                .inputs(ore('dustSodaAsh') * 24)
                .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                .fluidInputs(fluid('oxygen') * 50)
                .fluidInputs(fluid('roasted_bastnasite_leach'))
                .outputs(metaitem('dustConcentratedBastnasite'))
                .fluidOutputs(fluid('carbon_dioxide'))
                .duration(400)
                .EUt(Globals.voltAmps[2])
                .buildAndRegister()
    }
}

BR.recipeBuilder()
    .inputs(ore('dustConcentratedBastnasite'))
    .fluidInputs(fluid('sodium_hydroxide_solution'))
    .outputs(metaitem('dustBastReHydroxides'))
    .fluidOutputs(fluid('sodium_sulfate_solution'))
    .duration(20)
    .EUt(1)
    .buildAndRegister()

// Bastnasite Concentrate processing

MIXER.recipeBuilder()
    .inputs(ore(''))