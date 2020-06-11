package red.jad.jads.items;

import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCustomRecord extends ItemRecord {
	
	private boolean glint;
	
	public ItemCustomRecord(String name, SoundEvent sound, boolean glint) {
		super(name, sound);
		this.glint = glint;
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){
        return glint;
    }
}
