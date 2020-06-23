package red.jad.jads.fluids;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import red.jad.jads.jads;

public class FluidCum extends Fluid {
	public FluidCum() {
		super("cum", new ResourceLocation(jads.MOD_ID + ":blocks/fluids/cum_still"), new ResourceLocation(jads.MOD_ID + ":blocks/fluids/cum_flow"));
		
		setRarity(EnumRarity.COMMON);
		setViscosity(10000);
		setDensity(10000);
		setLuminosity(1);
	}
	
	@Override
	public boolean doesVaporize(FluidStack fluidStack){
        return false;
    }
	
}
