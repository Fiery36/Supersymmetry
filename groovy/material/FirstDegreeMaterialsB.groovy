package material;

import static material.SuSyMaterials.*;
import static globals.Globals.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.fluids.store.FluidStorage;
import gregtech.api.unification.material.properties.*
import gregtech.api.GTValues;
import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;
import static gregtech.api.fluids.FluidConstants.*;

import supercritical.api.unification.material.properties.FissionFuelProperty;
import supercritical.api.unification.material.properties.SCPropertyKey;

public class FirstDegreeMaterialsB {
    public static void register() {

        log.infoMC('Registering First Degree Materials B!');

        Zircaloy4 = new Material.Builder(8710, SuSyUtility.susyId('zircaloy_4'))
                .ingot().liquid(new FluidBuilder().temperature(2200))
                .components(Zirconium * 18, Tin * 3, Iron * 2, Chrome)
                .color(0x566570)
                .iconSet(METALLIC)
                .flags(GENERATE_RING, GENERATE_RING, GENERATE_PLATE, GENERATE_FRAME, GENERATE_SPRING, GENERATE_BOLT_SCREW)
                .blastTemp(2200, GasTier.MID, GTValues.VA[GTValues.EV])
                .fluidPipeProperties(1500, 1500, true, true, true, false)
                .build()

        ReactorSteel = new Material.Builder(8711, SuSyUtility.susyId('reactor_steel'))
                .ingot().liquid(new FluidBuilder().temperature(1800))
                .iconSet(SHINY)
                .flags(GENERATE_DOUBLE_PLATE)
                .components(Iron * 113, Manganese * 10, Molybdenum * 2, Nickel * 3)
                .colorAverage()
                .blastTemp(1800, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        Inconel718 = new Material.Builder(8297, SuSyUtility.susyId('inconel_718'))
                .ingot().liquid(new FluidBuilder().temperature(1610))
                .colorAverage()
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_DOUBLE_PLATE, GENERATE_SPRING, GENERATE_FRAME, SUPERALLOY)
                .components(Nickel * 41, Iron * 19, Chrome * 20, Niobium * 3, Molybdenum * 2, Titanium, Aluminium * 2)
                .blastTemp(1610, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        SilverIndiumCadmium = new Material.Builder(8712, SuSyUtility.susyId('silver_indium_cadmium'))
                .ingot().liquid(new FluidBuilder().temperature(1100))
                .components(Silver * 17, Indium * 3, Cadmium * 1)
                .colorAverage()
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .blastTemp(1100, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();
    }
}