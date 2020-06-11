package red.jad.jads.features;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSimpleFoiled;
import red.jad.jads.jads;
import red.jad.jads.blocks.BlockChungusSynthesizer;
import red.jad.jads.blocks.BlockDomcoinOre;
import red.jad.jads.blocks.BlockFlowey;
import red.jad.jads.blocks.BlockFluidCum;
import red.jad.jads.blocks.BlockFluidHotCum;
import red.jad.jads.blocks.BlockFoil;
import red.jad.jads.blocks.BlockFossilOre;
import red.jad.jads.blocks.BlockJadHead;
import red.jad.jads.blocks.BlockMetallic;
import red.jad.jads.blocks.BlockTower;
import red.jad.jads.blocks.BlockWeirdChamp;
import red.jad.jads.items.ItemChungusFlesh;
import red.jad.jads.items.ItemChunkusSpawner;
import red.jad.jads.items.ItemCustomRecord;
import red.jad.jads.items.ItemDomcoin;
import red.jad.jads.items.ItemFossil;
import red.jad.jads.items.ItemRoll;
import red.jad.jads.util.handlers.SoundsHandler;

public class Features {

	public static final List<Block> BLOCKS 	= new ArrayList<Block>();
	public static final List<Item> 	ITEMS 	= new ArrayList<Item>();
	
	/*
	 * Block Registration
	 */
	public static final Block WEIRDCHAMP				= setup( "weirdchamp", new BlockWeirdChamp() );
	public static final Block BLOCK_DOMCOIN			= setup( "domcoin_block", new BlockMetallic() );
	public static final Block HEAD_JAD					= setup( "jad_head", new BlockJadHead() );
	public static final Block MISSING					= setup( "missing", new Block(Material.ROCK).setLightLevel(1.0F).setHardness(0.5F).setResistance(1) );
	public static final Block FOIL						= setup( "foil", new BlockFoil() );
	public static final Block ORE_DOMCOIN				= setup( "domcoin_ore", new BlockDomcoinOre() );
	public static final Block TOWER						= setup( "tower", new BlockTower() );
	public static final Block CHUNGUS_SYNTHESIZER		= setup( "chungus_synthesizer", new BlockChungusSynthesizer() );
	public static final Block FLOWEY					= setup( "flowey", new BlockFlowey() );
	public static final Block ORE_FOSSIL				= setup( "fossilized_chungus_ore", new BlockFossilOre() );
	
	/*
	 * Item Registration
	 */
	public static final Item DOMCOIN					= setup( "domcoin", new ItemDomcoin() );
	public static final Item CHUNGUS_FLESH				= setup( "chungus_flesh", new ItemChungusFlesh(false) );
	public static final Item CHUNGUS_FLESH_COOKED		= setup( "chungus_flesh_cooked", new ItemChungusFlesh(true) );
	public static final Item INGOT_DOMCOIN				= setup( "domcoin_ingot", new Item() );
	public static final Item CHUNGUS_ESSENCE			= setup( "chungus_essence", new ItemSimpleFoiled() );
	public static final Item RECORD_PLACE				= setup( "record_place", new ItemCustomRecord("place", SoundsHandler.RECORD_PLACE, false) );
	public static final Item RECORD_CHUNGUS			= setup( "record_chungus", new ItemCustomRecord("chungus", SoundsHandler.RECORD_CHUNGUS, false) );
	public static final Item RECORD_CHUNGUS2			= setup( "record_chungus2", new ItemCustomRecord("chungus2", SoundsHandler.RECORD_CHUNGUS2, true) );
	public static final Item FOIL_ROLL					= setup( "foil_roll", new ItemRoll() );
	public static final Item FOIL_HAT					= setup( "foil_hat", new ItemArmor(FeaturesMaterials.FOIL_ARMOR, 0, EntityEquipmentSlot.HEAD) );
	public static final Item CHUNKUS_SPAWNER			= setup( "chunkus_spawner", new ItemChunkusSpawner() );
	public static final Item FOSSILIZED_CHUNGUS		= setup( "fossilized_chungus", new ItemFossil() );
	
	/*
	 * Fluid Registration
	 */
	public static final Block BLOCKFLUID_CUM			= setup( "cum", new BlockFluidCum() ); 
	public static final Block BLOCKFLUID_HOT_CUM		= setup( "hot_cum", new BlockFluidHotCum() ); 
	
	/*
	 * Item Setup Method
	 */
	private static Item setup(String name, Item i) {
		i.setUnlocalizedName(name);
		i.setRegistryName(name);
		i.setCreativeTab(jads.tabjads);
		
		ITEMS.add(i);
		return i;
	}
	
	/*
	 * Block Setup Method
	 */
	private static Block setup(String name, Block b) {
		b.setUnlocalizedName(name);
		b.setRegistryName(name);
		b.setCreativeTab(jads.tabjads);
		
		BLOCKS.add(b);
		ITEMS.add(new ItemBlock(b).setRegistryName(b.getRegistryName()));
		
		return b;
	}
}
