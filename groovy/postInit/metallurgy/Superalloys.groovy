import globals.Globals
import postInit.utils.RecyclingHelper

ABS = recipemap('alloy_blast_smelter')

ABS.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('dustAnyPurityIron') * 12)
    .inputs(ore('dustAnyPurityNickel') * 8)
    .inputs(ore('dustAnyPurityChrome') * 12)
    .inputs(ore('dustAnyPurityManganese') * 1)
    .inputs(ore('dustAnyPurityCopper') * 2)
    .inputs(ore('dustAnyPurityNiobium') * 1)
    .inputs(ore('dustAnyPurityTantalum') * 1)
    .inputs(ore('dustAnyPurityMolybdenum') * 2)
    .fluidOutputs(fluid('incoloy_twenty') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('dustAnyPurityIron') * 9)
    .inputs(ore('dustAnyPurityNickel') * 16)
    .inputs(ore('dustAnyPurityChrome') * 7)
    .inputs(ore('dustAnyPurityManganese') * 1)
    .inputs(ore('dustAnyPurityCopper') * 2)
    .inputs(ore('dustAnyPurityAluminium') * 1)
    .inputs(ore('dustAnyPurityTitanium') * 1)
    .inputs(ore('dustAnyPurityMolybdenum') * 2)
    .fluidOutputs(fluid('incoloy_eight_two_five') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('dustAnyPurityAluminium') * 1)
    .inputs(ore('dustAnyPurityCobalt') * 1)
    .inputs(ore('dustAnyPurityIron') * 20)
    .inputs(ore('dustAnyPurityNickel') * 30)
    .inputs(ore('dustAnyPurityChrome') * 3)
    .inputs(ore('dustAnyPurityTitanium') * 2)
    .inputs(ore('dustAnyPurityTungsten') * 1)
    .inputs(ore('dustAnyPurityNiobium') * 2)
    .fluidOutputs(fluid('incoloy_nine_zero_eight') * 8640)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('dustAnyPurityAluminium') * 3)
    .inputs(ore('dustAnyPurityCobalt') * 4)
    .inputs(ore('dustAnyPurityNickel') * 22)
    .inputs(ore('dustAnyPurityChrome') * 3)
    .inputs(ore('dustAnyPurityTungsten') * 2)
    .inputs(ore('dustAnyPurityHafnium') * 1)
    .inputs(ore('dustAnyPurityRhenium') * 2)
    .inputs(ore('dustAnyPurityTantalum') * 3)
    .fluidOutputs(fluid('rene') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('dustAnyPurityNickel') * 23)
    .inputs(ore('dustAnyPurityManganese') * 2)
    .inputs(ore('dustAnyPurityCopper') * 10)
    .inputs(ore('dustAnyPurityAluminium') * 4)
    .inputs(ore('dustAnyPurityTitanium') * 1)
    .fluidOutputs(fluid('monel') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('dustAnyPurityIron') * 2)
    .inputs(ore('dustAnyPurityNickel') * 2)
    .inputs(ore('dustAnyPurityCobalt') * 15)
    .inputs(ore('dustAnyPurityChrome') * 13)
    .inputs(ore('dustAnyPurityManganese') * 1)
    .inputs(ore('dustAnyPurityTungsten') * 7)
    .fluidOutputs(fluid('stellite_j') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('dustAnyPurityNickel') * 1)
    .inputs(ore('dustAnyPurityCobalt') * 24)
    .inputs(ore('dustAnyPurityChrome') * 10)
    .inputs(ore('dustAnyPurityManganese') * 1)
    .inputs(ore('dustAnyPurityTungsten') * 3)
    .inputs(ore('dustAnyPurityMolybdenum') * 1)
    .fluidOutputs(fluid('stellite_six') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('dustAnyPurityIron') * 39)
    .inputs(ore('dustAnyPurityManganese') * 1)
    .fluidOutputs(fluid('hsla_eighty_x') * 5760)
        .blastFurnaceTemp(2600)
    .duration(3000)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('dustAnyPurityIron') * 24)
    .inputs(ore('dustAnyPurityNickel') * 5)
    .inputs(ore('dustAnyPurityChrome') * 8)
    .inputs(ore('dustAnyPurityManganese') * 1)
    .inputs(ore('dustAnyPurityMolybdenum') * 2)
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


crafting.replaceShaped('gcym:casing_high_temperature', item('gcym:large_multiblock_casing', 1) * 2, [
        [metaitem('plateTitanium'), ore('craftingToolHardHammer'), metaitem('plateTitanium')],
        [metaitem('plateTitaniumCarbide'), metaitem('frameTungstenCarbide'), metaitem('plateTitaniumCarbide')],
        [metaitem('plateTitanium'), ore('craftingToolWrench'), metaitem('plateTitanium')]])

RecyclingHelper.replaceShaped('gcym:casing_high_temperature', item('gcym:large_multiblock_casing', 1) * 2, [
        [metaitem('plateTitanium'), ore('craftingToolHardHammer'), metaitem('plateTitanium')],
        [metaitem('plateTitaniumCarbide'), metaitem('frameTungstenCarbide'), metaitem('plateTitaniumCarbide')],
        [metaitem('plateTitanium'), ore('craftingToolWrench'), metaitem('plateTitanium')]])
/*
    Blocks from GT superalloys need to be removed (block, frame, sheeted frame) and liquids
    Recipes for GCYM casings need to be changed to use SuSy superalloys, currently they still have recipes with old ones
 */