package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility;
import supersymmetry.api.unification.material.properties.SuSyPropertyKey;
import supersymmetry.api.unification.material.properties.FiberProperty;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;

public class UnknownCompositionMaterials {
 
    public static void register() {

        log.infoMC('Registering Unknown Composition Materials!');

        EarthGreenhouseGas = new Material.Builder(4000, SuSyUtility.susyId('greenhouse_gases'))
                .gas()
                .color(0x95cade)
                .build();

        Asphalt = new Material.Builder(4001, SuSyUtility.susyId('asphalt'))
                .dust()
                .color(0x000000)
                .build();

        BlackAsh = new Material.Builder(4002, SuSyUtility.susyId('black_ash'))
                .dust()
                .color(0x000000)
                .build();

        MolecularSieve = new Material.Builder(4003, SuSyUtility.susyId('molecular_sieve'))
                .dust()
                .iconSet(SHINY)
                .color(0x737373)
                .build();

        WetMolecularSieve = new Material.Builder(4004, SuSyUtility.susyId('wet_molecular_sieve'))
                .dust()
                .iconSet(SHINY)
                .color(0x5c5c5c)
                .build();

        ChloridedAlumina = new Material.Builder(4005, SuSyUtility.susyId('chlorided_alumina'))
                .dust()
                .color(0x86bf99)
                .flags(GENERATE_CATALYST_BED)
                .build();

        FlueGas = new Material.Builder(4006, SuSyUtility.susyId('flue_gas'))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x484a48)
                .build();

        ExhaustSteam = new Material.Builder(4007, SuSyUtility.susyId('exhaust_steam'))
                .gas(new FluidBuilder().temperature(400))
                .color(0xc4c4c4)
                .build();

        SmokeBombMix = new Material.Builder(4008, SuSyUtility.susyId('smoke_bomb_mix'))
                .gas()
                .color(0x515443)
                .build();

        SugaryWater = new Material.Builder(4009, SuSyUtility.susyId('sugary_water'))
                .liquid()
                .color(0x8fbf9b)
                .build();

        ClarifiedSugaryWater = new Material.Builder(4010, SuSyUtility.susyId('clarified_sugary_water'))
                .liquid()
                .color(0xa7d6b3)
                .build();

        Brine = new Material.Builder(4011, SuSyUtility.susyId('brine'))
                .liquid()
                .color(0xd1d08e)
                .build();

        ImpureSodiumAluminateSolution = new Material.Builder(4012, SuSyUtility.susyId('impure_sodium_aluminate_solution'))
                .liquid()
                .color(0x5b80ba)
                .build();

        RedMud = new Material.Builder(4013, SuSyUtility.susyId('red_mud'))
                .liquid()
                .color(0x913f2d)
                .build();

        ImpureSodaAshSolution = new Material.Builder(4014, SuSyUtility.susyId('impure_soda_ash_solution'))
                .liquid()
                .color(0x91919b)
                .build();

        ImpureSodiumHydroxideSolution = new Material.Builder(4015, SuSyUtility.susyId('impure_sodium_hydroxide_solution'))
                .liquid()
                .color(0x3a4991)
                .build();

        ConcentratedRedMud = new Material.Builder(4016, SuSyUtility.susyId('concentrated_red_mud'))
                .liquid()
                .color(0x824133)
                .build();

        AmmoniaReactionMix = new Material.Builder(4017, SuSyUtility.susyId('ammonia_reaction_mix'))
                .gas(new FluidBuilder().temperature(400))
                .color(0x38478a)
                .build();

        AmmoniaRichGas = new Material.Builder(4018, SuSyUtility.susyId('ammonia_rich_gas'))
                .gas(new FluidBuilder().temperature(400))
                .color(0x345691)
                .build();

        // FREE ID: 4019

        Mash = new Material.Builder(4020, SuSyUtility.susyId('mash'))
                .liquid()
                .color(0x9e8660)
                .build();

        WeedKiller = new Material.Builder(4021, SuSyUtility.susyId('weed_killer'))
                .liquid()
                .color(0xade677)
                .build();

        Pesticide = new Material.Builder(4022, SuSyUtility.susyId('pesticide'))
                .liquid()
                .color(0xc0c77d)
                .build();

        GrainSolution = new Material.Builder(4023, SuSyUtility.susyId('grain_solution'))
                .liquid()
                .color(0xc2cc9d)
                .build();

        YeastSolution = new Material.Builder(4024, SuSyUtility.susyId('yeast_solution'))
                .liquid()
                .color(0xe6e3aa)
                .build();

        ImpureEthanol = new Material.Builder(4025, SuSyUtility.susyId('impure_ethanol'))
                .liquid()
                .color(0xbf9c77)
                .build();

        BorateLiquor = new Material.Builder(4026, SuSyUtility.susyId('borate_liquor'))
                .liquid()
                .color(0xacbbac)
                .build();

        ImpureAcetaldehyde = new Material.Builder(4027, SuSyUtility.susyId('impure_acetaldehyde'))
                .liquid()
                .color(0x6e6e6e)
                .build();

        CativaCatalystPreparation = new Material.Builder(4028, SuSyUtility.susyId('cativa_catalyst_preparation'))
                .liquid()
                .color(0x9c8275)
                .build();

        CativaCatalystSolution = new Material.Builder(4029, SuSyUtility.susyId('cativa_catalyst_solution'))
                .liquid()
                .color(0x75665e)
                .build();

        AcidicCumene = new Material.Builder(4030, SuSyUtility.susyId('acidic_cumene'))
                .liquid()
                .color(0x571a0b)
                .build()

        RearrangedCumene = new Material.Builder(4031, SuSyUtility.susyId('rearranged_cumene'))
                .liquid()
                .color(0x4f2f27)
                .build();

        SulfatedMetalOxide = new Material.Builder(4032, SuSyUtility.susyId('sulfated_metal_oxide'))
                .dust()
                .color(0xc7f089)
                .flags(GENERATE_CATALYST_BED)
                .build();

        ImpureKaptonK = new Material.Builder(4033, SuSyUtility.susyId('impure_kapton_k'))
                .liquid()
                .color(0xe0b53f)
                .build();

        ImpureKaptonE = new Material.Builder(4034, SuSyUtility.susyId('impure_kapton_e'))
                .liquid()
                .color(0xcad96f)
                .build();

        KaptonEPreparation = new Material.Builder(4035, SuSyUtility.susyId('kapton_e_preparation'))
                .liquid()
                .color(0x899444)
                .build();

        ImpureDiiodobenzene = new Material.Builder(4036, SuSyUtility.susyId('impure_diiodobenzene'))
                .liquid()
                .color(0x736c63)
                .build();

        ImpureEthyleneOxide = new Material.Builder(4037, SuSyUtility.susyId('impure_ethylene_oxide'))
                .gas()
                .color(0x52755c)
                .build();

        AmocoProcessCatalyst = new Material.Builder(4038, SuSyUtility.susyId('amoco_process_catalyst'))
                .dust()
                .iconSet(SHINY)
                .color(0xdea68c)
                .build();

        GraniteTailings = new Material.Builder(4039, SuSyUtility.susyId('granite_tailings'))
                .dust()
                .color(0x302323)
                .build();

        LimestoneTailings = new Material.Builder(4040, SuSyUtility.susyId('limestone_tailings'))
                .dust()
                .color(0x68695d)
                .build();

        PegmatiteTailings = new Material.Builder(4041, SuSyUtility.susyId('pegmatite_tailings'))
                .dust()
                .color(0x1f1c1c)
                .build();

        UltramaficTailings = new Material.Builder(4042, SuSyUtility.susyId('ultramafic_tailings'))
                .dust()
                .color(0x141414)
                .build();

        Corundum = new Material.Builder(4043, SuSyUtility.susyId('corundum'))
                .dust()
                .iconSet(SHINY)
                .color(0x7a4261)
                .build();

        Tourmaline = new Material.Builder(4044, SuSyUtility.susyId('tourmaline'))
                .dust().gem()
                .iconSet(SHINY)
                .color(0x8c613f)
                .build();

        NonMarineEvaporite = new Material.Builder(4045, SuSyUtility.susyId('non_marine_evaporite'))
                .dust()
                .color(0x78756d)
                .build();

        HalideEvaporite = new Material.Builder(4046, SuSyUtility.susyId('halide_evaporite'))
                .dust()
                .color(0x99867c)
                .build();

        CarbonateEvaporite = new Material.Builder(4047, SuSyUtility.susyId('carbonate_evaporite'))
                .dust()
                .color(0xe3e3e3)
                .build();

        SulfateEvaporite = new Material.Builder(4048, SuSyUtility.susyId('sulfate_evaporite'))
                .dust()
                .color(0xc7c0b1)
                .build();

        Vinegar = new Material.Builder(4049, SuSyUtility.susyId('vinegar'))
                .liquid()
                .color(0xc3c4b3)
                .build();

        RawCellulose = new Material.Builder(4050, SuSyUtility.susyId('raw_cellulose'))
                .dust()
                .color(0x302b1a)
                .build();

        WhiteLiquor = new Material.Builder(4051, SuSyUtility.susyId('white_liquor'))
                .liquid()
                .color(0xd9d3c1)
                .build();

        BlackLiquor = new Material.Builder(4052, SuSyUtility.susyId('black_liquor'))
                .liquid()
                .color(0x2e2a1f)
                .build();

        ConcentratedBlackLiquor = new Material.Builder(4053, SuSyUtility.susyId('concentrated_black_liquor'))
                .liquid()
                .color(0x1f1d18)
                .build();

        GreenLiquor = new Material.Builder(4054, SuSyUtility.susyId('green_liquor'))
                .liquid()
                .color(0x2b4536)
                .build();

        AcidicCelluloseSolution = new Material.Builder(4055, SuSyUtility.susyId('acidic_cellulose_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xb7bd60)
                .build();

        Wastewater = new Material.Builder(4056, SuSyUtility.susyId('wastewater'))
                .liquid()
                .color(0x2d402f)
                .build();

        HeatedWastewater = new Material.Builder(4057, SuSyUtility.susyId('heated_wastewater'))
                .liquid(new FluidBuilder().temperature(340))
                .color(0x435e46)
                .build();

        FlocculatedWastewater = new Material.Builder(4058, SuSyUtility.susyId('flocculated_wastewater'))
                .liquid()
                .color(0x435e46)
                .build();

        FilteredWastewater = new Material.Builder(4059, SuSyUtility.susyId('filtered_wastewater'))
                .liquid()
                .color(0x457568)
                .build();

        WastewaterSludge = new Material.Builder(4060, SuSyUtility.susyId('wastewater_sludge'))
                .liquid()
                .color(0x2b1e1e)
                .build();

        CarburizedStainlessSteel = new Material.Builder(4061, SuSyUtility.susyId('carburized_stainless_steel'))
                .dust().liquid(new FluidBuilder().temperature(1500))
                .color(0x6b6552)
                .build()

        UnscrubbedWoodGas = new Material.Builder(4062, SuSyUtility.susyId('unscrubbed_wood_gas'))
                .gas()
                .color(0x85806f)
                .build();

        LightOil = new Material.Builder(4063, SuSyUtility.susyId('light_oil'))
                .liquid()
                .color(0x5e5e4d)
                .build();

        NaphthaleneOil = new Material.Builder(4065, SuSyUtility.susyId('naphthalene_oil'))
                .liquid()
                .color(0x2e2926)
                .build();

        AnthraceneOil = new Material.Builder(4066, SuSyUtility.susyId('anthracene_oil'))
                .liquid()
                .color(0x211f1e)
                .build();

        AlkalineNaphthaleneOil = new Material.Builder(4067, SuSyUtility.susyId('alkaline_naphthalene_oil'))
                .liquid()
                .color(0x403833)
                .build();

        PurifiedNaphthaleneOil = new Material.Builder(4068, SuSyUtility.susyId('purified_naphthalene_oil'))
                .liquid()
                .color(0x595542)
                .build();

        AcidicLightOil = new Material.Builder(4069, SuSyUtility.susyId('acidic_light_oil'))
                .liquid()
                .color(0x87816c)
                .build();

        CrudePyridiniumSulfate = new Material.Builder(4070, SuSyUtility.susyId('crude_pyridinium_sulfate'))
                .liquid()
                .color(0x48523b)
                .build();

        ImpurePyridine = new Material.Builder(4071, SuSyUtility.susyId('impure_pyridine'))
                .liquid()
                .color(0x233326)
                .build();

        AcidicAnthraceneOil = new Material.Builder(4072, SuSyUtility.susyId('acidic_anthracene_oil'))
                .liquid()
                .color(0x87816c)
                .build();

        AnthraceneExtract = new Material.Builder(4073, SuSyUtility.susyId('anthracene_extract'))
                .liquid()
                .color(0x211c1c)
                .build();

        CrudeQuinoliniumSulfate = new Material.Builder(4074, SuSyUtility.susyId('crude_quinolinium_sulfate'))
                .liquid()
                .color(0x1b1c0a)
                .build();

        ImpureQuinoline = new Material.Builder(4075, SuSyUtility.susyId('impure_quinoline'))
                .liquid()
                .color(0x222418)
                .build();

        ConcentratedBrine = new Material.Builder(4076, SuSyUtility.susyId('concentrated_brine'))
                .liquid()
                .color(0xa6a444)
                .build();

        BoronFreeBrine = new Material.Builder(4078, SuSyUtility.susyId('boron_free_brine'))
                .liquid()
                .color(0xa68a44)
                .build();

        LithiumFreeBrine = new Material.Builder(4079, SuSyUtility.susyId('lithium_free_brine'))
                .liquid()
                .color(0xa17a4c)
                .build();

        ChlorinatedBrine = new Material.Builder(4080, SuSyUtility.susyId('chlorinated_brine'))
                .liquid()
                .color(0xa3b560)
                .build();

        ImpureBromine = new Material.Builder(4081, SuSyUtility.susyId('impure_bromine'))
                .gas(new FluidBuilder().temperature(373))
                .color(0x572d2b)
                .build();

        ChilledLava = new Material.Builder(4082, SuSyUtility.susyId('chilled_lava'))
                .liquid(new FluidBuilder().temperature(400))
                .color(0x4d2d25)
                .build();

        ChilledFlueGas = new Material.Builder(4083, SuSyUtility.susyId('chilled_flue_gas'))
                .gas(new FluidBuilder().temperature(400))
                .color(0x171717)
                .build();

        WoodAsh = new Material.Builder(4084, SuSyUtility.susyId('wood_ash'))
                .dust()
                .color(0x242221)
                .build();

        VeryConcentratedBrine = new Material.Builder(4085, SuSyUtility.susyId('very_concentrated_brine'))
                .liquid()
                .color(0xb5b226)
                .build();

        LangbeiniteLeach = new Material.Builder(4086, SuSyUtility.susyId('langbeinite_leach'))
                .liquid()
                .color(0x9c9a87)
                .build();

        PolyhaliteLeach = new Material.Builder(4087, SuSyUtility.susyId('polyhalite_leach'))
                .liquid()
                .color(0xb3a094)
                .build();

        TinDross = new Material.Builder(4088, SuSyUtility.susyId('tin_dross'))
                .dust().liquid(new FluidBuilder().temperature(600))
                .color(0x2a2e2e)
                .build();

        DecopperizedTin = new Material.Builder(4089, SuSyUtility.susyId('decopperized_tin'))
                .dust().liquid(new FluidBuilder().temperature(600))
                .color(0xb5b7c9)
                .build();

        KainiteLeach = new Material.Builder(4090, SuSyUtility.susyId('kainite_leach'))
                .liquid()
                .color(0xadb07f)
                .build();

        TypeXZeolite = new Material.Builder(4091, SuSyUtility.susyId('type_x_zeolite'))
                .dust()
                .iconSet(SHINY)
                .color(0xe4e8bc)
                .build();

        TypeXZeoliteSolution = new Material.Builder(4092, SuSyUtility.susyId('type_x_zeolite_solution'))
                .liquid()
                .color(0xe4e8bc)
                .build();

        LTSCatalyst = new Material.Builder(4093, SuSyUtility.susyId('lts_catalyst'))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x756857)
                .build();

        HTSCatalyst = new Material.Builder(4094, SuSyUtility.susyId('hts_catalyst'))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x5e4f4f)
                .build();

        SpentBismuthCatalyst = new Material.Builder(4095, SuSyUtility.susyId('spent_bismuth_catalyst'))
                .dust()
                .color(0x31403f)
                .build();

        AlkalineSodiumOleateSolution = new Material.Builder(4096, SuSyUtility.susyId('alkaline_sodium_oleate_solution'))
                .liquid()
                .color(0xa6b584)
                .build();

        FattyAcidSolution = new Material.Builder(4097, SuSyUtility.susyId('fatty_acid_solution'))
                .liquid()
                .color(0xa1ad5c)
                .build();

        OleicAcidSolution = new Material.Builder(4098, SuSyUtility.susyId('oleic_acid_solution'))
                .liquid()
                .color(0x8dbf67)
                .build();

        AluminiumSilicateLeach = new Material.Builder(4099, SuSyUtility.susyId('aluminium_silicate_leach'))
                .liquid()
                .color(0x587682)
                .build();

        AlkaliAlumMix = new Material.Builder(4100, SuSyUtility.susyId('alkali_alum_mix'))
                .iconSet(SHINY)
                .dust()
                .color(0xe34949)
                .build();

        AmblygoniteLeach = new Material.Builder(4101, SuSyUtility.susyId('amblygonite_leach'))
                .liquid()
                .color(0xbaced6)
                .build();

        SolidPhosphoricAcid = new Material.Builder(4102, SuSyUtility.susyId('solid_phosphoric_acid'))
                .dust()
                .iconSet(DULL)
                .color(0xd7de9e)
                .flags(GENERATE_WET_DUST, GENERATE_CATALYST_BED)
                .build();

        LepidoliteLeach = new Material.Builder(4103, SuSyUtility.susyId('lepidolite_leach'))
                .liquid()
                .color(0x805066)
                .build();

        NeutralizedLepidoliteLeach = new Material.Builder(4104, SuSyUtility.susyId('neutralized_lepidolite_leach'))
                .liquid()
                .color(0x675d85)
                .build();

        AluminiumFreeLepidoliteLeach = new Material.Builder(4105, SuSyUtility.susyId('aluminium_free_lepidolite_leach'))
                .liquid()
                .color(0x557365)
                .build();

        GoldLeachSolution = new Material.Builder(4106, SuSyUtility.susyId('gold_leach_solution'))
                .liquid()
                .color(0x9c8a46)
                .build();

        PhosphatePulp = new Material.Builder(4107, SuSyUtility.susyId('phosphate_pulp'))
                .dust()
                .color(0x8c7e2a)
                .iconSet(SAND)
                .build();

        FilteredPhosphatePulp = new Material.Builder(4108, SuSyUtility.susyId('filtered_phosphate_pulp'))
                .dust()
                .color(0x8c7e2a)
                .iconSet(SHINY)
                .build();

        PhosphateConcentrate = new Material.Builder(4109, SuSyUtility.susyId('phosphate_concentrate'))
                .dust()
                .color(0xd1b615)
                .iconSet(SHINY)
                .build();

        PropanalMixture = new Material.Builder(4110, SuSyUtility.susyId('propanal_mixture'))
                .liquid()
                .color(0x84910f)
                .build();
      
        ImpureAmmoniumFluoroberyllateSolution = new Material.Builder(4111, SuSyUtility.susyId('ammonium_fluoroberyllate_solution'))
                .liquid()
                .color(0x1b8541)
                .build();

        ImpureAmmoniumFluoroberyllateSolution.setFormula('(?)(NH4)2(BeF4)(H2O)3', true)

        ImpureBerylliumSulfateSolution = new Material.Builder(4112, SuSyUtility.susyId('impure_beryllium_sulfate_solution'))
                .liquid()
                .color(0x608726)
                .build();

        ImpureLithiumSulfateSolution = new Material.Builder(4113, SuSyUtility.susyId('impure_lithium_sulfate_solution'))
                .liquid()
                .color(0xf0bc89)
                .build();

        GalenaByproductsSlurry = new Material.Builder(4114, SuSyUtility.susyId('galena_byproducts_slurry'))
                .liquid()
                .color(0x592880)
                .build();

        SinteredLeadConcentrate = new Material.Builder(4115, SuSyUtility.susyId('sintered_lead_concentrate'))
                .dust()
                .color(0x3a1954)
                .iconSet(SAND)
                .build();

        ZincOxideFume = new Material.Builder(4116, SuSyUtility.susyId('zinc_oxide_fume'))
                .dust()
                .color(0x757061)
                .iconSet(DULL)
                .build();

        BlackMetal = new Material.Builder(4117, SuSyUtility.susyId('black_metal'))
                .dust()
                .color(0x3d3440)
                .build();

        AntimonyArsenicFlueDust = new Material.Builder(4118, SuSyUtility.susyId('antimony_arsenic_flue_dust'))
                .dust()
                .color(0x707063)
                .iconSet(DULL)
                .build();

        BurnedBlackMetal = new Material.Builder(4119, SuSyUtility.susyId('burned_black_metal'))
                .dust()
                .color(0x3d3440)
                .iconSet(DULL)
                .build();

        LithargeSlag = new Material.Builder(4120, SuSyUtility.susyId('litharge_slag'))
                .dust()
                .color(0xb5443c)
                .iconSet(DULL)
                .build();

        HarrisSlag = new Material.Builder(4121, SuSyUtility.susyId('harris_slag'))
                .dust()
                .color(0xabb074)
                .iconSet(DULL)
                .build();

        SodiumArsenateStannateSolution = new Material.Builder(4122, SuSyUtility.susyId('sodium_arsenate_stannate_solution'))
                .liquid()
                .color(0x5c3a23)
                .build();
        
        SodiumArsenateStannateMixture = new Material.Builder(4123, SuSyUtility.susyId('sodium_arsenate_stannate_mixture'))
                .dust()
                .color(0x784c2f)
                .build();

        ImpureEthyleneGlycol = new Material.Builder(4124, SuSyUtility.susyId('impure_ethylene_glycol'))
                .liquid()
                .color(0xc8c8e0)
                .build();

        ImpureSaturatedAmmoniacalMethanol = new Material.Builder(4125, SuSyUtility.susyId('impure_saturated_ammoniacal_methanol'))
                .liquid()
                .color(0xad8653)
                .build();

        CarnalliteLeach = new Material.Builder(4126, SuSyUtility.susyId('carnallite_leach'))
                .liquid()
                .color(0xc1c499)
                .build();

        HaliteLeach = new Material.Builder(4127, SuSyUtility.susyId('halite_leach'))
                .liquid()
                .color(0x9bbdbc)
                .build();

        EthylenediaminePyrocatechol = new Material.Builder(4128, SuSyUtility.susyId('ethylenediamine_pyrocatechol'))
                .liquid()
                .color(0x42392f)
                .build();

        CeramicThickFilmPaste = new Material.Builder(4129, SuSyUtility.susyId('ceramic_thick_film_paste'))
                .liquid()
                .color(0x000000)
                .build();

        BoraxElectrolyte = new Material.Builder(4130, SuSyUtility.susyId('borax_electrolyte'))
                .liquid()
                .color(0x85806b)
                .build();

        FerroelectricCeramicBinding = new Material.Builder(4131, SuSyUtility.susyId('ferroelectric_ceramic_binding'))
                .liquid()
                .color(0xede772)
                .build();

        DisproportionatedTrichlorosilane = new Material.Builder(4132, SuSyUtility.susyId('disproportionated_trichlorosilane'))
                .liquid()
                .color(0x849169)
                .build()

        DisproportionatedDichlorosilane = new Material.Builder(4133, SuSyUtility.susyId('disproportionated_dichlorosilane'))
                .liquid()
                .color(0xa1ad86)
                .build()

        DisproportionatedChlorosilane = new Material.Builder(4134, SuSyUtility.susyId('disproportionated_chlorosilane'))
                .liquid()
                .color(0xb5bf9b)
                .build()
      
        ChlorofluoromethaneMix = new Material.Builder(4135, SuSyUtility.susyId('chlorofluoromethane_mix'))
                .liquid()
                .color(0xb03f5d)
                .build();

        CoconutOil = new Material.Builder(4136, SuSyUtility.susyId('coconut_oil'))
                .liquid()
                .color(0xd6d39a)
                .build();
                
        CoconutAcid = new Material.Builder(4137, SuSyUtility.susyId('coconut_acid'))
                .liquid()
                .color(0xbdb280)
                .build();
                
        TwoEthylhexylPhosphoricAcidMix = new Material.Builder(4138, SuSyUtility.susyId('two_ethylhexyl_phosphoric_acid_mix'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xd1bb75)
                .build();

        RareEarthCatalystYNd = new Material.Builder(4139, SuSyUtility.susyId('rare_earth_catalyst_y_nd'))
                .dust()
                .color(0x2e2a2a)
                .build();

        DilutedPrimaryAmineN = new Material.Builder(4140, SuSyUtility.susyId('diluted_primary_amine_n'))
                .liquid()
                .color(0x704a9e)
                .build();

        CrosslinkedPolystyrene = new Material.Builder(4141, SuSyUtility.susyId('crosslinked_polystyrene'))
                .ingot().liquid(new FluidBuilder().temperature(513))
                .flags(GENERATE_ROUND)
                .color(0xa7a9d6)
                .build();

        EthyleneGlycolMix = new Material.Builder(4142, SuSyUtility.susyId('ethylene_glycol_mix'))
                .liquid()
                .color(0x2eafc9)
                .build();

        PalladiumDopedCrosslinkedPolystyrene = new Material.Builder(4143, SuSyUtility.susyId('palladium_doped_crosslinked_polystyrene'))
                .ingot().liquid(new FluidBuilder().temperature(513))
                .flags(GENERATE_ROUND)
                .color(0xe0e6bc)
                .build();

        AlfolTrialkylaluminiumMixture = new Material.Builder(4144, SuSyUtility.susyId('alfol_trialkylaluminium_mixture'))
                .liquid()
                .color(0x6b777d)
                .build()

        AlfolTrialkylaluminiumMixture.setFormula('AlR3', true)

        AluminiumAlkoxideMixture = new Material.Builder(4145, SuSyUtility.susyId('aluminium_alkoxide_mixture'))
                .dust()
                .color(0x657780)
                .build()

        AluminiumAlkoxideMixture.setFormula('Al(OR)3', true)

        ZieglerAlfolMixture = new Material.Builder(4146, SuSyUtility.susyId('ziegler_alfol_mixture'))
                .liquid()
                .color(0xc47631)
                .build()

        AluminiumAlkoxideSolution = new Material.Builder(4148, SuSyUtility.susyId('aluminium_alkoxide_solution'))
                .liquid()
                .color(0x657780)
                .build()

        AluminiumAlkoxideSolution.setFormula('[(C2H5)2O]Al(OR)3', true)

        CapsaicinSolution = new Material.Builder(4149, SuSyUtility.susyId('capsaicin_solution'))
                .liquid()
                .color(0xd43b2a)
                .build()

        TearGas = new Material.Builder(4150, SuSyUtility.susyId('tear_gas'))
                .liquid()
                .color(0xd1ba5c)
                .build()

        HydratedPropene = new Material.Builder(4151, SuSyUtility.susyId('hydrated_propene'))
                .liquid()
                .color(0xc9997d)
                .build()

        EthylamineMix = new Material.Builder(4152, SuSyUtility.susyId('ethylamine_mix'))
                .liquid()
                .color(0xdbaf48)
                .build()

        GermaniumRichOxide = new Material.Builder(4153, SuSyUtility.susyId('germanium_rich_oxide'))
                .dust()
                .color(0x7b9a9e)
                .build()

        UnprocessedSphaleriteSlurry = new Material.Builder(4154, SuSyUtility.susyId('unprocessed_sphalerite_slurry'))
                .liquid()
                .color(0xc7c991)
                .build()

        CocoAmine = new Material.Builder(4155, SuSyUtility.susyId('coco_amine'))
                .liquid()
                .color(0xb4d487)
                .build()

        CocoAmineAcetate = new Material.Builder(4156, SuSyUtility.susyId('coco_amine_acetate'))
                .liquid()
                .color(0xada67b)
                .build()
                
        ZincFlue = new Material.Builder(4157, SuSyUtility.susyId('zinc_flue'))
                .dust()
                .color(0x26222e)
                .build()

        CrudeZinc = new Material.Builder(4158, SuSyUtility.susyId('crude_zinc'))
                .liquid()
                .color(0x565863)
                .build()

        CadmiumRichZinc = new Material.Builder(4159, SuSyUtility.susyId('cadmium_rich_zinc'))
                .liquid()
                .color(0x80849c)
                .build()

        AmorphousSilicaAlumina = new Material.Builder(4160, SuSyUtility.susyId('amorphous_silica_alumina'))
                .dust()
                .color(0x7ea3ed)
                .iconSet(DULL)
                .build()

        ImpureUranylSulfateSolution = new Material.Builder(4161, SuSyUtility.susyId('impure_uranyl_sulfate_solution'))
                .liquid()
                .color(0x9c8f30)
                .build();

        ZincLeach = new Material.Builder(4162, SuSyUtility.susyId('zinc_leach'))
                .liquid()
                .color(0x8c6f58)
                .build()

        ZincLeachResidue = new Material.Builder(4163, SuSyUtility.susyId('zinc_leach_residue'))
                .dust()
                .color(0x33281f)
                .build()

        HotZincLeach = new Material.Builder(4164, SuSyUtility.susyId('hot_zinc_leach'))
                .liquid(new FluidBuilder().temperature(353))
                .color(0xb89e8a)
                .build()

        LeadSilicaResidue = new Material.Builder(4165, SuSyUtility.susyId('lead_silica_residue'))
                .dust()
                .color(0x3b332d)
                .build()

        WaelzSlag = new Material.Builder(4166, SuSyUtility.susyId('waelz_slag'))
                .dust()
                .color(0x242323)
                .build()

        ReducedZincLeach = new Material.Builder(4167, SuSyUtility.susyId('reduced_zinc_leach'))
                .liquid()
                .color(0xb38764)
                .build()

        WaelzOxide = new Material.Builder(4168, SuSyUtility.susyId('waelz_oxide'))
                .dust()
                .color(0x475453)
                .build()

        CarbonBlack = new Material.Builder(4169, SuSyUtility.susyId('carbon_black'))
                .dust()
                .color(0x140f02)
                .build()

        ZincCementationSlurry = new Material.Builder(4170, SuSyUtility.susyId('zinc_cementation_slurry'))
                .liquid()
                .color(0x4f5663)
                .build()

        PrecipitatedZincLeach = new Material.Builder(4171, SuSyUtility.susyId('precipitated_zinc_leach'))
                .liquid()
                .color(0x756d54)
                .build()

        CopperCadmiumResidue = new Material.Builder(4172, SuSyUtility.susyId('copper_cadmium_residue'))
                .dust()
                .color(0x47271d)
                .build()

        HotPrecipitatedZincLeach = new Material.Builder(4173, SuSyUtility.susyId('hot_precipitated_zinc_leach'))
                .liquid(new FluidBuilder().temperature(353))
                .color(0x918a71)
                .build()

        ReprecipitatedZincLeach = new Material.Builder(4174, SuSyUtility.susyId('reprecipitated_zinc_leach'))
                .liquid()
                .color(0x756e54)
                .build()

        CobaltResidue = new Material.Builder(4175, SuSyUtility.susyId('cobalt_residue'))
                .dust()
                .color(0x373b6b)
                .build()
      
        FuselOil = new Material.Builder(4176, SuSyUtility.susyId('fusel_oil'))
                .liquid()
                .color(0xa62403)
                .build()

        AshSlurry = new Material.Builder(4177, SuSyUtility.susyId('ash_slurry'))
                .liquid()
                .color(0x252526)
                .build()

        DesulfurizedFlueGas = new Material.Builder(4178, SuSyUtility.susyId('desulfurized_flue_gas'))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x151521)
                .build()

        ZincOxideFumeGas = new Material.Builder(4179, SuSyUtility.susyId('zinc_oxide_fume_gas'))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x757061)
                .build();

        AntimonyArsenicFlueGas = new Material.Builder(4180, SuSyUtility.susyId('antimony_arsenic_flue_gas'))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x707063)
                .build();

        ZincFlueGas = new Material.Builder(4181, SuSyUtility.susyId('zinc_flue_gas'))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x26222e)
                .build()

        FluorinatedOctanoylChlorideMixture = new Material.Builder(4182, SuSyUtility.susyId('fluorinated_octanoyl_chloride_mixture'))
                .liquid()
                .color(0x458583)
                .build()

        ButyraldehydeMixture = new Material.Builder(4183, SuSyUtility.susyId('butyraldehyde_mixture'))
                .liquid()
                .color(0x96920e)
                .build();

        PentanalMixture = new Material.Builder(4184, SuSyUtility.susyId('pentanal_mixture'))
                .liquid()
                .color(0x968450)
                .build();

        SaltRoastedVanadinite = new Material.Builder(4185, SuSyUtility.susyId('salt_roasted_vanadinite'))
                .dust()
                .color(0x2e2b28)
                .build();

        SodaAshRoastedVanadinite = new Material.Builder(4186, SuSyUtility.susyId('soda_ash_roasted_vanadinite'))
                .dust()
                .color(0x38342f)
                .build();

        LeachedSaltRoastedVanadinite = new Material.Builder(4187, SuSyUtility.susyId('leached_salt_roasted_vanadinite'))
                .dust()
                .color(0x403c37)
                .build();

        LeachedSodaAshRoastedVanadinite = new Material.Builder(4188, SuSyUtility.susyId('leached_soda_ash_roasted_vanadinite'))
                .dust()
                .color(0x4d463f)
                .build();

        DissolvedFerrochromium = new Material.Builder(4189, SuSyUtility.susyId('dissolved_ferrochromium'))
                .liquid()
                .color(0xd17979)
                .build();

        CrudeAmmoniumIronIISulfate = new Material.Builder(4190, SuSyUtility.susyId('crude_ammonium_iron_ii_sulfate'))
                .dust()
                .color(0x96cf70)
                .build();

        MohrMotherLiquor = new Material.Builder(4191, SuSyUtility.susyId('mohr_mother_liquor'))
                .liquid()
                .color(0x43a375)
                .build();

        CrudeAmmoniumIronIISulfateSolution = new Material.Builder(4192, SuSyUtility.susyId('crude_ammonium_iron_ii_sulfate_solution'))
                .liquid(new FluidBuilder().temperature(343))
                .color(0x96cf70)
                .build();

        ChromiumAnolyte = new Material.Builder(4193, SuSyUtility.susyId('chromium_anolyte'))
                .liquid()
                .color(0xd97777)
                .build();

        ChromiumCatholyte = new Material.Builder(4194, SuSyUtility.susyId('chromium_catholyte'))
                .liquid()
                .color(0xc45e4f)
                .build();

        ChromiumMotherLiquor = new Material.Builder(4195, SuSyUtility.susyId('chromium_mother_liquor'))
                .liquid()
                .color(0xeb94d1)
                .build();

        ReducedChromiumAnolyte = new Material.Builder(4196, SuSyUtility.susyId('reduced_chromium_anolyte'))
                .liquid()
                .color(0xd9b077)
                .build();
      
        Sienna = new Material.Builder(4197, SuSyUtility.susyId('sienna'))
                .dust()
                .color(0x4a3724)
                .build();

        BurntSienna = new Material.Builder(4198, SuSyUtility.susyId('burnt_sienna'))
                .dust()
                .color(0x662e2e)
                .build();

        CresolNovolacsOligomer = new Material.Builder(4199, SuSyUtility.susyId('cresol_novolacs_oligomer'))
                .liquid(new FluidBuilder().temperature(488))
                .color(0x9c745c)
                .build();

        EpoxyCresolNovolacs = new Material.Builder(4200, SuSyUtility.susyId('epoxy_cresol_novolacs'))
                .polymer()
                .color(0xe8cda5)
                .flags(GENERATE_WET_DUST, GENERATE_PLATE, GENERATE_FOIL)
                .build();

        SiliconDioxideSlurry = new Material.Builder(4201, SuSyUtility.susyId('silicon_dioxide_slurry'))
                .liquid()
                .color(0x69675b)
                .build();

        OrthoCresylicAcidMixture = new Material.Builder(4202, SuSyUtility.susyId('ortho_cresylic_acid_mixture'))
                .liquid()
                .color(0xb5a991)
                .build();

        VTSlag = new Material.Builder(4203, SuSyUtility.susyId('vt_slag'))
                .dust()
                .color(0x302222)
                .build();

        AlkaliVTSlag = new Material.Builder(4204, SuSyUtility.susyId('alkali_vt_slag'))
                .dust()
                .color(0x3b2531)
                .build();

        TitaniaSlag = new Material.Builder(4205, SuSyUtility.susyId('titania_slag'))
                .dust()
                .color(0x4f2b3f)
                .build();

        RutileSlurry = new Material.Builder(4207, SuSyUtility.susyId('rutile_slurry'))
                .liquid()
                .color(0x575544)
                .build();

        CarnotiteLeach = new Material.Builder(4208, SuSyUtility.susyId('carnotite_leach'))
                .liquid()
                .color(0x929c5c)
                .build();

        ReducedCarnotiteLeach = new Material.Builder(4209, SuSyUtility.susyId('reduced_carnotite_leach'))
                .liquid()
                .color(0x696840)
                .build();

        UraniumExtractionMixture = new Material.Builder(4210, SuSyUtility.susyId('uranium_extraction_mixture'))
                .liquid()
                .color(0xd4d03f)
                .build();

        UraniumVanadiumExtract = new Material.Builder(4211, SuSyUtility.susyId('uranium_vanadium_extract'))
                .liquid()
                .color(0x505e3a)
                .build();

        UraniumExtract = new Material.Builder(4212, SuSyUtility.susyId('uranium_extract'))
                .liquid()
                .color(0x4a6e3b)
                .build();

        AcidicVanadylSolution = new Material.Builder(4213, SuSyUtility.susyId('acidic_vanadyl_solution'))
                .liquid()
                .color(0x804221)
                .build();

        ImpureUranylCarbonateSolution = new Material.Builder(4214, SuSyUtility.susyId('impure_uranyl_carbonate_solution'))
                .liquid()
                .color(0x9cad37)
                .build();

        UranylCarbonateSolution = new Material.Builder(4215, SuSyUtility.susyId('uranyl_carbonate_solution'))
                .liquid()
                .color(0xbed14d)
                .build();

        UranylSulfateSolution = new Material.Builder(4216, SuSyUtility.susyId('uranyl_sulfate_solution'))
                .liquid()
                .color(0xb5a638)
                .build();

        TetraethylleadSludge = new Material.Builder(4217, SuSyUtility.susyId('tetraethyllead_sludge'))
                .liquid()
                .color(0x2b1e1e)
                .build();

        Oxygenates = new Material.Builder(4218, SuSyUtility.susyId('oxygenates'))
                .liquid()
                .color(0xb4c5e0)
                .build();

        Antioxidants = new Material.Builder(4219, SuSyUtility.susyId('antioxidants'))
                .liquid()
                .color(0x380b0d)
                .build();

        Antiknock = new Material.Builder(4220, SuSyUtility.susyId('antiknock'))
                .liquid()
                .color(0x48485e)
                .build();

        HydrotreatingCatalyst = new Material.Builder(4221, SuSyUtility.susyId('hydrotreating_catalyst'))
                .dust()
                .color(0xb5dea4)
                .flags(GENERATE_CATALYST_BED)
                .build();

        MidgradeGasoline = new Material.Builder(4222, SuSyUtility.susyId('midgrade_gasoline'))
                .liquid()
                .color(0xc49735)
                .flags(FLAMMABLE)
                .build();

        PremiumGasoline = new Material.Builder(4223, SuSyUtility.susyId('premium_gasoline'))
                .liquid()
                .color(0xdb8427)
                .flags(FLAMMABLE)
                .build();

        SupremeGasoline = new Material.Builder(4224, SuSyUtility.susyId('supreme_gasoline'))
                .liquid()
                .color(0xf26d1b)
                .flags(FLAMMABLE)
                .build();

        LtftCatalystSolution = new Material.Builder(4225, SuSyUtility.susyId('ltft_catalyst_solution'))
                .liquid()
                .color(0x4f3030)
                .build();

        LtftCatalyst = new Material.Builder(4226, SuSyUtility.susyId('ltft_catalyst'))
                .dust()
                .color(0x4f3030)
                .build();

        HtftCatalyst = new Material.Builder(4227, SuSyUtility.susyId('htft_catalyst'))
                .dust()
                .color(0x7d2727)
                .build();

        CrudeCarnotiteLeach = new Material.Builder(4228, SuSyUtility.susyId('crude_carnotite_leach'))
                .liquid()
                .color(0x697043)
                .build();

        CrudePitchblendeLeach = new Material.Builder(4229, SuSyUtility.susyId('crude_pitchblende_leach'))
                .liquid()
                .color(0x1d1f15)
                .build();

        PitchblendeLeach = new Material.Builder(4230, SuSyUtility.susyId('pitchblende_leach'))
                .liquid()
                .color(0x2a2e1c)
                .build();

        //FREE ID: 4231

        TitanylSulfateSolution = new Material.Builder(4232, SuSyUtility.susyId('titanyl_sulfate_solution'))
                .liquid()
                .color(0x74561d)
                .build();

        TitanylSulfateSolution.setFormula('(H2O)(TiO[SO4])(?)', true);

        AcidicWastewater = new Material.Builder(4233, SuSyUtility.susyId('acidic_wastewater'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xc88a41)
                .build();

        AcidicWastewater.setFormula('(H2O)(?)', true);

        CarbonatedMolecularSieve = new Material.Builder(4234, SuSyUtility.susyId('carbonated_molecular_sieve'))
                .dust()
                .color(0x737373)
                .iconSet(DULL)
                .build();
      
        PotashConcentrate = new Material.Builder(4235, SuSyUtility.susyId('potash_concentrate'))
                .dust()
                .color(0xb39a9a)
                .build();

        ImpurePotashSlurry = new Material.Builder(4236, SuSyUtility.susyId('impure_potash_slurry'))
                .liquid()
                .color(0xb39a9a)
                .build();

        PotashSlurry = new Material.Builder(4237, SuSyUtility.susyId('potash_slurry'))
                .liquid()
                .color(0xd4b2b2)
                .build();

        SupersaturatedBrine = new Material.Builder(4238, SuSyUtility.susyId('supersaturated_brine'))
                .liquid()
                .color(0xdbb56e)
                .build();
        
        OligomericBisphenolSolution = new Material.Builder(4239, SuSyUtility.susyId('oligomeric_bisphenol_solution'))
                .liquid()
                .color(0xcfa532)
                .build();

        NetherMolecularSieve = new Material.Builder(4240, SuSyUtility.susyId('nether_molecular_sieve'))
                .dust()
                .color(0x6e6565)
                .iconSet(DULL)
                .build();

        //FREE ID: 4241

        GraniteTailingSlurry = new Material.Builder(4242, SuSyUtility.susyId('granite_tailing_slurry'))
                .liquid()
                .color(0xc48072)
                .build();

        HydratedTriethyleneGlycol = new Material.Builder(4243, SuSyUtility.susyId('hydrated_triethylene_glycol'))
                .liquid()
                .color(0x2795a8)
                .build()

        SphaleriteByproductSlurry = new Material.Builder(4244, SuSyUtility.susyId('sphalerite_byproduct_slurry'))
                .liquid()
                .color(0x9f97a1)
                .build();

        //FREE IDs: 4245-4250
                
        PegmatiteTailingSlurry = new Material.Builder(4251, SuSyUtility.susyId('pegmatite_tailing_slurry'))
                .liquid()
                .color(0x2c4a2d)
                .build();

        FilteredPhosphateSlurry = new Material.Builder(4252, SuSyUtility.susyId('filtered_phosphate_slurry'))
                .liquid()
                .color(0x918e27)
                .build();

        PhosphateConcentrateSlurry = new Material.Builder(4253, SuSyUtility.susyId('phosphate_concentrate_slurry'))
                .liquid()
                .color(0xadaa32)
                .build();

        //FREE IDs: 4254-4255

        LimestoneTailingSlurry = new Material.Builder(4256, SuSyUtility.susyId('limestone_tailing_slurry'))
                .liquid()
                .color(0x68695d)
                .build();

        //FREE IDs: 4257-4258

        ImpureChalcopyriteSlurry = new Material.Builder(4259, SuSyUtility.susyId('impure_chalcopyrite_slurry'))
                .liquid()
                .color(0x856119)
                .build();

        CopperMatteFlueDust = new Material.Builder(4260, SuSyUtility.susyId('copper_matte_flue'))
                .dust()
                .color(0x3e146e)
                .iconSet(DULL)
                .build();

        ImpureBorniteSlurry = new Material.Builder(4261, SuSyUtility.susyId('impure_bornite_slurry'))
                .liquid()
                .color(0x7d511d)
                .build();

        CopperMatteFlueGas = new Material.Builder(4262, SuSyUtility.susyId('copper_matte_flue_gas'))
                .liquid()
                .color(0x3e146e)
                .build();

        ImpureChalcociteSlurry = new Material.Builder(4263, SuSyUtility.susyId('impure_chalcocite_slurry'))
                .liquid()
                .color(0x262424)
                .build();

        ZSMFive = new Material.Builder(4264, SuSyUtility.susyId('zsm_five'))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x739133)
                .build();

        MalachiteLeach = new Material.Builder(4265, SuSyUtility.susyId('malachite_leach'))
                .liquid()
                .color(0x0f6880)
                .build();

        OxidizedMalachiteLeach = new Material.Builder(4266, SuSyUtility.susyId('oxidized_malachite_leach'))
                .liquid()
                .color(0x1a728a)
                .build();

        PyriteSlurry = new Material.Builder(4267, SuSyUtility.susyId('pyrite_slurry'))
                .liquid()
                .color(0x967828)
                .build();

        CopperConcentrateSlurry = new Material.Builder(4268, SuSyUtility.susyId('copper_concentrate_slurry'))
                .liquid()
                .color(0xff6400)
                .build();

        CopperConcentrate = new Material.Builder(4269, SuSyUtility.susyId('copper_concentrate'))
                .dust()
                .color(0xff6400)
                .iconSet(SAND)
                .build();

        CopperMatte = new Material.Builder(4270, SuSyUtility.susyId('copper_matte'))
                .dust()
                .color(0x5c3d08)
                .build();

        BlisterCopper = new Material.Builder(4271, SuSyUtility.susyId('blister_copper'))
                .ingot()
                .flags(GENERATE_PLATE)
                .color(0x6e4c14)
                .iconSet(SHINY)
                .build();

        //FREE IDs: 4272-4275

        CalcinedScheelite = new Material.Builder(4276, SuSyUtility.susyId('calcined_scheelite'))
                .dust()
                .color(0xc88c14)
                .iconSet(FLINT)
                .build();

        //FREE IDs: 4277-4280

        SilicateFreeTungstateSolution = new Material.Builder(4281, SuSyUtility.susyId('silicate_free_tungstate_solution'))
                .liquid()
                .color(0x2c8576)
                .build();

        MolybdenumFreeTungstateSolution = new Material.Builder(4282, SuSyUtility.susyId('molybdenum_free_tungstate_solution'))
                .liquid()
                .color(0x25889c)
                .build();

        IsodecanalMixture = new Material.Builder(4283, SuSyUtility.susyId('isodecanal_mixture'))
                .liquid()
                .color(0xadad45)
                .build();

        TungstenExtractionMixture = new Material.Builder(4284, SuSyUtility.susyId('tungsten_extraction_mixture'))
                .liquid()
                .color(0xbfb341)
                .build();

        TungstenExtract = new Material.Builder(4285, SuSyUtility.susyId('tungsten_extract'))
                .liquid()
                .color(0x9e7c2e)
                .build();

        ScrubbedTungstenExtract = new Material.Builder(4286, SuSyUtility.susyId('scrubbed_tungsten_extract'))
                .liquid()
                .color(0x85a825)
                .build();

        //FREE IDs: 4287-4289

        CopperMolybdeniteSlurry = new Material.Builder(4290, SuSyUtility.susyId('copper_molybdenite_slurry'))
                .liquid()
                .color(0x2e2419)
                .build();

        //FREE IDs: 4291-4292

        HafniumExtractionMixture = new Material.Builder(4293, SuSyUtility.susyId('hafnium_extraction_mixture'))
                .liquid()
                .color(0xc1e3d3)
                .build();

        HafniumExtract = new Material.Builder(4294, SuSyUtility.susyId('hafnium_extract'))
                .liquid()
                .color(0xc1e3d9)
                .build();

        AminatedEthyleneMixture = new Material.Builder(4295, SuSyUtility.susyId('aminated_ethylene_mixture'))
      		.liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
      		.color(0xb9a9db)
      		.build();
             
      	NeutralizedAminatedEthyleneMixture = new Material.Builder(4296, SuSyUtility.susyId('neutralized_aminated_ethylene_mixture'))
      		.liquid()
      		.color(0x8a819c)
      		.build();

        //FREE IDs: 4297-4301

        RoastedPyrochlore = new Material.Builder(4302, SuSyUtility.susyId('roasted_pyrochlore'))
                .dust()
                .color(0x230300)
                .iconSet(DULL)
                .build();

        DigestedPyrochlore = new Material.Builder(4303, SuSyUtility.susyId('digested_pyrochlore'))
                .dust()
                .color(0x230300)
                .iconSet(QUARTZ)
                .build();

        ImpureNiobiumPentachloride = new Material.Builder(4304, SuSyUtility.susyId('impure_niobium_pentachloride'))
                .liquid()
                .color(0xb0c8b8)
                .build();

        //FREE IDs: 4305-4309

        ImpureFluoroniobicAcidSolution = new Material.Builder(4310, SuSyUtility.susyId('impure_fluoroniobic_acid_solution'))
                .liquid()
                .color(0x502b75)
                .build();

        NiobiumRichExtract = new Material.Builder(4311, SuSyUtility.susyId('niobium_rich_extract'))
                .liquid()
                .color(0x4a2894)
                .build();

        MetalSulfateWaste = new Material.Builder(4312, SuSyUtility.susyId('metal_sulfate_waste'))
                .liquid()
                .color(0x947728)
                .build();

        ScrubbedNiobiumRichExtract = new Material.Builder(4313, SuSyUtility.susyId('scrubbed_niobium_rich_extract'))
                .liquid()
                .color(0x5a34ad)
                .build();

        DilutedTantalumExtract = new Material.Builder(4314, SuSyUtility.susyId('diluted_tantalum_extract'))
                .liquid()
                .color(0xd99152)
                .build();

        FluoroniobicAcidSolution = new Material.Builder(4315, SuSyUtility.susyId('fluoroniobic_acid_solution'))
                .liquid()
                .color(0x48147d)
                .build();

        DilutedNiobiumExtract = new Material.Builder(4316, SuSyUtility.susyId('diluted_niobium_extract'))
                .liquid()
                .color(0xa46edb)
                .build();

        //FREE IDs: 4317-4321

        ImpureFluorotantalicAcidSolution = new Material.Builder(4322, SuSyUtility.susyId('impure_fluorotantalic_acid_solution'))
                .liquid()
                .color(0x753a10)
                .build();

        TantalumRichExtract = new Material.Builder(4323, SuSyUtility.susyId('tantalum_rich_extract'))
                .liquid()
                .color(0x9c5625)
                .build();

        ScrubbedTantalumRichExtract = new Material.Builder(4324, SuSyUtility.susyId('scrubbed_tantalum_rich_extract'))
                .liquid()
                .color(0xb56731)
                .build();

        HydrofluoricAmmoniaMixture = new Material.Builder(4325, SuSyUtility.susyId('hydrofluoric_ammonia_mixture'))
                .liquid()
                .color(0x5247b5)
                .build();

        MolybdeniteFlueGas = new Material.Builder(4326, SuSyUtility.susyId('molybdenite_flue_gas'))
                .gas()
                .color(0x464e61)
                .build();

        RheniumRichFlue = new Material.Builder(4327, SuSyUtility.susyId('rhenium_rich_flue'))
                .dust()
                .color(0x384b75)
                .build();

        ScrubbedPerrhenateSolution = new Material.Builder(4328, SuSyUtility.susyId('scrubbed_perrhenate_solution'))
                .liquid()
                .color(0x3c70bd)
                .build();

        AlphaOlefinMixture = new Material.Builder(4329, SuSyUtility.susyId('alpha_olefin_mixture'))
                .liquid()
                .color(0xd15298)
                .build();
                
        //FREE ID: 4330-4332
        
        HZSMFive = new Material.Builder(4333, SuSyUtility.susyId('hzsm_five'))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x75a118)
                .build();

        FunctionalizableCrosslinkedPolystyrene = new Material.Builder(4334, SuSyUtility.susyId('functionalizable_crosslinked_polystyrene'))
                .ingot().liquid(new FluidBuilder().temperature(513))
                .flags(GENERATE_ROUND)
                .color(0x8689cf)
                .build();

        TantalumExtract = new Material.Builder(4335, SuSyUtility.susyId('tantalum_extract'))
                .liquid()
                .color(0xc97328)
                .build();

        BisphenolBrominationCatalyst = new Material.Builder(4336, SuSyUtility.susyId('bisphenol_bromination_catalyst'))
                .dust()
                .color(0xbd800f)
                .build();

        ImpureBrominatedBisphenolEmulsion = new Material.Builder(4337, SuSyUtility.susyId('impure_brominated_bisphenol_emulsion'))
                .liquid()
                .color(0x502d0a)
                .build();

        ImpureBrominatedBisphenolSolution = new Material.Builder(4338, SuSyUtility.susyId('impure_brominated_bisphenol_solution'))
                .liquid()
                .color(0x78410a)
                .build();

        BisphenolANovolacEpoxy = new Material.Builder(4339, SuSyUtility.susyId('bisphenol_a_novolac_epoxy'))
                .dust()
                .color(0xa87e54)
                .build();

        SulfoniumPreparationMixture = new Material.Builder(4340, SuSyUtility.susyId('sulfonium_preparation_mixture'))
                .liquid()
                .color(0x9e935c)
                .build();

        SuEight = new Material.Builder(4341, SuSyUtility.susyId('su_eight'))
                .liquid()
                .color(0x11915c)
                .build();

        HydrodealkylatedTolueneMixture = new Material.Builder(4342, SuSyUtility.susyId('hydrodealkylated_toluene_mixture'))
                .liquid()
                .color(0x4a320a)
                .build();

        AcidicHydrogenSilsesquioxaneSolution = new Material.Builder(4343, SuSyUtility.susyId("acidic_hydrogen_silsesquioxane_solution"))
                .liquid()
                .color(0xb086aa)
                .build();

        HydrogenSilsesquioxaneSolution = new Material.Builder(4344, SuSyUtility.susyId("hydrogen_silsesquioxane_solution"))
                .liquid()
                .color(0xa186b0)
                .build();

        ImpureCelestineSlurry = new Material.Builder(4345, SuSyUtility.susyId("impure_celestine_slurry"))
                .liquid()
                .color(0x698886)
                .build();

        CelestineSlurry = new Material.Builder(4346, SuSyUtility.susyId("celestine_slurry"))
                .liquid()
                .color(0x8cb5b3)
                .build();

        BariumResidue = new Material.Builder(4347, SuSyUtility.susyId("barium_residue"))
                .dust()
                .color(0xc9c4b1)
                .build();
     
        OrganosiliconMixture = new Material.Builder(4348, SuSyUtility.susyId("organosilicon_mixture"))
                .liquid()
                .color(0xbebdb8)
                .build();
     
        ImpurePolydimethylsiloxaneMixture = new Material.Builder(4349, SuSyUtility.susyId("impure_polydimethylsiloxane_mixture"))
                .liquid()
                .color(0xf6f7f0)
                .build();
     
        RawPolydimethylsiloxaneMixture = new Material.Builder(4350, SuSyUtility.susyId("raw_polydimethylsiloxane_mixture"))
                .liquid()
                .color(0xf6f7f0)
                .build();
        
        AcidicDinitrobenzeneMixture = new Material.Builder(4351, SuSyUtility.susyId("acidic_dinitrobenzene_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(363))
                .color(0x255563)
                .build();

        AntistaticAdditive = new Material.Builder(4352, SuSyUtility.susyId("antistatic_additive"))
                .liquid()
                .color(0xd1cc8e)
                .build();

        AntifoamingAdditive = new Material.Builder(4353, SuSyUtility.susyId("antifoaming_additive"))
                .liquid()
                .color(0x597275)
                .build();

        DiisopropylParaPhenylenediamineSolution = new Material.Builder(4354, SuSyUtility.susyId('diisopropyl_para_phenylenediamine_solution'))
                .liquid()
                .color(0x189477)
                .build();

        PropanolamineMix = new Material.Builder(4355, SuSyUtility.susyId('propanolamine_mix'))
                .liquid()
                .color(0x4cb522)
                .build();

        LubricityAdditive = new Material.Builder(4356, SuSyUtility.susyId("lubricity_additive"))
                .liquid()
                .color(0xab8f61)
                .build();

        MetalDeactivator = new Material.Builder(4357, SuSyUtility.susyId('metal_deactivator'))
                .liquid()
                .color(0x9b34a8)
                .build();

        IgnitionImprover = new Material.Builder(4358, SuSyUtility.susyId('ignition_improver'))
                .liquid()
                .color(0x8ede6f)
                .build();

        ColdFlowImprover = new Material.Builder(4359, SuSyUtility.susyId('cold_flow_improver'))
                .liquid()
                .color(0x1c32a3)
                .build();

        CorrosionInhibitor = new Material.Builder(4360, SuSyUtility.susyId('corrosion_inhibitor'))
                .liquid()
                .color(0x8a633a)
                .build();

        MidgradeDiesel = new Material.Builder(4361, SuSyUtility.susyId('midgrade_diesel'))
                .liquid()
                .color(0xc4a535)
                .flags(FLAMMABLE)
                .build();

        PremiumDiesel = new Material.Builder(4362, SuSyUtility.susyId('premium_diesel'))
                .liquid()
                .color(0xd1aa1d)
                .flags(FLAMMABLE)
                .build();

        SupremeDiesel = new Material.Builder(4363, SuSyUtility.susyId('supreme_diesel'))
                .liquid()
                .color(0xdb9a16)
                .flags(FLAMMABLE)
                .build();

        MidgradeKerosene = new Material.Builder(4364, SuSyUtility.susyId('midgrade_kerosene'))
                .liquid()
                .color(0xa8a44a)
                .flags(FLAMMABLE)
                .build();

        PremiumKerosene = new Material.Builder(4365, SuSyUtility.susyId('premium_kerosene'))
                .liquid()
                .color(0xbab541)
                .flags(FLAMMABLE)
                .build();

        SupremeKerosene = new Material.Builder(4366, SuSyUtility.susyId('supreme_kerosene'))
                .liquid()
                .color(0xd9c148)
                .flags(FLAMMABLE)
                .build();

        SAPOEleven = new Material.Builder(4367, SuSyUtility.susyId('sapo_eleven'))
                .dust()
                .color(0x91834e)
                .build();
                
        PlatinumSAPOEleven = new Material.Builder(4368, SuSyUtility.susyId('platinum_sapo_eleven'))
                .dust()
                .color(0x969444)
                .flags(GENERATE_CATALYST_BED)
                .build();
                
        SiliconeOilMixture = new Material.Builder(4369, SuSyUtility.susyId('silicone_oil_mixture'))
                .liquid()
                .color(0x9aa38c)
                .build();
                
        SiliconeOil = new Material.Builder(4370, SuSyUtility.susyId('silicone_oil'))
                .liquid()
                .color(0xbec7b1)
                .build();
                
        CrudePolyalphaolefinMixture = new Material.Builder(4371, SuSyUtility.susyId('crude_polyalphaolefin_mixture'))
                .liquid()
                .color(0xc77db2)
                .build();
                
        BoronTrifluorideMixture = new Material.Builder(4372, SuSyUtility.susyId('boron_trifluoride_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xbd3a6b)
                .build();
                
        UnsaturatedPolyalphaolefin = new Material.Builder(4373, SuSyUtility.susyId('unsaturated_polyalphaolefin'))
                .liquid()
                .color(0xb393ba)
                .build();
                
        NButanolWaste = new Material.Builder(4374, SuSyUtility.susyId('n_butanol_waste'))
                .liquid()
                .color(0xba6685)
                .build();
                
        Polyalphaolefin = new Material.Builder(4375, SuSyUtility.susyId('polyalphaolefin'))
                .liquid()
                .color(0xcbaed1)
                .build();
                
        PolybuteneMixture = new Material.Builder(4376, SuSyUtility.susyId('polybutene_mixture'))
                .liquid()
                .color(0xb08d63)
                .build();
                
        EsterBaseOil = new Material.Builder(4377, SuSyUtility.susyId('ester_base_oil'))
                .liquid()
                .color(0xa098d4)
                .build();
                
        Monoglycerides = new Material.Builder(4378, SuSyUtility.susyId('monoglycerides'))
                .liquid()
                .color(0xb39147)
                .build();
                
        CrudeOneNitronaphthalene = new Material.Builder(4379, SuSyUtility.susyId('crude_one_nitronaphthalene'))
                .dust()
                .color(0x918a41)
                .build();
                
        PolyisobuteneMixture = new Material.Builder(4380, SuSyUtility.susyId('polyisobutene_mixture'))
                .liquid()
                .color(0xad6d34)
                .build();
                
        AlkylMethacrylate = new Material.Builder(4381, SuSyUtility.susyId('alkyl_methacrylate'))
                .liquid()
                .color(0x72ba6e)
                .build();
                
        PolyalkylMethacrylateSolution = new Material.Builder(4382, SuSyUtility.susyId('polyalkyl_methacrylate_solution'))
                .liquid()
                .color(0x8db08b)
                .build();
                
        AlkylMethacrylateEmulsion = new Material.Builder(4383, SuSyUtility.susyId('alkyl_methacrylate_emulsion'))
                .liquid()
                .color(0xa4d4a1)
                .build();
                
        Pama = new Material.Builder(4384, SuSyUtility.susyId('pama'))
                .dust()
                .color(0xc9edc7)
                .build();
                
        PolymerizedStyreneIsopreneSolution = new Material.Builder(4385, SuSyUtility.susyId('polymerized_styrene_isoprene_solution'))
                .liquid()
                .color(0x361940)
                .build();
                
        PolyisobuteneSuccinicAnhydride = new Material.Builder(4386, SuSyUtility.susyId('polyisobutene_succinic_anhydride'))
                .dust()
                .color(0x6b142b)
                .build();

        ZincDialkyldithiophospate = new Material.Builder(4387, SuSyUtility.susyId('zinc_dialkyldithiophosphate'))
                .liquid()
                .color(0x423900)
                .build();

        ZincDialkyldithiophospate.setFormula("Zn[(S2P(OR)2]2", true)

        MolybdenumDialkyldithiophosphate = new Material.Builder(4388, SuSyUtility.susyId('molybdenum_dialkyldithiophosphate'))
                .dust()
                .color(0x244200)
                .build();

        MolybdenumDialkyldithiophosphate.setFormula("Mo[(S2P(OR)2]2", true)
                
        MidgradeLubricant = new Material.Builder(4389, SuSyUtility.susyId('midgrade_lubricant'))
                .liquid()
                .color(0xc7aa2a)
                .build();
                
        PremiumLubricant = new Material.Builder(4390, SuSyUtility.susyId('premium_lubricant'))
                .liquid()
                .color(0xba831c)
                .build();
                
        SupremeLubricant = new Material.Builder(4391, SuSyUtility.susyId('supreme_lubricant'))
                .liquid()
                .color(0xad5f10)
                .build();

        DinitrobenzeneMixture = new Material.Builder(4392, SuSyUtility.susyId("dinitrobenzene_mixture"))
                .dust()
                .color(0x1f6478)
                .build();

        Cotton = new Material.Builder(4393, SuSyUtility.susyId("cotton"))
                .color(0xf0edd8)
                .build();

        Cotton.setFormula('C6H5(OH)4OH', true)
        Cotton.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, false, false))

        Spandex = new Material.Builder(4394, SuSyUtility.susyId("spandex"))
                .color(0x625f8a)
                .build();

        Spandex.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, false, true))

        PolyurethanePolymerizationMix = new Material.Builder(4395, SuSyUtility.susyId("polyurethane_polymerization_mix"))
                .liquid()
                .color(0x9c9c9c)
                .build();

        SpandexPrepolymer = new Material.Builder(4396, SuSyUtility.susyId("spandex_prepolymer"))
                .liquid()
                .color(0x393563)
                .build();

        SpandexPolymerizationMix = new Material.Builder(4397, SuSyUtility.susyId("spandex_polymerization_mix"))
                .liquid()
                .color(0x494575)
                .build();

        AcrylicPhotoemulsion = new Material.Builder(4398, SuSyUtility.susyId("acrylic_photoemulsion"))
                .liquid()
                .color(0x8a2531)
                .build();

        TreatedCollagen = new Material.Builder(4399, SuSyUtility.susyId("treated_collagen"))
                .dust()
                .color(0xa6a490)
                .iconSet(ROUGH)
                .build();

        ImpureCadmiumSulfateSolution = new Material.Builder(4400, SuSyUtility.susyId("impure_cadmium_sulfate_solution"))
                .liquid()
                .color(0x6f8485)
                .build();

        TannicAcidSolution = new Material.Builder(4401, SuSyUtility.susyId("tannic_acid_solution"))
                .liquid()
                .color(0x702507)
                .build();

        GermaniumLeach = new Material.Builder(4402, SuSyUtility.susyId("germanium_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7ecccb)
                .build();

        GermaniumConcentrate = new Material.Builder(4403, SuSyUtility.susyId("germanium_concentrate"))
                .dust()
                .color(0x6ca3a2)
                .build();

        ImpureGermaniumTetrachloride = new Material.Builder(4404, SuSyUtility.susyId("impure_germanium_tetrachloride"))
                .gas(new FluidBuilder().temperature(360))
                .color(0xc3ded9)
                .build();

        GermaniumOxalateLeach = new Material.Builder(4405, SuSyUtility.susyId("germanium_oxalate_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x476f91)
                .build();

        PurifiedGermaniumOxalateLeach = new Material.Builder(4406, SuSyUtility.susyId("purified_germanium_oxalate_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x52809c)
                .build();

        GermaniumGalliumExtractionMixture = new Material.Builder(4407, SuSyUtility.susyId("germanium_gallium_extraction_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7657b5)
                .build();

        GermaniumGalliumExtract = new Material.Builder(4408, SuSyUtility.susyId("germanium_gallium_extract"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x5a56a3)
                .build();

        GermaniumExtract = new Material.Builder(4409, SuSyUtility.susyId("germanium_extract"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x6e59b5)
                .build();

        GermaniumOxalateSolution = new Material.Builder(4410, SuSyUtility.susyId("germanium_oxalate_solution"))
                .liquid()
                .color(0x8b78cc)
                .build();

        CrudeIndiumIIIHydroxide = new Material.Builder(4411, SuSyUtility.susyId("crude_indium_iii_hydroxide"))
                .dust()
                .color(0x5618ad)
                .build();

        IndiumResidue = new Material.Builder(4412, SuSyUtility.susyId("indium_residue"))
                .dust()
                .color(0x7d41b5)
                .build();

        IndiumLeach = new Material.Builder(4413, SuSyUtility.susyId("indium_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7418ad)
                .build();

        CrudeIndiumIIISulfateSolution = new Material.Builder(4414, SuSyUtility.susyId("crude_indium_iii_sulfate_solution"))
                .liquid()
                .color(0xab18ad)
                .build();

        SulfatizedLeadSlime = new Material.Builder(4415, SuSyUtility.susyId("sulfatized_lead_slime"))
                .dust()
                .color(0x522a44)
                .build();

        ImpureIndiumLeach = new Material.Builder(4416, SuSyUtility.susyId("impure_indium_leach"))
                .liquid()
                .color(0x853579)
                .build();

        ZincHydrochloricLeachResidue = new Material.Builder(4417, SuSyUtility.susyId("zinc_hydrochloric_leach_residue"))
                .dust()
                .color(0x4a3b2f)
                .build()

        CopperAnodeSlimePaste = new Material.Builder(4418, SuSyUtility.susyId("copper_anode_slime_paste"))
                .liquid()
                .color(0x706b36)
                .build()

        SeleniumTelluriumConcentrate = new Material.Builder(4419, SuSyUtility.susyId("selenium_tellurium_concentrate"))
                .dust()
                .color(0x9bbf77)
                .build()

        TelluriumResidue = new Material.Builder(4420, SuSyUtility.susyId("tellurium_residue"))
                .dust()
                .color(0x688767)
                .build()

        TelluriumSlag = new Material.Builder(4421, SuSyUtility.susyId("tellurium_slag"))
                .dust()
                .color(0x98bf97)
                .build()

        PolluciteLeach = new Material.Builder(4422, SuSyUtility.susyId("pollucite_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8fa8cf)
                .build()

        CaesiumRubidiumAlumMixture = new Material.Builder(4423, SuSyUtility.susyId("caesium_rubidium_alum_mixture"))
                .dust()
                .color(0x631a87)
                .build()

        SourWater = new Material.Builder(4424, SuSyUtility.susyId("sour_water"))
                .fluid()
                .color(0x281757)
                .build()

        TypeYZeolite = new Material.Builder(4425, SuSyUtility.susyId('type_y_zeolite'))
                .dust()
                .iconSet(SHINY)
                .color(0xc8cca1)
                .build();

        TypeYZeoliteSolution = new Material.Builder(4426, SuSyUtility.susyId('type_y_zeolite_solution'))
                .liquid()
                .color(0xc8cca1)
                .build();

        //FREE ID: 4427

        OxidizedPGMLeach = new Material.Builder(4428, SuSyUtility.susyId("oxidized_pgm_leach"))
                .fluid()
                .color(0x1b261d)
                .build();

        ImpureNickelSulfateSolution = new Material.Builder(4429, SuSyUtility.susyId("impure_nickel_sulfate_solution"))
                .fluid()
                .color(0x1b4a1f)
                .build();

        CopperRichPGMSolids = new Material.Builder(4430, SuSyUtility.susyId("copper_rich_pgm_solids"))
                .dust()
                .color(0x374529)
                .build();

        PGMCopperLeachSlurry = new Material.Builder(4431, SuSyUtility.susyId("pgm_copper_leach_slurry"))
                .fluid()
                .color(0x334520)
                .build();

        PGMFreeCopperLeach = new Material.Builder(4432, SuSyUtility.susyId("pgm_free_copper_leach"))
                .fluid()
                .color(0xb35f1b)
                .build();

        PGMConcentrate = new Material.Builder(4433, SuSyUtility.susyId("pgm_concentrate"))
                .dust()
                .color(0xe60e0e)
                .iconSet(SHINY)
                .build();

        SulfidicCopperLeach = new Material.Builder(4434, SuSyUtility.susyId("sulfidic_copper_leach"))
                .fluid()
                .color(0xb3562b)
                .build();

        CopperSelenideTelluride = new Material.Builder(4435, SuSyUtility.susyId("copper_selenide_telluride"))
                .dust()
                .color(0xafc474)
                .build();

        ChalcogenFreeCopperLeach = new Material.Builder(4436, SuSyUtility.susyId("chalcogen_free_copper_leach"))
                .fluid()
                .color(0xf57242)
                .build();

        MixedChalcogenDioxide = new Material.Builder(4437, SuSyUtility.susyId("mixed_chalcogen_dioxide"))
                .dust()
                .color(0x657d85)
                .build();

        NickelCobaltSulfate = new Material.Builder(4438, SuSyUtility.susyId("nickel_cobalt_sulfate"))
                .dust()
                .color(0xe60e0e)
                .components(Nickel * 1, Cobalt * 1, Sulfur, Oxygen * 4)
                .build();

        NickelCobaltSulfate.setFormula('(Ni,Co)(SO4)', true)

        NickelCobaltSulfateSolution = new Material.Builder(4439, SuSyUtility.susyId("nickel_cobalt_sulfate_solution"))
                .fluid()
                .color(0x48852c)
                .build();

        //FREE ID: 4440-4441

        CobaltExtract = new Material.Builder(4442, SuSyUtility.susyId("cobalt_extract"))
                .fluid()
                .color(0x5e8e8e)
                .build();

        CrudeTrimethylpentylphosphinicAcid = new Material.Builder(4443, SuSyUtility.susyId("crude_trimethylpentylphosphinic_acid"))
                .fluid()
                .color(0xc4a335)
                .build();

        AlkalineTrimethylpentylphosphinicAcid = new Material.Builder(4444, SuSyUtility.susyId("alkaline_trimethylpentylphosphinic_acid"))
                .fluid()
                .color(0x360e0e)
                .build();

        AcidifiedTrimethylpentylphosphinicAcid = new Material.Builder(4445, SuSyUtility.susyId("acidified_trimethylpentylphosphinic_acid"))
                .fluid()
                .color(0x663e1e)
                .build();

        DehydratedTrimethylpentylphosphinicAcid = new Material.Builder(4446, SuSyUtility.susyId("dehydrated_trimethylpentylphosphinic_acid"))
                .fluid()
                .color(0x663e00)
                .build();

        OsmiumRutheniumFreePGMSolution = new Material.Builder(4447, SuSyUtility.susyId("os_ru_free_pgm_solution"))
                .fluid()
                .color(0xe0dcb6)
                .build();

        SilverFreePGMSolution = new Material.Builder(4448, SuSyUtility.susyId("silver_free_pgm_solution"))
                .fluid()
                .color(0xa3a18b)
                .build();

        GoldFreePGMSolution = new Material.Builder(4449, SuSyUtility.susyId("gold_free_pgm_solution"))
                .fluid()
                .color(0x82806b)
                .build();

        GoldExtract = new Material.Builder(4450, SuSyUtility.susyId("gold_extract"))
                .fluid()
                .color(0xe3d76b)
                .build();

        ScrubbedGoldExtract = new Material.Builder(4451, SuSyUtility.susyId("scrubbed_gold_extract"))
                .fluid()
                .color(0xf5e65f)
                .build();

        PlatinumFreePGMSolution = new Material.Builder(4452, SuSyUtility.susyId("platinum_free_pgm_solution"))
                .fluid()
                .color(0xbfb984)
                .build();

        ChlorinatedRhodiumIridiumSolution = new Material.Builder(4453, SuSyUtility.susyId("chlorinated_rh_ir_solution"))
                .fluid()
                .color(0xa39bb8)
                .build();

        ChlorateTreatedPGMSolution = new Material.Builder(4454, SuSyUtility.susyId("chlorate_treated_pgm_solution"))
                .fluid()
                .color(0xccc9a9)
                .build();

        IridiumExtract = new Material.Builder(4455, SuSyUtility.susyId("iridium_extract"))
                .fluid()
                .color(0x8e8e8e)
                .build();

        // FREE ID: 4456

        PalladiumExtract = new Material.Builder(4457, SuSyUtility.susyId("palladium_extract"))
                .fluid()
                .color(0xaba07e)
                .build();

        DiisobutyleneMixture = new Material.Builder(4458, SuSyUtility.susyId('diisobutylene_mixture'))
                .fluid()
                .color(0x5d503e)
                .build();

        GreenMatte = new Material.Builder(4459, SuSyUtility.susyId("green_matte"))
                .dust()
                .color(0xa18922)
                .iconSet(DULL)
                .build();

        WhiteMatte = new Material.Builder(4460, SuSyUtility.susyId("white_matte"))
                .dust()
                .color(0xd1bf71)
                .iconSet(DULL)
                .build();

        // FREE IDs: 4461-4469

        RhodiumIridiumSolution = new Material.Builder(4470, SuSyUtility.susyId("rh_ir_solution"))
                .fluid()
                .color(0x9177a1)
                .build();

        // FREE ID: 4471

        OsmiumRutheniumTetroxideMixture = new Material.Builder(4472, SuSyUtility.susyId("os_ru_tetroxide_mixture"))
                .gas()
                .color(0x8e8e8e)
                .build();

        OsmiumRutheniumSolution = new Material.Builder(4473, SuSyUtility.susyId("os_ru_solution"))
                .fluid()
                .color(0x7e8e8e)
                .build();

        ReducedGoldFreePGMSolution = new Material.Builder(4474, SuSyUtility.susyId("reduced_gold_free_pgm_solution"))
                .fluid()
                .color(0x82806b)
                .build();


        // Skipped IDs : 4426-4499 for gtl & plat chain

        DeacidifiedLipid = new Material.Builder(4500, SuSyUtility.susyId('deacidified_lipid'))
                .liquid()
                .color(0xe3ae64)
                .build();

        GlycerolMethanolSolution = new Material.Builder(4501, SuSyUtility.susyId('glycerol_methanol_solution'))
                .liquid()
                .color(0xb3de87)
                .build();

        GlycerolEthanolSolution = new Material.Builder(4502, SuSyUtility.susyId('glycerol_ethanol_solution'))
                .liquid()
                .color(0xc0de87)
                .build();

        CrudeGlycerol = new Material.Builder(4503, SuSyUtility.susyId('crude_glycerol'))
                .liquid()
                .color(0x96de87)
                .build();

        CrudeFattyAcidMethylEster = new Material.Builder(4504, SuSyUtility.susyId('crude_fatty_acid_methyl_ester'))
                .liquid()
                .color(0xffb100)
                .build();

        CrudeFattyAcidEthylEster = new Material.Builder(4505, SuSyUtility.susyId('crude_fatty_acid_ethyl_ester'))
                .liquid()
                .color(0xffa000)
                .build();

        NeutralizedFattyAcidMethylEster = new Material.Builder(4506, SuSyUtility.susyId('neutralized_fatty_acid_methyl_ester'))
                .liquid()
                .color(0xff8f00)
                .build();

        NeutralizedFattyAcidEthylEster = new Material.Builder(4507, SuSyUtility.susyId('neutralized_fatty_acid_ethyl_ester'))
                .liquid()
                .color(0xff6500)
                .build();

        UnscrubbedBioDiesel = new Material.Builder(4508, SuSyUtility.susyId('unscrubbed_bio_diesel'))
                .liquid()
                .color(0xc36100)
                .build();

        MoistBioDiesel = new Material.Builder(4509, SuSyUtility.susyId('moist_bio_diesel'))
                .liquid()
                .color(0xf77b00)
                .build();

        LipidBleachingMix = new Material.Builder(4510, SuSyUtility.susyId('bleaching_lipid_mix'))
                .liquid()
                .color(0xc29850)
                .build();

        BleachedLipid = new Material.Builder(4511, SuSyUtility.susyId('bleached_lipid'))
                .liquid()
                .color(0xd6c2a2)
                .build();

        HeatedLipid = new Material.Builder(4512, SuSyUtility.susyId('heated_lipid'))
                .liquid()
                .color(0xffd0a2)
                .build();

        HydrotreatedLipidMixture = new Material.Builder(4513, SuSyUtility.susyId('hydrotreated_lipid_mixture'))
                .liquid()
                .color(0xfff7ef)
                .build();

        CrudeNParaffin = new Material.Builder(4514, SuSyUtility.susyId('crude_n_paraffin'))
                .liquid()
                .color(0xededde)
                .build();

        NeutralizedNParaffin = new Material.Builder(4515, SuSyUtility.susyId('neutralized_n_paraffin'))
                .liquid()
                .color(0xf6f6ef)
                .build();

        DistilledNParaffin = new Material.Builder(4516, SuSyUtility.susyId('distilled_n_paraffin'))
                .liquid()
                .color(0xeff6f6)
                .build();

        IsomerizedParaffin = new Material.Builder(4517, SuSyUtility.susyId('isomerized_paraffin'))
                .liquid()
                .color(0xffebbb)
                .build();

        NitrogenOxideMixture = new Material.Builder(4518, SuSyUtility.susyId('nitrogen_oxide_mixture'))
                .gas()
                .components(NitricOxide, NitrogenDioxide)
                .colorAverage()
                .build();

        NitrogenOxideMixture.setFormula('NOx', true)

        HotNitrogenOxideMixture = new Material.Builder(4519, SuSyUtility.susyId('hot_nitrogen_oxide_mixture'))
                .gas(new FluidBuilder().temperature(1300))
                .components(NitrogenOxideMixture)
                .colorAverage()
                .build();

        NitrogenOxideMixtureRichAir = new Material.Builder(4520, SuSyUtility.susyId('nitrogen_oxide_mixture_rich_air'))
                .gas()
                .components(NitrogenOxideMixture * 2, Oxygen, Air * 10)
                .colorAverage()
                .build();

        HotNitrogenOxideMixtureRichAir = new Material.Builder(4521, SuSyUtility.susyId('hot_nitrogen_oxide_mixture_rich_air'))
                .gas(new FluidBuilder().temperature(1300))
                .components(NitrogenOxideMixtureRichAir)
                .colorAverage()
                .build();

        NitrogenDioxideRichAir = new Material.Builder(4522, SuSyUtility.susyId('nitrogen_dioxide_rich_air'))
                .gas(new FluidBuilder().temperature(500))
                .components(NitrogenDioxide, Air * 5)
                .colorAverage()
                .build();

        NitricOxideRichAir = new Material.Builder(4523, SuSyUtility.susyId('nitric_oxide_rich_air'))
                .gas()
                .components(NitricOxide, Air * 15)
                .colorAverage()
                .build();

        P204ExtractionMixture = new Material.Builder(4524, SuSyUtility.susyId('p_two_zero_four_extraction_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7f7f7f)
                .build();

        SpentP204ExtractionMixture = new Material.Builder(4525, SuSyUtility.susyId('spent_p_two_zero_four_extraction_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7f7f7f)
                .build();

        P507ExtractionMixture = new Material.Builder(4526, SuSyUtility.susyId('p_five_zero_seven_extraction_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7f7f7f)
                .build();

        SpentP507ExtractionMixture = new Material.Builder(4527, SuSyUtility.susyId('spent_p_five_zero_seven_extraction_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7f7f7f)
                .build();

        P507P229ExtractionMixture = new Material.Builder(4528, SuSyUtility.susyId('p_five_zero_seven_p_two_two_nine_extraction_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7f7f7f)
                .build();

        SpentP507P229ExtractionMixture = new Material.Builder(4529, SuSyUtility.susyId('spent_p_five_zero_seven_p_two_two_nine_extraction_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7f7f7f)
                .build();

        BastReHydroxides = new Material.Builder(4530, SuSyUtility.susyId('bast_re_hydroxides'))
                .dust()
                .color(0xad4636)
                .build()

        MonaReHydroxides = new Material.Builder(4531, SuSyUtility.susyId('mona_re_hydroxides'))
                .dust()
                .color(0xa17f2a)
                .build()

        XenoReHydroxides = new Material.Builder(4532, SuSyUtility.susyId('xeno_re_hydroxides'))
                .dust()
                .color(0x3b110b)
                .build()

        BastOxReConcentrate = new Material.Builder(4533, SuSyUtility.susyId('bast_ox_re_concentrate'))
                .dust()
                .color(0xad6c36)
                .build()

        MonaOxReConcentrate = new Material.Builder(4534, SuSyUtility.susyId('mona_ox_re_concentrate'))
                .dust()
                .color(0x947937)
                .build()

        BastOxReNitratesSolution = new Material.Builder(4535, SuSyUtility.susyId('bast_ox_re_nitrates_solution'))
                .liquid()
                .color(0xa17faa)
                .build()

        MonaOxReNitratesSolution = new Material.Builder(4536, SuSyUtility.susyId('mona_ox_re_nitrates_solution'))
                .liquid()
                .color(0xb093b8)
                .build()

        XenoReNitratesSolution = new Material.Builder(4537, SuSyUtility.susyId('xeno_re_nitrates_solution'))
                .liquid()
                .color(0x3a118c)
                .build()

        BastCeFreeSolution = new Material.Builder(4538, SuSyUtility.susyId('bast_ce_free_solution'))
                .liquid()
                .color(0x7950aa)
                .build()

        MonaCeFreeSolution = new Material.Builder(4539, SuSyUtility.susyId('mona_ce_free_solution'))
                .liquid()
                .color(0x886eb8)
                .build()

        CeriumExtract = new Material.Builder(4540, SuSyUtility.susyId('cerium_extract'))
                .liquid()
                .color(0xa0a381)
                .build()
        
        BastLreeConcentrate = new Material.Builder(4541, SuSyUtility.susyId('bast_lree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xad7287)
                .build();

        MonaLreeConcentrate = new Material.Builder(4542, SuSyUtility.susyId('mona_lree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xcc6e90)
                .build();

        XenoLreeExtract = new Material.Builder(4543, SuSyUtility.susyId('xeno_lree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x4f2f32)
                .build();

        XenoLreeConcentrate = new Material.Builder(4544, SuSyUtility.susyId('xeno_lree_concentrate'))
                .liquid()
                .color(0x422c34)
                .build();

        BastLreeFreeExtract = new Material.Builder(4545, SuSyUtility.susyId('bast_lree_free_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x9ca67e)
                .build();

        MonaLreeFreeExtract = new Material.Builder(4546, SuSyUtility.susyId('mona_lree_free_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xc6d694)
                .build();

        BastLreeFreeConcentrate = new Material.Builder(4547, SuSyUtility.susyId('bast_lree_free_concentrate'))
                .liquid()
                .color(0x87a376)
                .build();

        MonaLreeFreeConcentrate = new Material.Builder(4548, SuSyUtility.susyId('mona_lree_free_concentrate'))
                .liquid()
                .color(0x98cc78)
                .build();

        XenoLreeFreeConcentrate = new Material.Builder(4549, SuSyUtility.susyId('xeno_lree_free_concentrate'))
                .liquid()
                .color(0x7cb02e)
                .build();

        BastMreeConcentrate = new Material.Builder(4550, SuSyUtility.susyId('bast_mree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8f6c4d)
                .build();

        MonaMreeConcentrate = new Material.Builder(4551, SuSyUtility.susyId('mona_mree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x89c763)
                .build();

        XenoMreeConcentrate = new Material.Builder(4552, SuSyUtility.susyId('xeno_mree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x2e6b3b)
                .build();

        XenoMreeExtract = new Material.Builder(4553, SuSyUtility.susyId('xeno_mree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x567344)
                .build();

        XenoEnrichedMreeConcentrate = new Material.Builder(4554, SuSyUtility.susyId('xeno_enriched_mree_concentrate'))
                .liquid()
                .color(0x447a22)
                .build();

        BastHreeExtract = new Material.Builder(4555, SuSyUtility.susyId('bast_hree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7483ab)
                .build();
        
        MonaHreeExtract = new Material.Builder(4556, SuSyUtility.susyId('mona_hree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x6e88cc)
                .build();

        XenoHreeExtract = new Material.Builder(4557, SuSyUtility.susyId('xeno_hree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x264491)
                .build();

        BastHreeConcentrate = new Material.Builder(4558, SuSyUtility.susyId('bast_hree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x6c7f9f)
                .build();
                
        MonaHreeConcentrate = new Material.Builder(4559, SuSyUtility.susyId('mona_hree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x5a7db8)
                .build();

        XenoCeFreeConcentrate = new Material.Builder(4560, SuSyUtility.susyId('xeno_ce_free_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x3b4d6c)
                .build();
        
        BastPrNdHydroxides = new Material.Builder(4561, SuSyUtility.susyId('bast_pr_nd_hydroxides'))
                .dust()
                .color(0x571b23)
                .build();
        
        MonaPrNdHydroxides = new Material.Builder(4562, SuSyUtility.susyId('mona_pr_nd_hydroxides'))
                .dust()
                .color(0x421b20)
                .build();

        BastOxPrNdConcentrate = new Material.Builder(4563, SuSyUtility.susyId('bast_ox_pr_nd_concentrate'))
                .dust()
                .color(0x401d0d)
                .build();

        MonaOxPrNdConcentrate = new Material.Builder(4564, SuSyUtility.susyId('mona_ox_pr_nd_concentrate'))
                .dust()
                .color(0x472313)
                .build();

        BastReducedMreeConcentrate = new Material.Builder(4566, SuSyUtility.susyId('bast_reduced_mree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8f6d28)
                .build();

        MonaReducedMreeConcentrate = new Material.Builder(4567, SuSyUtility.susyId('mona_reduced_mree_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x89c732)
                .build();

        XenoReducedMreeConcentrate = new Material.Builder(4568, SuSyUtility.susyId('xeno_reduced_mree_concentrate'))
                .liquid()
                .color(0x447a0a)
                .build();

        BastSmGdConcentrate = new Material.Builder(4569, SuSyUtility.susyId('bast_sm_gd_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8f6214)
                .build();

        MonaSmGdConcentrate = new Material.Builder(4570, SuSyUtility.susyId('mona_sm_gd_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x88bd1e)
                .build();

        XenoSmGdConcentrate = new Material.Builder(4571, SuSyUtility.susyId('xeno_sm_gd_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x587000)
                .build();

        BastSmConcentrate = new Material.Builder(4572, SuSyUtility.susyId('bast_sm_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xc3cf7a)
                .build();

        MonaSmConcentrate = new Material.Builder(4573, SuSyUtility.susyId('mona_sm_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xd0d998)
                .build();

        XenoSmConcentrate = new Material.Builder(4574, SuSyUtility.susyId('xeno_sm_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x472313)
                .build();

        GadoliniumExtract = new Material.Builder(4575, SuSyUtility.susyId('gadolinium_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xaebfeb)
                .build();

        BastDidymiumConcentrate = new Material.Builder(4576, SuSyUtility.susyId('bast_didymium_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xad5a73)
                .build();
        
        MonaDidymiumConcentrate = new Material.Builder(4577, SuSyUtility.susyId('mona_didymium_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xd66482)
                .build();

        XenoDidymiumConcentrate = new Material.Builder(4578, SuSyUtility.susyId('xeno_didymium_concentrate'))
                .liquid()
                .color(0x4c222a)
                .build();

        LanthanumExtract = new Material.Builder(4579, SuSyUtility.susyId('lanthanum_extract'))
                .liquid()
                .color(0x518787)
                .build();

        BastNdConcentrate = new Material.Builder(4580, SuSyUtility.susyId('bast_nd_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x994bc9)
                .build();

        MonaNdConcentrate = new Material.Builder(4581, SuSyUtility.susyId('mona_nd_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xb04eed)
                .build();

        XenoNdConcentrate = new Material.Builder(4582, SuSyUtility.susyId('xeno_nd_concentrate'))
                .liquid()
                .color(0x362142)
                .build();

        PraseodymiumExtract = new Material.Builder(4583, SuSyUtility.susyId('praseodymium_extract'))
                .liquid()
                .color(0xbcd4d6)
                .build();

        BastPurifiedHreeExtract = new Material.Builder(4584, SuSyUtility.susyId('bast_purified_hree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x5da38a)
                .build();

        MonaPurifiedHreeExtract = new Material.Builder(4585, SuSyUtility.susyId('mona_purified_hree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x62cca6)
                .build();

        BastScrubbedHreeExtract = new Material.Builder(4586, SuSyUtility.susyId('bast_scrubbed_hree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x88c2ac)
                .build();

        MonaScrubbedHreeExtract = new Material.Builder(4587, SuSyUtility.susyId('mona_scrubbed_hree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x79e0bb)
                .build();

        XenoScrubbedHreeExtract = new Material.Builder(4588, SuSyUtility.susyId('xeno_scrubbed_hree_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x2e8f6a)
                .build();

        BastYttriumRichConcentrate = new Material.Builder(4589, SuSyUtility.susyId('bast_yttrium_rich_concentrate'))
                .liquid()
                .color(0x915347)
                .build();

        MonaYttriumRichConcentrate = new Material.Builder(4590, SuSyUtility.susyId('mona_yttrium_rich_concentrate'))
                .liquid()
                .color(0xb0503e)
                .build();

        XenoYttriumRichConcentrate = new Material.Builder(4591, SuSyUtility.susyId('xeno_yttrium_rich_concentrate'))
                .liquid()
                .color(0x692c21)
                .build();

        BastTmYbExtract = new Material.Builder(4592, SuSyUtility.susyId('bast_tm_yb_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xff9cb9)
                .build();
        
        MonaThuliumGroupExtract = new Material.Builder(4593, SuSyUtility.susyId('mona_thulium_group_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xff9cc9)
                .build();

        XenoThuliumGroupExtract = new Material.Builder(4594, SuSyUtility.susyId('xeno_thulium_group_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xb0376e)
                .build();
        
        BastYttriumConcentrate = new Material.Builder(4595, SuSyUtility.susyId('bast_yttrium_concentrate'))
                .liquid()
                .color(0x6b4025)
                .build();

        MonaYttriumConcentrate = new Material.Builder(4596, SuSyUtility.susyId('mona_yttrium_concentrate'))
                .liquid()
                .color(0x824119)
                .build();
        
        XenoYttriumConcentrate = new Material.Builder(4597, SuSyUtility.susyId('xeno_yttrium_concentrate'))
                .liquid()
                .color(0x472510)
                .build();

        BastTerbiumGroupExtract = new Material.Builder(4598, SuSyUtility.susyId('bast_terbium_group_extract'))
                .liquid()
                .color(0x61ab9a)
                .build();
        
        MonaTerbiumGroupExtract = new Material.Builder(4599, SuSyUtility.susyId('mona_terbium_group_extract'))
                .liquid()
                .color(0x54bfa7)
                .build();

        XenoTerbiumGroupExtract = new Material.Builder(4600, SuSyUtility.susyId('xeno_terbium_group_extract'))
                .liquid()
                .color(0x0c8267)
                .build();       
        
        BastTerbiumGroupConcentrate = new Material.Builder(4601, SuSyUtility.susyId('bast_terbium_group_concentrate'))
                .liquid()
                .color(0x61ab85)
                .build();

        MonaTerbiumGroupConcentrate = new Material.Builder(4602, SuSyUtility.susyId('mona_terbium_group_concentrate'))
                .liquid()
                .color(0x58bf8a)
                .build();

        XenoTerbiumGroupConcentrate = new Material.Builder(4603, SuSyUtility.susyId('xeno_terbium_group_concentrate'))
                .liquid()
                .color(0x278c58)
                .build();
        
        BastPurifiedTerbiumGroupExtract = new Material.Builder(4604, SuSyUtility.susyId('bast_purified_terbium_group_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xa4bf75)
                .build();

        MonaPurifiedTerbiumGroupExtract = new Material.Builder(4605, SuSyUtility.susyId('mona_purified_terbium_group_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x9ed466)
                .build();
        
        XenoPurifiedTerbiumGroupExtract = new Material.Builder(4606, SuSyUtility.susyId('xeno_purified_terbium_group_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x67ab20)
                .build();

        BastTerbiumFreeExtract = new Material.Builder(4607, SuSyUtility.susyId('bast_terbium_free_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xa39953)
                .build();

        MonaTerbiumFreeExtract = new Material.Builder(4608, SuSyUtility.susyId('mona_terbium_free_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xbaac47)
                .build();
        
        XenoTerbiumFreeExtract = new Material.Builder(4609, SuSyUtility.susyId('xeno_terbium_free_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x857821)
                .build();

        BastTerbiumConcentrate = new Material.Builder(4610, SuSyUtility.susyId('bast_terbium_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x3d8076)
                .build();

        MonaTerbiumConcentrate = new Material.Builder(4611, SuSyUtility.susyId('mona_terbium_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x2e9485)
                .build();

        XenoTerbiumConcentrate = new Material.Builder(4612, SuSyUtility.susyId('xeno_terbium_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x0d7a6a)
                .build();

        DysprosiumConcentrate = new Material.Builder(4613, SuSyUtility.susyId('dysprosium_concentrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xa0bd2d)
                .build();

        BastHoErExtract = new Material.Builder(4614, SuSyUtility.susyId('bast_ho_er_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xdeab52)
                .build();
        
        MonaHoErExtract = new Material.Builder(4615, SuSyUtility.susyId('mona_ho_er_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xeba834)
                .build();

        XenoHoErExtract = new Material.Builder(4616, SuSyUtility.susyId('xeno_ho_er_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xc28317)
                .build();
        
        BastErExtract = new Material.Builder(4617, SuSyUtility.susyId('bast_er_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8854a1)
                .build();

        MonaErExtract = new Material.Builder(4618, SuSyUtility.susyId('mona_er_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8e3cb5)
                .build();

        XenoErExtract = new Material.Builder(4619, SuSyUtility.susyId('xeno_er_extract'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x511a6b)
                .build();

        BastTmYbConcentrate = new Material.Builder(4620, SuSyUtility.susyId('bast_tm_yb_concentrate'))
                .liquid()
                .color(0xe68787)
                .build();

        MonaThuliumGroupConcentrate = new Material.Builder(4621, SuSyUtility.susyId('mona_thulium_group_concentrate'))
                .liquid()
                .color(0xe687a0)
                .build();

        XenoThuliumGroupConcentrate = new Material.Builder(4622, SuSyUtility.susyId('xeno_thulium_group_concentrate'))
                .liquid()
                .color(0xbf6980)
                .build();
        
        MonaTmLuConcentrate = new Material.Builder(4623, SuSyUtility.susyId('mona_tm_lu_concentrate'))
                .liquid()
                .color(0xd96684)
                .build();

        XenoTmLuConcentrate = new Material.Builder(4624, SuSyUtility.susyId('xeno_tm_lu_concentrate'))
                .liquid()
                .color(0xcf6380)
                .build();

        BastTmConcentrate = new Material.Builder(4625, SuSyUtility.susyId('bast_tm_concentrate'))
                .liquid()
                .color(0xc24879)
                .build();

        MonaTmConcentrate = new Material.Builder(4626, SuSyUtility.susyId('mona_tm_concentrate'))
                .liquid()
                .color(0xcf3271)
                .build();

        XenoTmConcentrate = new Material.Builder(4627, SuSyUtility.susyId('xeno_tm_concentrate'))
                .liquid()
                .color(0x9e1c50)
                .build();
        
        DigestedThoriumConcentrate = new Material.Builder(4628, SuSyUtility.susyId('digested_thorium_concentrate'))
                .dust()
                .color(0x384a10)
                .build();

        DissolvedThoriumConcentrate = new Material.Builder(4629, SuSyUtility.susyId('dissolved_thorium_concentrate'))
                .liquid()
                .color(0x18520f)
                .build();

        ThoriumExtract = new Material.Builder(4630, SuSyUtility.susyId('thorium_extract'))
                .liquid()
                .color(0x697310)
                .build();

        RoastedBastnasite = new Material.Builder(4631, SuSyUtility.susyId('roasted_bastnasite'))
                .dust()
                .color(0x754c20)
                .build()

        MonaziteLeach = new Material.Builder(4632, SuSyUtility.susyId('monazite_leach'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xed5813)
                .build()
                
        ThoriumConcentrate = new Material.Builder(4633, SuSyUtility.susyId('thorium_concentrate'))
                .dust()
                .color(0x291208)
                .build()

        ThoriumFreeMonaziteLeach = new Material.Builder(4634, SuSyUtility.susyId('thorium_free_monazite_leach'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xf26929)
                .build()

        RareEarthFreeMonaziteLeach = new Material.Builder(4635, SuSyUtility.susyId('rare_earth_free_monazite_leach'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xc1cf86)
                .build()

        RoastedXenotime = new Material.Builder(4636, SuSyUtility.susyId('roasted_xenotime'))
                .dust()
                .color(0x210604)
                .build()
    }
}