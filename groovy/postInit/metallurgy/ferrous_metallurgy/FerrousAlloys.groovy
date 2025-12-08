import prePostInit.Recipemaps

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Kanthal
Recipemaps.MIXER.recipeBuilder()
        .circuitMeta(2)
        .inputs(ore('dustIron') * 1)
        .inputs(ore('dustAluminium') * 1)
        .inputs(ore('dustChrome') * 1)
        .outputs(item('gregtech:meta_dust', 294) * 3)
        .EUt(VA[MV])
        .duration(500)
        .buildAndRegister()

Recipemaps.ADVANCED_ARC_FURNACE.recipeBuilder()
        .circuitMeta(12)
        .inputs(ore('dustIron') * 1)
        .inputs(ore('dustAluminium') * 1)
        .inputs(ore('dustChrome') * 1)
        .fluidOutputs(fluid('molten.nichrome') * 432) // Nichrome is Kanthal
        .EUt(VA[EV])
        .duration(937)
        .buildAndRegister()

Recipemaps.ADVANCED_ARC_FURNACE.recipeBuilder()
        .circuitMeta(2)
        .inputs(ore('dustIron') * 1)
        .inputs(ore('dustAluminium') * 1)
        .inputs(ore('dustChrome') * 1)
        .fluidInputs(fluid('nitrogen') * 5000)
        .fluidOutputs(fluid('molten.nichrome') * 720) // Kanthal is Nichrome
        .EUt(VA[EV])
        .duration(628)
        .buildAndRegister()