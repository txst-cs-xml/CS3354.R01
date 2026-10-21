// AFTER: Duck has behavior objects that can be replaced independently.
public class DuckCompositionAfter {
    interface FlyBehavior {
        void fly();
    }

    interface QuackBehavior {
        void quack();
    }

    static class FlyWithWings implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("Flying with wings");
        }
    }

    static class FlyNoWay implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("Cannot fly");
        }
    }

    static class FlyRocketPowered implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("Flying with a rocket");
        }
    }

    static class Quack implements QuackBehavior {
        @Override
        public void quack() {
            System.out.println("Quack");
        }
    }

    static class Squeak implements QuackBehavior {
        @Override
        public void quack() {
            System.out.println("Squeak");
        }
    }

    static class Duck {
        private FlyBehavior flyBehavior;
        private final QuackBehavior quackBehavior;

        Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
            this.flyBehavior = flyBehavior;
            this.quackBehavior = quackBehavior;
        }

        void swim() {
            System.out.println("Swimming");
        }

        void performFly() {
            flyBehavior.fly();
        }

        void performQuack() {
            quackBehavior.quack();
        }

        void setFlyBehavior(FlyBehavior flyBehavior) {
            this.flyBehavior = flyBehavior;
        }
    }

    public static void main(String[] args) {
        Duck mallard = new Duck(new FlyWithWings(), new Quack());
        Duck rubberDuck = new Duck(new FlyNoWay(), new Squeak());

        mallard.performFly();
        rubberDuck.performQuack();
        rubberDuck.performFly();

        // Composition lets this object's behavior change while the program runs.
        rubberDuck.setFlyBehavior(new FlyRocketPowered());
        rubberDuck.performFly();
    }
}
