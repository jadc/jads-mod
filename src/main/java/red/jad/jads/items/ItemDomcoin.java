package red.jad.jads.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import red.jad.jads.entities.EntityDomcoin;
import red.jad.jads.features.FeaturesSounds;
import red.jad.jads.util.Shorthands;

public class ItemDomcoin extends Item {

	public ItemDomcoin() {
		super();
	}
	
	/*
	 * Throwing action
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if(!playerIn.capabilities.isCreativeMode){
            itemstack.shrink(1);
        }

        Shorthands.playSound(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, FeaturesSounds.ENTITY_DOMCOIN_FLIP, SoundCategory.NEUTRAL);
        
        if(!worldIn.isRemote){
            EntityDomcoin entityDomcoin = new EntityDomcoin(worldIn, playerIn);
            entityDomcoin.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F, 2.0F);
            worldIn.spawnEntity(entityDomcoin);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
