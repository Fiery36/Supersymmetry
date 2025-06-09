import globals.Globals

ROASTER = recipemap('roaster');
REACTION_FURNACE = recipemap('reaction_furnace')


ROASTER.recipeBuilder()
    .inputs(ore('dustPyrite') * 2)
    .outputs(metaitem('dustIronIiiSulfate'))
    .outputs(metaitem('dustSulfur'))
    .duration(80)
    .EUt(7)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustIronIiiSulfate'))
    .outputs(metaitem('dustBandedIron'))
    .fluidOutputs(fluid('sulfur_trioxide') * 3000)
    .duration(160)
    .EUt(7)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hydrogen_sulfide') * 3000)
    .fluidInputs(fluid('oxygen') * 3000)
    .fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .outputs(metaitem('dustSulfur'))
    .duration(40)
    .EUt(30)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hydrogen_sulfide') * 3000)
    .fluidInputs(fluid('air') * 15000) //air is composed of ~21% oxygen
    .fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .outputs(metaitem('dustSulfur'))
    .duration(40)
    .EUt(30)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('catalystBedAlumina'))
    .fluidInputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .outputs(metaitem('dustSulfur') * 2)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

// Sodium bisulfite

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfur_dioxide') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('sodium_bisulfite_solution') * 1000)
    .duration(80)
    .EUt(7)
    .buildAndRegister()