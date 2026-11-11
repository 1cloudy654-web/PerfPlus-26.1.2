package dev.donut.client.gui;
import dev.donut.client.module.*;
import dev.donut.client.module.Module;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ClickGui extends Screen {
    public ClickGui(){ super(Component.literal("PerfPlus")); }
    @Override public boolean isPauseScreen(){ return false; }
    @Override public void render(GuiGraphics g, int mouseX, int mouseY, float delta){
        g.fill(0,0,width,height,0xCC080B14);
        g.fill(18,18,Math.min(width-18,520),Math.min(height-18,300),0xEE171D2B);
        g.drawString(font,"PERFPLUS",30,29,0xFF9B75FF);
        g.drawString(font,"Click a module to toggle it",30,45,0xFFB8C2D8);
        int x=30, y=68;
        for(Category c:Category.values()){
            g.drawString(font,c.name(),x,y,0xFF8EABFF);
            y+=14;
            for(Module m:ModuleManager.byCategory(c)){
                g.drawString(font,(m.isEnabled()?"[ON] ":"[OFF] ")+m.getName(),x+5,y,
                    m.isEnabled()?0xFF78E6B0:0xFFD5D9E4);
                y+=13;
            }
            x+=120; y=68;
        }
        g.drawString(font,"ESC - close",30,height-30,0xFF9AA5BA);
        super.render(g,mouseX,mouseY,delta);
    }
    @Override public boolean mouseClicked(double mx,double my,int button){
        if(button==0){
            int x=30,y=82;
            for(Category c:Category.values()){
                for(Module m:ModuleManager.byCategory(c)){
                    if(mx>=x && mx<=x+110 && my>=y-2 && my<=y+10){ m.toggle(); return true; }
                    y+=13;
                }
                x+=120; y=82;
            }
        }
        return super.mouseClicked(mx,my,button);
    }
}
