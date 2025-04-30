import globals.Globals
import static globals.SinteringGlobals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

GRAVITY_SEPARATOR = recipemap('gravity_separator')
MIXER = recipemap('mixer')
FROTH_FLOTATION = recipemap('froth_flotation')
CLARIFIER = recipemap('clarifier')
ROASTER = recipemap('roaster')
ROTARY_KILN = recipemap('rotary_kiln')
BR = recipemap('batch_reactor')
BLENDER = recipemap('blender')
FLUIDIZED_BED_REACTOR = recipemap('fluidized_bed_reactor')
ION_EXCHANGE = recipemap('ion_exchange_column')
CENTRIFUGE = recipemap('centrifuge')
LCR = recipemap('large_chemical_reactor')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
SIFTER = recipemap('sifter')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
CRYSTALLIZER = recipemap('crystallizer')

// Waste recycling

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('bast_lree_waste') * 1000)
    .outputs(metaitem('dustPotassiumPermanganate') * 4)
    .outputs(metaitem('dustManganeseIiNitrate') * 12)
    //.outputs(metaitem('dustSodiumNitrate') * 45) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('mona_lree_waste') * 500)
    .outputs(metaitem('dustPotassiumPermanganate') * 20)
    .outputs(metaitem('dustManganeseIiNitrate') * 60)
    //.outputs(metaitem('dustSodiumNitrate') * 27) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 500)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('xeno_lree_waste') * 200)
    .outputs(metaitem('dustPotassiumPermanganate') * 10)
    .outputs(metaitem('dustManganeseIiNitrate') * 30)
    //.outputs(metaitem('dustSodiumNitrate') * 5) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 200)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('bast_mree_waste') * 1000)
    .outputs(metaitem('dustSmallZincCarbonate') * 6)
    .fluidOutputs(fluid('bast_filtered_mree_waste') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('mona_mree_waste') * 1000)
    .outputs(metaitem('dustSmallZincCarbonate') * 6)
    .fluidOutputs(fluid('mona_filtered_mree_waste') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('xeno_mree_waste') * 1000)
    .outputs(metaitem('dustSmallZincCarbonate') * 6)
    .fluidOutputs(fluid('xeno_filtered_mree_waste') * 1000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('bast_filtered_mree_waste') * 1000)
    .chancedOutput(metaitem('dustSodiumFluoride') * 4, 5900, 0)
    .chancedOutput(metaitem('dustSalt') * 10, 8440, 0)
    //.outputs(metaitem('dustRockSalt') * 12) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('mona_filtered_mree_waste') * 1000)
    .chancedOutput(metaitem('dustSodiumFluoride') * 4, 8500, 0)
    .chancedOutput(metaitem('dustSalt') * 6, 9000, 0)
    //.outputs(metaitem('dustRockSalt') * 12) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('xeno_filtered_mree_waste') * 1000)
    .chancedOutput(metaitem('dustSodiumFluoride') * 2, 8400, 0)
    .chancedOutput(metaitem('dustSalt') * 10, 8140, 0)
    //.outputs(metaitem('dustRockSalt') * 12) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('bast_hree_waste') * 1000)
    .outputs(metaitem('dustSodiumChromate') * 14)
    .outputs(metaitem('dustSodiumDodecylSulfate') * 3)
    //.chancedOutput(metaitem('dustSalt') * 8, 8000, 0) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('mona_hree_waste') * 2000)
    .outputs(metaitem('dustSodiumChromate') * 28)
    .outputs(metaitem('dustSmallSodiumDodecylSulfate') * 27)
    //.chancedOutput(metaitem('dustSalt') * 12, 8766, 0) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 2000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('xeno_hree_waste') * 1000)
    .outputs(metaitem('dustSodiumChromate') * 14)
    .outputs(metaitem('dustSmallSodiumDodecylSulfate') * 6)
    // .chancedOutput(metaitem('dustSalt') * 14, 9000, 0) Uncomment when crystallizer has 3 output slots
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('xenotime_phosphate_waste') * 4000)
    .outputs(metaitem('dustSodiumPhosphate') * 16)
    .fluidOutputs(fluid('wastewater') * 4000)
    .duration(40)
    .EUt(30)
    .buildAndRegister()