package red.jad.jads.util.handlers;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import red.jad.jads.features.Features;

public class OreGenHandler implements IWorldGenerator {

	private WorldGenerator ore_domcoin, ore_fossil;

	public OreGenHandler() {
		ore_domcoin = new WorldGenMinable(Features.ORE_DOMCOIN.getDefaultState(), 6,
				BlockMatcher.forBlock(Blocks.STONE));
		ore_fossil = new WorldGenMinable(Features.ORE_FOSSIL.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.STONE));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if(world.provider.getDimension() == 0) {
			runGenerator(ore_domcoin, world, random, chunkX, chunkZ, 30, 6, 70);
			runGenerator(ore_fossil, world, random, chunkX, chunkZ, 15, 6, 30);
		}
	}

	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance,
			int minHeight, int maxHeight) {
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
