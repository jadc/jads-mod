package red.jad.jads.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
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
	
	/*
	TileEntitySynthesizer te;
	public TileEntity createNewTileEntity(World worldIn, int meta){
		this.te = new TileEntitySynthesizer();
		return te;
    }
    */
	
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
