package red.jad.jads.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import red.jad.jads.features.Features;
import red.jad.jads.features.FeaturesFluids;

public class BlockFluidCum extends BlockFluidClassic {

	public BlockFluidCum() {
		super(FeaturesFluids.FLUID_CUM, Material.WATER);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		// Player interaction
		if(entityIn instanceof EntityLivingBase) {
			EntityLivingBase en = (EntityLivingBase) entityIn;
			
			en.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 10, 0, false, false));
			en.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 10, 0, false, false));
		}
		
		/*
		// Portal opening
		if(entityIn instanceof EntityItem) {
			EntityItem en = (EntityItem) entityIn;
			
			if(worldIn.provider.getDimension() != 0) return;
			
			if(en.getItem().getItem() == Features.CHUNGUS_ESSENCE) {
				if(worldIn.getBlockState(pos).getBlock() == Features.BLOCKFLUID_CUM){
					en.setDead();
					worldIn.spawnEntity(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), false));
					worldIn.destroyBlock(pos, false);
					worldIn.setBlockState(pos, Features.PORTAL_CHUNGUS.getDefaultState());
				}
			}
		}
		*/
	}
}
