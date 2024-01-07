package io.letschill.nbtify.fabric;

import io.letschill.nbtify.fabric.callback.NBTCallBack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NBTIFY implements ModInitializer {

    private final Logger logger = LogManager.getLogger(io.letschill.nbtify.NBTIFY.MOD_ID);

    @Override
    public void onInitialize() {

        ItemTooltipCallback.EVENT.register(NBTCallBack::getTooltip);

        io.letschill.nbtify.NBTIFY.init();

        logger.info("Initialized");
    }
}