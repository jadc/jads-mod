package red.jad.jads.potions;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import red.jad.jads.jads;

public class PotionGeneric extends Potion {

	public PotionGeneric(String name, boolean bad, int color, int x, int y) {
		super(bad, color);
		setIconIndex(x, y);
		setPotionName("effect." + name);
		setRegistryName(new ResourceLocation(jads.MOD_ID + ":" + name));
	}
	
	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(jads.MOD_ID + ":textures/gui/potion_effects.png"));
		return true;
	}
}
