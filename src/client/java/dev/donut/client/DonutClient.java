package dev.donut.client;
import dev.donut.client.gui.ClickGui;
import dev.donut.client.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class DonutClient implements ClientModInitializer {
    @Override public void onInitializeClient(){
        KeyMapping key=KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.perfplus.gui", GLFW.GLFW_KEY_RIGHT_SHIFT, KeyMapping.Category.MISC));
        ClientTickEvents.END_CLIENT_TICK.register(mc->{
            ModuleManager.tick(mc);
            while(key.consumeClick()) if(mc.screen==null) mc.setScreen(new ClickGui());
        });
    }
}
