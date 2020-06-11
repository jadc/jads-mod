package red.jad.jads.util.handlers;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import red.jad.jads.features.Features;

public class OreGenHandler implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.getDimension() == 0) {
			generateOre(Features.ORE_DOMCOIN.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 90, random.nextInt(3) + 4, 5);
			generateOre(Features.ORE_FOSSIL.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 90, random.nextInt(2) + 2, 5);
			
		}
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chance) {
		int deltaY = maxY - minY;
		
		for(int i = 0; i < chance; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable gen = new WorldGenMinable(ore, size);
			gen.generate(world, random, pos);
		}
	}
}
