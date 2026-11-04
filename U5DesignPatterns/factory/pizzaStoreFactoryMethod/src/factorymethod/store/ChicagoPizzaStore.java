package factorymethod.store;

import factorymethod.pizza.ChicagoStyleCheesePizza;
import factorymethod.pizza.ChicagoStyleClamPizza;
import factorymethod.pizza.ChicagoStylePepperoniPizza;
import factorymethod.pizza.ChicagoStyleVeggiePizza;
import factorymethod.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("veggie")) {
        	    	return new ChicagoStyleVeggiePizza();
        	} else if (item.equals("clam")) {
        	    	return new ChicagoStyleClamPizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}
