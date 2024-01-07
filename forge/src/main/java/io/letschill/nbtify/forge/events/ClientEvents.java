package io.letschill.nbtify.forge.events;

import com.mojang.blaze3d.platform.InputConstants;
import io.letschill.nbtify.screen.NBTScreen;
import io.letschill.nbtify.utils.ToolTipUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class ClientEvents {

    private boolean flag = false;

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
        if (event.getFlags().isAdvanced()) return;

        if (event.getItemStack().getTag() == null) return;

        if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 258)) {
            event.getToolTip().add(Component.empty());
            ToolTipUtils.getGuide(event.getToolTip());

            String string = ToolTipUtils.format(event.getItemStack());

            Minecraft.getInstance().setScreen(new NBTScreen(Minecraft.getInstance().screen, string));
            return;
        }

        if (Screen.hasAltDown()) {
            event.getToolTip().remove(event.getToolTip().size() - 1);

            String string = ToolTipUtils.Colorize(Objects.requireNonNull(ToolTipUtils.format(event.getItemStack())));

            for (String line: string.lines().toList()) {
                event.getToolTip().add(Component.literal(line));
            }
            return;
        }

        if (Screen.hasControlDown()) {
            if (!flag) {
                String data = ToolTipUtils.format(event.getItemStack());

                if (data == null) return;

                Minecraft.getInstance().keyboardHandler.setClipboard(data);

                SystemToast.add(
                        Minecraft.getInstance().getToasts(),
                        SystemToast.SystemToastIds.TUTORIAL_HINT,
                        Component.literal("NBTify"),
                        Component.literal("Your NBT data has been copied!")
                );

                event.getToolTip().add(Component.empty());
                ToolTipUtils.getGuide(event.getToolTip());

                flag = true;
                return;
            }
            event.getToolTip().add(Component.empty());
            ToolTipUtils.getGuide(event.getToolTip());
            return;
        }

        flag = false;

        event.getToolTip().add(Component.empty());
        ToolTipUtils.getGuide(event.getToolTip());
    }
}
