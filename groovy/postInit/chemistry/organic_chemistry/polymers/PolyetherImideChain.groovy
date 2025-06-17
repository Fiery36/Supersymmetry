import globals.Globals

CSTR = recipemap('continuous_stirred_tank_reactor')
CRYSTALLIZER = recipemap('crystallizer')
BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
LCR = recipemap('large_chemical_reactor')
MIXER = recipemap('mixer')
POLYMERIZATION_TANK = recipemap('polymerization_tank')
DT = recipemap('distillation_tower')
SOLIDIFIER = recipemap('fluid_solidifier')
EXTRACTOR = recipemap('extractor')

CSTR.recipeBuilder()
    .fluidInputs(fluid('ammonia') * 100)
    .fluidInputs(fluid('phthalic_anhydride') * 50)
    .fluidOutputs(fluid('ammoniacal_phthalimide') * 100)
    .duration(1)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('ammoniacal_phthalimide') * 2000)
    .outputs(metaitem('dustPhthalimide'))
    .fluidOutputs(fluid('ammonia_solution') * 1000)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustPhthalimide'))
    .fluidInputs(fluid('methanol') * 1000)
    .outputs(metaitem('dustNMethylPhthalimide'))
    .fluidOutputs(fluid('water') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustNMethylPhthalimide'))
    .fluidInputs(fluid('nitric_acid') * 1000)
    .fluidOutputs(fluid('four_nitro_n_methyl_phthalimide_solution') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('four_nitro_n_methyl_phthalimide_solution') * 2000)
    .outputs(metaitem('dustFourNitroNMethylPhthalimide'))
    .fluidOutputs(fluid('water') * 2000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

LCR.recipeBuilder()
    .inputs(ore('dustFourNitroNMethylPhthalimide') * 2)
    .inputs(ore('dustSodiumBisphenolate'))
    .fluidInputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .outputs(metaitem('dustSodiumNitrite') * 8)
    .fluidOutputs(fluid('bisphenol_a_diimide_solution') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

LCR.recipeBuilder()
    .inputs(ore('dustPhthalicAnhydride') * 2)
    .fluidInputs(fluid('bisphenol_a_diimide_solution') * 1000)
    .fluidOutputs(fluid('impure_bisphenol_a_dianhydride_solution') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('impure_bisphenol_a_dianhydride_solution') * 1000)
    .outputs(metaitem('dustImpureBisphenolADianhydride') * 3)
    .fluidOutputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('impure_bisphenol_a_dianhydride') * 3000)
    .outputs(metaitem('dustBisphenolADianhydride'))
    .fluidOutputs(fluid('phthalimide') * 2000)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

MIXER.recipeBuilder()
    .inputs(ore('dustMetaPhenylenediamine'))
    .inputs(ore('dustBisphenolADianhydride'))
    .fluidInputs(fluid('dichlorobenzene') * 1000)
    .fluidOutputs(fluid('pei_preparation_mixture') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .notConsumable(fluid('nitrogen') * 8000)
    .fluidInputs(fluid('pei_preparation_mixture') * 1000)
    .fluidInputs(fluid('gtfo_aniline') * 200)
    .fluidOutputs(fluid('pei_polymerisation_solution') * 1200)
    .duration(300)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

DT.recipeBuilder()
    .fluidInputs(fluid('pei_polymerisation_solution') * 1200)
    .outputs(metaitem('dustPolyetherImide'))
    .fluidOutputs(fluid('dichlorobenzene') * 1000)
    .fluidOutputs(fluid('gtfo_aniline') * 200)
    .duration(100)
    .EUt(60)
    .buildAndRegister();

// Liquid susy.material.phthalimide * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustPhthalimide')], null)

EXTRACTOR.recipeBuilder()
    .inputs(ore('dustPhthalimide'))
    .fluidOutputs(fluid('phthalimide') * 1000)
    .duration(20)
    .EUt(16)
    .buildAndRegister();

// Liquid susy.material.impure_bisphenol_a_dianhydride * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustImpureBisphenolADianhydride')], null)

EXTRACTOR.recipeBuilder()
    .inputs(ore('dustImpureBisphenolADianhydride'))
    .fluidOutputs(fluid('impure_bisphenol_a_dianhydride') * 1000)
    .duration(20)
    .EUt(16)
    .buildAndRegister();

// Liquid Phthalic Anhydride * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustPhthalicAnhydride')], null)

EXTRACTOR.recipeBuilder()
        .inputs(ore('dustPhthalicAnhydride'))
        .fluidOutputs(fluid('phthalic_anhydride') * 1000)
        .duration(20)
        .EUt(16)
        .buildAndRegister();

SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ball'))
        .fluidInputs(fluid('phthalimide') * 1000)
        .outputs(metaitem('dustPhthalimide'))
        .duration(20)
        .EUt(16)
        .buildAndRegister();

SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ball'))
        .fluidInputs(fluid('impure_bisphenol_a_dianhydride') * 1000)
        .outputs(metaitem('dustImpureBisphenolADianhydride'))
        .duration(20)
        .EUt(16)
        .buildAndRegister();

SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ball'))
        .fluidInputs(fluid('phthalic_anhydride') * 1000)
        .outputs(metaitem('dustPhthalicAnhydride'))
        .duration(20)
        .EUt(16)
        .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_bisphenolate_solution') * 2000)
    .outputs(metaitem('dustSodiumBisphenolate'))
    .fluidOutputs(fluid('water') * 2000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();