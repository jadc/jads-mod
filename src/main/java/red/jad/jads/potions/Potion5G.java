package red.jad.jads.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.math.MathHelper;
import red.jad.jads.features.FeaturesDamageSources;

public class Potion5G extends PotionGeneric {

	public Potion5G() {
		super("5g", true, 12316189, 0, 0);
		registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED,
				MathHelper.getRandomUUID().toString(), 0.20000000298023224D * 4, 2);
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		if (entityLivingBaseIn.getActivePotionEffect(this).getDuration() % 40 == 0) {
			entityLivingBaseIn.attackEntityFrom(FeaturesDamageSources.DAMAGE_5G, 0.5F);
		}

		super.performEffect(entityLivingBaseIn, amplifier);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean isInstant() {
		return false;
	}
}
