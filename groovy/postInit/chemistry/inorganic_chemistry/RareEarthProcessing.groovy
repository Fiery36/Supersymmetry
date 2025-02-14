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
    .inputs(ore('dustBastReHydroxides'))
    .fluidInputs(fluid('nitric_acid'))
    .fluidOutputs(fluid('bast_re_nitrates_solution'))
        .duration(20)
        .EUt(1)
        .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPotassiumPermanganate'))
    .fluidInputs(fluid('nitric_acid'))
    .fluidInputs(fluid('bast_re_nitrates_solution'))
    .fluidOutputs(fluid('bast_ox_re_nitrates_solution'))
        .duration(20)
        .EUt(1)
        .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('bast_ox_re_nitrates_solution'))
    .fluidInputs(fluid('tributyl_phosphate'))
    .fluidOutputs(fluid('bast_cerium_extract'))
    .fluidOutputs(fluid('bast_cefree_re_nitrates_solution'))
        .duration(20)
        .EUt(1)
        .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('bast_cefree_re_nitrates_solution'))
    .fluidInputs(fluid('di_two_ethylhexyl_phosphoric_acid_solution')) //change to RE extraction mixture
    .fluidOutputs(fluid('bast_lree_concentrate'))
    .fluidOutputs(fluid('bast_dehpa_extract'))
        .duration(20)
        .EUt(1)
        .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid'))
    .fluidInputs(fluid('bast_dehpa_extract'))
    .fluidOutputs(fluid('di_two_ethylhexyl_phosphoric_acid_solution'))
    .fluidOutputs(fluid('bast_re_chlorides_solution'))
        .duration(20)
        .EUt(1)
        .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('bast_re_chlorides_solution'))
    .fluidInputs(fluid('water')) //replace with EHEHPA
    .fluidOutputs(fluid('bast_mree_concentrate'))
    .fluidOutputs(fluid('bast_ehehpa_extract'))
        .duration(20)
        .EUt(1)
        .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid'))
    .fluidInputs(fluid('bast_ehehpa_extract'))
    .fluidOutputs(fluid('water')) //replace with EHEHPA
    .fluidOutputs(fluid('bast_hree_concentrate'))
        .duration(20)
        .EUt(1)
        .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('bast_cerium_extract'))
    .fluidInputs(fluid('diluted_hydrochloric_acid'))
    .outputs(metaitem('dustCeriumIvNitrate'))
    .fluidOutputs(fluid('tributyl_phosphate'))
        .duration(20)
        .EUt(1)
        .buildAndRegister()