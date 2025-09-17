package characters;
import skills.Swimmable;

// Mermaid Class
public class Mermaid extends GameCharacter implements Swimmable {
    private double finLength;

    public Mermaid(String name, int level, int health, double finLength) {
        super(name, level, health);
        this.finLength = finLength;
    }

    public void sing() {
        System.out.println(getName() + " is singing a mesmerizing melody!");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming gracefully!");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getName() + " has stopped swimming.");
    }

}