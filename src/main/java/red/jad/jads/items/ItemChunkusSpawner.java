package red.jad.jads.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import red.jad.jads.entities.EntityChunkus;

public class ItemChunkusSpawner extends Item {
	
	public ItemChunkusSpawner() {
		this.setMaxStackSize(1);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		ItemStack itemstack = player.getHeldItem(hand);
		
		if (!worldIn.isRemote){
			
			double d0 = 300;
            int k = player.getPosition().getX();
            int l = player.getPosition().getY();
            int i1 = player.getPosition().getZ();
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).grow(d0).expand(0.0D, (double)worldIn.getHeight(), 0.0D);
            List<EntityLivingBase> list = worldIn.<EntityLivingBase>getEntitiesWithinAABB(EntityChunkus.class, axisalignedbb);
            if(list.isEmpty()) {
            	EntityChunkus entity = new EntityChunkus(worldIn);
                entity.setLocationAndAngles(pos.getX(), pos.getY() + 300, pos.getZ(), 0, 0.0F);
                ItemMonsterPlacer.applyItemEntityDataToEntity(worldIn, player, itemstack, entity);
                worldIn.spawnEntity(entity);
            }else {
            	player.sendStatusMessage(new TextComponentString("There is already a Big Chunkus in the world."), true);
                return EnumActionResult.FAIL;
            }
        }

		player.getCooldownTracker().setCooldown(this, 20*60*5);
        itemstack.shrink(1);
        return EnumActionResult.SUCCESS;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){
        return true;
    }
}
