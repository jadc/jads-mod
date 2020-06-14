package red.jad.jads.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChungusSynthesizer extends Block/* extends BlockContainer*/ {

	public BlockChungusSynthesizer() {
		super(Material.IRON);
		setHardness(5.0F);
		setResistance(2.0F);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 0);
	}
	
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    public boolean isFullCube(IBlockState state){
        return false;
    }

    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.CUTOUT;
    }
}
