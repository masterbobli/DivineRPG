package divinerpg.objects.blocks.tile.entity;

import com.google.common.collect.Lists;
import divinerpg.objects.blocks.tile.entity.base.ModUpdatableTileEntity;
import divinerpg.objects.entities.entity.vanilla.ayeraco.*;
import divinerpg.registry.ModBlocks;
import divinerpg.utils.MessageLocalizer;
import divinerpg.utils.log.Logging;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;

public class TileEntityAyeracoSpawn extends ModUpdatableTileEntity implements ITickable {
    private BlockPos greenBeam;
    private BlockPos blueBeam;
    private BlockPos redBeam;
    private BlockPos yellowBeam;
    private BlockPos purpleBeam;

    /**
     * Using in render, so it need to be proceed through update package
     */
    public int spawnTick;

    public TileEntityAyeracoSpawn() {
        this.spawnTick = 600;
    }

    @Override
    public void update() {
        switch (spawnTick) {
            case 600:
                greenBeam = getBeamLocation(8, 8);
                blueBeam = getBeamLocation(15, 0);
                redBeam = getBeamLocation(5, -12);
                yellowBeam = getBeamLocation(-5, -12);
                purpleBeam = getBeamLocation(-8, 8);
                setBlock(greenBeam, ModBlocks.ayeracoBeamGreen);
                logAyeracoSpawn(TextFormatting.GREEN);
                break;

            case 430:
                setBlock(blueBeam, ModBlocks.ayeracoBeamBlue);
                logAyeracoSpawn(TextFormatting.BLUE);
                break;

            case 300:
                setBlock(redBeam, ModBlocks.ayeracoBeamRed);
                logAyeracoSpawn(TextFormatting.RED);
                break;

            case 210:
                setBlock(yellowBeam, ModBlocks.ayeracoBeamYellow);
                logAyeracoSpawn(TextFormatting.YELLOW);
                break;

            case 145:
                setBlock(purpleBeam, ModBlocks.ayeracoBeamPurple);
                logAyeracoSpawn(TextFormatting.DARK_PURPLE, "purple");
                break;

            case 0:
                // Spawn entities only on server
                if (!world.isRemote) {
                    // Order is important!
                    ArrayList<Ayeraco> ayeracos = Lists.newArrayList(
                            new AyeracoRed(this.world, redBeam),
                            new AyeracoGreen(this.world, greenBeam),
                            new AyeracoBlue(this.world, blueBeam),
                            new AyeracoYellow(this.world, yellowBeam),
                            new AyeracoPurple(this.world, purpleBeam));

                    AyeracoGroup ayeracoGroup = new AyeracoGroup(ayeracos);

                    ayeracos.forEach(x -> x.initGroup(ayeracoGroup));
                    ayeracos.forEach(x -> world.spawnEntity(x));
                }

                setBlock(this.pos, Blocks.AIR);
                logAyeracoSpawn(TextFormatting.AQUA, "spawn");
                break;
        }

        spawnTick--;
    }

    private BlockPos getBeamLocation(int x, int z) {
        BlockPos beamCoords = this.pos.add(x, 0, z);
        if (this.world.getBlockState(beamCoords) == Blocks.AIR.getDefaultState()) {
            while (beamCoords.getY() > 0
                    && this.world.getBlockState(beamCoords.down()) == Blocks.AIR.getDefaultState()) {
                beamCoords = beamCoords.down();
            }
        } else {
            while (beamCoords.getY() < 200 && this.world.getBlockState(beamCoords) != Blocks.AIR.getDefaultState()) {
                beamCoords = beamCoords.up();
            }
        }
        return beamCoords;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.spawnTick = tag.getInteger("spawnTick");

        greenBeam = BlockPos.fromLong(tag.getLong("greenBeam"));
        blueBeam = BlockPos.fromLong(tag.getLong("blueBeam"));
        redBeam = BlockPos.fromLong(tag.getLong("redBeam"));
        yellowBeam = BlockPos.fromLong(tag.getLong("yellowBeam"));
        purpleBeam = BlockPos.fromLong(tag.getLong("purpleBeam"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("spawnTick", this.spawnTick);

        if (greenBeam != null) {
            tag.setLong("greenBeam", greenBeam.toLong());
        }

        if (blueBeam != null) {
            tag.setLong("blueBeam", blueBeam.toLong());
        }

        if (redBeam != null) {
            tag.setLong("redBeam", redBeam.toLong());
        }

        if (yellowBeam != null) {
            tag.setLong("yellowBeam", yellowBeam.toLong());
        }

        if (purpleBeam != null) {
            tag.setLong("purpleBeam", purpleBeam.toLong());
        }

        return tag;
    }

    /**
     * Prevent from double logging on client
     * @param formatting - format of message
     */
    private void logAyeracoSpawn(TextFormatting formatting){
        logAyeracoSpawn(formatting, null);
    }

    /**
     * Log ayeraco spawn, prevent from double client logging
     * @param formatting - message format
     * @param name - special name
     */
    private void logAyeracoSpawn(TextFormatting formatting, String name){
        if (world.isRemote)
            return;

        if (name == null){
            name = formatting.name().toLowerCase();
        }

        // Here creating the key like "message.ayeraco.blue"
        Logging.broadcast(MessageLocalizer.normal("message.ayeraco." + name, formatting));
    }

    private void setBlock(BlockPos pos, Block block) {
        this.world.setBlockState(pos, block.getDefaultState());
    }
}