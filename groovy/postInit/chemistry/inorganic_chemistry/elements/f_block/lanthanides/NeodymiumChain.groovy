import globals.Globals

BR = recipemap('batch_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')

BR.recipeBuilder()
    .fluidInputs(fluid('neodymium_chloride_solution') * 3000)
    .fluidInputs(fluid('hydrofluoric_acid') * 3000)
    .outputs(metaitem('dustNeodymiumFluoride') * 4)
    .fluidOutputs(fluid('acidic_wastewater') * 6000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustNeodymiumChloride') * 8)
    .inputs(ore('dustHighPurityCalcium') * 3)
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustNeodymium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .duration(200)
    .EUt(960)
    .buildAndRegister()