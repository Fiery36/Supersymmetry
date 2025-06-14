import gregtech.loaders.recipe.handlers.OreRecipeHandler;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.material.Material;
import classes.*;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.ore.OrePrefix;


CHEMICAL_BATH = recipemap('chemical_bath')
QUENCHER = recipemap('quencher')
RADIATOR = recipemap('radiator')
COOLING_UNIT = recipemap('cooling_unit')

//IQuenchingFluid(cold fluid, hot fluid, amount, duration, isInert, generateHeatRadiatorRecipes)

IQuenchingFluid Water = new IQuenchingFluid("water", 'warm_water', 1000, 100.0, false);
IQuenchingFluid Air = new IQuenchingFluid('air', 'hot_air', 10000, 1000.0, false);
IQuenchingFluid CompressedAir = new IQuenchingFluid('hp_air', 'hot_hp_air', 5000, 500.0, false);
IQuenchingFluid Nitrogen = new IQuenchingFluid('nitrogen', 'hot_nitrogen', 10000, 500.0, true);
IQuenchingFluid CompressedNitrogen = new IQuenchingFluid('hp_nitrogen', 'hot_hp_nitrogen', 5000, 500.0, true);
IQuenchingFluid SaltWater = new IQuenchingFluid('salt_water', 'warm_salt_water', 1000, 150.0, false);
IQuenchingFluid Brine = new IQuenchingFluid('brine', 'warm_brine', 1000, 150.0, false);

//Material name, blast furnace temperature

def ingotMap = [
    'Europium':6000,
    'Iridium':4500,
    'Molybdenum':2890,
    'Niobium':2750,
    'Osmium':4500,
    'Palladium':1828,
    'Platinum':2045,
    'Rhodium':2237,
    'Ruthenium':2607,
    'Samarium':5400,
    'Tantalum':3293,
    'Thorium':2028,
    'Titanium':2141,
    'Tungsten':3600,
    'Vanadium':2183,
    'Yttrium':1799,
    'Naquadah':5000,
    'NaquadahEnriched':7000,
    'Naquadria':9000,
    'Trinium':7200,
    'Kanthal':1800,
    'Nichrome':2700,
    'NiobiumNitride':2846,
    'NiobiumTitanium':4500,
    'BlackBronze':2000,
    'Ruridit':4500,
    'Ultimet':2700,
    'VanadiumGallium':4500,
    'YttriumBariumCuprate':4500,
    'Osmiridium':4500,
    'TungstenCarbide':3068,
    'MagnesiumDiboride':2500,
    'MercuryBariumCalciumCuprate':3300,
    'UraniumTriplatinum':4400,
    'SamariumIronArsenicOxide':5200,
    'IndiumTinBariumTitaniumCuprate':6000,
    'UraniumRhodiumDinaquadide':9000,
    'EnrichedNaquadahTriniumEuropiumDuranide':9900,
    'RutheniumTriniumAmericiumNeutronate':10800,
    'TungstenSteel':3000,
    'RtmAlloy': 3200,
    'NaquadahAlloy':7200,
    'RhodiumPlatedPalladium':4500,
    'Hssg':4200,
    'Hsse':5000,
    'Hsss':5000,
    'Stellite100':3790,
    'WatertightSteel':3850,
    'MaragingSteel300':4000,
    'HastelloyC276':4625,
    'HastelloyX':4200,
    'Trinaquadalloy':8747,
    'Zeron100':3693,
    'TitaniumCarbide':3430,
    'TantalumCarbide':4120,
    'MolybdenumDisilicide':2300,
    'TitaniumTungstenCarbide':3800,
    'IncoloyMa956':3625,
    'Incoloy825':3000,
    'Incoloy908':3000,
    'ReneN5':3000,
    'Monel500':3000,
    'StelliteJ':3800,
    'Stellite6':3000,
    'Hsla980X':2600,
    'FoodGradeStainlessSteel':2600,
    'PlatinumRhodium':2113
]

//MV Tweaks (from CEu #1724)

// Kanthal Ingot * 1
mods.gregtech.chemical_bath.removeByInput(120, [metaitem('ingotHotKanthal')], [fluid('water') * 100])
// Kanthal Ingot * 1
mods.gregtech.chemical_bath.removeByInput(120, [metaitem('ingotHotKanthal')], [fluid('distilled_water') * 100])

for (fluid in IQuenchingFluid.quenching_fluids) {
    CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('ingotHotKanthal'))
        .fluidInputs(liquid(fluid.getColdFluid()) * fluid.amount)
        .outputs(metaitem('ingotKanthal'))
        .fluidOutputs(liquid(fluid.getHotFluid()) * fluid.amount)
        .duration((int) fluid.getDuration() * 4)
        .EUt(120)
        .buildAndRegister();
}

for (entry in ingotMap) {
    for (fluid in IQuenchingFluid.quenching_fluids) {
    QUENCHER.recipeBuilder()
        .inputs(ore('ingotHot' + entry.key))
        .fluidInputs(liquid(fluid.getColdFluid()) * fluid.amount)
        .outputs(metaitem('ingot' + entry.key))
        .fluidOutputs(liquid(fluid.getHotFluid()) * fluid.amount)
        .duration((int) (fluid.getDuration() * (float) (entry.value / 2000)))
        .EUt(120)
        .buildAndRegister();
    }
}

def fluidMap = [
    'molten.kanthal':'Kanthal',
    'molten.nichrome':'Nichrome',
    'molten.niobium_nitride':'NiobiumNitride',
    'molten.niobium_titanium':'NiobiumTitanium',
    'molten.black_bronze':'BlackBronze',
    'molten.ruridit':'Ruridit',
    'molten.ultimet':'Ultimet',
    'molten.vanadium_gallium':'VanadiumGallium',
    'molten.yttrium_barium_cuprate':'YttriumBariumCuprate',
    'molten.osmiridium':'Osmiridium',
    'molten.tungsten_carbide':'TungstenCarbide',
    'molten.magnesium_diboride':'MagnesiumDiboride',
    'molten.mercury_barium_calcium_cuprate':'MercuryBariumCalciumCuprate',
    'molten.uranium_triplatinum':'UraniumTriplatinum',
    'molten.samarium_iron_arsenic_oxide':'SamariumIronArsenicOxide',
    'molten.indium_tin_barium_titanium_cuprate':'IndiumTinBariumTitaniumCuprate',
    'molten.uranium_rhodium_dinaquadide':'UraniumRhodiumDinaquadide',
    'molten.enriched_naquadah_trinium_europium_duranide':'EnrichedNaquadahTriniumEuropiumDuranide',
    'molten.ruthenium_trinium_americium_neutronate':'RutheniumTriniumAmericiumNeutronate',
    'molten.tungsten_steel':'TungstenSteel',
    'molten.naquadah_alloy':'NaquadahAlloy',
    'molten.rhodium_plated_palladium':'RhodiumPlatedPalladium',
    'molten.hssg':'Hssg',
    'molten.hsse':'Hsse',
    'molten.hsss':'Hsss',
    'molten.stellite_100':'Stellite100',
    'molten.watertight_steel':'WatertightSteel',
    'molten.maraging_steel_300':'MaragingSteel300',
    'molten.hastelloy_c_276':'HastelloyC276',
    'molten.hastelloy_x':'HastelloyX',
    'molten.trinaquadalloy':'Trinaquadalloy',
    'molten.zeron_100':'Zeron100',
    'molten.titanium_carbide':'TitaniumCarbide',
    'molten.tantalum_carbide':'TantalumCarbide',
    'molten.molybdenum_disilicide':'MolybdenumDisilicide',
    'molten.titanium_tungsten_carbide':'TitaniumTungstenCarbide',
    'molten.incoloy_ma_956':'IncoloyMa956',
    'molten.incoloy_20':'Incoloy20',
    'molten.incoloy_825':'Incoloy825',
    'molten.incoloy_908':'Incoloy908',
    'molten.rene_n_5':'ReneN5',
    'molten.monel_500':'Monel500',
    'molten.stellite_j':'StelliteJ',
    'molten.stellite_6':'Stellite6',
    'molten.hsla_980_x':'Hsla980X',
    'molten.food_grade_stainless_steel':'FoodGradeStainlessSteel'
]

for (entry in fluidMap) {
    for (fluid in IQuenchingFluid.quenching_fluids) {
        QUENCHER.recipeBuilder()
            .notConsumable(metaitem('shape.mold.ingot'))
            .fluidInputs(liquid(entry.key) * 144)
            .fluidInputs(liquid(fluid.getColdFluid()) * fluid.amount)
            .outputs(metaitem('ingot' + entry.value))
            .fluidOutputs(liquid(fluid.getHotFluid()) * fluid.amount)
            .duration((int) ((int) fluid.getDuration() * (int) 2))
            .EUt(120)
            .buildAndRegister();
    }
}

// Air cooling
RADIATOR.recipeBuilder()
    .fluidInputs(fluid('hot_air') * 1000)
    .fluidOutputs(liquid('air') * 1000)
    .duration(100)
    .buildAndRegister();

COOLING_UNIT.recipeBuilder()
    .fluidInputs(fluid('hot_air') * 1000)
    .fluidOutputs(liquid('air') * 1000)
    .duration(50)
    .EUt(480)
    .buildAndRegister();
