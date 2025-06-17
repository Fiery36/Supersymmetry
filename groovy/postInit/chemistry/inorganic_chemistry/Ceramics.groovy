import globals.Globals
import static globals.SinteringGlobals.*

SINTERING_OVEN = recipemap('sintering_oven')
HOT_ISOSTATIC_PRESS = recipemap('hot_isostatic_press')
MIXER = recipemap('mixer')
FORMING_PRESS = recipemap('forming_press')
CVD = recipemap('cvd')

// PVA binder

MIXER.recipeBuilder()
    .inputs(ore('dustPolyvinylAlcohol'))
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('polyvinyl_alcohol_binder') * 1000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

// Alumina

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .inputs(ore('dustAlumina') * 10)
    .fluidInputs(fluid('polyvinyl_alcohol_binder') * 200)
    .notConsumable(metaitem('shape.mold.ring'))
    .outputs(metaitem('sintered_alumina.insulator'))
    .duration(500)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Zirconia

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .inputs(ore('dustYttriaStabilizedZirconiumDioxide') * 12)
    .fluidInputs(fluid('polyvinyl_alcohol_binder') * 400)
    .outputs(metaitem('nozzle.yttria_stabilized_zirconia'))
    .duration(600)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

// Boron carbide

ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustBoronTrioxide') * 10)
    .inputs(ore('dustAnyPurityCarbon') * 7)
    .outputs(metaitem('dustBoronCarbide') * 5)
    .fluidOutputs(fluid('carbon_monoxide') * 6000)
    .duration(300)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

for (blanket in sintering_blankets) {
    SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustBoronCarbide'))
        .fluidInputs(fluid('novolacs') * 100)
        .notConsumable(metaitem('shape.mold.rod'))
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('stickBoronCarbide'))
        .duration(blanket.duration)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
}

// Boron nitride

CVD.recipeBuilder()
    .fluidInputs(fluid('boron_trichloride') * 1000)
    .fluidInputs(fluid('ammonia') * 1000)
    .outputs(metaitem('dustBoronNitride') * 2)
    .fluidOutputs(fluid('hydrogen_chloride') * 3000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

FORMING_PRESS.recipeBuilder()
    .inputs(ore('dustBoronNitride') * 14)
    .notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('crucible.boron.nitride'))
    .duration(2000)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()