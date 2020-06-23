package red.jad.jads.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWeirdChamp extends Block {

	public BlockWeirdChamp() {
		super(Material.CLAY);
		
		setSoundType(SoundType.SLIME);
	}

    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance){
        if (entityIn.isSneaking()){
            super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
        }
        else{
            entityIn.fall(fallDistance, 0.0F);
        }
    }

    /**
     * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
     * on its own
     */
    public void onLanded(World worldIn, Entity entityIn){
        if (entityIn.isSneaking()){
            super.onLanded(worldIn, entityIn);
        }
        else if (entityIn.motionY < 0.0D){
            entityIn.motionY = -entityIn.motionY;

            if (!(entityIn instanceof EntityLivingBase)){
                entityIn.motionY *= 0.8D;
            }
        }
    }

    /**
     * Called when the given entity walks on this Block
     */
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn){
        if (Math.abs(entityIn.motionY) < 0.1D && !entityIn.isSneaking()){
            double d0 = 0.4D + Math.abs(entityIn.motionY) * 0.2D;
            entityIn.motionX *= d0;
            entityIn.motionZ *= d0;
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
