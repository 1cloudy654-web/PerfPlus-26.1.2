
package dev.donut.client.gui;

import dev.donut.client.module.*;
import dev.donut.client.module.Module;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;

public class ClickGui extends Screen {

    public ClickGui() {
        super(Component.literal("PerfPlus"));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void extractRenderState(
            GuiGraphicsExtractor g,
            int mouseX,
            int mouseY,
            float delta
    ) {
        super.extractRenderState(g, mouseX, mouseY, delta);

        g.fill(0, 0, width, height, 0xCC080B14);
        g.fill(18, 18, Math.min(width - 18, 520),
                Math.min(height - 18, 300), 0xEE171D2B);

        g.text(font, "PERFPLUS", 30, 29, 0xFF9B75FF);
        g.text(font, "Click a module to toggle it",
                30, 45, 0xFFB8C2D8);

        int x = 30;

        for (Category c : Category.values()) {
            int y = 68;

            g.text(font, c.name(), x, y, 0xFF8EABFF);
            y += 14;

            for (Module m : ModuleManager.byCategory(c)) {
                String status = m.isEnabled() ? "[ON] " : "[OFF] ";

                g.text(
                    font,
                    status + m.getName(),
                    x + 5,
                    y,
                    m.isEnabled() ? 0xFF78E6B0 : 0xFFD5D9E4
                );

                y += 13;
            }

            x += 120;
        }

        g.text(font, "ESC - close", 30, height - 30, 0xFF9AA5BA);
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
        if (event.button() == 0) {
            int x = 30;

            for (Category c : Category.values()) {
                int y = 82;

                for (Module m : ModuleManager.byCategory(c)) {
                    if (event.x() >= x && event.x() <= x + 110
                            && event.y() >= y - 2 && event.y() <= y + 10) {
                        m.toggle();
                        return true;
                    }

                    y += 13;
                }

                x += 120;
            }
        }

        return super.mouseClicked(event, doubleClick);
    }
}
