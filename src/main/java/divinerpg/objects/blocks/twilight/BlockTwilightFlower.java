package divinerpg.objects.blocks.twilight;

import divinerpg.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockTwilightFlower extends BlockBush implements IPlantable {
    private Block grass;
    private AxisAlignedBB size;

    public BlockTwilightFlower(String name, Block grass) {
        this(name, grass, 0.4, 1);
    }

    /**
     * @param width  - sets the width of flower. Can't be lass/equals zero
     * @param height - sets the height of flower. Can't be less/equals zero
     */
    public BlockTwilightFlower(String name, Block grass, double width, double height) {
        setRegistryName(Reference.MODID, name);
        setUnlocalizedName(name);
        this.grass = grass;
        setCreativeTab(DivineRPGTabs.BlocksTab);
        setSoundType(SoundType.PLANT);
        this.setTickRandomly(true);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Width or height cannot be less/equals zero!");
        }

        // This is bounding box, 1*1 size
        // Center point (A) is 0.5;0.5
        // We need to find L's and R's points, that's a
        // rectangle with given size
        //////////////////////////
        //  L1----width----R1   //
        //  h                   //
        //  e                   //
        //  i      A            //
        //  g                   //
        //  h                   //
        //  t                   //
        //  L2             R2   //
        //////////////////////////

        double leftCorner = Double.max(0, 0.5 - width / 2);
        double rightCorner = 0.5 + width / 2;

        size = new AxisAlignedBB(leftCorner,
                0,
                leftCorner,
                rightCorner,
                height,
                rightCorner);
    }

    @Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this)
            return getDefaultState();
        return state;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && soil.getBlock() == grass;
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == grass;
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        return this.canSustainBush(worldIn.getBlockState(pos.down()));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return size;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Plains;
    }
}