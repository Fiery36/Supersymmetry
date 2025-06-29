import globals.Globals

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')
BCR = recipemap('bubble_column_reactor')
MIXER = recipemap('mixer')
POLYMERIZATION_TANK = recipemap('polymerization_tank')
DRYER = recipemap('dryer')

// Lithium Perfluorooctanoate Surfactant
BR.recipeBuilder()
    .inputs(ore('dustPerfluorooctanoicAcid') * 13)
    .fluidInputs(fluid('lithium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('pvdf_surfactant_mixture') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

// Vinylidene Fluoride
BCR.recipeBuilder()
    .notConsumable(metaitem('catalystBedIronIiiChloride'))
    .fluidInputs(fluid('vinyl_chloride') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidOutputs(fluid('one_one_dichloroethane') * 50)
    .duration(2)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BCR.recipeBuilder()
    .notConsumable(metaitem('carbon_arc_lamp'))
    .fluidInputs(fluid('one_one_dichloroethane') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidOutputs(fluid('one_one_one_trichloroethane') * 50)
    .fluidOutputs(fluid('hydrogen') * 1000)
    .duration(4)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

ROASTER.recipeBuilder()
    .notConsumable(ore('dustMolybdenum'))
    .fluidInputs(fluid('one_one_one_trichloroethane') * 1000)
    .fluidInputs(fluid('hydrofluoric_acid') * 2000)
    .fluidOutputs(fluid('one_chloro_two_two_difluoroethane') * 1000)
    .fluidOutputs(fluid('hydrochloric_acid') * 2000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

BR.recipeBuilder()
    .fluidInputs(fluid('one_chloro_two_two_difluoroethane') * 1000)
    .fluidInputs(fluid('sodium_ethoxide_solution') * 1000)
    .fluidOutputs(fluid('vinylidene_fluoride') * 1000)
    .fluidOutputs(fluid('ethanol') * 1000)
    .fluidOutputs(fluid('salt_water') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

// Polymerization
MIXER.recipeBuilder()
    .fluidInputs(fluid('vinylidene_fluoride') * 1000)
    .fluidInputs(fluid('pvdf_surfactant_mixture') * 1000)
    .fluidOutputs(fluid('pvdf_preparation_mixture') * 1000)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('pvdf_preparation_mixture') * 1000)
    .fluidOutputs(fluid('pvdf_polymerization_mixture') * 1000)
    .duration(300)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();

DRYER.recipeBuilder()
    .fluidInputs(fluid('pvdf_polymerisation_mixture') * 1000)
    .outputs(metaitem('dustPolyvinylideneFluoride'))
    .fluidOutputs(fluid('pvdf_surfactant_mixture') * 1000)
    .duration(300)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister();