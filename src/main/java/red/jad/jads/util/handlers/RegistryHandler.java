package red.jad.jads.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import red.jad.jads.jads;
import red.jad.jads.entities.EntityChungus;
import red.jad.jads.entities.EntityChungusHostile;
import red.jad.jads.entities.EntityChunkus;
import red.jad.jads.entities.EntityDomcoin;
import red.jad.jads.features.Features;
import red.jad.jads.features.FeaturesPotions;
import red.jad.jads.features.FeaturesTileEntities;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> e) {
		e.getRegistry().registerAll(Features.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> e) {
		e.getRegistry().registerAll(Features.BLOCKS.toArray(new Block[0]));
		FeaturesTileEntities.registerTileEntities();
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent e) {
		for(Item item : Features.ITEMS) ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
		for(Block block : Features.BLOCKS) ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "normal"));
		
		RenderHandler.registerEntityRenderers();
		RenderHandler.registerCustomMeshesAndStates();
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> e) {
		EntityEntry domcoin = EntityEntryBuilder.create()
			    .entity(EntityDomcoin.class)
			    .id(new ResourceLocation(jads.MOD_ID + ":" + "domcoin"), 0)
			    .name("domcoin")
			    .tracker(10, 20, true)
			    .build();
		e.getRegistry().register(domcoin);
		
		EntityEntry chungus = EntityEntryBuilder.create()
			    .entity(EntityChungus.class)
			    .id(new ResourceLocation(jads.MOD_ID + ":" + "chungus"), 1)
			    .name("chungus")
			    .tracker(50, 3, true)
			    .egg(0x68515F, 0xE1D2F7)
			    .build();
		e.getRegistry().register(chungus);
		
		EntityEntry chungus_hostile = EntityEntryBuilder.create()
			    .entity(EntityChungusHostile.class)
			    .id(new ResourceLocation(jads.MOD_ID + ":" + "chungus_hostile"), 2)
			    .name("chungus_hostile")
			    .tracker(50, 3, true)
			    .egg(0x68515F, 0xFF7083)
			    .build();
		e.getRegistry().register(chungus_hostile);
		
		EntityEntry chunkus = EntityEntryBuilder.create()
			    .entity(EntityChunkus.class)
			    .id(new ResourceLocation(jads.MOD_ID + ":" + "chunkus"), 3)
			    .name("chunkus")
			    .tracker(300, 10, false)
			    .build();
		e.getRegistry().register(chunkus);
	}

	@SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event){
        event.getRegistry().register(FeaturesPotions.FIVEG_EFFECT);
    }

    @SubscribeEvent
    public static void registerPotionTypes(RegistryEvent.Register<PotionType> event){
        event.getRegistry().register(FeaturesPotions.FIVEG);
    }
}
