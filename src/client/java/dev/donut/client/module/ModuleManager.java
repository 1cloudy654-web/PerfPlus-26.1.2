package dev.donut.client.module;
import java.util.List;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
public final class ModuleManager {
    public static final class AutoSprint extends Module {
        public AutoSprint(){ super("AutoSprint", Category.MOVEMENT); }
    }
    public static final class FpsHud extends Module {
        public FpsHud(){ super("FPS HUD", Category.RENDER); }
    }
    private static final List<Module> MODULES = List.of(new AutoSprint(), new FpsHud());
    private ModuleManager(){}
    public static List<Module> all(){ return MODULES; }
    public static List<Module> byCategory(Category c){
        List<Module> result=new ArrayList<>();
        for(Module m:MODULES) if(m.getCategory()==c) result.add(m);
        return result;
    }
    public static void tick(Minecraft mc){
        if(mc.player==null) return;
        for(Module m:MODULES) if(m.isEnabled() && m instanceof AutoSprint)
            if(mc.player.input.forwardImpulse>0 && !mc.player.isShiftKeyDown() && !mc.player.isUsingItem())
                mc.player.setSprinting(true);
    }
}
