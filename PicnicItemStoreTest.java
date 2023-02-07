import java.io.IOException;

public class PicnicItemStoreTest extends PicnicItemStore {
	public static void main (String[] args) throws IOException {
		PicnicItemStore store = new PicnicItemStore();
		store.put("a", "abiu");
		store.put("bl", "blackberry");
		store.put("bl", "blackcurrent");
		store.put("a", "apricot");
		System.out.println(store.getRandomItem("a"));
    System.out.println("\n");

		PicnicItemStore store2 = new PicnicItemStore("fruits.txt");
		System.out.println(store2.getRandomItem("A"));
    System.out.println("\n");

		CheeseStore store3 = new CheeseStore("cheeses.txt");
		System.out.println(store3.getRandomItem("B"));
    System.out.println("\n");

		DrinkStore store4 = new DrinkStore("drinks.txt");
		System.out.println(store4.getRandomItem("C"));
    System.out.println("\n");

    PicnicPlanner picnic = new PicnicPlanner(2);
    picnic.generate("dominique",2);
    System.out.println("\n");

  	PicnicPlanner picnic1 = new PicnicPlanner(3);
    picnic1.generate("dominique",3);
    System.out.println("\n");

    PicnicPlanner picnicPrefixLengthSame = new PicnicPlanner(9);
    picnicPrefixLengthSame.generate("dominique",9);
    System.out.println("\n");

    PicnicPlanner picnicPrefixLengthMore = new PicnicPlanner(11);
    picnicPrefixLengthMore.generate("dominique",11);
    System.out.println("\n");

    PicnicPlanner picnicStrategicName = new PicnicPlanner(3);
    picnicStrategicName.generate("abagail",3);

	}
}
