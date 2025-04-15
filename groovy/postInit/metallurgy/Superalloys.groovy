import globals.Globals
import postInit.utils.RecyclingHelper

ABS = recipemap('alloy_blast_smelter')
ASSEMBLER = recipemap('assembler')

ABS.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('dustIron') * 12)
    .inputs(ore('dustNickel') * 8)
    .inputs(ore('dustChrome') * 12)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustCopper') * 2)
    .inputs(ore('dustNiobium') * 1)
    .inputs(ore('dustTantalum') * 1)
    .inputs(ore('dustMolybdenum') * 2)
    .fluidOutputs(fluid('incoloy_twenty') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('dustIron') * 9)
    .inputs(ore('dustNickel') * 16)
    .inputs(ore('dustChrome') * 7)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustCopper') * 2)
    .inputs(ore('dustAluminium') * 1)
    .inputs(ore('dustTitanium') * 1)
    .inputs(ore('dustMolybdenum') * 2)
    .fluidOutputs(fluid('incoloy_eight_two_five') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('dustAluminium') * 1)
    .inputs(ore('dustCobalt') * 1)
    .inputs(ore('dustIron') * 20)
    .inputs(ore('dustNickel') * 30)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustTitanium') * 2)
    .inputs(ore('dustTungsten') * 1)
    .inputs(ore('dustNiobium') * 2)
    .fluidOutputs(fluid('incoloy_nine_zero_eight') * 8640)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('dustAluminium') * 3)
    .inputs(ore('dustCobalt') * 4)
    .inputs(ore('dustNickel') * 22)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustTungsten') * 2)
    .inputs(ore('dustHafnium') * 1)
    .inputs(ore('dustRhenium') * 2)
    .inputs(ore('dustTantalum') * 3)
    .fluidOutputs(fluid('rene') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('dustNickel') * 23)
    .inputs(ore('dustManganese') * 2)
    .inputs(ore('dustCopper') * 10)
    .inputs(ore('dustAluminium') * 4)
    .inputs(ore('dustTitanium') * 1)
    .fluidOutputs(fluid('monel') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('dustIron') * 2)
    .inputs(ore('dustNickel') * 2)
    .inputs(ore('dustCobalt') * 15)
    .inputs(ore('dustChrome') * 13)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustTungsten') * 7)
    .fluidOutputs(fluid('stellite_j') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('dustNickel') * 1)
    .inputs(ore('dustCobalt') * 24)
    .inputs(ore('dustChrome') * 10)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustTungsten') * 3)
    .inputs(ore('dustMolybdenum') * 1)
    .fluidOutputs(fluid('stellite_six') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('dustIron') * 39)
    .inputs(ore('dustManganese') * 1)
    .fluidOutputs(fluid('hsla_eighty_x') * 5760)
        .blastFurnaceTemp(2600)
    .duration(3000)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('dustIron') * 24)
    .inputs(ore('dustNickel') * 5)
    .inputs(ore('dustChrome') * 8)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustMolybdenum') * 2)
    .fluidOutputs(fluid('food_grade_stainless_steel') * 5760)
        .blastFurnaceTemp(2600)
    .duration(3000)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

static def removeItemsOfAlloy(String itemCategory) {
    mods.jei.ingredient.removeAndHide(metaitem('ingot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('ingotHot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dust' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustSmall' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustTiny' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('plate' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('stick' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('nugget' + itemCategory));
}

static def removeItemsOfAlloyNoRod(String itemCategory) {
    mods.jei.ingredient.removeAndHide(metaitem('ingot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('ingotHot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dust' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustSmall' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustTiny' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('plate' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('nugget' + itemCategory));
}

removeItemsOfAlloy('HastelloyC276');
removeItemsOfAlloy('HastelloyX');
removeItemsOfAlloy('IncoloyMa956');
removeItemsOfAlloy('MaragingSteel300');
removeItemsOfAlloy('WatertightSteel');
removeItemsOfAlloyNoRod('Stellite100');
removeItemsOfAlloyNoRod('Zeron100');

mods.jei.ingredient.removeAndHide(metaitem('ingotHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustSmallHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustTinyHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('plateHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('stickHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('nuggetHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('springHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('stickLongHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('plateDoubleHslaSteel'));

mods.gregtech.mixer.removeByInput(480, [metaitem('dustCobalt') * 5, metaitem('dustChrome') * 2, metaitem('dustNickel'),
                                        metaitem('dustMolybdenum'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
mods.gregtech.mixer.removeByInput(480, [metaitem('dustInvar') * 2, metaitem('dustVanadium'), metaitem('dustTitanium'),
                                        metaitem('dustMolybdenum'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateHslaSteel') * 4, metaitem('plateTitaniumCarbide') * 2,
                                           metaitem('frameTungstenCarbide'), metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateZeron100') * 6, metaitem('frameTitanium'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateStellite100') * 6, metaitem('frameTungsten'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateMaragingSteel300') * 6, metaitem('frameStainlessSteel'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateCobaltBrass') * 6, metaitem('gcym:frameHslaSteel'),
                                           metaitem('circuit.integrated').withNbt(['Configuration': 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateWatertightSteel') * 6, metaitem('gcym:frameWatertightSteel'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateIncoloyMa956') * 6, metaitem('gcym:frameIncoloyMa956'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateHastelloyC276') * 6, metaitem('gcym:frameHastelloyC276'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateHslaSteel') * 6, metaitem('gcym:frameHslaSteel'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateHastelloyX') * 6, metaitem('gcym:frameMaragingSteel300'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)
mods.gregtech.assembler.removeByInput(16, [metaitem('plateTitaniumTungstenCarbide') * 6, metaitem('frameTitanium'),
                                           metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)


// Secure Maceration Casing
RecyclingHelper.replaceShaped('gcym:casing_large_macerator', item('gcym:large_multiblock_casing') * 2, [
        [metaitem('plateStelliteJ'), ore('craftingToolHardHammer'), metaitem('plateStelliteJ')],
        [metaitem('plateStelliteJ'), ore('frameGtHslaEightyX'), metaitem('plateStelliteJ')],
        [metaitem('plateStelliteJ'), ore('craftingToolWrench'), metaitem('plateStelliteJ')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(6)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateStelliteJ') * 6)
        .outputs(item('gcym:large_multiblock_casing') * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// High Temperature Casing
RecyclingHelper.replaceShaped('gcym:casing_high_temperature', item('gcym:large_multiblock_casing', 1) * 2, [
        [metaitem('plateTitanium'), ore('craftingToolHardHammer'), metaitem('plateTitanium')],
        [metaitem('plateTitaniumCarbide'), metaitem('frameTungstenCarbide'), metaitem('plateTitaniumCarbide')],
        [metaitem('plateTitanium'), ore('craftingToolWrench'), metaitem('plateTitanium')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(7)
        .inputs(ore('frameGtTungstenCarbide'))
        .inputs(ore('plateTitanium') * 4)
        .inputs(ore('plateTitaniumCarbide') * 2)
        .outputs(item('gcym:large_multiblock_casing', 1) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Large-Scale Assembler Casing
RecyclingHelper.replaceShaped('gcym:casing_large_assembler', item('gcym:large_multiblock_casing', 2) * 2, [
        [metaitem('plateHslaEightyX'), ore('craftingToolHardHammer'), metaitem('plateHslaEightyX')],
        [metaitem('plateHslaEightyX'), ore('frameGtHslaEightyX'), metaitem('plateHslaEightyX')],
        [metaitem('plateHslaEightyX'), ore('craftingToolWrench'), metaitem('plateHslaEightyX')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(6)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateHslaEightyX') * 6)
        .outputs(item('gcym:large_multiblock_casing', 2) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Stress Proof Casing
RecyclingHelper.replaceShaped('gcym:casing_stress_proof', item('gcym:large_multiblock_casing', 3) * 2, [
        [metaitem('plateIncoloyNineZeroEight'), ore('craftingToolHardHammer'), metaitem('plateIncoloyNineZeroEight')],
        [metaitem('plateIncoloyNineZeroEight'), ore('frameGtHslaEightyX'), metaitem('plateIncoloyNineZeroEight')],
        [metaitem('plateIncoloyNineZeroEight'), ore('craftingToolWrench'), metaitem('plateIncoloyNineZeroEight')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(6)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateIncoloyNineZeroEight') * 6)
        .outputs(item('gcym:large_multiblock_casing', 3) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Corrosion Proof Casing
RecyclingHelper.replaceShaped('gcym:casing_corrosion_proof', item('gcym:large_multiblock_casing', 4) * 2, [
        [metaitem('plateIncoloyEightTwoFive'), ore('craftingToolHardHammer'), metaitem('plateIncoloyEightTwoFive')],
        [metaitem('plateRene'), ore('frameGtHslaEightyX'), metaitem('plateRene')],
        [metaitem('plateIncoloyEightTwoFive'), ore('craftingToolWrench'), metaitem('plateIncoloyEightTwoFive')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(8)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateIncoloyEightTwoFive') * 4)
        .inputs(ore('plateRene') * 2)
        .outputs(item('gcym:large_multiblock_casing', 4) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Vibration-Safe Casing
RecyclingHelper.replaceShaped('gcym:casing_vibration_safe', item('gcym:large_multiblock_casing', 5) * 2, [
        [metaitem('plateStelliteJ'), ore('craftingToolHardHammer'), metaitem('plateStelliteJ')],
        [metaitem('plateIncoloyEightTwoFive'), ore('frameGtHslaEightyX'), metaitem('plateIncoloyEightTwoFive')],
        [metaitem('plateStelliteJ'), ore('craftingToolWrench'), metaitem('plateStelliteJ')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(7)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateStelliteJ') * 4)
        .inputs(ore('plateIncoloyEightTwoFive') * 2)
        .outputs(item('gcym:large_multiblock_casing', 5) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Watertight Casing
RecyclingHelper.replaceShaped('gcym:casing_watertight', item('gcym:large_multiblock_casing', 6) * 2, [
        [metaitem('plateIncoloyEightTwoFive'), ore('craftingToolHardHammer'), metaitem('plateIncoloyEightTwoFive')],
        [metaitem('plateIncoloyEightTwoFive'), ore('frameGtHslaEightyX'), metaitem('plateIncoloyEightTwoFive')],
        [metaitem('plateIncoloyEightTwoFive'), ore('craftingToolWrench'), metaitem('plateIncoloyEightTwoFive')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(6)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateIncoloyEightTwoFive') * 6)
        .outputs(item('gcym:large_multiblock_casing', 6) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Shock Proof Cutting Casing
RecyclingHelper.replaceShaped('gcym:casing_large_cutter', item('gcym:large_multiblock_casing', 7) * 2, [
        [metaitem('plateStelliteJ'), ore('craftingToolHardHammer'), metaitem('plateStelliteJ')],
        [metaitem('plateIncoloyNineZeroEight'), ore('frameGtHslaEightyX'), metaitem('plateIncoloyNineZeroEight')],
        [metaitem('plateStelliteJ'), ore('craftingToolWrench'), metaitem('plateStelliteJ')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(7)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateStelliteJ') * 4)
        .inputs(ore('plateIncoloyNineZeroEight') * 2)
        .outputs(item('gcym:large_multiblock_casing', 7) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Nonconducting Casing
RecyclingHelper.replaceShaped('gcym:casing_nonconducting', item('gcym:large_multiblock_casing', 8) * 2, [
        [metaitem('plateStelliteSix'), ore('craftingToolHardHammer'), metaitem('plateStelliteSix')],
        [metaitem('plateStelliteSix'), ore('frameGtHslaEightyX'), metaitem('plateStelliteSix')],
        [metaitem('plateStelliteSix'), ore('craftingToolWrench'), metaitem('plateStelliteSix')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(6)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateStelliteSix') * 6)
        .outputs(item('gcym:large_multiblock_casing:', 8) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Reaction-Safe Mixing Casing
RecyclingHelper.replaceShaped('gcym:casing_large_mixer', item('gcym:large_multiblock_casing', 9) * 2, [
        [metaitem('plateIncoloyTwenty'), ore('craftingToolHardHammer'), metaitem('plateIncoloyTwenty')],
        [metaitem('plateIncoloyTwenty'), ore('frameGtHslaEightyX'), metaitem('plateIncoloyTwenty')],
        [metaitem('plateIncoloyTwenty'), ore('craftingToolWrench'), metaitem('plateIncoloyTwenty')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(6)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateIncoloyTwenty') * 6)
        .outputs(item('gcym:large_multiblock_casing', 9) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

// Laser-Safe Engraving Casing
RecyclingHelper.replaceShaped('gcym:casing_large_engraver', item('gcym:large_multiblock_casing', 10) * 2, [
        [metaitem('plateRene'), ore('craftingToolHardHammer'), metaitem('plateRene')],
        [metaitem('plateHslaEightyX'), ore('frameGtHslaEightyX'), metaitem('plateHslaEightyX')],
        [metaitem('plateRene'), ore('craftingToolWrench'), metaitem('plateRene')]])

ASSEMBLER.recipeBuilder()
        .circuitMeta(7)
        .inputs(ore('frameGtHslaEightyX'))
        .inputs(ore('plateRene') * 4)
        .inputs(ore('plateHslaEightyX') * 2)
        .outputs(item('gcym:large_multiblock_casing', 10) * 2)
        .duration(50)
        .EUt(16)
        .buildAndRegister()

/*
    Blocks from GT superalloys need to be removed (block, frame, sheeted frame) and liquids
    Recipes for GCYM casings need to be changed to use SuSy superalloys, currently they still have recipes with old ones
 */
