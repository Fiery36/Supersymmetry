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

/* Data (%mol)
La: 34
Ce: 50
Pr: 4
Nd: 10.8
Sm: 0.75
Eu: 0.1
Gd: 0.15
Tb: 0.01
Dy: 0.03
Ho: 0.004
Er: 0.004
Tm: 0.001
Yb: 0.001
Lu: 0
Y: 0.15

98.8% LREEs
1% MREEs
0.2% HREEs
*/

MACERATOR.recipeBuilder()
    .inputs(item('susy:resource_block', 7))
    .outputs(metaitem('dustBastnasite') * 4)
    .duration(240)
    .EUt(7)
    .buildAndRegister()

// Bastnasite beneficiation

GRAVITY_SEPARATOR.recipeBuilder()
    .inputs(ore('dustBastnasite'))
    .outputs(metaitem('dustSiftedBastnasite'))
    .chancedOutput(metaitem('dustLimestoneTailings'), 3000, 0)
    .chancedOutput(metaitem('dustBarite'), 500, 0)
    .chancedOutput(metaitem('dustStrontianite'), 100, 0)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSiftedBastnasite') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_bastnasite_slurry') * 2000)
    .duration(80)
    .EUt(480)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
    .notConsumable(fluid('oleic_acid') * 1000)
    .notConsumable(inputs('dustSodaAsh') * 5)
    .fluidInputs(fluid('impure_bastnasite_slurry') * 2000)
    .fluidOutputs(fluid('bastnasite_slurry') * 1000)
    .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
    .duration(80)
    .EUt(480)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('bastnasite_slurry') * 1000)
    .outputs(metaitem('dustFlotatedBastnasite') * 8)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

for (fuel in sintering_fuels) {
    if (!fuel.isPlasma) {
        ROTARY_KILN.recipeBuilder()
            .inputs(ore('dustFlotatedBastnasite') * 2)
            .fluidInputs(fluid('sulfuric_acid') * 3000)
            .outputs(metaitem('dustRoastedBastnasite') * 2)
            .fluidOutputs(fluid('hydrogen_fluoride') * 2000)
            .fluidOutputs(fluid('carbon_dioxide') * 2000)
            .fluidOutputs(fluid('dense_steam') * 2000)
            .duration(80)
            .EUt(120)
            .buildAndRegister()
    }
}   

AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustRoastedBastnasite'))
    .inputs(ore('dustSodiumHydroxide') * 9)
    .fluidInputs(fluid('distilled_water') * 2000)
    .outputs(metaitem('dustBastReHydroxides'))
    .fluidOutputs(fluid('sodium_sulfate_solution') * 2000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

// Bastnasite Concentrate Processing
// RE3+ + 2.5 H2L2 (dimers) -> REL(HL2)2 + 3H+ (acidic organophosphorous extractants)

ROASTER.recipeBuilder()
    .inputs(ore('dustBastReHydroxides'))
    .fluidInputs(fluid('air') * 1200)
    .outputs(metaitem('dustOxidizedBastReHydroxides')) // new
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustOxidizedBastReHydroxides'))
    .fluidInputs(fluid('nitric_acid') * 3000)
    .fluidOutputs(fluid('bast_ox_re_nitrates_solution') * 3000) // new
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('bast_ox_re_nitrates_solution') * 1000)
    .fluidInputs(fluid('tributyl_phosphate') * 1000)
    .fluidOutputs(fluid('cerium_extract') * 1000)
    .fluidOutputs(fluid('bast_ce_free_re_nitrates_solution') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('bast_ce_free_re_nitrates_solution') * 1000)
    .fluidInputs(fluid('P204_extraction_mixture') * 30)
    .fluidOutputs(fluid('bast_lree_concentrate') * 1000)
    .fluidOutputs(fluid('bast_mree_extract') * 30)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 3675)
    .fluidInputs(fluid('bast_mree_extract') * 3000)
    .fluidOutputs(fluid('bast_mree_chlorides_solution') * 3675)
    .fluidOutputs(fluid('spent_P204_extraction_mixture') * 3000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('bast_mree_chlorides_solution') * 3675)
    .fluidInputs(fluid('P507_extraction_mixture') * 500)
    .fluidOutputs(fluid('bast_mree_concentrate') * 3675) // contains 1.5 mol H+
    .fluidOutputs(fluid('bast_hree_extract') * 500)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') * 1225)
    .fluidInputs(fluid('bast_hree_extract') * 1000)
    .fluidOutputs(fluid('bast_hree_concentrate') * 1225)
    .fluidOutputs(fluid('spent_P507_extraction_mixture') * 1000)
    .duration(800)
    .EUt(120)
    .buildAndRegister()

// Bastnasite Element Extraction

// LREE separation
    // La separation
    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustPenteticAcid') * 5)
        .fluidInputs(fluid('bast_lree_concentrate') * 1000) // contains 0.34 La, 0.04 Pr, 0.108 Nd
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 340)
        .fluidOutputs(fluid('bast_didymium_conentrate') * 1000)
        .fluidOutputs(fluid('lanthanium_extract') * 340)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Didymium separation
    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustPenteticAcid') * 5)
        .fluidInputs(fluid('bast_didymium_conentrate') * 1000)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 40)
        .fluidOutputs(fluid('bast_neodymium_concentrate') * 1000)
        .fluidOutputs(fluid('praseodymium_extract') * 40)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Neodymium preciptation
    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide'))
        .fluidInputs(fluid('bast_neodymium_concentrate') * 1000)
        .chancedOutput(metaitem('dustNeodymiumHydroxide') * 7, 1080, 0)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()
    
// MREE separation
    // Europium separation
    BR.recipeBuilder()
        .inputs(ore('dustZinc'))
        .fluidInputs(fluid('bast_mree_concentrate') * 3675)
        .chancedOutput(metaitem('dustZinc'), 9500, 0)
        .fluidOutputs(fluid('reduced_bast_mree_concentrate') * 3675)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('reduced_bast_mree_concentrate') * 3675)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .chancedOutput(metaitem('dustEuropiumIiSulfate'), 6000, 0)
        .fluidOutputs(fluid('bast_sm_gd_concentrate') * 3675) // contains 1.6 mol H+
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Gadolinium separation
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('bast_sm_gd_concentrate') * 3675)
        .fluidInputs(fluid('P507_extraction_mixture') * 375)
        .fluidOutputs(fluid('bast_sm_concentrate') * 3675) // contains 2.725 mol H+
        .fluidOutputs(fluid('gadolinium_extract') * 375)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Samarium separation
    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 18)
        .fluidInputs(fluid('bast_sm_concentrate') * 3675)
        .chancedOutput(metaitem('dustSamariumHydroxide') * 7, 0)
        .fluidOutputs(fluid('wastewater') * 6400)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

// HREE separation
    // Primary purification
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('bast_hree_concentrate') * 1225)
        .fluidInputs(fluid('P507_P204_extraction_mixture') * 1000)
        .fluidOutputs(fluid('acidic_wastewater') * 1225)
        .fluidOutputs(fluid('purified_hree_extract') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('purified_hree_extract') * 500)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidInputs(fluid('nitric_acid') * 100)
        .fluidOutputs(fluid('scrubbed_hree_extract') * 500)
        .fluidOutputs(fluid('acidic_wastewater') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Separate Tb-Dy-Ho-Er-Y (0.198 mol)
    CENTRIFUGE.recipeBuilder() 
        .fluidInputs(fluid('nitric_acid') * 594)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidInputs(fluid('scrubbed_hree_extract') * 500)
        .fluidOutputs(fluid('bast_yttrium_concentrate') * 1000)
        .fluidOutputs(fluid('bast_tm_yb_extract') * 500)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    // Yttrium separation & precipitation
    CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustAmmoniumThiocyanate'))
        .inputs(ore('dustPenteticAcid') * 5)
        .fluidInputs(fluid('bast_yttrium_concentrate') * 1000)
        .fluidInputs(fluid('aliquat_336_extraction_mixture') * 120)
        .fluidOutputs(fluid('bast_yttrium_concentrate') * 1000) // contains 0.36 mol H+
        .fluidOutputs(fluid('bast_terbium_group_extract') * 120)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 3)
        .fluidInputs(fluid('bast_yttrium_concentrate') * 1000)
        .chancedOutput(metaitem('dustYttriumHydroxide') * 7, 1500, 0)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()
        
FLUIDIZED_BED_REACTOR.recipeBuilder()
    .inputs(ore('dustAmmoniumCarbonate') * 42)
    .fluidInputs(fluid('bast_lree_concentrate') * 1000)
    .chancedOutput(metaitem('dustLanthanumCarbonate') * 14, 5200, 0)
    .fluidOutputs(fluid('bast_lafree_lree_concentrate') * 1000)
    .duration(40)
    .EUt(120)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 30)
    .fluidInputs(fluid('bast_lafree_lree_concentrate') * 1000)
    .fluidOutputs(fluid('bast_lafree_lree_hydroxides') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .notConsumable(fluid('sodium_hydroxide') * 432)
    .inputs(ore('dustSodiumChlorate') * 5)
    .fluidInputs(fluid('bast_lafree_lree_hydroxides') * 1000)
    .fluidOutputs(fluid('bast_oxidised_lree_hydroxides') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('bast_oxidised_lree_hydroxides') * 1000)
    .chancedOutput(metaitem('dustPraseodymiumOxide') * 3, 9600, 0)
    .fluidOutputs(fluid('bast_prfree_lree_hydroxides') * 1000)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('bast_prfree_lree_hydroxides') * 1000)
    .chancedOutput(metaitem('dustNeodymiumHydroxide') * 14, 9600, 0)
    .fluidOutputs(fluid('bast_lree_waste') * 1000)
    .duration(80)
    .EUt(16)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSmallZinc') * 6)
    .fluidInputs(fluid('bast_mree_concentrate') * 1000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .chancedOutput(metaitem('dustEuropiumIiSulfate') * 6, 7200, 0)
    .fluidOutputs(fluid('bast_eufree_mree_concentrate') * 1000)
    .duration(100)
    .EUt(120)
    .buildAndRegister()

LCR.recipeBuilder()
    .fluidInputs(fluid('bast_eufree_mree_concentrate') * 1000)
    .fluidInputs(fluid('sodium_amalgam') * 800)
    .fluidOutputs(fluid('samarium_amalgam') * 800)
    .fluidOutputs(fluid('bast_smfree_mree_concentrate') * 1000)
    .duration(80)
    .EUt(480)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .inputs(metaitem('beads.strong_basic_anion_exchange') * 7)
    .fluidInputs(fluid('bast_smfree_mree_concentrate') * 1000)
    .outputs(metaitem('beads.loaded_gadolinium_anion_exchange') * 7)
    .fluidOutputs(fluid('bast_gdfree_mree_concentrate') * 1000)
    .duration(400)
    .EUt(16)
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('dustPotassiumCarbonate') * 18)
    .notConsumable(metaitem('stickPlatinum'))
    .notConsumable(fluid('potassium_hydroxide_solution') * 432)
    .fluidInputs(fluid('bast_gdfree_mree_concentrate') * 1000)
    .chancedOutput(metaitem('dustTerbiumCarbonate') * 14, 3040, 0)
    .fluidOutputs(fluid('bast_tbfree_mree_concentrate') * 1000)
    .duration(100)
    .EUt(1920)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSodiumFluoride') * 6)
    .fluidInputs(fluid('bast_tbfree_mree_concentrate') * 1000)
    .chancedOutput(metaitem('dustDysprosiumFluoride') * 4, 6080, 0)
    .fluidOutputs(fluid('bast_mree_waste') * 1000)
    .duration(80)
    .EUt(120)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('bast_hree_concentrate') * 1000)
    .fluidInputs(fluid('sodium_chromate_solution') * 2000)
    .outputs(metaitem('dustBastHreeDoubleChromates'))
    .fluidOutputs(fluid('yttrium_chloride_solution') * 800)
    .duration(60)
    .EUt(60)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustBastHreeDoubleChromates'))
    .fluidInputs(fluid('hydrochloric_acid') * 4000)
    .fluidOutputs(fluid('bast_yfree_hree_concentrate') * 1000)
    .fluidOutputs(fluid('hydrogen') * 2000)
    .duration(60)
    .EUt(60)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .notConsumable(fluid('two_ethylhexanol') * 1000)
    .fluidInputs(fluid('bast_yfree_hree_concentrate') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 100)
    .fluidInputs(fluid('sodium_dodecyl_sulfate_solution') * 3000)
    .chancedOutput(metaitem('dustErbiumDodecylSulfate'), 5000, 0)
    .fluidOutputs(fluid('bast_erfree_hree_concentrate') * 1000)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .notConsumable(fluid('two_ethylhexanol') * 1000)
    .fluidInputs(fluid('bast_erfree_hree_concentrate') * 3000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 100)
    .fluidInputs(fluid('sodium_dodecyl_sulfate_solution') * 3000)
    .chancedOutput(metaitem('dustHolmiumDodecylSulfate'), 5000, 0)
    .fluidOutputs(fluid('bast_hofree_hree_concentrate') * 1000)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

LCR.recipeBuilder()
    .fluidInputs(fluid('bast_hofree_hree_concentrate') * 1000)
    .fluidInputs(fluid('sodium_amalgam') * 400)
    .fluidOutputs(fluid('ytterbium_amalgam') * 400)
    .fluidOutputs(fluid('bast_ybfree_hree_concentrate') * 1000)
    .duration(80)
    .EUt(480)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .inputs(metaitem('beads.rare_earth_cation_exchange') * 5)
    .fluidInputs(fluid('bast_ybfree_hree_concentrate') * 1000)
    .outputs(metaitem('beads.loaded_thulium_cation_exchange') * 5)
    .fluidOutputs(fluid('bast_tmfree_hree_concentrate') * 1000)
    .duration(400)
    .EUt(16)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .inputs(metaitem('beads.rare_earth_cation_exchange') * 8)
    .fluidInputs(fluid('bast_tmfree_hree_concentrate') * 1000)
    .outputs(metaitem('beads.loaded_lutetium_cation_exchange') * 8)
    .fluidOutputs(fluid('bast_hree_waste') * 1000)
    .duration(400)
    .EUt(16)
    .buildAndRegister()*/