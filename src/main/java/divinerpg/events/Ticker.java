package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.capabilities.ArcanaProvider;
import divinerpg.capabilities.IArcana;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class Ticker {

    public static int tick;

    @SubscribeEvent
    public void tickServer(ServerTickEvent evt) {
        if (evt.phase == Phase.END) {
            tick++;
            if (tick > 100000)
                tick = 0;
        }
    }
}