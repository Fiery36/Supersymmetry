import globals.Globals
import static globals.SinteringGlobals.*

GRAVITY_SEPARATOR = recipemap('gravity_separator')
MIXER = recipemap('mixer')
FROTH_FLOTATION = recipemap('froth_flotation')
CLARIFIER = recipemap('clarifier')
ROASTER = recipemap('roaster')
ROTARY_KILN = recipemap('rotary_kiln')
BR = recipemap('batch_reactor')
FLUIDIZED_BED_REACTOR = recipemap('fluidized_bed_reactor')
ION_EXCHANGE = recipemap('ion_exchange_column')
CENTRIFUGE = recipemap('centrifuge')
LCR = recipemap('large_chemical_reactor')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
SIFTER = recipemap('sifter')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
CRYSTALLIZER = recipemap('crystallizer')
MACERATOR = recipemap('macerator')
AUTOCLAVE = recipemap('autoclave')
CENTRIFUGE = recipemap('centrifuge')

/* REE Data (%mol)
La: 23.4
Ce: 45.5
Pr: 4.1
Nd: 15.3
Sm: 3
Eu: 0.1
Gd: 1.9
Tb: 0.08
Dy: 0.9
Ho: 0.09
Er: 0.42
Tm: 0.42
Yb: 0.42
Lu: 0.07
Y: 4.3

88.3% LREEs
5% MREEs
6.7% HREEs

90% REEs, 8% ThO2, 0.3% UO2, 1.6% FeTiO3, 0.1% ZrO2
*/

MACERATOR.recipeBuilder()
    .inputs(item('susy:resource_block', 6))
    .outputs(metaitem('dustMonazite') * 4)
    .duration(240)
    .EUt(7)
    .buildAndRegister()

// Monazite beneficiation

MIXER.recipeBuilder()
    .inputs(ore('dustMonazite'))
    .fluidInputs(fluid('hot_sulfuric_acid') * 1000)
    .fluidOutputs(fluid('monazite_leach') * 1000)
    .duration(120)
    .EUt(480)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('monazite_leach') * 1000)
    .chancedOutput(metaitem('dustIlmenite'), 1600, 0)
    .chancedOutput(metaitem('dustZircon'), 100, 0)
    .fluidOutputs(fluid('sifted_monazite_leach') * 1000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sifted_monazite_leach') * 1000)
    .fluidInputs(fluid('ammonia_solution') * 100)
    .outputs(metaitem('dustThoriumConcentrate')) // contains 0.08 mol Th, 0.05 mol REE
    .fluidOutputs(fluid('thorium_free_monazite_leach') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 9)
    .fluidInputs(fluid('thorium_free_monazite_leach') * 1000)
    .chancedOutput(metaitem('dustMonaReHydroxides'), 8500, 0)
    .fluidOutputs(fluid('rare_earth_free_monazite_leach') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

LCR.recipeBuilder()
    .fluidInputs(fluid('rare_earth_free_monazite_leach') * 1000)
    .fluidInputs(fluid('ammonia_solution') * 3)
    .fluidInputs(fluid('oxygen') * 3)
    .chancedOutput(metaitem('dustAmmoniumDiuranate'), 285, 0)
    .fluidOutputs(fluid('wastewater') * 1003)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

// Monazite Concentrate Processing
// RE3+ + 2.5 H2L2 (dimers) -> REL(HL2)2 + 3H+ (acidic organophosphorous extractants)

ROASTER.recipeBuilder()
    .inputs(ore('dustMonaReHydroxides'))
    .fluidInputs(fluid('air') * 1080)
    .outputs(metaitem('dustOxidizedMonaReHydroxides'))
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustOxidizedMonaReHydroxides'))
    .fluidInputs(fluid('nitric_acid') * 3000)
    .fluidOutputs(fluid('mona_ox_re_nitrates_solution') * 3000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('mona_ox_re_nitrates_solution') * 1000)
    .fluidInputs(fluid('tributyl_phosphate') * 910)
    .fluidOutputs(fluid('cerium_extract') * 910)
    .fluidOutputs(fluid('mona_ce_free_re_nitrates_solution') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('mona_ce_free_re_nitrates_solution') * 1000)
    .fluidInputs(fluid('P204_extraction_mixture') * 2925)
    .fluidOutputs(fluid('mona_lree_concentrate') * 1000) // contains 0.351 mol H+
    .fluidOutputs(fluid('mona_mree_extract') * 2925)
    .duration(40)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 4245)
    .fluidInputs(fluid('mona_mree_extract') * 29250) // MREE/HREEs enriched tenfold
    .fluidOutputs(fluid('mona_mree_chlorides_solution') * 4245)
    .fluidOutputs(fluid('spent_P204_extraction_mixture') * 29250)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('mona_mree_chlorides_solution') * 4245)
    .fluidInputs(fluid('P507_extraction_mixture') * 16750)
    .fluidOutputs(fluid('mona_mree_concentrate') * 4245) // contains 2.01 mol H+
    .fluidOutputs(fluid('mona_hree_extract') * 16750)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 2430)
    .fluidInputs(fluid('mona_hree_extract') * 16750)
    .fluidOutputs(fluid('mona_hree_concentrate') * 2430)
    .fluidOutputs(fluid('spent_P507_extraction_mixture') * 16750)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

// Monazite Element Extraction Tier 1 (EV)

// LREE separation
    // La: 0.234
    // Pr: 0.041
    // Nd: 0.153

    CRYSTALLIZER.recipeBuilder()
        .inputs(ore('dustAmmoniumCarbonate') * 15)
        .inputs(ore('dustSodiumHydroxide'))
        .fluidInputs(fluid('mona_lree_concentrate') * 1000)
        .chancedOutput(metaitem('dustLanthanumCarbonate') * 14, 2340, 0)
        .outputs(metaitem('dustMonaPrNdHydroxides'))
        .fluidOutputs(fluid('carbon_dioxide') * 175)
        .duration(2000)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(fluid('potassium_hydroxide') * 4320)
        .inputs(ore('dustMonaPrNdHydroxides') * 10)
        .inputs(ore('dustTinyPotassiumChlorate'))
        .outputs(metaitem('dustOxidizedMonaPrNdConcentrate') * 10)
        .duration(2000)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustOxidizedMonaPrNdConcentrate'))
        .fluidInputs(fluid('hydrochloric_acid') * 459)
        .chancedOutput(metaitem('dustPraseodymiumIvOxide') * 3, 41, 0)
        .fluidOutputs(fluid('neodymium_chloride_solution') * 459)
        .duration(2000)
        .EUt(120)
        .buildAndRegister()

// MREE separation
    // Sm: 0.3
    // Eu: 0.01
    // Gd: 0.19

    BR.recipeBuilder()
        .inputs(ore('dustZinc'))
        .fluidInputs(fluid('mona_mree_concentrate') * 4245)
        .chancedOutput(metaitem('dustZinc'), 9950, 0)
        .fluidOutputs(fluid('mona_reduced_mree_concentrate') * 4245)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('mona_reduced_mree_concentrate') * 4245)
        .fluidInputs(fluid('sulfuric_acid') * 10)
        .chancedOutput(metaitem('dustEuropiumIiSulfate'), 600, 0)
        .fluidOutputs(fluid('mona_sm_gd_concentrate') * 4245) // contains 2.03 mol H+
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    LCR.recipeBuilder()
        .fluidInputs(fluid('mona_sm_gd_concentrate') * 4245)
        .fluidInputs(fluid('sodium_amalgam') * 300)
        .fluidOutputs(fluid('samarium_amalgam') * 300)
        .fluidOutputs(fluid('mona_gd_concentrate') * 4245)
        .duration(2000)
        .EUt(480)
        .buildAndRegister()

    ION_EXCHANGE.recipeBuilder()
        .inputs(metaitem('beads.strong_basic_anion_exchange') * 19)
        .fluidInputs(fluid('mona_gd_concentrate') * 4245)
        .outputs(metaitem('beads.loaded_gadolinium_anion_exchange') * 19)
        .fluidOutputs(fluid('wastewater') * 4245)
        .duration(400)
        .EUt(16)
        .buildAndRegister()

// monanasite Element Extraction Tier 2 (IV)

// LREE separation
    // La: 0.234
    // Pr: 0.041
    // Nd: 0.153

    CENTRIFUGE.recipeBuilder()
    .inputs(ore('dustPenteticAcid') * 5)
    .fluidInputs(fluid('mona_lree_concentrate') * 1000)
    .fluidInputs(fluid('aliquat_336_extraction_mixture') * 2340)
    .fluidOutputs(fluid('mona_didymium_conentrate') * 1000)
    .fluidOutputs(fluid('lanthanium_extract') * 2340)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

    // Didymium separation
    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustPenteticAcid') * 5)
        .fluidInputs(fluid('mona_didymium_concentrate') * 1000)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 41)
        .fluidOutputs(fluid('mona_neodymium_concentrate') * 1000)
        .fluidOutputs(fluid('praseodymium_extract') * 41)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Neodymium preciptation
    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide'))
        .fluidInputs(fluid('mona_neodymium_concentrate') * 1000)
        .chancedOutput(metaitem('dustNeodymiumHydroxide') * 7, 1530, 0)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

// MREE separation
    // Sm: 0.3
    // Eu: 0.01
    // Gd: 0.19

    // Europium separation same as tier 1

    // Gadolinium separation
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_sm_gd_concentrate') * 4245)
        .fluidInputs(fluid('P507_extraction_mixture') * 4750)
        .fluidOutputs(fluid('mona_sm_concentrate') * 4245) // contains 2.6 mol H+
        .fluidOutputs(fluid('gadolinium_extract') * 4750)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Samarium precipitation
    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 9)
        .fluidInputs(fluid('mona_sm_concentrate') * 4245)
        .chancedOutput(metaitem('dustSamariumHydroxide') * 7, 3000, 0)
        .fluidOutputs(fluid('wastewater') * 6845)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

// HREE separation
    // Tb: 0.008
    // Dy: 0.09
    // Ho: 0.009
    // Er: 0.042
    // Tm: 0.042
    // Yb: 0.042
    // Lu: 0.007
    // Y: 0.43
    // Per 2430L of monazite HREE concentrate
    // Total: 0.67 moles of HREEs

    // Primary purification
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_hree_concentrate') * 1215)
        .fluidInputs(fluid('P507_P224_extraction_mixture') * 8375)
        .fluidOutputs(fluid('acidic_wastewater') * 1215)
        .fluidOutputs(fluid('mona_purified_hree_extract') * 8375)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_purified_hree_extract') * 8375)
        .fluidInputs(fluid('distilled_water') * 5000)
        .fluidInputs(fluid('nitric_acid') * 100)
        .fluidOutputs(fluid('mona_scrubbed_hree_extract') * 8375)
        .fluidOutputs(fluid('acidic_wastewater') * 5000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Separate Tb-Dy-Ho-Er-Y (0.579 mol)
    CENTRIFUGE.recipeBuilder() 
        .fluidInputs(fluid('nitric_acid') * 890)
        .fluidInputs(fluid('distilled_water') * 500)
        .fluidInputs(fluid('mona_scrubbed_hree_extract') * 8375)
        .fluidOutputs(fluid('mona_yttrium_group_concentrate') * 500)
        .fluidOutputs(fluid('mona_thullium_group_extract') * 8375)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Yttrium separation & precipitation
    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustAmmoniumThiocyanate'))
        .inputs(ore('dustPenteticAcid') * 5)
        .fluidInputs(fluid('mona_yttrium_group_concentrate') * 1000)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 1490)
        .fluidOutputs(fluid('mona_yttrium_concentrate') * 1000)
        .fluidOutputs(fluid('mona_terbium_group_extract') * 1490)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSmallSodiumHydroxide') * 6)
        .fluidInputs(fluid('mona_yttrium_concentrate') * 1000)
        .chancedOutput(metaitem('dustYttriumHydroxide') * 7, 4300, 0)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Terbium group separation
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_terbium_group_extract') * 1490)
        .fluidInputs(fluid('distilled_water') * 149)
        .fluidOutputs(fluid('aliquat_336_extraction_mixture') * 1490)
        .fluidOutputs(fluid('mona_terbium_group_concentrate') * 149)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_terbium_group_concentrate') * 149)
        .fluidInputs(fluid('P507_P224_extraction_mixture') * 3725)
        .fluidOutputs(fluid('acidic_wastewater') * 149)
        .fluidOutputs(fluid('mona_purified_terbium_group_extract') * 3725)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_purified_terbium_group_extract') * 3725)
        .fluidInputs(fluid('hydrochloric_acid') * 106)
        .fluidOutputs(fluid('mona_scrubbed_terbium_group_extract') * 3725)
        .fluidOutputs(fluid('mona_terbium_concentrate') * 106)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('mona_terbium_concentrate') * 13250)
        .inputs(ore('dustSodiumHydroxide') * 9)
        .outputs(metaitem('dustTerbiumHydroxide') * 7)
        .fluidOutputs(fluid('wastewater') * 13250)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('diluted_hydrochloric_acid') * 540)
        .fluidInputs(fluid('mona_scrubbed_terbium_group_extract') * 3725)
        .fluidOutputs(fluid('dysprosium_concentrate') * 540)
        .fluidOutputs(fluid('mona_ho_er_extract') * 3725)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_ho_er_extract') * 3725)
        .fluidInputs(fluid('hydrochloric_acid') * 27)
        .fluidOutputs(fluid('mona_er_extract') * 3725)
        .fluidOutputs(fluid('holmium_chloride_solution') * 27)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_er_extract') * 3725)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 126)
        .fluidOutputs(fluid('mona_holmium_concentrate') * 3725)
        .fluidOutputs(fluid('erbium_sulfate_solution') * 126)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('mona_thullium_group_extract') * 8375)
        .fluidInputs(fluid('hydrochloric_acid') * 273)
        .fluidOutputs(fluid('spent_P507_P224_extraction_mixture') * 8375)
        .fluidOutputs(fluid('mona_thullium_group_concentrate') * 273)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    LCR.recipeBuilder()
        .fluidInputs(fluid('mona_thulium_group_concentrate') * 273)
        .fluidInputs(fluid('sodium_amalgam') * 42)
        .fluidOutputs(fluid('ytterbium_amalgam') * 42)
        .fluidOutputs(fluid('mona_tm_lu_concentrate') * 273)
        .duration(80)
        .EUt(480)
        .buildAndRegister()

    ION_EXCHANGE.recipeBuilder()
        .fluidInputs(fluid('mona_tm_lu_concentrate') * 273)
        .inputs(metaitem('beads.loaded_lutetium_cation_exchange') * 7)
        .fluidOutputs(fluid('mona_thulium_concentrate') * 273)
        .outputs(metaitem('beads.rare_earth_cation_exchange') * 7)
        .duration(400)
        .EUt(16)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 9)
        .fluidInputs(fluid('mona_thulium_concentrate') * 6500)
        .chancedOutput(metaitem('dustThuliumHydroxide') * 7)
        .fluidOutputs(fluid('wastewater') * 6500)
        .duration(80)
        .EUt(120)
        .buildAndRegister()
