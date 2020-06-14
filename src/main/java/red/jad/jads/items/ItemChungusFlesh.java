package red.jad.jads.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import red.jad.jads.features.FeaturesSounds;
import red.jad.jads.util.Shorthands;

public class ItemChungusFlesh extends ItemFood {
	
	boolean cooked;
	
	public ItemChungusFlesh(boolean cooked) {
		super(4 + (cooked ? 2 : 0), 1, true);
		this.cooked = cooked;
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(Shorthands.randomChance(cooked ? 0.1 : 1)) {
			Shorthands.addPotion(player, MobEffects.SLOWNESS, 20*5, 2);
			player.playSound(FeaturesSounds.ENTITY_CHUNGUS_AMBIENT, 0.25F, 1.0F);
			player.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, 0.15F, 1.0F);
		}
		Shorthands.addPotion(player, MobEffects.RESISTANCE, 20*10, 0);
		Shorthands.addPotion(player, MobEffects.REGENERATION, 20*10, 0);
	}
}
