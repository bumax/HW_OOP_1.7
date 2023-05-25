package model.base;

public abstract class Weapon {
    public Weapon(int damage, int minLevel) {
        this.damage = damage;
        this.minLevel = minLevel;
    }
    public int getDamage() {
        return damage;
    }
    public int getMinLevel() {
        return minLevel;
    }
    private int damage;
    private int minLevel;
}
