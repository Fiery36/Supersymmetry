import globals.Globals
import postInit.utils.RecyclingHelper

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