package red.jad.jads.util.handlers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import red.jad.jads.jads;
import red.jad.jads.entities.EntityChungus;
import red.jad.jads.entities.EntityChungusHostile;
import red.jad.jads.entities.EntityChunkus;
import red.jad.jads.entities.EntityDomcoin;
import red.jad.jads.entities.render.RenderChungus;
import red.jad.jads.entities.render.RenderChungusHostile;
import red.jad.jads.entities.render.RenderChunkus;
import red.jad.jads.entities.render.RenderDomcoin;
import red.jad.jads.features.Features;

public class RenderHandler {
	public static void registerEntityRenderers() {
		// Airborn domcoin
		RenderingRegistry.registerEntityRenderingHandler(EntityDomcoin.class, new IRenderFactory<EntityDomcoin>() {
			@Override
			public Render<? super EntityDomcoin> createRenderFor(RenderManager manager) {
				return new RenderDomcoin(manager);
			}
		}); 
		
		// Chungus
		RenderingRegistry.registerEntityRenderingHandler(EntityChungus.class, new IRenderFactory<EntityChungus>() {
			@Override
			public Render<? super EntityChungus> createRenderFor(RenderManager manager) {
				return new RenderChungus(manager);
			}
		});
		
		// Chunkus
		RenderingRegistry.registerEntityRenderingHandler(EntityChunkus.class, new IRenderFactory<EntityChunkus>() {
			@Override
			public Render<? super EntityChunkus> createRenderFor(RenderManager manager) {
				return new RenderChunkus(manager);
			}
		});
		
		// Hostile Chungus
		RenderingRegistry.registerEntityRenderingHandler(EntityChungusHostile.class, new IRenderFactory<EntityChungusHostile>() {
			@Override
			public Render<? super EntityChungusHostile> createRenderFor(RenderManager manager) {
				return new RenderChungusHostile(manager);
			}
		}); 
	}
	
	public static void registerCustomMeshesAndStates() {
		
		// Cum
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(Features.BLOCKFLUID_CUM), new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(jads.MOD_ID + ":cum", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(Features.BLOCKFLUID_CUM, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation(jads.MOD_ID + ":cum", "fluid");
			}
			
		});
		
		// Hot Cum
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(Features.BLOCKFLUID_HOT_CUM), new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(jads.MOD_ID + ":hot_cum", "fluid");
			}
		});
				
		ModelLoader.setCustomStateMapper(Features.BLOCKFLUID_HOT_CUM, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation(jads.MOD_ID + ":hot_cum", "fluid");
			}
					
		});
	
	}
}
