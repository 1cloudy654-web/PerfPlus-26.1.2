
package dev.donut.client.gui;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

public class ClickGui extends Screen {
    public ClickGui() {
        super(Component.literal("DonutSMP Client"));
    }

    @Override
    public void extractRenderState(
        GuiGraphicsExtractor graphics,
        int mouseX,
        int mouseY,
        float delta
    ) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);

        graphics.fill(0, 0, width, height, 0x99000000);
        graphics.fill(100, 60, 420, 310, 0xFF171420);
        graphics.fill(100, 60, 420, 100, 0xFF852BFF);

        graphics.centeredText(font, "DONUTSMP CLIENT", 260, 75, 0xFFFFFFFF);
        graphics.text(font, "COMBAT", 120, 120, 0xFFB987FF);
        graphics.text(font, "MOVEMENT", 120, 150, 0xFFB987FF);
        graphics.text(font, "RENDER", 120, 180, 0xFFB987FF);
        graphics.text(font, "PLAYER", 120, 210, 0xFFB987FF);
        graphics.text(font, "HUD", 120, 240, 0xFFB987FF);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
