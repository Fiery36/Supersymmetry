import globals.Globals

POLYMERIZATION_TANK = recipemap('polymerization_tank')
BCR = recipemap('bubble_column_reactor')
CENTRIFUGE = recipemap('centrifuge')
MIXER = recipemap('mixer')
BR = recipemap('batch_reactor')
SIEVE_DT = recipemap('sieve_distillation')

MIXER.recipeBuilder()
    .fluidInputs(fluid('two_six_xylenol') * 1000)
    .fluidInputs(fluid('toluene') * 1000)
    .fluidOutputs(fluid('xylenol_solution') * 2000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .inputs(ore('dustTinyCopperIiChloride'))
    .inputs(ore('dustTinyPotassiumHydroxide'))
    .fluidInputs(fluid('xylenol_solution') * 2000)
    .fluidOutputs(fluid('polymerised_xylenol_solution') * 2000)
    .duration(180)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

BCR.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 50)
    .fluidInputs(fluid('polymerised_xylenol_solution') * 100)
    .fluidOutputs(fluid('diluted_ppo_solution') * 100)
    .duration(2)
    .EUt(16)
    .buildAndRegister();

MIXER.recipeBuilder()
    .fluidInputs(fluid('ethylenediamine') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('ethylenediamine_solution') * 2000)
    .duration(80)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('ethylenediamine_solution') * 20)
    .fluidInputs(fluid('diluted_ppo_solution') * 2000)
    .fluidOutputs(fluid('ppo_solution') * 2000)
    .fluidOutputs(fluid('wastewater') * 20)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

BR.recipeBuilder()
    .fluidInputs(fluid('methanol') * 1000)
    .fluidInputs(fluid('ppo_solution') * 2000)
    .outputs(metaitem('dustPolyphenyleneOxide'))
    .fluidOutputs(fluid('ppo_extraction_waste') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

SIEVE_DT.recipeBuilder()
    .notConsumable(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('ppo_extraction_waste') * 3000)
    .fluidOutputs(fluid('phenol') * 1000)
    .fluidOutputs(fluid('methanol') * 1000)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();