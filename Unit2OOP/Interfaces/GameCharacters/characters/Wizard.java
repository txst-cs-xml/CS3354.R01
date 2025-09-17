package characters;
import skills.Flyable;
import skills.Teleportable;

// Wizard Class
public class Wizard extends GameCharacter implements Flyable, Teleportable {
    private int mana;

    public Wizard(String name, int level, int health, int mana) {
        super(name, level, health);
        this.mana = mana;
    }

    public void castSpell() {
        System.out.println(getName() + " is casting a spell!");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying on a broomstick!");
    }

    @Override
    public void land() {
        System.out.println(getName() + " has landed gracefully.");
    }

    @Override
    public void teleport(int x, int y) {
        System.out.println(getName() + " has teleported to (" + x + ", " + y + ").");
    }

}