package skully.fma.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import skully.fma.container.ContainerInfuser;
import skully.fma.core.handler.RenderHandler;


@SideOnly(Side.CLIENT)
public class GuiInfuser extends GuiContainer {

    Minecraft mc;

    public GuiInfuser(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
        super(new ContainerInfuser(par1InventoryPlayer, par2World, par3, par4, par5));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        this.fontRenderer.drawString(I18n.getString("container.trans"), 96, 8, 4210752);
        this.fontRenderer.drawString(I18n.getString("container.inventory"), 105, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderHandler.bindTexture("textures/guis/infusing.png");
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}