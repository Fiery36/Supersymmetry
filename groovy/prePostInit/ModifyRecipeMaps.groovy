package prePostInit

import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregtech.api.GregTechAPI
import gregtech.api.gui.GuiTextures
import gregtech.api.recipes.GTRecipeHandler
import gregtech.api.recipes.Recipe
import gregtech.api.recipes.RecipeMaps
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.properties.PropertyKey
import gregtech.api.unification.ore.OrePrefix
import gregtechfoodoption.recipe.GTFORecipeMaps
import supersymmetry.api.fluids.SusyFluidStorageKeys
import supersymmetry.api.gui.SusyGuiTextures

import static gregtech.api.recipes.GTRecipeHandler.*
import static gregtech.api.recipes.RecipeMaps.*

//Removed to make way for overhauls
GTRecipeHandler.removeAllRecipes(RecipeMaps.DISTILLERY_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.DISTILLATION_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.CRACKING_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.BREWING_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.CHEMICAL_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.LARGE_CHEMICAL_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.FERMENTING_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.PYROLYSE_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.IMPLOSION_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.LASER_ENGRAVER_RECIPES)
GTRecipeHandler.removeAllRecipes(GTFORecipeMaps.GREENHOUSE_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.VACUUM_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.ELECTROLYZER_RECIPES)
GTRecipeHandler.removeAllRecipes(GCYMRecipeMaps.ALLOY_BLAST_RECIPES)
GTRecipeHandler.removeAllRecipes(RecipeMaps.SEMI_FLUID_GENERATOR_FUELS)

GregTechAPI.materialManager.getRegisteredMaterials().forEach(material -> {
    if (material.hasProperty(PropertyKey.FLUID) && material.getProperty(PropertyKey.FLUID).getPrimaryKey() == SusyFluidStorageKeys.SLURRY) {
        Recipe recipe = RecipeMaps.EXTRACTOR_RECIPES.findRecipe(Integer.MAX_VALUE, Collections.singletonList(OreDictUnifier.get(OrePrefix.dust, material)), Collections.emptyList(), false)
        if (recipe != null) {
            RecipeMaps.EXTRACTOR_RECIPES.removeRecipe(recipe)
        }
    }
})
//Removal of certain centrifuging recipes

// LPG * 370
mods.gregtech.centrifuge.removeByInput(5, null, [fluid('butane') * 320])
// LPG * 290
mods.gregtech.centrifuge.removeByInput(5, null, [fluid('propane') * 320])
// Clay Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustBrick')], null)
// Epoxy Resin Pulp * 1
mods.gregtech.centrifuge.removeByInput(5, [metaitem('dustReinforcedEpoxyResin')], null)
// Water * 1000
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('gtfo_baking_soda_solution') * 1000])
// Clay Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustFireclay') * 2], null)
//Red sand centrifuging
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:sand', 1)], null)
// Nitrogen Dioxide * 3900
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('ender_air') * 10000])
mods.gregtech.centrifuge.removeByInput(320, [metaitem('dustPlutonium')], null)
// Carbon Monoxide * 3900
mods.gregtech.centrifuge.removeByInput(120, null, [fluid('nether_air') * 10000])
// Nitrogen * 3900
mods.gregtech.centrifuge.removeByInput(7, null, [fluid('air') * 10000])
// Silicon Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:redstone') * 10], null)
// Small Pile of Banded Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(900, [metaitem('dustMetalMixture')], null)
// Silicon Dioxide Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustPlatinumSludgeResidue') * 5], null)
mods.gregtech.centrifuge.removeByInput(320, [metaitem('dustUranium')], null)
// Lead Dust * 1
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('lead_zinc_solution') * 1000])
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:mycelium')], null)
// Antimony Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustStibnite') * 5], null)
// Raw Platinum Powder * 3
mods.gregtech.centrifuge.removeByInput(480, [metaitem('dustPlatinumGroupSludge') * 6], [fluid('aqua_regia') * 1200])
// Small Pile of Redstone Dust * 2
mods.gregtech.centrifuge.removeByInput(80, [item('minecraft:glowstone_dust') * 2], null)
// Small Pile of Quartzite Dust * 1
mods.gregtech.centrifuge.removeByInput(120, [metaitem('dustStone')], null)
// Sulfur Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustCinnabar') * 2], null)
// Aluminium Dust * 2
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('green_sapphire_slurry') * 3000])
// Aluminium Dust * 2
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('sapphire_slurry') * 3000])
// Aluminium Dust * 2
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('ruby_slurry') * 3000])
// Helium * 120
mods.gregtech.centrifuge.removeByInput(20, [metaitem('dustEndstone')], null)
// Biomass * 200
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustMeat') * 3], null)
//Centrifuging dirt or grass
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:dirt')], null)
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:grass')], null)
// Magnesium Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustMarble') * 8], null)
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustAsh')], null)
// Calcium Dust * 3
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustTricalciumPhosphate') * 5], null)
// Samarium Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustSamariumMagnetic')], null)
// Neodymium Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustNeodymiumMagnetic')], null)
// Phosphorus Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustPhosphorusPentoxide') * 7], null)
// Iridium Chloride Dust * 4
mods.gregtech.centrifuge.removeByInput(120, [metaitem('dustIridiumMetalResidue') * 5], null)
// Oil * 80
mods.gregtech.centrifuge.removeByInput(80, [item('minecraft:soul_sand')], null)
// Methane * 60
mods.gregtech.centrifuge.removeByInput(20, [item('gregtech:rubber_log')], null)
// Methane * 4000
mods.gregtech.centrifuge.removeByInput(5, null, [fluid('refinery_gas') * 8000])
// Heavy Oil * 2000
mods.gregtech.centrifuge.removeByInput(30, [item('gregtech:ore_oilsands_0')], null)
// Enriched Uranium Hexafluoride * 100
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('uranium_hexafluoride') * 1000])
// Tritium * 40
mods.gregtech.centrifuge.removeByInput(80, null, [fluid('deuterium') * 160])
// Helium-3 * 5
mods.gregtech.centrifuge.removeByInput(80, null, [fluid('helium') * 80])
//Centrifuging nether rack dust
mods.gregtech.centrifuge.removeByInput(20, [metaitem('dustNetherrack')], null)
// Deuterium * 40
mods.gregtech.centrifuge.removeByInput(20, null, [fluid('hydrogen') * 160])
// Arsenic Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustRealgar') * 2], null)
// Silicon Dioxide Dust * 4
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustGranite') * 5], null)
// Silicon Dioxide Dust * 4
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustGraniteBlack') * 5], null)
//Rare Earth
mods.gregtech.centrifuge.removeByInput(20, [metaitem('dustRareEarth')], null)
// Dark Ashes * 1
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:blaze_powder') * 2], null)
//Lava
mods.gregtech.centrifuge.removeByInput(80, null, [fluid('lava') * 100])
// Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustIronMagnetic')], null)
// Steel Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustSteelMagnetic')], null)
// Steel Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustDamascusSteel')], null)
// Calcite Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustRedrock') * 3], null)
// Copper Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustAnnealedCopper')], null)
// Methane * 54
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:persimmon')], null)
// Methane * 35
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:porkchop')], null)
// Methane * 94
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:pumpkin_pie')], null)
// Methane * 126
mods.gregtech.centrifuge.removeByInput(5, [item('quark:golden_frog_leg')], null)
// Methane * 144
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:rabbit_stew')], null)
// Methane * 35
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:beef')], null)
// Methane * 12
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:potato')], null)
// Methane * 58
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:pear')], null)
// Methane * 130
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_porkchop')], null)
// Methane * 35
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:rabbit')], null)
// Methane * 40
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:rotten_flesh')], null)
// Methane * 18
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:red_mushroom')], null)
// Methane * 14
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:beetroot')], null)
// Methane * 119
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:golden_carrot')], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:mutton')], null)
// Methane * 10
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:berries')], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:melon')], null)
// Methane * 18
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:nether_wart')], null)
// Methane * 47
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:apple')], null)
// Methane * 20
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:fish')], null)
// Methane * 20
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:fish', 1)], null)
// Methane * 10
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:fish', 2)], null)
// Methane * 10
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:fish', 3)], null)
// Methane * 38
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:filled_honeycomb')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.corn.cob')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:food.lemon')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:food.lime')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:crop.olive')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:crop.tomato')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:crop.onion')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:crop.cucumber')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:food.banana')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:food.orange')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:food.mango')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:food.apricot')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.soybean')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:crop.coffee')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.pea_pod')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:seed.bean')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.horseradish')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.basil')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.oregano')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.artichoke')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.black_pepper')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.rice')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:component.garlic_bulb')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [metaitem('gregtechfoodoption:crop.aubergine')], null)
// Methane * 72
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:bread')], null)
// Methane * 47
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:chorus_fruit')], null)
// Methane * 81
mods.gregtech.centrifuge.removeByInput(5, [item('quark:cooked_frog_leg')], null)
// Methane * 72
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_fish')], null)
// Methane * 97
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_fish', 1)], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:chicken')], null)
// Methane * 72
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_rabbit')], null)
// Methane * 79
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:golden_apple')], null)
// Methane * 79
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:golden_apple', 1)], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('quark:frog_leg')], null)
// Methane * 130
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_beef')], null)
// Methane * 10
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:shroompowder')], null)
// Methane * 18
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:brown_mushroom')], null)
// Methane * 86
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_chicken')], null)
// Methane * 12
mods.gregtech.centrifuge.removeByInput(5, [item('quark:crab_leg')], null)
// Methane * 54
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:peach')], null)
// Methane * 86
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:mushroom_stew')], null)
// Methane * 130
mods.gregtech.centrifuge.removeByInput(5, [item('quark:cooked_crab_leg')], null)
// Methane * 72
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:baked_potato')], null)
// Methane * 86
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:beetroot_soup')], null)
// Methane * 29
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:ricebowl')], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:poisonous_potato')], null)
// Methane * 32
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:spider_eye')], null)
// Methane * 20
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cookie')], null)
// Methane * 97
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_mutton')], null)
// Methane * 43
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:carrot')], null)
// Methane Gas * 78
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:apple_baked')], null)
// Methane Gas * 86
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:carrot_roasted')], null)
// Methane Gas * 86
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:egg_roasted')], null)
// Methane Gas * 72
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:mushroom_brown_roasted')], null)
// Methane Gas * 72
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:mushroom_red_roasted')], null)
// Methane Gas * 34
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:beetroot_roasted')], null)
// Methane Gas * 20
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:burned_food')], null)
// Methane Gas * 22
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:strange_tuber')], null)
// Methane Gas * 10
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:pyroberry_wine')], null)
// Methane Gas * 10
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:gloamberry_wine')], null)
// Methane Gas * 10
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:freckleberry_wine')], null)
// Methane Gas * 9
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:tainted_meat')], null)
// Methane Gas * 20
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:pyroberries')], null)
// Methane Gas * 20
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:gloamberries')], null)
// Methane Gas * 20
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:freckleberries')], null)
// Methane Gas * 9
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:marshmallow')], null)
// Methane Gas * 20
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:marshmallow_roasted')], null)
// Methane Gas * 9
mods.gregtech.centrifuge.removeByInput(5, [item('pyrotech:marshmallow_burned')], null)
// Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustYellowLimonite') * 4], null)
// Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustBrownLimonite') * 4], null)
// Baking Soda Solution * 1000
mods.gregtech.mixer.removeByInput(8, [metaitem('dustSodiumBicarbonate')], [fluid('water') * 1000])
// Crushed Bauxite Ore * 1
mods.gregtech.forge_hammer.removeByInput(16, [item('gregtech:ore_bauxite_0')], null)
// Crushed Bauxite Ore * 2
mods.gregtech.macerator.removeByInput(2, [item('gregtech:ore_bauxite_0')], null)
// Flower Pot * 1
mods.gregtech.assembler.removeByInput(2, [item('minecraft:brick') * 3], null)
// Tungsten Steel * 2
mods.gregtech.mixer.removeByInput(1920, [metaitem('dustTungsten'), metaitem('dustSteel'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Molten Tungstensteel * 288
mods.gregtech.advanced_arc_furnace.removeByInput(1920, [metaitem('dustSteel'), metaitem('dustTungsten'), metaitem('circuit.integrated').withNbt(['Configuration': 12])], [fluid('helium') * 200 * 200, fluid('refractory_gunning_mixture') * 50 * 50])
// Molten Tungstensteel * 288
mods.gregtech.advanced_arc_furnace.removeByInput(1920, [metaitem('dustSteel'), metaitem('dustTungsten'), metaitem('circuit.integrated').withNbt(['Configuration': 2])], [fluid('refractory_gunning_mixture') * 50 * 50])
// Diesel * 6000
mods.gregtech.blender.removeByInput(120, null, [fluid('light_fuel') * 5000 * 5000, fluid('heavy_fuel') * 1000 * 1000])
// Tungstensteel Dust * 2
mods.gregtech.blender.removeByInput(1920, [metaitem('dustTungsten'), metaitem('dustSteel'), metaitem('circuit.integrated').withNbt(['Configuration': 1])], null)
// Tempered Glass * 1
mods.gregtech.arc_furnace.removeByInput(30, [item('minecraft:glass')], [fluid('oxygen') * 60 * 60])
// Yttria Stabilized Zirconia Plate * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('dustYttriaStabilizedZirconia')], null)
// Small Ethylene-Vinyl Acetate (EVA) Fluid Pipe * 1
mods.gregtech.extruder.removeByInput(42, [metaitem('ingotEthyleneVinylAcetate'), metaitem('shape.extruder.pipe.small')], null)
// Small Ethylene-Vinyl Acetate (EVA) Fluid Pipe * 1
mods.gregtech.extruder.removeByInput(42, [metaitem('dustEthyleneVinylAcetate'), metaitem('shape.extruder.pipe.small')], null)
// Polysulfone Rod * 2
mods.gregtech.extruder.removeByInput(42, [metaitem('ingotPolysulfone'), metaitem('shape.extruder.rod')], null)
// Viton Ring * 4
mods.gregtech.extruder.removeByInput(42, [metaitem('ingotViton'), metaitem('shape.extruder.ring')], null)
// Viton Ring * 4
mods.gregtech.extruder.removeByInput(42, [metaitem('dustViton'), metaitem('shape.extruder.ring')], null)
// Polyvinylidene Fluoride (PVDF) Sheet * 1
mods.gregtech.extruder.removeByInput(56, [metaitem('ingotPolyvinylideneFluoride'), metaitem('shape.extruder.plate')], null)
// Polyvinylidene Fluoride (PVDF) Sheet * 1
mods.gregtech.extruder.removeByInput(56, [metaitem('dustPolyvinylideneFluoride'), metaitem('shape.extruder.plate')], null)
// Thin Polyphenylene Sulfide Sheet * 4
mods.gregtech.extruder.removeByInput(24, [metaitem('ingotPolyphenyleneSulfide'), metaitem('shape.extruder.foil')], null)
// Thin Polyphenylene Sulfide Sheet * 4
mods.gregtech.extruder.removeByInput(24, [metaitem('dustPolyphenyleneSulfide'), metaitem('shape.extruder.foil')], null)
// Thin Polyphenylene Sulfide Sheet * 4
mods.gregtech.bender.removeByInput(24, [metaitem('platePolyphenyleneSulfide'), metaitem('circuit.integrated').withNbt(['Configuration': 1])], null)
// Thin Polyphenylene Sulfide Sheet * 4
mods.gregtech.bender.removeByInput(24, [metaitem('ingotPolyphenyleneSulfide'), metaitem('circuit.integrated').withNbt(['Configuration': 10])], null)
// Ethenone * 100
mods.gregtech.fluid_heater.removeByInput(30, [metaitem('circuit.integrated').withNbt(['Configuration': 1])], [fluid('acetone') * 100])


RecipeMaps.SIFTER_RECIPES
    .modifyMaxFluidInputs(1)
    .modifyMaxFluidOutputs(1)
    .modifyMaxInputs(2)
    .modifyMaxOutputs(8)

RecipeMaps.CENTRIFUGE_RECIPES
    .modifyMaxFluidInputs(3)
    .setSlotOverlay(false, true, false, GuiTextures.CENTRIFUGE_OVERLAY)

RecipeMaps.MIXER_RECIPES
    .modifyMaxFluidInputs(3)
    .modifyMaxFluidOutputs(2)

RecipeMaps.ARC_FURNACE_RECIPES
    .modifyMaxInputs(4)

RecipeMaps.ELECTROLYZER_RECIPES
    .modifyMaxInputs(4)
    .modifyMaxOutputs(3)
    .modifyMaxFluidOutputs(3)

RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES
    .modifyMaxFluidInputs(1)
    .modifyMaxFluidOutputs(2)
    .modifyMaxOutputs(4)

GTFORecipeMaps.GREENHOUSE_RECIPES
    .modifyMaxFluidInputs(4)

RecipeMaps.PYROLYSE_RECIPES
    .modifyMaxFluidOutputs(3)

RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES
    .setSlotOverlay(false, false, SusyGuiTextures.ELECTROMAGNETIC_SEPARATOR_ITEM_OVERLAY)
    .setSlotOverlay(false, true, SusyGuiTextures.ELECTROMAGNETIC_SEPARATOR_FLUID_OVERLAY)

RecipeMaps.SIFTER_RECIPES
    .setSlotOverlay(false, true, SusyGuiTextures.SIFTER_FLUID_OVERLAY)
    .setSlotOverlay(true, true, SusyGuiTextures.SIFTER_FLUID_OVERLAY)
    .setSlotOverlay(false, false, SusyGuiTextures.SIFTER_ITEM_INPUT_OVERLAY)
    .setSlotOverlay(true, false, SusyGuiTextures.SIFTER_ITEM_OUTPUT_OVERLAY)

RecipeMaps.LASER_ENGRAVER_RECIPES
    .modifyMaxFluidInputs(1)

RecipeMaps.GAS_TURBINE_FUELS
    .modifyMaxInputs(1)
    .modifyMaxFluidInputs(3)
    .modifyMaxFluidOutputs(1)

RecipeMaps.AUTOCLAVE_RECIPES
    .modifyMaxFluidInputs(4)
    .modifyMaxFluidOutputs(2)

RecipeMaps.CHEMICAL_BATH_RECIPES
    .modifyMaxOutputs(3)
    .modifyMaxFluidInputs(3)
    .modifyMaxFluidOutputs(3)

RecipeMaps.EXTRUDER_RECIPES
    .modifyMaxOutputs(3)
    .modifyMaxFluidInputs(1)

RecipeMaps.CUTTER_RECIPES
    .modifyMaxOutputs(4)

RecipeMaps.FORGE_HAMMER_RECIPES
    .modifyMaxInputs(2)

RecipeMaps.LARGE_CHEMICAL_RECIPES
    .modifyMaxInputs(4)
    .modifyMaxFluidInputs(6)
