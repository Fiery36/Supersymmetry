import globals.Globals
import static globals.CarbonGlobals.*

ROASTER = recipemap('roaster')
CENTRIFUGE = recipemap('centrifuge')
AUTOCLAVE = recipemap('autoclave')
BR = recipemap('batch_reactor')
EBF = recipemap('electric_blast_furnace')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
BCR = recipemap('bubble_column_reactor')
DISTILLERY = recipemap('distillery')
EMSEPARATOR = recipemap('electromagnetic_separator')
ELECTROLYZER = recipemap('electrolyzer')
CRYSTALLIZER = recipemap('crystallizer')
ZONE_REFINER = recipemap('zone_refiner')

// Aluminium Nugget * 3
mods.gregtech.electric_blast_furnace.removeByInput(100, [metaitem('dustRuby')], null)
//Remove EBF recipe with Aluminium Dust:
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustAluminium'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('nitrogen') * 1000])
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustAluminium'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
//EBF recipe with Al dust re-enabled:
EBF.recipeBuilder()
    .inputs(ore('dustAluminium'))
    .outputs(metaitem('ingotAluminium'))
    .duration(240)
    .blastFurnaceTemp(933)
    .EUt(120)
    .buildAndRegister()

// remove auto generated furnace recipe, split into separate normal/pure recipes.
furnace.removeByInput(metaitem('dustHighPurityAluminium'))
EBF.recipeBuilder()
    .inputs(ore('dustHighPurityAluminium'))
    .outputs(metaitem('ingotHighPurityAluminium'))
    .duration(240)
    .blastFurnaceTemp(933)
    .EUt(120)
    .buildAndRegister()


// Ruby Slurry * 3000
mods.gregtech.mixer.removeByInput(1920, [metaitem('crushedRuby') * 2], [fluid('aqua_regia') * 3000])
mods.gregtech.blender.removeByInput(1920, [metaitem('crushedRuby') * 2], [fluid('aqua_regia') * 3000])
// Sapphire Slurry * 3000
mods.gregtech.mixer.removeByInput(1920, [metaitem('crushedSapphire') * 2], [fluid('aqua_regia') * 3000])
mods.gregtech.blender.removeByInput(1920, [metaitem('crushedSapphire') * 2], [fluid('aqua_regia') * 3000])
// Green Sapphire Slurry * 3000
mods.gregtech.mixer.removeByInput(1920, [metaitem('crushedGreenSapphire') * 2], [fluid('aqua_regia') * 3000])
mods.gregtech.blender.removeByInput(1920, [metaitem('crushedGreenSapphire') * 2], [fluid('aqua_regia') * 3000])

// Bauxite -> Red Mud

ROASTER.recipeBuilder()
.fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
.inputs(ore('dustBauxite') * 5)
.fluidOutputs(fluid('impure_sodium_aluminate_solution') * 3000)
.duration(200)
.EUt(16)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('impure_sodium_aluminate_solution') * 3000)
.fluidOutputs(fluid('sodium_aluminate_solution') * 3000)
.fluidOutputs(fluid('red_mud') * 500)
.duration(200)
.EUt(16)
.buildAndRegister()

// Carbon dioxide bubbling

CRYSTALLIZER.recipeBuilder()
.fluidInputs(fluid('sodium_aluminate_solution') * 3000)
.fluidInputs(fluid('water') * 1000)
.fluidInputs(fluid('carbon_dioxide') * 1000)
.fluidOutputs(fluid('impure_soda_ash_solution') * 1000)
.outputs(metaitem('dustAluminiumHydroxide') * 14)
.duration(300)
.EUt(20)
.buildAndRegister()

CRYSTALLIZER.recipeBuilder()
.fluidInputs(fluid('sodium_aluminate_solution') * 1500)
.fluidInputs(fluid('water') * 1500)
.notConsumable(ore('dustAluminiumHydroxide'))
.fluidOutputs(fluid('impure_sodium_hydroxide_solution') * 1000) //TO GALLIUM PROCESSING
.outputs(metaitem('dustAluminiumHydroxide') * 7)
.duration(300)
.EUt(16)
.buildAndRegister()

// Alumina from Al(OH)3

EBF.recipeBuilder()
.inputs(ore('dustAluminiumHydroxide') * 14)
.fluidOutputs(fluid('dense_steam') * 3000)
.outputs(metaitem('dustAlumina') * 5)
.duration(100)
.blastFurnaceTemp(1400)
.EUt(40)
.buildAndRegister()

// Electrolysis

ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('cryolite') * 2592)
        .inputs(ore('dustAlumina') * 10)
        .notConsumable(ore('dustAluminiumTrifluoride') * 4)
        .inputs(ore('dustCoke') * 3)
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .outputs(metaitem('ingotAluminium') * 4)
        .duration(300)
        .EUt(40)
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('cryolite') * 2592)
        .inputs(ore('dustAlumina') * 10)
        .notConsumable(ore('dustAluminiumTrifluoride') * 4)
        .inputs(ore('dustAnyPurityCarbon') * 3)
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .outputs(metaitem('ingotAluminium') * 4)
        .duration(100)
        .EUt(40)
        .buildAndRegister()

// Production of cryolite

ROASTER.recipeBuilder()
.fluidInputs(fluid('hydrofluoric_acid') * 6000)
.inputs(ore('dustAlumina') * 5)
.fluidOutputs(fluid('dense_steam') * 9000)
.outputs(metaitem('dustAluminiumTrifluoride') * 8)
.duration(300)
.EUt(16)
.buildAndRegister()

BCR.recipeBuilder()
.fluidInputs(fluid('hydrogen_fluoride') * 50)
.fluidInputs(fluid('sodium_hydroxide_solution') * 50)
.fluidOutputs(fluid('sodium_fluoride_solution') * 50)
.duration(5)
.EUt(16)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('sodium_fluoride_solution') * 1000)
.fluidOutputs(fluid('water') * 1000)
.outputs(metaitem('dustSodiumFluoride') * 2)
.duration(200)
.EUt(7)
.buildAndRegister()

ROASTER.recipeBuilder()
.inputs(ore('dustAluminiumTrifluoride') * 4)
.inputs(ore('dustSodiumFluoride') * 6)
.outputs(metaitem('dustCryolite') * 10)
.duration(180)
.EUt(16)
.buildAndRegister()

// Red mud processing

EMSEPARATOR.recipeBuilder()
.fluidInputs(fluid('red_mud') * 2000)
.chancedOutput(metaitem('dustIronIiiOxide'), 5000, 0)
.fluidOutputs(fluid('concentrated_red_mud') * 1000)
.duration(200)
.EUt(96)
.buildAndRegister()

EBF.recipeBuilder()
.fluidInputs(fluid('concentrated_red_mud') * 2000)
.outputs(ore('ingotIron').first())
.outputs(metaitem('red_mud_slag'))
.blastFurnaceTemp(1600)
.duration(300)
.EUt(Globals.voltAmps[2] * 2)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 250)
.inputs(metaitem('red_mud_slag'))
.outputs(metaitem('dustTinyRutile') * 3)
.outputs(metaitem('leached_red_mud_slag'))
.duration(100)
.EUt(Globals.voltAmps[3])
.buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 3000)
        .inputs(ore('dustAluminiumHydroxide') * 14)
        .fluidOutputs(fluid('aluminium_sulfate_solution') * 6000)
        .duration(100)
        .EUt(96)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 3000)
        .fluidInputs(fluid('water') * 3000)
        .inputs(ore('dustAlumina') * 5)
        .fluidOutputs(fluid('aluminium_sulfate_solution') * 6000)
        .duration(100)
        .EUt(96)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('aluminium_sulfate_solution') * 6000)
        .outputs(metaitem('dustAluminiumSulfate') * 17)
        .fluidOutputs(fluid('water') * 6000)
        .duration(100)
        .EUt(96)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 3000)
        .inputs(ore('dustAnyPurityAluminium') * 2)
        .outputs(metaitem('dustAluminiumSulfate') * 17)
        .fluidOutputs(fluid('hydrogen') * 6000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

// CENTRIFUGE.recipeBuilder()
// .fluidInputs(fluid('hydrochloric_acid') * 500)
// .inputs(metaitem('leached_red_mud_slag'))
// .fluidOutputs(fluid('acidic_ree_solution') * 500)
// .duration(100)
// .EUt(Globals.voltAmps[4])
// .buildAndRegister()

BR.recipeBuilder()      
        .inputs(ore('dustAluminiumSulfate') * 17)
        .fluidInputs(fluid('sodium_bicarbonate_solution') * 6000)
        .outputs(metaitem('dustAluminiumHydroxide') * 14)
        .fluidOutputs(fluid('diluted_sodium_sulfate_solution') * 6000)
        .fluidOutputs(fluid('carbon_dioxide') * 6000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

// Ullman's - Aluminium Ch. 5. Hall-Heroult makes like 99.9% pure already so not making it a chanced output.
ZONE_REFINER.recipeBuilder()
    .inputs(ore('ingotAluminium'))
    .outputs(metaitem('ingotHighPurityAluminium'))
    .duration(200)
    .EUt(30)
    .buildAndRegister()
