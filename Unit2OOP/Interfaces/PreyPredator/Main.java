import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		
		Fish fish = new Fish();
		
		fish.hunt();
		fish.flee();

        Rabbit rabbit = new Rabbit();
        rabbit.flee();
        //rabbit.hunt();

        Hawk hawk = new Hawk();
        hawk.hunt();
        //hawk.flee();
        ArrayList<Predator> hunters = new ArrayList<Predator>();
        hunters.add(fish);
        hunters.add(hawk);
        huntingMood(hunters);

	}
    public static void huntingMood(ArrayList<Predator> objects) {
        for(Predator obj:objects) {
            obj.hunt();
        }
    }
}