package skully.fma.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import skully.fma.api.CoreApi;
import skully.fma.core.config.ConfigSettings;
import skully.fma.core.enums.BagEnumState;
import skully.fma.core.enums.EnumState;
import skully.fma.core.enums.TattooEnumState;
import skully.fma.item.alchemical.ItemAlchemicCrystal;
import skully.fma.item.alchemical.ItemFireGlove;
import skully.fma.item.alchemical.ItemIceGauntlet;
import skully.fma.item.alchemical.ItemKunaiEnder;
import skully.fma.item.alchemical.ItemKunaiFire;
import skully.fma.item.alchemical.ItemPStone;
import skully.fma.item.alchemical.ItemReconstructionCircle;
import skully.fma.item.energy.ItemEnergyMeasurer;
import skully.fma.item.energy.ItemEnergyStore;
import skully.fma.item.research.ItemAlchNotebook;
import skully.fma.item.research.ItemAlchNotes;
import skully.fma.item.research.ItemChalkStick;


/**
 * @author viper283
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FMAItems {

    public static Item metaTest;
    public static Item pStone;
    public static Item redStone;
    public static Item alchemicCrystal;
    public static Item Stone;
    public static Item stone0;
    public static Item ash;
    public static Item eash;
    public static Item gash;
    public static Item ChalkStick;
    public static Item FireGlove;
    public static Item AlchSilk;
    public static Item FireCircle;
    public static Item ChalkCircle;
    public static Item ChalkPyramid;
    public static Item IceGauntlet;
    public static Item ReconstructionCircle;
    public static Item AlchNotebook;
    public static Item AlchNotes;
    public static Item Kunai;
    public static Item KunaiFire;
    public static Item KunaiEnder;
    public static Item ChalkBag;
    public static Item energyMeasurer;
    public static Item EnergyStore;


    public static String[] meta_names = new String[] {
            "chalkDust",
            "flacon",
            "flask",
            "bloodDrop",
            "alchemicalWool",
            "alchemicalSilk",
            "EStone",
            "GStone"
    };

    public static void initialize() {

        pStone = new ItemPStone(ConfigSettings.pStoneID, EnumState.OFF).setUnlocalizedName("pStone").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabTools)).setMaxStackSize(1);
        alchemicCrystal = new ItemAlchemicCrystal(ConfigSettings.alchemicCrystal).setUnlocalizedName("alchemicCrystal");
        redStone = new ItemRedStone(ConfigSettings.redStone, EnumState.OFF).setUnlocalizedName("redStone");
        stone0 = new Itemstone0(ConfigSettings.stone0).setUnlocalizedName("stone0").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        ash = new ItemAsh(ConfigSettings.ash).setUnlocalizedName("ash").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        eash = new ItemEash(ConfigSettings.eash).setUnlocalizedName("eash").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        gash = new ItemGash(ConfigSettings.gash).setUnlocalizedName("gash").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        ChalkStick = new ItemChalkStick(ConfigSettings.ChalkStick).setUnlocalizedName("ChalkStick").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        FireGlove = new ItemFireGlove(ConfigSettings.FireGlove).setUnlocalizedName("FireGlove").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabCombat));
        FireCircle = new ItemFireCircle(ConfigSettings.FireCircle).setUnlocalizedName("FireCircle").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        ChalkCircle = new ItemChalkCircle(ConfigSettings.ChalkCircle).setUnlocalizedName("ChalkCircle").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        ChalkPyramid = new ItemChalkPyramid(ConfigSettings.ChalkPyramid).setUnlocalizedName("ChalkPyramid").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        IceGauntlet = new ItemIceGauntlet(ConfigSettings.IceGauntlet).setUnlocalizedName("IceGauntlet").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabCombat));
        ReconstructionCircle = new ItemReconstructionCircle(ConfigSettings.ReconstructionCircle, TattooEnumState.OFF).setUnlocalizedName("ReconstructionCircle").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        AlchNotebook = new ItemAlchNotebook(ConfigSettings.AlchNotebook).setUnlocalizedName("AlchNotebook").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        AlchNotes = new ItemAlchNotes(ConfigSettings.AlchNotes).setUnlocalizedName("AlchNotes").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMisc));
        Kunai = new ItemKunai(ConfigSettings.Kunai).setUnlocalizedName("Kunai").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabTools));
        KunaiFire = new ItemKunaiFire(ConfigSettings.KunaiFire).setUnlocalizedName("KunaiFire").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabTools));
        KunaiEnder = new ItemKunaiEnder(ConfigSettings.KunaiEnder).setUnlocalizedName("KunaiEnder").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabTools));
        ChalkBag = new ItemChalkBag(ConfigSettings.ChalkBag, BagEnumState.OFF).setUnlocalizedName("ChalkBag").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabTools));
        energyMeasurer = new ItemEnergyMeasurer(ConfigSettings.energyMeasurer).setUnlocalizedName("EnergyMeasure").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabTools));
        EnergyStore = new ItemEnergyStore(ConfigSettings.energyStore).setUnlocalizedName("EnergyStore").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabTools));

        pStone.setContainerItem(pStone);
        localize();
    }
    
    public static void initializeMeta() {
    	metaTest = new ItemFMAMeta(ConfigSettings.metaID, meta_names).setUnlocalizedName("fmaMetaItem").setCreativeTab(CoreApi.getInstance().fmaTab(CreativeTabs.tabMaterials));
    }

    private static void localize() {

        //ApexUtils.addLocalizedNamesToStacksFromMap(ApexUtils.fillAndLocalizeItemStackToMap(metaTest, meta_localized_names));
    }
}