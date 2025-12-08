import prePostInit.Recipemaps

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Nichrome
Recipemaps.MIXER.recipeBuilder()
        .circuitMeta(1)
        .inputs(ore('dustNickel') * 4)
        .inputs(ore('dustChrome') * 1)
        .outputs(item('gregtech:meta_dust', 288) * 5)
        .EUt(VA[MV])
        .duration(300)
        .buildAndRegister()

Recipemaps.ADVANCED_ARC_FURNACE.recipeBuilder()
        .circuitMeta(13)
        .inputs(ore('dustNickel') * 4)
        .inputs(ore('dustChrome') * 1)
        .fluidOutputs(fluid('molten.kanthal') * 720) // Kanthal is Nichrome
        .EUt(VA[HV])
        .duration(506)
        .buildAndRegister()

Recipemaps.ADVANCED_ARC_FURNACE.recipeBuilder()
        .circuitMeta(3)
        .inputs(ore('dustNickel') * 4)
        .inputs(ore('dustChrome') * 1)
        .fluidInputs(fluid('nitrogen') * 3000)
        .fluidOutputs(fluid('molten.kanthal') * 720) // Kanthal is Nichrome
        .EUt(VA[HV])
        .duration(339)
        .buildAndRegister()