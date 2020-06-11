package red.jad.jads.util;

import java.util.Random;
import java.util.SplittableRandom;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Shorthands {
	
	// Potion
	public static void addPotion(EntityPlayer p, Potion e, int duration, int strength) {
		p.addPotionEffect(new PotionEffect(e, duration, strength, false, false));
	}
	
	// Play Sound
	public static void playSound(World w, double x, double y, double z, SoundEvent s, SoundCategory c) {
		w.playSound(null, x, y, z, s, c, 0.5F, (float) Shorthands.newRandom().nextDouble() + 0.5F);
	}
	
	public static void playSound(World w, double x, double y, double z, SoundEvent s) {
		w.playSound(null, x, y, z, s, SoundCategory.BLOCKS, 0.5F, (float) Shorthands.newRandom().nextDouble() + 0.5F);
	}
	
	// Random (50%)
	public static boolean randomChance() {
		return new SplittableRandom().nextBoolean();
	}
	
	// Random (Any%)
	public static boolean randomChance(double percent) {
		return new SplittableRandom().nextDouble() < percent;
	}
	
	// Random (Other)
	public static SplittableRandom newRandom() {
		return new SplittableRandom();
	}
}
