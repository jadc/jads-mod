package red.jad.jads.items;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import red.jad.jads.entities.EntityChungus;
import red.jad.jads.features.Features;
import red.jad.jads.util.Shorthands;

public class ItemFossil extends Item {
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if(worldIn.getBlockState(pos) == Features.CHUNGUS_SYNTHESIZER.getDefaultState()) {
			player.swingArm(hand);
			spawnChungus(worldIn, pos);
        	player.getCooldownTracker().setCooldown(this, 20);
			player.getHeldItemMainhand().shrink(1);
			return EnumActionResult.SUCCESS;
		}
		
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
	@Override
	public boolean onEntityItemUpdate(EntityItem e) {
		World world = e.getEntityWorld();
		if(world.getBlockState(e.getPosition().down()) == Features.CHUNGUS_SYNTHESIZER.getDefaultState()) {
			world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, e.posX + Shorthands.newRandom().nextDouble() - 0.5, e.posY + Shorthands.newRandom().nextDouble(), e.posZ + Shorthands.newRandom().nextDouble() - 0.5, 0, 0, 0, 0);
			if(!world.isRemote) {
				if(world.getTotalWorldTime() % (20*5) == 0) {
					spawnChungus(world, e.getPosition().down());
					e.getItem().setCount(e.getItem().getCount() - 1);
				}
			}
		}
		
		return super.onEntityItemUpdate(e);
	}
	
	private void spawnChungus(World worldIn, BlockPos pos) {
		if(worldIn != null) {
			double x = pos.getX() + 0.5;
	    	double y = pos.getY() + 1;
	    	double z = pos.getZ() + 0.5;
	    	
			if(!worldIn.isRemote) {
		    	EntityChungus chungus = new EntityChungus(worldIn);
		    	chungus.setLocationAndAngles(x, y, z, 0, 0);
		    	worldIn.spawnEntity(chungus);
			}

			for(double i = 0; i < 2; i += 0.1) {
				worldIn.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, x + Shorthands.newRandom().nextDouble() - 0.5, y + i, z + Shorthands.newRandom().nextDouble() - 0.5, 0, 0, 0, 1);
			}
		}
	}
}
