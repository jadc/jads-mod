package red.jad.jads.features;

import net.minecraft.util.DamageSource;
import red.jad.jads.jads;

public class FeaturesDamageSources {
	public static final DamageSource DAMAGE_5G = registerDamageSource("5g").setMagicDamage().setDamageBypassesArmor();
	public static final DamageSource FLOWEY = registerDamageSource("flowey").setMagicDamage();
	
	private static DamageSource registerDamageSource(String name) {
		return new DamageSource(jads.MOD_ID + "." + name);
	}
}
