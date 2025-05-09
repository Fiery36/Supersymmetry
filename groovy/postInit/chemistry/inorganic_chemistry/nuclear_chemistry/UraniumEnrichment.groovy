REACTION_FURNACE = recipemap('reaction_furnace')
FLUIDIZEDBR = recipemap('fluidized_bed_reactor')
GAS_CENTRIFUGE = recipemap('gas_centrifuge')
MIXER = recipemap('mixer')

GAS_CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('natural_uranium_hexafluoride') * 1000)
    .fluidOutputs(fluid('depleted_uranium_hexafluoride') * 860)
    .fluidOutputs(fluid('leu_235_hexafluoride') * 140)
    .duration(6000)
    .EUt(480)
    .buildAndRegister()

GAS_CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('leu_235_hexafluoride') * 1000)
    .fluidOutputs(fluid('depleted_uranium_hexafluoride') * 500)
    .fluidOutputs(fluid('haleu_235_hexafluoride') * 500)
    .duration(2000)
    .EUt(480)
    .buildAndRegister()

GAS_CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('haleu_235_hexafluoride') * 1000)
    .fluidOutputs(fluid('depleted_uranium_hexafluoride') * 500)
    .fluidOutputs(fluid('heu_235_hexafluoride') * 500)
    .duration(2600)
    .EUt(480)
    .buildAndRegister()

GAS_CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('heu_235_hexafluoride') * 900)
    .fluidOutputs(fluid('depleted_uranium_hexafluoride') * 700)
    .fluidOutputs(fluid('weapons_grade_uranium_hexafluoride') * 200)
    .duration(14000)
    .EUt(480)
    .buildAndRegister()

def uranium_grades = [
    'leu_235',
    'haleu_235',
    'heu_235',
    'depleted_uranium',
    'weapons_grade_uranium'
]

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustDepletedUraniumDioxide') * 3)
    .inputs(ore('dustMagnesium') * 2)
    .outputs(ore('dustUranium238').first())
    .outputs(metaitem('dustMagnesia') * 4)
    .EUt(3840)
    .duration(80)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustWeaponsGradeUraniumDioxide') * 3)
    .inputs(ore('dustMagnesium') * 2)
    .outputs(ore('dustWeaponsGradeUranium').first())
    .outputs(metaitem('dustMagnesia') * 4)
    .EUt(3840)
    .duration(80)
    .buildAndRegister()

for (grade in uranium_grades) {
    grade_solid = grade.replace('uranium', '').split('_').collect { it.capitalize() }.join()

    BR.recipeBuilder()
        .fluidInputs(fluid(grade + '_hexafluoride') * 2000)
        .fluidInputs(fluid('ammonia') * 2000)
        .fluidInputs(fluid('dense_steam') * 7000)
        .outputs(metaitem('dust' + grade_solid + 'AmmoniumDiuranate') * 19)
        .fluidOutputs(fluid('hydrogen_fluoride') * 12000)
        .EUt(240)
        .duration(80)
        .buildAndRegister()

    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dust' + grade_solid + 'AmmoniumDiuranate') * 19)
        .fluidInputs(fluid('hydrogen') * 2000)
        .outputs(metaitem('dust' + grade_solid + 'UraniumDioxide') * 6)
        .fluidOutputs(fluid('ammonia') * 2000)
        .fluidOutputs(fluid('dense_steam') * 3000)
        .EUt(3840)
        .duration(600)
        .buildAndRegister()
}

MIXER.recipeBuilder()
    .inputs(ore('dustWeaponsGradeUranium') * 2)
    .inputs(ore('dustUranium238') * 7)
    .outputs(ore('dustHeu235') * 9)
    .EUt(480)
    .duration(900)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustHeu235'))
    .inputs(ore('dustUranium238'))
    .outputs(ore('dustHaleu235') * 2)
    .EUt(480)
    .duration(200)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustHaleu235'))
    .inputs(ore('dustUranium238'))
    .outputs(ore('dustLeu235') * 2)
    .EUt(480)
    .duration(400)
    .buildAndRegister()