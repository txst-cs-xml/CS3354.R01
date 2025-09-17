package characters;
import skills.Flyable;
import skills.Swimmable;
import skills.Teleportable;

// Superhero Class
public class Superhero extends GameCharacter implements Flyable, Swimmable, Teleportable {
    private String superPower;

    public Superhero(String name, int level, int health, String superPower) {
        super(name, level, health);
        this.superPower = superPower;
    }

    public void saveTheDay() {
        System.out.println(getName() + " is saving the day with " + superPower + "!");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is soaring through the sky!");
    }

    @Override
    public void land() {
        System.out.println(getName() + " has landed safely.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming at incredible speed!");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getName() + " has stopped swimming.");
    }

    @Override
    public void teleport(int x, int y) {
        System.out.println(getName() + " has teleported to (" + x + ", " + y + ").");
    }
}