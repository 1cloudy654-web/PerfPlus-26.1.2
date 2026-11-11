package dev.donut.client.module;

public class ModuleManager {

    public static boolean sprint = false;
    public static boolean fullBright = false;
    public static boolean coordinates = true;
    public static boolean fpsCounter = true;
    public static boolean armorHud = true;
    public static boolean potionHud = true;
    public static boolean particles = true;

    public static void toggleSprint() {
        sprint = !sprint;
    }

    public static void toggleFullBright() {
        fullBright = !fullBright;
    }

    public static void toggleCoordinates() {
        coordinates = !coordinates;
    }

    public static void toggleFpsCounter() {
        fpsCounter = !fpsCounter;
    }
}
