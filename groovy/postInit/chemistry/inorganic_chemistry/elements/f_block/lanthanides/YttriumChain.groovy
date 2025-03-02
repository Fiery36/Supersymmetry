import globals.Globals

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

DISTILLERY = recipemap('distillery')
REACTION_FURNACE = recipemap('reaction_furnace')
MACERATOR = recipemap('macerator')

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('yttrium_chloride_solution') * 1000)
        .outputs(metaitem('dustYttriumChloride') * 4)
        .fluidOutputs(fluid('water') * 1000)
        .duration(160)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustYttriumChloride') * 4)
        .inputs(ore('dustSodium') * 3)
        .fluidInputs(fluid('nitrogen') * 1000)
        .outputs(metaitem('sponge.yttrium'))
        .outputs(metaitem('dustSalt') * 6)
        .duration(200)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustYttriumChloride') * 4)
        .inputs(ore('dustLithium') * 3)
        .fluidInputs(fluid('nitrogen') * 1000)
        .outputs(metaitem('sponge.yttrium'))
        .outputs(metaitem('dustLithiumChloride') * 6)
        .duration(200)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustYttriumChloride') * 4)
        .inputs(ore('dustSodium') * 3)
        .fluidInputs(fluid('argon') * 200)
        .outputs(metaitem('sponge.yttrium'))
        .outputs(metaitem('dustSalt') * 6)
        .duration(200)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustYttriumChloride') * 4)
        .inputs(ore('dustLithium') * 3)
        .fluidInputs(fluid('argon') * 200)
        .outputs(metaitem('sponge.yttrium'))
        .outputs(metaitem('dustLithiumChloride') * 6)
        .duration(200)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

MACERATOR.recipeBuilder()
        .inputs(ore('sponge.yttrium'))
        .outputs(metaitem('dustYttrium'))
        .duration(20)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()