public class DuckDemo {
    interface FlyBehavior {
        void fly();
    }

    static class FlyWithWings implements FlyBehavior {
        public void fly() {
            System.out.println("Flying with wings!");
        }
    }

    static class CannotFly implements FlyBehavior {
        public void fly() {
            System.out.println("I cannot fly.");
        }
    }

    static class RocketFlight implements FlyBehavior {
        public void fly() {
            System.out.println("Flying with a rocket!");
        }
    }

    static class Duck {
        private FlyBehavior flyBehavior;

        Duck(FlyBehavior flyBehavior) {
            this.flyBehavior = flyBehavior;
        }

        void swim() {
            // Shared behavior stays in Duck.
            System.out.println("Swimming on the water.");
        }

        void performFly() {
            // Variable behavior lives in a separate object.
            flyBehavior.fly();
        }

        void setFlyBehavior(FlyBehavior flyBehavior) {
            this.flyBehavior = flyBehavior;
        }
    }

    public static void main(String[] args) {
        Duck mallard = new Duck(new FlyWithWings());
        mallard.swim();
        mallard.performFly();

        Duck modelDuck = new Duck(new CannotFly());
        modelDuck.performFly();
        // The same duck can change how it flies during execution.
        modelDuck.setFlyBehavior(new RocketFlight());
        modelDuck.performFly();
    }
}
