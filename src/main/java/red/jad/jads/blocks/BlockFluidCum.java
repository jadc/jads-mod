package red.jad.jads.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		
		
		if(entityIn instanceof EntityItem) {
			EntityItem en = (EntityItem) entityIn;
			
			if(en.getItem().getItem() == Features.DOMCOIN) en.setItem(new ItemStack(Items.GOLD_NUGGET, en.getItem().getCount()));
			if(en.getItem().getItem() == Features.INGOT_DOMCOIN) en.setItem(new ItemStack(Items.GOLD_INGOT, en.getItem().getCount()));
			if(en.getItem().getItem() == Item.getItemFromBlock(Features.BLOCK_DOMCOIN)) en.setItem(new ItemStack(Item.getItemFromBlock(Blocks.GOLD_BLOCK), en.getItem().getCount()));
			
		}
		
	}
}
