package divinerpg.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CapabilityArcana implements IStorage<IArcana> {
    private static final String arcana = "arcana";
    private static final String regenDelay = "regenDelay";

    @Override
    public NBTBase writeNBT(Capability<IArcana> capability, IArcana instance, EnumFacing side) {
        NBTTagCompound result = new NBTTagCompound();

        result.setFloat(arcana, instance.getArcana());
        result.setFloat(regenDelay, instance.getRegenDelay());

        return result;
    }

    @Override
    public void readNBT(Capability<IArcana> capability, IArcana instance, EnumFacing side, NBTBase nbt) {
        // Compatibility for previous versions
        if (nbt.getTagTypeName(nbt.getId()).equals("TAG_Compound")) {
            NBTTagCompound saved = (NBTTagCompound) nbt;

            instance.set(saved.getFloat(arcana));
            instance.setRegenDelay(saved.getInteger(regenDelay));
        }
    }
}