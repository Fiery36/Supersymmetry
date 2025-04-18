ASSEMBLER = recipemap('assembler')

// LV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtSingleTin') * 2, metaitem('stickIron') * 2, metaitem('stickIronMagnetic'), metaitem('wireGtSingleCopper') * 4], null)
// LV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtSingleTin') * 2, metaitem('stickSteel') * 2, metaitem('stickSteelMagnetic'), metaitem('wireGtSingleCopper') * 4], null)
// MV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtSingleCopper') * 2, metaitem('stickAluminium') * 2, metaitem('stickSteelMagnetic'), metaitem('wireGtDoubleCupronickel') * 4], null)
// HV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleSilver') * 2, metaitem('stickStainlessSteel') * 2, metaitem('stickSteelMagnetic'), metaitem('wireGtDoubleElectrum') * 4], null)
// IV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleTungsten') * 2, metaitem('stickTungstenSteel') * 2, metaitem('stickNeodymiumMagnetic'), metaitem('wireGtDoubleGraphene') * 4], null)
// EV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleAluminium') * 2, metaitem('stickTitanium') * 2, metaitem('stickNeodymiumMagnetic'), metaitem('wireGtDoubleKanthal') * 4], null)
// Extreme Voltage Coil * 1
mods.gregtech.assembler.removeByInput(1920, [metaitem('stickNeodymiumMagnetic'), metaitem('wireFineTungstenSteel') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Insane Voltage Coil * 1
mods.gregtech.assembler.removeByInput(7680, [metaitem('stickNeodymiumMagnetic'), metaitem('wireFineIridium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Ludicrous Voltage Coil * 1
mods.gregtech.assembler.removeByInput(30720, [metaitem('stickSamariumMagnetic'), metaitem('wireFineOsmiridium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Zero Point Module Voltage Coil * 1
mods.gregtech.assembler.removeByInput(122880, [metaitem('stickSamariumMagnetic'), metaitem('wireFineEuropium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Ultimate Voltage Coil * 1
mods.gregtech.assembler.removeByInput(491520, [metaitem('stickSamariumMagnetic'), metaitem('wireFineTritanium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// LuV Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(6000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongHsss') * 2, metaitem('ringHsss') * 2, metaitem('roundHsss') * 4, metaitem('wireFineRuridit') * 64, metaitem('cableGtSingleNiobiumTitanium') * 2], [fluid('soldering_alloy') * 144, fluid('lubricant') * 250])
// ZPM Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(24000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongOsmiridium') * 4, metaitem('ringOsmiridium') * 4, metaitem('roundOsmiridium') * 8, metaitem('wireFineEuropium') * 64, metaitem('wireFineEuropium') * 32, metaitem('cableGtSingleVanadiumGallium') * 2], [fluid('soldering_alloy') * 288, fluid('lubricant') * 500])
// UV Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(100000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongTritanium') * 4, metaitem('ringTritanium') * 4, metaitem('roundTritanium') * 8, metaitem('wireFineAmericium') * 64, metaitem('wireFineAmericium') * 64, metaitem('cableGtSingleYttriumBariumCuprate') * 2], [fluid('soldering_alloy') * 576, fluid('lubricant') * 1000, fluid('naquadria') * 576])

crafting.removeByOutput(metaitem('electric.motor.lv'))

crafting.addShapeless('commutator', metaitem('commutator'), [
    metaitem('plateCopper'), metaitem('plateStone'), metaitem('rubber_drop'), ore('toolWireCutter')
])

crafting.addShapeless('brush.unfired', metaitem('unfired_brush'), [
    metaitem('dustGraphite'), metaitem('rubber_drop'), ore('toolHammer')
])

furnace.add(metaitem('brush.unfired'), metaitem('brush'))

crafting.addShaped('susy:electric_motor_lv', metaitem('electric.motor.lv'), [
    [metaitem('plateSteelMagnetic'), metaitem('wireGtSingleCopper'), metaitem('cableGtSingleTin')],
    [metaitem('brush'), metaitem('stickSteel'), metaitem('wireGtSingleCopper')],
    [metaitem('commutator'), metaitem('brush'), metaitem('plateSteelMagnetic')]
])

crafting.addShaped('susy:electric_motor_mv', metaitem('electric.motor.mv'), [
    [metaitem('plateSteelMagnetic'), metaitem('wireGtDoubleCupronickel'), metaitem('cableGtSingleCopper')],
    [metaitem('brush'), metaitem('stickAluminium'), metaitem('wireGtDoubleCupronickel')],
    [metaitem('commutator'), metaitem('brush'), metaitem('plateSteelMagnetic')]
])

crafting.addShaped('susy:electric_motor_hv', metaitem('electric.motor.hv'), [
    [metaitem('plateAlnicoMagnetic'), metaitem('wireGtDoubleElectrum'), metaitem('cableGtDoubleSilver')],
    [metaitem('brush'), metaitem('stickStainlessSteel'), metaitem('wireGtDoubleElectrum')],
    [metaitem('commutator'), metaitem('brush'), metaitem('plateAlnicoMagnetic')]
])

crafting.replaceShaped('gregtech:electric_motor_ev', metaitem('electric.motor.ev'), [
    [metaitem('plateAlnicoMagnetic'), metaitem('wireGtDoubleKanthal'), metaitem('cableGtDoubleAluminium')],
    [metaitem('brush'), metaitem('stickTitanium'), metaitem('wireGtDoubleKanthal')],
    [metaitem('commutator'), metaitem('brush'), metaitem('plateAlnicoMagnetic')]
])

crafting.replaceShaped('gregtech:electric_motor_iv', metaitem('electric.motor.iv'), [
    [metaitem('cableGtDoubleTungsten'), metaitem('wireGtDoubleGraphene'), metaitem('stickTungstenSteel')],
    [metaitem('wireGtDoubleGraphene'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtDoubleGraphene')],
    [metaitem('stickTungstenSteel'), metaitem('wireGtDoubleGraphene'), metaitem('cableGtDoubleTungsten')]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateCopper'))
    .inputs(ore('plateMica'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('commutator') * 4)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustGraphite'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('unfired_brush') * 2)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleTin'))
    .inputs(ore('stickSteel'))
    .inputs(ore('plateSteelMagnetic') * 2)
    .inputs(ore('wireGtSingleCopper') * 2)
    .inputs(metaitem('commutator'))
    .inputs(metaitem('brush') * 2)
    .outputs(metaitem('electric.motor.lv'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleCopper'))
    .inputs(ore('stickAluminium'))
    .inputs(ore('plateSteelMagnetic') * 2)
    .inputs(ore('wireGtDoubleCupronickel') * 2)
    .inputs(metaitem('commutator'))
    .inputs(metaitem('brush') * 2)
    .outputs(metaitem('electric.motor.mv'))
    .duration(100)
    .EUt(120)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleSilver'))
    .inputs(ore('stickStainlessSteel'))
    .inputs(ore('plateAlnicoMagnetic') * 2)
    .inputs(ore('wireGtDoubleElectrum') * 2)
    .inputs(metaitem('commutator'))
    .inputs(metaitem('brush') * 2)
    .outputs(metaitem('electric.motor.hv'))
    .duration(100)
    .EUt(480)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtDoubleAluminium'))
    .inputs(ore('stickTitanium'))
    .inputs(ore('plateAlnicoMagnetic') * 2)
    .inputs(ore('wireGtDoubleKanthal') * 2)
    .inputs(metaitem('commutator'))
    .inputs(metaitem('brush') * 2)
    .outputs(metaitem('electric.motor.ev'))
    .duration(100)
    .EUt(1920)
    .buildAndRegister();