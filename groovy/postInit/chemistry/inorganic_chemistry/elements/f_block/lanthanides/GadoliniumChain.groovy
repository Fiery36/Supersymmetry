import globals.Globals

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
CENTRIFUGE = recipemap('centrifuge')
DISTILLERY = recipemap('distillery')

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 3625)
    .fluidInputs(fluid('gadolinium_extract') * 25000)
    .fluidOutputs(fluid('gadolinium_chloride_solution') * 3625)
    .fluidOutputs(fluid('spent_p_five_zero_seven_extraction_mixture') * 25000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('gadolinium_chloride_solution') * 3625)
    .outputs(metaitem('dustGadoliniumChloride') * 4)
    .fluidOutputs(fluid('water') * 3625)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustGadoliniumChloride') * 4)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustGadoliniumFluoride') * 4)
    .fluidOutputs(fluid('hydrochloric_acid') * 3000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustGadoliniumFluoride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustGadolinium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()