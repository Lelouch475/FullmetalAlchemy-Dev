package skully.fma.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import skully.fma.api.CoreApi;
import skully.fma.block.circle.BlockCCircle;
import skully.fma.block.circle.BlockRCircle;
import skully.fma.block.circle.BlockFMACircles;
import skully.fma.core.config.ConfigSettings;
import skully.fma.item.FMAItems;


/**
 * @author viper283
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FMABlocks {


    public static Block chalkOre;
    public static Block craftingCircle;
    public static Block researchCircle;
    public static Block infuser;
    public static Block Test;

    public static void initialize() {

        chalkOre = new BlockOres(ConfigSettings.chalkOreID, new ItemStack(
                FMAItems.ChalkStick, 4))
                .setUnlocalizedName("chalkOre")
                .setHardness(1.5f)
                .setCreativeTab(
                        CoreApi.getInstance().fmaTab(CreativeTabs.tabMaterials));

        craftingCircle = new BlockCCircle(ConfigSettings.circle)
                .setUnlocalizedName("BCircle")
                .setHardness(0.0F);

        researchCircle = new BlockRCircle(ConfigSettings.RCircle)
                .setUnlocalizedName("TCircle")
                .setHardness(0.0F);

        Test = new BlockFMACircles(ConfigSettings.Test)
                .setUnlocalizedName("BCircle");
        //.setCreativeTab(
        //CoreApi.getInstance().fmaTab(CreativeTabs.tabMaterials));

        infuser = new BlockInfuser(ConfigSettings.infuser)
                .setUnlocalizedName("infuser")
                .setCreativeTab(
                        CoreApi.getInstance().fmaTab(CreativeTabs.tabMaterials));

        registerBlocks();

    }

    public static void registerBlocks() {

        // Block register
        GameRegistry.registerBlock(chalkOre, "chalkOre");
        GameRegistry.registerBlock(craftingCircle, "BCircle");
        GameRegistry.registerBlock(infuser, "infuser");
        GameRegistry.registerBlock(Test, "Test");
    }
}
