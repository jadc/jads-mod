package red.jad.jads.entities.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import red.jad.jads.jads;
import red.jad.jads.entities.EntityChunkus;
import red.jad.jads.entities.model.ModelChunkus;

public class RenderChunkus extends RenderLiving<EntityChunkus> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(jads.MOD_ID + ":textures/entities/chungus/chungus.png");
	
	public RenderChunkus(RenderManager manager) {
		super(manager, new ModelChunkus(), 10F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityChunkus e) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityChunkus entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
