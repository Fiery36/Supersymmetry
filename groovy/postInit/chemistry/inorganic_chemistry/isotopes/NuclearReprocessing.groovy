CENTRIFUGE = recipemap('centrifuge')
DISTILLERY = recipemap('distillery') // Couldn't think of a better machine for dehydration/evaporation
LCR = recipemap('large_chemical_reactor') // Stand in for mixer-settler
ROTARY_KILN = recipemap('rotary_kiln')
CSTR = recipemap('continuous_stirred_tank_reactor')
BR = recipemap('batch_reactor')
MIXER = recipemap('mixer')

// SolidLiq
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('spent_fuel_suspension') * 1)
    .fluidOutputs(fluid('spent_fuel_solution') * 1)
    .duration(1) 
    .EUt(1)
    .buildAndRegister();

// LiqLiq 
LCR.recipeBuilder()
    .fluidInputs(fluid('spent_fuel_solution') * 1)
    .fluidInputs(fluid('sodium_nitrite') * 1)
    .fluidInputs(fluid('tributyl_phosphate_mixture') * 1)
    .fluidInputs(fluid('nitric_acid') * 1)
    .fluidOutputs(fluid('uranium_plutonium_loaded_solvent') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// LiqLiq 
LCR.recipeBuilder() 
    .fluidInputs(fluid('uranium_plutonium_loaded_solvent') * 1)
    .fluidInputs(fluid('hydroxylammonium_nitrate') * 1)
    .fluidInputs(fluid('tributyl_phosphate_mixture') * 1)
    .fluidInputs(fluid('dilute_nitric_acid') * 1)
    .fluidOutputs(fluid('crude_uranium_loaded_solvent') * 1)
    .fluidOutputs(fluid('crude_plutonium_solution') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// LiqLiq 
LCR.recipeBuilder()
    .fluidInputs(fluid('crude_uranium_loaded_solvent') * 1)
    .fluidInputs(fluid('dilute_nitric_acid') * 1)
    .fluidOutputs(fluid('crude_uranium_solution') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// Uranium Cycle

// LiqLiq 
LCR.recipeBuilder()
    .fluidInputs(fluid('crude_uranium_solution') * 1)
    .fluidInputs(fluid('tributyl_phosphate_mixture') * 1)
    .fluidInputs(fluid('nitric_acid') * 1)
    .fluidOutputs(fluid('uranium_loaded_solvent') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// LiqLiq 
LCR.recipeBuilder()
    .fluidInputs(fluid('uranium_loaded_solvent') * 1)
    .fluidInputs(fluid('dilute_nitric_acid') * 1)
    .fluidOutputs(fluid('uranium_solution') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// Evaporation and Dehydration
DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('uranium_solution') * 1)
    .fluidOutputs(fluid('molten_uranyl_nitrate_hexahydrate') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// Denitration
ROTARY_KILN.recipeBuilder()
    .fluidInputs(fluid('molten_uranyl_nitrate_hexahydrate') * 1)
    .outputs(metaitem('dustUraniumTrioxide'))
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// Plutonium Cycle

// Adjusted
CSTR.recipeBuilder()
    .fluidInputs(fluid('crude_plutonium_solution') * 1)
    .fluidInputs(fluid('nitric_acid') * 1)
    .fluidInputs(fluid('sodium_nitrite') * 1)
    .fluidOutputs(fluid('adjusted_plutonium_solution') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// LiqLiq
LCR.recipeBuilder()
    .fluidInputs(fluid('adjusted_plutonium_solution') * 1)
    .fluidInputs(fluid('tributyl_phosphate_mixture') * 1)
    .fluidInputs(fluid('nitric_acid') * 1)
    .fluidOutputs(fluid('plutonium_loaded_solvent') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// LiqLiq
LCR.recipeBuilder()
    .fluidInputs(fluid('plutonium_loaded_solvent') * 1)
    .fluidInputs(fluid('hydroxylammonium_nitrate') * 1)
    .fluidInputs(fluid('dilute_nitric_acid') * 1)
    .fluidOutputs(fluid('plutonium_solution') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// Precipitation
BR.recipeBuilder()
    .fluidInputs(fluid('plutonium_solution') * 1)
    .fluidInputs(fluid('oxalic_acid_solution') * 1)
    .outputs(metaitem('dustPlutoniumOxalateHexahydrate'))
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// Calcination
ROTARY_KILN.recipeBuilder()
    .inputs(metaitem('dustPlutoniumOxalateHexahydrate'))
    .outputs(metaitem('dustPlutoniumDioxide'))
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// Chemicals

MIXER.recipeBuilder()
    .fluidInputs(fluid('nitric_acid') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('dilute_nitric_acid') * 2000)
    .duration(6)
    .EUt(30)
    .buildAndRegister();

BR.recipeBuilder()
    .fluidInputs(fluid('hydroxylamine') * 1)
    .fluidInputs(fluid('dilute_nitric_acid') * 1)
    .fluidOutputs(fluid('hydroxylammonium_nitrate') * 1)
    .duration(1)
    .EUt(1)
    .buildAndRegister();

// High Level Waste (Vitrification)

// Intermediate Level Waste (Cementation or Bituminization:)

