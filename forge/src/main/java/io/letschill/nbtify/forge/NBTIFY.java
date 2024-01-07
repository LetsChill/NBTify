package io.letschill.nbtify.forge;

import io.letschill.nbtify.forge.events.ClientEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(io.letschill.nbtify.NBTIFY.MOD_ID)
public class NBTIFY {
    public NBTIFY() {
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        io.letschill.nbtify.NBTIFY.init();
    }
}