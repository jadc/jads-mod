package red.jad.jads.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import red.jad.jads.util.handlers.DictionaryHandler;
import red.jad.jads.util.handlers.EventHandler;
import red.jad.jads.util.handlers.OreGenHandler;
import red.jad.jads.util.handlers.SmeltingHandler;

public class ClientProxy implements IProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

	public void init(FMLInitializationEvent event) {
		DictionaryHandler.registerOres();
		SmeltingHandler.registerRecipes();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
