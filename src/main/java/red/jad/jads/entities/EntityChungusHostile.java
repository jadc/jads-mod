package red.jad.jads.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import red.jad.jads.jads;
import red.jad.jads.features.FeaturesPotions;
import red.jad.jads.util.handlers.SoundsHandler;

public class EntityChungusHostile extends EntityCreeper {
	
	private static final ResourceLocation LOOT = LootTableList.register(new ResourceLocation(jads.MOD_ID, "entities/chungus-hostile"));
	private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 30;
    private int explosionRadius = 2;
    
	public EntityChungusHostile(World worldIn) {
		super(worldIn);
		setSize(1.0F, 2.9F);
	}
	
	public static void registerFixes(DataFixer fixer){
        EntityLiving.registerFixesMob(fixer, EntityChungusHostile.class);
    }
	
	@Override
	protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
    }
	
	@Override
	@Nullable
    protected ResourceLocation getLootTable(){
		return LOOT;
	}
	
	@Override
	public float getEyeHeight(){
        return 2.7F;
    }
	
	@Override
    public void onUpdate()
    {
        if (this.isEntityAlive())
        {
            this.lastActiveTime = this.timeSinceIgnited;

            if (this.hasIgnited())
            {
                this.setCreeperState(1);
            }

            int i = this.getCreeperState();

            if (i > 0 && this.timeSinceIgnited == 0)
            {
                this.playSound(SoundsHandler.ENTITY_CHUNGUS_AMBIENT, 1.0F, 0.75F);
            }

            this.timeSinceIgnited += i;

            if (this.timeSinceIgnited < 0)
            {
                this.timeSinceIgnited = 0;
            }

            if (this.timeSinceIgnited >= this.fuseTime)
            {
                this.timeSinceIgnited = this.fuseTime;
                this.explode();
            }
        }

        super.onUpdate();
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn){
        return SoundsHandler.ENTITY_CHUNGUS_HURT;
    }
	
	@Override
    protected SoundEvent getDeathSound(){
        return SoundsHandler.ENTITY_CHUNGUS_DEATH;
    }
	
	/*
	 * Milking functionality
	 */
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand){
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.BUCKET && !player.capabilities.isCreativeMode){
            this.playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, 0.5F);
            itemstack.shrink(1);
            return true;
        }
        else
        {
            return super.processInteract(player, hand);
        }
    }
	
	@Override
	public void fall(float distance, float damageMultiplier){}
	
	private void explode(){
        if (!this.world.isRemote)
        {
            float f = this.getPowered() ? 2.0F : 1.0F;
            this.dead = true;
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius * f, false);
            this.setDead();
            this.spawnLingeringCloud();
        }
    }
	
	private void spawnLingeringCloud(){
		EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(this.world, this.posX, this.posY, this.posZ);
        entityareaeffectcloud.setRadius(5F);
        entityareaeffectcloud.setRadiusOnUse(-0.5F);
        entityareaeffectcloud.setWaitTime(10);
        entityareaeffectcloud.setDuration(entityareaeffectcloud.getDuration());
        entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());

        entityareaeffectcloud.addEffect(new PotionEffect(FeaturesPotions.FIVEG_EFFECT, 10*20, 0, false, false));

        this.world.spawnEntity(entityareaeffectcloud);
    }
}










