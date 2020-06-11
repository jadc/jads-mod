package red.jad.jads.tiles;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import red.jad.jads.features.FeaturesEnergy;
import red.jad.jads.features.FeaturesPotions;

public class TileEntityTower extends TileEntityLockable implements ITickable, ISidedInventory
{ 
	private String customName;
	
	private static final int MAX_ENERGY = 10000;
	private static final int MIN_ENERGY = 1000;
	FeaturesEnergy energy = new FeaturesEnergy(MAX_ENERGY, MAX_ENERGY, MAX_ENERGY, MAX_ENERGY);
	
    public void update(){
    	if (this.world != null){
    		if(!this.world.isRemote) {
    			if (this.world.getTotalWorldTime() % (10*20) == 0L){
        			if(this.energy.getEnergyStored() >= MIN_ENERGY) {
                		this.energy.extractEnergy(MIN_ENERGY, false);
                		this.addEffectsToPlayers();
                	}
                }
    		}
        }
    }

    private void addEffectsToPlayers(){
        if (!this.world.isRemote){
            double d0 = 50;
            
            int k = this.pos.getX();
            int l = this.pos.getY();
            int i1 = this.pos.getZ();
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).grow(d0).expand(0.0D, (double)this.world.getHeight(), 0.0D);
            List<EntityLivingBase> list = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

            for (EntityLivingBase en : list){
            	if(en != null) {
            		en.addPotionEffect(new PotionEffect(FeaturesPotions.FIVEG_EFFECT, 30*20, 0, true, true));
            	}
            }
        }
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
    	if(capability == CapabilityEnergy.ENERGY) return true;
    	return super.hasCapability(capability, facing);
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
    	if(capability == CapabilityEnergy.ENERGY) {
    		return (T)this.energy;
    	}
    	return super.getCapability(capability, facing);
    }

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStack.EMPTY;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return false;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return null;
	}

	@Override
	public String getGuiID() {
		return null;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return false;
	}
	
	@Override
    public String getName()
    {
        return this.hasCustomName() ? this.customName : "container.tower";
    }

	@Override
    public boolean hasCustomName(){
        return this.customName != null && !this.customName.isEmpty();
    }
	
    public void setName(String name)
    {
        this.customName = name;
    }
    
    @Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket(){
        return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
    }
}