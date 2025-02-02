package divinerpg.objects.blocks.vanilla;

import divinerpg.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMobPumpkin extends BlockHorizontal {

    public BlockMobPumpkin(String name) {
        super(Material.GOURD);
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        setTickRandomly(true);
        setHardness(1.0F);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        setSoundType(SoundType.WOOD);
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return world.getBlockState(pos).getBlock().isReplaceable(world, pos)
                && world.isSideSolid(pos.down(), EnumFacing.UP);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { FACING });
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
            float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!player.isSneaking()) {
            Block block = world.getBlockState(pos).getBlock();
            SoundEvent sound = null;

            if (block == ModBlocks.spiderPumpkin) {
                sound = SoundEvents.ENTITY_SPIDER_AMBIENT;
            } else if (block == ModBlocks.glaconPumpkin) {
                sound = ModSounds.GLACIDE;
            } else if (block == ModBlocks.enderWatcherPumpkin) {
                sound = SoundEvents.ENTITY_ENDERMEN_AMBIENT;
            } else if (block == ModBlocks.jungleSpiderPumpkin) {
                sound = ModSounds.HELL_SPIDER;
            } else if (block == ModBlocks.hellspiderPumpkin) {
                sound = ModSounds.HELL_SPIDER;
            } else if (block == ModBlocks.enderPumpkin) {
                sound = SoundEvents.ENTITY_ENDERMEN_SCREAM;
            } else if (block == ModBlocks.creeperPumpkin) {
                sound = SoundEvents.ENTITY_CREEPER_PRIMED;
            } else if (block == ModBlocks.skeletonPumpkin) {
                sound = SoundEvents.ENTITY_SKELETON_AMBIENT;
            } else if (block == ModBlocks.blazePumpkin) {
                sound = SoundEvents.ENTITY_BLAZE_AMBIENT;
            } else if (block == ModBlocks.zombiePumpkin) {
                sound = SoundEvents.ENTITY_ZOMBIE_AMBIENT;
            } else if (block == ModBlocks.frostPumpkin) {
                sound = ModSounds.FROST;
            } else if (block == ModBlocks.cyclopsPumpkin) {
                sound = ModSounds.CYCLOPS;
            } else if (block == ModBlocks.ghastPumpkin) {
                sound = SoundEvents.ENTITY_GHAST_SCREAM;
            }

            if (sound != null) {
                world.playSound(null, pos, sound, SoundCategory.MASTER, 20.0F, 1.0F);
            }
        }
        return true;
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }
}