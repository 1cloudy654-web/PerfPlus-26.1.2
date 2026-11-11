package dev.donut.client.module;
public final class Setting {
    private final String name;
    private final double min, max, step;
    private double value;
    public Setting(String name, double value, double min, double max, double step) {
        this.name=name; this.min=min; this.max=max; this.step=step; this.value=value;
    }
    public String getName(){ return name; }
    public double get(){ return value; }
    public void set(double v){ value=Math.max(min, Math.min(max,v)); }
    public void inc(){ set(value+step); }
    public void dec(){ set(value-step); }
    public String display(){ return String.valueOf(Math.round(value*100.0)/100.0); }
}
