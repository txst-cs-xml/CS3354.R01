package abstractfactory.factory;

import abstractfactory.ingredients.Cheese;
import abstractfactory.ingredients.Clams;
import abstractfactory.ingredients.Dough;
import abstractfactory.ingredients.FreshClams;
import abstractfactory.ingredients.Garlic;
import abstractfactory.ingredients.MarinaraSauce;
import abstractfactory.ingredients.Mushroom;
import abstractfactory.ingredients.Onion;
import abstractfactory.ingredients.Pepperoni;
import abstractfactory.ingredients.RedPepper;
import abstractfactory.ingredients.ReggianoCheese;
import abstractfactory.ingredients.Sauce;
import abstractfactory.ingredients.SlicedPepperoni;
import abstractfactory.ingredients.ThinCrustDough;
import abstractfactory.ingredients.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
