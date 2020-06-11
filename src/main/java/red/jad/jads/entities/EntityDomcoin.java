package red.jad.jads.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import red.jad.jads.features.Features;
import red.jad.jads.util.Shorthands;
import red.jad.jads.util.handlers.SoundsHandler;

public class EntityDomcoin extends EntityThrowable {

	public EntityDomcoin(World worldIn) { super(worldIn); }

    public EntityDomcoin(World worldIn, EntityLivingBase throwerIn){
        super(worldIn, throwerIn);
    }

    public EntityDomcoin(World worldIn, double x, double y, double z){
        super(worldIn, x, y, z);
    }

    public static void registerFixesSnowball(DataFixer fixer){
        EntityThrowable.registerFixesThrowable(fixer, "Domcoin");
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id){}

    @Override
    protected void onImpact(RayTraceResult result){
        if (!this.world.isRemote){
            this.world.setEntityState(this, (byte)3);
            
            EntityItem itemEntity = new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(Features.DOMCOIN, 1));
            itemEntity.setAlwaysRenderNameTag(true);
            itemEntity.setCustomNameTag(Shorthands.randomChance() ? "Heads" : "Tails");
            this.world.spawnEntity(itemEntity);
            Shorthands.playSound(this.world, this.posX, this.posY, this.posZ, SoundsHandler.ENTITY_DOMCOIN_IMPACT, SoundCategory.NEUTRAL);
            this.setDead();
        }
    }
}
