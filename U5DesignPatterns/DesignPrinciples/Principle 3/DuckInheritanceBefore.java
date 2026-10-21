// BEFORE: behavior is fixed through inheritance.
public class DuckInheritanceBefore {
    static class Duck {
        void swim() {
            System.out.println("Swimming");
        }

        void quack() {
            System.out.println("Quack");
        }

        void fly() {
            System.out.println("Flying with wings");
        }
    }

    static class MallardDuck extends Duck {
        // Inherits all three behaviors.
    }

    static class RubberDuck extends Duck {
        @Override
        void quack() {
            System.out.println("Squeak");
        }

        @Override
        void fly() {
            // RubberDuck inherits fly(), even though normal rubber ducks cannot fly.
            System.out.println("Cannot fly");
        }
    }

    static class RocketDuck extends Duck {
        @Override
        void fly() {
            System.out.println("Flying with a rocket");
        }
    }

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck rubberDuck = new RubberDuck();
        Duck rocketDuck = new RocketDuck();

        mallard.fly();
        rubberDuck.quack();
        rubberDuck.fly();
        rocketDuck.fly();
    }
}
