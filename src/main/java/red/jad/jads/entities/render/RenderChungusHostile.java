package red.jad.jads.entities.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import red.jad.jads.jads;
import red.jad.jads.entities.EntityChungusHostile;
import red.jad.jads.entities.model.ModelChungus;

public class RenderChungusHostile extends RenderLiving<EntityChungusHostile> {
	
	private final String DIRECTORY = jads.MOD_ID + ":textures/entities/chungus/";
	
	public RenderChungusHostile(RenderManager manager) {
		super(manager, new ModelChungus(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityChungusHostile e) {
		return new ResourceLocation(DIRECTORY + "chungus-hostile.png");
	}
	
	@Override
	protected void applyRotations(EntityChungusHostile entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	/**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityChungusHostile entitylivingbaseIn, float partialTickTime)
    {
        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 1.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        GlStateManager.scale(f2, f3, f2);
    }

    /**
     * Gets an RGBA int color multiplier to apply.
     */
    protected int getColorMultiplier(EntityChungusHostile entitylivingbaseIn, float lightBrightness, float partialTickTime)
    {
        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);

        if ((int)(f * 10.0F) % 2 == 0)
        {
            return 0;
        }
        else
        {
            int i = (int)(f * 0.2F * 255.0F);
            i = MathHelper.clamp(i, 0, 255);
            return i << 24 | 822083583;
        }
    }
}
