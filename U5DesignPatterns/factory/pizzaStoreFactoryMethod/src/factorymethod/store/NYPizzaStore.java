package factorymethod.store;

import factorymethod.pizza.NYStyleCheesePizza;
import factorymethod.pizza.NYStyleClamPizza;
import factorymethod.pizza.NYStylePepperoniPizza;
import factorymethod.pizza.NYStyleVeggiePizza;
import factorymethod.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}
}
