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
import red.jad.jads.features.FeaturesPotions;

public class BlockFluidHotCum extends BlockFluidClassic {

	public BlockFluidHotCum() {
		super(FeaturesFluids.FLUID_HOT_CUM, Material.WATER);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		// Player interaction
		if(entityIn instanceof EntityLivingBase) {
			EntityLivingBase en = (EntityLivingBase) entityIn;
			
			en.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 10*20, 0, false, false));
			en.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 10*20, 2, false, false));
			en.addPotionEffect(new PotionEffect(FeaturesPotions.FIVEG_EFFECT, 10*20, 0, false, false));
		}
		
		if(entityIn instanceof EntityItem) {
			EntityItem en = (EntityItem) entityIn;
			
			if(en.getItem().getItem() == Features.CHUNGUS_ESSENCE) {
				en.setDead();
				worldIn.spawnEntity(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), true));
				worldIn.createExplosion(entityIn, pos.getX(), pos.getY(), pos.getZ(), 4, true);
				worldIn.spawnEntity(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), false));
				worldIn.destroyBlock(pos, false);
			}
		}
	}
}
