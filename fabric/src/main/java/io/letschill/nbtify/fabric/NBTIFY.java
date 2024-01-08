package io.letschill.nbtify.fabric;

import io.letschill.nbtify.utils.TooltipModifier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class NBTIFY implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        io.letschill.nbtify.NBTIFY.init();

        ItemTooltipCallback.EVENT.register(TooltipModifier::getTooltip);
    }
}