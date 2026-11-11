package dev.donut.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public class DonutClient implements ClientModInitializer {

    public static final String NAME = "DonutSMP Client";

    @Override
    public void onInitializeClient() {
        KeyMapping key = new KeyMapping(
            "key.donutclient.gui",
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            KeyMapping.Category.MISC
        );

        KeyMappingHelper.registerKeyMapping(key);

        net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (key.consumeClick()) {
                client.setScreen(new dev.donut.client.gui.ClickGui());
            }
        });
    }
}
