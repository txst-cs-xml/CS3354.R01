import Ducks.Duck;
import Ducks.MallardDuck;
import Ducks.ModelDuck;
import Ducks.RubberDuck;
import FlyBehaviors.FlyRocketPowered;

public class MiniDuckSimulator1 {
 
	public static void main(String[] args) {
 
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
   
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

		Duck rubber_duck = new RubberDuck();
		rubber_duck.performFly();
		rubber_duck.performQuack();

		

	}
}
