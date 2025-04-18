//import gregtech.api.recipes.chance.output.ChancedOutputLogic;

AUTOCLAVE = recipemap("autoclave")
MIXER = recipemap("mixer")
ROASTER = recipemap("roaster")
CHEMICAL_BATH = recipemap("chemical_bath")
BR = recipemap("batch_reactor")
CSTR = recipemap('continuous_stirred_tank_reactor')
BCR = recipemap("bubble_column_reactor")
HT_DISTILLATION_TOWER = recipemap('high_temperature_distillation')
REACTION_FURNACE = recipemap('reaction_furnace')
FLUID_SOLIDIFIER = recipemap('fluid_solidifier')
VACUUM_DT = recipemap('vacuum_distillation')

// From copper electrorefining
// Composition of slime: 15% Se, 5% Te, 40% Ag/Au, 40% Cu

AUTOCLAVE.recipeBuilder()
    .inputs(metaitem('anode_slime.copper'))
    .fluidInputs(fluid('sulfuric_acid') * 400)
    .fluidInputs(fluid('oxygen') * 400)
    .outputs(metaitem('anode_slime.decopperized'))
    .fluidOutputs(fluid('copper_sulfate_solution') * 400)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(metaitem('anode_slime.decopperized') * 5)
    .inputs(ore('dustSodaAsh') * 6)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('copper_anode_slime_paste') * 1000)
    .duration(600)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('copper_anode_slime_paste') * 1000)
    .outputs(metaitem('dustSeleniumTelluriumConcentrate')) // 0.75 Na2SeO4, 0.25 Na2TeO4, 2 Ag/Au
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(600)
    .EUt(120)
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('dustSeleniumTelluriumConcentrate'))
    .fluidInputs(fluid('distilled_water') * 750)
    .outputs(metaitem('dustTelluriumResidue')) // 0.25 Na2TeO4, 2 Ag/Au
    .fluidOutputs(fluid('sodium_selenate_solution') * 750) //Na2SeO4.H2O
    .duration(600)
    .EUt(30)
    .buildAndRegister()

CSTR.recipeBuilder() //Na2SeO4.H2O + 2HCl.H2O -> Na2SeO3.4H2O + 2 Cl
    .fluidInputs(fluid('sodium_selenate_solution') * 50)
    .fluidInputs(fluid('hydrochloric_acid') * 100)
    .fluidOutputs(fluid('sodium_selenite_solution') * 200)
    .fluidOutputs(fluid('chlorine') * 100)
    .duration(30)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sodium_selenite_solution') * 4000)
    .fluidInputs(fluid('sulfur_dioxide') * 2000)
    .outputs(metaitem('dustSelenium'))
    .fluidOutputs(fluid('acidic_wastewater') * 3000) //H2SO4.3H2O?
    .duration(6)
    .EUt(30)
    .buildAndRegister()

// From PGM Mattes

VACUUM_DT.recipeBuilder()
    .inputs(ore('dustMixedChalcogenDioxide') * 2)
    .outputs(metaitem('dustTelluriumDioxide') * 3)
    .fluidOutputs(fluid('selenium_dioxide') * 432)
    .duration(600)
    .EUt(30)
    .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('selenium_dioxide') * 432)
    .outputs(metaitem('dustSeleniumDioxide') * 3)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSeleniumDioxide') * 3)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('sodium_selenite_solution') * 4000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

// Further refining

HT_DISTILLATION_TOWER.recipeBuilder()
    .inputs(ore('dustSelenium'))
    .fluidOutputs(fluid('selenium') * 60)
    .fluidOutputs(fluid('high_purity_selenium') * 72)
    //.chancedOutput(metaitem('dustSelenium'), 4000, 0)
    //.chancedOutput(metaitem('dustHighPuritySelenium'), 5000, 0)
    //.chancedOutputLogic(ChancedOutputLogic.XOR)
    .duration(500)
    .EUt(240)
    .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('selenium') * 144)
    .outputs(metaitem('dustSelenium'))
    .duration(20)
    .EUt(30)
    .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('high_purity_selenium') * 144)
    .outputs(metaitem('dustHighPuritySelenium'))
    .duration(20)
    .EUt(30)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustSelenium'))
    .fluidInputs(fluid('hydrogen') * 2000)
    .fluidOutputs(fluid('hydrogen_selenide') * 1000)
    .duration(100)
    .EUt(240)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('hydrogen_selenide') * 1000)
    .chancedOutput(metaitem('dustHighPuritySelenium'), 9900, 0)
    .fluidOutputs(fluid('hydrogen') * 2000)
    .duration(100)
    .EUt(240)
    .buildAndRegister()