import globals.Globals
import postInit.utils.RecyclingHelper
import gregtech.api.recipes.ingredients.nbtmatch.*

import static gregtech.api.unification.material.Materials.*;

ASSEMBLER = recipemap('assembler')
CHEMICAL_BATH = recipemap('chemical_bath')
CSTR = recipemap('continuous_stirred_tank_reactor')
SINTERING_OVEN = recipemap('sintering_oven')
FORMING_PRESS = recipemap('forming_press')
CANNER = recipemap('canner')
SPENT_FUEL_POOL = recipemap('spent_fuel_pool')
CUTTING_MACHINE = recipemap('cutting_machine')

// Gas Centrifuge

    // Gas Centrifuge Column

    ASSEMBLER.recipeBuilder()
        .inputs(ore('plateAluminium') * 20)
        .inputs(ore('plateReinforcedEpoxyResin') * 20)
        .inputs(ore('pipeSmallFluidAluminium') * 6)
        .inputs(ore('stickLongStainlessSteel') * 8)
        .inputs(ore('ringStainlessSteel') * 8)
        .inputs(ore('plateStainlessSteel') * 20)
        .inputs(metaitem('electric.pump.ev') * 4)
        .inputs(metaitem('electric.motor.ev'))
        .fluidInputs(fluid('supreme_lubricant') * 5000)
        .circuitMeta(22)
        .outputs(item('supercritical:gas_centrifuge_casing') * 5)
        .duration(240)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

    RecyclingHelper.handleRecycling(item('supercritical:gas_centrifuge_casing') * 5,
        [ore('plateAluminium') * 20,
        ore('pipeSmallFluidAluminium') * 6,
        ore('stickLongStainlessSteel') * 8,
        ore('ringStainlessSteel') * 8,
        ore('plateStainlessSteel') * 20,
        metaitem('electric.pump.ev') * 4,
        metaitem('electric.motor.ev')]
    )

    // Gas Centrifuge Heater

    ASSEMBLER.recipeBuilder()
        .inputs(ore('springKanthal') * 4)
        .inputs(ore('plateStainlessSteel') * 4)
        .inputs(ore('cableGtSingleAluminium') * 4)
        .inputs(ore('frameGtStainlessSteel'))
        .outputs(item('supercritical:nuclear_casing', 1))
        .circuitMeta(22)
        .duration(240)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

    RecyclingHelper.handleRecycling(item('supercritical:nuclear_casing', 1),
        [ore('springKanthal') * 4,
        ore('plateStainlessSteel') * 4,
        ore('cableGtSingleAluminium') * 4,
        ore('frameGtStainlessSteel')]
    )

    // Gas Centrifuge Controller

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('hull.ev'))
        .inputs(ore('circuitEv') * 8)
        .inputs(metaitem('plate.power_integrated_circuit') * 4)
        .inputs(ore('pipeSmallFluidAluminium') * 16)
        .inputs(metaitem('electric.pump.ev') * 4)
        .circuitMeta(22)
        .outputs(metaitem('supercritical:gas_centrifuge'))
        .duration(240)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

    RecyclingHelper.handleRecycling(metaitem('supercritical:gas_centrifuge'),
        [metaitem('hull.ev'),
        ore('circuitEv') * 8,
        metaitem('plate.power_integrated_circuit') * 4,
        ore('pipeSmallFluidAluminium') * 16,
        metaitem('electric.pump.ev') * 4]
    )

// Fission Fuel

def fuels = [
    //'ThoriumDioxide',
    'Leu235Dioxide',
    'Haleu235Dioxide',
    'Heu235Dioxide'
]

    // Fuel Cladding
    ASSEMBLER.recipeBuilder()
        .inputs(ore('plateZircaloy') * 4)
        .inputs(ore('springInconel625'))
        .inputs(ore('roundStainlessSteel') * 2)
        .outputs(metaitem('supercritical:cladding.fuel'))
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    RecyclingHelper.handleRecycling(metaitem('supercritical:cladding.fuel'),
        [ore('plateZircaloy') * 4,
        ore('springInconel625'),
        ore('roundStainlessSteel') * 2]
    )

for (fuel in fuels) {
    FORMING_PRESS.recipeBuilder()
        .inputs(ore('dust' + fuel) * 3)
        .outputs(metaitem('fuelPelletRaw' + fuel))
        .duration(25)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    SINTERING_OVEN.recipeBuilder()
        .inputs(ore('fuelPelletRaw' + fuel))
        .outputs(metaitem('fuelPellet' + fuel))
        .duration(15)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

    CANNER.recipeBuilder()
        .inputs(ore('fuelPellet' + fuel) * 16)
        .inputs(metaitem('suprcritical:cladding.fuel'))
        .outputs(metaitem('fuelRod' + fuel))
        .duration(300)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()
}

// Fission Reactor Controller

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(ore('circuitEv') * 16)
    .inputs(ore('wireFineRedAlloy') * 16)
    .inputs(metaitem('sensor.ev') * 16)
    .circuitMeta(31)
    .outputs(metaitem('supercritical:fission_reactor'))
    .duration(240)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('supercritical:fission_reactor'),
    [metaitem('hull.ev'),
    ore('circuitEv') * 4,
    ore('wireFineRedAlloy') * 16,
    metaitem('sensor.ev') * 16]
)

// Fission Reactor Vessel

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateDoubleInconel625'))
    .inputs(ore('plateStainlessSteel') * 5)
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('supercritical:fission_casing'))
    .duration(320)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('supercritical:fission_casing'),
    [ore('plateDoubleInconel625'),
    ore('plateStainlessSteel') * 5,
    ore('frameGtStainlessSteel')]
)

// Fuel Channel
ASSEMBLER.recipeBuilder()
    .inputs(ore('stickZircaloy') * 6)
    .inputs(ore('ringZircaloy'))
    .circuitMeta(1)
    .outputs(item('supercritical:fission_casing', 1))
    .duration(320)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('supercritical:fission_casing', 1),
    [ore('stickZircaloy') * 6,
    ore('ringZircaloy')]
)

// Control Rod Channel
ASSEMBLER.recipeBuilder()
    .inputs(ore('stickZircaloy') * 3)
    .inputs(ore('ringZircaloy'))
    .circuitMeta(2)
    .outputs(item('supercritical:fission_casing', 2))
    .duration(320)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('supercritical:fission_casing', 2),
    [ore('stickZircaloy') * 3,
    ore('ringZircaloy')]
)

// Coolant Channel
ASSEMBLER.recipeBuilder()
    .inputs(ore('pipeLargeFluidInconel625'))
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('supercritical:fission_casing', 3))
    .duration(320)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('supercritical:fission_casing', 3),
    [ore('pipeLargeFluidInconel625'),
    ore('frameGtStainlessSteel')]
)

// Fuel Rod Input Port
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(ore('stickZircaloy') * 6)
    .fluidInputs(fluid('polytetrafluoroethylene') * 144)
    .circuitMeta(1)
    .outputs(metaitem('supercritical:fuel_rod_input'))
    .duration(300)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('supercritical:fuel_rod_output'),
    [metaitem('hull.ev'),
    ore('stickZircaloy') * 6,
    ore('ingotPolytetrafluoroethylene')]
)

// Fuel Rod Output Port
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(ore('stickZircaloy') * 6)
    .fluidInputs(fluid('polytetrafluoroethylene') * 144)
    .circuitMeta(2)
    .outputs(metaitem('supercritical:fuel_rod_output'))
    .duration(300)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('supercritical:fuel_rod_input'),
    [metaitem('hull.ev'),
    ore('stickZircaloy') * 6,
    ore('ingotPolytetrafluoroethylene')]
)

// Coolant Input Port
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(ore('pipeLargeFluidInconel625'))
    .fluidInputs(fluid('polytetrafluoroethylene') * 144)
    .circuitMeta(1)
    .outputs(metaitem('supercritical:coolant_input'))
    .duration(300)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('supercritical:coolant_input'),
    [metaitem('hull.ev'),
    ore('pipeLargeFluidInconel625'),
    ore('ingotPolytetrafluoroethylene')]
)

// Coolant Output Port
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(ore('pipeLargeFluidInconel625'))
    .fluidInputs(fluid('polytetrafluoroethylene') * 144)
    .circuitMeta(2)
    .outputs(metaitem('supercritical:coolant_output'))
    .duration(300)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('supercritical:coolant_output'),
    [metaitem('hull.ev'),
    ore('pipeLargeFluidInconel625'),
    ore('ingotPolytetrafluoroethylene')]
)

// Control Rod Port
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(ore('circuitEv'))
    .inputs(metaitem('electric.piston.ev'))
    .inputs(ore('stickLongHafnium'))
    .fluidInputs(fluid('polytetrafluoroethylene') * 144)
    .circuitMeta(1)
    .outputs(metaitem('supercritical:control_rod'))
    .duration(300)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('supercritical:control_rod'),
    [metaitem('hull.ev'),
    ore('circuitEv'),
    ore('stickLongHafnium'),
    ore('ingotPolytetrafluoroethylene')]
)

// Graphite-Tipped Control Rod Port
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(ore('circuitEv'))
    .inputs(metaitem('electric.piston.ev'))
    .inputs(ore('stickLongHafnium'))
    .inputs(ore('dustGraphite'))
    .fluidInputs(fluid('polytetrafluoroethylene') * 144)
    .circuitMeta(2)
    .outputs(metaitem('supercritical:control_rod_moderated'))
    .duration(300)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('supercritical:control_rod_moderated'),
    [metaitem('hull.ev'),
    ore('circuitEv'),
    metaitem('electric.piston.ev'),
    ore('stickLongHafnium'),
    ore('dustGraphite'),
    ore('ingotPolytetrafluoroethylene')]
)

// Anode Basket
ASSEMBLER.recipeBuilder()
    .inputs(ore('ringTitanium') * 2)
    .inputs(ore('stickTitanium') * 16)
    .outputs(metaitem('supercritical:basket.anode'))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('supercritical:basket.anode'),
    [ore('ringTitanium') * 2,
    ore('stickTitanium') * 16]
)


// Spent Fuel Pool

    // Spent Fuel Pool Controller

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('hull.hv'))
        .inputs(item('gregtech:stone_smooth', 4) * 16)
        .inputs(ore('plateStainlessSteel') * 16)
        .inputs(metaitem('robot_arm.hv'))
        .circuitMeta(30)
        .outputs(metaitem('supercritical:spent_fuel_pool'))
        .duration(120)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

    RecyclingHelper.handleRecycling(metaitem('supercritical:spent_fuel_pool'),
        [metaitem('hull.hv'),
        ore('circuitHv') * 4,
        ore('pipeSmallFluidAluminium') * 16,
        metaitem('electric.pump.hv') * 16]
    )

    // Panelling

    ASSEMBLER.recipeBuilder()
        .inputs(ore('plateStainlessSteelSteel') * 6)
        .inputs(ore('frameGtStainlessSteel'))
        .fluidInputs(fluid('concrete') * 144)
        .circuitMeta(17)
        .outputs(item('supercritical:panelling', 7))
        .EUt(16)
        .duration(120)
        .buildAndRegister()

    for (int i = 0; i < CHEMICAL_DYES.length; i++) {
        CHEMICAL_BATH.recipeBuilder()
            .inputs(item('supercritical:panelling', 7))
            .fluidInputs(CHEMICAL_DYES[i].getFluid(9))
            .outputs(item('supercritical:panelling', i))
            .EUt(2).duration(10)
            .buildAndRegister()

        RecyclingHelper.handleRecycling(item('supercritical:panelling', i),
            [ore('plateStainlessSteelSteel') * 6,
            ore('blockConcrete')]
        )
    }

    // Spent Fuel Casing
    
    ASSEMBLER.recipeBuilder()
        .inputs(ore('plateBoron10Carbide') * 4) // NEEDS TO BE BORON 10
        .inputs(ore('frameGtStainlessSteel'))
        .outputs(item('supercritical:nuclear_casing'))
        .duration(300)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    RecyclingHelper.handleRecycling(item('supercritical:nuclear_casing'),
        [ore('plateBoron10Carbide') * 4]
    )

// Fuel Rod Decay

for (fuel in fuels) {
    SPENT_FUEL_POOL.recipeBuilder()
        .inputs(metaitem('fuelRodHotDepleted' + fuel))
        .outputs(metaitem('fuelRodDepleted' + fuel))
        .duration(1000)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    CUTTING_MACHINE.recipeBuilder()
        .inputs(metaitem('fuelRodDepleted' + fuel))
        .outputs(metaitem('fuelPelletDepleted' + fuel) * 16)
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
}