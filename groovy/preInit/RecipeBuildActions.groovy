package preInit

//import gregtech.api.GregTechAPI
import gregtech.api.recipes.RecipeMap
import gregtech.api.recipes.RecipeMaps
import gregtech.api.recipes.ingredients.GTRecipeInput

import supersymmetry.api.recipes.SuSyRecipeMaps

//import static gregtech.api.recipes.RecipeMaps.*

//Add mixer recipes to blender

RecipeMaps.MIXER_RECIPES.onRecipeBuild(recipeBuilder -> {
    recipeBuilder.invalidateOnBuildAction();
    SuSyRecipeMaps.BLENDER_RECIPES.recipeBuilder()
        .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
        .fluidInputs(recipeBuilder.getFluidInputs())
        .outputs(recipeBuilder.getOutputs())
        .chancedOutputs(recipeBuilder.getChancedOutputs())
        .fluidOutputs(recipeBuilder.getFluidOutputs())
        .cleanroom(recipeBuilder.getCleanroom())
        .duration(recipeBuilder.getDuration())
        .EUt(recipeBuilder.EUt)
        .buildAndRegister();
});