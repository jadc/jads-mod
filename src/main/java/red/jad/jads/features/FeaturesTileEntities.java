package red.jad.jads.features;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import red.jad.jads.jads;
import red.jad.jads.tiles.TileEntityTower;

public class FeaturesTileEntities {
	public static void registerTileEntities() {
		registerTileEntity(TileEntityTower.class, "tower");
	}
	
	private static void registerTileEntity(Class<? extends TileEntity> te, String name) {
		GameRegistry.registerTileEntity(te, jads.MOD_ID + ":" + name);
	}
}
