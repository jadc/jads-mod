package red.jad.jads.fluids;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import red.jad.jads.jads;

public class FluidHotCum extends Fluid {
	public FluidHotCum() {
		super("hot_cum", new ResourceLocation(jads.MOD_ID + ":blocks/fluids/hot_cum_still"), new ResourceLocation(jads.MOD_ID + ":blocks/fluids/hot_cum_flow"));
		
		setRarity(EnumRarity.UNCOMMON);
		setViscosity(5000);
		setDensity(10000);
		setLuminosity(15);
	}
	
	@Override
	public boolean doesVaporize(FluidStack fluidStack){
        return false;
    }
	
}
