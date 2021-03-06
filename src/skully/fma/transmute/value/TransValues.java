package skully.fma.transmute.value;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TransValues {

	private static Minecraft mc;
	private static List<Block> blocks = new ArrayList<Block>();
	private static List<Block> corruptBlocks = new ArrayList<Block>();

	// private static List DTrans = new Block.blocksList[5];

	public static Block[] block = Block.blocksList;

	public static Block[] corrupt = {
		Block.obsidian,
		Block.netherBrick,
		Block.netherrack,
		Block.skull,
		Block.stairsNetherBrick
	};

	public static int getRandomID() {
		return getRandomBlock().blockID;
	}

	public static int getCorruptionID() {
		return getCorruptionBlock().blockID;
	}

	/**
	 * Only called if the pSTone is active
	 */
	public static Block getRandomBlock() {

		for(Block block : Block.blocksList) {
			if(block != null) {
				boolean hasTile = block.hasTileEntity(0);

				if(block.blockID != 0 && !(hasTile) && block.blockID == Block.dirt.blockID) {
					//this.add(DTrans);
				} else if(block.blockID != 0 && !(hasTile)) {
					Material mat = block.blockMaterial != null ? block.blockMaterial : Material.air;

					if(mat.isSolid()) {
						blocks.add(block);
					}
				}
			}
		}

		Random rand = new Random();

		int random = rand.nextInt(blocks.size());

		Block block = blocks.get(random);

		return block;
	}

	public static Block getCorruptionBlock() {

		for(Block block : corrupt) {
			if(block != null) {
				boolean hasTile = block.hasTileEntity(0);
				if(block.blockID != 0 && !(hasTile)) {
					Material mat = block.blockMaterial != null ? block.blockMaterial : Material.air;

					if(mat.isSolid()) {
						corruptBlocks.add(block);
					}
				}
			}
		}

		Random rand = new Random();

		int random = rand.nextInt(corruptBlocks.size());

		Block block = corruptBlocks.get(random);

		return block;
	}
}