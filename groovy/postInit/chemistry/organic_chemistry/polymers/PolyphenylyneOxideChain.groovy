import globals.Globals

POLYMERIZATION_TANK = recipemap('polymerization_tank')
BCR = recipemap('bubble_column_reactor')
CENTRIFUGE = recipemap('centrifuge')
TBR = recipemap('trickle_bed_reactor')
BR = recipemap('batch_reactor')
DT = recipemap('distillation_tower')

POLYMERIZATION_TANK.recipeBuilder()
    .inputs(ore('dustTinyCopperIiChloride'))
    .fluidInputs(fluid('two_six_xylenol') * 1000)
    .fluidInputs(fluid('phenol') * 1000)
    .fluidOutputs(fluid('polymerised_xylenol_solution') * 2000)
    .duration(90)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

BCR.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 50)
    .fluidInputs(fluid('polymerised_xylenol_solution') * 100)
    .fluidOutputs(fluid('diluted_ppo_solution') * 100)
    .duration(2)
    .EUt(16)
    .buildAndRegister();

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('ethylenediamine') * 10)
    .fluidInputs(fluid('diluted_ppo_solution') * 2000)
    .fluidOutputs(fluid('ppo_solution') * 1000)
    .fluidOutputs(fluid('wastewater') * 10)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('methanol') * 1000)
    .fluidInputs(fluid('ppo_solution') * 2000)
    .outputs(metaitem('dustPolyphenyleneOxide'))
    .fluidOutputs(fluid('ppo_extraction_waste') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

DT.recipeBuilder()
    .fluidInputs(fluid('ppo_extraction_waste') * 3000)
    .fluidOutputs(fluid('phenol') * 1000)
    .fluidOutputs(fluid('methanol') * 1000)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();