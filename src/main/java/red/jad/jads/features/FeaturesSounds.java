package red.jad.jads.features;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import red.jad.jads.jads;

public class FeaturesSounds {
	// Entities
	public static SoundEvent ENTITY_CHUNGUS_AMBIENT		= registerSound("entity.chungus.ambient");
	public static SoundEvent ENTITY_CHUNGUS_HURT		= registerSound("entity.chungus.hurt");
	public static SoundEvent ENTITY_CHUNGUS_DEATH		= registerSound("entity.chungus.death");
	
	// Records
	public static SoundEvent RECORD_PLACE				= registerSound("record.place");
	public static SoundEvent RECORD_CHUNGUS				= registerSound("record.chungus");
	public static SoundEvent RECORD_CHUNGUS2			= registerSound("record.chungus2");
	
	// Misc
	public static SoundEvent ENTITY_DOMCOIN_IMPACT		= registerSound("entity.domcoin.impact");
	public static SoundEvent ENTITY_DOMCOIN_FLIP		= registerSound("entity.domcoin.flip");
	
	// HEV
	public static SoundEvent HEV_FLATLINE				= registerSound("hev.flatline");
	
	private static SoundEvent registerSound(String name) {
		SoundEvent sound = new SoundEvent(new ResourceLocation(jads.MOD_ID, name)).setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(sound);
		return sound;
	}
}
