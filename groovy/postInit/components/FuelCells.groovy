import globals.Globals

MIXER = recipemap('mixer')
TEXTILE_SPINNER = recipemap('textile_spinner')
ASSEMBLER = recipemap('assembler')

TEXTILE_SPINNER.recipeBuilder()
    .inputs(metaitem('carbon.fiber') * 16)
    .outputs(metaitem('carbon.mesh'))
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPlatinumOnCarbon'))
    .inputs(ore('dustNafion'))
    .fluidInputs(fluid('isopropyl_alcohol') * 1000)
    .fluidOutputs(fluid('fuel_cell_catalyst_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateNafion'))
    .inputs(metaitem('carbon.mesh') * 2)
    .inputs(ore('ringNafion') * 2)
    .fluidInputs(fluid('fuel_cell_catalyst_solution') * 1000)
    .