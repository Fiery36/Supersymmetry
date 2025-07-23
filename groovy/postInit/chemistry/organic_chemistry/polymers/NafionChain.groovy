import globals.Globals

CSTR = recipemap('continuous_stirred_tank_reactor')
LCR = recipemap('large_chemical_reactor')
DT = recipemap('distillation_tower')

CSTR.recipeBuilder()
    .fluidInputs(fluid('hexafluoropropylene') * 50)
    .fluidInputs(fluid('oxygen') * 50)
    .fluidOutputs(fluid('hexafluoropropylene_oxide') * 50)
    .duration(5)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

CSTR.recipeBuilder()
    .notConsumable(ore('springNichrome'))
    .fluidInputs(fluid('tetrafluoroethylene') * 50)
    .fluidInputs(fluid('sulfur_trioxide') * 50)
    .fluidOutputs(fluid('fluorosulfonyl_difluoroacetyl_fluoride') * 50)
    .duration(5)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

LCR.recipeBuilder()
    .notConsumable(ore('dustPotassiumFluoride') * 4)
    .inputs(ore('dustPotassiumCarbonate') * 5)
    .fluidInputs(fluid('dimethylformamide') * 4000)
    .fluidInputs(fluid('hexafluoropropylene_oxide') * 2000)
    .fluidInputs(fluid('fluorosulfonyl_difluoroacetyl_fluoride') * 1000)
    .fluidOutputs(fluid('perfluorovinyl_sulfonyl_ether_solution') * 5000)
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .duration(1000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister();

DT.recipeBuilder()
    .fluidInputs(fluid('perfluorovinyl_sulfonyl_ether_solution') * 4000)
    .outputs(metaitem('dustPotassiumFluoride') * 8)
    .fluidOutputs(fluid('perfluorovinyl_sulfonyl_ether') * 1000)
    .fluidOutputs(fluid('dimethylformamide') * 4000)
    .duration(1000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister();

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('fluorinated_surfactant_mixture') * 500)
    .fluidInputs(fluid('perfluorovinyl_sulfonyl_ether') * 1000)
    .fluidInputs(fluid('tetrafluoroethylene') * 1000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('nafion_solution') * 500)
    .duration(200)
    .EUt(240)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('nafion_solution') * 500)
    .outputs(metaitem('dustNafion'))
    .fluidOutputs(fluid('fluorinated_surfactant_mixture') * 500)
    .duration(200)
    .EUt(240)
    .buildAndRegister()