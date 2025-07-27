import globals.Globals

MIXER = recipemap('mixer')
SINTERING_OVEN = recipemap('sintering_oven')
BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
ROASTER = recipemap('roaster')
DISTILLERY = recipemap('distillery')
DT = recipemap('distillation_tower')
DRYER = recipemap('dryer')
AUTOCLAVE = recipemap('autoclave')
ION_EXCHANGE = recipemap('ion_exchange_column')
FBR = recipemap('fixed_bed_reactor')
LCR = recipemap('large_chemical_reactor')
ASSEMBLER = recipemap('assembler')
ALLOY_SMELTER = recipemap('alloy_smelter')

// Alumina supports

MIXER.recipeBuilder()
    .inputs(ore('dustAmmoniumHexachloroplatinate') * 17)
    .fluidInputs(fluid('phosphoric_acid') * 1000)
    .fluidOutputs(fluid('platinum_precursor_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(ore('dustAlumina') * 5)
    .fluidInputs(fluid('platinum_precursor_solution') * 1000)
    .outputs(metaitem('dustSupportedPlatinum'))
    .fluidOutputs(fluid('phosphoric_acid') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPalladiumChloride') * 3)
    .fluidInputs(fluid('phosphoric_acid') * 1000)
    .fluidOutputs(fluid('palladium_precursor_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(ore('dustAlumina') * 5)
    .fluidInputs(fluid('palladium_precursor_solution') * 1000)
    .outputs(metaitem('dustSupportedPalladium'))
    .fluidOutputs(fluid('phosphoric_acid') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(ore('dustAlumina') * 5)
    .fluidInputs(fluid('nickel_nitrate_solution') * 1000)
    .outputs(metaitem('dustSupportedNickel'))
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustSupportedNickel'))
    .fluidInputs(fluid('hydrogen_sulfide') * 100)
    .outputs(metaitem('dustHydrotreatingCatalyst'))
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Tungsten source

ROASTER.recipeBuilder()
    .inputs(ore('dustAmmoniumParatungstate'))
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('ammonium_metatungstate_solution') * 4000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('ammonium_metatungstate_solution') * 4000)
    .outputs(metaitem('dustAmmoniumMetatungstate'))
    .fluidOutputs(fluid('ammonia_solution') * 4000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Isomerization catalysts

BR.recipeBuilder()
    .inputs(ore('dustSupportedPlatinum'))
    .fluidInputs(fluid('hydrogen_chloride') * 100)
    .outputs(metaitem('dustChloridedAlumina'))
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustZirconiumDioxide') * 3)
    .inputs(ore('dustAmmoniumHexachloroplatinate'))
    .fluidInputs(fluid('aluminium_sulfate_solution') * 6000)
    .outputs(metaitem('dustSulfatedMetalOxide'))
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Olefin condensation catalysts

    // SHOP process catalyst

    BR.recipeBuilder()
        .inputs(ore('dustNickelIiOxide') * 2)
        .fluidInputs(fluid('nitric_acid') * 2000)
        .fluidOutputs(fluid('nickel_nitrate_solution') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('nickel_nitrate_solution') * 1000)
        .outputs(metaitem('dustNickelIiNitrate') * 9)
        .fluidOutputs(fluid('water') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustNickelIiNitrate') * 9)
        .fluidInputs(fluid('acetylacetone') * 2000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
        .fluidOutputs(fluid('nickel_ii_bisacetylacetonate_solution') * 2000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .fluidInputs(fluid('nickel_ii_bisacetylacetonate_solution') * 2000)
        .outputs(metaitem('dustNickelIiBisacetylacetonate'))
        .outputs(metaitem('dustSodiumNitrate') * 10)
        .fluidOutputs(fluid('dense_steam') * 2000)
        .duration(120)
        .EUt(480)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustNickelIiBisacetylacetonate'))
        .fluidInputs(fluid('cyclooctadiene') * 2000)
        .fluidInputs(fluid('triethylaluminium') * 2000)
        .outputs(metaitem('dustBiscyclooctadienenickelZero'))
        .fluidOutputs(fluid('ethane') * 1000)
        .fluidOutputs(fluid('ethylene') * 1000)
        .fluidOutputs(fluid('diethylaluminium_acetylacetonate') * 2000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('diethylaluminium_acetylacetonate') * 1000)
        .fluidInputs(fluid('hydrochloric_acid') * 3000)
        .fluidOutputs(fluid('aluminium_chloride_solution') * 3000)
        .fluidOutputs(fluid('acetylacetone') * 1000)
        .fluidOutputs(fluid('ethylene') * 2000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('aluminium_chloride_solution') * 3000)
        .outputs(metaitem('dustAluminiumChloride') * 4)
        .fluidOutputs(fluid('water') * 3000)
        .EUt(Globals.voltAmps[1])
        .duration(20)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustTriphenylphosphine'))
        .fluidInputs(fluid('phosphorus_trichloride') * 500)
        .fluidOutputs(fluid('chlorodiphenylphosphine') * 1500)
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('chlorodiphenylphosphine') * 50)
        .fluidInputs(fluid('acetic_acid') * 50)
        .notConsumable(fluid('sodium_hydroxide_solution') * 50)
        .fluidOutputs(fluid('diphenylphosphinoacetic_acid') * 50)
        .duration(10)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustBiscyclooctadienenickelZero'))
        .fluidInputs(fluid('diphenylphosphinoacetic_acid') * 1000)
        .fluidInputs(fluid('ethylene_glycol') * 1000)
        .fluidOutputs(fluid('shell_higher_olefin_catalyst_solution') * 1000)
        .duration(200)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    // SPA catalysts for gasoline polymerate

    MIXER.recipeBuilder()
        .inputs(ore('dustDiatomite'))
        .fluidInputs(fluid('phosphoric_acid') * 1700)
        .outputs(metaitem('dustWetSolidPhosphoricAcid'))
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
        
    DRYER.recipeBuilder()
        .inputs(ore('dustWetSolidPhosphoricAcid'))
        .outputs(metaitem('dustSolidPhosphoricAcid'))
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    // Hydrocracking catalyst

    AUTOCLAVE.recipeBuilder()
        .fluidInputs(fluid('sodium_silicate_solution') * 1000)
        .fluidInputs(fluid('aluminium_sulfate_solution') * 100)
        .outputs(metaitem('dustAmorphousSilicaAlumina'))
        .fluidOutputs(fluid('wastewater') * 1100)
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustHighPurityCobaltOxide') * 2)
        .fluidInputs(fluid('nitric_acid') * 2000)
        .fluidOutputs(fluid('cobalt_nitrate_solution') * 1000)
        .duration(60)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .inputs(ore('dustAmorphousSilicaAlumina') * 10)
        .inputs(ore('dustAmmoniumMetatungstate'))
        .fluidInputs(fluid('cobalt_nitrate_solution') * 2000)
        .outputs(metaitem('hydrocracking_catalyst') * 10)
        .duration(200)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

// Syngas WGSR catalysts

ROASTER.recipeBuilder()
    .inputs(ore('dustChromiumTrioxide') * 1)
    .inputs(ore('dustIronIiiOxide') * 12)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
    .outputs(metaitem('dustHtsCatalyst'))
    .duration(200)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustZincOxide') * 1)
    .inputs(ore('dustCupricOxide') * 1)
    .inputs(ore('dustAlumina') * 1)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
    .outputs(metaitem('dustLtsCatalyst'))
    .duration(200)
    .EUt(30)
    .buildAndRegister()

// Fischer-Tropsch catalysts

    // Low-temperature Fischer-Tropsch catalyst

    BR.recipeBuilder()
        .inputs(ore('dustSiliconDioxide') * 3)
        .inputs(ore('dustPotassiumCarbonate') * 2)
        .inputs(ore('dustAlumina'))
        .fluidInputs(fluid('iron_iii_nitrate_solution') * 1000)
        .fluidOutputs(fluid('ltft_catalyst_solution') * 1000)
        .duration(100)
        .EUt(120)
        .buildAndRegister();

    ROASTER.recipeBuilder()
        .fluidInputs(fluid('ltft_catalyst_solution') * 1000)
        .outputs(metaitem('dustLtftCatalyst'))
        .fluidOutputs(fluid('dense_steam') * 1000)
        .duration(100)
        .EUt(120)
        .buildAndRegister();

    // High-temperature Fischer-Tropsch catalyst

    SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustIronIiiOxide') * 5)
        .inputs(ore('dustPotassiumCarbonate') * 2)
        .inputs(ore('dustAlumina'))
        .outputs(metaitem('dustHtftCatalyst'))
        .duration(400)
        .EUt(120)
        .buildAndRegister();

// Methanol catalyst

BR.recipeBuilder()
    .inputs(ore('dustZincChloride') * 3)
    .fluidInputs(fluid('soda_ash_solution') * 1000)
    .outputs(metaitem('dustZincCarbonate') * 5)
    .fluidOutputs(fluid('concentrated_salt_water') * 1000)
    .duration(100)
    .EUt(120)
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustCopperIiChloride') * 3)
    .fluidInputs(fluid('soda_ash_solution') * 1000)
    .outputs(metaitem('dustCopperCarbonate') * 5)
    .fluidOutputs(fluid('concentrated_salt_water') * 1000)
    .duration(100)
    .EUt(120)
    .buildAndRegister();


ROASTER.recipeBuilder()
    .inputs(ore('dustCopperCarbonate') * 10)
    .inputs(ore('dustZincCarbonate') * 5)
    .inputs(ore('dustChromiumTrioxide') * 4)
    .outputs(metaitem('dustCopperZincChromiumOxide'))
    .fluidOutputs(fluid('carbon_dioxide') * 3000)
    .duration(40)
    .EUt(40)
    .buildAndRegister()

//RuO2

ROASTER.recipeBuilder()
    .inputs(ore('dustRuthenium'))
    .fluidInputs(fluid('chlorine') * 3000)
    .outputs(metaitem('dustRutheniumIiiChloride') * 4)
    .duration(200)
    .EUt(480)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustRutheniumIiiChloride') * 4)
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('dustRutheniumIvOxide') * 3)
    .fluidOutputs(fluid('chlorine') * 3000)
    .duration(200)
    .EUt(480)
    .buildAndRegister()

//Wustite Catalyst for Haber Process
ROASTER.recipeBuilder()
    .fluidInputs(fluid('monoxide_rich_syngas') * 1000)
    .inputs(ore('dustMagnetite'))
    .outputs(metaitem('dustWustiteCatalyst') * 5)
    .duration(400)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('hydrogen_rich_syngas') * 1000)
    .inputs(ore('dustMagnetite'))
    .outputs(metaitem('dustWustiteCatalyst') * 5)
    .duration(400)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//Pd-Rh Catalyst for Haber Process
MIXER.recipeBuilder()
    .inputs(ore('dustPlatinum') * 9)
    .inputs(ore('dustRhodium') * 1)
    .outputs(metaitem('dustPlatinumRhodium') * 10)
    .duration(800)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFinePlatinumRhodium') * 16)
    .outputs(metaitem('mesh.platinum_rhodium'))
    .EUt(120)
    .duration(160)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFinePlatinum') * 16)
    .outputs(metaitem('mesh.platinum'))
    .circuitMeta(3)
    .EUt(120)
    .duration(160)
    .buildAndRegister()

// Dicobalt Octacarbonyl

ROASTER.recipeBuilder()
    .inputs(ore('dustAnyPurityCobalt') * 2)
    .fluidInputs(fluid('carbon_monoxide') * 8000)
    .outputs(metaitem('dustDicobaltOctacarbonyl') * 18)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Impregnated Alumina Catalyst

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('dustSilicaGel') * 3)
    .inputs(ore('dustAlumina') * 5)
    .outputs(metaitem('dustImpregnatedAluminaCatalyst') * 8)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()