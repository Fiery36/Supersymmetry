import globals.Globals

BATCH_REACTOR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
ROASTER = recipemap('roaster')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
MACERATOR = recipemap('macerator')
MIXER = recipemap('mixer')
CHEMICAL_BATH = recipemap('chemical_bath')
DISTILLATION_TOWER = recipemap('distillation_tower')

// Silver Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustRawElectrum') * 2], null)

// Aqua Regia * 3000
mods.gregtech.mixer.removeByInput(30, null, [fluid('nitric_acid') * 1000, fluid('hydrochloric_acid') * 2000])
mods.gregtech.blender.removeByInput(30, null, [fluid('nitric_acid') * 1000, fluid('hydrochloric_acid') * 2000])

//GOLD AMALGAMATION (50% EFFICIENCY)
MIXER.recipeBuilder()
    .inputs(ore('dustRawElectrum') * 2)
    .fluidInputs(fluid('mercury') * 1000)
    .outputs(metaitem('dustSilver'))
    .fluidOutputs(fluid('gold_amalgam') * 1000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('gold_amalgam') * 1000)
    .outputs(metaitem('dustGold'))
    .fluidOutputs(fluid('mercury') * 1000)
    .duration(360)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//NATURAL ELECTRUM PURIFICATION VIA PARTING (PRIMITIVE, 67% EFFICIENCY)
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustRawElectrum') * 3)
    .fluidInputs(fluid('nitric_acid') * 4000)
    .outputs(metaitem('dustGold') * 2)
    .fluidOutputs(fluid('silver_nitrate_solution') * 2000)
    .fluidOutputs(fluid('nitrogen_dioxide') * 2000)
    .duration(360)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ADD PLACER DEPOSIT GRAVITY SEPARATION

//MILLER PROCESS (UNIVERSAL, 100%)
BATCH_REACTOR.recipeBuilder()
    .fluidInputs(fluid('raw_electrum') * 144)
    .fluidInputs(fluid('chlorine') * 500)
    .outputs(metaitem('dustSilverChloride'))
    .fluidOutputs(fluid('gold') * 144)
    .duration(120)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

    //ADD MILLER PROCESS FOR OTHER ELECTROREFINING DORES

//CYANIDATION (UNIVERSAL, 100%)
MACERATOR.recipeBuilder()
    .inputs(item('susy:resource_block:11'))
    .outputs(metaitem('dustGoldConcentrate') * 8)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustGoldConcentrate') * 20)
    .fluidInputs(fluid('distilled_water') * 6000)
    .fluidOutputs(fluid('gold_ore_slurry') * 6000)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustSodiumCyanide') * 24)
    .inputs(ore('dustTinyQuicklime'))
    .fluidInputs(fluid('gold_ore_slurry') * 6000)
    .fluidInputs(fluid('air') * 10000)
    .outputs(metaitem('sand.dust') * 16)
    .fluidOutputs(fluid('gold_leach_solution') * 6000)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustAnyPurityCarbon'))
    .fluidInputs(fluid('nitrogen') * 1000)
    .outputs(metaitem('dustActivatedCarbon'))
    .duration(1440)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('dustActivatedCarbon') * 4)
    .fluidInputs(fluid('gold_leach_solution') * 6000)
    .outputs(metaitem('dustLoadedCarbon') * 4)
    .fluidOutputs(fluid('sodium_hydroxide_solution') * 4000)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustSodiumCyanide'))
    .inputs(ore('dustSodiumHydroxide'))
    .fluidInputs(fluid('distilled_water') * 9000)
    .fluidOutputs(fluid('gold_eluent') * 9000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('dustLoadedCarbon'))
    .fluidInputs(fluid('gold_eluent') * 1000)
    .outputs(metaitem('dustSpentActivatedCarbon'))
    .fluidOutputs(fluid('gold_elute_solution') * 1000)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('dustSpentActivatedCarbon'))
    .fluidInputs(fluid('hydrochloric_acid') * 5)
    .outputs(metaitem('dustWashedActivatedCarbon'))
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustWashedActivatedCarbon'))
    .fluidInputs(fluid('air') * 100)
    .outputs(metaitem('dustActivatedCarbon'))
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('wireFineSteel') * 8)
    .notConsumable(ore('plateStainlessSteel') * 8)
    .notConsumable(ore('platePlastic') * 8)
    .fluidInputs(fluid('gold_elute_solution') * 1000)
    .outputs(metaitem('wireFineGoldPlatedSteel') * 16)
    .fluidOutputs(fluid('oxygen') * 500)
    .fluidOutputs(fluid('mixed_cyanide_solution') * 500)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('mixed_cyanide_solution') * 500)
    .outputs(metaitem('dustSodiumCyanide') * 3)
    .fluidOutputs(fluid('water') * 500)
    .fluidOutputs(fluid('gtfo_hydrogen_cyanide') * 1000)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('wireFineGoldPlatedSteel') * 16)
    .fluidInputs(fluid('nitric_acid') * 6000)
    .outputs(metaitem('dustGold'))
    .fluidOutputs(fluid('nitrogen_dioxide') * 3000)
    .fluidOutputs(fluid('iron_iii_nitrate_solution') * 3000)
    .duration(40)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('iron_iii_nitrate_solution') * 6000)
    .outputs(metaitem('dustIronIiiOxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 6000)
    .fluidOutputs(fluid('nitrogen_dioxide') * 6000)
    .fluidOutputs(fluid('oxygen') * 3000)
    .duration(80)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//PURIFIED GOLD (SPECIALIZED)
CSTR.recipeBuilder()
    .fluidInputs(fluid('hydrogen_chloride') * 150)
    .fluidInputs(fluid('nitric_acid') * 50)
    .fluidOutputs(fluid('aqua_regia') * 200)
    .duration(6)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustGold') * 3)
    .fluidInputs(fluid('aqua_regia') * 16000)
    .fluidOutputs(fluid('chloroauric_acid_solution') * 1000)
    .chancedOutput(metaitem('dustSilverChloride'), 1000, 0)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('chloroauric_acid_solution') * 1000)
    .outputs(metaitem('dustChloroauricAcid') * 15)
    .fluidOutputs(fluid('dense_steam') * 6500)
    .fluidOutputs(fluid('nitrogen_dioxide') * 1000)
    .fluidOutputs(fluid('oxygen') * 500)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustChloroauricAcid') * 5)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('hydrochloric_acid') * 2000)
    .fluidOutputs(fluid('wohlwill_electrolyte') * 1000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('plateGold'))
    .fluidInputs(fluid('wohlwill_electrolyte') * 250)
    .notConsumable(metaitem('plateTitanium'))
    .notConsumable(fluid('wohlwill_electrolyte') * 1000)
    .outputs(metaitem('dustHighPurityGold'))
    .chancedOutput(metaitem('anode_slime.gold'), 600, 0)
    .fluidOutputs(fluid('spent_wohlwill_electrolyte') * 250)
    .duration(480)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('plateGold'))
    .fluidInputs(fluid('wohlwill_electrolyte') * 250)
    .notConsumable(metaitem('plateHighPurityGold'))
    .notConsumable(fluid('wohlwill_electrolyte') * 1000)
    .outputs(metaitem('dustHighPurityGold'))
    .chancedOutput(metaitem('anode_slime.gold'), 600, 0)
    .fluidOutputs(fluid('spent_wohlwill_electrolyte') * 250)
    .duration(560)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .fluidInputs(fluid('spent_wohlwill_electrolyte') * 2000)
    .fluidInputs(fluid('sulfur_dioxide') * 3000)
    .outputs(metaitem('dustGold'))
    .fluidOutputs(fluid('acidic_wastewater') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

    //Au3+ + 3e- --> Au
    //SO2 + 2H2O --> SO4 2- + 4H+ + 2e-
    //2 Au3+ + 3SO2 + 6H2O --> 3SO4 2- + 12H+
    //in solution containing 2 H+, 8 Cl-, 4 HCl
    //added products: 3 SO4 2-, 12 H+
    //final solution: 12 HCl, 3 H2SO4, 8 H2O

//ANODE SLIME PROCESSING
BATCH_REACTOR.recipeBuilder()
    .inputs(metaitem('anode_slime.silver'))
    .fluidInputs(fluid('aqua_regia') * 16000)
    .fluidOutputs(fluid('chloroauric_acid_solution') * 1000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(metaitem('anode_slime.gold'))
    .fluidInputs(fluid('nitric_acid') * 2000)
    .chancedOutput(metaitem('dustPgmConcentrate'), 1000, 0)
    .fluidOutputs(fluid('silver_nitrate_solution') * 1000)
    .fluidOutputs(fluid('nitrogen_dioxide') * 1000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()
