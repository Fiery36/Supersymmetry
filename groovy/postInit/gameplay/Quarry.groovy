import gregtech.api.recipes.RecipeBuilder
import globals.Globals
QUARRY = recipemap('quarry')


crafting.addShaped("susy:quarry_controller", metaitem('quarry'), [
        [ore('plateSteel'), metaitem('electric.motor.lv'), ore('plateSteel')],
        [ore('circuitLv'), metaitem('hull.lv'), ore('circuitLv')],
        [ore('cableGtSingleTin'), metaitem('component.grinder.diamond'), ore('cableGtSingleTin')]
])



def overworld_ores = [
        item('minecraft:stone'),
        item('minecraft:stone', 1),
        item('minecraft:stone', 3),
        item('minecraft:stone', 5),
        item('minecraft:cobblestone'),
        item('pyrotech:cobblestone'),
        item('pyrotech:cobblestone', 1),
        item('pyrotech:cobblestone', 2),
        item('susy:susy_stone_smooth'),
        item('susy:susy_stone_smooth', 5),
        item('susy:susy_stone_cobble'),
        item('susy:susy_stone_cobble', 5),
]
def beneath_ores = [
        item('susy:susy_stone_smooth', 1),
        item('susy:susy_stone_smooth', 3),
        item('susy:susy_stone_smooth', 6),
        item('susy:susy_stone_cobble', 1),
        item('susy:susy_stone_cobble', 3),
        item('susy:susy_stone_cobble', 6),
]

//overworld rocks:
for(entry in overworld_ores){
    QUARRY.recipeBuilder()
            .notConsumable(entry)
            .outputs(entry)
            .dimension(Globals.dimensions["Overworld"])
            .duration(100)
            .EUt(16)
            .buildAndRegister();
    QUARRY.recipeBuilder()
            .circuitMeta(1)
            .chancedOutput(item('minecraft:stone'), 1667, 500)
            .chancedOutput(item('minecraft:stone', 1), 1667, 500)
            .chancedOutput(item('minecraft:stone', 3), 1667, 500)
            .chancedOutput(item('minecraft:stone', 5), 1667, 500)
            .chancedOutput(item('susy:susy_stone_smooth', 1), 1667, 500)
            .chancedOutput(item('susy:susy_stone_smooth', 5), 1667, 500)
            .outputs(entry)
            .dimension(Globals.dimensions["Overworld"])
            .duration(100)
            .EUt(16)
            .buildAndRegister();

    QUARRY.recipeBuilder()
            .circuitMeta(2)
            .chancedOutput(item('minecraft:cobblestone'), 1667, 500)
            .chancedOutput(item('pyrotech:cobblestone'), 1667, 500)
            .chancedOutput(item('pyrotech:cobblestone', 1), 1667, 500)
            .chancedOutput(item('pyrotech:cobblestone', 2), 1667, 500)
            .chancedOutput(item('susy:susy_stone_cobble', 1), 1667, 500)
            .chancedOutput(item('susy:susy_stone_cobble', 5), 1667, 500)
            .outputs(entry)
            .dimension(Globals.dimensions["Overworld"])
            .duration(100)
            .EUt(16)
            .buildAndRegister();
}



//beneath rocks:
for(entry in beneath_ores){
    QUARRY.recipeBuilder()
            .notConsumable(entry)
            .outputs(entry)
            .dimension(Globals.dimensions["Beneath"])
            .duration(100)
            .EUt(64)
            .buildAndRegister();
    QUARRY.recipeBuilder()
            .circuitMeta(1)
            .chancedOutput(item('susy:susy_stone_smooth', 1), 3333, 500)
            .chancedOutput(item('susy:susy_stone_smooth', 2), 3333, 500)
            .chancedOutput(item('susy:susy_stone_smooth', 2), 3333, 500)
            .outputs(entry)
            .dimension(Globals.dimensions["Beneath"])
            .duration(100)
            .EUt(64)
            .buildAndRegister();
    QUARRY.recipeBuilder()
            .circuitMeta(2)
            .chancedOutput(item('susy:susy_stone_cobble', 1), 3333, 500)
            .chancedOutput(item('susy:susy_stone_cobble', 2), 3333, 500)
            .chancedOutput(item('susy:susy_stone_cobble', 2), 3333, 500)
            .outputs(entry)
            .dimension(Globals.dimensions["Beneath"])
            .duration(100)
            .EUt(64)
            .buildAndRegister();
}