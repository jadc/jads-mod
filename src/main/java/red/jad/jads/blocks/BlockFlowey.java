package red.jad.jads.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import red.jad.jads.features.FeaturesDamageSources;

public class BlockFlowey extends BlockBush {
	public BlockFlowey() {
		this.setSoundType(SoundType.PLANT);
	}

	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			entityIn.attackEntityFrom(FeaturesDamageSources.FLOWEY, 1.0F);
		}

		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}
}
