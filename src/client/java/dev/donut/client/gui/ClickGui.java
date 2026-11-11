package dev.donut.client.gui;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphicsExtractor;

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

        // Background
        graphics.fill(0, 0, this.width, this.height, 0x99000000);

        // Main panel
        graphics.fill(100, 60, 420, 310, 0xFF171420);

        // Purple header
        graphics.fill(100, 60, 420, 100, 0xFF852BFF);

        graphics.drawCenteredString(
            this.font,
            "DONUTSMP CLIENT",
            260,
            75,
            0xFFFFFFFF
        );

        // Categories
        graphics.drawString(this.font, "COMBAT", 120, 120, 0xFFB987FF);
        graphics.drawString(this.font, "MOVEMENT", 120, 150, 0xFFB987FF);
        graphics.drawString(this.font, "RENDER", 120, 180, 0xFFB987FF);
        graphics.drawString(this.font, "PLAYER", 120, 210, 0xFFB987FF);
        graphics.drawString(this.font, "HUD", 120, 240, 0xFFB987FF);

        graphics.drawString(this.font, "Right Shift - Close", 120, 280, 0xFFFFFFFF);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
