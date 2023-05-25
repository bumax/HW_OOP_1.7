package model.base;

/***
 * Базовый класс персонажа
 */
public abstract class Character {
    public Character(String name) {
        this.name = name;
        level = 0;
        healthPoints = 100;
        maxHP = 100;
        manaPoints = 100;
        maxMana = 100;
        experience = 0;
        maxXP = levelUp[level];
    }

    public int getLevel() {
        return level;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = increaseVal(this.healthPoints, healthPoints, maxHP);
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = increaseVal(this.manaPoints, manaPoints, maxMana);;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = increaseVal(this.experience, experience, maxXP);;
    }

    public int getMaxXP() {
        return maxXP;
    }

    public String getName() {
        return name;
    }

    private String name;
    private int level;
    private int armor;
    private int healthPoints;
    private int maxHP;
    private int manaPoints;
    private int maxMana;
    private int experience;
    private int maxXP;

    public int setDamage(int damage){
        int damageMultiplier =  damage / (damage + armor);
        damage *= damageMultiplier;
        if(damage >= healthPoints)
            healthPoints = 0;
        else
            healthPoints -= damage;
        return healthPoints;
    }

    /**
     * Массив с необходимым XP для перехода на следующий уровень
     */
    private static final int[] levelUp = {5,10,50,100,500,1000,5000,10000};

    /**
     * Обновляяем левел персонажа
      */
    public void updateLevel(){
        // проверяем уровень персонажа
        if(this.level < 8 && this.experience >= maxXP){
            // если очки XP чуть больше, чем требуется дл перехода, то переносим остатки на следующий уровень
            this.experience = this.experience - maxXP;
            // апаем левел
            this.level++;
            maxXP = this.levelUp[this.level];
            maxHP += 10;
            maxMana += 10;
        }

    }
    private int increaseVal(int val, int inc, int limit){
        if(inc > 0)
            val += inc;
        if(val > limit)
            val = limit;
        return val;
    }
}
