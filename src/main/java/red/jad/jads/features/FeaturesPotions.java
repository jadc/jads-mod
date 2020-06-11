package red.jad.jads.features;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import red.jad.jads.potions.Potion5G;

public class FeaturesPotions {
	public static Potion FIVEG_EFFECT = new Potion5G().registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, MathHelper.getRandomUUID().toString(), 0.20000000298023224D * 4, 2);;
	public static final PotionType FIVEG = new PotionType("5g", new PotionEffect[] {new PotionEffect(FIVEG_EFFECT, 3*60*20)}).setRegistryName("5g");
	
	
	
	private static void registerPotionMixes() {
		PotionHelper.addMix(PotionTypes.AWKWARD, Features.DOMCOIN, FIVEG);
	}
}
