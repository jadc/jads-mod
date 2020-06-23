package red.jad.jads.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockMetallic extends Block {
	public BlockMetallic() {
		super(Material.IRON);
		
		setSoundType(SoundType.METAL);
		setLightLevel(0.5F);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 0);
	}
}
