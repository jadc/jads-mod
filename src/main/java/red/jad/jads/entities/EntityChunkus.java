package red.jad.jads.entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import red.jad.jads.jads;
import red.jad.jads.util.Shorthands;
import red.jad.jads.util.handlers.SoundsHandler;

public class EntityChunkus extends EntityCow implements IEntityMultiPart {
	
	private static final ResourceLocation LOOT = LootTableList.register(new ResourceLocation(jads.MOD_ID, "entities/chunkus"));
	private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public List<MultiPartEntityPart> chunkusPartArray;
	
	private float width = 16.0F;
	private float height = 16.0F;
	private float hurtBoxSize = 4.0F;
	
	public EntityChunkus(World worldIn) {
		super(worldIn);
        this.setSize(width, height);
		this.ignoreFrustumCheck = true;
		
		this.chunkusPartArray = new ArrayList<MultiPartEntityPart>();
		for(int x = 0; x < width; x += hurtBoxSize) {
			for(int z = 0; z < width; z += hurtBoxSize) {
				for(int y = 0; y < height; y += hurtBoxSize) {
					chunkusPartArray.add(new MultiPartEntityPart(this, x + "," + y + "," + z, hurtBoxSize, hurtBoxSize));
				}
			}
		}
	}
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		for(MultiPartEntityPart part : chunkusPartArray) {
			String[] coords = part.partName.split(",");
			int x = Integer.parseInt(coords[0]);
			int y = Integer.parseInt(coords[1]);
			int z = Integer.parseInt(coords[2]);
			setHurtbox(part, x, y, z);
		}
		
		if(!this.world.isRemote) {
			if (this.world.getTotalWorldTime() % (10L * 20L) == 0L){
				EntityChungusHostile c = new EntityChungusHostile(this.world);
				double x = this.posX + (Shorthands.newRandom().nextDouble() * (width * 2) - width);
				double z = this.posZ + (Shorthands.newRandom().nextDouble() * (width * 2) - width);
				EntityLightningBolt l = new EntityLightningBolt(this.world, x, this.posY, z, true);
				
	        	c.setLocationAndAngles(x, this.posY, z, 0, 0.0F);
	        	l.setLocationAndAngles(x, this.posY, z, 0, 0.0F);
	        	this.world.addWeatherEffect(l);
	        	this.world.spawnEntity(c);
	        }
		}
	}
	
	public void setHurtbox(MultiPartEntityPart part, double x, double y, double z) {
		part.onUpdate();
		part.setLocationAndAngles(this.posX + x - 6, this.posY + y, this.posZ + z - 6, 0, 0);
	}
	
	private void attackEntitiesInList(List<Entity> p_70971_1_)
    {
        for (int i = 0; i < p_70971_1_.size(); ++i)
        {
            Entity entity = p_70971_1_.get(i);

            if (entity instanceof EntityLivingBase)
            {
                entity.attackEntityFrom(DamageSource.causeMobDamage(this), 10.0F);
                this.applyEnchantments(this, entity);
            }
        }
    }
	
	@Override
	public boolean canBeCollidedWith(){
        return false;
    }
	
	@Override
	protected void initEntityAI(){
    }
	
	public static void registerFixes(DataFixer fixer){
        EntityLiving.registerFixesMob(fixer, EntityChunkus.class);
    }
	
	@Override
	protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2048.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
    }
	
	@Override
	@Nullable
    protected ResourceLocation getLootTable(){
		return LOOT;
	}

	@Override
	public EntityChunkus createChild(EntityAgeable ageable) {
		return null;
	}
	
	@Override
	public float getEyeHeight(){
        return 16F;
    }
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean isNonBoss(){
        return false;
    }
	
    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }
	
	@Override
	protected SoundEvent getAmbientSound(){
        return SoundsHandler.ENTITY_CHUNGUS_AMBIENT;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn){
        return SoundsHandler.ENTITY_CHUNGUS_HURT;
    }
	
	@Override
    protected SoundEvent getDeathSound(){
        return SoundsHandler.ENTITY_CHUNGUS_DEATH;
    }
	
	protected void updateAITasks() {
		super.updateAITasks();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
	@Override
	public void fall(float distance, float damageMultiplier)
    {
    }
	
	/*
	 * Multipart Functionality
	 */
	
	/*
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(){
        return this.getEntityBoundingBox();
    }
	/*
	@Override
    public void onCollideWithPlayer(EntityPlayer entityIn) {}

    @Override
    public boolean hitByEntity(Entity entityIn) { return true; }

    @Override
    public boolean canBePushed() { return false; }

    @Override
    protected void collideWithEntity(Entity p_82167_1_) {}

    @Override
    protected void collideWithNearbyEntities() { }
*/

    /**
     * Return the Entity parts making up this Entity (currently only for dragons)
     */
    @Override
    public Entity[] getParts(){
    	MultiPartEntityPart[] array = new MultiPartEntityPart[this.chunkusPartArray.size()];
    	for(int i = 0; i < this.chunkusPartArray.size(); i++) {
    		array[i] = this.chunkusPartArray.get(i);
    	}
        return array;
    }

	@Override
	public World getWorld() {
		return this.world;
	}
	
	@Override
	public boolean attackEntityFromPart(MultiPartEntityPart part, DamageSource source, float damage) {
		this.attackEntityFrom(source, damage);
		return false;
	}
}










