BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')

// TNT

BR.recipeBuilder()
    .fluidInputs(fluid('toluene') * 1000)
    .fluidInputs(fluid('nitration_mixture') * 6000)
    .fluidOutputs(fluid('tnt_slurry') * 3000)
    .duration(200)
    .EUt(24)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('tnt_slurry') * 1000)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 1000)
    .outputs(metaitem('dustTnt') * 7)
    .duration(300)
    .EUt(30)
    .buildAndRegister()

// PICRIC ACID

BR.recipeBuilder()
    .fluidInputs(fluid('phenol') * 1000)
    .fluidInputs(fluid('nitration_mixture') * 6000)
    .fluidOutputs(fluid('tnp_slurry') * 3000)
    .duration(200)
    .EUt(24)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('tnp_slurry') * 1000)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 1000)
    .outputs(metaitem('dustPicricAcid') * 7)
    .duration(300)
    .EUt(30)
    .buildAndRegister()