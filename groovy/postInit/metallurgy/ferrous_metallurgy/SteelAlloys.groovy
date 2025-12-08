import prePostInit.Recipemaps

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Tungstensteel
Recipemaps.ADVANCED_ARC_FURNACE.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('molten.steel') * 8640) //equal to 60 Steel dust 
    .inputs(ore('dustTungsten') * 8)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustVanadium') * 1)
    .inputs(ore('dustMolybdenum') * 2)  
    .fluidOutputs(fluid('molten.tungsten_steel') * 10656) // 74 ingot 
    .EUt(VA[IV])
    .duration(22000) 
    .buildAndRegister()

Recipemaps.ADVANCED_ARC_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('molten.steel') * 8640) //equal to 60 Steel dust
    .fluidInputs(fluid('argon') * 6000)
    .inputs(ore('dustTungsten') * 8)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustVanadium') * 1)
    .inputs(ore('dustMolybdenum') * 2)  
    .fluidOutputs(fluid('molten.tungsten_steel') * 10656) // 74 ingot 
    .EUt(VA[IV])
    .duration(17000) 
    .buildAndRegister()

// Galvanized Steel
Recipemaps.SOLIDIFIER.recipeBuilder()
        .inputs(ore('wireFineSteel') * 8)
        .fluidInputs(fluid('zinc') * 18)
        .outputs(metaitem('wireFineGalvanizedSteel') * 8)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

