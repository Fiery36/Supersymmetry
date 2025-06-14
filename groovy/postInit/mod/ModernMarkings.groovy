mods.chisel.carving.addGroup("markings_basic")
mods.chisel.carving.addGroup("markings_symbolic")
mods.chisel.carving.addGroup("markings_electric")

def basic = [
    'ags_modernmarkings:floor_marking_white_singleline',
    'ags_modernmarkings:floor_marking_black_singleline',
    'ags_modernmarkings:floor_marking_blue_singleline',
    'ags_modernmarkings:floor_marking_green_singleline',
    'ags_modernmarkings:floor_marking_orange_singleline',
    'ags_modernmarkings:floor_marking_red_hazardline',
    'ags_modernmarkings:wall_marking_hazardline_left',
    'ags_modernmarkings:wall_marking_hazardline_right',
    'ags_modernmarkings:floor_marking_yellow_hazardline',
    'ags_modernmarkings:floor_marking_red_singleline',
    'ags_modernmarkings:floor_marking_white_lane',
    'ags_modernmarkings:floor_marking_white_lane_cross',
    'ags_modernmarkings:floor_marking_white_square',
    'ags_modernmarkings:floor_marking_whiteblack_hazardline',
    'ags_modernmarkings:floor_marking_yellow_hazardline',
    'ags_modernmarkings:floor_marking_yellow_lane',
    'ags_modernmarkings:floor_marking_yellow_sideline',
    'ags_modernmarkings:floor_marking_yellow_singleline',
    'ags_modernmarkings:floor_marking_yellow_square',
    'ags_modernmarkings:floor_marking_yellow_stripes'
]

for (anItem in basic) {
	crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_basic", item(anItem))
}

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCalcite'))
    .fluidInputs(fluid('water') * 100)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_white_singleline'))
    .EUt(8)
    .duration(30)
    .buildAndRegister()

def symbolic = [
    'ags_modernmarkings:wall_marking_number_0',
    'ags_modernmarkings:wall_marking_symbol_frost',
    'ags_modernmarkings:wall_marking_symbol_gears',
    'ags_modernmarkings:wall_marking_symbol_laser',
    'ags_modernmarkings:wall_marking_symbol_magic',
    'ags_modernmarkings:wall_marking_symbol_mob',
    'ags_modernmarkings:wall_marking_symbol_pinch',
    'ags_modernmarkings:wall_marking_symbol_production',
    'ags_modernmarkings:wall_marking_symbol_radiation',
    'ags_modernmarkings:wall_marking_symbol_storage',
    'ags_modernmarkings:floor_marking_danger_red',
    'ags_modernmarkings:floor_marking_danger_yellow',
    'ags_modernmarkings:floor_marking_exit',
    'ags_modernmarkings:floor_marking_noentry',
    'ags_modernmarkings:floor_marking_nostep',
    'ags_modernmarkings:floor_marking_redx',
    'ags_modernmarkings:floor_marking_white_arrow',
    'ags_modernmarkings:floor_marking_yellow_arrow',
    'ags_modernmarkings:wall_marking_number_1',
    'ags_modernmarkings:wall_marking_number_2',
    'ags_modernmarkings:wall_marking_number_3',
    'ags_modernmarkings:wall_marking_number_4',
    'ags_modernmarkings:wall_marking_number_5',
    'ags_modernmarkings:wall_marking_number_6',
    'ags_modernmarkings:wall_marking_number_7',
    'ags_modernmarkings:wall_marking_number_8',
    'ags_modernmarkings:wall_marking_number_9',
    'ags_modernmarkings:wall_marking_number_no',
    'ags_modernmarkings:wall_marking_number_numero',
    'ags_modernmarkings:wall_marking_number_dash',
    'ags_modernmarkings:wall_marking_number_comma',
    'ags_modernmarkings:wall_marking_number_period',
    'ags_modernmarkings:wall_marking_symbol_chemical',
    'ags_modernmarkings:wall_marking_symbol_electric',
    'ags_modernmarkings:wall_marking_symbol_fire',
    'ags_modernmarkings:wall_marking_symbol_fluid'
]

for (anItem in symbolic) {
	crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_symbolic", item(anItem))
}

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCalcite') * 2)
    .fluidInputs(fluid('water') * 150)
    .circuitMeta(2)
    .outputs(item('ags_modernmarkings:wall_marking_number_0'))
    .EUt(8)
    .duration(30)
    .buildAndRegister()

def electric = [
    'ags_modernmarkings:wall_marking_voltage_eu',
    'ags_modernmarkings:wall_marking_voltage_fe',
    'ags_modernmarkings:wall_marking_voltage_rf',
    'ags_modernmarkings:wall_marking_voltage_pert',
    // No ULV tier :(
    'ags_modernmarkings:wall_marking_voltage_lv',
    'ags_modernmarkings:wall_marking_voltage_mv',
    'ags_modernmarkings:wall_marking_voltage_hv',
    'ags_modernmarkings:wall_marking_voltage_ev',
    'ags_modernmarkings:wall_marking_voltage_iv',
    'ags_modernmarkings:wall_marking_voltage_luv',
    'ags_modernmarkings:wall_marking_voltage_zpm',
    'ags_modernmarkings:wall_marking_voltage_uv',
    'ags_modernmarkings:wall_marking_voltage_uhv',
    'ags_modernmarkings:wall_marking_voltage_uev',
    'ags_modernmarkings:wall_marking_voltage_uiv',
    'ags_modernmarkings:wall_marking_voltage_umv',
    'ags_modernmarkings:wall_marking_voltage_uxv',
    'ags_modernmarkings:wall_marking_voltage_max'
]

for (anItem in electric) {
	crafting.remove(anItem) // Should all be the same name
    mods.chisel.carving.addVariation("markings_electric", item(anItem))
}

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCalcite') * 2)
    .fluidInputs(fluid('water') * 200)
    .circuitMeta(3)
    .outputs(item('ags_modernmarkings:wall_marking_voltage_eu'))
    .EUt(8)
    .duration(30)
    .buildAndRegister()

crafting.remove('ags_modernmarkings:floor_marking_danger_red_from_yellow')
crafting.remove('ags_modernmarkings:floor_marking_danger_yellow_from_red')
crafting.remove('ags_modernmarkings:wall_marking_voltage_fe_from_rf')