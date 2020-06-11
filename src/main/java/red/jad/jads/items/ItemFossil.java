package red.jad.jads.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import red.jad.jads.entities.EntityChungus;
import red.jad.jads.features.Features;
import red.jad.jads.util.Shorthands;

public class ItemFossil extends Item {
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote) {
			if(worldIn.getBlockState(pos) == Features.CHUNGUS_SYNTHESIZER.getDefaultState()) {
				if (worldIn != null){
					double x = pos.getX() + 0.5;
		        	double y = pos.getY() + 1;
		        	double z = pos.getZ() + 0.5;
		        	EntityChungus chungus = new EntityChungus(worldIn);
	            	chungus.setLocationAndAngles(x, y, z, 0, 0);
	            	worldIn.spawnEntity(chungus);
	            	
	            	player.getCooldownTracker().setCooldown(this, 20);
					player.getHeldItemMainhand().shrink(1);
					return EnumActionResult.SUCCESS;
				}
			}
		}
		
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
}
