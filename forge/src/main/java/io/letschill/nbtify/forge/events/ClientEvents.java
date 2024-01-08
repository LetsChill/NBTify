package io.letschill.nbtify.forge.events;

import io.letschill.nbtify.utils.TooltipModifier;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEvents {

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
        TooltipModifier.getTooltip(event.getItemStack(), event.getFlags(), event.getToolTip());
    }
}
