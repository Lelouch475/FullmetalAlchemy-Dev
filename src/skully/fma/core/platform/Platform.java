package skully.fma.core.platform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import skully.fma.core.FullmetalAlchemy;
import skully.fma.core.util.ConvertUtil;

/**
 * @author viper283
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class Platform {

	public static Platform instance() {

		return FullmetalAlchemy.platform;
	}

	public void registerRenderThings() {

	}

	public static void saveData(WorldServer world, NBTTagCompound tag, String fileName) {

		try {
			if(world.getChunkSaveLocation().exists()) {

				File file = new File(world.getChunkSaveLocation(), fileName + ".dat");
				if(file.exists()) {

					File file1 = new File(world.getChunkSaveLocation(), fileName + "_backup.dat");
					if(file1.exists()) {

						if(file1.delete()) {

							file.renameTo(file1);
						}
					} else {

						file.renameTo(file1);
					}
				} else {

					CompressedStreamTools.writeCompressed(tag, new FileOutputStream(file));
				}
			}
		} catch(Exception e) {

			e.printStackTrace();
		}
	}

	public static NBTTagCompound loadData(WorldServer world, String fileName) {

		NBTTagCompound tag = null;

		try {

			File file = new File(world.getChunkSaveLocation(), fileName + ".dat");
			if(!(file.exists())) {

				return null;
			}

			tag = CompressedStreamTools.readCompressed(new FileInputStream(file));
			return tag;
		} catch(Exception e) {

			try {

				File file = new File(world.getChunkSaveLocation(), fileName + "_backup.dat");
				if(!(file.exists())) {

					return null;
				}
				tag = CompressedStreamTools.readCompressed(new FileInputStream(file));

				File file1 = new File(world.getChunkSaveLocation(), fileName + ".dat");
				file1.delete();
				file.renameTo(file1);
				return tag;
			} catch(Exception e2) {

				e2.printStackTrace();
			}
		}
		return tag;
	}

	public void registerKeyBinds() {

	}

	public void transmuteBlock(int x, int y, int z, int blockID, int meta, EntityPlayer player, World world) {

		player.sendChatToPlayer(ConvertUtil.toChatComponent("HEHE"));
	}
}
