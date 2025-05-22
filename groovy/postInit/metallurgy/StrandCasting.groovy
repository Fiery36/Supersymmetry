POLISHING = recipemap('polishing_machine')
ADVANCED_ARC_FURNACE = recipemap('advanced_arc_furnace')
FLUID_SOLIDIFIER = recipemap('fluid_solidifier')
ASSEMBLER = recipemap('assembler')
// Recipes for the machines and components needed for the multiblocks

// Rolls
FLUID_SOLIDIFIER.recipeBuilder()
        .fluidInputs(fluid('vanadium_steel') * 432)
        .inputs(metaitem('shape.mold.cylinder'))
        .outputs(metaitem('work_roll.unfinished'))
        .EUt(30)
        .duration(80)
        .build()

POLISHING.recipeBuilder()
        .inputs(metaitem('work_roll.unfinished'))
        .fluidInputs(fluid('silicon_dioxide_slurry') * 100)
        .outputs(item('susy:metallurgy_roll'))
        .EUt(120)
        .duration(200)
        .build()

// Hydraulic Press
ASSEMBLER.recipeBuilder()
        .inputs(ore('plateDoubleStainlessSteel'))
        .inputs(ore('stickStainlessSteel'))
        .inputs(ore('boltStainlessSteel') * 4)
        .inputs(ore('ringRubber') * 2)
        .inputs(ore('pipeNormalFluidStainlessSteel'))
        .fluidInputs(fluid('silicone_oil') * 100)
        .outputs(item('susy:metallurgy'))
        .EUt(120)
        .duration(300)
        .build()

// Flying Shear Saw
ASSEMBLER.recipeBuilder()
        .inputs(metaitem('component.grinder.diamond'))
        .inputs(ore('stickStainlessSteel'))
        .inputs(item('gregtech:metal_casing', 4))
        .inputs(metaitem('electric.motor.hv'))
        .inputs(metaitem('cableGtSingleGold') * 2)
        .outputs(item('susy:metallurgy_2'))
        .EUt(16)
        .duration(100)
        .build()

// Monel 500 casings
ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateMonel500') * 6)
        .outputs(metaitem('frameHsla980X'))
        .outputs(item('susy:susy_multiblock_casing', 5) * 4)
        .EUt(16)
        .duration(100)
        .build()

// Pipe casing
crafting.addShaped("susy:monel_500_pipe_casing", item('susy:susy_multiblock_casing', 6) * 2, [
    [ore('plateMonel500'), ore('pipeNormalFluidMonel500'), ore('plateMonel500')],
    [ore('pipeNormalFluidMonel500'), metaitem('frameHsla980X'), ore('pipeNormalFluidMonel500')],
    [ore('plateMonel500'), ore('pipeNormalFluidMonel500'), ore('plateMonel500')]
])

// Machines
// Gas atomizer
crafting.addShaped("susy:gas_atomizer", metaitem('gas_atomizer'), [
    [ore('plateSteel'), item('electric.pump.ev'), ore('plateSteel')],
        [ore('circuitEv'), item('susy:susy_multiblock_casing', 6), ore('circuitEv')],
        [ore('plateSteel'), item('electric.pump.ev'), ore('plateSteel')]
])

// Hot isostatic press
crafting.addShaped("susy:hot_isostatic_press", metaitem('hot_isostatic_press'), [
    [ore('plateSiliconCarbide'), item('electric.pump.ev'), ore('plateSiliconCarbide')],
        [ore('circuitEv'), item('susy:susy_multiblock_casing'), ore('circuitEv')],
        [ore('plateSiliconCarbide'), item('electric.piston.ev'), ore('plateSiliconCarbide')]
])

// Turning zone
crafting.addShaped("susy:turning_zone", metaitem('turning_zone'), [
        [ore('gearUltimet'), metaitem('cableGtOctalNichrome'), ore('gearUltimet')],
    [item('electric.motor.ev'), item('gregtech:metal_casing', 4), item('electric.motor.ev')],
    [item('electric.motor.ev'), ore('circuitMv'), item('electric.motor.ev')]
])

// Rolling mill and cluster mill
crafting.addShaped("susy:rolling_mill", metaitem('rolling_mill'), [
        [ore('gearUltimet'), metaitem('cableGtOctalNichrome'), ore('gearUltimet')],
    [item('electric.pump.ev'), item('gregtech:boiler_casing', 1), item('electric.pump.ev')],
    [item('electric.motor.ev'), metaitem('cableGtOctalNichrome'), item('electric.motor.ev')]
])

crafting.addShaped("susy:cluster_mill", metaitem('cluster_mill'), [
        [ore('gearUltimet'), metaitem('cableGtHexNichrome'), ore('gearUltimet')],
        [item('electric.pump.ev'), item('gregtech:boiler_casing', 1), item('electric.pump.ev')],
        [item('electric.motor.ev'), metaitem('cableGtHexNichrome'), item('electric.motor.ev')]
])

// Flying shear
crafting.addShaped("susy:flying_shear", metaitem('flying_shear'), [
        [ore('gearUltimet'), metaitem('cableGtOctalNichrome'), ore('gearUltimet')],
        [item('electric.sensor.ev'), item('gregtech:metal_casing', 4), item('electric.piston.ev')],
        [item('electric.motor.ev'), ore('circuitEv'), item('electric.piston.ev')]
])

// Fast steel generation in large arc furnace
ADVANCED_ARC_FURNACE.recipeBuilder()
        .inputs(ore('ingotPigIron') * 18)
        .fluidInputs(fluid('oxygen') * 400)
        .fluidOutputs(fluid('molten.steel') * 2592)
        .EUt(120)
        .duration(65) // Give a good number of overclocks
        .buildAndRegister()

// Fast aluminium generation in large arc furnace
ADVANCED_ARC_FURNACE.recipeBuilder()
        .notConsumable(fluid('cryolite') * 7776)
        .inputs(ore('dustAlumina') * 45)
        .notConsumable(ore('dustAluminiumTrifluoride') * 12)
        .inputs(ore('dustCoke') * 14)
        .fluidOutputs(fluid('carbon_dioxide') * 13500)
        .fluidOutputs(fluid('molten.aluminium') * 2592)
        .duration(300)
        .EUt(120)
        .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder()
        .notConsumable(fluid('cryolite') * 7776)
        .inputs(ore('dustAlumina') * 45)
        .notConsumable(ore('dustAluminiumTrifluoride') * 12)
        .inputs(ore('dustCoke') * 14)
        .fluidOutputs(fluid('carbon_dioxide') * 13500)
        .fluidOutputs(fluid('molten.aluminium') * 2592)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

// Fast copper generation in large arc furnace

def copperOres = [
        "Copper",
        "Tetrahedrite",
        "Bornite",
        "Chalcopyrite",
        "Chalcocite"
]
def orePrefixes = [
        "ore",
        "crushed",
        "dust",
        "crushedPurified",
        "dustImpure",
        "dustPurified",
        "crushedCentrifuged"
]

for (ore in copperOres) {
    for (prefix in orePrefixes) {
        ADVANCED_ARC_FURNACE.recipeBuilder()
                .inputs(ore(prefix + ore) * 18)
                .fluidOutputs(fluid('molten.copper') * 2592)
                .EUt(120)
                .duration(65) // Give a good number of overclocks
                .buildAndRegister()
    }
    ADVANCED_ARC_FURNACE.recipeBuilder()
            .inputs(ore('oreNetherrack' + ore) * 9)
            .fluidOutputs(fluid('molten.copper') * 2592)
            .EUt(120)
            .duration(65) // Give a good number of overclocks
            .buildAndRegister()
    ADVANCED_ARC_FURNACE.recipeBuilder()
            .inputs(ore('oreEndstone' + ore) * 9)
            .fluidOutputs(fluid('molten.copper') * 2592)
            .EUt(120)
            .duration(65) // Give a good number of overclocks
            .buildAndRegister()
}

for (prefix in orePrefixes) {
    ADVANCED_ARC_FURNACE.recipeBuilder()
            .inputs(ore(prefix + "Malachite") * 18)
            .outputs(fluid('molten.copper') * 5184)
            .EUt(120)
            .duration(65) // Give a good number of overclocks
            .buildAndRegister()
}
ADVANCED_ARC_FURNACE.recipeBuilder()
        .inputs(ore('oreNetherrackMalachite') * 9)
        .outputs(fluid('molten.copper') * 5184)
        .EUt(120)
        .duration(65) // Give a good number of overclocks
        .buildAndRegister()
ADVANCED_ARC_FURNACE.recipeBuilder()
        .inputs(ore('oreEndstoneMalachite') * 9)
        .outputs(fluid('molten.copper') * 5184)
        .EUt(120)
        .duration(65) // Give a good number of overclocks
        .buildAndRegister()