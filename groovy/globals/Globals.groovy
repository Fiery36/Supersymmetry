package globals

import com.cleanroommc.groovyscript.api.IIngredient
import gregtech.api.GTValues
import gregtech.api.fluids.store.FluidStorageKeys
import gregtech.api.fluids.store.FluidStorage
import gregtech.api.unification.material.properties.*
import gregtech.api.unification.material.Material

import static gregtech.api.fluids.FluidConstants.*

class Globals {
    public static voltageTiers = GTValues.VN.collect { it.toLowerCase() }

    public static dimensions = ["Overworld": 0, "Beneath": 10, "Nether": -1]

    public static solders = [
        'tin': 144,
        'soldering_alloy': 72
    ]

    public static wireCoatings = [
        'rubber': 144,
        'silicone_rubber': 72,
        'styrene_butadiene_rubber': 36
    ]

    public static mod_priority = [
        "minecraft",
        "gregtech",
        "gcym",
        "libvulpes",
        "techguns",
        "advancedrocketry",
        "biomesoplenty"
    ]

    record InertGas(String name, int amount_required, int duration, int tier) {}
    public static inertGases = [
        new InertGas('nitrogen', 8000, 4, 1),
        new InertGas('argon', 4000, 2, 2),
        new InertGas('helium', 1000, 1, 3)
    ]


    public static elementList = [
        'Lithium' , 'Beryllium', 'Boron', 'Carbon', 'Sodium', 'Magnesium', 'Aluminium', 'Silicon',
        'Phosphorus' , 'Sulfur', 'Potassium', 'Calcium', 'Scandium', 'Titanium', 'Vanadium', 'Chrome',
        'Manganese' , 'Iron', 'Cobalt', 'Nickel', 'Copper', 'Zinc', 'Gallium', 'Germanium', 'Arsenic',
        'Selenium' , 'Rubidium', 'Strontium', 'Yttrium', 'Ruthenium', 'Zirconium', 'Niobium', 'Molybdenum', 'Technetium',
        'Rhenium' , 'Rhodium', 'Palladium', 'Silver', 'Cadmium', 'Indium', 'Tin', 'Antimony', 'Tellurium',
        'Iodine' , 'Caesium', 'Barium', 'Lanthanum', 'Hafnium', 'Tantalum', 'Tungsten', 'Osmium',
        'Iridium' , 'Platinum', 'Gold', 'Thallium', 'Lead', 'Bismuth', 'Cerium', 'Praseodymium',
        'Neodymium' , 'Samarium', 'Europium', 'Gadolinium', 'Terbium', 'Dysprosium', 'Holmium', 'Erbium',
        'Thulium' , 'Ytterbium', 'Lutetium', 'Thorium'
    ]

    public static int determineTemperatureGas(Material material) {
        if (material.getProperty(PropertyKey.FLUID) != null && material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.GAS) != null) {
            def current = material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.GAS).temperature
          if (current != -1) {
                return current
            }
        }
        BlastProperty property = material.getProperty(PropertyKey.BLAST)
           if (property == null) {
            return ROOM_TEMPERATURE
        } else {
            return property.getBlastTemperature() + GAS_TEMPERATURE_OFFSET
        }
    }

    private static int determineTemperatureLiquid(Material material) {
        if (material.getProperty(PropertyKey.FLUID) != null && material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.LIQUID) != null) {
            def current = material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.LIQUID).temperature
          if (current != -1) {
                return current
            }
        }
        BlastProperty property = material.getProperty(PropertyKey.BLAST);
        if (property == null) {
            if (material.hasProperty(PropertyKey.DUST)) {
                   return SOLID_LIQUID_TEMPERATURE;
            }
            return ROOM_TEMPERATURE;
        } else {
            return property.getBlastTemperature() + LIQUID_TEMPERATURE_OFFSET
        }
    }

    def circuits = [ore('circuitUlv'), ore('circuitLv'), ore('circuitMv'),
                    ore('circuitHv'), ore('circuitEv'), ore('circuitIv'),
                    ore('circuitLuv'), ore('circuitZpm'), ore('circuitUv'),
                    ore('circuitUhv'), ore('circuitUev'), ore('circuitUiv'),
                    ore('circuitUxv'), ore('circuitOpv')];

    def conveyors = [null, metaitem('conveyor.module.lv'), metaitem('conveyor.module.mv'), metaitem('conveyor.module.hv'),
                     metaitem('conveyor.module.ev'), metaitem('conveyor.module.iv'), metaitem('conveyor.module.luv'),
                     metaitem('conveyor.module.zpm'), metaitem('conveyor.module.uv'), metaitem('conveyor.module.uhv'),
                     metaitem('conveyor.module.uev'), metaitem('conveyor.module.uiv'), metaitem('conveyor.module.opv'),
                     metaitem('conveyor.module.uxv')];

    def pumps = [null, metaitem('electric.pump.lv'), metaitem('electric.pump.mv'), metaitem('electric.pump.hv'),
                 metaitem('electric.pump.ev'), metaitem('electric.pump.iv'), metaitem('electric.pump.luv'),
                 metaitem('electric.pump.zpm'), metaitem('electric.pump.uv'), metaitem('electric.pump.uhv'),
                 metaitem('electric.pump.uev'), metaitem('electric.pump.uiv'), metaitem('electric.pump.uxv'),
                 metaitem('electric.pump.opv')];

/*def regulators = [null, metaitem('fluid.regulator.lv'), metaitem('fluid.regulator.mv'), metaitem('fluid.regulator.hv'),
         metaitem('fluid.regulator.ev'), metaitem('fluid.regulator.iv'), metaitem('fluid.regulator.luv'),
         metaitem('fluid.regulator.zpm'), metaitem('fluid.regulator.uv'), metaitem('fluid.regulator.uhv'),
         metaitem('fluid.regulator.uev'), metaitem('fluid.regulator.uiv'), metaitem('fluid.regulator.uxv'),
         metaitem('fluid.regulator.opv')];*/

    def field_generators = [null, metaitem('field.generator.lv'), metaitem('field.generator.mv'), metaitem('field.generator.hv'),
                            metaitem('field.generator.ev'), metaitem('field.generator.iv'), metaitem('field.generator.luv'),
                            metaitem('field.generator.zpm'), metaitem('field.generator.uv'), metaitem('field.generator.uhv'),
                            metaitem('field.generator.uev'), metaitem('field.generator.uiv'), metaitem('field.generator.uxv'),
                            metaitem('field.generator.opv')];

    def emitters = [null, metaitem('emitter.lv'), metaitem('emitter.mv'), metaitem('emitter.hv'),
                    metaitem('emitter.ev'), metaitem('emitter.iv'), metaitem('emitter.luv'),
                    metaitem('emitter.zpm'), metaitem('emitter.uv'), metaitem('emitter.uhv'),
                    metaitem('emitter.uev'), metaitem('emitter.uiv'), metaitem('emitter.uxv'),
                    metaitem('emitter.opv')];

    def sensors = [null, metaitem('sensor.lv'), metaitem('sensor.mv'), metaitem('sensor.hv'),
                   metaitem('sensor.ev'), metaitem('sensor.iv'), metaitem('sensor.luv'),
                   metaitem('sensor.zpm'), metaitem('sensor.uv'), metaitem('sensor.uhv'),
                   metaitem('sensor.uev'), metaitem('sensor.uiv'), metaitem('sensor.uxv'),
                   metaitem('sensor.opv')];

    def motors = [null, metaitem('electric.motor.lv'), metaitem('electric.motor.mv'), metaitem('electric.motor.hv'),
                  metaitem('electric.motor.ev'), metaitem('electric.motor.iv'), metaitem('electric.motor.luv'),
                  metaitem('electric.motor.zpm'), metaitem('electric.motor.uv'), metaitem('electric.motor.uhv'),
                  metaitem('electric.motor.uev'), metaitem('electric.motor.uiv'), metaitem('electric.motor.uxv'),
                  metaitem('electric.motor.opv')];

    def pistons = [null, metaitem('electric.piston.lv'), metaitem('electric.piston.mv'), metaitem('electric.piston.hv'),
                   metaitem('electric.piston.ev'), metaitem('electric.piston.iv'), metaitem('electric.piston.luv'),
                   metaitem('electric.piston.zpm'), metaitem('electric.piston.uv'), metaitem('electric.piston.uhv'),
                   metaitem('electric.piston.uev'), metaitem('electric.piston.uiv'), metaitem('electric.piston.uxv'),
                   metaitem('electric.piston.opv')];

    def robotArms = [null, metaitem('robot.arm.lv'), metaitem('robot.arm.mv'), metaitem('robot.arm.hv'),
                     metaitem('robot.arm.ev'), metaitem('robot.arm.iv'), metaitem('robot.arm.luv'),
                     metaitem('robot.arm.zpm'), metaitem('robot.arm.uv'), metaitem('robot.arm.uhv'),
                     metaitem('robot.arm.uev'), metaitem('robot.arm.uiv'), metaitem('robot.arm.uxv'),
                     metaitem('robot.arm.opv')];

    def hulls = [metaitem('hull.ulv'), metaitem('hull.lv'), metaitem('hull.mv'), metaitem('hull.hv'),
                 metaitem('hull.ev'), metaitem('hull.iv'), metaitem('hull.luv'),
                 metaitem('hull.zpm'), metaitem('hull.uv'), metaitem('hull.uhv'),
                 metaitem('hull.uev'), metaitem('hull.uiv'), metaitem('hull.uxv'),
                 metaitem('hull.opv')];

    def tieredWires = [ore('wireGtQuadrupleLead'), ore('wireGtQuadrupleCopper'), ore('wireGtQuadrupleCupronickel'), ore('wireGtQuadrupleNichrome'),
                       ore('wireGtQuadrupleKanthal'), ore('stickMolybdenumDisilicide'), ore('wireGtQuadrupleTungsten'),
                       ore('wireGtQuadrupleNaquadah'), ore('wireGtQuadrupleNaquadahAlloy')];

    def tieredPlates = [ore('plateWroughtIron'), ore('plateSteel'), ore('plateAluminium'), ore('plateStainlessSteel'),
                        ore('plateTitanium'), ore('plateTungstenSteel'), ore('plateRhodiumPlatedPalladium'),
                        ore('plateNaquadahAlloy'), ore('plateDarmstadtium')];

    def tieredSticks = [ore('stickWroughtIron'), ore('stickIron'), ore('stickSteel'), ore('stickSteel'),
                        ore('stickNeodymiumAlloy'), ore('stickVanadiumGallium'), ore('stickVanadiumGallium'),
                        ore('stickVanadiumGallium'), ore('stickVanadiumGallium')];

    def tieredGlass = [ore('blockGlass'), ore('blockGlass'), ore('blockGlass'), item('gregtech:transparent_casing:0'),
                       item('gregtech:transparent_casing:0'), item('gregtech:transparent_casing:2'), item('gregtech:transparent_casing:2'),
                       item('gregtech:transparent_casing:1'), item('gregtech:transparent_casing:1')];

    def tieredCables = [ore('cableGtSingleLead'), ore('cableGtSingleTin'), ore('cableGtSingleCopper'), ore('cableGtSingleGold'),
                        ore('cableGtSingleAluminium'), ore('cableGtSinglePlatinum'), ore('cableGtSingleNiobiumTitanium'),
                        ore('cableGtSingleVanadiumGallium'), ore('cableGtSingleYttriumBariumCuprate')]

    def tieredQuadCables = [ore('cableGtQuadrupleLead'), ore('cableGtQuadrupleTin'), ore('cableGtQuadrupleCopper'), ore('cableGtQuadrupleGold'),
                            ore('cableGtQuadrupleAluminium'), ore('cableGtQuadruplePlatinum'), ore('cableGtQuadrupleNiobiumTitanium'),
                            ore('cableGtQuadrupleVanadiumGallium'), ore('cableGtQuadrupleYttriumBariumCuprate')]

    def tieredOctCables = [ore('cableGtOctalLead'), ore('cableGtOctalTin'), ore('cableGtOctalCopper'), ore('cableGtOctalGold'),
                           ore('cableGtOctalAluminium'), ore('cableGtOctalPlatinum'), ore('cableGtOctalNiobiumTitanium'),
                           ore('cableGtOctalVanadiumGallium'), ore('cableGtOctalYttriumBariumCuprate')]

    def tieredHexCables = [ore('cableGtHexLead'), ore('cableGtHexTin'), ore('cableGtHexCopper'), ore('cableGtHexGold'),
                           ore('cableGtHexAluminium'), ore('cableGtHexPlatinum'), ore('cableGtHexNiobiumTitanium'),
                           ore('cableGtHexVanadiumGallium'), ore('cableGtHexYttriumBariumCuprate')]

    def tieredSprings = [metaitem('springIron'), metaitem('springCopper'), metaitem('springCupronickel'), metaitem('springNichrome'),
                         metaitem('springKanthal'), metaitem('springMolybdenumDisilicide'), metaitem('springTungsten'),
                         metaitem('springNaquadah'), metaitem('springNaquadahAlloy')]

    def rotors = [
        ore('rotorLead'),
        ore('rotorTin'),
        ore('rotorBronze'),
        ore('rotorSteel'),
        ore('rotorStainlessSteel'),
        ore('rotorTungstenSteel'),
        ore('rotorRhodiumPlatedPalladium'),
        ore('rotorNaquadahAlloy'),
        ore('rotorDarmstadtium')
    ]

    def chemicalReactorParts = [ore('blockGlass'), ore('blockGlass'), ore('blockGlass'), metaitem('pipeNormalFluidPlastic'), metaitem('pipeLargeFluidPlastic'),
                                metaitem('pipeHugeFluidPlastic'), metaitem('pipeNormalFluidPolytetrafluoroethylene'), metaitem('pipeLargeFluidPolytetrafluoroethylene'),
                                metaitem('pipeHugeFluidPolytetrafluoroethylene')]

    def tieredPipes = [metaitem('pipeLargeFluidSteel'), metaitem('pipeLargeFluidSteel'), metaitem('pipeLargeFluidAluminium'), metaitem('pipeLargeFluidStainlessSteel'),
                       metaitem('pipeLargeFluidTitanium'), metaitem('pipeLargeFluidTungstenSteel'), metaitem('pipeLargeFluidNiobiumTitanium'),
                       metaitem('pipeLargeFluidNaquadah'), metaitem('pipeLargeFluidDuranium')]

    def tieredMagnets = [metaitem('stickIronMagnetic'), metaitem('stickSteelMagnetic'), metaitem('stickSteelMagnetic'), metaitem('stickAlnicoMagnetic'),
                         metaitem('stickAlnicoMagnetic'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('stickSamariumAlloyMagnetic'),
                         metaitem('stickSamariumAlloyMagnetic'), metaitem('stickSamariumAlloyMagnetic')];

    def refractories = [item('gregtech:metal_casing', 1), item('gregtech:metal_casing', 1), item('susy:susy_multiblock_casing', 11), item('susy:susy_multiblock_casing', 11),
                        item('susy:susy_multiblock_casing', 9), item('susy:susy_multiblock_casing', 9), item('susy:susy_multiblock_casing', 9),
                        item('susy:susy_multiblock_casing', 9), item('susy:susy_multiblock_casing', 9)]
}
