package divinerpg.objects.blocks;

import java.util.Random;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.Reference;
import divinerpg.enums.ParticleType;
import divinerpg.registry.ModBlocks;
import divinerpg.utils.DivineTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModPortal extends BlockBreakable {

    public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis",
            EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
    protected static final AxisAlignedBB X_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D);
    protected static final AxisAlignedBB Z_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D);

    protected static final AxisAlignedBB Y_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);

    public static int meta(Axis a) {
        return a == EnumFacing.Axis.X ? 1 : (a == EnumFacing.Axis.Z ? 2 : 0);
    }

    protected Block fireBlock, portalFrame, portalBlock = this;
    ParticleType portalParticle;
    protected String name;
    protected int dimId;

    public BlockModPortal(String name, int dimId, Block fireBlock, Block portalFrame, ParticleType particle) {
        super(Material.PORTAL, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.X));
        this.setRegistryName(Reference.MODID, name);
        this.setUnlocalizedName(name);
        this.setTickRandomly(true);
        this.setCreativeTab(null);
        this.setBlockUnbreakable();
        this.fireBlock = fireBlock;
        this.dimId = dimId;
        this.portalFrame = portalFrame;
        this.portalParticle = particle;

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { AXIS });
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess i, IBlockState i2, BlockPos p, EnumFacing f) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(AXIS)) {
        case X:
            return X_AABB;
        case Y:
        default:
            return Y_AABB;
        case Z:
            return Z_AABB;
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return null;
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return null;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return meta(state.getValue(AXIS));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public boolean makePortal(World worldIn, BlockPos p) {
        BlockModPortal.Size size = new BlockModPortal.Size(worldIn, p, EnumFacing.Axis.X);
        if (size.isValid() && size.portalBlockCount == 0) {
            size.placePortalBlocks();
            return true;
        } else {
            BlockModPortal.Size size1 = new BlockModPortal.Size(worldIn, p, EnumFacing.Axis.Z);
            if (size1.isValid() && size1.portalBlockCount == 0) {
                size1.placePortalBlocks();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        EnumFacing.Axis enumfacing$axis = state.getValue(AXIS);

        if (enumfacing$axis == EnumFacing.Axis.X) {
            BlockModPortal.Size EdenBlock$size = new BlockModPortal.Size(worldIn, pos, EnumFacing.Axis.X);

            if (!EdenBlock$size.isValid()
                    || EdenBlock$size.portalBlockCount < EdenBlock$size.width * EdenBlock$size.height) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        } else if (enumfacing$axis == EnumFacing.Axis.Z) {
            BlockModPortal.Size BlockModPortal$size1 = new BlockModPortal.Size(worldIn, pos, EnumFacing.Axis.Z);

            if (!BlockModPortal$size1.isValid() || BlockModPortal$size1.portalBlockCount < BlockModPortal$size1.width
                    * BlockModPortal$size1.height) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity) {
        if ((entity.getRidingEntity() == null) && ((entity instanceof EntityPlayerMP))) {
            EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
            thePlayer.mcServer.getWorld(thePlayer.dimension);
            int dimensionID = dimId;
            if (thePlayer.timeUntilPortal > 0) {
                thePlayer.timeUntilPortal = 40;
            } else if (thePlayer.dimension != dimensionID) {
                thePlayer.timeUntilPortal = 40;
                thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, dimensionID,
                        new DivineTeleporter(thePlayer.mcServer.getWorld(dimensionID), this,
                                portalFrame.getDefaultState()));
            } else {
                thePlayer.timeUntilPortal = 40;
                thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, 0,
                        new DivineTeleporter(thePlayer.mcServer.getWorld(0), this, portalFrame.getDefaultState()));
            }
        }
    }

    @Override
    public int quantityDropped(Random p_149745_1_) {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(100) == 0) {
            worldIn.playSound(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT,
                    SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double d0 = pos.getX() + rand.nextFloat();
            double d1 = pos.getY() + rand.nextFloat();
            double d2 = pos.getZ() + rand.nextFloat();
            double d3 = (rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = (rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = (rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;
            if (worldIn.getBlockState(pos.west()).getBlock() != this
                    && worldIn.getBlockState(pos.east()).getBlock() != this) {
                d0 = pos.getX() + 0.5D + 0.25D * j;
                d3 = rand.nextFloat() * 2.0F * j;
            } else {
                d2 = pos.getZ() + 0.5D + 0.25D * j;
                d5 = rand.nextFloat() * 2.0F * j;
            }

            DivineRPG.proxy.spawnParticle(worldIn, portalParticle, d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
            EnumFacing side) {
        pos = pos.offset(side);
        EnumFacing.Axis enumfacing$axis = null;

        if (blockState.getBlock() == this) {
            enumfacing$axis = blockState.getValue(AXIS);
            if (enumfacing$axis == null) {
                return false;
            }
            if (enumfacing$axis == EnumFacing.Axis.Z && side != EnumFacing.EAST && side != EnumFacing.WEST) {
                return false;
            }
            if (enumfacing$axis == EnumFacing.Axis.X && side != EnumFacing.SOUTH && side != EnumFacing.NORTH) {
                return false;
            }
        }

        boolean flag = blockAccess.getBlockState(pos.west()).getBlock() == this
                && blockAccess.getBlockState(pos.west(2)).getBlock() != this;
        boolean flag1 = blockAccess.getBlockState(pos.east()).getBlock() == this
                && blockAccess.getBlockState(pos.east(2)).getBlock() != this;
        boolean flag2 = blockAccess.getBlockState(pos.north()).getBlock() == this
                && blockAccess.getBlockState(pos.north(2)).getBlock() != this;
        boolean flag3 = blockAccess.getBlockState(pos.south()).getBlock() == this
                && blockAccess.getBlockState(pos.south(2)).getBlock() != this;
        boolean flag4 = flag || flag1 || enumfacing$axis == EnumFacing.Axis.X;
        boolean flag5 = flag2 || flag3 || enumfacing$axis == EnumFacing.Axis.Z;

        if (flag4 && side == EnumFacing.WEST) {
            return true;
        } else if (flag4 && side == EnumFacing.EAST) {
            return true;
        } else if (flag5 && side == EnumFacing.NORTH) {
            return true;
        } else {
            return flag5 && side == EnumFacing.SOUTH;
        }
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        switch (rot) {
        case COUNTERCLOCKWISE_90:
        case CLOCKWISE_90:

            switch (state.getValue(AXIS)) {
            case X:
                return state.withProperty(AXIS, EnumFacing.Axis.Z);
            case Z:
                return state.withProperty(AXIS, EnumFacing.Axis.X);
            default:
                return state;
            }
        default:
            return state;
        }
    }

    public class Size {
        private final World world;
        private final EnumFacing.Axis axis;
        private final EnumFacing rightDir;
        private final EnumFacing leftDir;
        private int portalBlockCount;
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(World worldIn, BlockPos pos, EnumFacing.Axis axis) {
            this.world = worldIn;
            this.axis = axis;

            if (axis == EnumFacing.Axis.X) {
                this.leftDir = EnumFacing.EAST;
                this.rightDir = EnumFacing.WEST;
            } else {
                this.leftDir = EnumFacing.NORTH;
                this.rightDir = EnumFacing.SOUTH;
            }

            for (BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0
                    && this.isEmptyBlock(worldIn.getBlockState(pos.down()).getBlock()); pos = pos.down()) {
                ;
            }

            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;

            if (i >= 0) {
                this.bottomLeft = pos.offset(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);

                if (this.width < 2 || this.width > 21) {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if (this.bottomLeft != null) {
                this.height = this.calculatePortalHeight();
            }
        }

        protected int calculatePortalHeight() {
            label56:

            for (this.height = 0; this.height < 21; ++this.height) {
                for (int i = 0; i < this.width; ++i) {
                    BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
                    Block block = this.world.getBlockState(blockpos).getBlock();

                    if (!this.isEmptyBlock(block)) {
                        break label56;
                    }

                    if (block == portalBlock) {
                        ++this.portalBlockCount;
                    }

                    if (i == 0) {
                        block = this.world.getBlockState(blockpos.offset(this.leftDir)).getBlock();

                        if (block != portalFrame) {
                            break label56;
                        }
                    } else if (i == this.width - 1) {
                        block = this.world.getBlockState(blockpos.offset(this.rightDir)).getBlock();

                        if (block != portalFrame) {
                            break label56;
                        }
                    }
                }
            }

            for (int j = 0; j < this.width; ++j) {
                if (this.world.getBlockState(this.bottomLeft.offset(this.rightDir, j).up(this.height))
                        .getBlock() != portalFrame) {
                    this.height = 0;
                    break;
                }
            }

            if (this.height <= 21 && this.height >= 3) {
                return this.height;
            } else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        protected int getDistanceUntilEdge(BlockPos pos, EnumFacing facing) {
            int i;

            for (i = 0; i < 22; ++i) {
                BlockPos blockpos = pos.offset(facing, i);

                if (!this.isEmptyBlock(this.world.getBlockState(blockpos).getBlock())
                        || this.world.getBlockState(blockpos.down()).getBlock() != portalFrame) {
                    break;
                }
            }

            Block block = this.world.getBlockState(pos.offset(facing, i)).getBlock();
            return block == portalFrame ? i : 0;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        protected boolean isEmptyBlock(Block blockIn) {
            return blockIn.getMaterial(blockIn.getDefaultState()) == Material.AIR || blockIn == fireBlock
                    || blockIn == portalBlock;
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3
                    && this.height <= 21;
        }

        public void placePortalBlocks() {
            for (int i = 0; i < this.width; ++i) {
                BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i);
                if (Config.debug) {
                    DivineRPG.logger.info("attempting to ignight a portal");
                }
                for (int j = 0; j < this.height; ++j) {
                    this.world.setBlockState(blockpos.up(j),
                            portalBlock.getDefaultState().withProperty(BlockModPortal.AXIS, this.axis), 2);
                }
            }
        }
    }
}