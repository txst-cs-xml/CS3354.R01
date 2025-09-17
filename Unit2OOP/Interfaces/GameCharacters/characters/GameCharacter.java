package characters;
// GameCharacter Class
public class GameCharacter {
    private String name;
    private int level;
    private int health;
    
    public GameCharacter(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public void attack() {
        System.out.println(name + " is attacking!");
    }

    public void defend() {
        System.out.println(name + " is defending!");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // additional settersand getters for level and health fields
}


