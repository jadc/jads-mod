package red.jad.jads.entities.render;

import javax.annotation.Nullable;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import red.jad.jads.jads;
import red.jad.jads.entities.EntityDomcoin;
import red.jad.jads.entities.model.ModelDomcoin;

@SideOnly(Side.CLIENT)
public class RenderDomcoin extends Render<EntityDomcoin> {
    private final ModelDomcoin model = new ModelDomcoin();

    public RenderDomcoin(RenderManager renderManagerIn){
        super(renderManagerIn);
    }

    @Override
    public void doRender(EntityDomcoin entity, double x, double y, double z, float entityYaw, float partialTicks) {
    	GlStateManager.pushMatrix();
        GlStateManager.translate((float)x,(float)y,(float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(entity);

        model.render(entity,partialTicks,0f,-1f,0f,0f,0.01f);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity,x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDomcoin entity){
        return new ResourceLocation(jads.MOD_ID, "textures/items/domcoin.png");
    }
}
