import globals.Globals

BR = recipemap('batch_reactor')
BCR = recipemap('bubble_column_reactor')
ROASTER = recipemap('roaster')
PYROLYSE_OVEN = recipemap('pyrolyse_oven')
FBR = recipemap('fixed_bed_reactor')
DISTILLERY = recipemap('distillery')
MIXER = recipemap('mixer')
POLYMERIZATION_TANK = recipemap('polymerization_tank')
EXTRACTOR = recipemap('extractor')
SOLIDIFIER = recipemap('fluid_solidifier')

// 4,4'-difluorobenzophenone
BR.recipeBuilder()
    .inputs(ore('dustSodiumNitrite') * 4)
    .fluidInputs(fluid('gtfo_aniline') * 1000)
    .fluidInputs(fluid('hydrogen_fluoride') * 2000)
    .outputs(metaitem('dustBenzenediazoniumFluoride') * 14)
    .fluidOutputs(fluid('diluted_sodium_fluoride_solution') * 2000)
    .duration(120)
    .EUt(120)
    .buildAndRegister();

ROASTER.recipeBuilder()
    .inputs(ore('dustBenzenediazoniumFluoride') * 14)
    .outputs(metaitem('dustFluorobenzene') * 12)
    .fluidOutputs(fluid('nitrogen') * 2000)
    .duration(100)
    .EUt(120)
    .buildAndRegister();

BCR.recipeBuilder()
    .notConsumable(ore('dustPalladiumOnCarbon'))
    .fluidInputs(fluid('p_nitrotoluene') * 50)
    .fluidInputs(fluid('hydrogen') * 300)
    .fluidOutputs(fluid('p_toluidene') * 50)
    .fluidOutputs(fluid('water') * 100)
    .duration(4)
    .EUt(120)
    .buildAndRegister();

BR.recipeBuilder()
    .inputs(ore('dustSodiumNitrite') * 4)
    .fluidInputs(fluid('hydrofluoric_acid') * 1000)
    .fluidInputs(fluid('p_toluidene') * 1000)
    .fluidOutputs(fluid('fluorinated_toluidene') * 1000)
    .fluidOutputs(fluid('nitrogen') * 2000)
    .duration(100)
    .EUt(120)
    .buildAndRegister();

PYROLYSE_OVEN.recipeBuilder()
    .fluidInputs(fluid('fluorinated_toluidene')* 1000)
    .outputs(metaitem('dustSodiumFluoride') * 2)
    .fluidOutputs(fluid('fluorotoluene') * 1000)
    .fluidOutputs(fluid('dense_steam') * 4000)
    .duration(300)
    .EUt(480)
    .buildAndRegister();

BCR.recipeBuilder()
    .notConsumable(metaitem('carbon_arc_lamp'))
    .fluidInputs(fluid('fluorotoluene') * 50)
    .fluidInputs(fluid('chlorine') * 150)
    .fluidOutputs(fluid('fluorotoluenetrichloride') * 50)
    .fluidOutputs(fluid('hydrogen') * 150)
    .duration(4)
    .EUt(120)
    .buildAndRegister();

FBR.recipeBuilder()
    .notConsumable(metaitem('catalystBedIronIiiChloride'))
    .fluidInputs(fluid('water') * 1000)
    .fluidInputs(fluid('fluorotoluenetrichloride') * 1000)
    .outputs(metaitem('dustFluorobenzoylChloride') * 14)
    .fluidOutputs(fluid('hydrogen_chloride') * 2000)
    .duration(80)
    .EUt(120)
    .buildAndRegister();

BR.recipeBuilder()
    .notConsumable(metaitem('catalystBedAluminiumChloride'))
    .inputs(ore('dustFluorobenzene') * 12)
    .inputs(ore('dustFluorobenzoylChloride') * 14)
    .fluidInputs(fluid('hexane') * 1000)
    .fluidOutputs(fluid('four_four_difluorobenzophenone_solution') * 1000)
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .duration(200)
    .EUt(120)
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('four_four_difluorobenzophenone_solution') * 1000)
    .outputs(metaitem('dustFourFourDifluorobenzophenone'))
    .fluidOutputs(fluid('hexane') * 1000)
    .duration(60)
    .EUt(120)
    .buildAndRegister();

// Hydroquinone
BCR.recipeBuilder()
    .fluidInputs(fluid('benzene') * 50)
    .fluidInputs(fluid('propene') * 100)
    .fluidOutputs(fluid('p_diisopropylbenzene') * 50)
    .duration(2)
    .EUt(120)
    .buildAndRegister();

ROASTER.recipeBuilder()
    .fluidInputs(fluid('air') * 10000)
    .fluidInputs(fluid('p_diisopropylbenzene') * 1000)
    .fluidOutputs(fluid('bis_hydroperoxide') * 1000)
    .duration(120)
    .EUt(120)
    .buildAndRegister();

BR.recipeBuilder()
    .notConsumable(fluid('acetic_acid') * 50)
    .fluidInputs(fluid('bis_hydroperoxide') * 1000)
    .fluidOutputs(fluid('hydroquinone_solution') * 2000)
    .duration(100)
    .EUt(120)
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('hydroquinone_solution') * 2000)
    .outputs(metaitem('dustHydroquinone') * 14)
    .fluidOutputs(fluid('acetone') * 2000)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

// Diphenyl Sulfone

BR.recipeBuilder()
    .fluidInputs(fluid('benzene') * 1000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('benzenesulfonic_acid') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .duration(100)
    .EUt(120)
    .buildAndRegister();

BR.recipeBuilder()
    .notConsumable(fluid('oleum') * 1000)
    .fluidInputs(fluid('benzenesulfonic_acid') * 2000)
    .outputs(metaitem('dustDiphenylSulfone'))
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .duration(100)
    .EUt(120)
    .buildAndRegister();

// Polymerisation

MIXER.recipeBuilder()
    .inputs(ore('dustHydroquinone') * 14)
    .inputs(ore('dustFourFourDifluorobenzophenone'))
    .fluidInputs(fluid('diphenyl_sulfone') * 1000)
    .fluidOutputs(fluid('hydroquinone_emulsion'))
    .duration(200)
    .EUt(480)
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .notConsumable(fluid('nitrogen') * 8000)
    .inputs(ore('dustTinySodaAsh'))
    .fluidInputs(fluid('hydroquinone_emulsion') * 1000)
    .outputs(metaitem('dustPeekMixture'))
    .duration(300)
    .EUt(1920)
    .buildAndRegister();

MIXER.recipeBuilder()
    .inputs(ore('dustPeekMixture'))
    .fluidInputs(fluid('acetone') * 1000)
    .outputs(metaitem('dustPolyetherEtherKetone'))
    .fluidOutputs(fluid('diphenyl_sulfone_solution') * 1000)
    .duration(100)
    .EUt(120)
    .buildAndRegister();

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diphenyl_sulfone_solution') * 1000)
    .outputs(metaitem('dustDiphenylSulfone'))
    .fluidOutputs(fluid('acetone') * 1000)
    .duration(60)
    .EUt(30)
    .buildAndRegister();

// Liquid Diphenyl Sulfone * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustDiphenylSulfone')], null)

EXTRACTOR.recipeBuilder()
    .inputs(ore('dustDiphenylSulfone'))
    .fluidOutputs(fluid('diphenyl_sulfone') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister();

SOLIDIFIER.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ball'))
    .fluidInputs(fluid('diphenyl_sulfone') * 1000)
    .outputs(metaitem('dustDiphenylSulfone'))
    .duration(20)
    .EUt(30)
    .buildAndRegister();

// Liquid susy.material.p_toluidene * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustPToluidene')], null)

EXTRACTOR.recipeBuilder()
        .inputs(ore('dustPToluidene'))
        .fluidOutputs(fluid('p_toluidene') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister();

SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ball'))
        .fluidInputs(fluid('p_toluidene') * 1000)
        .outputs(metaitem('dustPToluidene'))
        .duration(20)
        .EUt(30)
        .buildAndRegister();

// Liquid susy.material.p_nitrotoluene * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustPNitrotoluene')], null)

EXTRACTOR.recipeBuilder()
        .inputs(ore('dustPNitrotoluene') * 7)
        .fluidOutputs(fluid('p_nitrotoluene') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister();

SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ball'))
        .fluidInputs(fluid('p_nitrotoluene') * 1000)
        .outputs(metaitem('dustPNitrotoluene') * 7)
        .duration(20)
        .EUt(30)
        .buildAndRegister();