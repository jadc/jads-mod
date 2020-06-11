package red.jad.jads.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelChunkus extends ModelBase {
    public ModelRenderer foot_left;
    public ModelRenderer foot_right;
    public ModelRenderer torso;
    public ModelRenderer arm_left;
    public ModelRenderer arm_right;
    public ModelRenderer ear_right;
    public ModelRenderer ear_left;
    public ModelRenderer face;
    public ModelRenderer nose;
    public ModelRenderer teeth;

    public ModelChunkus() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.foot_right = new ModelRenderer(this, 0, 49);
        this.foot_right.setRotationPoint(-2.0F, 21.0F, 2.0F);
        this.foot_right.addBox(-3.0F, 0.0F, -14.0F, 6, 3, 12, 0.0F);
        this.setRotateAngle(foot_right, 0.0F, 1.0471975511965976F, 0.0F);
        this.ear_left = new ModelRenderer(this, 68, 26);
        this.ear_left.setRotationPoint(0.0F, -25.0F, 0.0F);
        this.ear_left.addBox(0.0F, -20.0F, -1.0F, 6, 20, 2, 0.0F);
        this.setRotateAngle(ear_left, 0.0F, 0.0F, 0.17453292519943295F);
        this.face = new ModelRenderer(this, 68, 0);
        this.face.setRotationPoint(0.0F, -25.0F, 0.0F);
        this.face.addBox(-6.0F, 0.0F, -6.0F, 12, 14, 12, 0.0F);
        this.nose = new ModelRenderer(this, 84, 27);
        this.nose.setRotationPoint(0.0F, -25.0F, 0.0F);
        this.nose.addBox(-2.0F, 8.0F, -8.0F, 4, 2, 2, 0.0F);
        this.teeth = new ModelRenderer(this, 96, 27);
        this.teeth.setRotationPoint(0.0F, -25.0F, 0.0F);
        this.teeth.addBox(-1.0F, 10.0F, -7.5F, 2, 1, 1, 0.0F);
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.torso.addBox(-9.0F, -32.0F, -8.0F, 18, 32, 16, 0.0F);
        this.arm_left = new ModelRenderer(this, 84, 43);
        this.arm_left.setRotationPoint(9.0F, -7.0F, 0.0F);
        this.arm_left.addBox(0.0F, 0.0F, -2.5F, 4, 16, 5, 0.0F);
        this.setRotateAngle(arm_left, 0.0F, 0.0F, -0.08726646259971647F);
        this.ear_right = new ModelRenderer(this, 68, 26);
        this.ear_right.setRotationPoint(0.0F, -25.0F, 0.0F);
        this.ear_right.addBox(-6.0F, -20.0F, -1.0F, 6, 20, 2, 0.0F);
        this.setRotateAngle(ear_right, 0.0F, 0.0F, -0.17453292519943295F);
        this.foot_left = new ModelRenderer(this, 0, 49);
        this.foot_left.setRotationPoint(2.0F, 21.0F, 2.0F);
        this.foot_left.addBox(-3.0F, 0.0F, -14.0F, 6, 3, 12, 0.0F);
        this.setRotateAngle(foot_left, 0.0F, -1.0471975511965976F, 0.0F);
        this.arm_right = new ModelRenderer(this, 84, 43);
        this.arm_right.setRotationPoint(-9.0F, -7.0F, 0.0F);
        this.arm_right.addBox(-4.0F, 0.0F, -2.5F, 4, 16, 5, 0.0F);
        this.setRotateAngle(arm_right, 0.0F, 0.0F, 0.08726646259971647F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.scale(14F, 8F, 14F);
        GlStateManager.translate(0F, -1.35F, 0F);
        this.ear_left.render(f5);
        this.ear_right.render(f5);
        this.nose.render(f5);
        this.teeth.render(f5);
        this.face.render(f5);
        this.foot_right.render(f5);
        this.torso.render(f5);
        this.arm_left.render(f5);
        this.foot_left.render(f5);
        this.arm_right.render(f5);
        GlStateManager.popMatrix();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	this.face.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.face.rotateAngleX = 0.0F;
    	this.ear_left.rotateAngleY = this.face.rotateAngleY;
    	this.ear_left.rotateAngleX = this.face.rotateAngleX;
    	this.ear_right.rotateAngleY = this.face.rotateAngleY;
    	this.ear_right.rotateAngleX = this.face.rotateAngleX;
    	this.nose.rotateAngleY = this.face.rotateAngleY;
    	this.nose.rotateAngleX = this.face.rotateAngleX;
    	this.teeth.rotateAngleY = this.face.rotateAngleY;
    	this.teeth.rotateAngleX = this.face.rotateAngleX;
    	
    	
    	this.foot_left.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
    	this.foot_right.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
    	
        this.arm_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.arm_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.arm_right.rotateAngleZ = 0.0F;
        this.arm_left.rotateAngleZ = 0.0F;
    }
}
