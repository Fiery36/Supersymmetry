import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

GRAVITY_SEPARATOR = recipemap('gravity_separator')
MACERATOR = recipemap('macerator')
MIXER = recipemap('mixer')
FROTH_FLOTATION = recipemap('froth_flotation_vat')
CLARIFIER = recipemap('clarifier_vat')
ROTARY_KILN = recipemap('rotary_kiln')
BR = recipemap('batch_reactor')

MACERATOR.recipeBuilder()
    .inputs(ore('bastnasite_alluvial'))
    .outputs(metaitem(dustBastnasite))
    .duration(20)
    .EUt(1)
    .buildAndRegister()

