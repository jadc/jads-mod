package red.jad.jads.util.handlers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.registry.GameRegistry;
import red.jad.jads.features.Features;
import red.jad.jads.features.FeaturesFluids;

public class SmeltingHandler {
	public static void registerRecipes() {
		GameRegistry.addSmelting(Features.CHUNGUS_FLESH, new ItemStack(Features.CHUNGUS_FLESH_COOKED, 1), 0.1F);
		GameRegistry.addSmelting(FluidUtil.getFilledBucket(new FluidStack(FeaturesFluids.FLUID_CUM, 1)), FluidUtil.getFilledBucket(new FluidStack(FeaturesFluids.FLUID_HOT_CUM, 1)), 0.1F);
		GameRegistry.addSmelting(Features.ORE_DOMCOIN, new ItemStack(Features.INGOT_DOMCOIN, 1), 0.1F);
		
	}
}
