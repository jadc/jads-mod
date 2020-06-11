package red.jad.jads.entities.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import red.jad.jads.jads;
import red.jad.jads.entities.EntityChungus;
import red.jad.jads.entities.model.ModelChungus;

public class RenderChungus extends RenderLiving<EntityChungus> {
	
	private final String DIRECTORY = jads.MOD_ID + ":textures/entities/chungus/";
	
	public RenderChungus(RenderManager manager) {
		super(manager, new ModelChungus(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityChungus e) {
		return new ResourceLocation(DIRECTORY + "chungus.png");
	}
	
	@Override
	protected void applyRotations(EntityChungus entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
