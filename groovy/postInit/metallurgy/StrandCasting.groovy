POLISHING = recipemap('polishing_machine')
ADVANCED_ARC_FURNACE = recipemap('advanced_arc_furnace')

// Recipes for the machines and components needed for the multiblocks

// Rolls

POLISHING.recipeBuilder()
    .input()
    .fluidInputs(fluid('silicon_dioxide_slurry') * 100)
    .output(item('susy:metallurgy_roll'))
    .EUt(120)
    .duration(200)
    .build()

// Fast steel generation in large arc furnace
ADVANCED_ARC_FURNACE.recipeBuilder()
    .input(ore('ingotPigIron') * 18)
    .fluidInputs(fluid('oxygen') * 400)
    .outputs(fluid('steel') * 2592)
    .EUt(120)
    .duration(65) // Give a good number of overclocks
    .buildAndRegister()

// Fast aluminium generation in large arc furnace
ADVANCED_ARC_FURNACE.recipeBuilder()
        .notConsumable(fluid('cryolite') * 7776)
        .inputs(ore('dustAlumina') * 30)
        .inputs(ore('dustAluminiumTrifluoride') * 3)
        .inputs(ore('dustCoke') * 9)
        .fluidOutputs(fluid('hydrogen_fluoride') * 2250)
        .fluidOutputs(fluid('carbon_dioxide') * 9000)
        .fluidOutputs(fluid('aluminium') * 576)
        .duration(300)
        .EUt(120)
        .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder()
        .notConsumable(fluid('cryolite') * 7776)
        .inputs(ore('dustAlumina') * 30)
        .inputs(ore('dustAluminiumTrifluoride') * 3)
        .inputs(ore('dustAnyPurityCarbon') * 9)
        .fluidOutputs(fluid('hydrogen_fluoride') * 2250)
        .fluidOutputs(fluid('carbon_dioxide') * 9000)
        .fluidOutputs(fluid('aluminium') * 576)
        .duration(100)
        .EUt(120)
        .buildAndRegister()
// Fast copper generation in large arc furnace