package abstractfactory.factory;

import abstractfactory.ingredients.Cheese;
import abstractfactory.ingredients.Clams;
import abstractfactory.ingredients.Dough;
import abstractfactory.ingredients.Pepperoni;
import abstractfactory.ingredients.Sauce;
import abstractfactory.ingredients.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
