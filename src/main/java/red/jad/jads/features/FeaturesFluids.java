package red.jad.jads.features;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import red.jad.jads.fluids.FluidCum;
import red.jad.jads.fluids.FluidHotCum;

public class FeaturesFluids {

	public static final Fluid FLUID_CUM					= setup( new FluidCum() );
	public static final Fluid FLUID_HOT_CUM			= setup( new FluidHotCum() );
	
	/*
	 * Fluid Setup Method
	 */
	private static Fluid setup(Fluid f) {
		FluidRegistry.registerFluid(f);
		FluidRegistry.addBucketForFluid(f);
		return f;
	}
}
