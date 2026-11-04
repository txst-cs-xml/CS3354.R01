package abstractfactory.factory;

import abstractfactory.ingredients.BlackOlives;
import abstractfactory.ingredients.Cheese;
import abstractfactory.ingredients.Clams;
import abstractfactory.ingredients.Dough;
import abstractfactory.ingredients.Eggplant;
import abstractfactory.ingredients.FrozenClams;
import abstractfactory.ingredients.MozzarellaCheese;
import abstractfactory.ingredients.Pepperoni;
import abstractfactory.ingredients.PlumTomatoSauce;
import abstractfactory.ingredients.Sauce;
import abstractfactory.ingredients.SlicedPepperoni;
import abstractfactory.ingredients.Spinach;
import abstractfactory.ingredients.ThickCrustDough;
import abstractfactory.ingredients.Veggies;

public class ChicagoPizzaIngredientFactory 
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
