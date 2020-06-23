package red.jad.jads.features;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import red.jad.jads.jads;

public class FeaturesMaterials {
	public static final ArmorMaterial FOIL_ARMOR = EnumHelper.addArmorMaterial(
			jads.MOD_ID + ":" + "foil_armor", 
			jads.MOD_ID + ":foil", 
			15, 
			new int[]{2, 5, 6, 2}, 
			9, 
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 
			0.0F
	);
}
