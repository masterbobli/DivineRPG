package divinerpg.world.structures;

import java.util.Random;

import divinerpg.Config;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModDimensions;
import divinerpg.utils.DRPGLootTables;
import divinerpg.utils.DRPGStructureHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 * Created by LiteWolf101 on Jan /27/2019
 */
public class WorldGenCustomStructures implements IWorldGenerator {
    //Iceika
    public static final DRPGStructureHandler ICEIKA_DUNGEON = new DRPGStructureHandler("iceika_dungeon",
            DRPGLootTables.ICEIKA_CHEST_DUNGEON);
    public static final DRPGStructureHandler ICEIKA_DUNGEON_ROLLUM = new DRPGStructureHandler("iceika_dungeon_rollum",
            DRPGLootTables.ICEIKA_CHEST_DUNGEON);
    public static final DRPGStructureHandler COALSTONE_LAMP_1 = new DRPGStructureHandler("coalstone_lamp_1");
    public static final DRPGStructureHandler COALSTONE_LAMP_2 = new DRPGStructureHandler("coalstone_lamp_2");
    public static final DRPGStructureHandler COALSTONE_LAMP_3 = new DRPGStructureHandler("coalstone_lamp_3");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_1 = new DRPGStructureHandler("workshop_house_1",
            DRPGLootTables.ICEIKA_CHEST_HUT);
    public static final DRPGStructureHandler WORKSHOP_HOUSE_2 = new DRPGStructureHandler("workshop_house_2");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_3 = new DRPGStructureHandler("workshop_house_3");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_4 = new DRPGStructureHandler("workshop_house_4");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_5 = new DRPGStructureHandler("workshop_house_5");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_6 = new DRPGStructureHandler("workshop_house_6");
    public static final DRPGStructureHandler WORKSHOP_LIBRARY = new DRPGStructureHandler("workshop_library",
            DRPGLootTables.ICEIKA_CHEST_HUT);

    //vanilla
    public static final DRPGStructureHandler HUT = new DRPGStructureHandler("hut");

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
            IChunkProvider chunkProvider) {

        if (world.provider.getDimensionType() == ModDimensions.iceikaDimension) {
            generateStructure(ICEIKA_DUNGEON, world, random, chunkX, chunkZ, 50);
            generateStructure(ICEIKA_DUNGEON_ROLLUM, world, random, chunkX, chunkZ, 50);
            generateStructure(COALSTONE_LAMP_1, world, random, chunkX, chunkZ, 25, ModBlocks.frozenGrass);
            generateStructure(COALSTONE_LAMP_2, world, random, chunkX, chunkZ, 25, ModBlocks.frozenGrass);
            generateStructure(COALSTONE_LAMP_3, world, random, chunkX, chunkZ, 25, ModBlocks.frozenGrass);
            generateStructure(WORKSHOP_HOUSE_1, world, random, chunkX, chunkZ, 10, ModBlocks.frozenGrass, 14, 14);
            generateStructure(WORKSHOP_HOUSE_2, world, random, chunkX, chunkZ, 10, ModBlocks.frozenGrass, 13, 12);
            generateStructure(WORKSHOP_HOUSE_3, world, random, chunkX, chunkZ, 10, ModBlocks.frozenGrass, 11, 11);
            generateStructure(WORKSHOP_HOUSE_4, world, random, chunkX, chunkZ, 10, ModBlocks.frozenGrass, 10, 10);
            generateStructure(WORKSHOP_HOUSE_5, world, random, chunkX, chunkZ, 10, ModBlocks.frozenGrass, 12, 8);
            generateStructure(WORKSHOP_HOUSE_6, world, random, chunkX, chunkZ, 10, ModBlocks.frozenGrass, 10, 9);
            generateStructure(WORKSHOP_LIBRARY, world, random, chunkX, chunkZ, 10, ModBlocks.frozenGrass, 19, 11);
        } else if (world.provider.getDimensionType() == DimensionType.OVERWORLD) {
            Biome biome = world.getChunkFromChunkCoords(chunkX, chunkZ)
                    .getBiome(new BlockPos(chunkX * 16, 0, chunkZ * 16), world.getBiomeProvider());
            if (Config.generateHuts && world.getWorldType() != WorldType.FLAT
                    && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)
                            || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA))) {
                generateStructure(HUT, world, random, chunkX, chunkZ, 20, Blocks.GRASS, 11, 11);
            }
        }
    }

    /** Generates a structure between y=13 and y=56 */
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
            int chance) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = random.nextInt(43) + 13;
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
        }
    }

    /** Generates a structure only on the specified topblock */
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
            int chance, Block topBlock) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
        }
    }

    /** Generates a structure with the specified blocks in a given area */
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
            int chance, Block topBlock, int xCheckDist, int zCheckDist) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            if (locationIsValidSpawn(world, x, y, z, xCheckDist, zCheckDist, topBlock)) {
                generator.generate(world, random, pos);
            }
        }
    }

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
        int y = world.getHeight();
        boolean foundGround = false;
        while (!foundGround && y-- >= 15) {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == topBlock;
        }
        return y;
    }

    public boolean locationIsValidSpawn(World world, int x, int y, int z, int distX, int distZ, Block topBlock) {
        for (int i = 0; i < distX; i++) {
            for (int l = 0; l < distZ; l++) {
                if (world.getBlockState(new BlockPos(x + i, y, z + l)).getBlock() != topBlock) {
                    return false;
                }
            }
        }
        return true;
    }
}