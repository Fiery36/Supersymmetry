import globals.Globals

ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')

ROASTER.recipeBuilder()
    .inputs(ore('dustSamariumHydroxide') * 14)
    .outputs(metaitem('dustSamariumOxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('crucible.tantalum'))
    .inputs(ore('dustSamariumOxide') * 5)
    .inputs(ore('dustLanthanum') * 2)
    .outputs(metaitem('dustSamarium') * 2)
    .outputs(metaitem('dustLanthanumOxide') * 5)
    .duration(200)
    .EUt(480)
    .buildAndRegister()

// From Xenotime

ROASTER.recipeBuilder()
    .inputs(ore('dustSamariumOxalate') * 20)
    .outputs(metaitem('dustSamariumOxide') * 5)
    .fluidOutputs(fluid('carbon_dioxide') * 3000)
    .fluidOutputs(fluid('carbon_monoxide') * 3000)
    .duration(100)
    .EUt(120)
    .buildAndRegister()