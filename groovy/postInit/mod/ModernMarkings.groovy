mods.chisel.carving.addGroup("markings_basic")
mods.chisel.carving.addGroup("markings_symbolic")
mods.chisel.carving.addGroup("markings_electric")

def basic = [
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
    'ags_modernmarkings:floor_marking_white_singleline',
    'ags_modernmarkings:floor_marking_white_square',
    'ags_modernmarkings:floor_marking_whiteblack_hazardline',
    'ags_modernmarkings:floor_marking_yellow_hazardline',
    'ags_modernmarkings:floor_marking_yellow_lane',
    'ags_modernmarkings:floor_marking_yellow_sideline',
    'ags_modernmarkings:floor_marking_yellow_singleline',
    'ags_modernmarkings:floor_marking_yellow_square',
    'ags_modernmarkings:floor_marking_yellow_stripes'
]

for (def item : basic) {
	crafting.remove(basic) // Should all be the same name
    mods.chisel.carving.addVariation("markings_basic", item(basic))
}

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCalcite'))
    .fluidInputs(fluid('water') * 100)
    .circuitMeta(1)
    .outputs(item('ags_modernmarkings:floor_marking_white_singleline'))
    .EUt(8)
    .duration(30)
    .buildAndRegister()