package red.jad.jads;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import red.jad.jads.features.Features;
import red.jad.jads.proxy.IProxy;

@Mod(modid = jads.MOD_ID, useMetadata = true)
public class jads{

	// Proxy
	@SidedProxy(clientSide = "red.jad.jads.proxy.ClientProxy", serverSide = "red.jad.jads.proxy.ServerProxy")
	public static IProxy proxy;
	
	// Constants
	@Instance
	public static jads instance;
	public static final String MOD_ID = "jads";
	public static class Tab extends CreativeTabs {
		public Tab() { super("tabjads"); }
		@Override
		public ItemStack getTabIconItem() { return new ItemStack(Features.HEAD_JAD); }
	}
	public static final CreativeTabs tabjads = new Tab();
	
	static { FluidRegistry.enableUniversalBucket(); }
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent e){ proxy.preInit(e); }
    @EventHandler
    public void init(FMLInitializationEvent e){ proxy.init(e); }
    @EventHandler
    public void postInit(FMLPostInitializationEvent e){ proxy.postInit(e); }
}
