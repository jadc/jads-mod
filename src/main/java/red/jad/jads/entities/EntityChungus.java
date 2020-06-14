package red.jad.jads.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import red.jad.jads.jads;
import red.jad.jads.features.Features;
import red.jad.jads.features.FeaturesFluids;
import red.jad.jads.features.FeaturesSounds;
import red.jad.jads.util.Shorthands;

public class EntityChungus extends EntityCow {
	
	private static final ResourceLocation LOOT = LootTableList.register(new ResourceLocation(jads.MOD_ID, "entities/chungus"));
    private int timeUntilNextCoin = 6000;
    
	public EntityChungus(World worldIn) {
		super(worldIn);
		setSize(1.0F, 2.9F);
	}
	
	public static void registerFixes(DataFixer fixer){
        EntityLiving.registerFixesMob(fixer, EntityChungus.class);
    }
	
	@Override
	protected void initEntityAI(){
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(2, new EntityAITempt(this, 1.25D, Items.CARROT, false));
        this.tasks.addTask(2, new EntityAITempt(this, 1.50D, Items.GOLDEN_CARROT, false));
        this.tasks.addTask(3, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIAvoidEntity(this, EntityChungusHostile.class, 6.0F, 1.0D, 1.2D));
    }
	
	@Override
	protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }
	
	@Override
	@Nullable
    protected ResourceLocation getLootTable(){
		return LOOT;
	}

	@Override
	public EntityChungus createChild(EntityAgeable ageable) {
		return new EntityChungus(this.world);
	}
	
	@Override
	public float getEyeHeight(){
        return 2.7F;
    }
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.CARROT || stack.getItem() == Items.GOLDEN_CARROT;
	}
	
	@Override
	protected SoundEvent getAmbientSound(){
        return FeaturesSounds.ENTITY_CHUNGUS_AMBIENT;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn){
        return FeaturesSounds.ENTITY_CHUNGUS_HURT;
    }
	
	@Override
    protected SoundEvent getDeathSound(){
        return FeaturesSounds.ENTITY_CHUNGUS_DEATH;
    }
	
	/*
	 * Milking functionality
	 */
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand){
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.BUCKET && !player.capabilities.isCreativeMode){
            player.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 1.0F, 1.0F);
            itemstack.shrink(1);

            if (itemstack.isEmpty()){
                player.setHeldItem(hand, FluidUtil.getFilledBucket(new FluidStack(FeaturesFluids.FLUID_CUM, 1)));
            }
            else if (!player.inventory.addItemStackToInventory(FluidUtil.getFilledBucket(new FluidStack(FeaturesFluids.FLUID_CUM, 1)))){
                player.dropItem(FluidUtil.getFilledBucket(new FluidStack(FeaturesFluids.FLUID_CUM, 1)), false);
            }
            
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.spawnParticle(EnumParticleTypes.HEART, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);

            return true;
        }
        else
        {
            return super.processInteract(player, hand);
        }
    }
	
	/*
	 * Shed
	 */
	public void onLivingUpdate(){
        super.onLivingUpdate();
        
        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextCoin <= 0){
            Shorthands.playSound(this.getEntityWorld(), this.posX, this.posY, this.posZ, SoundEvents.ENTITY_CHICKEN_EGG);
            this.dropItem(Features.DOMCOIN, 1);
            this.timeUntilNextCoin = 6000 + Shorthands.newRandom().nextInt(6000);
        }
    }
	
	@Override
	public void onDeath(DamageSource cause) {
		if(cause.getTrueSource() instanceof EntityPlayerMP) {
			if(Shorthands.randomChance(0.25)) {
            	EntityChungusHostile enh = new EntityChungusHostile(this.world);
                enh.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);

                if (this.hasCustomName()){
                    enh.setCustomNameTag(this.getCustomNameTag());
                    enh.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
                }
                
                enh.setVelocity(0, 0.5D, 0);

                this.world.spawnEntity(enh);
                this.setDead();
            }
		}
		super.onDeath(cause);
	}
}










