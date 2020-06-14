package red.jad.jads.items;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import red.jad.jads.features.FeaturesMaterials;
import red.jad.jads.features.FeaturesSounds;

public class ItemFoilHat extends ItemArmor {

	public ItemFoilHat() {
		super(FeaturesMaterials.FOIL_ARMOR, 0, EntityEquipmentSlot.HEAD);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if(!player.getActivePotionEffects().isEmpty()) {
			player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
			int damage = 3 - EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, itemStack);
			if(damage > 0) itemStack.attemptDamageItem(damage, new Random(), null);
			if(itemStack.getItemDamage() > itemStack.getMaxDamage()	) itemStack.shrink(1);
		}
		super.onArmorTick(world, player, itemStack);
	}
}
