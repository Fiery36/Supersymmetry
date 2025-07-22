package material;

import static material.SuSyMaterials.*;
import static globals.Globals.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.fluids.store.FluidStorage;
import gregtech.api.unification.material.properties.*
import gregtech.api.GTValues;
import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;
import static gregtech.api.fluids.FluidConstants.*;

import supercritical.api.unification.material.properties.FissionFuelProperty;
import supercritical.api.unification.material.properties.SCPropertyKey;

public class FirstDegreeMaterialsB {
    public static void register() {

        log.infoMC('Registering First Degree Materials B!');

        ThoriumNitrateSolution = new Material.Builder(8706, SuSyUtility.susyId('thorium_nitrate_solution'))
                .liquid()
                .components(Thorium, Nitrogen * 3, Oxygen * 9, Water)
                .color(0x001e13)
                .build();

        ThoriumNitrateSolution.setFormula("(Th(NO3)4)(H2O)", true)

        ThoriumDioxide = new Material.Builder(8707, SuSyUtility.susyId('thorium_dioxide'))
                .dust()
                .components(Thorium, Oxygen * 2)
                .color(0x00061e)
                .build();

        // ThoriumDioxide.setProperty(SCPropertyKey.FISSION_FUEL, new FissionFuelProperty(?, ?, ?, ?, ?, ?, ?, ThoriumDioxide.getRegistryName()));

        ThoriumChloride = new Material.Builder(8708, SuSyUtility.susyId('thorium_chloride'))
                .dust()
                .components(Thorium, Chlorine * 3)
                .color(0x012916)
                .build();

        Zircaloy4 = new Material.Builder(8710, SuSyUtility.susyId('zircaloy_4'))
                .ingot().liquid(new FluidBuilder().temperature(2200))
                .components(HighPurityZirconium * 18, Tin * 3, Iron * 2, Chrome)
                .color(0x566570)
                .iconSet(METALLIC)
                .flags(GENERATE_RING, GENERATE_RING, GENERATE_PLATE, GENERATE_FRAME, GENERATE_SPRING, GENERATE_BOLT_SCREW)
                .blastTemp(2200, GasTier.MID, GTValues.VA[GTValues.EV])
                .fluidPipeProperties(1500, 1500, true, true, true, false)
                .build()

        ReactorSteel = new Material.Builder(8711, SuSyUtility.susyId('reactor_steel'))
                .ingot().liquid(new FluidBuilder().temperature(1800))
                .iconSet(SHINY)
                .flags(GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_BOLT_SCREW)
                .components(Iron * 113, Manganese * 10, Molybdenum * 2, Nickel * 3)
                .colorAverage()
                .blastTemp(1800, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        Inconel718 = new Material.Builder(8712, SuSyUtility.susyId('inconel_718'))
                .ingot().liquid(new FluidBuilder().temperature(1800))
                .colorAverage()
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_DOUBLE_PLATE, GENERATE_FRAME, GENERATE_SPRING, SUPERALLOY)
                .components(Nickel * 41, Iron * 19, Chrome * 20, Niobium * 3, Molybdenum * 2, Titanium, Aluminium * 2)
                .blastTemp(1800, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        SilverIndiumCadmium = new Material.Builder(8713, SuSyUtility.susyId('silver_indium_cadmium'))
                .ingot().liquid(new FluidBuilder().temperature(1100))
                .components(Silver * 17, Indium * 3, Cadmium * 1)
                .colorAverage()
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .blastTemp(1100, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        MullitizedKyanite = new Material.Builder(8714, SuSyUtility.susyId('mullitized_kyanite'))
                .dust()
                .components(Aluminium * 2, Silicon * 1, Oxygen * 5)
                .color(0xb8cee0)
                .build();

        SodiumPhosphate = new Material.Builder(8715, SuSyUtility.susyId('sodium_phosphate'))
                .dust()
                .components(Sodium * 3, Phosphorus, Oxygen * 4)
                .color(0xdae69e)
                .build();

        AmmoniumAlum = new Material.Builder(8716, SuSyUtility.susyId('ammonium_alum'))
                .dust()
                .components(Aluminium * 1, Nitrogen * 1, Hydrogen * 4, Sulfur * 2, Oxygen * 8, Water * 12)
                .color(0x1673a6)
                .build(); 

        AmmoniumAlum.setFormula('(NH4)Al(SO4)2 * (H2O)12', true);
        
        PurifiedBerylliumHydroxide = new Material.Builder(8717, SuSyUtility.susyId('purified_beryllium_hydroxide')) 
                .dust()
                .iconSet(SHINY)
                .components(Beryllium, Oxygen * 2, Hydrogen * 2)
                .colorAverage()
                .build();
        
        PurifiedBerylliumHydroxide.setFormula("Be(OH)2", true);

        PurifiedBerylliumOxide = new Material.Builder(8718, SuSyUtility.susyId('purified_beryllium_oxide'))
                .dust()
                .iconSet(SHINY)
                .components(Beryllium, Oxygen)
                .colorAverage()
                .build();

        PurifiedBerylliumChloride = new Material.Builder(8719, SuSyUtility.susyId('purified_beryllium_chloride'))
                .dust().liquid(new FluidBuilder().temperature(672))
                .components(Beryllium, Chlorine * 2)
		.iconSet(SHINY)
                .colorAverage()
                .build();

        Alnico = new Material.Builder(8720, SuSyUtility.susyId('alnico'))
                .dust().ingot().liquid(new FluidBuilder().temperature(1800))
                .components(Aluminium * 5, Nickel * 4, Cobalt * 3, Copper, Iron * 11)
                .color(0xb2d8ed)
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE)
                .blastTemp(1800, GasTier.LOW, 480, 200)
                .build()

        AlnicoMagnetic = new Material.Builder(8721, SuSyUtility.susyId('alnico_magnetic'))
                .ingot()
                .iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, IS_MAGNETIC)
                .color(0xb2d8ed)
                .components(Alnico)
                .ingotSmeltInto(Alnico)
                .arcSmeltInto(Alnico)
                .macerateInto(Alnico)
                .build()

        ReprocessedUranylNitrate = new Material.Builder(8722, SuSyUtility.susyId('reprocessed_uranyl_nitrate'))
                .dust()
                .components(ReprocessedUranium, Nitrogen * 2, Oxygen * 8)
                .color(0xb7d629)
                .build()

        ReprocessedUranylNitrate.setFormula("UO2(NO3)2", true)

        FerrousSulfamate = new Material.Builder(8723, SuSyUtility.susyId('ferrous_sulfamate'))
                .dust()
                .components(Iron * 1, Nitrogen * 1, Sulfur * 1, Oxygen * 3, Hydrogen * 6)
                .color(0x4c5b4c)
                .build()
                
        FerrousSulfamate.setFormula("Fe(NH2SO3)2", true)

        ReprocessedUraniumTrioxide = new Material.Builder(8724, SuSyUtility.susyId('reprocessed_uranium_trioxide'))
                .dust()
                .components(ReprocessedUranium, Oxygen * 3)
                .color(0x8b8b00)
                .build();

        ReprocessedUraniumTrioxide.setFormula("UO3", true);

        ReactorGradePlutoniumIIINitrate = new Material.Builder(8725, SuSyUtility.susyId('reactor_grade_plutonium_iii_nitrate'))
                .dust()
                .components(ReactorGradePlutonium, Nitrogen * 3, Oxygen * 9)
                .color(0x8b0000)
                .build()

        ReactorGradePlutoniumIIINitrate.setFormula("Pu(NO3)3", true);

        ReactorGradePlutoniumDioxide = new Material.Builder(8726, SuSyUtility.susyId('reactor_grade_plutonium_dioxide'))
                .dust()
                .components(ReactorGradePlutonium, Oxygen * 2)
                .colorAverage()
                .build()
        
        ReactorGradePlutoniumDioxide.setFormula("PuO2", true)

        HydroxylammoniumNitrateSolution = new Material.Builder(8727, SuSyUtility.susyId('hydroxylammonium_nitrate_solution'))
                .liquid()
                .components(Hydroxylamine, Hydrogen, Nitrogen, Oxygen * 3, Water)
                .color(0x8b0000)
                .build();

        HydroxylammoniumNitrateSolution.setFormula("(N2H4O4)(H2O)", true);

        ReprocessedUraniumDioxide = new Material.Builder(8728, SuSyUtility.susyId('reprocessed_uranium_dioxide'))
                .dust()
                .iconSet(SAND)
                .components(ReprocessedUranium, Oxygen * 2)
                .color(0x4c6e5c)
                .build();

        ReprocessedUraniumDioxide.setFormula("UO2", true);

        ReprocessedUraniumTetrafluoride = new Material.Builder(8729, SuSyUtility.susyId('reprocessed_uranium_tetrafluoride'))
                .dust()
                .iconSet(SAND)
                .components(ReprocessedUranium, Fluorine * 4)
                .color(0x5d8570)
                .build();

        ReprocessedUraniumTetrafluoride.setFormula("UF4", true);

        ReprocessedUraniumHexafluoride = new Material.Builder(8730, SuSyUtility.susyId('reprocessed_uranium_hexafluoride'))
                .gas(new FluidBuilder().temperature(330))
                .components(ReprocessedUranium, Fluorine * 6)
                .color(0x49c930)
                .build();

        ReprocessedUraniumHexafluoride.setFormula("UF6", true);

        PlutoniumGallium = new Material.Builder(8731, SuSyUtility.susyId('plutonium_gallium'))
                .dust()
                .iconSet(METALLIC)
                .components(ReactorGradePlutonium * 29, Gallium)
                .colorAverage()
                .blastTemp(1100, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        MixedOxideFuel = new Material.Builder(8732, SuSyUtility.susyId('mixed_oxide_fuel'))
                .dust()
                .color(0x62C032).iconSet(METALLIC)
                .components(ReprocessedUraniumDioxide * 19, ReactorGradePlutoniumDioxide)
                .build();

        MixedOxideFuel.setFormula("(U,Pu)O2", true);

        MixedOxideFuel.setProperty(SCPropertyKey.FISSION_FUEL,
                FissionFuelProperty.builder(MixedOxideFuel.getRegistryName(), 1600, 60000, 1.5)
                        .fastNeutronCaptureCrossSection(0.5)
                        .fastNeutronFissionCrossSection(0.25)
                        .slowNeutronCaptureCrossSection(2.2)
                        .slowNeutronFissionCrossSection(2.2)
                        .requiredNeutrons(1)
                        .releasedNeutrons(2.60)
                        .releasedHeatEnergy(0.02)
                        .decayRate(0.1)
                        .build());

        DilutedAcetone = new Material.Builder(8733, SuSyUtility.susyId('diluted_acetone'))
                .liquid()
                .components(Acetone, Water)
                .colorAverage()
                .build();

        BariumNitrate = new Material.Builder(8734, SuSyUtility.susyId('barium_nitrate'))
                .dust()
                .components(Barium, Nitrogen * 2, Oxygen * 6)
                .colorAverage()
                .build();

        BariumNitrate.setFormula("Ba(NO3)2", true);

        DeuteriumTritiumMixture = new Material.Builder(8735, SuSyUtility.susyId('deuterium_tritium_mixture'))
                .gas()
                .components(Deuterium * 99, Tritium * 1)
                .colorAverage()
                .build();
    }
}