package dev.donut.client;

import dev.donut.client.gui.ClickGui;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class DonutClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        KeyMapping key = KeyMappingHelper.registerKeyMapping(
            new KeyMapping(
                "key.donutclient.gui",
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                KeyMapping.Category.MISC
            )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (key.consumeClick()) {
                Minecraft.getInstance().setScreen(new ClickGui());
            }
        });
    }
}
